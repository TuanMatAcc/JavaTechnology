package org.example.DAO;

import java.util.List;

public interface Repository<T> {
    public boolean add(T entity);
    public boolean update(T entity);
    public boolean removeByID(int id);
    public boolean remove(T entity);
    public T get(int id);
    public List<T> getAll();
}
