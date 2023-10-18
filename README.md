# University Grade Tracker

This Java project implements a university management system where students, grouped into faculties and further into groups, are enrolled in various subjects and receive grades. The project demonstrates the creation and handling of custom exceptions and includes logic for calculating average grades at different levels of the university hierarchy.

## Task Overview

In the university, there are several faculties where students study, grouped into various groups. Each student has multiple subjects for which they receive grades. A hierarchy of students, groups, and faculties was implemented.

The following logic was implemented:
- Calculation of the average grade for all subjects of a student.
- Calculation of the average grade for a specific subject within a specific group and on a specific faculty.
- Calculation of the average grade for a subject across the entire university.

Implementation of the following exceptions was provided:

- `InvalidGradeException`: When a grade is below 0 or above 10.
- `NoSubjectsException`: When a student has no subjects (they must have at least one).
- `NoStudentsException`: When there are no students in a group.
- `NoGroupsException`: When there are no groups in a faculty.
- `NoFacultiesException`: When there are no faculties in the university.

## Project Structure

The project is organized as follows:

- `src/` - Contains the Java source code for the project.
    - `universitymanagement/` - The main package for the project.
        - `Main.java` - The entry point for the program.
        - `models/` - Contains Java classes for representing the university hierarchy.
        - `exceptions/` - Contains custom exception classes.
- `LICENSE` - The license file for the project.
- `README.md` - This README file.

## How to Use

To compile and run the project from the `src` folder, execute the following commands:

```shell
javac universitymanagement/Main.java
java universitymanagement/Main
