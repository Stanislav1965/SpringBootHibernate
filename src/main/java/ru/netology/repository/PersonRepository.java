package ru.netology.repository;

import jakarta.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.netology.entity.Person;

import java.util.List;

@Repository
public class PersonRepository {

    @Autowired
    private EntityManager entityManager;


    public List<Person> getPersonsByCity(String city) {
        return entityManager.createQuery("from Person t where t.city_of_living like :city", Person.class)
                .setParameter("city", city)
                .getResultList();
    }

}
