# Student Halls Management System

## Overview
This project is a Java based application designed to manage student records for university halls. It provides a simple graphical user interface (GUI) that allows users to add, view, search, delete, save, and load student data.

The system was developed using object-oriented programming (OOP) principles and Java Swing for the user interface.

---

## Features
- Add new student records  
- Display all students in a structured format  
- Save student data to a file  
- Load data automatically when the program starts  
- Search students by name  
- Delete students by ID (with confirmation dialog)  
- Input validation to prevent empty entries  

---

##  Technologies Used
- Java  
- Java Swing (GUI)  
- File Handling (FileWriter, BufferedReader)  
- Object-Oriented Programming (OOP)  

---

## Project Structure
- `Student.java` → Represents a student object  
- `StudentHall.java` → Manages student list and operations  
- `HasamStudentHalls.java` → Main GUI and application logic  

---

##  How to Run
1. Open the project in Apache NetBeans  
2. Build the project  
3. Run `HasamStudentHalls.java`  
4. Use the GUI to interact with the system  

---

## Data Storage
Student data is stored in a text file (`students.txt`) using CSV format: StudentID,FirstName,LastName,Course,Year


## Future Improvements
- Add edit/update student feature  
- Improve search with partial matching  
- Replace file storage with a database  
- Enhance UI design with advanced layouts  

---

## Author
Hazem
