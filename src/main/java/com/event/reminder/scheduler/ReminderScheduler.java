package com.event.reminder.scheduler;

import com.event.reminder.model.Event;
import com.event.reminder.repository.EventRepository;
import com.event.reminder.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ReminderScheduler {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 9 * * *")
    //@Scheduled(fixedRate = 30000)
    public void checkReminders() {

        LocalDate today = LocalDate.now();

        List<Event> events = eventRepository.findAll();

        for (Event event : events) {

            if (event.getEmail() == null || event.getEmail().isBlank()) {
                continue;
            }

            LocalDate reminderDate =
                    event.getDate().minusDays(event.getReminderDays());

            if (today.equals(reminderDate)
                    && !event.isReminderSent()) {

                emailService.sendReminder(
                        event.getEmail(),
                        event.getTitle(),
                        event.getDate().toString(),
                        event.getDescription()
                );

                event.setReminderSent(true);
                eventRepository.save(event);
            }
        }
    }
}