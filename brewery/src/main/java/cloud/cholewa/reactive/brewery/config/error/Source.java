package cloud.cholewa.reactive.brewery.config.error;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
class Source {

    private String pointer;
    private String parameter;

    private Map<String, Object> unknownAdditionalProperties = new HashMap<>();

    @JsonIgnore
    public Boolean hasPointerOrParameterValue() {
        return StringUtils.hasText(this.pointer) || StringUtils.hasText(parameter);
    }
}
