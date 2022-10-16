package cloud.cholewa.reactive.brewery.config.processors;

import cloud.cholewa.reactive.brewery.config.error.ErrorMessage;
import cloud.cholewa.reactive.brewery.logging.Severity;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;

import static cloud.cholewa.reactive.brewery.logging.CustomLoggingArguments.severity;
import static cloud.cholewa.reactive.brewery.logging.CustomLoggingArguments.stack;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
public class DefaultExceptionProcessor implements ExceptionProcessor {

    @Override
    public Messages apply(final Throwable throwable) {

        log.error(
                "Generic processing for exception [{}]: {}",
                throwable.getClass().getName(),
                throwable.getLocalizedMessage(),
                severity(Severity.MAJOR),
                stack(throwable)
        );
        return Messages.builder()
                .httpStatus(INTERNAL_SERVER_ERROR)
                .errors(Collections.singleton(
                        ErrorMessage.builder()
                                .status(String.valueOf(INTERNAL_SERVER_ERROR.value()))
                                .title("Unknown error occurred")
                                .detail(
                                        throwable.getLocalizedMessage() == null
                                        ? "Exception of type: " + throwable.getClass().getName()
                                                : throwable.getLocalizedMessage())
                                .build()
                ))
                .build();
    }
}
