package com.lexmatos.problems;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DateHourDTOTest {

	private DateHourDTO dateHourDTO;
	
    @Test
    void testHour() throws ParseException {
    	dateHourDTO = DateHourDTO.builder()
    			.dateInicio(new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-30"))
    			.hourMinutesBegin("16:30")
    			.hourMinutesEnd("19:30")
    			.build();
    	
    	 Assertions.assertEquals(new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2022-11-30 16:30"),dateHourDTO.getTimeStampBegin());
    	 Assertions.assertEquals(new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2022-11-30 19:30"),dateHourDTO.getTimeStampEnd());
    }	
	
    @Test
    void testHourWrong() throws ParseException {
    	dateHourDTO = DateHourDTO.builder()
    			.dateInicio(new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-30"))
    			.hourMinutesBegin("29:30")
    			.hourMinutesEnd("19:30")
    			.build();
    	
    	 Assertions.assertEquals(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2022-11-30 29:30"),dateHourDTO.getTimeStampBegin());
    	 Assertions.assertEquals(new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2022-11-30 19:30"),dateHourDTO.getTimeStampEnd());
    }	    
}
