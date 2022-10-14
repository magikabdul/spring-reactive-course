package cloud.cholewa.reactive.introduction.db.repository;

import cloud.cholewa.reactive.introduction.model.Person;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

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
}
