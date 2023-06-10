import java.util.Scanner;

public class Assess {
    private String[] teachers = {"Thai", "Eng", "Math", "Science"};
    private double[][] scores = new double[4][3];

    public void inputScores() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("** Evaluate the teacher's teaching by rating 1-5 **");
        for (int i = 0; i < teachers.length; i++) {
            System.out.println("Enter scores for " + teachers[i] + " teacher");

            System.out.print("1. Teaching materials and equipment: ");
            scores[i][0] = validateScoreInput(scanner);

            System.out.print("2. Suitability to level of knowledge and learner's ability: ");
            scores[i][1] = validateScoreInput(scanner);

            System.out.print("3. Coverage and alignment with purpose: ");
            scores[i][2] = validateScoreInput(scanner);

            System.out.println("-----------------------------------------------------------------");
        }
        scanner.close(); // Close the scanner after usage
    }

    private double validateScoreInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextDouble()) {
                double score = scanner.nextDouble();
                if (score >= 1 && score <= 5) {
                    return score;
                } else {
                    System.out.print("!!! Wrong number, please enter again: ");
                }
            } else {
                String input = scanner.next();
                System.out.print("!!! Invalid input, please enter a number: ");
            }
        }
    }

    public double[][] getScores() {
        return scores;
    }

    public static void main(String[] args) {
        Assess assess = new Assess();
        assess.inputScores();

        double[][] scores = assess.getScores();

        // Print the scores for verification
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Scores for " + assess.teachers[i] + " teacher:");
            for (int j = 0; j < scores[i].length; j++) {
                System.out.println("Criteria " + (j + 1) + ": " + scores[i][j]);
            }
            System.out.println("---------------------------------------");
        }
    }
}
