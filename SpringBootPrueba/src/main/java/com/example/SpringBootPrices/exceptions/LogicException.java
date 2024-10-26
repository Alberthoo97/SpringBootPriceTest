package com.example.SpringBootPrices.exceptions;

public class LogicException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public LogicException(String msg) {
        super(msg);
    }

}
