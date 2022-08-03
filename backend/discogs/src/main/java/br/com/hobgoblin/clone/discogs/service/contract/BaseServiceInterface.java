package br.com.hobgoblin.clone.discogs.service.contract;

import java.util.List;

public interface BaseServiceInterface <T, D>{
	T save(T dto);
	T find(D identifier);
	List<T> findAll();
	void remove(D identifier);
}
