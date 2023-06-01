package Teacher;

import java.util.Vector;
import GUI.*;
import Admin.*;

public class Teacher {
    private String id;
    private String name;
    private String surname;
    private String birth;
    private String course;
    private String password;

    public Teacher(String id,String password){
        this.id = id;
        this.password = password;
        name = "-";
        surname = "-";
        birth = "-/-/-";
    }
    public Teacher(String id,String name,String surname,String birth){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birth = birth;

    }
    public Teacher(String id,String name,String surname,String birth,String course,String password){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.course = course;
        this.password = password;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    public void setCourse(String course) {
        this.course = course;
    }

    public String getBirth() {
        return birth;
    }
    public String getCourse() {
        return course;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPassword() {
        return password;
    }

    public void display() {
        System.out.print("Hello ! "+name +" "+ surname);
    }
}
