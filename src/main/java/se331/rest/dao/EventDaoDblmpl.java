package se331.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.rest.entity.Event;
import se331.rest.repository.EventRepository;

import java.util.List;

@Repository
@Profile("db")
public class EventDaoDblmpl implements EventDao{
    @Autowired
    EventRepository eventRepository;
    @Override
    public Integer getEventSize() {
        return Math.toIntExact(eventRepository.count());
    }

    @Override
//    public List<Event> getEvents(Integer pageSize, Integer page) {
//        List<Event> events = eventRepository.findAll();
//        pageSize = pageSize ==null ? events.size():pageSize;
//        page = page ==null ? 1:page;
//        int firstIndex = (page-1)*pageSize;
//        List<Event> output = events.subList(firstIndex,firstIndex+pageSize);
//        return output;
//    }
    public Page<Event> getEvents(Integer pageSize, Integer page) {
        return eventRepository.findAll(PageRequest.of(page-1,pageSize));
    }

    @Override
    public Event getEvent(Long id) {
        return eventRepository.findById(id).orElse(null);
    }
}
