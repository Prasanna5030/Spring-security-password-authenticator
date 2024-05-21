package com.sl.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.entity.Product;
import com.sl.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	private List<Product>productList =null;
 	@Override
	public List<Product> getAllProducts() {
    List<Product> productList= productRepository.findAll();
		return productList;
	}

 	@PostConstruct
	public void addProducts() {
		
		productList = IntStream.rangeClosed(1, 100).mapToObj(i->Product.builder()
																.productName(new Random().nextInt(20)+"product"+i)
																.price(new Random().nextFloat(5000))
																.quantity(new Random().nextInt(20))
																.build()).collect(Collectors.toList());
		
		productRepository.saveAll(productList);
																					
	}

	@Override
	public Product getProductById(int id) {
		return  productRepository.findById(id).orElseThrow( ( )->  new RuntimeException("product"+ id +"not found"));
		
	}

}
