package com.products.vendas.services;

import com.products.vendas.entities.Category;
import com.products.vendas.entities.Person;
import com.products.vendas.repositories.CategoryRepository;
import com.products.vendas.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository repository;

    public List<Category> findAll() {

        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}