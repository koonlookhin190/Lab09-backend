package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.rest.entity.Event;
import se331.rest.service.EventService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EventController {


    @Autowired
    EventService eventService;
    @GetMapping("events")
    public ResponseEntity<?> getEventLists(@RequestParam(value = "_limit", required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page) {
        //List<Event> output = null;
        Page<Event> pageOutput = eventService.getEvents(perPage,page);
        HttpHeaders responseHeader = new HttpHeaders();
//        responseHeader.set("x-total-count",String.valueOf(eventService.getEventSize()));
//
//        try {
//            output = eventService.getEvents(perPage,page);
//            return new ResponseEntity<>(output,responseHeader,HttpStatus.OK);
//        } catch (IndexOutOfBoundsException ex) {
//            return new ResponseEntity<>(output,responseHeader,HttpStatus.OK);
//        }
        responseHeader.set("x-total-count",String.valueOf(pageOutput.getTotalElements()));
        return new
                ResponseEntity<>(pageOutput.getContent(),responseHeader,HttpStatus.OK);
    }

    @GetMapping("events/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Event output = eventService.getEvent(id);
        if (output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/events")
    public ResponseEntity<?> addEvent(@RequestBody Event event){
        Event output = eventService.save(event);
        return ResponseEntity.ok(event);
    }
}



