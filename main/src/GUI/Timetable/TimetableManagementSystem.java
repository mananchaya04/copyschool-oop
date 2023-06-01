package GUI.Timetable;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Admin.StoreTimetable;
import Admin.Timetable;
import GUI.MainFrame;

public class TimetableManagementSystem extends JFrame implements ActionListener {
    private static final String[] menu = {
            "Select",
            "Student Math Timetable",
            "Student Science Timetable",
            "Student Eng Language Timetable",
    };

    private final JComboBox<String> comboBox;
    private Label title;
    private JMenuItem exitMenuItem, logoutMenuItem;
    private DefaultTableModel tableModel;
    private JTable timeTable;
    private JButton updateButton;
    private static StoreTimetable storeTimetable;
    private Vector<Timetable> timetableMath = StoreTimetable.getTimeMath();
    private Vector<Timetable> timetableEng = StoreTimetable.getTimeEng();
    private Vector<Timetable> timetableSci = StoreTimetable.getTimeSci();
    private JScrollPane scrollPane;
    private static String level;

    public TimetableManagementSystem() {
        // Set title
        setTitle("Timetable");

        // Menu bar
        JMenuBar menuBar = new JMenuBar();

        // Menu bar1
        JMenu menu1 = new JMenu("Menu");
        exitMenuItem = new JMenuItem("Exit");
        logoutMenuItem = new JMenuItem("Logout");
        menu1.add(exitMenuItem);
        menu1.add(logoutMenuItem);
        menuBar.add(menu1);

        exitMenuItem.addActionListener(e -> exitMenuItem());
        logoutMenuItem.addActionListener(e -> logoutMenuItem());
        setJMenuBar(menuBar);

        // Set components
        title = new Label("Welcome To Manage Timetable");
        title.setBounds(310, 20, 200, 25);
        add(title);

        comboBox = new JComboBox<String>(menu);
        comboBox.setBounds(300, 60, 200, 25);
        add(comboBox);

        // Create the table
        Vector<String> columnNames = new Vector<>();
        columnNames.addElement("Day");
        columnNames.addElement("8.00-9.00");
        columnNames.addElement("9.00-10.00");
        columnNames.addElement("10.00-11.00");
        columnNames.addElement("11.00-12.00");
        columnNames.addElement("12.00-13.00");
        columnNames.addElement("13.00-14.00");
        columnNames.addElement("14.00-15.00");
        columnNames.addElement("15.00-16.00");

        tableModel = new DefaultTableModel(columnNames, 0);
        timeTable = new JTable(tableModel);

        scrollPane = new JScrollPane(timeTable);
        scrollPane.setBounds(70, 120, 650, 103);
        add(scrollPane);

        // Set Button
        updateButton = new JButton("Update");
        updateButton.setBounds(250, 300, 300, 50);
        add(updateButton);

        // Add Action
        comboBox.addActionListener(this);
        updateButton.addActionListener(e -> updateTimetable(level));

        // Visible
        scrollPane.setVisible(false);
        updateButton.setVisible(false);

        // Set the size and location of the frame
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(null);

        // Set the default close operation and show the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void exitMenuItem() {
        MainFrame mainFrame = new MainFrame();
        mainFrame.switchToAdminPanel();
        mainFrame.setVisible(true);
        setVisible(false);
    }

    public void logoutMenuItem() {
        MainFrame mainFrame = new MainFrame();
        mainFrame.switchToLoginPanel();
        mainFrame.setVisible(true);
        setVisible(false);
    }

    public void updateTimetable(String Level) {
        int selectedRow = timeTable.getSelectedRow();

        if (selectedRow != -1) {
            String day = (String) tableModel.getValueAt(selectedRow, 0);
            String time1 = (String) tableModel.getValueAt(selectedRow, 1);
            String time2 = (String) tableModel.getValueAt(selectedRow, 2);
            String time3 = (String) tableModel.getValueAt(selectedRow, 3);
            String time4 = (String) tableModel.getValueAt(selectedRow, 4);
            String time5 = (String) tableModel.getValueAt(selectedRow, 5);
            String time6 = (String) tableModel.getValueAt(selectedRow, 6);
            String time7 = (String) tableModel.getValueAt(selectedRow, 7);
            String time8 = (String) tableModel.getValueAt(selectedRow, 8);

            JLabel dayLabel = new JLabel(day);
            JTextField time1Field = new JTextField(time1);
            JTextField time2Field = new JTextField(time2);
            JTextField time3Field = new JTextField(time3);
            JTextField time4Field = new JTextField(time4);
            JTextField time5Field = new JTextField(time5);
            JTextField time6Field = new JTextField(time6);
            JTextField time7Field = new JTextField(time7);
            JTextField time8Field = new JTextField(time8);

            Object[] message = {
                    "Day:",dayLabel,
                    "8-9:", time1Field,
                    "9-10:", time2Field,
                    "10-11:", time3Field,
                    "11-12:", time4Field,
                    "12-13:", time5Field,
                    "13-14:", time6Field,
                    "14-15:", time7Field,
                    "15-16:", time8Field,
            };
            int option = JOptionPane.showConfirmDialog(null, message, "Update Timetable",
                    JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                tableModel.setValueAt(dayLabel.getText(), selectedRow, 0);
                tableModel.setValueAt(time1Field.getText(), selectedRow, 1);
                tableModel.setValueAt(time2Field.getText(), selectedRow, 2);
                tableModel.setValueAt(time3Field.getText(), selectedRow, 3);
                tableModel.setValueAt(time4Field.getText(), selectedRow, 4);
                tableModel.setValueAt(time5Field.getText(), selectedRow, 5);
                tableModel.setValueAt(time6Field.getText(), selectedRow, 6);
                tableModel.setValueAt(time7Field.getText(), selectedRow, 7);
                tableModel.setValueAt(time8Field.getText(), selectedRow, 8);

                // Update the timetable in the list
                Timetable updatedTimetable = new Timetable(
                        dayLabel.getText(),
                        time1Field.getText(),
                        time2Field.getText(),
                        time3Field.getText(),
                        time4Field.getText(),
                        time5Field.getText(),
                        time6Field.getText(),
                        time7Field.getText(),
                        time8Field.getText());
                if (level.equals("Math")) {
                    timetableMath.set(selectedRow, updatedTimetable);
                } else if (level.equals("Eng")) {
                    timetableEng.set(selectedRow, updatedTimetable);
                } else {
                    timetableSci.set(selectedRow, updatedTimetable);
                }
                JOptionPane.showMessageDialog(null, "Update Success.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to update.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JComboBox) {
            String choice = (String) comboBox.getSelectedItem();
            if ("Select".equals(choice)) {
                scrollPane.setVisible(false);
                updateButton.setVisible(false);
            } else if ("Student Math Timetable".equals(choice)) {
                // Remove All Row Before Create Row
                tableModel.setRowCount(0);

                for (Timetable timetable : timetableMath) {
                    Vector<String> row = new Vector<>();
                    row.addElement(timetable.getDay());
                    row.addElement(timetable.getTime1());
                    row.addElement(timetable.getTime2());
                    row.addElement(timetable.getTime3());
                    row.addElement(timetable.getTime4());
                    row.addElement(timetable.getTime5());
                    row.addElement(timetable.getTime6());
                    row.addElement(timetable.getTime7());
                    row.addElement(timetable.getTime8());
                    tableModel.addRow(row);
                }

                scrollPane.setVisible(true);
                updateButton.setVisible(true);

                level = "Math";

            } else if ("Student Eng Language Timetable".equals(choice)) {
                // Remove All Row Before Create Row
                tableModel.setRowCount(0);

                for (Timetable timetable : timetableEng) {
                    Vector<String> row = new Vector<>();
                    row.addElement(timetable.getDay());
                    row.addElement(timetable.getTime1());
                    row.addElement(timetable.getTime2());
                    row.addElement(timetable.getTime3());
                    row.addElement(timetable.getTime4());
                    row.addElement(timetable.getTime5());
                    row.addElement(timetable.getTime6());
                    row.addElement(timetable.getTime7());
                    row.addElement(timetable.getTime8());
                    tableModel.addRow(row);
                }
                scrollPane.setVisible(true);
                updateButton.setVisible(true);

                level = "Eng";

            } else if ("Student Science Timetable".equals(choice)) {
                // Remove All Row Before Create Row
                tableModel.setRowCount(0);

                for (Timetable timetable : timetableSci) {
                    Vector<String> row = new Vector<>();
                    row.addElement(timetable.getDay());
                    row.addElement(timetable.getTime1());
                    row.addElement(timetable.getTime2());
                    row.addElement(timetable.getTime3());
                    row.addElement(timetable.getTime4());
                    row.addElement(timetable.getTime5());
                    row.addElement(timetable.getTime6());
                    row.addElement(timetable.getTime7());
                    row.addElement(timetable.getTime8());
                    tableModel.addRow(row);
                }
                scrollPane.setVisible(true);
                updateButton.setVisible(true);

                level = "Sci";

            }
        }
    }

    public static void main(String[] args) {
        storeTimetable = new StoreTimetable();
        new TimetableManagementSystem();
    }
}

