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

public class Editins extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField insuser;
	private JTextField insmail;
	private JTextField inspass;
	private JTextField insid;
	private JTextField m1;
	private JTextField m2;
	private JTextField m3;
	private JTextField m4;
	private Editins edins;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editins frame = new Editins();
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
	public Editins() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 459);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBorder(new LineBorder(new Color(245, 245, 245), 28, true));
		panel_6_1.setBackground(Color.WHITE);
		panel_6_1.setBounds(33, 64, 560, 291);
		contentPane.add(panel_6_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setBounds(25, 22, 514, 268);
		panel_6_1.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(27, 63, 86, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("______________________________");
		lblNewLabel_1_3.setBounds(27, 90, 224, 14);
		panel_1.add(lblNewLabel_1_3);
		
		insuser = new JTextField();
		insuser.setColumns(10);
		insuser.setBorder(null);
		insuser.setBackground(new Color(245, 245, 245));
		insuser.setBounds(27, 76, 208, 20);
		panel_1.add(insuser);
		
		JLabel lblNewLabel_2_1 = new JLabel("Email");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(27, 127, 86, 14);
		panel_1.add(lblNewLabel_2_1);
		
		insmail = new JTextField();
		insmail.setColumns(10);
		insmail.setBorder(null);
		insmail.setBackground(new Color(245, 245, 245));
		insmail.setBounds(27, 140, 208, 20);
		panel_1.add(insmail);
		
		JLabel lblNewLabel_2_2 = new JLabel("Password");
		lblNewLabel_2_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(27, 194, 86, 14);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("______________________________");
		lblNewLabel_1_3_2.setBounds(27, 221, 256, 14);
		panel_1.add(lblNewLabel_1_3_2);
		
		inspass = new JTextField();
		inspass.setColumns(10);
		inspass.setBorder(null);
		inspass.setBackground(new Color(245, 245, 245));
		inspass.setBounds(27, 207, 208, 20);
		panel_1.add(inspass);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("______________________________");
		lblNewLabel_1_3_3.setBounds(27, 154, 224, 14);
		panel_1.add(lblNewLabel_1_3_3);
		
		JLabel lblNewLabel_2_3 = new JLabel("Instructor Id");
		lblNewLabel_2_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(27, 0, 86, 14);
		panel_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("______________________________");
		lblNewLabel_1_3_1.setBounds(27, 27, 224, 14);
		panel_1.add(lblNewLabel_1_3_1);
		
		insid = new JTextField();
		insid.setColumns(10);
		insid.setBorder(null);
		insid.setBackground(new Color(245, 245, 245));
		insid.setBounds(27, 13, 208, 20);
		panel_1.add(insid);
		
		JLabel lblNewLabel_2_4 = new JLabel("Module 1");
		lblNewLabel_2_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_4.setBounds(272, 0, 86, 14);
		panel_1.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_1_3_4 = new JLabel("____________________________");
		lblNewLabel_1_3_4.setBounds(272, 27, 208, 14);
		panel_1.add(lblNewLabel_1_3_4);
		
		m1 = new JTextField();
		m1.setColumns(10);
		m1.setBorder(null);
		m1.setBackground(new Color(245, 245, 245));
		m1.setBounds(272, 13, 208, 20);
		panel_1.add(m1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Module 2");
		lblNewLabel_2_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(272, 63, 86, 14);
		panel_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("____________________________");
		lblNewLabel_1_3_1_1.setBounds(272, 90, 208, 14);
		panel_1.add(lblNewLabel_1_3_1_1);
		
		m2 = new JTextField();
		m2.setColumns(10);
		m2.setBorder(null);
		m2.setBackground(new Color(245, 245, 245));
		m2.setBounds(272, 76, 208, 20);
		panel_1.add(m2);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Module 4");
		lblNewLabel_2_3_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_3_1.setBounds(272, 194, 86, 14);
		panel_1.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_1_3_3_1 = new JLabel("____________________________");
		lblNewLabel_1_3_3_1.setBounds(272, 221, 208, 14);
		panel_1.add(lblNewLabel_1_3_3_1);
		
		m4 = new JTextField();
		m4.setColumns(10);
		m4.setBorder(null);
		m4.setBackground(new Color(245, 245, 245));
		m4.setBounds(272, 207, 208, 20);
		panel_1.add(m4);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Module 3");
		lblNewLabel_2_2_1.setBounds(272, 127, 86, 14);
		panel_1.add(lblNewLabel_2_2_1);
		lblNewLabel_2_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_3_2_1 = new JLabel("____________________________");
		lblNewLabel_1_3_2_1.setBounds(272, 154, 208, 14);
		panel_1.add(lblNewLabel_1_3_2_1);
		
		m3 = new JTextField();
		m3.setBounds(272, 140, 208, 20);
		panel_1.add(m3);
		m3.setColumns(10);
		m3.setBorder(null);
		m3.setBackground(new Color(245, 245, 245));
		
		JLabel lblEditInstructorDetails = new JLabel("Edit Instructor Details");
		lblEditInstructorDetails.setFont(new Font("Yu Gothic UI", Font.BOLD, 21));
		lblEditInstructorDetails.setBackground(new Color(245, 245, 245));
		lblEditInstructorDetails.setBounds(36, 11, 249, 31);
		contentPane.add(lblEditInstructorDetails);
		
		JButton btnAdd_1 = new JButton("Edit");
		btnAdd_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String gid = insid.getText();
				String user = insuser.getText();
				String pass = inspass.getText();
				String mail = insmail.getText();
				String md1 = m1.getText();
				String md2 = m2.getText();
				String md3 = m3.getText();
				String md4 = m4.getText();
				if (!gid.equals("") && !user.equals("") && !pass.equals("") && !mail.equals("") && !md1.equals("") && !md2.equals("") && !md3.equals("") && !md4.equals("")) {
					try {
					int insId = Integer.parseInt(gid); // Assuming courseId is an integer
					String url = "jdbc:mysql://localhost:3306/coursemanagementsystem";
		            String username1 = "root";
		            String password1 = "";
		            Connection con = DriverManager.getConnection(url, username1, password1);
		           	Statement st = con.createStatement();
		            String sql = "UPDATE `instructor` SET `teacher_name`='"+user+"',`teacher_email`='"+mail+"',`teacher_password`='"+pass+"',`Module_1`='"+md1+"',`Module_2`='"+md2+"',`Module_3`='"+md3+"',`Module_4`='"+md4+"' WHERE teacher_id = '"+gid+"'";
		            st.execute(sql);
		            JOptionPane.showMessageDialog(null, "Edited Successfully", "Successful", JOptionPane.INFORMATION_MESSAGE);
		            insid.setText("");
		            insuser.setText("");
		            inspass.setText("");
		            insmail.setText("");
		            m1.setText("");
		            m2.setText("");
		            m3.setText("");
		            m4.setText("");
		            }catch (NumberFormatException e1) {
			            // If parsing fails, display an error message
			            JOptionPane.showMessageDialog(null, "Invalid Instructor ID: Must be a number", "Error", JOptionPane.ERROR_MESSAGE);
			        }catch (SQLException e1) {
						e1.printStackTrace();
					}
	            }else {
	            	 JOptionPane.showMessageDialog(null, "Fill all the Details", "Info", JOptionPane.INFORMATION_MESSAGE);
	            }
			}
		});
		btnAdd_1.setBounds(215, 366, 181, 31);
		contentPane.add(btnAdd_1);
		btnAdd_1.setForeground(Color.WHITE);
		btnAdd_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnAdd_1.setBorder(null);
		btnAdd_1.setBackground(new Color(62, 62, 62));
		
		JButton btnAdd_1_1 = new JButton("X");
		btnAdd_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				edins.dispose();
			}
		});
		btnAdd_1_1.setForeground(Color.WHITE);
		btnAdd_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnAdd_1_1.setBorder(null);
		btnAdd_1_1.setBackground(new Color(62, 62, 62));
		btnAdd_1_1.setBounds(578, 20, 15, 17);
		contentPane.add(btnAdd_1_1);
	}

	public void setEditins(Editins edins) {
		this.edins = edins;		
	}
}
