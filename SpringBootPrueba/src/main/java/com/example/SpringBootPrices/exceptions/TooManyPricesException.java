package com.example.SpringBootPrices.exceptions;

import com.example.SpringBootPrices.utils.Constants;

public class TooManyPricesException extends LogicException {
	
	private static final long serialVersionUID = 1L;

	public TooManyPricesException(String msg) {
        super(msg);
    }
	
	public TooManyPricesException() {
        super(Constants.EXCEPTION_TOO_MANY_PRICES);
    }

}
