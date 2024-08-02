package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Marks extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sem;
	private JTextField stuid;
	private JTextField m1;
	private JTextField m2;
	private JTextField m3;
	private JTextField m4;
	private JTextField ma1;
	private JTextField ma3;
	private JTextField ma2;
	private JTextField ma4;
	private Marks m;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Marks frame = new Marks();
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
	public Marks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 454);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddMarks = new JLabel("Add Marks");
		lblAddMarks.setFont(new Font("Yu Gothic UI", Font.BOLD, 21));
		lblAddMarks.setBackground(new Color(245, 245, 245));
		lblAddMarks.setBounds(65, 22, 191, 31);
		contentPane.add(lblAddMarks);
		
		JComboBox comboBox = new JComboBox();
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String sid = stuid.getText();
				String seme = sem.getText();
				String course = comboBox.getSelectedItem().toString();
				String md1 = m1.getText();
				String md2 = m2.getText();
				String md3 = m3.getText();
				String md4 = m4.getText();
				String mr1 = ma1.getText();
				String mr2 = ma2.getText();
				String mr3 = ma3.getText();
				String mr4 = ma4.getText();
				if ( !sid.equals("") && !seme.equals("") && !md1.equals("") && !md2.equals("") && !md3.equals("") && !md4.equals("")) {
					try {
						String url = "jdbc:mysql://localhost:3306/coursemanagementsystem";
			            String username1 = "root";
			            String password1 = "";
			            Connection con = DriverManager.getConnection(url, username1, password1);
			           	Statement st = con.createStatement();
						String sql1 = "SELECT * FROM  result  WHERE student_id = '"+sid+"'";
			            ResultSet rs = st.executeQuery(sql1);
	
			            if (rs.next()) {
			            	 JOptionPane.showMessageDialog(null, "Marked Already", "Marked", JOptionPane.INFORMATION_MESSAGE);
			            }else {
			            	try {
					            String sql = "INSERT INTO `result`(`student_id`, `course`, `semseter`, `Module_1`, `marks_1`, `Module_2`, `marks_2`, `Module_3`, `marks_3`, `Module_4`, `marks_4`) VALUES ('"+sid+"','"+course+"','"+seme+"','"+md1+"','"+mr1+"','"+md2+"','"+mr2+"','"+md3+"','"+mr3+"','"+md4+"','"+mr4+"')";
					            st.execute(sql);
					            JOptionPane.showMessageDialog(null, "Added Successfully", "Successful", JOptionPane.INFORMATION_MESSAGE);
				            } catch (SQLException e1) {
								e1.printStackTrace();
							}
			            }
						} catch (Exception ea) {
				            System.out.println(ea);
				        }
				
	            }else {
	            	 JOptionPane.showMessageDialog(null, "Fill all the Details", "Info", JOptionPane.INFORMATION_MESSAGE);
	            }
			}
		});
		btnAdd_1.setForeground(Color.WHITE);
		btnAdd_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnAdd_1.setBorder(null);
		btnAdd_1.setBackground(new Color(62, 62, 62));
		btnAdd_1.setBounds(225, 344, 181, 31);
		contentPane.add(btnAdd_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(245, 245, 245), 28, true));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(60, 77, 578, 71);
		contentPane.add(panel_6);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(10, 4, 544, 67);
		panel_6.add(panel);
		panel.setLayout(null);
		
		sem = new JTextField();
		sem.setBounds(368, 28, 97, 23);
		panel.add(sem);
		sem.setColumns(10);
		sem.setBorder(null);
		sem.setBackground(new Color(245, 245, 245));
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(368, 11, 86, 14);
		panel.add(lblSemester);
		lblSemester.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2_2 = new JLabel("_____________");
		lblNewLabel_1_2_2.setBounds(367, 41, 106, 14);
		panel.add(lblNewLabel_1_2_2);
		
		JLabel lblCourseId_1 = new JLabel("Course");
		lblCourseId_1.setBounds(158, 11, 86, 14);
		panel.add(lblCourseId_1);
		lblCourseId_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2 = new JLabel("__________");
		lblNewLabel_1_2.setBounds(10, 41, 97, 14);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblStudentId = new JLabel("Student Id");
		lblStudentId.setBounds(11, 11, 86, 14);
		panel.add(lblStudentId);
		lblStudentId.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		stuid = new JTextField();
		stuid.setBounds(10, 28, 80, 23);
		panel.add(stuid);
		stuid.setColumns(10);
		stuid.setBorder(null);
		stuid.setBackground(new Color(245, 245, 245));
		
		
		comboBox.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"BSc Hons Computer Science", "CSIT", "BCA", "BBA"}));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(158, 29, 145, 22);
		panel.add(comboBox);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBorder(new LineBorder(new Color(245, 245, 245), 28, true));
		panel_6_1.setBackground(Color.WHITE);
		panel_6_1.setBounds(60, 170, 578, 147);
		contentPane.add(panel_6_1);
		
		JLabel lblNewLabel_2 = new JLabel("Module 1");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(25, 22, 86, 14);
		panel_6_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("___________________________");
		lblNewLabel_1_3.setBounds(25, 49, 224, 14);
		panel_6_1.add(lblNewLabel_1_3);
		
		m1 = new JTextField();
		m1.setColumns(10);
		m1.setBorder(null);
		m1.setBackground(new Color(245, 245, 245));
		m1.setBounds(25, 35, 189, 20);
		panel_6_1.add(m1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Module 2");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(315, 22, 86, 14);
		panel_6_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("___________________________");
		lblNewLabel_1_3_1.setBounds(315, 49, 224, 14);
		panel_6_1.add(lblNewLabel_1_3_1);
		
		m2 = new JTextField();
		m2.setColumns(10);
		m2.setBorder(null);
		m2.setBackground(new Color(245, 245, 245));
		m2.setBounds(315, 35, 177, 20);
		panel_6_1.add(m2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Module 3");
		lblNewLabel_2_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(25, 84, 86, 14);
		panel_6_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("___________________________");
		lblNewLabel_1_3_2.setBounds(25, 111, 216, 14);
		panel_6_1.add(lblNewLabel_1_3_2);
		
		m3 = new JTextField();
		m3.setColumns(10);
		m3.setBorder(null);
		m3.setBackground(new Color(245, 245, 245));
		m3.setBounds(25, 97, 189, 20);
		panel_6_1.add(m3);
		
		JLabel lblNewLabel_2_3 = new JLabel("Module 4");
		lblNewLabel_2_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(315, 84, 86, 14);
		panel_6_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("___________________________");
		lblNewLabel_1_3_3.setBounds(315, 111, 224, 14);
		panel_6_1.add(lblNewLabel_1_3_3);
		
		m4 = new JTextField();
		m4.setColumns(10);
		m4.setBorder(null);
		m4.setBackground(new Color(245, 245, 245));
		m4.setBounds(315, 97, 177, 20);
		panel_6_1.add(m4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setBounds(25, 22, 543, 103);
		panel_6_1.add(panel_1);
		panel_1.setLayout(null);
		
		ma1 = new JTextField();
		ma1.setText("    0.0");
		ma1.setBounds(195, 21, 44, 20);
		panel_1.add(ma1);
		ma1.setColumns(10);
		
		ma3 = new JTextField();
		ma3.setText("    0.0");
		ma3.setColumns(10);
		ma3.setBounds(195, 83, 44, 20);
		panel_1.add(ma3);
		
		ma2 = new JTextField();
		ma2.setText("    0.0");
		ma2.setColumns(10);
		ma2.setBounds(489, 21, 44, 20);
		panel_1.add(ma2);
		
		ma4 = new JTextField();
		ma4.setText("   0.0");
		ma4.setColumns(10);
		ma4.setBounds(489, 83, 44, 20);
		panel_1.add(ma4);
		
		JButton btnAdd_1_1 = new JButton("X");
		btnAdd_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				m.dispose();
			}
		});
		btnAdd_1_1.setForeground(Color.WHITE);
		btnAdd_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnAdd_1_1.setBorder(null);
		btnAdd_1_1.setBackground(new Color(62, 62, 62));
		btnAdd_1_1.setBounds(623, 31, 15, 17);
		contentPane.add(btnAdd_1_1);
	}

	public void setMarks(Marks m) {
		this.m = m;
		
	}
}
