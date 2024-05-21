package com.sl.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="products_tbl")
public class Product {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="product_name", nullable=false)
	private String productName;
	
	private Float price;
	private Integer quantity;
	

}
