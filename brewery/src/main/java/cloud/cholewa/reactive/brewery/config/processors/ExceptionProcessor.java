package cloud.cholewa.reactive.brewery.config.processors;

import javax.validation.constraints.NotNull;

@FunctionalInterface
public interface ExceptionProcessor {

    @NotNull
    Messages apply(final Throwable throwable);
}
