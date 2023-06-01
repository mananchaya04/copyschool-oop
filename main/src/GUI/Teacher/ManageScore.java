package GUI.Teacher;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Admin.StoreStudent;
import Admin.StoreTeacher;
import Teacher.Teacher;
import GUI.*;
import Student.Student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ManageScore extends JFrame implements ActionListener {
    private JTable teacherTable;
    private DefaultTableModel tableModel;
    private JMenuItem exitMenuItem, logoutMenuItem;
    // private JFrame mainFrame;
    private Vector<Student> students = StoreStudent.getStudents();
    private static StoreStudent storeStudent;
    private static String attend,mind;
    private static String userID, club, pass, birth;

    public ManageScore(String classRoom) {

        setTitle("Student Manage System");
        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        // Menu bar1
        JMenu menu1 = new JMenu("Menu");
        exitMenuItem = new JMenuItem("Exit");
        logoutMenuItem = new JMenuItem("Logout");
        menu1.add(exitMenuItem);
        menu1.add(logoutMenuItem);
        menuBar.add(menu1);

        // vector

        exitMenuItem.addActionListener(this);
        logoutMenuItem.addActionListener(this);
        setJMenuBar(menuBar);

        // Create the table
        Vector<String> columnNames = new Vector<>();
        columnNames.addElement("ID");
        columnNames.addElement("Name");
        columnNames.addElement("Surname");
        columnNames.addElement("Class");
        columnNames.addElement("Attandend");
        columnNames.addElement("Mind Score");

        tableModel = new DefaultTableModel(columnNames, 0);
        teacherTable = new JTable(tableModel);

        // test
        for (Student student : students) {
            if (student.getClassRoom().equals(classRoom)) {
                // Add Row
                Vector<String> row = new Vector<>();
                row.addElement(student.getId());
                row.addElement(student.getName());
                row.addElement(student.getSurname());
                row.addElement(student.getClassRoom());
                row.addElement(student.getAttendScore());
                row.addElement(student.getMindScore());
                tableModel.addRow(row);

                // Add Variable
                club = student.getClub();
                pass = student.getPassword();
                birth = student.getBirth();
            }
        }
        System.out.println(Login.getCourseId());
        // Create the buttons
        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(e -> updateTeacher());

        // Create the panel for the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 1));
        buttonPanel.add(updateButton);

        // Add components to the frame
        add(new JScrollPane(teacherTable), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set the size and visibility of the frame
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void updateTeacher() {
        // Show a dialog for updating a teacher
        int selectedRow = teacherTable.getSelectedRow();

        if (selectedRow != -1) {
            String id = (String) tableModel.getValueAt(selectedRow, 0);
            String name = (String) tableModel.getValueAt(selectedRow, 1);
            String surname = (String) tableModel.getValueAt(selectedRow, 2);
            String classRoom = (String) tableModel.getValueAt(selectedRow, 3);
            String attendScore = (String) tableModel.getValueAt(selectedRow, 4);
            String mindScore = (String) tableModel.getValueAt(selectedRow, 5);

            JTextField idField = new JTextField(id);
            JTextField nameField = new JTextField(name);
            JTextField surnameField = new JTextField(surname);
            JTextField classField = new JTextField(classRoom);
            JTextField attendScoreField = new JTextField(attendScore);
            JTextField mindScoreField = new JTextField(mindScore);

            Object[] message = {
                    "Attend Score:", attendScoreField,
                    "Mind Score:", mindScoreField,
            };
            int option = JOptionPane.showConfirmDialog(null, message, "Update Score", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                tableModel.setValueAt(idField.getText(), selectedRow, 0);
                tableModel.setValueAt(nameField.getText(), selectedRow, 1);
                tableModel.setValueAt(surnameField.getText(), selectedRow, 2);
                tableModel.setValueAt(classField.getText(), selectedRow, 3);
                tableModel.setValueAt(attendScoreField.getText(), selectedRow, 4);
                tableModel.setValueAt(mindScoreField.getText(), selectedRow, 5);
                //

                // Get the index of the Teacher object with id "1002"

                int index = -1; // initialize the index to -1 (not found)
                for (int i = 0; i < students.size(); i++) {
                    Student student = students.get(i);
                    if (student.getId().equals(id)) {
                        index = i;
                        break;
                    }
                }

                Student student2 = students.get(index);
                double grade[] = {student2.getMid(),student2.getWork(),student2.getPro(),student2.getFin()};

                System.out.println("mid:"+grade[0]+", work:"+grade[1]+",pro:"+grade[2]+", final:"+grade[3]);
                // Update the Score in the list
                Student updatedStudent = new Student(
                        id, // explicitly set the id to the original value
                        name, // explicitly set the name to the original value
                        surname, // explicitly set the surname to the original value
                        birth,
                        classRoom, // explicitly set the classRoom to the original value
                        club,
                        pass,
                        attendScoreField.getText(),
                        mindScoreField.getText(),
                        grade
                );
                System.out.println("Index of teacher with id " + id + ": " + index);
                students.set(index, updatedStudent);
                JOptionPane.showMessageDialog(null, "Update Success.");

                System.out.println(selectedRow);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to update.");
        }
    }
   /*  public String getAttend(){
        return attend;
    }
    public String getMind(){
        return mind;
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == exitMenuItem) {
            userID = StoreTeacher.idCurrent;
            TeacherGUI teacherGUI = new TeacherGUI(userID);
            setVisible(false);

        } else if (e.getSource() == logoutMenuItem) {
            MainFrame mainFrame = new MainFrame();
            mainFrame.switchToLoginPanel();
            mainFrame.setVisible(true);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        storeStudent = new StoreStudent();
        new ManageScore(null);
    }

}

