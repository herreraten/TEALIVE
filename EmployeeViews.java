import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeViews extends JFrame {

    private JPanel contentPane;
    private JLabel dateTimeLabel;
    private JTextField id;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EmployeeViews frame = new EmployeeViews();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public EmployeeViews() {
        initialize();
        startClock();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 593);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        id = new JTextField();
        id.setBounds(483, 67, 234, 36);
        id.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        id.setBorder(null); // Set border to null to remove it
        id.setOpaque(false);
        contentPane.add(id);
        id.setColumns(10);

        dateTimeLabel = new JLabel();
        dateTimeLabel.setFont(new Font("Cooper Black", Font.PLAIN, 58));
        dateTimeLabel.setBounds(266, 142, 673, 229);
        contentPane.add(dateTimeLabel);

        JButton btnTimeIn = new JButton("");
        btnTimeIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String employeeId = id.getText().trim();
                if (!employeeId.isEmpty()) {
                    timeInAction1(employeeId);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter employee ID.");
                }
            }
        });
        btnTimeIn.setBounds(338, 442, 176, 49);
        btnTimeIn.setBorderPainted(false);
        btnTimeIn.setContentAreaFilled(false);
        btnTimeIn.setOpaque(false);
        contentPane.add(btnTimeIn);

        JButton btnTimeOut = new JButton("");
        btnTimeOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String employeeId = id.getText().trim();
                if (!employeeId.isEmpty()) {
                    timeOutAction(employeeId);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter employee ID.");
                }
            }
        });
        btnTimeOut.setBounds(679, 442, 185, 49);
        btnTimeOut.setBorderPainted(false);
        btnTimeOut.setContentAreaFilled(false);
        btnTimeOut.setOpaque(false);
        contentPane.add(btnTimeOut);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sam\\Downloads\\attendance.png"));
        lblNewLabel.setBounds(0, 0, 976, 563);
        contentPane.add(lblNewLabel);

		JButton overtime = new JButton("");
        overtime.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Employee_Overtime empo = new Employee_Overtime();
        		empo.setVisible(true);
        		dispose();
        	}
        });
        overtime.setBounds(76, 225, 89, 23);
        overtime.setBorderPainted(false);
		overtime.setContentAreaFilled(false);
		overtime.setOpaque(false);
        contentPane.add(overtime);
        
        JButton requestleave = new JButton("");
        requestleave.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Employee_Requestleave empr = new Employee_Requestleave();
        		empr.setVisible(true);
        		dispose();
        	}
        });
        requestleave.setBounds(76, 270, 89, 23);
        requestleave.setBorderPainted(false);
		requestleave.setContentAreaFilled(false);
		requestleave.setOpaque(false);
        contentPane.add(requestleave);
                
        JButton payroll = new JButton("");
        payroll.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Employee_Payroll emps = new Employee_Payroll();
        		emps.setVisible(true);
        		dispose();
        	}
        });
        payroll.setBounds(76, 326, 89, 23);
        payroll.setBorderPainted(false);
		payroll.setContentAreaFilled(false);
		payroll.setOpaque(false);
        contentPane.add(payroll);
                
        JButton logout = new JButton("");
        logout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		HomePage home = new HomePage();
        		home.setVisible(true);
        		dispose();
        	}
        });
        logout.setBounds(88, 508, 77, 23);
        logout.setBorderPainted(false);
		logout.setContentAreaFilled(false);
		logout.setOpaque(false);
        contentPane.add(logout);
        
        JButton attendance = new JButton("");
        attendance.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				EmployeeViews emp = new EmployeeViews();
				emp.setVisible(true);
				dispose();
			}
		});
        attendance.setBounds(76, 161, 89, 36);
        attendance.setBorderPainted(false);
        attendance.setContentAreaFilled(false);
        attendance.setOpaque(false);
        contentPane.add(attendance);
	}



    private void updateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateFormat.format(new Date());
        dateTimeLabel.setText(currentTime);
    }

    private void startClock() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
        timer.start();
    }
    
    private void timeInAction1(String employeeId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tealive", "root", "Tealivecafe2");
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM employee_attendance WHERE employeeID = '" + employeeId + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                // Employee ID exists in the table, proceed with time in action
                query = "UPDATE employee_attendance SET time_in = NOW(), date = CURDATE() WHERE employeeID = '" + employeeId + "'";
                stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Time In recorded successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid employee ID.");
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: Unable to record Time In.");
        }
    }


    private void timeInAction(String employeeId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tealive", "root", "Tealivecafe2");
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM employee_attendance WHERE employeeID = '" + employeeId + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                // Employee ID exists in the table, proceed with time in action
                query = "UPDATE employee_attendance SET time_in = NOW() WHERE employeeID = '" + employeeId + "'";
                stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Time In recorded successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid employee ID.");
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: Unable to record Time In.");
        }
    }

    private void timeOutAction(String employeeId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tealive", "root", "Tealivecafe2");
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM employee_attendance WHERE employeeID = '" + employeeId + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                // Employee ID exists in the table, proceed with time out action
                query = "UPDATE employee_attendance SET time_out = NOW() WHERE employeeID = '" + employeeId + "'";
                stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Time Out recorded successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid employee ID.");
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: Unable to record Time Out.");
        }
    }
       

}
