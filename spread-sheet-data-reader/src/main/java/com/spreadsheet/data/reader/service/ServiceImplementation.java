package com.spreadsheet.data.reader.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.spreadsheet.data.reader.repository.Repositories;
import com.spreadsheet.data.reader.utility.Utility;

@SuppressWarnings("rawtypes")
public class ServiceImplementation<T> implements Services {

	@Autowired
	private Repositories repository;

	@Autowired
	private Utility utility;

//	@Autowired
//	private DetailRepository detailRepository;
//	
//	@Autowired
//	private BatchRepository batchRepository;

	@SuppressWarnings("unchecked")
	@Override
	public void upload(MultipartFile file) {
		try {
//			List<Header> hList = utility.excelToObject(file.getInputStream());
//			List<Detail> dList = (List<Detail>) Utility.excelToObject(file.getInputStream());
//			List<Batch> bList = (List<Batch>) Utility.excelToObject(file.getInputStream());
			repository.saveAll(utility.excelToObject(file.getInputStream()));
//			repository.saveAll(dList);
//			repository.saveAll(bList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> get() {
//		List<?> list = new ArrayList<>();
//		list.addAll(headerRepository.findAll());
		return repository.findAll();

	}
}
