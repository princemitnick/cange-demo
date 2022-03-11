package com.prince.cange.cangedemo.repositories;


import com.prince.cange.cangedemo.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<Person, Long> {
}
