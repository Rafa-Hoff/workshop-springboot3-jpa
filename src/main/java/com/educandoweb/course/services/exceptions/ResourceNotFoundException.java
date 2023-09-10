package com.educandoweb.course.services.exceptions;

import javax.management.relation.RelationNotFoundException;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id " + id);
    }
}
