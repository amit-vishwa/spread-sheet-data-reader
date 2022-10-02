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
@Table(name = "detail")
public class Detail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "unit_price")
	private Float productAmount;

	@Column(name = "product_name")
	private String productName;

	public Float getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Float productAmount) {
		this.productAmount = productAmount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Detail() {
		super();
		// TODO Auto-generated constructor stub
	}
}
