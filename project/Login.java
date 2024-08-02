package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textemail;
	private JPasswordField textpassword;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 437);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textemail = new JTextField();
		textemail.setBorder(null);
		textemail.setBounds(280, 104, 191, 20);
		contentPane.add(textemail);
		textemail.setColumns(10);
		
		textpassword = new JPasswordField();
		textpassword.setBorder(null);
		textpassword.setBounds(280, 160, 191, 20);
		contentPane.add(textpassword);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBorder(null);
		comboBox.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Student", "Instructor"}));
		comboBox.setBounds(280, 231, 267, 22);
		contentPane.add(comboBox);
		
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(62, 62, 62));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    String email = textemail.getText();
			    String password = textpassword.getText();
			    String value = comboBox.getSelectedItem().toString();
			    if (!email.equals("") && !password.equals("") && !value.equals("")) {
			        try {
			            String url = "jdbc:mysql://localhost:3306/coursemanagementsystem";
			            String username1 = "root";
			            String password1 = "";
			            Connection con = DriverManager.getConnection(url, username1, password1);
			            Statement st = con.createStatement();

			            // Mysql query
			            String tableName = "";
			            String emailColumnName = "";
			            String passwordColumnName = "";

			            if (value.equals("Student")) {
			                tableName = "students";
			                emailColumnName = "email";
			                passwordColumnName = "password";
			            } else if (value.equals("Admin")) {
			                tableName = "admin";
			                emailColumnName = "admin_email";
			                passwordColumnName = "admin_password";
			            } else {
			                tableName = "instructor";
			                emailColumnName = "teacher_email";
			                passwordColumnName = "teacher_password";
			            }

			            // Using PreparedStatement to prevent SQL injection
			            String sql = "SELECT * FROM " + tableName + " WHERE " + emailColumnName + "=? AND " + passwordColumnName + "=?";
			            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			                preparedStatement.setString(1, email);
			                preparedStatement.setString(2, password);
			                ResultSet rs = preparedStatement.executeQuery();

			                if (rs.next()) {
			                    // If username and password are correct.
			                    Dashboard d = new Dashboard();
			                    d.setValue(value);
			                    d.setVisible(true);
			                    dispose();
			                    String query = "SELECT COUNT(username) FROM students";
					            ResultSet r = st.executeQuery(query);
					            while (r.next()) {
					                int studentCount = r.getInt(1);
					                d.getStudenttotal().setText(String.valueOf(studentCount));
					            }
					            //to find total instructor
					            String query1 = "SELECT COUNT(teacher_name) FROM instructor";
					            ResultSet rs1 = st.executeQuery(query1);
					            while (rs1.next()) {
					                int teacherCount = rs1.getInt(1);
					                d.getInstotal().setText(String.valueOf(teacherCount));
					            }
					            String query2 = "SELECT COUNT(course) FROM course";
					            ResultSet rs2 = st.executeQuery(query2);
					            while (rs2.next()) {
					                int courseCount = rs2.getInt(1);
					                d.getCoursetotal().setText(String.valueOf(courseCount));
					            }
					         
						        	String sql1 = "Select * from course";
									ResultSet rs3 = st.executeQuery(sql1);
									ResultSetMetaData rsmd = (ResultSetMetaData) rs3.getMetaData();
									DefaultTableModel model = (DefaultTableModel) d.getCoursetable().getModel();
									
									int cols = rsmd.getColumnCount();
									String[] colName = new String[cols];
									for(int i = 0; i<cols; i++) {
										colName[i]=rsmd.getColumnName(i+1);
									}
									model.setColumnIdentifiers(colName);
									String id, course, year, sem, mod1, mod2, mod3, mod4;
									while (rs3.next()) {
										id = rs3.getString(1);
										course = rs3.getString(2);
										year = rs3.getString(3);
										sem = rs3.getString(4);
										mod1 = rs3.getString(5);
										mod2 = rs3.getString(6);
										mod3 = rs3.getString(7);
										mod4 = rs3.getString(8);
										
										String[] row = {id, course, year, sem, mod1, mod2, mod3, mod4 };
										model.addRow(row);
									}
					            
								if(value.equals("Admin") || value.equals("Student")) {
									String sql2 = "Select * from instructor";
									ResultSet rs4 = st.executeQuery(sql2);
									ResultSetMetaData rsmd1 = (ResultSetMetaData) rs4.getMetaData();
									DefaultTableModel model1 = (DefaultTableModel) d.getInstable().getModel();
									
									int cols1 = rsmd1.getColumnCount();
									String[] colName1 = new String[cols1];
									for(int i = 0; i<cols1; i++) {
										colName1[i]=rsmd1.getColumnName(i+1);
									}
									model1.setColumnIdentifiers(colName1);
									String tid, name, mail, pass, md1, md2, md3, md4 ;
									while (rs4.next()) {
										tid = rs4.getString(1);
										name = rs4.getString(2);
										mail = rs4.getString(3);
										pass = rs4.getString(4);
										md1 =	rs4.getString(5);
										md2 =	rs4.getString(6);
										md3 =	rs4.getString(7);
										md4 =	rs4.getString(8);
										
										String[] row1 = {tid, name, mail, pass, md1, md2, md3, md4 };
										model1.addRow(row1);
									}
								}else if(value.equals("Instructor")) {
									String sqlf="select * from instructor where teacher_email= '"+email+"' and teacher_password='"+password+"'";
						            ResultSet rsf = st.executeQuery(sqlf);
						            ResultSetMetaData rsmd1 = (ResultSetMetaData) rsf.getMetaData();
									DefaultTableModel model1 = (DefaultTableModel) d.getInstable().getModel();
									int cols1 = rsmd1.getColumnCount();
									String[] colName1 = new String[cols1];
									for(int i = 0; i<cols1; i++) {
										colName1[i]=rsmd1.getColumnName(i+1);
									}
									model1.setColumnIdentifiers(colName1);
									String tid, name, mail, pass, md1, md2, md3, md4 ;
									while (rsf.next()) {
										tid = rsf.getString(1);
										name = rsf.getString(2);
										mail = rsf.getString(3);
										pass = rsf.getString(4);
										md1 =	rsf.getString(5);
										md2 =	rsf.getString(6);
										md3 =	rsf.getString(7);
										md4 =	rsf.getString(8);
										
										String[] row1 = {tid, name, mail, pass, md1, md2, md3, md4 };
										model1.addRow(row1);
									}
								}
								if(value.equals("Admin") || value.equals("Instructor")) {
									String sql3 = "Select * from students";
									ResultSet rs5 = st.executeQuery(sql3);
									ResultSetMetaData rsmd2 = (ResultSetMetaData) rs5.getMetaData();
									DefaultTableModel model2 = (DefaultTableModel) d.getStutable().getModel();
									
									int cols2 = rsmd2.getColumnCount();
									String[] colName2 = new String[cols2];
									for(int i = 0; i<cols2; i++) {
										colName2[i]=rsmd2.getColumnName(i+1);
									}
									model2.setColumnIdentifiers(colName2);
									String sid, sname, smail, spass, scourse ;
									while (rs5.next()) {
										sid = rs5.getString(1);
										sname = rs5.getString(2);
										smail = rs5.getString(3);
										spass = rs5.getString(4);
										scourse = rs5.getString(5);
										
										String[] row1 = {sid, sname, smail, spass, scourse };
										model2.addRow(row1);
									}
								}else if(value.equals("Student")) {
									String sqlf="select * from students where email= '"+email+"' and password='"+password+"'";
						            ResultSet rsf = st.executeQuery(sqlf);
						            ResultSetMetaData rsmd1 = (ResultSetMetaData) rsf.getMetaData();
									DefaultTableModel model1 = (DefaultTableModel) d.getStutable().getModel();
									int cols1 = rsmd1.getColumnCount();
									String[] colName1 = new String[cols1];
									for(int i = 0; i<cols1; i++) {
										colName1[i]=rsmd1.getColumnName(i+1);
									}
									model1.setColumnIdentifiers(colName1);
									String tid, name, mail, pass, scourse ;
									while (rsf.next()) {
										tid = rsf.getString(1);
										name = rsf.getString(2);
										mail = rsf.getString(3);
										pass = rsf.getString(4);
										scourse = rsf.getString(5);
										
										String[] row1 = {tid, name, mail, pass, scourse };
										model1.addRow(row1);
									}

								}
								if(value.equals("Admin") || value.equals("Instructor")) {
									String sql3 = "Select * from result";
									ResultSet rs5 = st.executeQuery(sql3);
									ResultSetMetaData rsmd2 = (ResultSetMetaData) rs5.getMetaData();
									DefaultTableModel model2 = (DefaultTableModel) d.getResulttable().getModel();
									
									int cols2 = rsmd2.getColumnCount();
									String[] colName2 = new String[cols2];
									for(int i = 0; i<cols2; i++) {
										colName2[i]=rsmd2.getColumnName(i+1);
									}
									model2.setColumnIdentifiers(colName2);
									String rid, sid, courses, seme, md1, md2, md3, md4, mr1, mr2, mr3, mr4, re ;
									while (rs5.next()) {
										rid = rs5.getString(1);
										sid = rs5.getString(2);
										courses = rs5.getString(3);
										seme = rs5.getString(4);
										md1 = rs5.getString(5);
										mr1 = rs5.getString(6);
										md2 = rs5.getString(7);
										mr2 = rs5.getString(8);
										md3 = rs5.getString(9);
										mr3 = rs5.getString(10);
										md4 = rs5.getString(11);
										mr4 = rs5.getString(12);
										re =rs5.getString(13);
										String[] row1 = {rid, sid, courses, seme, md1, mr1, md2, mr2, md3, mr3, md4, mr4, re};
										model2.addRow(row1);
									}
								}

			                } else {
			                    // If username and password are wrong
			                    JOptionPane.showMessageDialog(null, "Login Failed", "Error", JOptionPane.ERROR_MESSAGE);
			                    textemail.setText("");
			                    textpassword.setText("");
			                }
			                
			            }
			            con.close();
			        } catch (Exception ea) {
			            System.out.println(ea);
			        }
			    } else {
			        JOptionPane.showMessageDialog(null, "Login Failed");
			    }
			}
		});
		
		btnNewButton.setBounds(280, 280, 244, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2_1 = new JLabel("Don't have an account?");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(319, 322, 130, 14);
		contentPane.add(lblNewLabel_2_1);
		
		
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Yu Gothic UI", Font.BOLD, 21));
		lblLogin.setBounds(280, 29, 256, 31);
		contentPane.add(lblLogin);
		
		JLabel emailtxt = new JLabel("Email");
		emailtxt.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		emailtxt.setBounds(280, 90, 86, 14);
		contentPane.add(emailtxt);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(280, 144, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mode");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(280, 196, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("__________________________________");
		lblNewLabel_1_2.setBounds(280, 112, 256, 23);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("__________________________________");
		lblNewLabel_1_3.setBounds(280, 171, 256, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon(Login.class.getResource("/Images/email.png")));
		lblNewLabel_5_1.setBounds(524, 114, 46, 20);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("");
		lblNewLabel_5_1_1.setIcon(new ImageIcon(Login.class.getResource("/Images/pw.png")));
		lblNewLabel_5_1_1.setBounds(524, 165, 46, 20);
		contentPane.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Sign Up");
		lblNewLabel_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp s = new SignUp();
				s.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(450, 322, 63, 15);
		contentPane.add(lblNewLabel_2_1_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(62, 62, 62));
		panel.setBounds(0, 0, 207, 398);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCourseManagementSystem = new JLabel("CMS");
		lblCourseManagementSystem.setForeground(Color.WHITE);
		lblCourseManagementSystem.setFont(new Font("Yu Gothic UI", Font.BOLD, 21));
		lblCourseManagementSystem.setBounds(83, 132, 51, 22);
		panel.add(lblCourseManagementSystem);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Images/cms.png")));
		lblNewLabel.setBounds(92, 108, 24, 29);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Start your journey with Course ");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(24, 175, 162, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("        Management System.");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(24, 190, 152, 22);
		panel.add(lblNewLabel_1_1);
		
		
	}
	

}
