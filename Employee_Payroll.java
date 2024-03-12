
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Employee_Payroll extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_Payroll frame = new Employee_Payroll();
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
	public Employee_Payroll() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
        
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
        

        JButton btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				EmployeeViews emp = new EmployeeViews();
				emp.setVisible(true);
				dispose();
			}
		});
        btnNewButton.setBounds(70, 148, 95, 49);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setOpaque(false);
        contentPane.add(btnNewButton);
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
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(245, 111, 705, 352);
        contentPane.add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"PayrolID", "EmployeeID", "Full Name", "Total Hours ", "Total Overtime Hours", "Gross Pay"
        	}
        ));
        scrollPane.setViewportView(table);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sam\\Downloads\\shifthours.png"));
        lblNewLabel.setBounds(0, 0, 1013, 556);
        contentPane.add(lblNewLabel);
		
	}

}
