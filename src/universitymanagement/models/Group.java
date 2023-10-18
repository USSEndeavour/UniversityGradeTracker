package universitymanagement.models;

import java.util.ArrayList;
import universitymanagement.exceptions.NoStudentsException;
import universitymanagement.exceptions.InvalidGradeException;
import universitymanagement.exceptions.InvalidSubjectException;

public class Group {
    private String name;
    private ArrayList<Student> students;

    // Constructor to initialize a group with a name and an empty list of students.
    public Group(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    // Getter method to retrieve the name of the group.
    public String getName() {
        return name;
    }

    // Method to add a student to the group.
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to remove a student from the group.
    public void removeStudent(Student student) {
        students.remove(student);
    }

    // Getter method to retrieve the list of students in the group.
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Calculate the average grade for a specific subject within the group.
     *
     * @param subjectName The name of the subject for which to calculate the average grade.
     * @return The average grade for the specified subject in the group.
     * @throws NoStudentsException    If the group has no students.
     * @throws InvalidSubjectException If an invalid subject name is provided.
     * @throws InvalidGradeException  If an invalid grade is encountered.
     */
    public float calculateAverageGradeForSubjectInGroup(Subjects subjectName)
            throws NoStudentsException, InvalidSubjectException, InvalidGradeException {

        if (students.size() == 0)
            throw new NoStudentsException(name + " has no students.");

        float averageGrade = 0;
        int counter = 0;

        for (Student s : students) {
            if (s.isEnrolled(subjectName)) {
                averageGrade += (s.getSubject(subjectName)).getGrade();
                counter++;
            }
        }

        return averageGrade / counter;
    }
}
