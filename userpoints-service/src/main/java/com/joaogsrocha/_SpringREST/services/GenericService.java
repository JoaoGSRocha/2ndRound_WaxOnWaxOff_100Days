package com.joaogsrocha._SpringREST.services;

public interface GenericService<T> {

    public Iterable<T> findAll();

    public T  find(Long id);

    public T create(T t);

    public void update(T t);

    public void delete(String id);

}
