package com.lexmatos.coding;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.Builder;

public class AverageSalary {

	@Builder
	private record Employee(String name, int age, float salary) {}
	
	private static List<Employee> list = List.of(Employee.builder().age(25).name("João").salary(2500).build(),
				Employee.builder().age(45).name("Marcello").salary(7500).build(),
				Employee.builder().age(52).name("Sergio").salary(5500).build(),
				Employee.builder().age(50).name("Isabella").salary(4500).build()
			); 
	private static float calculateBy(int ageThreshold) {
		Double averary = list.stream()
				.filter(e -> e.age() <= ageThreshold)
				.collect(Collectors.averagingDouble(e -> e.salary()));
		
		return averary.floatValue();
	}
	
	@Test
	void avarageSalary() {
		Assertions.assertEquals(5000, calculateBy(45));
		Assertions.assertEquals(5000, calculateBy(52));
	}
	
}
