package com.spreadsheet.data.reader.utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.spreadsheet.data.reader.model.Batch;
import com.spreadsheet.data.reader.model.Detail;
import com.spreadsheet.data.reader.model.Header;

public class Utility<T> {
	public static boolean hasFileFormat(MultipartFile file) {
		if (file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
				|| file.getContentType().equals(".csv")) {
			return true;
		}
		return false;
	}

	public static boolean hasFileSize(MultipartFile file) {
		if (file.getSize() / 1024 * 1024 <= 20) {
			return true;
		}
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean hasRowLimit(MultipartFile file) {
		try {
			Workbook wb = new XSSFWorkbook(file.getInputStream());
			Sheet sheet = (Sheet) wb.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();
			int rowCount = 0;
			while (rows.hasNext()) {
				rowCount++;
			}
			if (rowCount <= 5000) {
				return true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> excelToObject(InputStream is) {
		try {
			Workbook wb = new XSSFWorkbook(is);
			Sheet sheet = (Sheet) wb.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();
			List<T> list = new ArrayList<>();
//			List<Header> hList = new ArrayList<Header>();
//			List<Detail> dList = new ArrayList<Detail>();
//			List<Batch> bList = new ArrayList<Batch>();

			List<String> columList = new ArrayList<>();
			int rownum = 0;
			while (rows.hasNext()) {
				Row row = rows.next();
				Iterator<Cell> cells = row.iterator();
				Header header = new Header();
				Detail detail = new Detail();
				Batch batch = new Batch();

				int cellnum = 0;
				while (cells.hasNext()) {
					Cell currentCell = cells.next();
					if (rownum == 0)
						columList.add(currentCell.getStringCellValue());
					switch (columList.get(cellnum)) {
					case "Invoice Number":
						header.setVendorInvoiceNumber(currentCell.getStringCellValue());
						break;
					case "Invoice Date":
						try {
							header.setVendorInvoiceDate(
									(Date) new SimpleDateFormat("dd/mm/yyyy").parse(currentCell.getStringCellValue()));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case "Client":
						header.setVendorClientNumber((int) currentCell.getNumericCellValue());
						break;
					case "Asset":
						header.setVendorAssetNumber((int) currentCell.getNumericCellValue());
						break;
					case "Vehicle Registered State (T&R)":
						header.setVendorRegisteredState(currentCell.getStringCellValue());
						break;
					case "Product Name (Transaction Type)":
						detail.setProductName(currentCell.getStringCellValue());
						break;
					case "Product Amount":
						detail.setProductAmount((float) currentCell.getNumericCellValue());
						break;
					case "VIN":
						header.setVendorVehicleVin(currentCell.getStringCellValue());
						break;
					case "Vendor Number (Supplied By LP)":
						batch.setVendorNumber((long) currentCell.getNumericCellValue());
						break;

					default:
						break;
					}
					cellnum++;
					if (cellnum > 8 || columList.get(cellnum).equals(""))
						break;
				}
				list.add((T) header);
				list.add((T) detail);
				list.add((T) batch);
			}
			wb.close();
//			list.add((T) hList);
//			list.add((T) dList);
//			list.add((T) bList);
			return list;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings({ "resource", "unchecked" })
	public List<T> csvToObject(InputStream is) {
		Scanner scanner = new Scanner(is);
		List<T> list = new ArrayList<>();
		List<Header> hList = new ArrayList<Header>();
		List<Detail> dList = new ArrayList<Detail>();
		List<Batch> bList = new ArrayList<Batch>();
		Header header = new Header();
		Detail detail = new Detail();
		Batch batch = new Batch();

		while (scanner.hasNext()) {
			String[] dataStrings = scanner.next().toString().split(",");
			header.setVendorInvoiceNumber(dataStrings[0]);
			try {
				header.setVendorInvoiceDate((Date) new SimpleDateFormat("dd/mm/yyyy").parse(dataStrings[1]));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			header.setVendorClientNumber(Integer.parseInt(dataStrings[2]));
			header.setVendorAssetNumber(Integer.parseInt(dataStrings[3]));
			header.setVendorRegisteredState(dataStrings[4]);
			detail.setProductName(dataStrings[5]);
			detail.setProductAmount(Float.parseFloat(dataStrings[6]));
			header.setVendorVehicleVin(dataStrings[7]);
			batch.setVendorNumber(Long.parseLong(dataStrings[8]));
			hList.add(header);
			dList.add(detail);
			bList.add(batch);
		}
		list.add((T) hList);
		list.add((T) dList);
		list.add((T) bList);
		return list;
	}

}
