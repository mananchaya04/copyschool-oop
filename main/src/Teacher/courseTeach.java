package Teacher;

public class courseTeach extends Teacher{
    private String course;
    public courseTeach(String id, String name, String surname, String birth, String course){
        super(id, name, surname, birth);
        this.course = course;
    }

    @Override
    public void display() {
        super.display();
    }
}