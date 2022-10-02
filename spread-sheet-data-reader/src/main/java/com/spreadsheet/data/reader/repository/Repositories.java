package com.spreadsheet.data.reader.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositories<T extends CrudRepository<T, Integer>> {
	public List<T> findAll();

	public List<T> saveAll(List<T> list);
}
