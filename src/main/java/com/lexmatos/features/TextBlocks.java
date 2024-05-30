package com.lexmatos.features;

public class TextBlocks {
	public static String oldStyle() {
		var oldOne = "{\n" +
                "  \"name\": \"Alexandre dos Santos Matos\",\n" +
                "  \"address\": \"Rua Visconde de Moraes 159 apto 1304, Rio de Janeiro\"\n" +
                "}";
		return oldOne;
	}
	public static String newStyle() {
	
		var newOne = """
				{
				  "name": "Alexandre dos Santos Matos",
				  "address": "Rua Visconde de Moraes 159 apto 1304, Rio de Janeiro"
				}""";
		return newOne; 
	}
}
