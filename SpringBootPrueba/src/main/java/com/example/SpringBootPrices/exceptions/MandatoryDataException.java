package com.example.SpringBootPrices.exceptions;

import com.example.SpringBootPrices.utils.Constants;

public class MandatoryDataException extends LogicException {
	
	private static final long serialVersionUID = 1L;

	public MandatoryDataException(String msg) {
        super(msg);
    }
	
	public MandatoryDataException() {
        super(Constants.EXCEPTION_MANDATORY_DATA);
    }

}
