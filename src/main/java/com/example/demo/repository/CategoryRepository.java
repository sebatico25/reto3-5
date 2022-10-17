package com.example.demo.repository;

import com.example.demo.crudrepository.CategoryCrudRepository;
import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {
    
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    
    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }
    
    public Optional<Category> getById(Integer id){
        return categoryCrudRepository.findById(id);
    }
    
    public Category save(Category category){
        return categoryCrudRepository.save(category);
    }
    
    public void delete (Category category){
        categoryCrudRepository.delete(category);
    }
    
}
