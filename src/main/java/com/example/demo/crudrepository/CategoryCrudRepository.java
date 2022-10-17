package com.example.demo.crudrepository;

import com.example.demo.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<Category, Integer>{
    
}