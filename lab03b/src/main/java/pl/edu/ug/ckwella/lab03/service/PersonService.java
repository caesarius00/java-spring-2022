package pl.edu.ug.ckwella.lab03.service;

import pl.edu.ug.ckwella.lab03.domain.Person;

import java.util.HashMap;

public interface PersonService {

    Person addPerson(Person person);

    HashMap<String, Person> getAllPersons();

    boolean deletePerson(String id);

    Person findPerson(String id);

    Person editPerson(String id, Person person);


}
