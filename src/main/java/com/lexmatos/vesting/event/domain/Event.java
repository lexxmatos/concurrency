package com.lexmatos.vesting.event.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Event {
	
	@EqualsAndHashCode.Exclude
	private String command;
	private String employeeId;
	private String employeeName;
	private String awardId;
	@EqualsAndHashCode.Exclude
	private Date date;
	@EqualsAndHashCode.Exclude
	private Float quantity;
	@Override
	public String toString() {
		return employeeId + "," + employeeName + "," + awardId + "," + quantity;
	}
}
