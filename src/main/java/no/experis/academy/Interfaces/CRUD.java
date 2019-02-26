package no.experis.academy.Interfaces;

public interface CRUD<T> {
    Iterable<T> getAll();
    T getById(int id);
    void add(T item);
    void update(T item);
    T delete(T item);
}
