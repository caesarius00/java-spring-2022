package pl.edu.ug.ckwella.lab03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.ckwella.lab03.domain.Person;
import pl.edu.ug.ckwella.lab03.service.PersonService;

import java.util.HashMap;

@RestController
public class Controller {
    private final PersonService personService;

    public Controller(@Autowired PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/api/person")
    Person addPerson(@RequestBody Person person) {

        return personService.addPerson(person);

    }

    @GetMapping("/api/person")
    HashMap<String, Person> getAll() {
        return personService.getAllPersons();
    }

    @GetMapping("/api/person/{name}")
    Person findPerson(@PathVariable("name") String name) {
        return personService.findPerson(name);
    }

    @DeleteMapping("/api/person/{id}")
    boolean deletePerson(@PathVariable("id") String id) {
        return personService.deletePerson(id);
    }

    @PutMapping("/api/person/{id}")
    Person editPerson(@PathVariable("id") String id, @RequestBody Person person) {
        return personService.editPerson(id, person);
    }

}
