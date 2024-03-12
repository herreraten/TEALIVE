	
	
	import java.awt.EventQueue;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JTable;
	import javax.swing.JScrollPane;
	
	public class EmployeeAttendance extends JFrame {
	
		private JPanel contentPane;
		private JTable table;
	
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						EmployeeAttendance frame = new EmployeeAttendance();
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
		public EmployeeAttendance() {
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
			employeedetails.setBounds(82, 134, 95, 43);
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
			employeeattendance.setBounds(82, 193, 95, 43);
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
			overtime.setBounds(88, 246, 89, 39);
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
			leaverequest.setBounds(92, 309, 108, 23);
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
			shifthours.setBounds(88, 364, 102, 39);
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
			logout.setBounds(101, 511, 89, 23);
			logout.setBorderPainted(false);
			logout.setContentAreaFilled(false);
			logout.setOpaque(false);
			contentPane.add(logout);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sam\\Downloads\\employeeattendance.png"));
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
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(280, 111, 650, 333);
			contentPane.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			
			JButton show = new JButton("");
			show.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
				        try {
				            Class.forName("com.mysql.cj.jdbc.Driver");
				            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tealive", "root", "Tealivecafe2");
				            Statement stmt = con.createStatement();
				            String query = "select * from employee_attendance";
				            ResultSet rs = stmt.executeQuery(query);
				            ResultSetMetaData rsmd = rs.getMetaData();
				            DefaultTableModel model = (DefaultTableModel) table.getModel();
				            
				            // Clear existing rows from the table model
				            model.setRowCount(0);

				            int cols = rsmd.getColumnCount();
				            String[] colName = new String[cols];
				            for (int i = 0; i < cols; i++)
				                colName[i] = rsmd.getColumnName(i + 1);
				            model.setColumnIdentifiers(colName);
				            
				            String no, name, time_in, time_out, date;
				            while (rs.next()) {
				                no = rs.getString(1);
				                name = rs.getString(2);
				                time_in = rs.getString(3);
				                time_out = rs.getString(4);
				                date = rs.getString(5);
				                
				                String[] row = { no, name, time_in , time_out, date };
				                model.addRow(row);
				            }
				            stmt.close();
				            con.close();
				        } catch (ClassNotFoundException | SQLException e1) {
				            e1.printStackTrace();
				        }
				    }
				});		
			show.setBounds(534, 513, 123, 33);
			show.setBorderPainted(false);
			show.setContentAreaFilled(false);
			addemployee.setOpaque(false);
			contentPane.add(show);
		}
	}
