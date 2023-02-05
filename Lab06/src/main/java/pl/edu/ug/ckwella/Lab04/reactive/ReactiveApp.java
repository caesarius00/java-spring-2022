package pl.edu.ug.ckwella.Lab04.reactive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import pl.edu.ug.ckwella.Lab04.domain.Material;

@SpringBootApplication
public class ReactiveApp {

    Logger logger = LoggerFactory.getLogger(ReactiveApp.class);

    public static void main(String[] args) {
        SpringApplication.run(ReactiveApp.class, args);
    }

    @Bean
    ApplicationRunner runner() {
        return args -> {
            WebClient.create("http://localhost:8080/").get()
                    .uri("material")
                    .retrieve()
                    .bodyToFlux(Material.class)
                    .subscribe(data -> logger.info(data.toString()));
        };
    }
}


