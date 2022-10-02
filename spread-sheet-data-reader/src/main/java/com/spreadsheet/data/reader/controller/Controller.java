package com.spreadsheet.data.reader.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spreadsheet.data.reader.service.Services;
import com.spreadsheet.data.reader.utility.Utility;

@RestController
public class Controller {

	@SuppressWarnings("rawtypes")
	Services services;

	@SuppressWarnings("unchecked")
	@GetMapping("/get")
	public <T> List<T> get() {
//		List<?> list = new ArrayList<>();
		return services.get();
	}

	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
		if (Utility.hasFileFormat(file)) {
			if (Utility.hasFileSize(file)) {
				if(Utility.hasRowLimit(file)) {
				services.upload(file);
				return ResponseEntity.ok(Map.of("message", "file records are inserted in database tables"));
				}
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel or csv file with 20 MB of size and max of 5000 rows");
	}
}
