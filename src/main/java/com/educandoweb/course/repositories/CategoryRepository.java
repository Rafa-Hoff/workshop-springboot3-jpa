package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Instantiates a repository object with operations to manipulate a Category object.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
