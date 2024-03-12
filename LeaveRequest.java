

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class LeaveRequest extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
	public LeaveRequest() {
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
		leaverequest.setBounds(92, 309, 112, 29);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(266, 54, 698, 405);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"EmployeeID", "Full Name", "Reason", "Start Date", "End Date"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sam\\Downloads\\ui\\leaveapproval.png"));
		lblNewLabel.setBounds(0, 0, 1000, 563);
		contentPane.add(lblNewLabel);
	}

}
