package com.event.reminder.controller;

import com.event.reminder.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailTestController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/test-mail")
    public String testMail() {

        emailService.sendReminder(
                "joshimahek.05@gmail.com",
                "Mom's Birthday",
                "2026-06-26",
                "Buy Cake"
        );

        return "Mail Sent";
    }
}