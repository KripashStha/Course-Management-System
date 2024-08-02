package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class Report extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField stuid;
	private JTable printtable;
	private Report r;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report frame = new Report();
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
	public Report() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 441);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		stuid = new JTextField();
		stuid.setColumns(10);
		stuid.setBorder(null);
		stuid.setBounds(32, 105, 66, 20);
		contentPane.add(stuid);
		
		JLabel lblProgressDecision = new JLabel("Report");
		lblProgressDecision.setFont(new Font("Yu Gothic UI", Font.BOLD, 21));
		lblProgressDecision.setBounds(32, 25, 108, 31);
		contentPane.add(lblProgressDecision);
		
		JLabel lblStudentId = new JLabel("Student Id");
		lblStudentId.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblStudentId.setBounds(32, 88, 86, 14);
		contentPane.add(lblStudentId);
		
		JLabel lblNewLabel_1_2 = new JLabel("_________");
		lblNewLabel_1_2.setBounds(32, 113, 80, 23);
		contentPane.add(lblNewLabel_1_2);
		
		JComboBox passBox = new JComboBox();
		passBox.setBorder(null);
		passBox.setBackground(new Color(255, 255, 255));
		passBox.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		passBox.setModel(new DefaultComboBoxModel(new String[] {"Pass", "Fail"}));
		passBox.setBounds(32, 182, 108, 22);
		contentPane.add(passBox);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 String id = stuid.getText();
				 String value = passBox.getSelectedItem().toString();
				    if (!id.equals("")) {
				        try {
				            // Attempt to parse the input string to a numeric type
				            int stuId = Integer.parseInt(id); // Assuming courseId is an integer
				            // If parsing is successful, proceed with deletion
				            String url = "jdbc:mysql://localhost:3306/coursemanagementsystem";
				            String username1 = "root";
				            String password1 = "";
				            Connection con = DriverManager.getConnection(url, username1, password1);
				            Statement st = con.createStatement();
				            String sql = "UPDATE `result` SET `result`='"+value+"' WHERE student_id = '"+id+"'";
				            st.execute(sql);
				            JOptionPane.showMessageDialog(null, "Added Successfully", "Successful", JOptionPane.INFORMATION_MESSAGE);
				            stuid.setText("");
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
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnSave.setBorder(null);
		btnSave.setBackground(new Color(62, 62, 62));
		btnSave.setBounds(32, 215, 108, 20);
		contentPane.add(btnSave);
		
	
		
		JLabel lblDecision = new JLabel("Decision");
		lblDecision.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblDecision.setBounds(32, 157, 86, 14);
		contentPane.add(lblDecision);
		
		JButton btnNewButton = new JButton(" Print");
		btnNewButton.setIcon(new ImageIcon(Report.class.getResource("/Images/print.png")));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(20, 190, 24));
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!stuid.getText().equals("")) {
					try {
						MessageFormat header = new MessageFormat(
								"MarkSheet      Student Id: " + stuid.getText() + "    Result: "+ passBox.getSelectedItem().toString());
						MessageFormat footer = new MessageFormat("Page{0,number,integer}");
						printtable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
					} catch (PrinterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Cannot print");
				}
			}
		});
		btnNewButton.setBounds(32, 284, 108, 31);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(162, 89, 645, 230);
		contentPane.add(scrollPane);
		
		printtable = new JTable();
		scrollPane.setViewportView(printtable);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!stuid.getText().equals("")) {
					try {
						String url = "jdbc:mysql://localhost:3306/coursemanagementsystem";
				        String username1 = "root";
				        String password1 = "";
				        Connection con = DriverManager.getConnection(url, username1, password1);
						Statement st = con.createStatement();
						String sql3 = "SELECT `id`, `student_id`, `course`, `semseter`, `Module_1`, `marks_1`, `Module_2`, `marks_2`, `Module_3`, `marks_3`, `Module_4`, `marks_4` from result where student_id = '"+stuid.getText()+"'";
						ResultSet rs5 = st.executeQuery(sql3);	
						ResultSetMetaData rsmd2 = (ResultSetMetaData) rs5.getMetaData();
						DefaultTableModel model2 = (DefaultTableModel) printtable.getModel();	
						String[] colName2 = new String[12];
						for(int i = 0; i<12; i++) {
							colName2[i]=rsmd2.getColumnName(i+1);
						}
						model2.setColumnIdentifiers(colName2);
						String rid, sid, courses, seme, md1, md2, md3, md4, mr1, mr2, mr3, mr4;
						if (rs5.next()) {
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

								String[] row1 = {rid, sid, courses, seme, md1, mr1, md2, mr2, md3, mr3, md4, mr4};
								model2.addRow(row1);
							}
						else {
							JOptionPane.showMessageDialog(null, "Result not Published");
						}
						con.close();
					}catch(Exception ea) {
			            System.out.println(ea);
			        }
				}else {
					JOptionPane.showMessageDialog(null, "Enter the Id");
				}
			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Yu Gothic UI", Font.BOLD, 10));
		btnSearch.setBorder(null);
		btnSearch.setBackground(new Color(62, 62, 62));
		btnSearch.setBounds(103, 113, 37, 19);
		contentPane.add(btnSearch);
		
		JButton btnAdd_1_1 = new JButton("X");
		btnAdd_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				r.dispose();
			}
		});
		btnAdd_1_1.setForeground(Color.WHITE);
		btnAdd_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnAdd_1_1.setBorder(null);
		btnAdd_1_1.setBackground(new Color(62, 62, 62));
		btnAdd_1_1.setBounds(792, 34, 15, 17);
		contentPane.add(btnAdd_1_1);
	}

	public void setReport(Report r) {
		this.r = r;
		
	}

}
