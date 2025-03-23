# Real Estate Rental Management System

**Personal Project | August 2024 - December 2024**

This is a personal project developed to strengthen my expertise in web backend development using **Java** and related technologies. All progress, including feature implementation and bug fixes, is tracked via commits across multiple branches in this GitHub repository.

## Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Core Functionalities](#core-functionalities)
- [Installation](#installation)
- [Usage](#usage)
- [Repository](#repository)
- [License](#license)

---

## Project Overview

A web-based system for managing real estate rentals, including user authentication, building and customer management, transaction handling, and staff assignments. The project simulates real-world workflows and prioritizes security and scalability.

---

## Technologies Used

### Backend:
- Java
- Spring MVC
- Spring Security
- Spring Data JPA
- JPA (Java Persistence API)
- JWT (JSON Web Token)
- Spring Profiles
- MySQL
- Kafka

### Frontend:
- HTML5
- CSS3
- JavaScript
- Bootstrap
- JQuery
- Ajax

---

## Core Functionalities

- **Authentication & Authorization**:  
  - User login, registration  
  - Role-based access control using Spring Security + JWT

- **Search Capabilities**:  
  - Buildings: 16 searchable fields  
  - Customers: 6 searchable fields  
  - Accounts: 2 searchable fields  

- **Data Management**:  
  - Full CRUD operations for buildings, customers, and accounts  
  - Assign buildings to specific management staff

- **Transactions**:  
  - Handle and track multiple transactions between customers and staff

- **Customer Interaction**:  
  - Allow customers to leave contact info for inquiries or consultations

---

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/dinhduc0794/real-estate-rental-mgmt.git
   cd real-estate-rental-mgmt
   ```

2. Configure the database:
   - Set up a MySQL database and update connection parameters in `application.properties` or `application.yml`.

3. Build the backend:
   ```bash
   ./mvnw clean install
   ```

4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

---

## Usage

1. Access the frontend via browser at `http://localhost:8080`.
2. Use available endpoints for building, customer, and account management.
3. Kafka integration handles asynchronous event processing (e.g., notifications, logging).

---

## Repository

GitHub Repository: [github.com/dinhduc0794/real-estate-rental-mgmt](https://github.com/dinhduc0794/real-estate-rental-mgmt)

---

## License

This project is for personal educational use and is not licensed for commercial use.
