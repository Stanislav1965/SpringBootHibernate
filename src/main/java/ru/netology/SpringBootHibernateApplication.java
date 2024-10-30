package ru.netology;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import ru.netology.entity.Person;
import ru.netology.repository.PersonRepository;

import java.util.List;


@SpringBootApplication
public class SpringBootHibernateApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHibernateApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {

        entityManager.persist(new Person("Scott", "Turner", 24, "911 221-12-12", "Moscow"));
        entityManager.persist(new Person("Michael", "Dooley", 40, "921 740-77-77", "Samara"));
        entityManager.persist(new Person("Sabrina", "Spellman", 19, "911 555-01-17", "Moscow"));
        entityManager.persist(new Person("Jon","Snow", 30, "921 555-14-39", "Moscow"));
        entityManager.persist(new Person("Joe", "Camber", 27, "911 555-71-25", "Samara"));
        entityManager.persist(new Person("Ellie", "Creed", 55, "921 555-25-59", "Moscow"));

        System.out.println();
        List<Person> personList = personRepository.findByAge(40, Sort.by("age")); // personRepository.findByCity_of_living("Moscow");
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}