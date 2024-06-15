package com.educandoweb.course.services;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    /**
     * Responsible to returning all the categories of database.
     * @return all categories list.
     */
    public List<Category> findAll() {
        return repository.findAll();
    }

    /**
     * Responsible to finding a Category by the ID.
     * @param id category ID.
     * @return a Category.
     */
    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}
