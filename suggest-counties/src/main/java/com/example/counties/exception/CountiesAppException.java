package com.example.counties.exception;

/**
 * This class is a custom exception class that extends the Exception class
 * 
 * @author Manoj SP
 * @since 1.0
 */
public class CountiesAppException extends Exception {

	private static final long serialVersionUID = 7683031972329070728L;

	// This is the constructor of the class. It is calling the constructor of the
    // super class (Exception)
    // and passing the error message.
    public CountiesAppException(String errorMsg) {
        super(errorMsg);
    }
}
