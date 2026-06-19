# 🎉 Event Reminder System

A full-stack Event Reminder application built using **Spring Boot**, **PostgreSQL**, **JavaMailSender**, and a simple **HTML/CSS/JavaScript frontend**.

The application allows users to create events, set reminder days, and automatically receive email notifications before the event date.

---

## 🚀 Features

### Event Management

* Add new events
* View all upcoming events
* Edit existing events
* Delete events
* Sort events by date

### Reminder System

* Set custom reminder days for each event
* Automatic email notifications
* Scheduled background reminder checks
* Prevents duplicate reminder emails

### Categories

Examples:

* Personal
* Work
* Birthday

### Dashboard

* Countdown badges:

  * Today
  * Tomorrow
  * X Days Left
  * Passed
* Reminder date preview
* Clean modern UI

---

# 🛠 Tech Stack

### Backend

* Java 21
* Spring Boot 3
* Spring Data JPA
* Hibernate
* JavaMailSender

### Database

* PostgreSQL

### Frontend

* HTML
* CSS
* JavaScript (Fetch API)

### Scheduling

* Spring Scheduler (`@Scheduled`)

---

# 📂 Database Schema

### Event Table

| Column        | Type    |
| ------------- | ------- |
| id            | BIGINT  |
| title         | VARCHAR |
| category      | VARCHAR |
| date          | DATE    |
| description   | VARCHAR |
| email         | VARCHAR |
| reminder_days | INTEGER |
| reminder_sent | BOOLEAN |

---

# 📡 REST API Endpoints

## Get All Events

```http
GET /events
```

Response

```json
[
  {
    "id": 1,
    "title": "Mom's Birthday",
    "category": "Personal",
    "date": "2026-06-26",
    "description": "Buy Cake",
    "email": "user@gmail.com",
    "reminderDays": 8,
    "reminderSent": false
  }
]
```

---

## Create Event

```http
POST /events
```

Request Body

```json
{
  "title": "Mom's Birthday",
  "category": "Personal",
  "date": "2026-06-26",
  "description": "Buy Cake",
  "email": "user@gmail.com",
  "reminderDays": 8
}
```

---

## Update Event

```http
PUT /events/{id}
```

Request Body

```json
{
  "title": "Mom's Birthday",
  "category": "Personal",
  "date": "2026-06-26",
  "description": "Buy Cake",
  "email": "user@gmail.com",
  "reminderDays": 5
}
```

---

## Delete Event

```http
DELETE /events/{id}
```

---

# ⏰ Email Reminder Workflow

Example:

```text
Event Date = 26 June 2026
Reminder Days = 8

Reminder Date = 18 June 2026
```

Scheduler runs automatically.

When:

```java
today == eventDate.minusDays(reminderDays)
```

An email is sent.

After sending:

```java
reminderSent = true
```

This prevents duplicate emails.

---

# Scheduler Configuration

### Every Day at 9:00 AM

```java
@Scheduled(cron = "0 0 9 * * *")
```

### Every Hour

```java
@Scheduled(cron = "0 0 * * * *")
```

### Every Minute (Testing)

```java
@Scheduled(cron = "0 * * * * *")
```

---

# Email Example

### Subject

```text
Reminder: Mom's Birthday 🎉
```

### Email Body

```text
Upcoming Event

Title: Mom's Birthday
Date: 2026-06-26
Description: Buy Cake
```

---

# Run Locally

## Clone Repository

```bash
git clone https://github.com/yourusername/event-reminder-system.git
```

---

## PostgreSQL

Create Database

```sql
CREATE DATABASE reminderdb;
```

---

## application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/reminderdb
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password

spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

---

## Start Backend

```bash
mvn spring-boot:run
```

Application starts at:

```text
http://localhost:8080
```

---

# Future Enhancements

* SMS Notifications
* WhatsApp Reminders
* Recurring Events
* Calendar View
* Google Calendar Integration
* User Authentication (JWT)
* Docker Deployment
* Cloud Deployment (AWS/Render/Railway)

---

# Author

**Mahek Joshi**

Built as a full-stack Spring Boot + PostgreSQL project demonstrating:

* REST APIs
* Database Integration
* Email Automation
* Scheduled Tasks
* Frontend Integration
* CRUD Operations
