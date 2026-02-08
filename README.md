# E-Learning Platform (Java)

A clean, modular Java backend project modeling the core domain of an
e-learning platform.

## Features
- User hierarchy (Student, Instructor, Admin)
- Course & CourseContent modeling
- Subscription & Payment flow
- Enrollment validation
- Progress tracking per course content
- Certificate issuance upon course completion

## Architecture
- Plain Java (Java SE 17)
- Builder pattern for immutable models
- Services for business logic
- In-memory repositories (easily replaceable by DB)
- SRP and clean separation of concerns

## How to Run
Run the `Main` class to see the full flow:
payment → subscription → enrollment → progress → certificate

## Future Improvements
- Persistence with JPA/Hibernate
- REST API (Spring Boot)
- Authentication & authorization
- Reporting & analytics
