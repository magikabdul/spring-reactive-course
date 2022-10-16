package cloud.cholewa.reactive.brewery.config.processors;

import cloud.cholewa.reactive.brewery.config.error.ErrorMessage;
import cloud.cholewa.reactive.brewery.config.error.WarningMessage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Messages {

    private Set<ErrorMessage> errors;
    private Set<WarningMessage> warnings;

    @JsonIgnore
    private HttpStatus httpStatus;

    public Messages addWarning(final WarningMessage warningMessage) {
        if (this.warnings == null) {
            this.warnings = new HashSet<>();
        }
        this.warnings.add(warningMessage);
        return this;
    }

    public Messages addError(final ErrorMessage errorMessage) {
        if (this.errors == null) {
            this.errors = new HashSet<>();
        }
        this.errors.add(errorMessage);
        return this;
    }
}
