package com.lexmatos.ocp;

import java.util.function.Predicate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Lambdas {
	class Pamda {
		int age;
	}
	private String check(Pamda pamda, Predicate<Pamda> pred) {
		String result = pred.test(pamda) ? "match" : "not match";
		return result;
	}
	
	@Test
	void pampa() {
		Pamda p1 = new Pamda();
		p1.age = 1;
		Assertions.assertEquals("match", check (p1, p->p.age < 5));
		
	}
	@Test
	void test() {
		System.out.println(
	    String.format(
	    	      "%1$s %2$s[%3$s] from Task with id %4$s has a value that is not approved by the validation service %5$s[%6$s] of the Validation %7$s[%8$s]",
	    	      "classSimpleName",
	    	      "taskFieldName",
	    	      "taskFieldId",
	    	      "taskFieldTaskId",
	    	      "validationServiceName",
	    	      "validationServiceId",
	    	      "validationName",
	    	      "validationPublicId"));
	 }
		
}

