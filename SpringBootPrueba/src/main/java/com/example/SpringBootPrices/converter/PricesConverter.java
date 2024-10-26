package com.example.SpringBootPrices.converter;

import com.example.SpringBootPrices.entity.Prices;
import com.example.SpringBootPrices.model.dto.PriceDTO;

public class PricesConverter {

	public static PriceDTO priceEntityToDto(Prices prices) {

		PriceDTO priceDTO = PriceDTO.builder().brandId(prices.getBrandId()).startDate(prices.getStartDate())
				.endDate(prices.getEndDate()).priceList(prices.getPriceList()).productId(prices.getProductId()).build();

		return priceDTO;

	}

}
