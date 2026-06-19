package com.event.reminder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendReminder(
            String to,
            String title,
            String eventDate,
            String description
    ) {

        SimpleMailMessage message =
                new SimpleMailMessage();

        message.setTo(to);
        message.setSubject(
                "Reminder: " + title + " 🎉"
        );

        message.setText(
                "Upcoming Event\n\n" +
                        "Title: " + title + "\n" +
                        "Date: " + eventDate + "\n" +
                        "Description: " + description
        );

        mailSender.send(message);
    }
}