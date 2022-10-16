package cloud.cholewa.reactive.brewery.service;

import cloud.cholewa.reactive.brewery.db.repository.BreweryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BreweryService {

    private final BreweryRepository breweryRepository;
}
