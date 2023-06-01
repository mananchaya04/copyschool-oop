package GUI.Teacher;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Admin.StoreTeacher;
import Teacher.Teacher;
import GUI.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class TeacherManagementSystem extends JFrame implements ActionListener {
    private JTable teacherTable;
    private DefaultTableModel tableModel;
    private JMenuItem exitMenuItem,logoutMenuItem;
    //private JFrame mainFrame;
    private Vector <Teacher> teachers = StoreTeacher.getTeachersVector();
    private static StoreTeacher storeTeacher;

    public TeacherManagementSystem() {
        //super("Teacher Management System");
        setTitle("Teacher Manage System");
        //Menu Bar
        JMenuBar menuBar = new JMenuBar();
        //Menu bar1
        JMenu menu1 = new JMenu("Menu");
        exitMenuItem = new JMenuItem("Exit");
        logoutMenuItem = new JMenuItem("Logout");
        menu1.add(exitMenuItem);
        menu1.add(logoutMenuItem);
        menuBar.add(menu1);

        //vector

        exitMenuItem.addActionListener(this);
        logoutMenuItem.addActionListener(this);
        setJMenuBar(menuBar);


        // Create the table
        Vector<String> columnNames = new Vector<>();
        columnNames.addElement("ID");
        columnNames.addElement("Name");
        columnNames.addElement("Surname");
        columnNames.addElement("Birth");
        columnNames.addElement("Course");
        columnNames.addElement("Password");

        tableModel = new DefaultTableModel(columnNames, 0);
        teacherTable = new JTable(tableModel);

        //test
        for(Teacher teacher : teachers){
            Vector<String> row = new Vector<>();
            row.addElement(teacher.getId());
            row.addElement(teacher.getName());
            row.addElement(teacher.getSurname());
            row.addElement(teacher.getBirth());
            row.addElement(teacher.getCourse());
            row.addElement(teacher.getPassword());
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
        JTextField courseField = new JTextField();
        JTextField passwordField = new JTextField();

        Object[] message = {
                "ID:", idField,
                "Name:", nameField,
                "Surname:", surnameField,
                "Birth:", birthField,
                "Course:",courseField,
                "Password:",passwordField,
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Add Teacher", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String id = idField.getText();
            String name = nameField.getText();
            String surname = surnameField.getText();
            String birth = birthField.getText();
            String course = courseField.getText();
            String password = passwordField.getText();

            // Add the new teacher to the table

            StoreTeacher.setTeacher(id, name, surname, birth, course, password);

            Vector<String> row = new Vector<>();
            row.addElement(id);
            row.addElement(name);
            row.addElement(surname);
            row.addElement(birth);
            row.addElement(course);
            row.addElement(password);
            tableModel.addRow(row);
        }
    }

    private void deleteTeacher() {
        // Vector form Storage Teacher


        // Show a dialog for updating a teacher
        int selectedRow = teacherTable.getSelectedRow();
        if (selectedRow != -1){
            // Get the selected row and delete it from the table
            int[] selectedRows = teacherTable.getSelectedRows();
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                tableModel.removeRow(selectedRows[i]);
                teachers.remove(selectedRows[i]);
            }
        }
        else {
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
            String course = (String) tableModel.getValueAt(selectedRow, 4);
            String password = (String) tableModel.getValueAt(selectedRow, 5);

            JTextField idField = new JTextField(id);
            JTextField nameField = new JTextField(name);
            JTextField surnameField = new JTextField(surname);
            JTextField birthField = new JTextField(birth);
            JTextField courseField = new JTextField(course);
            JTextField passwordField = new JTextField(password);


            Object[] message = {
                    "ID:", idField,
                    "Name:", nameField,
                    "Surname:", surnameField,
                    "Birth:", birthField,
                    "Course:",courseField,
                    "Password:",passwordField,
            };
            int option = JOptionPane.showConfirmDialog(null, message, "Update Teacher", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                tableModel.setValueAt(idField.getText(), selectedRow, 0);
                tableModel.setValueAt(nameField.getText(), selectedRow, 1);
                tableModel.setValueAt(surnameField.getText(), selectedRow, 2);
                tableModel.setValueAt(birthField.getText(), selectedRow, 3);
                tableModel.setValueAt(courseField.getText(), selectedRow, 4);
                tableModel.setValueAt(passwordField.getText(), selectedRow, 5);
                // Update the teacher in the list
                Teacher updatedTeacher = new Teacher(
                        idField.getText(),
                        nameField.getText(),
                        surnameField.getText(),
                        birthField.getText(),
                        courseField.getText(),
                        passwordField.getText()
                );
                teachers.set(selectedRow, updatedTeacher);
                JOptionPane.showMessageDialog(null, "Update Success.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to update.");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == exitMenuItem){
            MainFrame mainFrame = new MainFrame();
            mainFrame.switchToAdminPanel();
            mainFrame.setVisible(true);
            setVisible(false);
        }
        else if(e.getSource() == logoutMenuItem){
            MainFrame mainFrame = new MainFrame();
            mainFrame.switchToLoginPanel();
            mainFrame.setVisible(true);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        storeTeacher = new StoreTeacher();
        new TeacherManagementSystem();
    }


}

