package com.example.SpringBootPrices.model.response;


import com.example.SpringBootPrices.model.dto.PriceDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PricesResponse extends Response {
	
	private PriceDTO priceDTO;
	
	
}
