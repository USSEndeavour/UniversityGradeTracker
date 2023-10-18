package universitymanagement.models;
import universitymanagement.exceptions.InvalidGradeException;

public class Subject {
    private Subjects name;
    private final int grade;

    // Constructor to initialize a subject with a name and grade.
    // Throws InvalidGradeException if the grade is not within the valid range (0 to 10).
    public Subject(Subjects name, int grade) throws InvalidGradeException {
        if (grade < 0 || grade > 10)
            throw new InvalidGradeException(name + ": the grade must accept a value between 0 and 10!");
        this.name = name;
        this.grade = grade;
    }

    // Getter method to retrieve the name of the subject.
    public Subjects getName() {
        return name;
    }

    // Getter method to retrieve the grade of the subject.
    public int getGrade() {
        return grade;
    }

    // Override of the toString() method to provide a string representation of the subject.
    @Override
    public String toString() {
        return "Subject: " + name + ", grade: " + grade;
    }
}
