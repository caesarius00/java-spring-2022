package pl.edu.ug.ckwella.kolokwium;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.edu.ug.ckwella.kolokwium.service.ScarfService;

@SpringBootApplication
public class KolokwiumApplication {

	public static void main(String[] args) {
		SpringApplication.run(KolokwiumApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ScarfService service) {
		return (args -> {

			service.learning();

		});

	}
}
