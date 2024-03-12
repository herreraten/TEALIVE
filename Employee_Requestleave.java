

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Employee_Requestleave extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_Requestleave frame = new Employee_Requestleave();
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
	public Employee_Requestleave() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
        
        textField = new JTextField();
        textField.setBounds(296, 195, 245, 19);
        contentPane.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(296, 252, 245, 19);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(632, 229, 245, 19);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(301, 349, 597, 71);
        contentPane.add(textField_3);
        textField_3.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sam\\Downloads\\requestleave.png"));
        lblNewLabel.setBounds(0, 0, 1000, 563);
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBounds(476, 497, 239, 23);
        contentPane.add(btnNewButton);
	}
}
