import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class adminlogin extends JFrame {

    private JPanel contentPane;
    private JTextField Email;
    private JPasswordField Password;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    adminlogin frame = new adminlogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public adminlogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 593);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton backbtn = new JButton("");
        backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HomePage home = new HomePage();
                home.setVisible(true);
                dispose();
            }
        });
        backbtn.setBounds(10, 25, 82, 55);
        backbtn.setBorderPainted(false);
        backbtn.setContentAreaFilled(false);
        backbtn.setOpaque(false);
        contentPane.add(backbtn);
        
        JButton Login = new JButton("");
        Login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retrieve email and password
                String email = Email.getText();
                String pass = new String(Password.getPassword());
                
                // Add your login logic here
                // For example, you can check if email and password match some predefined values
                if(email.equals("admin123") && pass.equals("admin123")) {
                    // If login is successful, show a message
                    JOptionPane.showMessageDialog(null, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    EmployeeDetails details = new EmployeeDetails();
                    details.setVisible(true);
                    dispose();
                    
                    // You can add code here to open a new window or perform any other action
                } else {
                    // If login fails, show an error message using JOptionPane
                    JOptionPane.showMessageDialog(null, "Invalid email or password. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });
        Login.setBounds(188, 445, 142, 34);
        Login.setBorderPainted(false);
        Login.setContentAreaFilled(false);
        Login.setOpaque(false);
        contentPane.add(Login);
        
        Email = new JTextField();
        Email.setBounds(86, 252, 294, 27);
        Email.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Email.setBackground(null);
        Email.setBorder(null);
        Email.setOpaque(false);
        contentPane.add(Email);
        Email.setColumns(10);
        
        Password = new JPasswordField();
        Password.setBounds(86, 358, 294, 27);
        Password.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Password.setBackground(null);
        Password.setBorder(null); // Remove border
        Password.setOpaque(false);
        contentPane.add(Password);
        
        
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sam\\Downloads\\ui\\adminlogin.png"));
        lblNewLabel.setBounds(0, 0, 1000, 563);
        contentPane.add(lblNewLabel);
    }
}
