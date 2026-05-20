[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/Qr3lBpHw)

# University Management System

A microservices-based university management system built with Spring Boot.

## Technologies Used
- Java 21
- Spring Boot 3.x
- Spring Data JPA
- Spring Cloud OpenFeign
- PostgreSQL
- Springdoc OpenAPI (Swagger UI)
- Lombok
- Docker / Docker Compose
- Gradle

## How to Run

### Start databases
```bash
docker-compose up student-db course-db
```

### Run services
```bash
# Terminal 1
./gradlew :student-service:bootRun

# Terminal 2
./gradlew :course-service:bootRun
```

## Swagger URLs
- Student Service: http://localhost:9090/swagger-ui/index.html
- Course Service: http://localhost:8081/swagger-ui/index.html

## Endpoints

### Student Service (port 9090)
| Method | Path | Description |
|--------|------|-------------|
| POST | /api/v1/students | Create student |
| GET | /api/v1/students | Get all students |
| GET | /api/v1/students/{id} | Get student by ID |
| GET | /api/v1/students/search?name= | Search by name |
| PUT | /api/v1/students/{id} | Update student |
| DELETE | /api/v1/students/{id} | Delete student |

### Course Service (port 8081)
| Method | Path | Description |
|--------|------|-------------|
| POST | /api/v1/courses | Create course |
| GET | /api/v1/courses | Get all courses |
| GET | /api/v1/courses/{id} | Get course by ID |
| PUT | /api/v1/courses/{id} | Update course |
| DELETE | /api/v1/courses/{id} | Delete course |
| POST | /api/v1/courses/{courseId}/students/{studentId} | Enroll student |
| GET | /api/v1/courses/{courseId}/students | Get course students |
| GET | /api/v1/courses/by-student-name?name= | Get courses by student name |

## Example Requests

```bash
# Create student
curl -X POST http://localhost:9090/api/v1/students \
  -H "Content-Type: application/json" \
  -d '{"firstName":"Nicat","lastName":"Aliyev","email":"nicat@ada.edu.az","age":20}'

# Create course with prerequisite
curl -X POST http://localhost:8081/api/v1/courses \
  -H "Content-Type: application/json" \
  -d '{"title":"Məlumat Strukturları","code":"CS201","credits":4,"prerequisiteCourseId":1}'

# Enroll student
curl -X POST http://localhost:8081/api/v1/courses/1/students/1

# Get courses by student name
curl "http://localhost:8081/api/v1/courses/by-student-name?name=Nicat"
```

## Notes
- If a course has a prerequisiteCourseId, student must be enrolled
  in that course first or enrollment will be rejected with HTTP 422
