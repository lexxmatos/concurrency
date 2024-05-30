package com.lexmatos.ocp;

import static org.assertj.core.api.Assertions.catchException;

import java.awt.Window;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Locale.Category;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionAndLocalization {  
	public void whatHappensNext() throws IOException {
		throw new IOException();
	}
	
	class Problem extends Exception {}	
	class YesProblem extends Problem {}
	
	class MyDatabase {
		
		void connectToDatabase() throws Problem {
			throw new YesProblem();
		}
	}
	
	//@Test
	void connectToDatabase() { 
		connectToDatabase();
	}
	
	@Test
	void snippetTest() { 
		int a = 0, b = 0;
		
		try {
			System.out.print(a/b);
		} catch (ArithmeticException e) {
			System.out.println(-1);
		} catch (RuntimeException e) {
			System.out.println(0);
		} finally {
			System.out.println("done");
		}
	}
	
	@Test
	void currentLocate() {
		double t = 100_102.2; 
		Assertions.assertEquals("100 mil",NumberFormat.getCompactNumberInstance().format(t));
		Assertions.assertEquals("100 thousand",NumberFormat.getCompactNumberInstance(Locale.ENGLISH, Style.LONG).format(t));
		Assertions.assertEquals("100K", NumberFormat.getCompactNumberInstance(Locale.getDefault(), Style.SHORT).format(t));
		Assertions.assertEquals("R$ 100.102,20", NumberFormat.getCurrencyInstance().format(t));
	}
	
	private String tryAgain(String s) throws FileNotFoundException { //7 D
		
		String valor = "X"; 
		try (FileReader r = null; var p = new FileReader("")){
			throw new IllegalArgumentException();
		} catch (Exception ss) {
			valor = "A";
			throw new FileNotFoundException();
			
		} finally {
			valor = valor.concat("O");
		}
		
		//return valor;
	}
	
	@Test
	void patternTest() { //8 C //9 F //10 B // 11 D E F
		String pattern = "#,###,000.0#";
		var message = DoubleStream.of(5.21, 8.49, 1234)
				.mapToObj(v -> new DecimalFormat(pattern).format(v))
				.collect(Collectors.joining("> <"));
		
		Assertions.assertEquals("005,21> <008,49> <1.234,0", message);
	}
	
	class StuckTurkeyCage implements AutoCloseable {
		public void close() throws IOException  {
			throw new FileNotFoundException("Cage not closed");
		}
	}
	
	@Test
	void stuckTurkeyCageTest() throws Exception{
		try (StuckTurkeyCage tt = new StuckTurkeyCage()){
			System.out.print("put turkeys in");
		}  
	}
	
	@Test
	void byllPointTest() {
		var huey = (String) null;
		Integer dewey = null;
		Object louie = null;
		
		if(louie == huey.substring(dewey.intValue())) {  // nullpoint in dewey
			System.out.print("Quack!");
		}
	}
	
	class  ReadMap implements AutoCloseable {
		private Locale locale;
		private boolean closed = false;
		
		@Override
		public void close() {
			System.out.println("Folding map");
			locale = null;
			closed = true;
		}
		
		public void open() {
			this.locale = new Locale("pt","BR");
			this.locale = new Locale.Builder().setLanguage("pt").setRegion("BR").build(); //minusculo para linguagem e maiusculo para o pais.
		}
		public void use() {
			
		}
	}
	@Test
	void dateTimeFormatterTest() {
		var d = DateTimeFormatter.ofPattern("dd' o''clock'");
		var f = DateTimeFormatter.ofPattern("hh' o''clock'");
		var ff = DateTimeFormatter.ISO_DATE_TIME;
		var dd = DateTimeFormatter.ISO_LOCAL_DATE;
		var tt = DateTimeFormatter.ISO_TIME;
		System.out.println(ff.format(LocalDateTime.now())+ "::" + f.format(LocalDateTime.now())); // Represents a date and time without considering any time zone or offset information.
		System.out.println(ff.format(ZonedDateTime.now())+ "::" +f.format(ZonedDateTime.now()));  
		System.out.println(dd.format(LocalDate.now())+ "::" +d.format(LocalDate.now()));  // there is no hour
		System.out.println(tt.format(LocalTime.now())+ "::" +f.format(LocalTime.now()));
	}

	@Test
	void familyCarMainTest() {
		var d = new FamilyCar.Door();
		try (d; var w = new FamilyCar.Windows()){
			System.out.print("T");;
		} catch (Exception e) {
			System.out.print("E");
		} finally {
			System.out.print("F");
		}
	}
	
	//19. d
	//20. AEBCD B
	//21 F
	
	@Test
	void localDateTimeTest() {
		try {
			LocalDateTime  book = LocalDateTime.of(2022, 4, 5, 12, 30, 20);
			System.out.print(book.format(DateTimeFormatter.ofPattern("m")));
			System.out.print(book.format(DateTimeFormatter.ofPattern("Z")));
		} catch (Throwable e) {}
	}
	
	@Test
	void snowStormTest() {
		final SnowStrom.WalkToSchool walk1 = new SnowStrom.WalkToSchool();
		try(walk1; SnowStrom.WalkToSchool walk2 = new SnowStrom.WalkToSchool()){
			throw new RuntimeException("blizzard");
		} catch (Exception e) {
			System.out.println(e.getMessage() + " " +e.getSuppressed().length);
		}
	//	walk1 = null;
	}
	
	record Wallet(double money) {
		private String openWallet() {
		//	Locale.setDefault(Category.DISPLAY, new Locale.Builder().setRegion("us").build());
			Locale.setDefault(Category.FORMAT, new Locale.Builder().setRegion("us").setLanguage("en").build());
			
			//return  NumberFormat.getCurrencyInstance(Locale.GERMANY).format(money);
			return  NumberFormat.getCurrencyInstance().format(money);
		}
		public void printBalance() {
			System.out.println(openWallet());
		}
	}
	@Test
	void walletTest() {
		new Wallet(2.4).printBalance();
	}
	
	void rollOut() throws ClassCastException {}  //f
	void transform(String c) {
		try {
			rollOut();
		} catch (IllegalArgumentException | NullPointerException e) {
			
		}
	}
}



class SnowStrom {
	static class WalkToSchool implements AutoCloseable {
		public void close() {
			throw new RuntimeException ("flurry");
		}
	}
}
class FamilyCar {  //TWDEF
	static class Door implements AutoCloseable {
		public void close() {
			System.out.print("D");
		}
	}
	static class Windows implements Closeable {
		public void close() {
			System.out.print("W");
			throw new RuntimeException();
		}
	}
}

class AhChoo {
	static class SneezeException extends Exception {}
	static class SniffleException extends SneezeException {}
	
	public static void main (String[] args) {
		try {
			throw new SneezeException();
		//} catch (SneezeException | SniffleException e) {
		} catch (SneezeException e) {			
			
		} finally {}
	}
}




