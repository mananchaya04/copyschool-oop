public interface AssessGUI {
    void displayMessage(String message);

    double getScoreInput(String criteria);

    void displayScores(String[] teachers, double[][] scores);
}

