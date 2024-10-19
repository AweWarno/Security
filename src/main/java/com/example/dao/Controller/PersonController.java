package com.example.dao.Controller;

import com.example.dao.Entity.Person;
import com.example.dao.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PersonController {

    final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
        setTestData();
    }

    @GetMapping("persons/by-city")
    public String getPersonsByCity(String city) {
        Person person = personRepository.findByCity(city);
        return person.toString();
    }

    @GetMapping("persons/by-age")
    public String getPersonsByCity(int age) {
        Person person = personRepository.findByAge(age);
        return person.toString();
    }

    @GetMapping("persons/by-name")
    public Optional<Person> getPersonsByName(String name, String surname) {
        Person person = personRepository.findByName(name, surname);
        return Optional.ofNullable(person);

    }


    private void setTestData() {
        Person person1 = Person.builder()
                .name("name1")
                .surname("surname1")
                .age(41)
                .phoneNumber("1111")
                .cityOfLiving("Moskow")
                .build();

        personRepository.save(person1);

        Person person2 = Person.builder()
                .name("name2")
                .surname("surname2")
                .age(42)
                .phoneNumber("2222")
                .cityOfLiving("SPB")
                .build();

        personRepository.save(person2);

        Person person3 = Person.builder()
                .name("name3")
                .surname("surname3")
                .age(43)
                .phoneNumber("33333")
                .cityOfLiving("Kazan")
                .build();

        personRepository.save(person1);
    }
}
