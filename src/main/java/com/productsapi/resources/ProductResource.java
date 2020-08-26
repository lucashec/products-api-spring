package com.productsapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productsapi.models.Product;
import com.productsapi.repository.ProductRepository;

@RestController
@RequestMapping(value="/api")
public class ProductResource {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	public List<Product> productList(){
		return productRepository.findAll();
	}
	@GetMapping("/products/{id}")
	public Product uniqueProduct(@PathVariable(value="id")long id){
		return productRepository.findById(id);
	}
	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	@DeleteMapping("/products")
	public void deleteProduct(@RequestBody Product product) {
		productRepository.delete(product);
	}
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
}

