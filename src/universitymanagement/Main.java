package universitymanagement;
import universitymanagement.models.*;
import universitymanagement.exceptions.*;

public class Main {
    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the University Grade Tracker!");

        // Error Handling Section

        // Handling InvalidGradeException
        try {
            // Creating a subject with an invalid grade
            Subject english = new Subject(Subjects.English, 2);
            System.out.println(english.toString());

            // Attempting to create a subject with an invalid grade (expecting an exception)
            Subject math = new Subject(Subjects.Math, 12); // Invalid grade
        } catch (InvalidGradeException e) {
            // Printing the error message
            System.err.println("Error: " + e.getMessage());
        }

        // Handling ExistingSubjectException
        try {
            // Creating subjects
            Subject math = new Subject(Subjects.Math, 9);
            Subject math1 = new Subject(Subjects.Math, 8);

            try {
                // Creating a student and attempting to enroll in the same subject twice (expecting an exception)
                Student alex = new Student("Alex");
                alex.addSubject(math);
                alex.addSubject(math1); // Already enrolled in the course
            } catch (ExistingSubjectException e) {
                // Printing the error message
                System.err.println("Error: " + e.getMessage());
            }
        } catch (InvalidGradeException e) {
            // Printing the error message
            System.err.println("Error: " + e.getMessage());
        }

        // Handling NoSubjectsException
        try {
            // Creating a student without any subjects assigned (expecting an exception)
            Student alex = new Student("Alex"); // No subjects assigned
            alex.calculateAverageGrade();
        } catch (NoSubjectsException e) {
            // Printing the error message
            System.err.println("Error: " + e.getMessage());
        }

        // Handling NoStudentsException
        try {
            // Creating a group and attempting to calculate the average grade without students (expecting an exception)
            Group group = new Group("Phys01");
            group.calculateAverageGradeForSubjectInGroup(Subjects.Test);
        } catch (InvalidGradeException | InvalidSubjectException | NoStudentsException e) {
            // Printing the error message
            System.err.println("Error: " + e.getMessage());
        }

        // Handling NoGroupsException
        try {
            // Creating a faculty and attempting to calculate the average grade without groups (expecting an exception)
            Faculty faculty = new Faculty("Physics");
            faculty.calculateAverageGradeForSubjectInFaculty(Subjects.Test);
        } catch (InvalidGradeException | InvalidSubjectException | NoStudentsException | NoGroupsException e) {
            // Printing the error message
            System.err.println("Error: " + e.getMessage());
        }

        // Handling NoFacultiesException
        try {
            // Creating an university and attempting to calculate the average grade without groups (expecting an exception)
            University university = new University("CalTech University");
            university.calculateAverageGradeForSubjectInUniversity(Subjects.Test);
        } catch (InvalidGradeException | InvalidSubjectException | NoStudentsException | NoGroupsException | NoFacultiesException e) {
            // Printing the error message
            System.err.println("Error: " + e.getMessage());
        }

        // Logic Demonstration Section

        // 1. Calculate the average grade for all subjects of a student
        try {
            // Creating a subject with a valid grade
            Subject english = new Subject(Subjects.English, 2);
            Subject physics = new Subject(Subjects.Physics, 10);
            try {
                Student mark = new Student("Mark");
                mark.addSubject(english);
                mark.addSubject(physics);
                System.out.println(mark.toString() + ", average grade: " + mark.calculateAverageGrade());
            } catch (ExistingSubjectException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (NoSubjectsException e) {
                System.err.println("Error: " + e.getMessage());
            }
        } catch (InvalidGradeException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // 2. Calculate the average grade for a subject for the entire university.
        // 3. Calculate the average grade for a specific subject within a particular group and faculty.
        try {
            // Creating subjects with valid grades
            Subject english = new Subject(Subjects.English, 2);
            Subject english1 = new Subject(Subjects.English, 7);
            Subject physics = new Subject(Subjects.Physics, 10);
            Subject physics1 = new Subject(Subjects.Physics, 9);
            Subject math = new Subject(Subjects.Math, 8);
            Subject math1 = new Subject(Subjects.Math, 5);
            try {
                // Creating students and assigning subjects
                Student alex = new Student("Alex");
                Student seun = new Student("Seun");
                Student bill = new Student("Bill");

                alex.addSubject(english);
                alex.addSubject(physics);
                seun.addSubject(math1);
                seun.addSubject(physics1);
                bill.addSubject(english1);
                bill.addSubject(math);

                // Creating groups and adding students
                Group phys01 = new Group("Phys");
                Group math01 = new Group("Math");
                phys01.addStudent(alex);
                phys01.addStudent(seun);
                math01.addStudent(bill);

                // Creating a faculty and adding groups
                Faculty faculty = new Faculty("Physics");
                faculty.addGroup(phys01);
                faculty.addGroup(math01);

                // Creating a university and adding a faculty
                University university = new University("CalTech University");
                university.addFaculty(faculty);

                try {
                    // Calculating and displaying the average grade for a specific subject in the university
                    System.out.println(university.toString() + ", English average grade across all students: " +
                            university.calculateAverageGradeForSubjectInUniversity(Subjects.English));

                    // Calculate the average grade for a specific subject within a particular group and faculty.
                    System.out.println(university.toString() + ", English average grade across the Physics faculty and phys01 group: " +
                            university.calculateAverageGradeForSubjectInFacultyAndGroup(Subjects.Physics, faculty, phys01));

                } catch (InvalidSubjectException | NoStudentsException | NoGroupsException | NoFacultiesException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            } catch (ExistingSubjectException e) {
                System.err.println("Error: " + e.getMessage());
            }
        } catch (InvalidGradeException e) {
            // Printing the error message
            System.err.println("Error: " + e.getMessage());
        }
    }
}
