	
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
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.ResultSetMetaData;
	import java.sql.SQLException;
	import java.sql.Statement;
	
	
	public class EmployeeDetails extends JFrame {
	
		private JPanel contentPane;
		private JTable table;
	
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						EmployeeDetails frame = new EmployeeDetails();
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
		public EmployeeDetails() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1000, 593);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
			setContentPane(contentPane);
			
			JButton employeedetails = new JButton("");
			employeedetails.setBounds(82, 138, 89, 34);
			employeedetails.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EmployeeDetails det = new EmployeeDetails();
					det.setVisible(true);
					dispose();
				}
			});
			contentPane.setLayout(null);
			employeedetails.setBorderPainted(false);
			employeedetails.setContentAreaFilled(false);
			employeedetails.setOpaque(false);
			contentPane.add(employeedetails);
			
			JButton employeeattendance = new JButton("");
			employeeattendance.setBounds(88, 193, 89, 39);
			employeeattendance.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EmployeeAttendance att = new EmployeeAttendance();
					att.setVisible(true);
					dispose();
				}
			});
			employeeattendance.setBorderPainted(false);
			employeeattendance.setContentAreaFilled(false);
			employeeattendance.setOpaque(false);
			contentPane.add(employeeattendance);
			
			JButton overtime = new JButton("");
			overtime.setBounds(82, 242, 89, 34);
			overtime.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Overtime ovr = new Overtime();
					ovr.setVisible(true);
					dispose();
				}
			});
			overtime.setBorderPainted(false);
			overtime.setContentAreaFilled(false);
			overtime.setOpaque(false);
			contentPane.add(overtime);
			
			JButton leaverequest = new JButton("");
			leaverequest.setBounds(88, 299, 110, 34);
			leaverequest.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LeaveRequest leave = new LeaveRequest();
					leave.setVisible(true);
					dispose();
				}
			});
			leaverequest.setBorderPainted(false);
			leaverequest.setContentAreaFilled(false);
			leaverequest.setOpaque(false);
			contentPane.add(leaverequest);
			
			JButton shifthours = new JButton("");
			shifthours.setBounds(88, 360, 100, 39);
			shifthours.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EmployeesShiftHour sft = new EmployeesShiftHour();
					sft.setVisible(true);
					dispose();
				}
			});
			shifthours.setBorderPainted(false);
			shifthours.setContentAreaFilled(false);
			shifthours.setOpaque(false);
			contentPane.add(shifthours);
			
			JButton logout = new JButton("");
			logout.setBounds(88, 511, 89, 23);
			logout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HomePage home = new HomePage();
					home.setVisible(true);
					dispose();
				}
			});
			logout.setBorderPainted(false);
			logout.setContentAreaFilled(false);
			logout.setOpaque(false);
			contentPane.add(logout);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setBounds(0, 0, 1000, 563);
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sam\\Downloads\\employeedetails.png"));
			contentPane.add(lblNewLabel);
			
			JButton addemployee = new JButton("");
			addemployee.setBounds(60, 425, 138, 34);
			addemployee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addEmployeee add = new addEmployeee();
					add.setVisible(true);
					dispose();
				}
			});
			addemployee.setBorderPainted(false);
			addemployee.setContentAreaFilled(false);
			addemployee.setOpaque(false);
			contentPane.add(addemployee);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(271, 77, 684, 382);
			contentPane.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			
			JButton btnNewButton = new JButton("SHOW");
			btnNewButton.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        try {
			            Class.forName("com.mysql.cj.jdbc.Driver");
			            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tealive", "root", "Tealivecafe2");
			            Statement stmt = con.createStatement();
			            String query = "select * from employeedetails";
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
			            
			            String no, name, email, age, birthdate, gender, contactnumber, address, position;
			            while (rs.next()) {
			                no = rs.getString(1);
			                name = rs.getString(2);
			                email = rs.getString(3);
			                age = rs.getString(4);
			                birthdate = rs.getString(5);
			                gender = rs.getString(6);
			                contactnumber = rs.getString(7);
			                address = rs.getString(8);
			                position = rs.getString(9);
			                String[] row = { no, name, email, age, birthdate, gender, contactnumber, address, position };
			                model.addRow(row);
			            }
			            stmt.close();
			            con.close();
			        } catch (ClassNotFoundException | SQLException e1) {
			            e1.printStackTrace();
			        }
			    }
			});		
			btnNewButton.setBounds(549, 500, 128, 35);
			btnNewButton.setBorderPainted(false);
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.setOpaque(false);
			contentPane.add(btnNewButton);
			
		}
	}
