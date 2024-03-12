import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

public class addEmployeee extends JFrame {

    private JPanel contentPane;
    private JTextField fullname;
    private JTextField gender;
    private JTextField contactnumber;
    private JTextField birthdate;
    private JTextField email;
    private JTextField address;
    private JTextField position;
    private JTextField employeeID;
    private JButton add;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LeaveRequest frame = new LeaveRequest();
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
    public addEmployeee() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 593);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        JButton employeedetails = new JButton("");
        employeedetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EmployeeDetails det = new EmployeeDetails();
                det.setVisible(true);
                dispose();
            }
        });
        
        position = new JTextField();
        position.setText("");
        position.setBounds(723, 225, 207, 34);
        position.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        position.setBorder(null); // Set border to null to remove it
        position.setOpaque(false);
        contentPane.add(position);
        position.setColumns(10);
        
        employeeID = new JTextField();
        employeeID.setBounds(723, 292, 207, 36);
        employeeID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        employeeID.setBorder(null); // Set border to null to remove it
        employeeID.setOpaque(false);
        contentPane.add(employeeID);
        employeeID.setColumns(10);
        
        address = new JTextField();
        address.setBounds(723, 149, 207, 36);
        address.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        address.setBorder(null); // Set border to null to remove it
        address.setOpaque(false);
        contentPane.add(address);
        address.setColumns(10);
        
        email = new JTextField();
        email.setBounds(378, 395, 207, 28);
        email.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        email.setBorder(null); // Set border to null to remove it
        email.setOpaque(false);
        contentPane.add(email);
        email.setColumns(10);
        
        birthdate = new JTextField();
        birthdate.setBounds(374, 332, 211, 36);
        birthdate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        birthdate.setBorder(null); // Set border to null to remove it
        birthdate.setOpaque(false);
        contentPane.add(birthdate);
        birthdate.setColumns(10);
        
        contactnumber = new JTextField();
        contactnumber.setBounds(374, 257, 211, 39);
        contactnumber.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contactnumber.setBorder(null); // Set border to null to remove it
        contactnumber.setOpaque(false);
        contentPane.add(contactnumber);
        contactnumber.setColumns(10);
        
        gender = new JTextField();
        gender.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        gender.setBorder(null); // Set border to null to remove it
        gender.setOpaque(false);
        gender.setBounds(374, 188, 211, 36);
        contentPane.add(gender);
        gender.setColumns(10);
        
        fullname = new JTextField();
        fullname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        fullname.setBounds(374, 116, 211, 36);
        fullname.setBorder(null); // Set border to null to remove it
        fullname.setOpaque(false);
        contentPane.add(fullname);

        fullname.setColumns(10);
        employeedetails.setBounds(82, 136, 89, 42);
        employeedetails.setBorderPainted(false);
        employeedetails.setContentAreaFilled(false);
        employeedetails.setOpaque(false);
        contentPane.add(employeedetails);
        
        JButton employeeattendance = new JButton("");
        employeeattendance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EmployeeAttendance att = new EmployeeAttendance();
                att.setVisible(true);
                dispose();
            }
        });
        employeeattendance.setBounds(82, 194, 107, 42);
        employeeattendance.setBorderPainted(false);
        employeeattendance.setContentAreaFilled(false);
        employeeattendance.setOpaque(false);
        contentPane.add(employeeattendance);
        
        JButton overtime = new JButton("");
        overtime.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Overtime ovr = new Overtime();
                ovr.setVisible(true);
                dispose();
            }
        });
        overtime.setBounds(82, 253, 89, 23);
        overtime.setBorderPainted(false);
        overtime.setContentAreaFilled(false);
        overtime.setOpaque(false);
        contentPane.add(overtime);
        
        JButton leaverequest = new JButton("");
        leaverequest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LeaveRequest leave = new LeaveRequest();
                leave.setVisible(true);
                dispose();
            }
        });
        leaverequest.setBounds(92, 299, 112, 39);
        leaverequest.setBorderPainted(false);
        leaverequest.setContentAreaFilled(false);
        leaverequest.setOpaque(false);
        contentPane.add(leaverequest);
        
        JButton shifthours = new JButton("");
        shifthours.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EmployeesShiftHour sft = new EmployeesShiftHour();
                sft.setVisible(true);
                dispose();
            }
        });
        shifthours.setBounds(82, 364, 107, 39);
        shifthours.setBorderPainted(false);
        shifthours.setContentAreaFilled(false);
        shifthours.setOpaque(false);
        contentPane.add(shifthours);
        
        JButton logout = new JButton("");
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HomePage home = new HomePage();
                home.setVisible(true);
                dispose();
            }
        });
        logout.setBounds(100, 510, 89, 36);
        logout.setBorderPainted(false);
        logout.setContentAreaFilled(false);
        logout.setOpaque(false);
        contentPane.add(logout);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sam\\Downloads\\addemployee.png"));
        lblNewLabel.setBounds(0, 0, 1000, 563);
        contentPane.add(lblNewLabel);
        JButton addemployee = new JButton("");
        addemployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addEmployeee add = new addEmployeee();
                add.setVisible(true);
                dispose();
            }
        });
        addemployee.setBounds(60, 425, 138, 34);
        addemployee.setBorderPainted(false);
        addemployee.setContentAreaFilled(false);
        addemployee.setOpaque(false);
        contentPane.add(addemployee);


        add = new JButton("");
        add.setBounds(823, 457, 107, 28);
        add.setBorderPainted(false);
        add.setContentAreaFilled(false);
        add.setOpaque(false);
        contentPane.add(add);


         add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Validate and get employee details
                String fullnameText = fullname.getText();
                String genderText = gender.getText();
                String contactNumberText = contactnumber.getText();
                String birthdateText = birthdate.getText();
                String emailText = email.getText();
                String addressText = address.getText();
                String positionText = position.getText();
                String employeeIDText = employeeID.getText();

                // Perform validations
                if (!contactNumberText.startsWith("+63")) {
                    JOptionPane.showMessageDialog(null, "Contact number must start with +63.");
                    return;
                }

                if (!isDateValid(birthdateText)) {
                    JOptionPane.showMessageDialog(null, "Invalid birthdate format. Please use YYYY-MM-DD.");
                    return;
                }

                // Calculate age from birthdate
                int age = calculateAge(birthdateText);

                // If all validations pass, add the employee to the database
                try {
                    // Create database connection
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tealive", "root", "Tealivecafe2");

                    // Prepare SQL statement with parameters for employee details table
                    String sqlEmployeeDetails = "INSERT INTO employeedetails (EmployeeID, Fullname, Email, Age, Birthdate, Gender, ContactNumber, Address, Position) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement statementEmployeeDetails = connection.prepareStatement(sqlEmployeeDetails);
                    statementEmployeeDetails.setString(1, employeeIDText);
                    statementEmployeeDetails.setString(2, fullnameText);
                    statementEmployeeDetails.setString(3, emailText);
                    statementEmployeeDetails.setInt(4, age); // Set age as an integer
                    statementEmployeeDetails.setString(5, birthdateText);
                    statementEmployeeDetails.setString(6, genderText);
                    statementEmployeeDetails.setString(7, contactNumberText);
                    statementEmployeeDetails.setString(8, addressText);
                    statementEmployeeDetails.setString(9, positionText);

                    // Execute the statement for employee details table
                    int rowsInsertedEmployeeDetails = statementEmployeeDetails.executeUpdate();

                    // Prepare SQL statement with parameters for employee attendance table
                    String sqlEmployeeAttendance = "INSERT INTO employee_attendance (EmployeeID, date, time_in, time_out) VALUES (?, ?, ?, ?)";
                    PreparedStatement statementEmployeeAttendance = connection.prepareStatement(sqlEmployeeAttendance);
                    statementEmployeeAttendance.setString(1, employeeIDText);
                    statementEmployeeAttendance.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
                    statementEmployeeAttendance.setNull(3, java.sql.Types.TIME);
                    statementEmployeeAttendance.setNull(4, java.sql.Types.TIME);

                    // Execute the statement for employee attendance table
                    int rowsInsertedEmployeeAttendance = statementEmployeeAttendance.executeUpdate();

                    // Check if both insertions were successful
                    if (rowsInsertedEmployeeDetails > 0 && rowsInsertedEmployeeAttendance > 0) {
                        JOptionPane.showMessageDialog(null, "Employee added successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Employee could not be added.");
                    }

                    // Close connections and statements
                    statementEmployeeDetails.close();
                    statementEmployeeAttendance.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: Employee could not be added.");
                }
            }
        });
    }

    // Method to check if a string is a valid number
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Method to check if a string is a valid date in YYYY-MM-DD format
    private boolean isDateValid(String str) {
        if (str == null || !str.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return false;
        }

        try {
            java.sql.Date.valueOf(str);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // Method to calculate age from birthdate
    private int calculateAge(String birthdate) {
        LocalDate today = LocalDate.now();
        LocalDate birth = LocalDate.parse(birthdate);
        return Period.between(birth, today).getYears();
    }
}
