package com.lexmatos.features;

import java.util.List;

public class SwitchExpressions {
	public enum Country {
		BRAZIL, PORTUGAL, SPAIN, ENGLAND, OTHER
	}
	public static String oldOne(Country country) {
		
		String language;
		switch (country) {
        	case BRAZIL, PORTUGAL:
        		language = "Portuguese";
            	break;
        	case SPAIN:
        		language = "Spanish";
        		break;
        	case ENGLAND:
        		language = "English";
        	default:
        		language = "Chinese";
            
	    }
        return language;
    }
	public static String newOne(Country country) {
		var x = "Chinese";
		List<String> list = List.of("Portuguese", "Spanish"); 
		
		list.stream().anyMatch( 
					t -> t.endsWith(country.name())
				);
		
		list.stream().anyMatch(  
					t -> switch (t.toUpperCase()) {
						case "Portuguese" -> true;
						default -> false;
					}
				);
		
		String language = switch (country) {
        	case BRAZIL, PORTUGAL -> "Portuguese";
        	case SPAIN            -> "Spanish";
        	case ENGLAND          -> { System.out.println(); yield "English";}
        	default               -> x;
	    };
        return language;
    }	
}
