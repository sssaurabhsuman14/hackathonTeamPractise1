package com.hcl.flight.utility;

import java.util.Optional;

	public class OptionalUtils {

		public static Object checkOptional(Optional<?> optionalObject) {
			
			if(optionalObject.isPresent())
				return optionalObject.get();
			else
				return null;	
		}

	}
