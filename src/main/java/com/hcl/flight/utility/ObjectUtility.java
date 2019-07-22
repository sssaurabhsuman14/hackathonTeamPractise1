package com.hcl.flight.utility;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ObjectUtility 
{
	public static Object checkOptional(Optional<?> optionalObject) {
		
		if(optionalObject.isPresent())
			return optionalObject.get();
		else
			return null;	
	}
	
	public static Object mappingObjects(Object objct1, Object object2)
	{
		BeanUtils.copyProperties(objct1, object2);
		return object2;
		
	}
	

}
