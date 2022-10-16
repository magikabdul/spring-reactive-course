package cloud.cholewa.reactive.brewery.logging;

import cloud.cholewa.reactive.brewery.config.error.ErrorId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.exception.ExceptionUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomLoggingArguments {

    public static String severity(final Severity severity) {
        return severity.toString();
    }

    public static String errorId(final ErrorId errorId) {
        return errorId.getCode();
    }

    public static String stack(final Throwable throwable) {
        return ExceptionUtils.getStackTrace(throwable);
    }
}
