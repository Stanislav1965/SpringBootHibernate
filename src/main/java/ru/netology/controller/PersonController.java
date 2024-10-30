package ru.netology.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.entity.Person;
import ru.netology.service.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons/by-city")
    public List<Person> findByCity(@RequestParam("city") String city) {
          return personService.findByCity(city);
      }

    @GetMapping("/persons/by-age")
    public List<Person> findByAge(@RequestParam("age") Integer age, Sort sort) {
        return personService.findByAge(age, sort);
    }

    @GetMapping("/persons/by-name")
    public Optional<Person> findByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname ) {
        return personService.findByNameAndSurname(name, surname);
    }
}
