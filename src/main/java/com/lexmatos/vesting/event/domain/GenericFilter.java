package com.lexmatos.vesting.event.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GenericFilter<T> {
	
	public List<T> filter(List<T> products, Predicate<? super T> predicate) {
		
		return products.stream().filter(predicate).collect(Collectors.toList());
	}
}
