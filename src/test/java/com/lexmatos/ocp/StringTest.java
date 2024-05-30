package com.lexmatos.ocp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class StringTest {

	@Test
	void numberOfLine(){
		String block1 = """
				doe \
				deer""";
		String block2 = """
				doe \n
				deer
				""";
		String block3 = """
				"doe\"\"\"
				\"deer\"""
				""";
		
		System.out.println("1#"+block1+"#1");
		Assertions.assertEquals(1,block1.split("\n").length);
		System.out.println("2#"+block2+"#2");
		Assertions.assertEquals(3,block2.split("\n").length);
		System.out.println("3#"+block3+"#3");
		Assertions.assertEquals(2,block3.split("\n").length);
	}
	
	@Test
	void matchesFileName() {
		String REGEX_PATTERN = "^[a-zA-Z0-9_-]+\\.zip$";
		String fileName = "OrderComposer_import_64be5ae20bec1451c6304847_2023-07-24_11_05_06Z.zip";
		
		Assertions.assertTrue(fileName.matches(REGEX_PATTERN));
		
		String REGEX_PATTERN2 = "^OrderComposer_export_[a-zA-Z0-9_+-]+\\.xml$";
		String fileName2 =  "OrderComposer_export_63ef78fd33581d61f08fc343_../../2022-01-01_13_00_00_+0000.xml";
		Assertions.assertFalse(fileName2.matches(REGEX_PATTERN2));		
	}
	
	@Test
	void allowedFileName() {
		Set<String> ALLOWED_FILENAMES = new HashSet<>(Arrays.asList("OrderComposer_import_"));
		
		String fileName = "OrderComposer_import_64be5ae20bec1451c6304847_../..2023-07-24_11_05_06Z.zip";
		
		Assertions.assertTrue(fileName.contains("OrderComposer_import_"));		
	}
	
}

