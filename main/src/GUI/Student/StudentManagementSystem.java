package GUI.Student;

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

public class StudentManagementSystem extends JFrame implements ActionListener {
    private JTable teacherTable;
    private DefaultTableModel tableModel;
    private JMenuItem exitMenuItem, logoutMenuItem;
    // private JFrame mainFrame;
    private Vector<Student> students = StoreStudent.getStudents();
    private static StoreStudent storeStudent;
    //private String mind, attend;

    public StudentManagementSystem() {
        // super("Teacher Management System");
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
        columnNames.addElement("Birth");
        columnNames.addElement("Class");
        columnNames.addElement("Club");
        columnNames.addElement("Password");

        tableModel = new DefaultTableModel(columnNames, 0);
        teacherTable = new JTable(tableModel);

        // test
        for (Student student : students) {
            Vector<String> row = new Vector<>();
            row.addElement(student.getId());
            row.addElement(student.getName());
            row.addElement(student.getSurname());
            row.addElement(student.getBirth());
            row.addElement(student.getClassRoom());
            row.addElement(student.getClub());
            row.addElement(student.getPassword());
            tableModel.addRow(row);
        }

        // Create the buttons
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> addTeacher());

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> deleteTeacher());

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(e -> updateTeacher());

        // Create the panel for the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
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

    private void addTeacher() {
        // Show a dialog for adding a teacher
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField surnameField = new JTextField();
        JTextField birthField = new JTextField();
        JTextField classField = new JTextField();
        JTextField clubField = new JTextField();
        JTextField passwordField = new JTextField();

        Object[] message = {
                "ID:", idField,
                "Name:", nameField,
                "Surname:", surnameField,
                "Birth:", birthField,
                "Class", classField,
                "Club", clubField,
                "Password", passwordField,
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Add Teacher", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String id = idField.getText();
            String name = nameField.getText();
            String surname = surnameField.getText();
            String birth = birthField.getText();
            String classRoom = classField.getText();
            String club = clubField.getText();
            String password = passwordField.getText();

            // Add the new teacher to the table

            StoreStudent.setStudent(id, name, surname, birth, classRoom, club, password);

            Vector<String> row = new Vector<>();
            row.addElement(id);
            row.addElement(name);
            row.addElement(surname);
            row.addElement(birth);
            row.addElement(classRoom);
            row.addElement(club);
            row.addElement(password);
            tableModel.addRow(row);
        }
    }

    private void deleteTeacher() {
        // Vector form Storage Teacher

        // Show a dialog for updating a teacher
        int selectedRow = teacherTable.getSelectedRow();

        if (selectedRow != -1) {
            // Get the selected row and delete it from the table
            int[] selectedRows = teacherTable.getSelectedRows();
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                tableModel.removeRow(selectedRows[i]);
                students.remove(selectedRows[i]);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to Delete.");
        }
    }

    private void updateTeacher() {
        // Show a dialog for updating a teacher
        int selectedRow = teacherTable.getSelectedRow();

        if (selectedRow != -1) {
            String id = (String) tableModel.getValueAt(selectedRow, 0);
            String name = (String) tableModel.getValueAt(selectedRow, 1);
            String surname = (String) tableModel.getValueAt(selectedRow, 2);
            String birth = (String) tableModel.getValueAt(selectedRow, 3);
            String classRoom = (String) tableModel.getValueAt(selectedRow, 4);
            String club = (String) tableModel.getValueAt(selectedRow, 5);
            String password = (String) tableModel.getValueAt(selectedRow, 6);

            JTextField idField = new JTextField(id);
            JTextField nameField = new JTextField(name);
            JTextField surnameField = new JTextField(surname);
            JTextField birthField = new JTextField(birth);
            JTextField classField = new JTextField(classRoom);
            JTextField clubField = new JTextField(club);
            JTextField passwordField = new JTextField(password);

            Object[] message = {
                    "ID:", idField,
                    "Name:", nameField,
                    "Surname:", surnameField,
                    "Birth:", birthField,
                    "Class:", classField,
                    "Club:", clubField,
                    "Password:", passwordField,
            };
            int option = JOptionPane.showConfirmDialog(null, message, "Update Teacher", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                tableModel.setValueAt(idField.getText(), selectedRow, 0);
                tableModel.setValueAt(nameField.getText(), selectedRow, 1);
                tableModel.setValueAt(surnameField.getText(), selectedRow, 2);
                tableModel.setValueAt(birthField.getText(), selectedRow, 3);
                tableModel.setValueAt(classField.getText(), selectedRow, 4);
                tableModel.setValueAt(clubField.getText(), selectedRow, 5);
                tableModel.setValueAt(passwordField.getText(), selectedRow, 6);

                // SET ALL
                Student student = students.get(selectedRow);
                String mind = student.getMindScore();
                String attend = student.getAttendScore();
                double grade[] = {student.getMid(),student.getWork(),student.getPro(),student.getFin()};

                System.out.println("Mind:"+mind+", Attend:"+attend);
                System.out.println("mid:"+grade[0]+", work:"+grade[1]+",pro:"+grade[2]+", final:"+grade[3]);
                // Update the teacher in the list
                Student updatedStudent = new Student(
                        idField.getText(),
                        nameField.getText(),
                        surnameField.getText(),
                        birthField.getText(),
                        classField.getText(),
                        clubField.getText(),
                        passwordField.getText(),
                        attend,
                        mind,
                        grade
                );

                students.set(selectedRow, updatedStudent);
                JOptionPane.showMessageDialog(null, "Update Success.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to update.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == exitMenuItem) {
            MainFrame mainFrame = new MainFrame();
            mainFrame.switchToAdminPanel();
            mainFrame.setVisible(true);
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
        new StudentManagementSystem();
    }

}
