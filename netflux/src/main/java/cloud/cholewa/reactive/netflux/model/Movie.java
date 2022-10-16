package cloud.cholewa.reactive.netflux.model;

import com.mongodb.lang.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@Data
@NoArgsConstructor
public class Movie {
    private String id;

    @NonNull
    private String title;

    public Movie(String s) {
        title = s;
    }
}
