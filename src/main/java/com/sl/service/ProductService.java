package com.sl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sl.entity.Product;
@Service
public interface ProductService {
	List<Product> getAllProducts();
	Product  getProductById( int id);

}
