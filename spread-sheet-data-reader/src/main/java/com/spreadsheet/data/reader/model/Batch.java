package com.spreadsheet.data.reader.model;

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
@Table(name="batch")
public class Batch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "vendor_uid")
	private Long vendorNumber;
	
	public Long getVendorNumber() {
		return vendorNumber;
	}

	public void setVendorNumber(Long vendorNumber) {
		this.vendorNumber = vendorNumber;
	}

	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}
}
