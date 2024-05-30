package com.lexmatos.vesting.event.domain;

import java.util.List;
import java.util.Set;

public interface EventGroup {
	List<Event> group(List<Event> events);
}
