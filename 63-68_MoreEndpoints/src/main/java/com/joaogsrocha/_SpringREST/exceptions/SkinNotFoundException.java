package com.joaogsrocha._SpringREST.exceptions;

public class SkinNotFoundException extends RuntimeException {
    public SkinNotFoundException(Long id) {
        super("Could not find employee " + id +"\n");
    }
}
