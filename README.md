# Smart-Campus-Portal
A Java-based Smart Campus Portal that integrates JavaFX, JDBC, Servlets, OOP, Collections, and Multithreading to manage attendance, results, announcements, and feedback with role-based secure access.
# Smart Campus Portal
## Project Overview
Smart Campus Portal is a JavaFX-based desktop application that manages students, faculty, and admin operations in a campus. It provides a clean, user-friendly interface to handle tasks such as:
![image alt](https://github.com/Rookiecoder07/Smart-Campus-Portal/blob/7de67d773e3f13ef31d5d1b5c52f8346364a9122/image3.png)


- User login and authentication
- Role-based dashboards for Students, Admins, and Faculty
- CRUD operations on users and data
- Secure password handling (default password for all users)
- Smooth navigation between interfaces
![Login credentials](https://github.com/Rookiecoder07/Smart-Campus-Portal/blob/7de67d773e3f13ef31d5d1b5c52f8346364a9122/image2.jpg)
This project is designed as a mini campus management system for academic purposes and learning JavaFX with MySQL integration.

---

## Features

### Student
- View personal information
- Access courses and schedules
- Logout functionality

### Admin
- Manage students, faculty, and users
- Add, update, delete user data
- Generate reports

### Faculty
- View assigned courses and students
- Manage class-related data
- Logout functionality

---

## Technologies Used
- **Java 23**  
- **JavaFX 25** for UI  
- **MySQL** for database management  
- **JDBC** for connecting Java to MySQL  
- **IntelliJ IDEA** as the IDE

---

## Project Structure
SmartCampusPortal/
│
├── src/
│ ├── controller/ # All Java controllers for FXML

│ ├── model/ # Java classes representing database entities
│ ├── util/ # Utility classes (DB connection, etc.)
│ └── view/ # FXML files for UI
│
├── lib/ # All external libraries (JavaFX, MySQL connector)
├── images/ # Screenshots for README
└── README.md

