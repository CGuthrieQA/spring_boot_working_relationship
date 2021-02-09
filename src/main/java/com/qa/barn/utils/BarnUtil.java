package com.qa.barn.utils;

import static org.springframework.beans.BeanUtils.copyProperties;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class BarnUtil {

	// merge not null - used to ensure we don;t get an error with update statement
	// need a customer handler --> will handle our error if one occurs.
	
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
	
	// this just checks that our object is not null during update and prevents spring from crashing
	
}
