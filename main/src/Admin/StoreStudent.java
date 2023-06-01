package Admin;

import java.util.Vector;

import Student.*;
public class StoreStudent {
    private static Vector<Student> students;
    public static String idCurrent;

    public StoreStudent(){
        students = new Vector<>();
        getStudent();
    }

    public void displayAll(){
        for(Student teacher: students){
            System.out.println("id :"+teacher.getId()+", password :"+teacher.getPassword());
        }
    }

    public static Vector<Student> getStudents() {
        return students;
    }

    public void getStudent(){
        students.add(new Student("001", "name_A", "surname_A", "01/01/2001", "Math","Math" ,"1"));
        students.add(new Student("002", "name_B", "surname_B", "02/02/2002", "Eng","Eng", "2"));
        students.add(new Student("003", "name_C", "surname_C", "03/03/2003", "Sci","Program", "3"));
        students.add(new Student("004", "name_D", "surname_D", "04/04/2004", "Math","Eng", "4"));
        students.add(new Student("005", "name_E", "surname_E", "05/05/2005", "Eng","Program", "5"));
    }

    public static void setStudent(String id,String name,String surname,String birth,String classRoom,String club,String password){
        students.add(new Student(id, name, surname, birth, classRoom, club, password));
    }


    public boolean checkId(String Id){
        for(Student student: students){
            if(Id.equals(student.getId())){
                return false;
            }
        }
        return true;
    }

    public static boolean checkLogin(String Id,String pass){
        for(Student student: students){
            if(Id.equals(student.getId()) && pass.equals(student.getPassword())){
                idCurrent = student.getId();
                return true;
            }
        }
        return false;
    }
}
