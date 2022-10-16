package cloud.cholewa.reactive.netflux.api;

import cloud.cholewa.reactive.netflux.model.Movie;
import cloud.cholewa.reactive.netflux.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
class MovieController {

    private final MovieService movieService;

    @GetMapping("/{id}")
    public Mono<Movie> getMovieById(@PathVariable String id) {
        return movieService.findMovieById(id);
    }

    @GetMapping
    public Flux<Movie> getAllMovies() {
        return movieService.findAllMovies();
    }
}
