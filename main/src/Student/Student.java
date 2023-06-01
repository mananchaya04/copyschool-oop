package Student;

import Function.Assignment;
import Function.GradeCal;

import java.util.ArrayList;

public class Student {
    private String name;
    private String surname;
    private String id;
    private String birth;
    private String classRoom;
    private String club;
    private String password;
    private String gradeAlphapets = "F";
    private double grade[] = {0,0,0,0,0}; // [0] = mid, [1] = work, [2] = pro, [3] = final, [4] = sum
    private String attendScore="0",mindScore="100";
    private double[] engSub;
    private double[] mathSub;
    private double[] thaiSub;
    private ArrayList<Assignment> assignments;


    // Add Grade
    public Student(String id,String name, String surname, String birth,String classRoom,String club,String password,String attend,String mind,double grade2[]){
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.classRoom = classRoom;
        this.attendScore = attend;
        this.mindScore = mind;
        this.club = club;
        this.password = password;
        this.birth = birth;
        this.attendScore = attend;
        this.mindScore = mind;
        for(int i=0;i<grade2.length;i++){
            this.grade[i] = grade2[i];
        }
        gradeAlphapets = GradeCal.gradeCal(grade2[0], grade2[1], grade2[2], grade2[3]);
        grade[4] = GradeCal.getTotal(grade2[0], grade2[1], grade2[2], grade2[3]);
    }

    // Add Mind Score And Attendend Score
    public Student(String id,String name, String surname, String birth,String classRoom,String club,String password,String attend,String mind){
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.classRoom = classRoom;
        this.attendScore = attend;
        this.mindScore = mind;
        this.club = club;
        this.password = password;
        this.birth = birth;
        this.attendScore = attend;
        this.mindScore = mind;
    }

    // Create ID Of Students
    public Student(String id, String name, String surname, String birth, String classRoom, String club, String password) {

        this.name = name;
        this.surname = surname;
        this.id = id;
        this.birth = birth;
        this.classRoom = classRoom;
        this.club = club;
        this.password = password;
    }

    public Student(String name, String surname, String id, String birth, double[] engSub, double[] mathSub, double[] thaiSub) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.birth = birth;
        this.engSub = engSub;
        this.mathSub = mathSub;
        this.thaiSub = thaiSub;
    }

    public Student(String id, String name, String birth, String classRoom, String club, String password){
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.classRoom = classRoom;
        this.club = club;
        this.password = password;
    }


    public String getGradeAlphapets() {
        return gradeAlphapets;
    }
    public double getMid() {
        return grade[0];
    }
    public double getWork() {
        return grade[1];
    }
    public double getPro() {
        return grade[2];
    }
    public double getFin() {
        return grade[3];
    }
    public double getSumScore() {
        return grade[4];
    }
    public double[] getEngSub() {
        return engSub;
    }

    public void setEngSub(double[] engSub) {
        this.engSub = engSub;
    }

    public double[] getMathSub() {
        return mathSub;
    }

    public void setMathSub(double[] mathSub) {
        this.mathSub = mathSub;
    }

    public double[] getThaiSub() {
        return thaiSub;
    }

    public void setThaiSub(double[] thaiSub) {
        this.thaiSub = thaiSub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public String getAttendScore() {
        return attendScore;
    }
    public String getMindScore() {
        return mindScore;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBirth() {
        return birth;
    }

    public String getClassRoom() {
        return classRoom;
    }
    public String getClub() {
        return club;
    }
    public double[] getGrade() {
        return grade;
    }
    public String getPassword() {
        return password;
    }
    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
    public void setClub(String club) {
        this.club = club;
    }
    public void setGrade(double[] grade) {
        this.grade = grade;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public void setAttendScore(String attendScore) {
        this.attendScore = attendScore;
    }
    public void setMindScore(String mindScore) {
        this.mindScore = mindScore;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;

    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
    public double sumSub(double[] Subject){
        double sum = 0;
        for(int i = 0; i < Subject.length; i++) {
            sum += Subject[i];
        }
        return sum;
    }

    public void display() {
        System.out.println(getId() + " " + getName() + " " + getSurname() + " " + getBirth());
    }

}

