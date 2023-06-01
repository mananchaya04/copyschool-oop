package Teacher;

public class advisorTeach extends Teacher{
    private String classRoom;
    public advisorTeach(String id, String name, String surname, String birth,String classRoom) {
        super(id, name, surname, birth);
        this.classRoom = classRoom;
    }
}

