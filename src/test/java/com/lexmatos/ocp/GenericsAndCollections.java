package com.lexmatos.ocp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GenericsAndCollections {

	public record Hello<T>(T t) {
		public Hello(T t) {
			this.t = t ;
		}
		
		private <T> String println(T message) {
			return t + "-" + message;
		}
	}
	@Test
	void hello() {
		Assertions.assertEquals("hi-1",new Hello<String>("hi").println(1));
		Assertions.assertEquals("hola-true",new Hello("hola").println(true));
	}
	
	public record Platypus(String name, int beakLength) {
		@Override
		public String toString() {
			return "" + beakLength;
		}
	}
	@Test
	void comparator() {
		Platypus p1 = new Platypus("Paula",3);
		Platypus p2 = new Platypus("Peter",5);
		Platypus p3 = new Platypus("Peter",7);
		
		List<Platypus> list = Arrays.asList(p1,p2,p3);
		
		Collections.sort(list, Comparator.comparing(Platypus::beakLength).reversed());
		Assertions.assertArrayEquals(List.of(p3,p2,p1).toArray(new Platypus[0]),list.toArray(new Platypus[0]));
		
		Collections.sort(list, Comparator.comparing(Platypus::name).reversed()
				.thenComparing(Comparator.comparing(Platypus::beakLength).reversed() ));
		Assertions.assertArrayEquals(List.of(p3,p2,p1).toArray(new Platypus[0]),list.toArray(new Platypus[0]));
	}
	
	public record Sorted (int num, String text) implements Comparable<Sorted>, Comparator<Sorted> {
		public String toString() { return "" + num; }

		@Override
		public int compare(Sorted s1, Sorted s2) {

			return s1.num + s2.num;
		}

		@Override
		public int compareTo(Sorted s) {
			return text.compareTo(s.text);
		}
	}
	@Test
	void sortedTest() {
		var s1 = new Sorted(88, "a");
		var s2 = new Sorted(55, "b");
		var t1 = new TreeSet<Sorted>();
		
		t1.add(s1); t1.add(s2);
		var t2 = new TreeSet<Sorted>(s1);
		
		t2.add(s1); t2.add(s2);
		
		Assertions.assertEquals("[88, 55] [88, 55]", t1.toString() + " " + t2.toString());
		
	}
	@Test
	void linkedList() {
		var q = new LinkedList<>();
		q.add(10);
		q.add(12);
		q.remove(1);
		
		Assertions.assertEquals("[10]", q.toString());
		
		Queue<Integer> y = new LinkedList<>();
		y.add(10);
		y.add(12);
		y.remove();
		
		Assertions.assertEquals("[12]", y.toString());

	}
	
//	@Test
	void hashMapTest() {
		Map m = new HashMap();
		m.put(123, "456");
		m.put("abc", "edf");
		
		Assertions.assertEquals(true, m.containsKey("abc"));
		
		var map = Map.of(1,2,3,6);
		var list = List.copyOf(map.entrySet());
		
		Assertions.assertEquals("[3=6, 1=2]", list.toString());
		
		List<Integer> one = List.of(8, 16, 2);
		var copy = List.copyOf(one);
		var copyOfCopy = List.copyOf(copy);
		var thirdCopy = List.copyOf(copyOfCopy);
		
		Assertions.assertEquals("[8, 16, 2]", thirdCopy.toString());
	}
	
	public static <T> T identity(T t) {
		return t;
	}
	
	@Test
	void identityTest() {
		var map = new HashMap<Integer, Integer>();
		map.put(1, 10);
		map.put(2, 20);
		map.put(3, null);
		
		map.merge(1, 3, (a,b) -> a + b);
		map.merge(3, 3, (a,b) -> a + b);
		
		System.out.print(map);
	}
	
	
}
