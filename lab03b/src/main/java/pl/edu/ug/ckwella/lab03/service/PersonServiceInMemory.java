package pl.edu.ug.ckwella.lab03.service;

import org.springframework.stereotype.Component;
import pl.edu.ug.ckwella.lab03.domain.Person;

import java.util.HashMap;
import java.util.UUID;

@Component
public class PersonServiceInMemory implements PersonService {

    private HashMap<String, Person> persons = new HashMap<>();

    @Override
    public Person addPerson(Person person) {
        persons.put(UUID.randomUUID().toString(), person);
        return person;
    }

    @Override
    public HashMap<String, Person> getAllPersons() {
        return persons;
    }

    @Override
    public boolean deletePerson(String id) {
        if (persons.containsKey(id)) {
            persons.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Person findPerson(String name) {
        for (Person person : persons.values()) {
            if (person.getFirstName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Person editPerson(String id, Person person) {
        if (persons.containsKey(id)) {
            persons.put(id, person);
            return person;
        }
        return null;
    }
}
