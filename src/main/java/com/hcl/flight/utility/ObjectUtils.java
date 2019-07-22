package com.hcl.flight.utility;

import org.springframework.beans.BeanUtils;

public class ObjectUtils {

	public static Object mappingObjects(Object object1, Object object2)
	{
		BeanUtils.copyProperties(object1, object2);
		return object2;
		
	}

}
