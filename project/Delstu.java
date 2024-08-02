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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delstu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField delstu;
	private Delstu dels;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delstu frame = new Delstu();
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
	public Delstu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 311);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		delstu = new JTextField();
		delstu.setColumns(10);
		delstu.setBorder(null);
		delstu.setBounds(111, 125, 191, 20);
		contentPane.add(delstu);
		
		JLabel lblDeleteStudentDetails = new JLabel("Delete Student Details");
		lblDeleteStudentDetails.setFont(new Font("Yu Gothic UI", Font.BOLD, 21));
		lblDeleteStudentDetails.setBounds(111, 47, 217, 31);
		contentPane.add(lblDeleteStudentDetails);
		
		JLabel lblStudentId = new JLabel("Student Id");
		lblStudentId.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblStudentId.setBounds(111, 108, 86, 14);
		contentPane.add(lblStudentId);
		
		JLabel lblNewLabel_1_2 = new JLabel("__________________________");
		lblNewLabel_1_2.setBounds(111, 133, 217, 23);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 String del = delstu.getText();
				    if (!del.equals("")) {
				        try {
				            // Attempt to parse the input string to a numeric type
				            int stuId = Integer.parseInt(del); // Assuming courseId is an integer
				            // If parsing is successful, proceed with deletion
				            String url = "jdbc:mysql://localhost:3306/coursemanagementsystem";
				            String username1 = "root";
				            String password1 = "";
				            Connection con = DriverManager.getConnection(url, username1, password1);
				            Statement st = con.createStatement();
				            String sql = "DELETE FROM `students` WHERE id = '" + stuId + "'";
				            st.execute(sql);
				            JOptionPane.showMessageDialog(null, "Deleted Successfully", "Successful", JOptionPane.INFORMATION_MESSAGE);
				            delstu.setText("");
				            con.close(); // Close the connection
				        } catch (NumberFormatException e1) {
				            // If parsing fails, display an error message
				            JOptionPane.showMessageDialog(null, "Invalid Student ID: Must be a number", "Error", JOptionPane.ERROR_MESSAGE);
				        } catch (SQLException e2) {
				            e2.printStackTrace();
				            JOptionPane.showMessageDialog(null, "Database Error: " + e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				        }
				    } else {
				        JOptionPane.showMessageDialog(null, "Enter the Student Id", "Info", JOptionPane.INFORMATION_MESSAGE);
				    }
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(62, 62, 62));
		btnDelete.setBounds(111, 176, 217, 31);
		contentPane.add(btnDelete);
		
		JButton btnAdd_1_1 = new JButton("X");
		btnAdd_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dels.dispose();
			}
		});
		btnAdd_1_1.setForeground(Color.WHITE);
		btnAdd_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnAdd_1_1.setBorder(null);
		btnAdd_1_1.setBackground(new Color(62, 62, 62));
		btnAdd_1_1.setBounds(427, 11, 15, 17);
		contentPane.add(btnAdd_1_1);
	}

	public void setDels(Delstu dels) {
		this.dels = dels;
		
	}
}
