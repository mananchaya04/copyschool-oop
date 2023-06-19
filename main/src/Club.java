import Student.Student;
import java.util.Scanner;

public class Club {
    private String studentId;
    private Student student;
    private String club;
    private static Student[] students; // Assuming an array of Student objects is available

    public Club(Student[] students) {
        this.students = students;
    }

    public String getStudentID() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public Student findStudentById(String targetId) {
        for (Student student : students) {
            if (student.getId().equals(targetId)) {
                return student;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Student[] students = {}; // Assuming an array of Student objects is available
        Club club = new Club(students);
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your student ID:");
        String studentId = input.next();

        Student targetStudent = club.findStudentById(studentId);

        if (targetStudent != null) {
            System.out.println("Choose Your Club:");
            System.out.println("1. English");
            System.out.println("2. Program");
            System.out.println("3. Maths");
            System.out.println("4. Science");
            System.out.println("5. Sport");

            int number = input.nextInt();

            if (number == 1) {
                targetStudent.setClub("English");
            } else if (number == 2) {
                targetStudent.setClub("Program");
            } else if (number == 3) {
                targetStudent.setClub("Maths");
            } else if (number == 4) {
                targetStudent.setClub("Science");
            } else if (number == 5) {
                targetStudent.setClub("Sport");
            }

            System.out.println("Joined Club: " + targetStudent.getClub());
        } else {
            System.out.println("Invalid ID");
        }
    }
}
