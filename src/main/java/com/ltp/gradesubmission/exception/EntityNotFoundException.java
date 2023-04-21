package com.ltp.gradesubmission.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id, Class<?> entity) {
        super("The " + entity.getSimpleName().toLowerCase() + " with id '" + id + "' does not exist in our records");
    }

    public EntityNotFoundException(String courseCode, Class<?> entity) {
        super("The " + entity.getSimpleName().toLowerCase() + " with code '" + courseCode
                + "' does not exist in our records");
    }

}