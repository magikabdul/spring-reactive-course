package cloud.cholewa.reactive.brewery.config.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private String code;
    private String title;
    private String detail;
    private Source source;
    private String status;

    private Map<String, Object> unknownAdditionalProperties = new HashMap<>();
}
