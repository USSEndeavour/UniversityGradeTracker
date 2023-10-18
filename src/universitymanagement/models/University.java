package universitymanagement.models;

import java.util.ArrayList;
import universitymanagement.exceptions.*;

public class University {
    private String name;
    private final ArrayList<Faculty> faculties;

    // Constructor to initialize a university with a name and an empty list of faculties.
    public University(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }

    // Getter method to retrieve the name of the university.
    public String getName() {
        return name;
    }

    // Getter method to retrieve the list of faculties in the university.
    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    // Method to add a faculty to the university.
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    // Method to remove a faculty from the university.
    public void removeFaculty(Faculty faculty) {
        faculties.remove(faculty);
    }

    // Method to calculate the average grade for a specific subject across all faculties in the university.
    // Throws NoFacultiesException if the university has no faculties.
    public float calculateAverageGradeForSubjectInUniversity(Subjects subjectName)
            throws InvalidGradeException, InvalidSubjectException, NoStudentsException, NoGroupsException, NoFacultiesException {
        if (faculties.size() == 0)
            throw new NoFacultiesException(name + " has no faculties.");

        float averageGrade = 0;
        int counter = 0;

        for (Faculty f: faculties) {
            averageGrade += f.calculateAverageGradeForSubjectInFaculty(subjectName);
            counter++;
        }

        return averageGrade / counter;
    }

    // Method to calculate the average grade for a specific subject within a specific group and on a specific faculty.
    public float calculateAverageGradeForSubjectInFacultyAndGroup(Subjects subjectName, Faculty faculty, Group group)
            throws InvalidGradeException, InvalidSubjectException, NoStudentsException, NoFacultiesException {
        if (faculties.size() == 0)
            throw new NoFacultiesException(name + " has no faculties.");

        Faculty targetFaculty = faculties.get(faculties.indexOf(faculty));
        Group targetGroup = targetFaculty.getGroup(group);

        float averageGrade = targetGroup.calculateAverageGradeForSubjectInGroup(subjectName);

        return averageGrade;
    }

    // Override of the toString() method to provide a string representation of the university.
    @Override
    public String toString() {
        return "University: " + name;
    }
}
