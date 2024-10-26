package com.example.SpringBootPrices.dao;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.SpringBootPrices.entity.Prices;

public interface PricesRepository extends JpaRepository<Prices, Long> {
	
	@Query("SELECT p FROM Prices p WHERE :applicationDate BETWEEN p.startDate AND p.endDate "
			+ " AND p.productId = :productId "
			+ " AND p.brandId = :brandId "
			+ " AND p.priority = (SELECT MAX(p2.priority) FROM Prices p2 WHERE :applicationDate BETWEEN p2.startDate AND p2.endDate "
			+ " AND p2.productId = :productId AND p2.brandId = :brandId) ")
	Optional<List<Prices>> findByDateProductAndBrand(@Param("applicationDate") OffsetDateTime applicationDate, 
			@Param("productId") Integer productId,
			@Param("brandId") Integer brandId);

}
