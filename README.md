# GoRest API Automation Framework

## 🚀 Project Overview
This project is an API Automation suite built to validate the **Users CRUD (Create, Read, Update, Delete)** lifecycle on the [GoRest API](https://gorest.co.in). [cite_start]The framework follows the **Modular Design Pattern**, ensuring that test logic, API interactions, and data models are strictly separated[cite: 10, 11].

## 🛠 Tech Stack
* [cite_start]**Java 11+** [cite: 4]
* [cite_start]**Maven** (Build & Dependency Management) [cite: 5]
* [cite_start]**Rest-Assured** (API Request/Response library) [cite: 6]
* [cite_start]**TestNG** (Test Execution & Assertions) [cite: 7]
* [cite_start]**Jackson/POJO** (JSON Serialization/Deserialization) [cite: 8]

## 📂 Project Architecture
[cite_start]The project follows the professional folder structure requested in the assignment [cite: 58-77]:

| Package | Responsibility |
| :--- | :--- |
| **base** | [cite_start]Contains `BaseTest.java` for global URI and Auth setup[cite: 65, 79]. |
| **client** | [cite_start]Contains `UserApiClient.java` with logic for POST, GET, PUT, DELETE[cite: 67, 83]. |
| **models** | [cite_start]Contains `User.java` POJO for data representation[cite: 69, 90]. |
| **tests** | [cite_start]Contains `UserCrudTest.java` for orchestrating the test flow[cite: 71, 100]. |
| **utils** | [cite_start]Helper classes like `ConfigReader` (properties) and `TestDataUtil`[cite: 73, 74, 75]. |

---

## 💻 Core Component Explanations

### 1. BaseTest.java (Setup)
[cite_start]The `BaseTest` class uses a `@BeforeClass` annotation to initialize global settings before any tests run[cite: 79].
* [cite_start]**Base URI:** Fetched from `config.properties` to avoid hardcoding[cite: 80, 106].
* [cite_start]**Request Specification:** Pre-configures the **Authorization Bearer Token** and **Content-Type: application/json** for all requests[cite: 81, 82].

### 2. UserApiClient.java (API Layer)
This class contains the technical implementation of the HTTP methods. [cite_start]It focuses strictly on the logic of calling endpoints and returns a `Response` object for validation in the test layer[cite: 83, 89].
* [cite_start]`createUser(User user)` - POST [cite: 85]
* [cite_start]`getUser(int userId)` - GET [cite: 86]
* [cite_start]`updateUser(int userId, User user)` - PUT/PATCH [cite: 87]
* [cite_start]`deleteUser(int userId)` - DELETE [cite: 88]

### 3. UserCrudTest.java (Mandatory Flow)
[cite_start]This class orchestrates the **End-to-End** flow as required by the assignment[cite: 22, 101]:
1. [cite_start]**Create:** Sends POST, validates **201**, and **extracts user Id**[cite: 23, 27, 29].
2. [cite_start]**Get:** Uses the extracted ID to fetch data and validates **200**[cite: 30, 31, 35].
3. [cite_start]**Update:** Updates a field (e.g., name) and validates the change[cite: 37, 39, 42].
4. [cite_start]**Delete:** Removes the user and validates **204**[cite: 44, 46, 48].
5. [cite_start]**Verify:** Attempts to GET the deleted user to confirm a **404 Not Found** status[cite: 49, 50, 52].

---

## ⚙️ Setup & Execution
1. **API Token:** Generate a token at [GoRest](https://gorest.co.in/consumer/login).
2. [cite_start]**Configuration:** Update `src/test/resources/config.properties`[cite: 77, 104]:
   ```properties
   base.url=[https://gorest.co.in](https://gorest.co.in)
   auth.token=YOUR_TOKEN_HERE
   ```
3.Run via CLI:

```Bash
mvn clean test
```
## 📋 Evaluation Metrics
This framework addresses the key areas for assessment:

- Request Chaining: Demonstrates handling dynamic data between endpoints.

- Code Structure: Adheres to industry-standard modular design.

- Validations: Includes status codes, response bodies, and negative testing.


