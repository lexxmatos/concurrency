package com.lexmatos.vesting.event.adapter;

import java.util.List;

import com.lexmatos.vesting.event.domain.Event;

public interface EventRepository {
	
	public List<Event> findAll();
}
