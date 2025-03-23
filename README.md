# Real Estate Rental Management System

**Personal Project | August 2024 - December 2024**

This is a personal project developed to strengthen my expertise in web backend development using **Java** and related technologies. All progress, including feature implementation and bug fixes, is tracked via commits across multiple branches in this GitHub repository.

## Table of Contents

- [Project Overview](#project-overview)
- [Branch Overview](#branch-overview)
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

## Branch Overview

This repository includes multiple branches, each representing different stages of development, implementation approaches, or specific feature sets. Below is a description of each branch:

| Branch Name                | Description                                                                                                                           |
|---------------------------|---------------------------------------------------------------------------------------------------------------------------------------|
| **main**                  | The primary and final branch. It includes both the **non-JWT project** (backend APIs only, no frontend) and the **spring-boot-web** project (fully integrated APIs and frontend UI). |
| **project-2**             | A dedicated branch for developing the **building search feature** with 16 searchable fields, independent of the main workflow.       |
| **using-map**             | Demonstrates the use of Java **Map** to receive a list of request parameters dynamically for filtering and searching data.             |
| **using-builder-pattern** | Applies the **Builder Pattern**, a well-known design pattern, to handle a list of request parameters for building dynamic search conditions. |
| **using-jpa**             | Focuses on data persistence using standard **Java Persistence API (JPA)** for ORM and database interaction.                           |
| **using-spring-data-jpa** | Integrates **Spring Data JPA** directly to simplify and optimize CRUD operations and database interactions.                           |
| **spring-boot-web**       | The base version of the complete **web application**, including backend APIs and frontend UI.                                         |
| **spring-boot-web-v2.0**  | An **optimized version** of the web application, integrating newer technologies (e.g., **Cascade**, **Kafka**, etc.) for improved performance and scalability. |

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
