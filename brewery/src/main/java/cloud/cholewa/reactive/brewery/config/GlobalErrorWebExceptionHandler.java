package cloud.cholewa.reactive.brewery.config;

import cloud.cholewa.reactive.brewery.config.processors.DefaultExceptionProcessor;
import cloud.cholewa.reactive.brewery.config.processors.ExceptionProcessor;
import cloud.cholewa.reactive.brewery.config.processors.Messages;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

class GlobalErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {

    private Map<Class<? extends Exception>, ExceptionProcessor> processorMap;

    private final ExceptionProcessor defaultProcessor = new DefaultExceptionProcessor();

    public GlobalErrorWebExceptionHandler(
            final ErrorAttributes errorAttributes,
            final WebProperties.Resources resources,
            final ApplicationContext applicationContext,
            final ServerCodecConfigurer configurer) {
        super(errorAttributes, resources, applicationContext);

        this.setMessageWriters(configurer.getWriters());
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(
                RequestPredicates.all(), this::rendererErrorResponse
        );
    }

    Mono<ServerResponse> rendererErrorResponse(final ServerRequest request) {
        Messages errorResponse = fromError(getError(request));

        return ServerResponse
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(errorResponse));
    }

    private Messages fromError(final Throwable throwable) {
        return processorMap
                .getOrDefault(throwable.getClass(), defaultProcessor)
                .apply(throwable);
    }
}
