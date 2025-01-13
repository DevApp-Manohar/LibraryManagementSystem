LLD-Assignment1
Backend Engineering Launchpad Cohort 10

# Library Management System

## Overview
The **Library Management System** is a console-based Java application that helps manage a library's books and patrons. It allows users to perform operations like adding books, registering patrons, checking out books, and returning books. The system follows the **Observer design pattern** to notify users when books become available.

## Features
- Add and remove books from the library
- Search for books by ISBN
- List all available books
- Register patrons in the system
- Borrow and return books
- Notify users when a book becomes available
- Maintain a borrow history for patrons

## Technologies Used
- **Java** (JDK 8+)
- **Object-Oriented Programming (OOP)** principles
- **Observer Design Pattern**

## Class Structure
### Classes and Their Roles:

1. **LibraryBook** - Represents a book with attributes like title, author, ISBN, year, and availability.
2. **BookCreator** - Factory class responsible for creating `LibraryBook` objects.
3. **BookAvailabilityManager** - Tracks book availability and notifies interested patrons when books become available.
4. **LibraryManager** - Handles book and patron management, including checkouts and returns.
5. **LibraryManagementSystem** - The main class that provides a console-based menu for interacting with the system.
6. **NotificationListener** - Interface for classes that want to receive updates when books become available.
7. **LibraryUser** - Represents a library patron with borrowing capabilities.
8. **EventPublisher** - Manages observer subscriptions and notifications.

## Class Diagram
Below is a simplified **UML Class Diagram** showing the relationships between classes:

```
         +-----------------------+
         |    LibraryManagementSystem    |
         +-----------------------+
                      |
                      v
         +-------------------+
         |    LibraryManager  |
         +-------------------+
                |        |         |
                v        v         v
+-----------------+  +-----------------+  +--------------------+
|  LibraryBook    |  |  LibraryUser     |  |  BookCreator      |
+-----------------+  +-----------------+  +--------------------+
       |                 |          |
       v                 v          v
+-----------------------+
| BookAvailabilityManager |
+-----------------------+
                |
                v
+---------------------+
|   EventPublisher   |
+---------------------+
                |
                v
+---------------------+
| NotificationListener |
+---------------------+
```

## How to Run the Project
1. Clone the repository or download the project files.
2. Open the project in any Java IDE (Eclipse, IntelliJ, etc.).
3. Ensure you have **Java 8+** installed.
4. Run `LibraryManagementSystem.java`.
5. Follow the console menu to interact with the system.


