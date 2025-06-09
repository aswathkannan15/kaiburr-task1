# Java backend and REST API example.

A simple Spring Boot REST API for creating, running, and managing tasks, where each task runs shell commands and stores execution results in MongoDB.

Each **Task** object stores:
- `id`: Unique Task ID
- `name`: Task Name
- `owner`: Task Owner
- `command`: Shell command to execute
- `taskExecutions`: List of execution history with output and timestamps

---

## Features

- Create a new task
-  Retrieve one or all tasks
-  Delete a task
-  Search tasks by name
-  Execute shell commands (safely)
-  Stores outputs and timestamps of each execution
-  MongoDB integration  

---

## Technologies Used

- Java 17+
- Spring Boot
- Spring Data MongoDB
- MongoDB 
- Postman

---

## 📁 Project Structure
```bash
src/
├── Controller
│ └── TaskController.java
├── model
│ ├── Task.java
│ └── TaskExecution.java
├── repository
│ └── TaskRepo.java
├── service
│ └── TaskService.java
└── Task1Application.java


