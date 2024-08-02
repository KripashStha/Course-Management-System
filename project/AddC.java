package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.border.LineBorder;

public class AddC extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textcourse;
	private JTextField textm1;
	private JTextField textm2;
	private JTextField textm3;
	private JTextField textm4;
	private JTextField textyear;
	private JTextField textsem;
	private JTextField textField_1;
	private AddC ac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddC frame = new AddC();
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
	public AddC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 435);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textcourse = new JTextField();
		textcourse.setBackground(new Color(245, 245, 245));
		textcourse.setColumns(10);
		textcourse.setBorder(null);
		textcourse.setBounds(47, 108, 151, 20);
		contentPane.add(textcourse);
		
		JLabel addc = new JLabel("Add Course");
		addc.setFont(new Font("Yu Gothic UI", Font.BOLD, 21));
		addc.setBounds(41, 28, 191, 31);
		contentPane.add(addc);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblCourse.setBounds(47, 94, 86, 14);
		contentPane.add(lblCourse);
		
		JLabel lblNewLabel_2 = new JLabel("Module 1");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(47, 190, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("____________________");
		lblNewLabel_1_2.setBounds(47, 116, 162, 23);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("____________________________");
		lblNewLabel_1_3.setBounds(47, 217, 208, 14);
		contentPane.add(lblNewLabel_1_3);
		
		textm1 = new JTextField();
		textm1.setBackground(new Color(245, 245, 245));
		textm1.setColumns(10);
		textm1.setBorder(null);
		textm1.setBounds(47, 203, 208, 20);
		contentPane.add(textm1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Module 2");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(283, 190, 86, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("____________________________");
		lblNewLabel_1_3_1.setBounds(283, 217, 208, 14);
		contentPane.add(lblNewLabel_1_3_1);
		
		textm2 = new JTextField();
		textm2.setBackground(new Color(245, 245, 245));
		textm2.setColumns(10);
		textm2.setBorder(null);
		textm2.setBounds(283, 203, 208, 20);
		contentPane.add(textm2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Module 3");
		lblNewLabel_2_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(47, 254, 86, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("____________________________");
		lblNewLabel_1_3_2.setBounds(47, 281, 208, 14);
		contentPane.add(lblNewLabel_1_3_2);
		
		textm3 = new JTextField();
		textm3.setBackground(new Color(245, 245, 245));
		textm3.setColumns(10);
		textm3.setBorder(null);
		textm3.setBounds(47, 267, 208, 20);
		contentPane.add(textm3);
		
		JLabel lblNewLabel_2_3 = new JLabel("Module 4");
		lblNewLabel_2_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(283, 254, 86, 14);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("____________________________");
		lblNewLabel_1_3_3.setBounds(283, 281, 208, 14);
		contentPane.add(lblNewLabel_1_3_3);
		
		textm4 = new JTextField();
		textm4.setBackground(new Color(245, 245, 245));
		textm4.setColumns(10);
		textm4.setBorder(null);
		textm4.setBounds(283, 267, 208, 20);
		contentPane.add(textm4);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String addedcourse = textcourse.getText();
				String addedm1 = textm1.getText();
				String addedm2 = textm2.getText();
				String addedm3 = textm3.getText();
				String addedm4 = textm4.getText();
				String addedyear = textyear.getText();
				String addedsem = textsem.getText();
				if (!addedcourse.equals("") && !addedm1.equals("") && !addedm2.equals("") && !addedm3.equals("") && !addedm4.equals("") && !addedyear.equals("") && !addedsem.equals("")) {
					try {
					String url = "jdbc:mysql://localhost:3306/coursemanagementsystem";
		            String username1 = "root";
		            String password1 = "";
		            Connection con = DriverManager.getConnection(url, username1, password1);
		           	Statement st = con.createStatement();
		            String sql = "INSERT INTO `course`(`course`, `Year`, `Semester`, `Module_1`, `Module_2`, `Module_3`, `Module_4`) VALUES ('"+addedcourse+"','"+addedyear+"','"+addedsem+"','"+addedm1+"','"+addedm2+"','"+addedm3+"','"+addedm4+"')";
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
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(62, 62, 62));
		btnAdd.setBounds(186, 339, 181, 31);
		contentPane.add(btnAdd);
		
		textyear = new JTextField();
		textyear.setBackground(new Color(245, 245, 245));
		textyear.setColumns(10);
		textyear.setBorder(null);
		textyear.setBounds(232, 108, 64, 20);
		contentPane.add(textyear);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblYear.setBounds(232, 94, 86, 14);
		contentPane.add(lblYear);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("_____________");
		lblNewLabel_1_2_1.setBounds(232, 116, 137, 23);
		contentPane.add(lblNewLabel_1_2_1);
		
		textsem = new JTextField();
		textsem.setBackground(new Color(245, 245, 245));
		textsem.setColumns(10);
		textsem.setBorder(null);
		textsem.setBounds(386, 108, 80, 20);
		contentPane.add(textsem);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblSemester.setBounds(386, 94, 86, 14);
		contentPane.add(lblSemester);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("_____________");
		lblNewLabel_1_2_2.setBounds(386, 116, 124, 23);
		contentPane.add(lblNewLabel_1_2_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(245, 245, 245), 28, true));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(37, 81, 487, 69);
		contentPane.add(panel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setBounds(10, 11, 456, 47);
		panel_6.add(panel_1);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBorder(new LineBorder(new Color(245, 245, 245), 28, true));
		panel_6_1.setBackground(Color.WHITE);
		panel_6_1.setBounds(37, 170, 487, 150);
		contentPane.add(panel_6_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(245, 245, 245));
		textField_1.setBounds(450, 28, 97, 23);
		panel_6_1.add(textField_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(245, 245, 245));
		panel_1_1.setBounds(23, 11, 454, 124);
		panel_6_1.add(panel_1_1);
		
		JButton btnAdd_1_1 = new JButton("X");
		btnAdd_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ac.dispose();
			}
		});
		btnAdd_1_1.setForeground(Color.WHITE);
		btnAdd_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnAdd_1_1.setBorder(null);
		btnAdd_1_1.setBackground(new Color(62, 62, 62));
		btnAdd_1_1.setBounds(509, 37, 15, 17);
		contentPane.add(btnAdd_1_1);
	}

	public void setAddc(AddC ac) {
		this.ac = ac;
		
	}
}
