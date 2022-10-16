package cloud.cholewa.reactive.brewery.config;

import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;

@Configuration
public class ExceptionHandlerConfig {

    @Bean
    public GlobalErrorWebExceptionHandler globalErrorWebExceptionHandler(
            final ErrorAttributes errorAttributes,
            final WebProperties webProperties,
            final ApplicationContext applicationContext,
            final ServerCodecConfigurer configurer
            ) {
        GlobalErrorWebExceptionHandler globalErrorWebExceptionHandler = new GlobalErrorWebExceptionHandler(
                errorAttributes, webProperties.getResources(), applicationContext, configurer
        );

        return globalErrorWebExceptionHandler;
    }
}
