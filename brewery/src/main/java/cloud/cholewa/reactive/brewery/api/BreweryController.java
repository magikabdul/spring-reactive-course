package cloud.cholewa.reactive.brewery.api;

import cloud.cholewa.reactive.brewery.api.model.BeerResponse;
import cloud.cholewa.reactive.brewery.service.BreweryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.NOT_IMPLEMENTED;

@RestController
@RequestMapping("v1/")
@RequiredArgsConstructor
class BreweryController {

    private final BreweryService breweryService;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<BeerResponse>> getBeerById(@PathVariable String id) {
        return Mono.just(ResponseEntity.status(NOT_IMPLEMENTED).build());
    }

    @GetMapping
    public Mono<ResponseEntity<BeerResponse>> getAllBeers() {
        return Mono.just(ResponseEntity.status(NOT_IMPLEMENTED).build());
    }

    @PostMapping
    public Mono<ResponseEntity<BeerResponse>> createBeer() {
        return Mono.just(ResponseEntity.status(NOT_IMPLEMENTED).build());
    }

    @PatchMapping
    public Mono<ResponseEntity<BeerResponse>> updateBeer() {
        return Mono.just(ResponseEntity.status(NOT_IMPLEMENTED).build());
    }

    @DeleteMapping
    public Mono<ResponseEntity<BeerResponse>> deleteBeer(String id) {
        return Mono.just(ResponseEntity.status(NOT_IMPLEMENTED).build());
    }
}
