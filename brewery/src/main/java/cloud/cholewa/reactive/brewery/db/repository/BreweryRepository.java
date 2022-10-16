package cloud.cholewa.reactive.brewery.db.repository;

import cloud.cholewa.reactive.brewery.db.model.BeerEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BreweryRepository extends ReactiveMongoRepository<BeerEntity, String> {
}
