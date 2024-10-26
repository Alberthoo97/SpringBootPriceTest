package com.example.SpringBootPrices.controller;



import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.example.SpringBootPrices.dao.PricesRepository;
import com.example.SpringBootPrices.entity.Prices;
import com.example.SpringBootPrices.model.request.PricesRequest;
import com.example.SpringBootPrices.model.response.PricesResponse;
import com.example.SpringBootPrices.service.PricesService;
import com.example.SpringBootPrices.utils.Constants;

@SpringBootTest
public class PricesControllerTest {
	
	@Autowired
	private PricesController pricesController;
	
	@Autowired
	private PricesService pricesService;
	
	
	
	@Test
	public void getPriceTest1() {
		
		PricesRequest request = new PricesRequest();
		request.setApplicationDate(OffsetDateTime.of(2020, 06, 14, 10, 0, 0, 0, ZoneOffset.ofHours(0)));
		request.setBrandId(1);
		request.setProductId(35455);
		
		Long expectedResult = 1l;
		
		Assertions.assertEquals(expectedResult, pricesController.getPrice(request).getPriceDTO().getPriceList());
	}
	
	@Test
	public void getPriceTest2() {
		
		PricesRequest request = new PricesRequest();
		request.setApplicationDate(OffsetDateTime.of(2020, 06, 14, 16, 0, 0, 0, ZoneOffset.ofHours(0)));
		request.setBrandId(1);
		request.setProductId(35455);
		
		Long expectedResult = 2l;
		
		Assertions.assertEquals(expectedResult, pricesController.getPrice(request).getPriceDTO().getPriceList());
	}
	
	@Test
	public void getPriceTest3() {
		
		PricesRequest request = new PricesRequest();
		request.setApplicationDate(OffsetDateTime.of(2020, 06, 14, 21, 0, 0, 0, ZoneOffset.ofHours(0)));
		request.setBrandId(1);
		request.setProductId(35455);
		
		Long expectedResult = 1l;
		
		Assertions.assertEquals(expectedResult, pricesController.getPrice(request).getPriceDTO().getPriceList());
	}
	
	@Test
	public void getPriceTest4() {
		
		PricesRequest request = new PricesRequest();
		request.setApplicationDate(OffsetDateTime.of(2020, 06, 15, 10, 0, 0, 0, ZoneOffset.ofHours(0)));
		request.setBrandId(1);
		request.setProductId(35455);
		
		Long expectedResult = 3l;
		
		Assertions.assertEquals(expectedResult, pricesController.getPrice(request).getPriceDTO().getPriceList());
	}
	
	@Test
	public void getPriceTest5() {
		
		PricesRequest request = new PricesRequest();
		request.setApplicationDate(OffsetDateTime.of(2020, 06, 16, 21, 0, 0, 0, ZoneOffset.ofHours(0)));
		request.setBrandId(1);
		request.setProductId(35455);
		
		Long expectedResult = 4l;
		
		Assertions.assertEquals(expectedResult, pricesController.getPrice(request).getPriceDTO().getPriceList());
	}
	
	@Test
	public void getPriceMandatoryDataExceptionTest() {
		PricesRequest request = new PricesRequest();
		request.setApplicationDate(OffsetDateTime.of(2020, 06, 14, 10, 0, 0, 0, ZoneOffset.ofHours(0)));
		request.setBrandId(1);
		
		PricesResponse response = pricesController.getPrice(request);
		
		Assertions.assertEquals(Constants.EXCEPTION_MANDATORY_DATA, response.getMsgError());
		Assertions.assertEquals(false, response.isOk());
		Assertions.assertEquals(null, response.getPriceDTO());
	}
	
	@Test
	public void getPriceNoDataExceptionTest() {
		PricesRequest request = new PricesRequest();
		request.setApplicationDate(OffsetDateTime.of(2020, 06, 14, 10, 0, 0, 0, ZoneOffset.ofHours(0)));
		request.setBrandId(111);
		request.setProductId(111);
		PricesResponse response = pricesController.getPrice(request);
		
		Assertions.assertEquals(Constants.EXCEPTION_NO_DATA, response.getMsgError());
		Assertions.assertEquals(false, response.isOk());
		Assertions.assertEquals(null, response.getPriceDTO());
	}
	
    @Test
    public void getPriceTooManyResultsTest() {
    	PricesRepository repository = Mockito.mock(PricesRepository.class);
    	ReflectionTestUtils.setField(pricesService, "pricesRepository", repository);
    	
        PricesRequest request = new PricesRequest();
        request.setApplicationDate(OffsetDateTime.of(2020, 6, 14, 10, 0, 0, 0, ZoneOffset.ofHours(0)));
        request.setBrandId(1);
        request.setProductId(35455);
        
        List<Prices> pricesResult = new ArrayList<>();
        pricesResult.add(new Prices());
        pricesResult.add(new Prices());
        Optional<List<Prices>> responseRepository = Optional.of(pricesResult);

        when(repository.findByDateProductAndBrand(any(), anyInt(), anyInt())).thenReturn(responseRepository);

        PricesResponse response = pricesController.getPrice(request);

        Assertions.assertEquals(Constants.EXCEPTION_TOO_MANY_PRICES, response.getMsgError());
        Assertions.assertFalse(response.isOk());
        Assertions.assertNull(response.getPriceDTO());
    }
	
	
    @Test
    public void getPriceUnexpectedExceptionTest() {
    	PricesService service = Mockito.mock(PricesService.class);
        PricesController pController = new PricesController(service);

    	
        PricesRequest request = new PricesRequest();
        request.setApplicationDate(OffsetDateTime.of(2020, 6, 14, 10, 0, 0, 0, ZoneOffset.ofHours(0)));
        request.setBrandId(1);
        request.setProductId(35455);

        when(service.getPrice(any(), anyInt(), anyInt())).thenThrow(new RuntimeException());

        PricesResponse response = pController.getPrice(request);

        Assertions.assertEquals(Constants.EXCEPTION_SYSTEM_ERROR, response.getMsgError());
        Assertions.assertFalse(response.isOk());
        Assertions.assertNull(response.getPriceDTO());
    }
	
}
