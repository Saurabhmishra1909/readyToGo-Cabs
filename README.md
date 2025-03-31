# ReadyToGo- Cab Booking System - Spring Boot Backend

## 1. Project Overview
The **Cab Booking System** is a backend service developed using **Spring Boot** that enables customers to book cabs, drivers to register their vehicles, and admins to manage bookings. The system includes customer and driver management functionalities, real-time booking confirmations via email, and integration with **JPA and Hibernate** for database interactions. 

## 2. Technology Stack
- **Backend Framework:** Spring Boot
- **Database:** MySQL/PostgreSQL (via JPA & Hibernate)
- **API Testing:** Postman
- **Dependency Injection:** Spring Boot @Autowired
- **Email Service:** JavaMailSender
- **Build Tool:** Maven/Gradle

## 3. System Architecture
The system follows a **RESTful API** architecture with the following components:
- **Controllers:** Handle incoming HTTP requests.
- **Services:** Contain business logic for cab bookings, customers, and drivers.
- **Repositories:** Communicate with the database via JPA.
- **Entities:** Represent database tables.
- **Email Service:** Sends booking confirmation emails to customers.

## 4. Features & Endpoints

### 4.1 Booking Management
- **Book a Cab:**
  ```http
  POST /booking/book/{customerId}
  ```
  - Request Body: BookingRequest
  - Response: BookingResponse
  - Sends confirmation email upon successful booking.

### 4.2 Cab Management
- **Register a Cab:**
  ```http
  POST /cab/register/{driverId}
  ```
  - Registers a new cab under a specific driver.
  
- **Get Available Cabs:**
  ```http
  GET /cab/availableCabs
  ```
  - Returns a list of cabs available for booking.

### 4.3 Customer Management
- **Add a New Customer:**
  ```http
  POST /customer/add
  ```
  - Registers a new customer.
  
- **Get Customer By ID:**
  ```http
  GET /customer/get/customerId/{customerId}
  ```
  - Retrieves customer details based on ID.

- **Get Customers by Gender:**
  ```http
  GET /customer/get/{gender}
  ```
  - Fetches all customers filtered by gender.

- **Filter Customers by Age & Gender:**
  ```http
  GET /customer/get?gender={gender}&age={age}
  ```
  - Returns customers of a specific gender and age.

### 4.4 Driver Management
- **Add a New Driver:**
  ```http
  POST /driver/add
  ```
  - Registers a new driver.
  
- **Get Driver by ID:**
  ```http
  GET /driver/get/driverId/{driverId}
  ```
  - Retrieves driver details based on ID.

- **Get Drivers by Phone Number:**
  ```http
  GET /driver/get/driverNumber/{driverPhone}
  ```
  - Fetches driver details using phone number.

- **Filter Drivers by Gender:**
  ```http
  GET /driver/get/gender/{gender}
  ```
  - Returns a list of drivers based on gender.

## 5. Database Schema
The project utilizes **JPA & Hibernate** to interact with a relational database. The key entities include:

### Booking Entity
- **bookingID (PK, Auto-generated)**
- **source (String)**
- **destination (String)**
- **fare (Double)**
- **distanceInKm (Double)**
- **status (Enum - TripStatus)**
- **bookedAt (Timestamp - Creation Timestamp)**
- **lastUpdatedAt (Timestamp - Update Timestamp)**

### Cab Entity
- **cabID (PK, Auto-generated)**
- **cabNumber (Unique, Non-nullable, String)**
- **model (String)**
- **ratePerKm (Double)**
- **isAvailable (Boolean)**

### Customer Entity
- **customerID (PK, Auto-generated)**
- **name (String)**
- **age (Integer)**
- **email (Unique, Non-nullable, String)**
- **phone (Unique, Non-nullable, String)**
- **gender (Enum - Gender)**
- **bookings (OneToMany Relationship with Booking)**

### Driver Entity
- **driverID (PK, Auto-generated)**
- **name (String)**
- **age (Integer)**
- **email (Unique, Non-nullable, String)**
- **phone (Unique, Non-nullable, String)**
- **gender (Enum - Gender)**
- **cab (OneToOne Relationship with Cab, Unique)**
- **bookings (OneToMany Relationship with Booking)**

## 6. API Testing
All API endpoints were tested using **Postman**, verifying:
- Request validation
- Successful responses (200/201 HTTP status codes)
- Error handling (400/404 for bad requests)

## 7. Future Enhancements
- **Payment Integration:** Enable online payments for cab bookings.
- **Ride Tracking:** Add GPS-based tracking for booked rides.
- **Mobile App Support:** Develop frontend integration for mobile users.
- **Rating & Reviews:** Allow customers to rate drivers.

## 8. Conclusion
The **Cab Booking System** provides a structured and efficient backend for managing cab services. By leveraging **Spring Boot, JPA, Hibernate, and JavaMailSender**, the system ensures seamless bookings and effective customer-driver interactions. Future improvements can further enhance its usability and scalability.

