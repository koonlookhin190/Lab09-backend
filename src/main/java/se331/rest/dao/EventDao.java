package se331.rest.dao;

import se331.rest.entity.Event;
import org.springframework.data.domain.Page;
import java.util.List;

public interface EventDao {
    Integer getEventSize();
    Page<Event> getEvents(Integer pageSize, Integer page);
    Event getEvent(Long id);

    Event save(Event event);
}

