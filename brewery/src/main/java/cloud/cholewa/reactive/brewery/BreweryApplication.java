package cloud.cholewa.reactive.brewery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class BreweryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BreweryApplication.class, args);
    }

}
