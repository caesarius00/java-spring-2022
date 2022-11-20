package pl.edu.ug.ckwella.lab03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import pl.edu.ug.ckwella.lab03.domain.Person;
import pl.edu.ug.ckwella.lab03.service.Data;
import pl.edu.ug.ckwella.lab03.service.PersonService;
import pl.edu.ug.ckwella.lab03.zad2.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

@ImportResource("classpath:beans.xml")

@SpringBootApplication
public class Lab03Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Lab03Application.class, args);

		try{
			HashMap<String, Person> m = Data.getMap(applicationContext,Data.getData("https://stepik.org/media/attachments/lesson/266646/MOCK_DATA.csv"));

			Service service = applicationContext.getBean(Service.class);
			m.put(UUID.randomUUID().toString(), service.getPerson1());
			m.put(UUID.randomUUID().toString(), service.getPerson2());
			m.put(UUID.randomUUID().toString(), service.getPerson3());

			m.forEach((k,v)-> System.out.println(k + " " + v));

			PersonService personService = applicationContext.getBean(PersonService.class);
			for (Person p : m.values()){
				personService.addPerson(p);
			}
			//print line
			System.out.println("------------------------------------------------------------");
			//print all persons
			personService.getAllPersons().forEach((k,v)-> System.out.println(k + " " + v));

		} catch (IOException e) {}

	}

}
