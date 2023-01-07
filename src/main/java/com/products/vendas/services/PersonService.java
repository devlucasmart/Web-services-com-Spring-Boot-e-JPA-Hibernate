package com.products.vendas.services;

import com.products.vendas.entities.Person;
import com.products.vendas.repositories.PersonRepository;
import com.products.vendas.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {

        return repository.findAll();
    }
    public Person findById(Long id) {
        Optional<Person> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public Person insert(Person obj) {

        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}