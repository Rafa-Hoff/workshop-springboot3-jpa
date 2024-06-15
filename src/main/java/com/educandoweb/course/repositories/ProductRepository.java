package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Instantiates a repository object with operations to manipulate a Product object.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
