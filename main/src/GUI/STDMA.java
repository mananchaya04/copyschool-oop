package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

//
//
//  TESE FOR MANAGE STUDENT
//
//
public class STDMA extends JFrame implements ActionListener {
    private JTable table;
    private DefaultTableModel model;
    private JTextField nameField, idField, gpaField;
    private JButton addButton, editButton, removeButton;

    public STDMA() {
        // Set up the JFrame
        setTitle("Student Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        // Create the table and model
        String[] columns = {"ID", "Name", "GPA"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Create the input fields and buttons
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        JLabel gpaLabel = new JLabel("GPA:");
        gpaField = new JTextField();
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        removeButton = new JButton("Remove");
        addButton.addActionListener(this);
        editButton.addActionListener(this);
        removeButton.addActionListener(this);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(gpaLabel);
        inputPanel.add(gpaField);
        inputPanel.add(addButton);
        inputPanel.add(editButton);
        inputPanel.add(removeButton);
        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameField.getText();
            String id = idField.getText();
            String gpa = gpaField.getText();
            Object[] rowData = {id, name, gpa};
            model.addRow(rowData);
            nameField.setText("");
            idField.setText("");
            gpaField.setText("");
        } else if (e.getSource() == editButton) {
            int row = table.getSelectedRow();
            if (row >= 0) {
                String name = nameField.getText();
                String id = idField.getText();
                String gpa = gpaField.getText();
                model.setValueAt(id, row, 0);
                model.setValueAt(name, row, 1);
                model.setValueAt(gpa, row, 2);
                nameField.setText("");
                idField.setText("");
                gpaField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to edit.");
            }
        } else if (e.getSource() == removeButton) {
            int row = table.getSelectedRow();
            if (row >= 0) {
                model.removeRow(row);
                nameField.setText("");
                idField.setText("");
                gpaField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to remove.");
            }
        }
    }

    public static void main(String[] args) {
        new STDMA();
    }
}
