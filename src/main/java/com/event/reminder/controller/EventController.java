package com.event.reminder.controller;

import org.springframework.web.bind.annotation.*;

import com.event.reminder.model.Event;
import com.event.reminder.repository.EventRepository;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/events")
public class EventController {

    private final EventRepository repo;

    public EventController(EventRepository repo) {
        this.repo = repo;
    }

   @GetMapping
public List<Event> getAllEvents() {
    return repo.findAll();
}

@PostMapping
public Event createEvent(@RequestBody Event event) {
    return repo.save(event);
}

@PutMapping("/{id}")
public Event updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
    Event event = repo.findById(id)
        .orElseThrow(() -> new RuntimeException("Event not found"));

    event.setTitle(updatedEvent.getTitle());
    event.setCategory(updatedEvent.getCategory());
    event.setDate(updatedEvent.getDate());
    event.setDescription(updatedEvent.getDescription());

    return repo.save(event);
}

@DeleteMapping("/{id}")
public void deleteEvent(@PathVariable Long id) {
    repo.deleteById(id);
}
}