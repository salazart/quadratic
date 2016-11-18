package com.sz.quadratic.interfaces;

import java.util.List;

public interface IDao<T> {
	T get(int id);
	void save(T entity);
	void update(T entity);
	void delete(int id);
	List<T> getAll();
}
