import Function.Assignment;
import Student.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Create Each Student to Object
        //menu for student and teacher
        //จำลองรายชื่อนักเรียน

        String[][] studentInfo = {{"Ava","Elijah","Ethan","Isabella","Noah","Sophia","Ethan","Emma","Noah","Ava","Lucas","Olivia","Liam","Mia","Jackson"},
                {"Rodriguez","Wilson","Davis","Johnson","Brown","Lee","Davis","Patel","Kim","Rodriguez","Brown","Nguyen","Hernandez","Chen","Gupta"},
                {"131","132","133","134","135","136","137","138","139","140","141","142","143","144","145","146"},
                {"11052546","11052546","11052546","11052546","11052546","11052546","11052546","11052546","11052546","11052546","11052546","11052546","11052546","11052546","11052546"}};
        Student[] students = new Student[15];
        for (int i = 0; i < 15; i++) {
            if (i < 5) {
                students[i] = new sciMathStu(studentInfo[0][i], studentInfo[1][i], studentInfo[2][i], studentInfo[3][i],
                        random(), random(), random(), random(), random(), random(), random());
            } else if (i < 10) {
                students[i] = new mathEngStu(studentInfo[0][i], studentInfo[1][i], studentInfo[2][i], studentInfo[3][i],
                        random(), random(), random(), random() ,random());
            } else {
                students[i] = new artStu(studentInfo[0][i], studentInfo[1][i], studentInfo[2][i], studentInfo[3][i],
                        random(), random(), random(), random());
            }
        }
        //-------------------------------------------------CREATE DATA FOR STUDENT -----------------------------------------//

//        gradestudentManage(students);
//        displayStudentGrade(students);
//        displayStudentData(students);
//        displaySciStudent(students);
//        displayEMStudent(students);
//        displayARTStudent(students);
//        addAssignment(students);
//        displayAssignmentStudent(students ,"132");
//        addGradeAssign(students ,"132");
//        displayAssignmentStudent(students ,"132");

    }
    public static void addGradeAssign(Student[] students, String id){
        Student targetStudent = findStudentById(students , id);
        ArrayList<Assignment> studentAssignments = targetStudent.getAssignments();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter assignment grade (0-100): ");
        int grade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter feedback: ");
        String feedback = scanner.nextLine();
        studentAssignments.get(0).setFeedback(feedback);
        studentAssignments.get(0).setGrade(grade);
    }
    public static void displayAssignmentStudent(Student[] students, String id){
        Student targetStudent = findStudentById(students , id);
        ArrayList<Assignment> studentAssignments = targetStudent.getAssignments();
        for (Assignment assignment : studentAssignments) {
            System.out.println("Title: " + assignment.getTitle());
            System.out.println("SubmissionDate: " + assignment.getSubmissionDate());
            System.out.println("DueDate: " + assignment.getDueDate());
            if (assignment.getFeedback() != null){
                System.out.println("Feedback: " + assignment.getFeedback());
                System.out.println("Grade: " + assignment.getGrade());
            }
            System.out.println("*-----------------------------------------------*");
        }
    }
    public static void addAssignment(Student[] students){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Assignment> assignments = new ArrayList<>();

        System.out.print("Enter student's ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Enter assignment title: ");
        String assignmentTitle = scanner.nextLine();
        System.out.print("Enter submission date (mm/dd/yyyy): ");
        String submissionDate = scanner.nextLine();
        System.out.print("Enter due date (mm/dd/yyyy): ");
        String dueDate = scanner.nextLine();
        assignments.add(new Assignment(assignmentTitle,submissionDate,dueDate));

        Student targetStudent = findStudentById(students , studentID);
        targetStudent.setAssignments(assignments);
        System.out.println("Assignment added successfully!");
    }

    public static Student findStudentById(Student[] students, String targetId) {
        for (Student student : students) {
            if (student.getId().equals(targetId)) {
                return student;
            }
        }
        return null;
    }
    public static void displaySciStudent(Student[] students ) {
        // Print the table header
        System.out.println("+------------+----------------+----------------+---------------+---------------+");
        System.out.println("+------------------- S C I E N C E - M A T H S T U D E N T --------------------+");
        System.out.println("+------------+----------------+----------------+---------------+---------------+");
        System.out.println("+----------| MIDTERM |  WORK  | PROJECT |  FINAL  | SUMMARY | GRADE |----------+");
        System.out.println("+------------+----------------+----------------+---------------+---------------+");
        double[] phy = ((sciMathStu) students[1]).getPhySub();
        double[] chem = ((sciMathStu) students[1]).getChemSub();
        double[] bio = ((sciMathStu) students[1]).getBioSub();
        double[] math = students[1].getMathSub();
        double[] advMath = ((sciMathStu) students[1]). getAdvMathSub();
        double[] eng = students[1].getEngSub();
        double[] thai = students[1].getThaiSub();
        System.out.printf("PHYSICS  : | %-7.2f | %-6.2f | %-7.2f | %-7.2f | %-7.2f |   %-5s %n",phy[0],phy[1],phy[2],phy[3],students[1].sumSub(((sciMathStu) students[1]).getPhySub()), grade(students[1].sumSub(((sciMathStu) students[1]).getPhySub())));
        System.out.printf("CHEMICAL : | %-7.2f | %-6.2f | %-7.2f | %-7.2f | %-7.2f |   %-5s %n",chem[0],chem[1],chem[2],chem[3],students[1].sumSub(((sciMathStu) students[1]).getChemSub()), grade(students[1].sumSub(((sciMathStu) students[1]).getChemSub())));
        System.out.printf("BIOLOGY  : | %-7.2f | %-6.2f | %-7.2f | %-7.2f | %-7.2f |   %-5s %n",bio[0],bio[1],bio[2],bio[3],students[1].sumSub(((sciMathStu) students[1]).getBioSub()), grade(students[1].sumSub(((sciMathStu) students[1]).getBioSub())));
        System.out.printf("MATH     : | %-7.2f | %-6.2f | %-7.2f | %-7.2f | %-7.2f |   %-5s %n",math[0],math[1],math[2],math[3],students[1].sumSub(students[1].getMathSub()), grade(students[1].sumSub(students[1].getMathSub())));
        System.out.printf("ADV-MATH  : | %-7.2f | %-6.2f | %-7.2f | %-7.2f | %-7.2f |   %-5s %n",advMath[0],advMath[1],advMath[2],advMath[3],students[1].sumSub(((sciMathStu) students[1]).getAdvMathSub()), grade(students[1].sumSub(((sciMathStu) students[1]).getAdvMathSub())));
        System.out.printf("ENG      : | %-7.2f | %-6.2f | %-7.2f | %-7.2f | %-7.2f |   %-5s %n",eng[0],eng[1],eng[2],eng[3],students[1].sumSub(students[1].getEngSub()), grade(students[1].sumSub(students[1].getEngSub())));
        System.out.printf("THAI     : | %-7.2f | %-6.2f | %-7.2f | %-7.2f | %-7.2f |   %-5s %n",thai[0],thai[1],thai[2],thai[3],students[1].sumSub(students[1].getThaiSub()),grade(students[1].sumSub(students[1].getThaiSub())));
    }
    public static void displayEMStudent(Student[] students ) {
        // Print the table header
        System.out.println("+------------+----------------+----------------+---------------+---------------+");
        System.out.println("+----------------------- E N G - M A T H S T U D E N T ------------------------+");
        System.out.println("+------------+----------------+----------------+---------------+---------------+");
        System.out.println("+----------| MIDTERM |  WORK  | PROJECT |  FINAL  | SUMMARY | GRADE |----------+");
        System.out.println("+------------+----------------+----------------+---------------+---------------+");
        double[] sci = ((mathEngStu) students[5]).getSciSub();
        double[] math = students[5].getMathSub();
        double[] advMath = ((mathEngStu) students[5]).getAdvMathSub();
        double[] eng = students[5].getEngSub();
        double[] thai = students[5].getThaiSub();
        System.out.printf("SCIENCE  : | %-7.2f | %-6.2f | %-7.2f | %-7.2f | %-7.2f |   %-5s %n",sci[0],sci[1],sci[2],sci[3],students[5].sumSub(((mathEngStu) students[5]).getSciSub()), grade(students[5].sumSub(((mathEngStu) students[5]).getSciSub())));
        System.out.printf("MATH     : | %-7.2f | %-6.2f | %-7.2f | %-7.2f | %-7.2f |   %-5s %n",math[0],math[1],math[2],math[3],students[5].sumSub(students[5].getMathSub()), grade(students[5].sumSub(students[5].getMathSub())));
        System.out.printf("ADV-MATH  : | %-7.2f | %-6.2f | %-7.2f | %-7.2f | %-7.2f |   %-5s %n",advMath[0],advMath[1],advMath[2],advMath[3],students[5].sumSub(((mathEngStu) students[5]).getAdvMathSub()), grade(students[1].sumSub(((mathEngStu) students[5]).getAdvMathSub())));
        System.out.printf("ENG      : | %-7.2f | %-6.2f | %-7.2f | %-7.2f | %-7.2f |   %-5s %n",eng[0],eng[1],eng[2],eng[3],students[5].sumSub(students[5].getEngSub()), grade(students[5].sumSub(students[5].getEngSub())));
        System.out.printf("THAI     : | %-7.2f | %-6.2f | %-7.2f | %-7.2f | %-7.2f |   %-5s %n",thai[0],thai[1],thai[2],thai[3],students[5].sumSub(students[5].getThaiSub()),grade(students[5].sumSub(students[5].getThaiSub())));
    }
    public static void displayARTStudent(Student[] students) {
        // Print the table header
        System.out.println("+------------+----------------+----------------+---------------+---------------+");
        System.out.println("+---------------------------- A R T S T U D E N T -----------------------------+");
        System.out.println("+------------+----------------+----------------+---------------+---------------+");
        System.out.println("+----------| MIDTERM |  WORK  | PROJECT |  FINAL  | SUMMARY | GRADE |----------+");
        System.out.println("+------------+----------------+----------------+---------------+---------------+");
        double[] sci = ((artStu) students[10]).getSciSub();
        double[] math = students[10].getMathSub();
        double[] eng = students[10].getEngSub();
        double[] thai = students[10].getThaiSub();
        System.out.printf("SCIENCE  : | %-7.2f | %-6.2f | %-7.2f | %-7.2f | %-7.2f |   %-5s %n",sci[0],sci[1],sci[2],sci[3],students[10].sumSub(((artStu) students[10]).getSciSub()), grade(students[10].sumSub(((artStu) students[10]).getSciSub())));
        System.out.printf("MATH     : | %-7.2f | %-6.2f | %-7.2f | %-7.2f | %-7.2f |   %-5s %n",math[0],math[1],math[2],math[3],students[10].sumSub(students[10].getMathSub()), grade(students[10].sumSub(students[10].getMathSub())));
        System.out.printf("ENG      : | %-7.2f | %-6.2f | %-7.2f | %-7.2f | %-7.2f |   %-5s %n",eng[0],eng[1],eng[2],eng[3],students[10].sumSub(students[10].getEngSub()), grade(students[10].sumSub(students[10].getEngSub())));
        System.out.printf("THAI     : | %-7.2f | %-6.2f | %-7.2f | %-7.2f | %-7.2f |   %-5s %n",thai[0],thai[1],thai[2],thai[3],students[10].sumSub(students[10].getThaiSub()),grade(students[10].sumSub(students[10].getThaiSub())));
    }

    public static double[] random(){
        return new double[]{10.0 + (Math.random() * ((30.0 - 10.0) + 1)), 5.0 + (Math.random() * ((10.0 - 5.0) + 1)) ,
                10.0 + (Math.random() * ((20.0 - 10.0) + 1)), 15.0 + (Math.random() * ((40.0 - 15.0) + 1))};
    }
    ///displayStudentData ใช้แสดงข้อมูลนักเรียนทั้งหมด สำหรับครู
    public static void displayStudentData(Student[] students){
        // Print the table header
        System.out.println("+-------+--------+----------+------------+");
        System.out.println("|+--- S T U D E N T  H I S T O R Y ----+|");
        System.out.println("+-------+--------+----------+------------+");
        System.out.println("|  ID  |  Name  |  Surname |  Birthdate |");
        System.out.println("+-------+--------+----------+------------+");

        for (int i = 0; i < 5 ; i++) {
            System.out.printf("| %-2s | %-8s | %-9s | %-8s |%n", students[i].getId(),students[i].getName(),students[i].getSurname(),students[i].getBirth());
        }

        // Print the table footer
        System.out.println("+-------+--------+----------+------------+");
    }

    ///displayStudentGrade ใช้แสดงข้อมูลคะแนนนักเรียนทั้งหมด สำหรับครู

    public static void displayStudentGrade(Student[] students){
        // Print the table header
        System.out.println("+----------+--------+----------+------------+-----+");
        System.out.println("|+------------- S T U D E N T  G R A D E ---------+|");
        System.out.println("+----------+--------+----------+------------+------+");
        System.out.println("| ID |   Name    |  Surname  | ENG | THAI | MATH |");
        System.out.println("+----------+--------+----------+------------+-----+");

        for (int i = 0; i < students.length ; i++) {
            System.out.printf("| %-2s | %-8s | %-9s | %3.1f | %4.1f | %4.1f |%n",
                    students[i].getId(),students[i].getName(),students[i].getSurname(),
                    students[i].sumSub(students[i].getEngSub()),students[i].sumSub(students[i].getThaiSub()),
                    students[i].sumSub(students[i].getMathSub()));
        }

        // Print the table footer
        System.out.println("+----------+--------+----------+------------+-----------+");
    }

    ///studentManage ใช้จัดการ / แก้ไขข้อมูลคะแนนนักเรียน
    public static void gradestudentManage(Student[] students){
        // print the top border of the table
        System.out.println("+-------+------------+------------+------------+----------------+-------+--------------+");

        // print the header row of the table
        System.out.printf("| %-5s | %-10s | %-10s | %-10s | %-10s | %-5s | %-5s | %-12s |\n",
                "ID", "Name", "Surname", "Midterm", "Work","Project", "Final", "Summary Grade");

        // print the middle border of the table
        System.out.println("+-------+------------+------------+------------+----------------+-------+--------------+");

        // print each row of student data
        for (int i = 0; i < students.length ; i++){
            if (students[i] instanceof sciMathStu){
                double arr[] = ((sciMathStu) students[i]). getChemSub();
                System.out.printf("| %-5s | %-10s | %-10s | %-10.1f | %-10.1f | %-5.1f | %-12.1f |%-12.2f|\n",
                        students[i].getId(),students[i].getName(),students[i].getSurname(),
                        arr[0] , arr[1] ,arr[2] , arr[3] , students[i].sumSub(((sciMathStu) students[i]).getChemSub()));
            }
        }

        // print the bottom border of the table
        System.out.println("+-------+------------+------------+------------+----------------+-------+--------------+");
    }

    ///studentManage ใช้จัดการ / แก้ไขข้อมูลนักเรียน
    public static void studentManage(Student[] students){
        displayStudentData(students);
        Scanner sc = new Scanner(System.in);
        String studentId = sc.next();
        for (int i = 0; i < students.length ; i++) {
            if (studentId.equals(students[i].getId())){
                students[i].display();
                System.out.println("What Information?");
                System.out.print("1.Name\n2.Surname\n3.BirthDay\n");
                System.out.print("Input you Choice : ");
                int info_Student = sc.nextInt();
                System.out.print("Input you Information : ");
                String Change_info = sc.next();
                switch (info_Student){
                    case 1 -> students[i].setName(Change_info);
                    case 2 -> students[i].setSurname(Change_info);
                    case 3 -> students[i].setBirth(Change_info);
                }
            }
        }
        displayStudentData(students);
    }
    public static String grade(double score) {
        if(score>=80)
        {
            return "A";
        }
        else if(score>=70)
        {
            return  "B";
        }
        else if(score>=60)
        {
            return "C";
        }
        else if(score>=50)
        {
            return  "D";
        }
        else {
            return  "F";
        }
    }
}