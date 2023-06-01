package GUI;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Admin.StoreStudent;
import Admin.StoreTeacher;
import Admin.StoreTimetable;


public class MainFrame extends JFrame {
    private JPanel contentPane;
    private CardLayout cardLayout;
    private Login loginPanel;
    private AdminGui adminPanel;
    private static final int width = 700;
    private static final int height = 500;
    private static StoreTeacher storeTeacher = new StoreTeacher();
    private static StoreStudent storeStudent = new StoreStudent();
    private static StoreTimetable storeTimetable = new StoreTimetable();


    public MainFrame() {


        // Set up the frame
        setTitle("Page Switcher");
        setSize(width,height);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up the content pane with CardLayout
        contentPane = new JPanel();
        cardLayout = new CardLayout();
        contentPane.setLayout(cardLayout);
        add(contentPane);

        // Create the panels
        loginPanel = new Login(this);
        adminPanel = new AdminGui(this);

        // Add the panels to the content pane
        contentPane.add(loginPanel, "login");
        contentPane.add(adminPanel, "admin");

        // Show the admin panel by default
        cardLayout.show(contentPane, "login");
    }

    // Switch to the admin panel when the user logs in
    public void switchToAdminPanel() {
        adminPanel = new AdminGui(this);
        cardLayout.show(contentPane, "admin");
    }

    // Switch to the login panel when the user logs out
    public void switchToLoginPanel() {

        loginPanel = new Login(this);
        cardLayout.show(contentPane, "login");
    }


    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}
