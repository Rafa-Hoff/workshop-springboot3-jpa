package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    /**
     * Responsible to returning all the users of database.
     * @return all users list.
     */
    public List<User> findAll() {
        return repository.findAll();
    }

    /**
     * Responsible to finding a user by the user ID.
     * @param id user ID.
     * @return a user.
     */
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    /**
     * Responsible to inserting a new user in database.
     * @param obj
     * @return null.
     */
    public User insert(User obj) {
        return repository.save(obj);
    }

    /**
     * Responsible to deleting a user from database using his ID.
     * @param id user ID.
     */
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * Responsible to updating the user data.
     * @param id User ID that will be changed.
     * @param obj new user data
     * @return null
     */
    public User update(Long id, User obj) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    /**
     * Responsible to updating the user data.
     * @param entity
     * @param obj
     */
    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
