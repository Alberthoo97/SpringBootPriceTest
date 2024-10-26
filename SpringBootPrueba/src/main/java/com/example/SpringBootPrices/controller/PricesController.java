package com.example.SpringBootPrices.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootPrices.exceptions.LogicException;
import com.example.SpringBootPrices.exceptions.MandatoryDataException;
import com.example.SpringBootPrices.model.dto.PriceDTO;
import com.example.SpringBootPrices.model.request.PricesRequest;
import com.example.SpringBootPrices.model.response.PricesResponse;
import com.example.SpringBootPrices.service.PricesService;
import com.example.SpringBootPrices.utils.Constants;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/prices")
@AllArgsConstructor
public class PricesController {
	
	private PricesService pricesService;
	
	/**
	 * Controller getPrice (POST), puerta de entrada para la ejecución del 
	 * servicio getPrice, obtiene la tarifa en base a la fecha, productId y brandId
	 */
	@PostMapping("/getPrice")
	public PricesResponse getPrice(@RequestBody PricesRequest priceRequest) {
		PricesResponse response = new PricesResponse();
		try {
			if (priceRequest == null || (priceRequest != null && (priceRequest.getApplicationDate() == null || 
					priceRequest.getBrandId() == null || priceRequest.getProductId() == null))) {
				throw new MandatoryDataException();
			}
			
			PriceDTO priceDTO = pricesService.getPrice(priceRequest.getApplicationDate(), priceRequest.getProductId(), priceRequest.getBrandId());
			
			response.setOk(true);
			response.setPriceDTO(priceDTO);
			
		} catch (LogicException ex) {
			response.setOk(false);
			response.setPriceDTO(null);
			response.setMsgError(ex.getLocalizedMessage());
		} catch (Exception ex) {
			response.setOk(false);
			response.setPriceDTO(null);
			response.setMsgError(Constants.EXCEPTION_SYSTEM_ERROR);
		}
		
		return response;
		
	}

}
