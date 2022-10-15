package cloud.cholewa.reactive.introduction.db.repository;

import cloud.cholewa.reactive.introduction.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PersonRepositoryImpl implements PersonRepository {

    private final Person tom = Person.builder().id(1L).firstName("Tom").lastName("Jones").build();
    private final Person steve = Person.builder().id(2L).firstName("Steve").lastName("Brown").build();
    private final Person joan = Person.builder().id(3L).firstName("Joan").lastName("Doe").build();
    private final Person kevin = Person.builder().id(4L).firstName("Kevin").lastName("Alone").build();

    @Override
    public Mono<Person> getById(Long id) {
        return id < 4L ? Mono.just(kevin) : Mono.empty();
    }

    @Override
    public Flux<Person> findAll() {
        return Flux.just(tom, steve, joan, kevin);
    }
}
