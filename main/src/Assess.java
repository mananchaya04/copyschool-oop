import java.util.Scanner;

public class Assess {
    private String[] teachers = {"Thai", "Eng", "Math", "Science"};
    double[][] scores = new double[4][3];

    public String[] getTeachers() {
        return teachers;
    }

    public void setTeachers(String[] teachers) {
        this.teachers = teachers;
    }

    public void inputScores() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < teachers.length; i++) {
            System.out.println("Enter scores for teacher " + teachers[i]);
            System.out.print("teaching materials and equipment: ");
            scores[i][0] = scanner.nextDouble();
            System.out.print("suitability to level of knowledge and learner's ability: ");
            scores[i][1] = scanner.nextDouble();
            System.out.print("Coverage and alignment with purpose: ");
            scores[i][2] = scanner.nextDouble();
            System.out.println("--------------------------------------");
        }
    }

    public static void main(String[] args) {
        Assess assess = new Assess();
        assess.inputScores();
    }
}
