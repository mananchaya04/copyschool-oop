package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import Admin.*;
import GUI.Student.StudentManagementSystem;
import GUI.Teacher.*;
import GUI.Timetable.TimetableManagementSystem;
import Teacher.*;

class AdminGui extends JPanel implements ActionListener {
    private MainFrame mainFrame;
    private JButton logoutButton,teacherButton,studeButton,timeButton;
    private JLabel title;
    private JTextField idTextField,passTextField;
    private JComboBox<String> comboBox;
    private GridBagLayout layout;
    private StoreTeacher storeTeacher;

    public static int y[] = new int[10];
    //set menu

    public AdminGui(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        //store Teacher
        //storeTeacher = new StoreTeacher();

        //set frame
        mainFrame.setTitle("Admin");
        JFrame.setDefaultLookAndFeelDecorated(true);
        setLayout(null);


        y[0] = 50;
        for (int i = 1; i < y.length; i++) {
            y[i] = y[i - 1] + 50;
        }

        title = new JLabel("Welcome to Admin page");
        title.setBounds(280, y[0], 400, 30);
        add(title);

        teacherButton = new JButton("Manage Teachers");
        teacherButton.setBounds(250, y[1], 200, 30);
        add(teacherButton);

        studeButton = new JButton("Manage Students");
        studeButton.setBounds(250, y[2], 200, 30);
        add(studeButton);

        timeButton = new JButton("Timetable");
        timeButton.setBounds(250, y[3], 200, 30);
        add(timeButton);

        logoutButton = new JButton("LogOut");
        logoutButton.setBounds(250, y[5], 200, 30);
        add(logoutButton);

        logoutButton.addActionListener(this);
        teacherButton.addActionListener(this);
        studeButton.addActionListener(this);
        timeButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutButton) {
            mainFrame.switchToLoginPanel();
        }
        else if(e.getSource() == teacherButton){
            mainFrame.setVisible(false);
            TeacherManagementSystem teacherManagementSystem = new TeacherManagementSystem();
        }
        else if(e.getSource() == studeButton){
            mainFrame.setVisible(false);
            StudentManagementSystem studentManagementSystem = new StudentManagementSystem();
        }
        else if(e.getSource() == timeButton){
            mainFrame.setVisible(false);
            TimetableManagementSystem timetableManagementSystem = new TimetableManagementSystem();
        }
    }
}

