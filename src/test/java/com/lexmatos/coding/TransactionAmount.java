package com.lexmatos.coding;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.Builder;

public class TransactionAmount {

	private enum Type {
		DEBIT,
		CREDIT
	}
	@Builder
	private record Transaction(String id, int amount, Type type) {}
	
	private static List<Transaction> list = List.of(Transaction.builder().amount(25).type(Type.DEBIT).build(),
				Transaction.builder().amount(45).type(Type.DEBIT).build(),
				Transaction.builder().amount(52).type(Type.CREDIT).build(),
				Transaction.builder().amount(50).type(Type.DEBIT).build()
			); 
	private Map<Type, Integer>  calculateBy() {
		var averary = list.stream().collect(Collectors.groupingBy(t -> t.type(), Collectors.summingInt(t -> t.amount())));
		
		return averary;
	}
	
//	@Test
	void avarageSalary() {
		Assertions.assertEquals("{CREDIT=52, DEBIT=120}", calculateBy().toString());
	}
	
}
