package cloud.cholewa.reactive.brewery.api;

import cloud.cholewa.reactive.brewery.service.BreweryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@WebFluxTest(BreweryController.class)
class BreweryControllerTest {

    @MockBean
    private BreweryService breweryService;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void should_return_not_implemented_when_calling_find_beer_by_id() {
        webTestClient.get()
                .uri("/v1/1")
                .exchange()
                .expectStatus().is5xxServerError();
    }

    @Test
    void should_return_not_implemented_when_calling_find_all_beers() {
        webTestClient.get()
                .uri("/v1/")
                .exchange()
                .expectStatus().is5xxServerError();
    }

    @Test
    void should_return_not_implemented_when_calling_create_beer() {
        webTestClient.post()
                .uri("/v1/")
                .exchange()
                .expectStatus().is5xxServerError();
    }

    @Test
    void should_return_not_implemented_when_calling_update_beer_by_id() {
        webTestClient.patch()
                .uri("/v1/1")
                .exchange()
                .expectStatus().is5xxServerError();
    }

    @Test
    void should_return_not_implemented_when_calling_delete_beer_by_id() {
        webTestClient.delete()
                .uri("/v1/1")
                .exchange()
                .expectStatus().is5xxServerError();
    }
}
