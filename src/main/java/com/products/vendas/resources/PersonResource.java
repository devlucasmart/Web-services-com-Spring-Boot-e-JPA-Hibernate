package com.products.vendas.resources;

import com.products.vendas.entities.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/persons")
public class PersonResource {

    @GetMapping
    public ResponseEntity<Person> findAll(){
        Person p = new Person(1L, "Maria", "maria@gmail.com", "99999", "12345");
        return ResponseEntity.ok().body(p);
    }
}
