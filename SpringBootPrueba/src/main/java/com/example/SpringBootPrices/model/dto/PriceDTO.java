package com.example.SpringBootPrices.model.dto;

import java.time.OffsetDateTime;


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
public class PriceDTO {
	
	private Integer productId;
	private Integer brandId;
	private Long priceList;
	private OffsetDateTime startDate;
	private OffsetDateTime endDate;
	
}
