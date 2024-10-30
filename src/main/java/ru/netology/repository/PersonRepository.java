package ru.netology.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByCity(String city);

    @Query("select p from Person p where p.age < :age")
    List<Person> findByAge(@Param("age") Integer age, Sort sort);

    Optional<Person> findByNameAndSurname(String name, String surname);
}
