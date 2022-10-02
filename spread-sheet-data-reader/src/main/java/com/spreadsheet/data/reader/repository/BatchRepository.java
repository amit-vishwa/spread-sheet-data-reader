package com.spreadsheet.data.reader.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spreadsheet.data.reader.model.Batch;

public interface BatchRepository extends CrudRepository<Batch, Integer> {

	public List<Batch> findAll();

}
