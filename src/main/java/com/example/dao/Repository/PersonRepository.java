package com.example.dao.Repository;

import com.example.dao.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select p from Person p where upper(p.cityOfLiving) like upper(concat('%', ?1, '%'))")
    Person findByCity(String cityOfLiving);

    @Query("select p from Person p where p.age < ?1 ORDER BY p.age DESC")
    Person findByAge(int age);

    @Query("select p from Person p where p.name = ?1 and p.surname = ?2")
    Person findByName(String name, String surname);
}