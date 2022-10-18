package com.darkblue97.curriculummonolith.exceptions;

public class CodeInjectionSuspectDetected extends Exception {
    private final String message;

    public CodeInjectionSuspectDetected(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ("Code injection suspected" + message);
    }
}