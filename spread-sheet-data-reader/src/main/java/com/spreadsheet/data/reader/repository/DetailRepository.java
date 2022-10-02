package com.spreadsheet.data.reader.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spreadsheet.data.reader.model.Detail;

public interface DetailRepository extends CrudRepository<Detail, Integer> {
	public List<Detail> findAll();

}
