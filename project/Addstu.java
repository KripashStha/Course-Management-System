package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Addstu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField adduser;
	private JTextField addemail;
	private JTextField addpass;
	private Addstu adds;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addstu frame = new Addstu();
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
	public Addstu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 383);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBorder(new LineBorder(new Color(245, 245, 245), 28, true));
		panel_6_1.setBackground(Color.WHITE);
		panel_6_1.setBounds(31, 65, 560, 183);
		contentPane.add(panel_6_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setBounds(25, 22, 514, 150);
		panel_6_1.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 11, 86, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("______________________________");
		lblNewLabel_1_3.setBounds(10, 38, 224, 14);
		panel_1.add(lblNewLabel_1_3);
		
		adduser = new JTextField();
		adduser.setColumns(10);
		adduser.setBorder(null);
		adduser.setBackground(new Color(245, 245, 245));
		adduser.setBounds(10, 24, 208, 20);
		panel_1.add(adduser);
		
		JLabel lblNewLabel_2_1 = new JLabel("Email");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(290, 11, 86, 14);
		panel_1.add(lblNewLabel_2_1);
		
		addemail = new JTextField();
		addemail.setColumns(10);
		addemail.setBorder(null);
		addemail.setBackground(new Color(245, 245, 245));
		addemail.setBounds(290, 24, 208, 20);
		panel_1.add(addemail);
		
		JLabel lblNewLabel_2_2 = new JLabel("Password");
		lblNewLabel_2_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(10, 73, 86, 14);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("______________________________");
		lblNewLabel_1_3_2.setBounds(10, 100, 256, 14);
		panel_1.add(lblNewLabel_1_3_2);
		
		addpass = new JTextField();
		addpass.setColumns(10);
		addpass.setBorder(null);
		addpass.setBackground(new Color(245, 245, 245));
		addpass.setBounds(10, 86, 208, 20);
		panel_1.add(addpass);
		
		JLabel lblNewLabel_2_3 = new JLabel("Course");
		lblNewLabel_2_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(290, 73, 86, 14);
		panel_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("______________________________");
		lblNewLabel_1_3_3.setBounds(290, 38, 224, 14);
		panel_1.add(lblNewLabel_1_3_3);
		
		JComboBox courseBox = new JComboBox();
		courseBox.setBorder(null);
		courseBox.setModel(new DefaultComboBoxModel(new String[] {"BSc Hons Computer Science", "CSIT", "BCA", "BBA"}));
		courseBox.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		courseBox.setBackground(new Color(255, 255, 255));
		courseBox.setBounds(290, 96, 208, 22);
		panel_1.add(courseBox);
		
		JLabel lblAddStudentDetails = new JLabel("Add Student Details");
		lblAddStudentDetails.setFont(new Font("Yu Gothic UI", Font.BOLD, 21));
		lblAddStudentDetails.setBackground(new Color(245, 245, 245));
		lblAddStudentDetails.setBounds(34, 11, 199, 31);
		contentPane.add(lblAddStudentDetails);
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					String user = adduser.getText();
					String email = addemail.getText();
					String pass = addpass.getText();
					String course = courseBox.getSelectedItem().toString();
					if (!course.equals("") && !user.equals("") && !email.equals("") && !pass.equals("")) {
						try {
						String url = "jdbc:mysql://localhost:3306/coursemanagementsystem";
			            String username1 = "root";
			            String password1 = "";
			            Connection con = DriverManager.getConnection(url, username1, password1);
			           	Statement st = con.createStatement();
			            String sql = "INSERT INTO `students`(`username`, `email`, `password`, `course`) VALUES ('"+user+"','"+email+"','"+pass+"','"+course+"')";
			            st.execute(sql);
			            JOptionPane.showMessageDialog(null, "Added Successfully", "Successful", JOptionPane.INFORMATION_MESSAGE);
			            } catch (SQLException e1) {
							e1.printStackTrace();
						}
		            }else {
		            	 JOptionPane.showMessageDialog(null, "Fill all the Details", "Info", JOptionPane.ERROR_MESSAGE);
		            }
				}
		});
		btnAdd_1.setForeground(Color.WHITE);
		btnAdd_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnAdd_1.setBorder(null);
		btnAdd_1.setBackground(new Color(62, 62, 62));
		btnAdd_1.setBounds(209, 273, 181, 31);
		contentPane.add(btnAdd_1);
		
		JButton btnAdd_1_1 = new JButton("X");
		btnAdd_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adds.dispose();
			}
		});
		btnAdd_1_1.setForeground(Color.WHITE);
		btnAdd_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnAdd_1_1.setBorder(null);
		btnAdd_1_1.setBackground(new Color(62, 62, 62));
		btnAdd_1_1.setBounds(576, 22, 15, 17);
		contentPane.add(btnAdd_1_1);
	}
	
	public void setValue(Addstu adds) {
		this.adds = adds;
	}

}
