package com.example.SpringBootPrices;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.SpringBootPrices.dao.PricesRepository;
import com.example.SpringBootPrices.entity.Prices;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DataLoaderComponent implements CommandLineRunner {

	private final PricesRepository pricesRepository;

	@Override
	public void run(String... args) throws Exception {

		pricesRepository.save(Prices.builder().priceList(1l).brandId(1).startDate(formatDate("2020-06-14-00.00.00"))
				.endDate(formatDate("2020-12-31-23.59.59")).productId(35455).priority(0).price(35.5).curr("EUR")
				.lastUpdate(formatDate("2020-03-26-14.49.07")).lastUpdateBy("user1").build());

		pricesRepository.save(Prices.builder().priceList(2l).brandId(1).startDate(formatDate("2020-06-14-15.00.00"))
				.endDate(formatDate("2020-06-14-18.30.00")).productId(35455).priority(1).price(25.45).curr("EUR")
				.lastUpdate(formatDate("2020-05-26-15.38.22")).lastUpdateBy("user1").build());

		pricesRepository.save(Prices.builder().priceList(3l).brandId(1).startDate(formatDate("2020-06-15-00.00.00"))
				.endDate(formatDate("2020-06-15-11.00.00")).productId(35455).priority(1).price(30.5).curr("EUR")
				.lastUpdate(formatDate("2020-05-26-15.39.22")).lastUpdateBy("user2").build());

		pricesRepository.save(Prices.builder().priceList(4l).brandId(1).startDate(formatDate("2020-06-15-16.00.00"))
				.endDate(formatDate("2020-12-31-23.59.59")).productId(35455).priority(1).price(38.95).curr("EUR")
				.lastUpdate(formatDate("2020-06-02-10.14.00")).lastUpdateBy("user1").build());

	}

	private OffsetDateTime formatDate(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ssXXX");

        String dateTimeWithOffset = stringDate + "+00:00";
        
        return OffsetDateTime.parse(dateTimeWithOffset, formatter.withZone(java.time.ZoneOffset.UTC));

	}
}