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
        System.out.println("** Evaluate the teacher's teaching by rating 1-5 **");
        for (int i = 0; i < teachers.length; i++) {
            System.out.println("Enter scores for " + teachers[i] + " teacher");

            System.out.print("1.teaching materials and equipment : ");
            scores[i][0] = validateScoreInput(scanner);

            System.out.print("2. suitability to level of knowledge and learner's ability : ");
            scores[i][1] = validateScoreInput(scanner);

            System.out.print("3. Coverage and alignment with purpose : ");
            scores[i][2] = validateScoreInput(scanner);

            System.out.println("-----------------------------------------------------------------");
        }
    }

    private double validateScoreInput(Scanner scanner) {
        while (true) {
            double score = scanner.nextDouble();
            if (score >= 1 && score <= 5) {
                return score;
            } else {
                System.out.print(" !!! Wrong number, please enter again : ");
            }
        }
    }

    public static void main(String[] args) {
        Assess assess = new Assess();
        assess.inputScores();
    }
}
