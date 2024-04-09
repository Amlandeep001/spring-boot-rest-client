package com.example.restclient.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder
public class Product
{
	Long id;
	String productname;
	Integer quantity;
	String brand;
	BigDecimal price;
	LocalDate expiryDate;
	LocalDate manufacturedDate;
}
