package pl.edu.ug.ckwella.Lab04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.edu.ug.ckwella.Lab04.domain.LiturgicalVestment;
import pl.edu.ug.ckwella.Lab04.service.LiturgicalVestmentService;

import javax.naming.directory.SearchResult;
import java.util.UUID;

@SpringBootApplication
public class Lab04Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab04Application.class, args);
	}

	//command runner
	@Bean
	public CommandLineRunner commandLineRunner(@Autowired LiturgicalVestmentService service) {
		return (args -> {
			service.addVestment(new LiturgicalVestment(UUID.randomUUID().toString(), "chasuble", "green", "gold", "silk", "cotton", "roman", "large", null ));
			service.addVestment(new LiturgicalVestment(UUID.randomUUID().toString(), "chasuble", "red", "white", "wool", "linen", "gothic", "medium", "Examplary description" ));
			service.addVestment(new LiturgicalVestment(UUID.randomUUID().toString(), "stole", "white", "gold", "suede ", "cotton", "roman", "small", null ));
			service.addVestment(new LiturgicalVestment(UUID.randomUUID().toString(), "cope", "violet", "silver", "velvet", "cotton", "roman", "large", "Examplary description 3" ));
		});


	}


}
