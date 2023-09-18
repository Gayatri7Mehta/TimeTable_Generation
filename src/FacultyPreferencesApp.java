import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class FacultyPreferencesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Faculty Preferences Collection");
        
        // Create a new Faculty object to store preferences
        Faculty faculty = new Faculty();

        System.out.print("Enter Faculty ID: ");
        faculty.setFacultyId(scanner.nextInt());

        System.out.print("Enter Faculty Name: ");
        faculty.setFacultyName(scanner.next());

        // Display the list of predefined subjects
        System.out.println("Choose a Subject from the List:");
        List<String> subjects = SubjectList.subjects;
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println((i + 1) + ". " + subjects.get(i));
        }

        // Collect preferred subjects in a loop
        System.out.println("Enter Preferred Subjects (type 'done' when finished):");
        String chosenSubject;
        while (true) {
            chosenSubject = scanner.next();
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

        // Display collected preferences
        System.out.println("\nFaculty ID: " + faculty.getFacultyId());
        System.out.println("Faculty Name: " + faculty.getFacultyName());
        System.out.println("Preferred Subjects: " + faculty.getPreferredSubjects());

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
        subjects.add("Mathematics");
        subjects.add("Science");
        subjects.add("History");
        subjects.add("English");
    }
}
