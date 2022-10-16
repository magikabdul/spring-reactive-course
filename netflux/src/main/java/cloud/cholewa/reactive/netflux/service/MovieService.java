package cloud.cholewa.reactive.netflux.service;

import cloud.cholewa.reactive.netflux.db.repository.MovieRepository;
import cloud.cholewa.reactive.netflux.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public Mono<Movie> findMovieById(String id) {
        return movieRepository.findById(id);
    }

    public Flux<Movie> findAllMovies() {
        return movieRepository.findAll();
    }
}
