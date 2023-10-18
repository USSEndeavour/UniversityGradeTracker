package universitymanagement.models;

import java.util.ArrayList;
import universitymanagement.exceptions.NoSubjectsException;
import universitymanagement.exceptions.InvalidSubjectException;
import universitymanagement.exceptions.InvalidGradeException;
import universitymanagement.exceptions.ExistingSubjectException;

public class Student {
    private String name;
    private final ArrayList<Subject> subjects;

    // Constructor to initialize a Student with a name and an empty list of subjects.
    public Student(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    // Getter method to retrieve the name of the student.
    public String getName() {
        return name;
    }

    // Method to add a subject to the student's list of subjects.
    // Throws ExistingSubjectException if the subject with the same name already exists in the list.
    public void addSubject(Subject subject) throws ExistingSubjectException {
        boolean flag = false;
        for (Subject s: subjects) {
            if (s.getName().equals(subject.getName())) {
                flag = true;
                break;
            }
        }

        if (flag)
            throw new ExistingSubjectException(name + " is already enrolled in the " + subject.getName() + " course!");

        subjects.add(subject);
    }

    // Method to remove a subject from the student's list of subjects.
    public void removeSubject(Subject subject) {
        subjects.remove(subject);
    }

    // Getter method to retrieve the list of subjects that the student is enrolled in.
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    // Method to get a specific subject by its name.
    // Throws InvalidSubjectException if the subject with the given name is not found.
    public Subject getSubject(Subjects subjectName) throws InvalidSubjectException, InvalidGradeException {

        Subject subject = new Subject(Subjects.Test, 0);

        boolean flag = false;
        for (Subject s: subjects) {
            if (s.getName().equals(subjectName)) {
                flag = true;
                break;
            }
        }

        if (!flag)
            throw new InvalidSubjectException(name + " does not attend the " + subjectName + " subject!");

        for (Subject s: subjects) {
            if (s.getName().equals(subjectName))
                subject = s;
        }

        return subject;
    }

    // Method to check if the student is enrolled in a specific subject.
    public boolean isEnrolled(Subjects subjectName) {
        boolean flag = false;

        for (Subject s: subjects) {
            if (s.getName().equals(subjectName)) {
                flag = true;
            }
        }

        return flag;
    }

    // Method to calculate the average grade of the student based on their enrolled subjects.
    // Throws NoSubjectsException if the student has no enrolled subjects.
    public float calculateAverageGrade() throws NoSubjectsException {
        if (subjects.size() == 0)
            throw new NoSubjectsException(name + " does not have any subjects.");

        float averageGrade = 0;
        for (Subject s: subjects) {
            averageGrade += s.getGrade();
        }
        return (float) averageGrade/subjects.size();
    }

    // Override of the toString() method to provide a string representation of the student.
    @Override
    public String toString() {
        return "Student " + name;
    }
}
