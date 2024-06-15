package com.educandoweb.course.services;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    /**
     * Responsible to returning all the orders of database.
     * @return all orders list.
     */
    public List<Order> findAll() {
        return repository.findAll();
    }

    /**
     * Responsible to finding an order by the ID.
     * @param id order ID.
     * @return an Order.
     */
    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
}
