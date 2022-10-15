package cloud.cholewa.reactive.introduction.db.repository;

import cloud.cholewa.reactive.introduction.model.Person;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class PersonRepositoryImplTest {

    private final PersonRepositoryImpl personRepository = new PersonRepositoryImpl();

    @Test
    void getPersonByIdBlock() {
        Mono<Person> personMono = personRepository.getById(1L);

        Person person = personMono.block();

        System.out.println(person.toString());
    }

    @Test
    void getPersonBySubscribe() {
        Mono<Person> personMono = personRepository.getById(1L);

        StepVerifier.create(personMono)
                .expectNextCount(1L)
                .verifyComplete();

        personMono.subscribe(person -> System.out.println(person.toString()));
    }

    @Test
    void getPersonBySubscribeNotFound() {
        Mono<Person> personMono = personRepository.getById(8L);

        StepVerifier.create(personMono)
                .expectNextCount(0)
                .expectComplete()
                .verify();

        personMono.subscribe(person -> System.out.println(person.toString()));
    }

    @Test
    void getPersonByMapFunction() {
        Mono<Person> personMono = personRepository.getById(1L);

        personMono.map(person -> {
            System.out.println(person.toString());
                    return person;
                }
        ).subscribe(person -> System.out.println(person.getFirstName()));
    }

    @Test
    void findAllBlockFirst() {
        Flux<Person> personFlux = personRepository.findAll();

        Person person = personFlux.blockFirst();

        System.out.println(person.toString());
    }

    @Test
    void findAllBySubscribe() {
        Flux<Person> personFlux = personRepository.findAll();

        StepVerifier.create(personFlux)
                        .expectNextCount(4)
                                .verifyComplete();

        personFlux.subscribe(person -> System.out.println(person.toString()));
    }

    @Test
    void findAllToListMono() {
        Flux<Person> personFlux = personRepository.findAll();

        personFlux.collectList().subscribe(people -> System.out.println(people.toString()));
    }

    @Test
    void findPersonById() {
        Flux<Person> personFlux = personRepository.findAll();

        personFlux.filter(person -> person.getId().equals(2L)).subscribe(person -> System.out.println(person.toString()));
    }

    @Test
    void findPersonByIdNotFound() {
        Flux<Person> personFlux = personRepository.findAll();

        Mono<Person> personMono = personFlux.filter(person -> person.getId().equals(8L)).next();

        personMono.subscribe(person -> System.out.println(person.toString()));
    }

    @Test
    void findPersonByIdNotFoundWithException() {
        Flux<Person> personFlux = personRepository.findAll();

        Mono<Person> personMono = personFlux.filter(person -> person.getId().equals(8L)).single();

        personMono
                .doOnError(throwable -> System.out.println("Boo"))
                .onErrorReturn(Person.builder().build())
                .subscribe(person -> System.out.println(person.toString()));
    }
}
