package com.lexmatos.features;

import lombok.AllArgsConstructor;
import lombok.Value;

public class InstanceOfPattern {
	
	@Value
	@AllArgsConstructor
	static class Country {
		private String name;
		private String idiom;
	}
	public static String oldOne(Object o) {
		String toString;
		if (o instanceof Country) {
			Country country = (Country) o;
			toString = country.toString();
		}else {
			toString = o.toString();
		}
		return toString;
	}
	
	public static String newOne(Object o) {
		String toString;
		if (o instanceof Country country && "Portugal".equals(country.getName())) {
			toString = "PORTUGAL";
		} else {
			toString = o.toString();
		}
		return toString;
	}
}
