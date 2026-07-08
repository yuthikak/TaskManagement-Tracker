# TaskManagement-Tracker

# 📋 Task Management Tracker

A RESTful Task Management application built with **Spring Boot**, **Spring Security**, and **MongoDB**. The application allows users to securely manage their personal tasks through authenticated REST APIs.

---

## 🚀 Features

* 🔐 User Registration
* 🔑 Secure Authentication using Spring Security
* 🔒 Password Encryption with BCrypt
* ✅ Create a Task
* 📄 View All Tasks of the Logged-in User
* ✏️ Update Existing Tasks
* 🗑️ Delete Tasks
* 👤 User-specific task management
* 🌐 RESTful API architecture
* 💾 MongoDB integration

---

## 🛠️ Tech Stack

| Technology          | Description                    |
| ------------------- | ------------------------------ |
| Java 17             | Programming Language           |
| Spring Boot         | Backend Framework              |
| Spring Security     | Authentication & Authorization |
| Spring Data MongoDB | Database Access                |
| MongoDB             | NoSQL Database                 |
| Maven               | Dependency Management          |
| Postman             | API Testing                    |

---

## 📂 Project Structure

```text
src
├── controller
├── service
├── repository
├── entity
├── config
├── security
├── dto
└── exception
```

---

## 📌 API Endpoints

### Authentication

| Method | Endpoint | Description         |
| ------ | -------- | ------------------- |
| POST   | `/user`  | Register a new user |

---

### Tasks

| Method | Endpoint     | Description                                  |
| ------ | ------------ | -------------------------------------------- |
| POST   | `/task`      | Create a new task                            |
| GET    | `/task`      | Retrieve all tasks of the authenticated user |
| PUT    | `/task/{id}` | Update an existing task                      |
| DELETE | `/task/{id}` | Delete a task                                |

> **Note:** Task endpoints require authentication.

---

## 🔒 Security

* User authentication using Spring Security.
* Passwords are encrypted using BCrypt before storage.
* Authenticated users can access only their own tasks.
* Unauthorized requests are denied.

---

## 🗄️ Database

The application uses **MongoDB** to store:

### User Collection

* User ID
* Username
* Password (Encrypted)
* Roles

### Task Collection

* Task ID
* Title
* Description
* Created At
* User ID (Owner)




## 🧪 Testing

The REST APIs were tested using **Postman**.

Example workflow:

1. Register a new user.
2. Authenticate using your configured security mechanism.
3. Create a task.
4. View your tasks.
5. Update a task.
6. Delete a task.

---

## 📈 Future Improvements

* Task status (Pending, In Progress, Completed)
* Due dates
* Task priority
* Pagination and sorting
* Search and filtering
* JWT-based authentication
* Swagger/OpenAPI documentation
* Unit and integration testing

---

## 📚 What I Learned

Through this project, I gained hands-on experience with:

* Building REST APIs using Spring Boot
* Implementing authentication and authorization with Spring Security
* Password encryption using BCrypt
* Working with MongoDB using Spring Data
* Designing layered architecture (Controller → Service → Repository)
* Managing user-specific resources securely
* Testing APIs using Postman

---

## 👩‍💻 Author

**Yuthika Kuwar**

If you found this project interesting, feel free to fork it, explore the code, or share your feedback.
