package com.darkblue97.curriculummonolith.exceptions;

public class DataAlreadySavedException extends Exception {
    private final String message;

    public DataAlreadySavedException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ("Exception occurred when saving data, rolling back insert:" + message);
    }
}
