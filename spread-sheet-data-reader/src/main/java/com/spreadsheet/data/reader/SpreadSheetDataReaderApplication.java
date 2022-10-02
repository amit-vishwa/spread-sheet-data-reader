package com.spreadsheet.data.reader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpreadSheetDataReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpreadSheetDataReaderApplication.class, args);
		System.out.println("Spreadsheet data reader application running...");
	}

}
