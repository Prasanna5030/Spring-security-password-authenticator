package com.sl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sl.entity.Product;
import com.sl.service.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/")
	public String productpage() {
		return "Hello , welcome to products page";
	}
	
	//@PreAuthorize( "hasAuthority('ROLE_ADMIN')")
	@GetMapping("/all")
	public ResponseEntity<List <Product>> getProducts(){
		List<Product> allProducts = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(allProducts, HttpStatus.FOUND);
	}
	
	
	//@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable int id){
		Product product=productService.getProductById(id);
		return new ResponseEntity<Product>(product , HttpStatus.FOUND);
	}
	
	
}
