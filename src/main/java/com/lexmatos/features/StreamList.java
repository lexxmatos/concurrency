package com.lexmatos.features;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamList {
	
	public static List<String> oldStyle(String[] list) {
		
		return Stream.of(list).collect(Collectors.toList());
	}
	
	public static List<String> newStyle(String[] list) {
		
		return Stream.of(list).toList();
	}
}
