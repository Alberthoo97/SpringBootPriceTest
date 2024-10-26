package com.example.SpringBootPrices.entity;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prices")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prices {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "price_list", unique = true, nullable = false)
	private Long priceList;
	
	@Column(name = "brandId")
	private Integer brandId;
	
	@Column(name = "start_date")
	private OffsetDateTime startDate;

	@Column(name = "end_date")
	private OffsetDateTime endDate;
	
	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "priority")
	private Integer priority;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "curr")
	private String curr;
	
	@Column(name = "last_update")
	private OffsetDateTime lastUpdate;
	
	@Column(name = "last_update_by")
	private String lastUpdateBy;
	
}
