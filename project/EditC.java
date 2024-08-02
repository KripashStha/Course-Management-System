package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EditC extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField courseid;
	private JTextField editm1;
	private JTextField editm2;
	private JTextField editm3;
	private JTextField editm4;
	private JTextField edity;
	private JTextField edits;
	private JTextField editc;
	private EditC ec;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditC frame = new EditC();
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
	public EditC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteCourse = new JLabel("Edit Course");
		lblDeleteCourse.setBackground(new Color(245, 245, 245));
		lblDeleteCourse.setFont(new Font("Yu Gothic UI", Font.BOLD, 21));
		lblDeleteCourse.setBounds(35, 23, 191, 31);
		contentPane.add(lblDeleteCourse);
		
		JButton btnAdd = new JButton("Edit");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cid = courseid.getText();
				String edcourse = editc.getText();
				String edm1 = editm1.getText();
				String edm2 = editm2.getText();
				String edm3 = editm3.getText();
				String edm4 = editm4.getText();
				String edyear = edity.getText();
				String edsem = edits.getText();
				if (!cid.equals("") && !edcourse.equals("") && !edm1.equals("") && !edm2.equals("") && !edm3.equals("") && !edm4.equals("") && !edyear.equals("") && !edsem.equals("")) {
					try {
						int courseId = Integer.parseInt(cid); // Assuming courseId is an integer
						String url = "jdbc:mysql://localhost:3306/coursemanagementsystem";
			            String username1 = "root";
			            String password1 = "";
			            Connection con = DriverManager.getConnection(url, username1, password1);
			           	Statement st = con.createStatement();
			            String sql = "UPDATE `course` SET `course`='"+edcourse+"',`Year`='"+edyear+"',`Semester`='"+edsem+"',`Module_1`='"+edm1+"',`Module_2`='"+edm2+"',`Module_3`='"+edm3+"',`Module_4`='"+edm4+"' WHERE id = '"+cid+"'";
			            st.execute(sql);
			            JOptionPane.showMessageDialog(null, "Edited Successfully", "Successful", JOptionPane.INFORMATION_MESSAGE);
			            courseid.setText("");
			            editc.setText("");
			            editm1.setText("");
			            editm2.setText("");
			            editm3.setText("");
			            editm4.setText("");
			            edity.setText("");
			            edits.setText("");
		            }catch (NumberFormatException e1) {
			            // If parsing fails, display an error message
			            JOptionPane.showMessageDialog(null, "Invalid Course ID: Must be a number", "Error", JOptionPane.ERROR_MESSAGE);
			        }catch (SQLException e1) {
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
		btnAdd.setBounds(212, 343, 181, 31);
		contentPane.add(btnAdd);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(245, 245, 245), 28, true));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(30, 78, 560, 71);
		contentPane.add(panel_6);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("_______________");
		lblNewLabel_1_2_3.setBounds(160, 37, 135, 23);
		panel_6.add(lblNewLabel_1_2_3);
		
		edits = new JTextField();
		edits.setBounds(450, 28, 97, 23);
		panel_6.add(edits);
		edits.setBackground(new Color(245, 245, 245));
		edits.setColumns(10);
		edits.setBorder(null);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(450, 11, 86, 14);
		panel_6.add(lblSemester);
		lblSemester.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2_2 = new JLabel("_____________");
		lblNewLabel_1_2_2.setBounds(449, 41, 106, 14);
		panel_6.add(lblNewLabel_1_2_2);
		
		edity = new JTextField();
		edity.setBounds(317, 31, 86, 20);
		panel_6.add(edity);
		edity.setBackground(new Color(245, 245, 245));
		edity.setColumns(10);
		edity.setBorder(null);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(317, 11, 86, 14);
		panel_6.add(lblYear);
		lblYear.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2_1 = new JLabel("____________");
		lblNewLabel_1_2_1.setBounds(317, 37, 97, 23);
		panel_6.add(lblNewLabel_1_2_1);
		
		editc = new JTextField();
		editc.setBounds(160, 28, 111, 23);
		panel_6.add(editc);
		editc.setBackground(new Color(245, 245, 245));
		editc.setColumns(10);
		editc.setBorder(null);
		
		JLabel lblCourseId_1 = new JLabel("Course");
		lblCourseId_1.setBounds(160, 11, 86, 14);
		panel_6.add(lblCourseId_1);
		lblCourseId_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2 = new JLabel("__________");
		lblNewLabel_1_2.setBounds(20, 41, 97, 14);
		panel_6.add(lblNewLabel_1_2);
		
		JLabel lblCourseId = new JLabel("Course Id");
		lblCourseId.setBounds(21, 11, 86, 14);
		panel_6.add(lblCourseId);
		lblCourseId.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		courseid = new JTextField();
		courseid.setBounds(20, 28, 80, 23);
		panel_6.add(courseid);
		courseid.setBackground(new Color(245, 245, 245));
		courseid.setColumns(10);
		courseid.setBorder(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(81, 4, 371, 56);
		panel_6.add(panel);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBorder(new LineBorder(new Color(245, 245, 245), 28, true));
		panel_6_1.setBackground(Color.WHITE);
		panel_6_1.setBounds(30, 171, 560, 147);
		contentPane.add(panel_6_1);
		
		JLabel lblNewLabel_2 = new JLabel("Module 1");
		lblNewLabel_2.setBounds(25, 22, 86, 14);
		panel_6_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_3 = new JLabel("______________________________");
		lblNewLabel_1_3.setBounds(25, 49, 224, 14);
		panel_6_1.add(lblNewLabel_1_3);
		
		editm1 = new JTextField();
		editm1.setBounds(25, 35, 208, 20);
		panel_6_1.add(editm1);
		editm1.setBackground(new Color(245, 245, 245));
		editm1.setColumns(10);
		editm1.setBorder(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Module 2");
		lblNewLabel_2_1.setBounds(315, 22, 86, 14);
		panel_6_1.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_3_1 = new JLabel("______________________________");
		lblNewLabel_1_3_1.setBounds(315, 49, 224, 14);
		panel_6_1.add(lblNewLabel_1_3_1);
		
		editm2 = new JTextField();
		editm2.setBounds(315, 35, 208, 20);
		panel_6_1.add(editm2);
		editm2.setBackground(new Color(245, 245, 245));
		editm2.setColumns(10);
		editm2.setBorder(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("Module 3");
		lblNewLabel_2_2.setBounds(25, 84, 86, 14);
		panel_6_1.add(lblNewLabel_2_2);
		lblNewLabel_2_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_3_2 = new JLabel("______________________________");
		lblNewLabel_1_3_2.setBounds(25, 111, 256, 14);
		panel_6_1.add(lblNewLabel_1_3_2);
		
		editm3 = new JTextField();
		editm3.setBounds(25, 97, 208, 20);
		panel_6_1.add(editm3);
		editm3.setBackground(new Color(245, 245, 245));
		editm3.setColumns(10);
		editm3.setBorder(null);
		
		JLabel lblNewLabel_2_3 = new JLabel("Module 4");
		lblNewLabel_2_3.setBounds(315, 84, 86, 14);
		panel_6_1.add(lblNewLabel_2_3);
		lblNewLabel_2_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_3_3 = new JLabel("______________________________");
		lblNewLabel_1_3_3.setBounds(315, 111, 224, 14);
		panel_6_1.add(lblNewLabel_1_3_3);
		
		editm4 = new JTextField();
		editm4.setBounds(315, 97, 208, 20);
		panel_6_1.add(editm4);
		editm4.setBackground(new Color(245, 245, 245));
		editm4.setColumns(10);
		editm4.setBorder(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setBounds(25, 22, 514, 103);
		panel_6_1.add(panel_1);
		
		JButton btnAdd_1_1 = new JButton("X");
		btnAdd_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ec.dispose();
			}
		});
		btnAdd_1_1.setForeground(Color.WHITE);
		btnAdd_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnAdd_1_1.setBorder(null);
		btnAdd_1_1.setBackground(new Color(62, 62, 62));
		btnAdd_1_1.setBounds(575, 32, 15, 17);
		contentPane.add(btnAdd_1_1);
	}

	public void setEditc(EditC ec) {
		this.ec = ec;
		
	}
}
