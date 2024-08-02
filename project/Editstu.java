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

public class Editstu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edituser;
	private JTextField editemail;
	private JTextField editpass;
	private JTextField getid;
	private Editstu edits;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editstu frame = new Editstu();
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
	public Editstu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 412);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBorder(new LineBorder(new Color(245, 245, 245), 28, true));
		panel_6_1.setBackground(Color.WHITE);
		panel_6_1.setBounds(36, 65, 560, 241);
		contentPane.add(panel_6_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setBounds(25, 22, 514, 200);
		panel_6_1.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(10, 74, 86, 14);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_3 = new JLabel("______________________________");
		lblNewLabel_1_3.setBounds(10, 101, 224, 14);
		panel_1.add(lblNewLabel_1_3);
		
		edituser = new JTextField();
		edituser.setBounds(10, 87, 208, 20);
		panel_1.add(edituser);
		edituser.setColumns(10);
		edituser.setBorder(null);
		edituser.setBackground(new Color(245, 245, 245));
		
		JLabel lblNewLabel_2_1 = new JLabel("Email");
		lblNewLabel_2_1.setBounds(290, 11, 86, 14);
		panel_1.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		editemail = new JTextField();
		editemail.setBounds(290, 24, 208, 20);
		panel_1.add(editemail);
		editemail.setColumns(10);
		editemail.setBorder(null);
		editemail.setBackground(new Color(245, 245, 245));
		
		JLabel lblNewLabel_2_2 = new JLabel("Password");
		lblNewLabel_2_2.setBounds(10, 136, 86, 14);
		panel_1.add(lblNewLabel_2_2);
		lblNewLabel_2_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_3_2 = new JLabel("______________________________");
		lblNewLabel_1_3_2.setBounds(10, 163, 256, 14);
		panel_1.add(lblNewLabel_1_3_2);
		
		editpass = new JTextField();
		editpass.setBounds(10, 149, 208, 20);
		panel_1.add(editpass);
		editpass.setColumns(10);
		editpass.setBorder(null);
		editpass.setBackground(new Color(245, 245, 245));
		
		JLabel lblNewLabel_2_3 = new JLabel("Course");
		lblNewLabel_2_3.setBounds(290, 73, 86, 14);
		panel_1.add(lblNewLabel_2_3);
		lblNewLabel_2_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_3_3 = new JLabel("______________________________");
		lblNewLabel_1_3_3.setBounds(290, 38, 224, 14);
		panel_1.add(lblNewLabel_1_3_3);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Student Id");
		lblNewLabel_2_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(10, 11, 86, 14);
		panel_1.add(lblNewLabel_2_1_1);
		
		getid = new JTextField();
		getid.setColumns(10);
		getid.setBorder(null);
		getid.setBackground(new Color(245, 245, 245));
		getid.setBounds(10, 24, 208, 20);
		panel_1.add(getid);
		
		JLabel lblNewLabel_1_3_3_1 = new JLabel("______________________________");
		lblNewLabel_1_3_3_1.setBounds(10, 38, 224, 14);
		panel_1.add(lblNewLabel_1_3_3_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBorder(null);
		comboBox.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"BSc Computer Science", "CSIT", "BCA", "BBA"}));
		comboBox.setBounds(290, 97, 208, 22);
		panel_1.add(comboBox);
		
		JLabel lblEditStudentDetails = new JLabel("Edit Student Details");
		lblEditStudentDetails.setFont(new Font("Yu Gothic UI", Font.BOLD, 21));
		lblEditStudentDetails.setBackground(new Color(245, 245, 245));
		lblEditStudentDetails.setBounds(39, 11, 199, 31);
		contentPane.add(lblEditStudentDetails);
		
		JButton btnAdd = new JButton("Edit");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String gid = getid.getText();
				String course = comboBox.getSelectedItem().toString();
				String user = edituser.getText();
				String pass = editpass.getText();
				String mail = editemail.getText();
				if (!gid.equals("") && !user.equals("") && !pass.equals("") && !mail.equals("")) {
					try {
					int stuId = Integer.parseInt(gid); // Assuming courseId is an integer
					String url = "jdbc:mysql://localhost:3306/coursemanagementsystem";
		            String username1 = "root";
		            String password1 = "";
		            Connection con = DriverManager.getConnection(url, username1, password1);
		           	Statement st = con.createStatement();
		            String sql = "UPDATE `students` SET `username`='"+user+"',`email`='"+mail+"',`password`='"+pass+"',`course`='"+course+"' WHERE id = '"+gid+"'";
		            st.execute(sql);
		            JOptionPane.showMessageDialog(null, "Edited Successfully", "Successful", JOptionPane.INFORMATION_MESSAGE);
		            getid.setText("");
		            edituser.setText("");
		            editpass.setText("");
		            editemail.setText("");
		            }catch (NumberFormatException e1) {
			            // If parsing fails, display an error message
			            JOptionPane.showMessageDialog(null, "Invalid Student ID: Must be a number", "Error", JOptionPane.ERROR_MESSAGE);
			        }catch (SQLException e1) {
						e1.printStackTrace();
					}
	            }else {
	            	 JOptionPane.showMessageDialog(null, "Fill all the Details", "Info", JOptionPane.INFORMATION_MESSAGE);
	            }
			}
		});
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(62, 62, 62));
		btnAdd.setBounds(215, 317, 181, 31);
		contentPane.add(btnAdd);
		
		JButton btnAdd_1_1 = new JButton("X");
		btnAdd_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				edits.dispose();
			}
		});
		btnAdd_1_1.setForeground(Color.WHITE);
		btnAdd_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnAdd_1_1.setBorder(null);
		btnAdd_1_1.setBackground(new Color(62, 62, 62));
		btnAdd_1_1.setBounds(581, 20, 15, 17);
		contentPane.add(btnAdd_1_1);
	}

	public void setEdits(Editstu edits) {
		this.edits = edits;
	}
}
