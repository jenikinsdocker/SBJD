package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		Product prodcuts=productService.saveProductDetails(product);
		return new ResponseEntity<>(prodcuts,HttpStatus.CREATED);
	}
	@GetMapping("/findAll")
	public ResponseEntity<Product> findAllProducts(){
		List<Product> prodcuts=productService.findAllProductDetails();
		return new ResponseEntity(prodcuts,HttpStatus.OK);
	}
	
	

}
