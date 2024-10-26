package com.example.SpringBootPrices.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.SpringBootPrices.converter.PricesConverter;
import com.example.SpringBootPrices.dao.PricesRepository;
import com.example.SpringBootPrices.entity.Prices;
import com.example.SpringBootPrices.exceptions.NoDataException;
import com.example.SpringBootPrices.exceptions.TooManyPricesException;
import com.example.SpringBootPrices.model.dto.PriceDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PricesServiceImpl implements PricesService {

	
	private PricesRepository pricesRepository;


	/**
	 * Servicio que obtiene del repository la tarifa por la fecha/product/brand
	 */
	@Override
	public PriceDTO getPrice(OffsetDateTime applicationDate, Integer productId, Integer brandId) {


		Optional<List<Prices>> pricesEntity = pricesRepository.findByDateProductAndBrand(applicationDate, productId, brandId);
		
		if (pricesEntity.isEmpty() || pricesEntity.get().isEmpty()) {
			throw new NoDataException();
		}
		
		if (pricesEntity.get().size() > 1) {
			throw new TooManyPricesException();
		}
		
		PriceDTO priceDTO = PricesConverter.priceEntityToDto(pricesEntity.get().get(0));
		

		return priceDTO;

	}

	
}
