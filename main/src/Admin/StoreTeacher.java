package Admin;

import java.util.Vector;
import Teacher.Teacher;

public class StoreTeacher {
    private static Vector<Teacher> teachers;
    public static String idCurrent,courseCurrent;

    public StoreTeacher(){
        teachers = new Vector<>();
        getTeacherOld();
    }

    public void displayAll(){
        for(Teacher teacher: teachers){
            System.out.println("id :"+teacher.getId()+", password :"+teacher.getPassword());
        }
    }

    public static Vector<Teacher> getTeachersVector() {
        return teachers;
    }

    public void getTeacherOld(){
        teachers.add(new Teacher("1001", "name_A", "surname_A", "01/01/2001", "Math", "1"));
        teachers.add(new Teacher("1002", "name_B", "surname_B", "02/02/2002", "Eng", "2"));
        teachers.add(new Teacher("1003", "name_C", "surname_C", "03/03/2003", "Sci", "3"));
    }

    public static void setTeacher(String id,String name,String surname,String birth,String course,String password){
        teachers.add(new Teacher(id, name, surname, birth, course, password));
    }


    public boolean checkId(String Id){
        for(Teacher teacher: teachers){
            if(Id.equals(teacher.getId())){
                return false;
            }
        }
        return true;
    }

    public static boolean checkLogin(String Id,String pass){
        for(Teacher teacher: teachers){
            if(Id.equals(teacher.getId()) && pass.equals(teacher.getPassword())){
                idCurrent = teacher.getId();
                courseCurrent = teacher.getCourse();
                return true;
            }
        }
        return false;
    }
}



