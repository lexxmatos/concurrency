package com.lexmatos.features;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class DateFormateTest {
	
	  @Test
	  void formateDate(){
	    OffsetDateTime offsetDT1 = OffsetDateTime.now();
	    System.out.println("OffsetDateTime1: " + offsetDT1);

	    OffsetDateTime offsetDT2 = OffsetDateTime.now(Clock.systemUTC());
	    System.out.println("OffsetDateTime2: " + offsetDT2);

	    OffsetDateTime offsetDT3 = OffsetDateTime.now(ZoneId.of("America/Sao_Paulo"));
	    System.out.println("OffsetDateTime3: " + offsetDT3);

	    OffsetDateTime offsetDT4 = OffsetDateTime.of(1980, 4, 9, 20, 15, 45, 345875000, ZoneOffset.of("+07:00"));
	    System.out.println("OffsetDateTime4: " + offsetDT4);

	    OffsetDateTime offsetDT5 = OffsetDateTime.of(LocalDate.now(), LocalTime.of(15, 50, 25), ZoneOffset.of("+07:00"));
	    System.out.println("OffsetDateTime5: " + offsetDT5);

	    OffsetDateTime offsetDT6 = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.of("+07:00"));
	    System.out.println("OffsetDateTime6: " + offsetDT6);

	    OffsetDateTime offsetDT7 = OffsetDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
	    System.out.println("OffsetDateTime7: " + offsetDT7);



	    OffsetDateTime offsetDT9 = OffsetDateTime.parse("1980-04-09T08:20:45+07:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME);
	    System.out.println("OffsetDateTime9: " + offsetDT9);

	    OffsetDateTime offsetDT10 = OffsetDateTime.parse("1980-04-09T08:20:45+07:00", DateTimeFormatter.ISO_DATE_TIME);
	    System.out.println("OffsetDateTime9: " + offsetDT9);
	  }
	  
//	  @Test
	  void formateDate2(){
		    //String datum = "2023-03-14 09:59:14.077195";
		    String datum = "2023-03-14 09:59:14";
		/*    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
		    LocalDateTime datetime = LocalDateTime.parse(datum, formatter);

		    ZonedDateTime zoned = datetime.atZone(ZoneId.of("America/Sao_Paulo"));
		    OffsetDateTime result = zoned.toOffsetDateTime();
		    System.out.println(result);
		  */  
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
		    LocalDateTime datetime = LocalDateTime.parse(datum, formatter);
		    ZonedDateTime zoned = datetime.atZone(ZoneId.of("Europe/Berlin"));
		    OffsetDateTime result = zoned.toOffsetDateTime();
		  
/*		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss.nnnnnn");
		    OffsetDateTime offsetDT8 = OffsetDateTime.parse("2023-03-14 09:59:14.077195",formatter);
*/		    
		    System.out.println("OffsetDateTime8: " + result);
		    
		    
	  }
}
