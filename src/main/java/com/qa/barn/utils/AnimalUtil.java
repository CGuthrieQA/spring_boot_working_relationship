package com.qa.barn.utils;

import static org.springframework.beans.BeanUtils.copyProperties;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class AnimalUtil {
	
	//constructor
	public static void mergeNotNull(Object source, Object target) {
		copyProperties(source, target, getNullPropName(source));
	}
	
	
	private static String[] getNullPropName(Object src) {
		final BeanWrapper wrappedSrcObj = new BeanWrapperImpl(src);
		// loop through the data we pass then do something
		Set<String> propName = new HashSet<>();
		
		for ( PropertyDescriptor descriptor : wrappedSrcObj.getPropertyDescriptors() ) {
			if( wrappedSrcObj.getPropertyValue( descriptor.getName() ) == null ) {
				propName.add(descriptor.getName());
			}
		}
		return propName.toArray(new String[propName.size()]);
	}

}
