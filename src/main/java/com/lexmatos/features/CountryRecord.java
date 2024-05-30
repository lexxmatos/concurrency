package com.lexmatos.features;

import lombok.Builder;
// https://reflectoring.io/java-release-notes/

@Builder
public record CountryRecord (String name, Integer size, String idiom) {
	// private final String name
	// private final String size
	// private final String idiom
	//toString()
	//equals() 
	//hashCode()
	public CountryRecord {
		if (size<=0) {
			throw new IllegalArgumentException("size must be bigger than 0");
		}
	}
}
