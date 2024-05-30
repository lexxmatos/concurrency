package com.lexmatos.features;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryLombok {
	private String name;
	private Integer size;
	private String idiom;

	public CountryLombok (String name, Integer size, String idiom){
		this.name = name;
		this.size = size;
		this.idiom = idiom;
		if (size<=0) {
			throw new IllegalArgumentException("size must be bigger than 0");
		}
	}	
}
