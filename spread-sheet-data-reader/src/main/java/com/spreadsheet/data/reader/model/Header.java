package com.spreadsheet.data.reader.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="header")
public class Header {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "invoice_number")
	private String vendorInvoiceNumber;

	@Column(name = "invoice_date")
	private Date vendorInvoiceDate;
	
	@Column(name = "client_number")
	private Integer vendorClientNumber;
	
	@Column(name = "asset_number")
	private Integer vendorAssetNumber;
	
	@Column(name = "vehicle_vin")
	private String vendorVehicleVin;

	@Column(name = "state_abbreviation")
	private String vendorRegisteredState;

	public Header() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVendorInvoiceNumber() {
		return vendorInvoiceNumber;
	}

	public void setVendorInvoiceNumber(String vendorInvoiceNumber) {
		this.vendorInvoiceNumber = vendorInvoiceNumber;
	}

	public Date getVendorInvoiceDate() {
		return vendorInvoiceDate;
	}

	public void setVendorInvoiceDate(Date vendorInvoiceDate) {
		this.vendorInvoiceDate = vendorInvoiceDate;
	}

	public Integer getVendorClientNumber() {
		return vendorClientNumber;
	}

	public void setVendorClientNumber(Integer vendorClientNumber) {
		this.vendorClientNumber = vendorClientNumber;
	}

	public Integer getVendorAssetNumber() {
		return vendorAssetNumber;
	}

	public void setVendorAssetNumber(Integer vendorAssetNumber) {
		this.vendorAssetNumber = vendorAssetNumber;
	}

	public String getVendorVehicleVin() {
		return vendorVehicleVin;
	}

	public void setVendorVehicleVin(String vendorVehicleVin) {
		this.vendorVehicleVin = vendorVehicleVin;
	}

	public String getVendorRegisteredState() {
		return vendorRegisteredState;
	}

	public void setVendorRegisteredState(String vendorRegisteredState) {
		this.vendorRegisteredState = vendorRegisteredState;
	}

}
