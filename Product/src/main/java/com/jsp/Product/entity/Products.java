package com.jsp.Product.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productid;
	private String productname;
	private String category;
	private double price;
	@Column(columnDefinition = "DATE")
	private LocalDate mfgdate;
	@Column(columnDefinition = "DATE")
	private LocalDate expdate;
}
