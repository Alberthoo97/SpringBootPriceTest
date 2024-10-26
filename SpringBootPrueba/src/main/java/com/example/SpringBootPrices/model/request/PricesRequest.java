package com.example.SpringBootPrices.model.request;

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
public class PricesRequest extends Request {

	private OffsetDateTime applicationDate;
	private Integer productId;
	private Integer brandId;
	
}
