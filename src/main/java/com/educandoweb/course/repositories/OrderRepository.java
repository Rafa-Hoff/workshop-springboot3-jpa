package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Instantiates a repository object with operations to manipulate an Order object.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}
