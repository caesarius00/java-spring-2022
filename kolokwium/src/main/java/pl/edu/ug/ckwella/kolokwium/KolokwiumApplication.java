package pl.edu.ug.ckwella.kolokwium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
