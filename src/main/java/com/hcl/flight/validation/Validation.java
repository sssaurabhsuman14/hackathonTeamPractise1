package com.hcl.flight.validation;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.hcl.flight.exception.ApplicationException;
import com.hcl.flight.model.SearchFlightModel;

@Component
public class Validation {

	public static void validateSearchFlightModel(SearchFlightModel searchFlightModel) throws ApplicationException 
	{
		if(!StringUtils.hasText(searchFlightModel.getSource()))
			throw new ApplicationException("Source is Mandatory");
		
		if(!StringUtils.hasText(searchFlightModel.getDestination()))
			throw new ApplicationException("Destination is Mandatory");
		
		if(!StringUtils.hasText(searchFlightModel.getFlightDate().toString()))
			throw new ApplicationException("Flight Date is Mandatory");
		
	}

}
