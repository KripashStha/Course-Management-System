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
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Addins extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField addinsuser;
	private JTextField addinsmail;
	private JTextField addinspass;
	private JTextField m1;
	private JTextField m2;
	private JTextField m4;
	private JTextField m3;
	private Addins ins;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addins frame = new Addins();
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
	public Addins() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 524);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBorder(new LineBorder(new Color(245, 245, 245), 28, true));
		panel_6_1.setBackground(Color.WHITE);
		panel_6_1.setBounds(57, 81, 560, 310);
		contentPane.add(panel_6_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setBounds(25, 22, 514, 268);
		panel_6_1.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(271, 11, 86, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("______________________________");
		lblNewLabel_1_3.setBounds(271, 38, 224, 14);
		panel_1.add(lblNewLabel_1_3);
		
		addinsuser = new JTextField();
		addinsuser.setColumns(10);
		addinsuser.setBorder(null);
		addinsuser.setBackground(new Color(245, 245, 245));
		addinsuser.setBounds(271, 24, 208, 20);
		panel_1.add(addinsuser);
		
		JLabel lblNewLabel_2_1 = new JLabel("Email");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(271, 75, 86, 14);
		panel_1.add(lblNewLabel_2_1);
		
		addinsmail = new JTextField();
		addinsmail.setColumns(10);
		addinsmail.setBorder(null);
		addinsmail.setBackground(new Color(245, 245, 245));
		addinsmail.setBounds(271, 88, 208, 20);
		panel_1.add(addinsmail);
		
		JLabel lblNewLabel_2_2 = new JLabel("Password");
		lblNewLabel_2_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(271, 142, 86, 14);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("______________________________");
		lblNewLabel_1_3_2.setBounds(271, 169, 256, 14);
		panel_1.add(lblNewLabel_1_3_2);
		
		addinspass = new JTextField();
		addinspass.setColumns(10);
		addinspass.setBorder(null);
		addinspass.setBackground(new Color(245, 245, 245));
		addinspass.setBounds(271, 155, 208, 20);
		panel_1.add(addinspass);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("______________________________");
		lblNewLabel_1_3_3.setBounds(271, 102, 224, 14);
		panel_1.add(lblNewLabel_1_3_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Module 1");
		lblNewLabel_2_4.setBounds(27, 11, 86, 14);
		panel_1.add(lblNewLabel_2_4);
		lblNewLabel_2_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_3_4 = new JLabel("____________________________");
		lblNewLabel_1_3_4.setBounds(27, 38, 208, 14);
		panel_1.add(lblNewLabel_1_3_4);
		
		m1 = new JTextField();
		m1.setBounds(27, 24, 208, 20);
		panel_1.add(m1);
		m1.setColumns(10);
		m1.setBorder(null);
		m1.setBackground(new Color(245, 245, 245));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Module 2");
		lblNewLabel_2_1_1.setBounds(27, 74, 86, 14);
		panel_1.add(lblNewLabel_2_1_1);
		lblNewLabel_2_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("____________________________");
		lblNewLabel_1_3_1_1.setBounds(27, 101, 208, 14);
		panel_1.add(lblNewLabel_1_3_1_1);
		
		m2 = new JTextField();
		m2.setBounds(27, 87, 208, 20);
		panel_1.add(m2);
		m2.setColumns(10);
		m2.setBorder(null);
		m2.setBackground(new Color(245, 245, 245));
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Module 4");
		lblNewLabel_2_3_1.setBounds(27, 205, 86, 14);
		panel_1.add(lblNewLabel_2_3_1);
		lblNewLabel_2_3_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_3_3_1 = new JLabel("____________________________");
		lblNewLabel_1_3_3_1.setBounds(27, 232, 208, 14);
		panel_1.add(lblNewLabel_1_3_3_1);
		
		m4 = new JTextField();
		m4.setBounds(27, 218, 208, 20);
		panel_1.add(m4);
		m4.setColumns(10);
		m4.setBorder(null);
		m4.setBackground(new Color(245, 245, 245));
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Module 3");
		lblNewLabel_2_2_1.setBounds(27, 138, 86, 14);
		panel_1.add(lblNewLabel_2_2_1);
		lblNewLabel_2_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_3_2_1 = new JLabel("____________________________");
		lblNewLabel_1_3_2_1.setBounds(27, 165, 208, 14);
		panel_1.add(lblNewLabel_1_3_2_1);
		
		m3 = new JTextField();
		m3.setBounds(27, 151, 208, 20);
		panel_1.add(m3);
		m3.setColumns(10);
		m3.setBorder(null);
		m3.setBackground(new Color(245, 245, 245));
		
		JLabel lblAddInstructorDetails = new JLabel("Add Instructor Details");
		lblAddInstructorDetails.setFont(new Font("Yu Gothic UI", Font.BOLD, 21));
		lblAddInstructorDetails.setBackground(new Color(245, 245, 245));
		lblAddInstructorDetails.setBounds(59, 27, 249, 31);
		contentPane.add(lblAddInstructorDetails);
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.setBounds(237, 423, 181, 31);
		contentPane.add(btnAdd_1);
		btnAdd_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String user = addinsuser.getText();
				String email = addinsmail.getText();
				String pass = addinspass.getText();
				String md1 = m1.getText();
				String md2 = m2.getText();
				String md3 = m3.getText();
				String md4 = m4.getText();
				if (!user.equals("") && !email.equals("") && !pass.equals("") && !md1.equals("") && !md2.equals("") && !md3.equals("") && !md4.equals("")) {
					try {
					String url = "jdbc:mysql://localhost:3306/coursemanagementsystem";
		            String username1 = "root";
		            String password1 = "";
		            Connection con = DriverManager.getConnection(url, username1, password1);
		           	Statement st = con.createStatement();
		            String sql = "INSERT INTO `instructor`(`teacher_name`, `teacher_email`, `teacher_password`, `Module_1`, `Module_2`, `Module_3`, `Module_4`) VALUES ('"+user+"','"+email+"','"+pass+"','"+md1+"','"+md2+"','"+md3+"','"+md4+"')";
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
		
		JButton btnAdd_1_1 = new JButton("X");
		btnAdd_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ins.dispose();
			}
		});
		btnAdd_1_1.setForeground(Color.WHITE);
		btnAdd_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnAdd_1_1.setBorder(null);
		btnAdd_1_1.setBackground(new Color(62, 62, 62));
		btnAdd_1_1.setBounds(602, 36, 15, 17);
		contentPane.add(btnAdd_1_1);
	}

	public void setAddins(Addins ins) {
		this.ins = ins;
		
	}

}
