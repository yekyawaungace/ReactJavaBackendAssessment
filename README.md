# ReactJavaBackendAssessment
ReactJavaBackendAssessment

# firstly run reactassessment_favoriteplace.sql file in reactassessment folder in mysql db.

# import ReactAssessment.postman_collection.json in postman

# 📍 Favorite Places API - Spring Boot Application

This is a simple RESTful API built with **Spring Boot** for managing a list of favorite places (e.g., locations from Google Maps). It provides endpoints to **create**, **retrieve**, and **delete** favorite places.

---

## 🚀 Technologies Used

- Spring Boot
- Spring Data JPA
- MySQL  (based on configuration)
- Lombok
- REST API
- CORS Enabled for Frontend Integration (React)

---


## 📖 API Endpoints

| Method | Endpoint                                    | Description                    |
|--------|---------------------------------------------|--------------------------------|
| GET    | `/api/favorite`                             | Get all favorite                  |
| POST   | `/api/favorite`                             | Create a book                  |
| DELETE | `/api/favorite?1`                           | Delete a book by ID            |


---

Swager UI

http://localhost:9090/swagger-ui/index.html

---

## 🧪 Running Tests

```bash
mvn test