package com.example.restclient.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restclient.client.ProductServiceClient;
import com.example.restclient.dto.Product;

@RestController
@RequestMapping("/product-client/products")
public class ProductClientController
{
	private final ProductServiceClient serviceClient;

	public ProductClientController(ProductServiceClient serviceClient)
	{
		this.serviceClient = serviceClient;
	}

	@PostMapping
	public Product saveNewProduct(@RequestBody Product product)
	{
		return serviceClient.saveNewProduct(product);
	}

	@GetMapping
	public List<Product> getAllProducts()
	{
		return serviceClient.getAllProducts();
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable int id)
	{
		return serviceClient.getProduct(id);
	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product product)
	{
		return serviceClient.updateProduct(id, product);
	}

	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		return serviceClient.deleteProduct(id);
	}

}
