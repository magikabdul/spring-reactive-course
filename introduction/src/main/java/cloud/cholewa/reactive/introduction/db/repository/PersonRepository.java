package cloud.cholewa.reactive.introduction.db.repository;

import cloud.cholewa.reactive.introduction.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository {

    Mono<Person> getById(Long id);

    Flux<Person> findAll();
}
