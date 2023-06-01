package Function;


public class Assignment {
    protected String title;
    protected String submissionDate;
    protected String dueDate;
    protected int grade;
    protected String feedback;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Assignment(String title, String submissionDate, String dueDate) {
        this.title = title;
        this.submissionDate = submissionDate;
        this.dueDate = dueDate;
        this.feedback = null;
    }
}

