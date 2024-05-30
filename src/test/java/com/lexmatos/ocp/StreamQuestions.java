package com.lexmatos.ocp;


import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StreamQuestions {
	
	@Test
	void iterate() {
		var stream = Stream.iterate("", (s) -> s+"1");
		var second  = stream.limit(5).map(x -> x + "2").collect(Collectors.toList());
		//var first  = stream.limit(5).collect(Collectors.toList());
		//Assertions.assertEquals("[, 1, 11, 111, 1111]", first.toString());
		Assertions.assertEquals("[2, 12, 112, 1112, 11112]", second.toString());
	}
	
	@Test
	void predicateTest() {
		
		Predicate<String> predicate  = s -> s.startsWith("g");
		
		var stream1 = Stream.generate(() -> "grow1!");
		var stream2 = Stream.generate(() -> "grow1!");
		
		
		var b1 = stream1.anyMatch(predicate);
		var b2 = stream2.anyMatch(predicate);
		
		Assertions.assertEquals("true true",b1 + " " + b2);
	}
	
	@Test
	void predicate2Test() {
		
		Predicate<String> predicate = s -> s.length()>3;
		
		var stream = Stream.iterate("-", s-> ! s.isEmpty(), (s) -> s+s);
		var stream2 = Stream.iterate("-", s-> ! s.isEmpty(), (s) -> s+s);
		var stream3 = Stream.iterate("-", s-> ! s.isEmpty(), (s) -> s+s).limit(5);
		
		var b1 = stream.noneMatch(predicate);
		var b2 = stream2.anyMatch(predicate);
		var b3 = stream3.filter(predicate);
		
		Assertions.assertEquals("false true",b1 + " " + b2);
		//Assertions.assertEquals("false true",b3.toArray());		
	}
	
	@Test
	void result8Test() {
		double result = LongStream.of(6l, 8l, 10l)
				.mapToInt(x -> (int)x).boxed().collect(Collectors.groupingBy(x -> x)).keySet().stream().collect(Collectors.averagingInt(x -> x));
		
		Assertions.assertEquals(8l,result);		
		
/*		result = LongStream.of(6l, 8l, 10l)
				.mapToInt(x -> (int)x).collect(Collectors.groupingBy(x -> x, Collectors.toSet())).keySet().stream().collect(Collectors.averagingInt(x -> x));
				
		Assertions.assertEquals(8l,result);		
		*/
		
		/*
		 * The generic type T of the Java 16 toList() is the same as the generic type T of the Stream itself. 
		 * The generic type T of Collectors.toList() however is propagated from the left hand side of the assignment. 
		 * If those 2 types are different, you may see errors when replacing all the old calls.
		 */
		// Compiles
		List<CharSequence> list = Stream.of("hello", "world").collect(Collectors.toList());
		List<CharSequence> list2 = Stream.of("hello", "world").map(CharSequence.class::cast).toList();
	}
	
	@Test
	void generateTest() {
		var s = Stream.generate(() -> "meow");
		
		var match = s.allMatch(String::isEmpty);
		
		Assertions.assertFalse(match);
	}
	
	@Test
	void sortedList() {
		List<String> list = Stream.of("f","a", "b", "c","d", "e").toList(); 
		
		List<String> listSorted =  list.stream().sorted((a,b) -> a.compareTo(b)).toList();
		
		Assertions.assertArrayEquals(new String[]{"a", "b", "c","d", "e", "f"}, listSorted.toArray(new String[]{}));
	}
	
	@Test
	void optionalTest() {
		var stream = LongStream.of(1,2,3);
		var opt = stream.map(n -> n * 10).filter(n -> n < 5).findFirst();
		
		opt.ifPresent(System.out::println);
	}
	
	@Test
	void output10Test() {
		// N
		Stream.generate(() -> "1")
//			.peek(System.out::println)
			.limit(10)
			.forEach(System.out::println);
		//Assertions.assertEquals("10",output);
	}
	
	@Test
	void printString12345() {
		var print12345 = Stream.iterate(1,  x -> ++x)
			.limit(5).map(x -> "" + x).collect(Collectors.joining());
		
		var print11111 = Stream.iterate(1,  x -> x++)
				.limit(5).map(x -> "" + x).collect(Collectors.joining());
		
		Assertions.assertEquals("12345",print12345);
		Assertions.assertEquals("11111",print11111);
	}
	 @Test
	void flamingoTest() {
		Set<String> birds = Set.of("oriole","flamingo");
		Stream.concat(birds.stream(), birds.stream())
			//.sorted()
			.distinct()
			.findAny()
			.ifPresent(System.out::println);
	}
	@Test 
	void print123456() {
		List<Integer> x1 = List.of(1,2,3);
		List<Integer> x2 = List.of(4,5,6);
		List<Integer> x3 = List.of();
		
		Stream.of(x1,x2, x3)
			.flatMap(x -> x.stream())
			.map(x -> x + 1)
			.forEach(System.out::print);
	} 
	
	@Test
	void streamMapBoxed() {
		Stream<Integer> s = Stream.of(1);
		IntStream ss = IntStream.of(1);
		//IntStream is = s.boxed();
		Stream<Integer> is = ss.boxed();
		DoubleStream ds = s.mapToDouble(x -> x);
		//Stream<Integer> s2 = ds.mapToInt(x -> x);
		IntStream s2 = ds.mapToInt(x -> (int)x);
		
	}
	
	@Test
	void statementTrue() {
		
		Predicate<String> empty = String::isEmpty;
		Predicate<String> notEmpty = empty.negate();
		
		var result = Stream.generate(() -> "")
				.limit(10)
				.filter(notEmpty)
				.collect(Collectors.groupingBy(k -> k))
				.entrySet()
				.stream()
				.map(Entry::getValue)
				.flatMap(Collection::stream)
				.collect(Collectors.partitioningBy(notEmpty));
				//.collect(Collectors.groupingBy(n -> n));
		
		Assertions.assertEquals("{false=[], true=[]}",result.toString());
		//Assertions.assertEquals("{}",result.toString());
		//System.out.println(result); // B C
	}
	
	@Test
	void doubleStreamTest() {
		var s = DoubleStream.of(1.2, 2.4).peek(System.out::println).filter(x -> x>2).count();
		Assertions.assertEquals(1,s);
	}
	
	class Paging {
		record Sesame (String name, boolean human) {
			
			@Override 
			public String toString() {
				return name();
			}
		}
		
		record Page(List<Sesame> list, long count) {}
		static Page printPage(Stream<Sesame> monsters, Stream<Sesame> people) {
			Page page = Stream.concat(monsters, people)
					.collect(Collectors.teeing(
							Collectors.filtering(s -> s.name().startsWith("E"), Collectors.toList()), 
							Collectors.counting(), 
							(l,c) -> new Page(l,c)));
			return page;
		}
	}
	
	@Test
	void pagingTest() {
		var monsters = Stream.of(new Paging.Sesame("Elmo", false));
		var people = Stream.of(new Paging.Sesame("Abby", true));
		
		Assertions.assertEquals("Page[list=[Elmo], count=2]",Paging.printPage(monsters, people).toString()); ;
	}
	
	
}

