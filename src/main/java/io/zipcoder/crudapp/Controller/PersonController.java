package io.zipcoder.crudapp.Controller;

import io.zipcoder.crudapp.Models.Person;
import io.zipcoder.crudapp.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;


    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/people")
    public Person createPerson( @RequestBody Person p){
        return personRepository.save(p);
    }

    @GetMapping("/people/{id}")
    public Person getPerson(@PathVariable Integer id){
        return this.personRepository.findOne(id);
    }

    @GetMapping("/people")
    public Iterable<Person> getPersonList(){
        return this.personRepository.findAll();
    }

    @PutMapping("/people/{id}")
    public Person updatePerson(@RequestBody  Person p, @PathVariable Integer id){
        Person person = getPerson(id);
        person.setFirstName(p.getFirstName());
        person.setLastName(p.getFirstName());

        return this.personRepository.save(person);
    }

    @DeleteMapping("/people/{id}")
    public void DeletePerson(@PathVariable Integer id){
         this.personRepository.delete(id);
    }
}