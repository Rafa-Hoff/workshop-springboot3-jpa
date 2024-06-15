package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Instantiates a repository object with operations to manipulate a User object.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
