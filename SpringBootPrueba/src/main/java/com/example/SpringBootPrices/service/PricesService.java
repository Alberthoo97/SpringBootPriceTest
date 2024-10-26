package com.example.SpringBootPrices.service;

import java.time.OffsetDateTime;

import com.example.SpringBootPrices.model.dto.PriceDTO;

public interface PricesService {
	
	public PriceDTO getPrice(OffsetDateTime applicationDate, Integer productId, Integer brandId);
}
