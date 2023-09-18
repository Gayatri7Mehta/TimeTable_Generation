package timetable_App;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class FacultyPreferencesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Taking Faculty Preferences");

        // Create a list to store faculty preferences
        List<Faculty> facultyList = new ArrayList<>();

        while (true) {
            // Create a new Faculty object to store preferences for each teacher
            Faculty faculty = new Faculty();

            System.out.print("Enter Faculty ID (or type 'done' to finish): ");
            String facultyIdInput = scanner.next();
            
            if (facultyIdInput.equals("done")) {
                break; // Exit the loop if 'done' is entered
            }

            int facultyId = Integer.parseInt(facultyIdInput);
            faculty.setFacultyId(facultyId);

            System.out.print("Enter Faculty Name: ");
            faculty.setFacultyName(scanner.next());

            // Display the list of predefined subjects
            System.out.println("Choose a Subject from the List:");
            List<String> subjects = SubjectList.subjects;
            for (int i = 0; i < subjects.size(); i++) {
                System.out.println((i + 1) + ". " + subjects.get(i));
            }

            // Collect preferred subjects in a loop
            System.out.println("Enter Preferred Subjects (type 'done' after subject preference is done. If faculty inputs are over write done again.):");
            while (true) {
                String chosenSubject = scanner.next();
                if (chosenSubject.equals("done")) {
                    break;
                }
                int subjectChoice = Integer.parseInt(chosenSubject);
                if (subjectChoice >= 1 && subjectChoice <= subjects.size()) {
                    String selectedSubject = subjects.get(subjectChoice - 1);
                    faculty.getPreferredSubjects().add(selectedSubject);
                    System.out.println("Added: " + selectedSubject);
                } else {
                    System.out.println("Invalid choice. Please choose from the list.");
                }
            }

            // Add the faculty preferences to the list
            facultyList.add(faculty);
        }

        // Display collected preferences for all faculties
        for (Faculty faculty : facultyList) {
            System.out.println("\nFaculty ID: " + faculty.getFacultyId());
            System.out.println("Faculty Name: " + faculty.getFacultyName());
            System.out.println("Preferred Subjects: " + faculty.getPreferredSubjects());
        }

        // Close the scanner
        scanner.close();
    }
}

class Faculty {
    private int facultyId;
    private String facultyName;
    private List<String> preferredSubjects = new ArrayList<>();

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public List<String> getPreferredSubjects() {
        return preferredSubjects;
    }
}

class SubjectList {
    public static List<String> subjects = new ArrayList<>();

    static {
        subjects.add("Enginerring Mathematics");
        subjects.add("PPL");
        subjects.add("Physics");
        subjects.add("OS");
        subjects.add("DSA");
        subjects.add("SEPM");
        subjects.add("Microprocessor");
        subjects.add("Compiler Design");
        subjects.add("Computer Graphics");
    }
}
