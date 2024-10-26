package com.example.SpringBootPrices.exceptions;

import com.example.SpringBootPrices.utils.Constants;

public class NoDataException extends LogicException {
	
	private static final long serialVersionUID = 1L;

	public NoDataException(String msg) {
        super(msg);
    }
	
	public NoDataException() {
        super(Constants.EXCEPTION_NO_DATA);
    }

}
