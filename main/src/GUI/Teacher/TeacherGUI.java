package GUI.Teacher;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import Admin.StoreStudent;
import Admin.StoreTeacher;
import Admin.StoreTimetable;
import GUI.Login;
import GUI.MainFrame;
import Teacher.Teacher;
import Student.Student;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TeacherGUI extends JFrame implements ActionListener {
    private MainFrame mainFrame;
    private Label title;
    private Label name,nameAnz,surname,surnameAnz,birth,birthAnz,course,courseAnz;
    private JButton logoutButton,assignmentButton;
    private static Vector<Teacher> teachers = StoreTeacher.getTeachersVector();
    private String userID,nameID,surnameID,birthID,courseID;
    private JMenuItem manageStudMenuItem,manageScorMenuItem,gradMenuItem;
    private static final String USER_ID;
    private static String courseId;

    public static int y[] = new int[10];

    public TeacherGUI (String userid) {
        //set panel
        setLayout(null);
        setTitle("Teacher");
        setResizable(false);
        setLocation(400,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);

        //set y
        y[0] = 50;
        for(int i=1;i<y.length;i++){
            y[i] = y[i-1]+50;
        }
        // Set ID
        for(Teacher teacher: teachers){
            if(userid.equals(teacher.getId())){
                userID = teacher.getId();
                nameID = teacher.getName();
                surnameID = teacher.getSurname();
                birthID = teacher.getBirth();
                courseID = teacher.getCourse();
            }
        }

        //Menu Bar
        JMenuBar menuBar = new JMenuBar();
        //Menu bar1
        JMenu menu1 = new JMenu("Manage");
        manageStudMenuItem = new JMenuItem("Manage Students");
        manageScorMenuItem = new JMenuItem("Manage Score");
        gradMenuItem = new JMenuItem("Manage Grade");
        menu1.add(manageStudMenuItem);
        menu1.add(manageScorMenuItem);
        menu1.add(gradMenuItem);
        menuBar.add(menu1);
        setJMenuBar(menuBar);

        // Set Action
        manageScorMenuItem.addActionListener(e -> manageScore());
        gradMenuItem.addActionListener(e -> manageGrade());

        // Set Label
        title = new Label("Welcome "+userID+" To Teacher Page");
        title.setBounds(280, y[0], 400, 30);
        add(title);

        name = new Label("Name:" );
        name.setBounds(220, y[1], 50, 30);
        add(name);

        nameAnz = new Label(nameID);
        nameAnz.setBounds(270, y[1], 100, 30);
        add(nameAnz);

        surname = new Label("Surname:");
        surname.setBounds(370, y[1], 60, 30);
        add(surname);

        surnameAnz = new Label(surnameID);
        surnameAnz.setBounds(430, y[1], 100, 30);
        add(surnameAnz);

        course = new Label("Course:");
        course.setBounds(220, y[2], 50, 30);
        add(course);

        courseAnz = new Label(courseID);
        courseAnz.setBounds(270, y[2], 100, 30);
        add(courseAnz);

        birth = new Label("Birth:");
        birth.setBounds(370, y[2], 50, 30);
        add(birth);

        birthAnz = new Label(birthID);
        birthAnz.setBounds(430, y[2], 100, 30);
        add(birthAnz);

        assignmentButton = new JButton("Assignment");
        assignmentButton.setBounds(250, y[5], 200, 30);
        add(assignmentButton);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(250, y[6], 200, 30);
        logoutButton.addActionListener(this);
        add(logoutButton);

        setVisible(true);
    }

    private void manageScore() {
        ManageScore manageScore = new ManageScore(courseID);
        setVisible(false);
    }

    private void manageGrade(){
        ManageGrade manageGrade = new ManageGrade(courseID);
        setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == logoutButton) {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            setVisible(false);
            mainFrame.switchToLoginPanel();
        }
    }
    static{
        USER_ID = Login.getUserId();
        courseId = Login.getCourseId();
    }

    public static void main(String[] args) {
        new TeacherGUI(null);
    }
}
