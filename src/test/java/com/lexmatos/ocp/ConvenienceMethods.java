package com.lexmatos.ocp;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConvenienceMethods {

	@Test
	void suplierArray() {

		Supplier<ArrayList<String>> s3 = ArrayList::new;
		ArrayList<String> a1 = s3.get();
		
		Assertions.assertEquals(0,a1.size());
	}

	@Test
	void predicateBrown() {
		Predicate<String> egg = s -> s.contains("egg");
		Predicate<String> brown = s -> s.contains("brown");
		Predicate<String> brownEggs = egg.and(brown);
		Predicate<String> othersEggs = egg.and(brown.negate());
		
		Assertions.assertTrue(brownEggs.test("egg and brown"));
		Assertions.assertTrue(othersEggs.test("egg and milk"));
		Assertions.assertFalse(othersEggs.test("egg or brown"));
	}
	
	@Test
	void functionCompose() {
		Function<Integer, Integer> s = a -> a + 4;
		Function<Integer, Integer> t = a -> a * 3;
		Function<Integer, Integer> c = s.compose(t);
		
		Assertions.assertEquals(7, c.apply(1));
	}
	@Test
	void functionCompile() {
		final int length = 3;
		
		for(int i =0; i>3; i++) {
			if(i%2 == 0) {
				Supplier<Integer> supplier = () -> length;
				System.out.println(supplier.get());
			} else {
				final int j = i;
				Supplier<Integer> supplier = () -> j;
				System.out.println(supplier.get());
			}
		}
	}

	class Hyena {
		private int age = 1;
	}

	@Test
	void lambdaExpression() {
		
		var p = new Hyena();
		double height = 10;
		int age = 1;
		testLaugh(p, var -> p.age <= 10);
		testLaugh(p, shenzi -> age == 1);
		testLaugh(p, pp -> true);  // p, p ERROR
		testLaugh(p, shenzi -> age == 2);
		testLaugh(p, h -> h.age < 5);
	}
	
	static void testLaugh(Hyena panda, Predicate<Hyena> joke) {
		var r= joke.test(panda) ? "hahaha\n" : "silence\n";
		System.out.print(r);
	}
	
	@Test
	void splitTest() {
		String m = "[finishConnect(..) failed: Connection refused: localhost/127.0.0.1:7777]";
		String sb2 = Stream.of(m)
				.map(s -> s.substring(s.indexOf(": ")+2))
				.map(s -> s.substring(0, s.length()-1))
				.findFirst().get();
		Assertions.assertEquals("Connection refused: localhost/127.0.0.1:7777",sb2);
	}
}
