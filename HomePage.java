
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sam\\Downloads\\ui\\homepage.png"));
		lblNewLabel.setBounds(0, 0, 1000, 563);
		contentPane.add(lblNewLabel);
		
		JButton Employee = new JButton("New button");
		Employee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeViews emp = new EmployeeViews();
				emp.setVisible(true);
				dispose();
			}
		});
		Employee.setBounds(685, 358, 174, 39);
		Employee.setBorderPainted(false);
		Employee.setContentAreaFilled(false);
		Employee.setOpaque(false);
		contentPane.add(Employee);
		
		JButton Admin = new JButton("New button");
		Admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminlogin adm = new adminlogin();
				adm.setVisible(true);
				dispose();
			}
		});
		Admin.setBounds(685, 291, 174, 39);
		Admin.setBorderPainted(false);
		Admin.setContentAreaFilled(false);
		Admin.setOpaque(false);
		contentPane.add(Admin);
	}
}
