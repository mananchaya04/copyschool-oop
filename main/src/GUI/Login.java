package GUI;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

import Admin.*;
import GUI.Teacher.TeacherGUI;
import Student.Student;
import Teacher.Teacher;

public class Login extends JPanel implements ActionListener {
    private MainFrame mainFrame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel title;
    private JLabel userName;
    private JLabel passWord;
    private int userLevel;
    private static String userId,userCourse;


    public static final int ADMIN_LEVEL = 1;
    public static final int TEACHER_LEVEL = 2;
    public static final int STUDENT_LEVEL = 3;

    public Login(MainFrame mainFrame) {
        this.mainFrame = mainFrame;


        // Set up the panel
        setLayout(null);
        mainFrame.setTitle("Java School");

        // Add the fields and button to the panel
        title = new JLabel("JAVA SCHOOL");
        title.setBounds(300,100,400,30);
        add(title);

        userName = new JLabel("Username");
        userName.setBounds(250, 150, 80, 25);
        add(userName);
        usernameField = new JTextField();
        usernameField.setBounds(340,150,130,25);
        add(usernameField);

        passWord = new JLabel("Password");
        passWord.setBounds(250, 200, 80, 25);
        add(passWord);
        passwordField = new JPasswordField();
        passwordField.setBounds(340,200,130,25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginButton.setBounds(300,250,100,30);
        add(loginButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if the login information is valid
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (isValidLogin(username, password)) {
            // Check Level user
            // Go To Admin Page
            if(userLevel == 1){
                mainFrame.switchToAdminPanel();
            }
            // Go To Teacher Page
            else if(userLevel == 2){


                //set sesstion Id to go personar page

                userCourse = StoreTeacher.courseCurrent;
                userId = StoreTeacher.idCurrent;
                mainFrame.setVisible(false);
                TeacherGUI teacherGUI = new TeacherGUI(userId);

                userId = StoreTeacher.idCurrent;

                JOptionPane.showMessageDialog(this, "Welcome to Teacher");


            }
            // Go To Student Page
            else if(userLevel == 3){
                JOptionPane.showMessageDialog(this, "Welcome to Student");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password");

        }
    }

    private boolean isValidLogin(String username, String password) {
        // Check if the login information is valid
        //Admin
        if(username.equals(Admin.getNameAdmin()) && password.equals(Admin.getPassword())){
            userLevel = ADMIN_LEVEL;
            return true;
        }
        //Teacher
        else if(StoreTeacher.checkLogin(username, password)){
            userLevel = TEACHER_LEVEL;
            return true;
        }
        //Student
        else if(StoreStudent.checkLogin(username, password)){
            userLevel = STUDENT_LEVEL;
            return true;
        }
        return false;
    }

    public static String getUserId(){
        return userId;
    }
    public static String getCourseId(){
        return userCourse;
    }


}
