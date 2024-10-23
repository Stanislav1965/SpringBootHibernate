package ru.netology.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.entity.Person;
import ru.netology.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPersonsByCity(String city) {
        return personRepository.getPersonsByCity(city);
    }
}
