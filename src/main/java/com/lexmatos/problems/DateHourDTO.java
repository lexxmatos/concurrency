package com.lexmatos.problems;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DateHourDTO {
	private Date dateInicio;
	private String hourMinutesBegin; //"HH:MM"
	private String hourMinutesEnd; //"HH:MM"
	private Date dateFull;

	public Date getTimeStampBegin() throws ParseException {
		
		Calendar calendar = new Calendar.Builder().setInstant(dateInicio).build();
		
		calendar.set(Calendar.HOUR,Integer.valueOf(hourMinutesBegin.split(":")[0]));
		calendar.set(Calendar.MINUTE,Integer.valueOf(hourMinutesBegin.split(":")[1]));
		
		return calendar.getTime();
	}
	
	public Date getTimeStampEnd() throws ParseException {
		
		Calendar calendar = new Calendar.Builder().setInstant(dateInicio).build();
		
		calendar.set(Calendar.HOUR,Integer.valueOf(hourMinutesEnd.split(":")[0]));
		calendar.set(Calendar.MINUTE,Integer.valueOf(hourMinutesEnd.split(":")[1]));
		
		return calendar.getTime();
	}
}
