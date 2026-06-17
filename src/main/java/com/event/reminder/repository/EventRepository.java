package com.event.reminder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.reminder.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}