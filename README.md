# 🧪 GoRest API Automation Framework

This project demonstrates a clean and scalable API automation framework using **Java**, **Rest Assured**, and **Cucumber BDD**. It automates CRUD operations on [GoRest API](https://gorest.co.in/) with token-based authentication, data-driven testing, and modular utilities.

---

📌 Technologies Used
Java 17+

 - Rest Assured
 - Cucumber BDD
 - Maven
 - JSONPath
 - JUnit/TestNG
 - Git & GitHub

## ✅ Features

- Built using Java, Maven, Rest Assured, and Cucumber BDD
- Covers CRUD operations: Create, Retrieve, Update, and Delete User
- Token-based authentication handled via config manager
- Scenario Outline used for data-driven PATCH and POST requests
- Uses Request and Response Specification Builders for reusability
- Externalized payload data and configuration
- Basic reporting via Cucumber HTML reports
- Modular folder structure with clear separation of concerns

---

## 🧪 Test Scenarios Covered

1. **Create a user** using POST request  
2. **Retrieve user details** using GET request  
3. **Update user fields** using PATCH request (data-driven)  
4. **Delete a user** using DELETE request  

---

## ⚙️ Configuration

Update `config.properties` in `src/test/resources` with your GoRest credentials:

properties
base_url=https://gorest.co.in/public/v2
token=your_bearer_token_here

---

## ▶️ How to Run

Using Test Runner (IDE):
- Run TestRunner.java using JUnit or TestNG.

---

## 📈 Future Enhancements
Allure or Extent Report Integration

Cucumber hooks 

Complex nested JSON payload handling using POJOs

Pagination, chaining, and validation enhancements

---

🤝 Author
Gaurang Gajjar
Email - gauranggajjar26@gmail.com

---



