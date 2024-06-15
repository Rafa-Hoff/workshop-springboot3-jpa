package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Instantiates a repository object with operations to manipulate an OrderItem object.
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
