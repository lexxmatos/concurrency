package com.lexmatos.vesting.event.repository;

import java.util.Date;

import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Data;

public class EventCsv {
	
	@CsvBindByPosition(position = 0)
	private String command;
	@CsvBindByPosition(position = 1)
	private String employeeId;
	@CsvBindByPosition(position = 2)
	private String employeeName;
	@CsvBindByPosition(position = 3)
	private String awardId;
	@CsvBindByPosition(position = 4)
	private String date;
	@CsvBindByPosition(position = 5)
	private Float quantity;	

	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getAwardId() {
		return awardId;
	}
	public void setAwardId(String awardId) {
		this.awardId = awardId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Float getQuantity() {
		return quantity;
	}
	@Override
	public String toString() {
		return "EventCsv [employeeId=" + employeeId + ", employeeName=" + employeeName + ", awardId=" + awardId
				+ ", date=" + date + ", quantity=" + quantity + "]";
	}
	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}
}
