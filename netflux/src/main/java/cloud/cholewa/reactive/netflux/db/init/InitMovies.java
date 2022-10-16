package cloud.cholewa.reactive.netflux.db.init;

import cloud.cholewa.reactive.netflux.db.repository.MovieRepository;
import cloud.cholewa.reactive.netflux.model.Movie;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
class InitMovies implements CommandLineRunner {

    private final Faker faker = new Faker();
    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll()
                .thenMany(
                        Flux.just(generateTitle(10))
                                .map(Movie::new)
                                .flatMap(movieRepository::save)
                ).subscribe();
    }

    private String[] generateTitle(int quantity) {
        List<String> titles = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            titles.add(faker.book().title());
        }

        return titles.toArray(new String[0]);
    }
}
