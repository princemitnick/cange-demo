package com.prince.cange.cangedemo.controllers;


import com.prince.cange.cangedemo.models.Person;
import com.prince.cange.cangedemo.repositories.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonsController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<Person> list(){
        return personRepository.findAll();
    }

    @GetMapping( value = "/{id}")
    public Person get(@PathVariable Long id){
        return personRepository.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody final Person person){
        return personRepository.saveAndFlush(person);
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Person> createAll(@RequestBody final List<Person> persons){
        return personRepository.saveAll(persons);
    }


    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        personRepository.deleteById(id);
    }

    @PutMapping(value = "/edit/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person person){
        Person existingPerson = personRepository.findById(id).get();
        BeanUtils.copyProperties(person,existingPerson,"id");
        return personRepository.saveAndFlush(existingPerson);
    }


}
