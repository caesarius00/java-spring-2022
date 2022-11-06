package pl.edu.ug.ckwella.lab03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.edu.ug.ckwella.lab03.domain.Person;

@Component
public class PersonManagerService {

    private final Person person;

    public PersonManagerService(@Autowired @Qualifier("object2") Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

}
