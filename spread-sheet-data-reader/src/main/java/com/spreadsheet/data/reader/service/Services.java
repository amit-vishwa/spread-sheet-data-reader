package com.spreadsheet.data.reader.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface Services<T> {

	public void upload(MultipartFile file);

	public List<T> get();

}
