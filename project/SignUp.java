package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Window;

import javax.swing.border.LineBorder;

public class SignUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField textpassword;
	private JTextField textemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 458);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 21));
		lblNewLabel.setBounds(276, 32, 256, 31);
		contentPane.add(lblNewLabel);
		
		JLabel emailtxt = new JLabel("Email");
		emailtxt.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		emailtxt.setBounds(276, 144, 86, 14);
		contentPane.add(emailtxt);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(276, 194, 71, 14);
		contentPane.add(lblNewLabel_2);
		
		textUsername = new JTextField();
		textUsername.setBorder(null);
		textUsername.setBounds(276, 107, 160, 20);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		textpassword = new JPasswordField();
		textpassword.setBorder(null);
		textpassword.setBounds(276, 209, 160, 20);
		contentPane.add(textpassword);
		
		JLabel coursebox = new JLabel("Course");
		coursebox.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		coursebox.setBounds(276, 313, 46, 14);
		contentPane.add(coursebox);
		
		JComboBox courseBox = new JComboBox();
		courseBox.addMouseListener(new MouseAdapter() {});
		courseBox.setBackground(new Color(255, 255, 255));
		courseBox.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		courseBox.setModel(new DefaultComboBoxModel(new String[] {"BSc Hons Computer Science", "BCA", "CSIT"}));
		courseBox.setBounds(357, 308, 185, 22);
		contentPane.add(courseBox);
		courseBox.setVisible(false);
		coursebox.setVisible(false);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString().equals("Student")){
					courseBox.setVisible(true);
					coursebox.setVisible(true);
			}else {
					courseBox.setVisible(false);
					coursebox.setVisible(false);
			}
			}
		});
		comboBox.setBorder(null);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Instructor", "Student"}));
		comboBox.setBounds(276, 275, 266, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Mode");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(276, 240, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = textUsername.getText();
				String password = textpassword.getText();
				String email = textemail.getText();
				String value = comboBox.getSelectedItem().toString();
				String course = courseBox.getSelectedItem().toString();
				
				String url ="jdbc:mysql://localhost:3306/coursemanagementsystem";
				String username1 = "root";
				String password1 = "";
				Connection con;
				if (!username.equals("") && !password.equals("") && !email.equals("") && !value.equals("")) {
					try {
						con = DriverManager.getConnection(url, username1,password1);
						Statement st = con.createStatement();
	//					System.out.println("Connection Success");
						if(value.equals("Student")) {
							String insertQuery = "INSERT INTO students (username, email, password, course) VALUES ('" + username + "','" + email + "','" + password + "','" + course + "')";
							st.execute(insertQuery);
						}else if(value.equals("Admin")) {
							String insertQuery = "INSERT INTO admin (admin_name, admin_email, admin_password) VALUES ('" + username + "','" + email + "','" + password + "')";
							st.execute(insertQuery);
						}else {
							String insertQuery = "INSERT INTO instructor (teacher_name, teacher_email, teacher_password) VALUES ('" + username + "','" + email + "','" + password + "')";
							st.execute(insertQuery);
						}
						
						Login l = new Login();
						l.setVisible(true);
						dispose();
						con.close();
					}catch(Exception ea){
						System.out.println(ea);
				}
				}else {
					JOptionPane.showMessageDialog(null, "Sign Up Failed", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
//				System.out.println(username);
//				System.out.println(password);
				
//				System.out.println(value);
			}
		});
		btnNewButton.setBackground(new Color(62, 62, 62));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(328, 348, 160, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(276, 94, 86, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textemail = new JTextField();
		textemail.setBorder(null);
		textemail.setBounds(276, 158, 160, 20);
		contentPane.add(textemail);
		textemail.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(62, 62, 62));
		panel.setBounds(0, 0, 221, 419);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcomeBack = new JLabel("Welcome Back!");
		lblWelcomeBack.setForeground(Color.WHITE);
		lblWelcomeBack.setFont(new Font("Yu Gothic UI", Font.BOLD, 23));
		lblWelcomeBack.setBounds(35, 96, 176, 44);
		panel.add(lblWelcomeBack);
		
		JLabel lblNewLabel_4 = new JLabel("Already have an account?");
		lblNewLabel_4.setBounds(41, 161, 140, 14);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(41, 196, 140, 31);
		panel.add(btnLogin);
		btnLogin.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login lg = new Login();
				lg.setVisible(true);
				dispose();
			}
		});
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_1 = new JLabel("__________________________________");
		lblNewLabel_1.setBounds(276, 119, 256, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("__________________________________");
		lblNewLabel_1_2.setBounds(276, 169, 254, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("__________________________________");
		lblNewLabel_1_2_1.setBounds(276, 219, 254, 14);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(SignUp.class.getResource("/Images/useri.png")));
		lblNewLabel_5.setBounds(531, 107, 46, 31);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon(SignUp.class.getResource("/Images/email.png")));
		lblNewLabel_5_1.setBounds(531, 158, 46, 31);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("");
		lblNewLabel_5_1_1.setIcon(new ImageIcon(SignUp.class.getResource("/Images/pw.png")));
		lblNewLabel_5_1_1.setBounds(531, 209, 46, 31);
		contentPane.add(lblNewLabel_5_1_1);
		
		
	}
}
