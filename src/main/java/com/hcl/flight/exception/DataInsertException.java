package com.hcl.flight.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataInsertException extends RuntimeException
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataInsertException(String exception) {
        super(exception);
    }
}