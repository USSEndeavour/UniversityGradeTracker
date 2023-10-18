package universitymanagement.models;

import java.util.ArrayList;
import universitymanagement.exceptions.*;

public class Faculty {
    private String name;
    private final ArrayList<Group> groups;

    // Constructor to initialize a faculty with a name and an empty list of groups.
    public Faculty(String name) {
        this.name = name;
        this.groups = new ArrayList<>();
    }

    // Getter method to retrieve the name of the faculty.
    public String getName() {
        return name;
    }

    // Getter method to retrieve the list of groups in the faculty.
    public ArrayList<Group> getGroups() {
        return groups;
    }

    // Method to add a group to the faculty.
    public void addGroup(Group group) {
        groups.add(group);
    }

    // Method to get a group.
    public Group getGroup(Group group) {
        Group targetGroup = groups.get(groups.indexOf(group));
        return targetGroup;
    }

    // Method to remove a group from the faculty.
    public void removeGroup(Group group) {
        groups.remove(group);
    }

    // Method to calculate the average grade for a specific subject within the faculty.
    // Throws NoGroupsException if the faculty has no groups.
    public float calculateAverageGradeForSubjectInFaculty(Subjects subjectName) throws InvalidGradeException, InvalidSubjectException, NoStudentsException, NoGroupsException {
        if (groups.size() == 0)
            throw new NoGroupsException(name + " has no groups.");

        float averageGrade = 0;
        int counter = 0;

        for (Group g: groups) {
            averageGrade += g.calculateAverageGradeForSubjectInGroup(subjectName);
            counter++;
        }

        return (float) averageGrade / counter;
    }

    // Override of the toString() method to provide a string representation of the faculty.
    @Override
    public String toString() {
        return "Faculty " + name;
    }
}
