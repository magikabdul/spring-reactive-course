package cloud.cholewa.reactive.netflux.db.repository;

import cloud.cholewa.reactive.netflux.model.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, Long> {
}
