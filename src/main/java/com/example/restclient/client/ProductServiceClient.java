package com.example.restclient.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.restclient.dto.Product;

@Service
public class ProductServiceClient
{
	private final RestClient restClient;

	public ProductServiceClient(@Value("${product.service.base-url}") URI baseUrl)
	{
		restClient = RestClient.builder()
				.baseUrl(baseUrl)
				.build();
	}

	public Product saveNewProduct(Product product)
	{
		return restClient.post()
				.uri("/products")
				.contentType(MediaType.APPLICATION_JSON)
				.body(product)
				.retrieve()
				.body(Product.class);
	}

	public List<Product> getAllProducts()
	{
		return restClient.get()
				.uri("/products")
				.retrieve()
				.body(new ParameterizedTypeReference<List<Product>>()
				{
				});
	}

	public Product getProduct(int id)
	{
		return restClient.get()
				.uri("/products/{id}", id)
				.retrieve()
				.body(Product.class);
	}

	public Product updateProduct(int id, Product product)
	{
		return restClient.put()
				.uri("/update/{id}", id)
				.contentType(MediaType.APPLICATION_JSON)
				.body(product)
				.retrieve()
				.body(Product.class);
	}

	public String deleteProduct(int id)
	{
		restClient.delete()
				.uri("/delete/{id}", id)
				.retrieve()
				.toBodilessEntity();
		return "product removed : " + id;
	}

}
