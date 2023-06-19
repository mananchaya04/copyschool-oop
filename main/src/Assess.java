import java.util.Scanner;

public class Assess {
    private String[] teachers = {"Thai", "Eng", "Math", "Science"};
    private double[][] scores = new double[4][3];
    private AssessGUI gui; // Reference to the AssessGUI interface

    public void setInputGUI(AssessGUI gui) {
        this.gui = gui;
    }

    public void inputScores() {
        gui.displayMessage("** Evaluate the teacher's teaching by rating 1-5 **");

        for (int i = 0; i < teachers.length; i++) {
            gui.displayMessage("Enter scores for " + teachers[i] + " teacher");

            scores[i][0] = gui.getScoreInput("Teaching materials and equipment");
            scores[i][1] = gui.getScoreInput("Suitability to level of knowledge and learner's ability");
            scores[i][2] = gui.getScoreInput("Coverage and alignment with purpose");

            gui.displayMessage("-----------------------------------------------------------------");
        }
    }

    public void displayScores() {
        gui.displayScores(teachers, scores);
    }

    public double[][] getScores() {
        return scores;
    }

    public static void main(String[] args) {
        Assess assess = new Assess();
        AssessGUI gui = new AssessGUI() {
            @Override
            public void displayMessage(String message) {

            }

            @Override
            public double getScoreInput(String criteria) {
                return 0;
            }

            @Override
            public void displayScores(String[] teachers, double[][] scores) {

            }
        }; // Create an instance of the GUI interface
        assess.setInputGUI(gui); // Set the GUI interface for the Assess class

        assess.inputScores();
        assess.displayScores();
    }
}

