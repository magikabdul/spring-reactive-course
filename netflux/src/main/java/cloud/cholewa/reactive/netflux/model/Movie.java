package cloud.cholewa.reactive.netflux.model;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @MongoId
    private Long id;

    @NonNull
    private String title;

}
