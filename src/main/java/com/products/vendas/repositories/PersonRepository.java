package com.products.vendas.repositories;

import com.products.vendas.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository <Person, Long> {

}