package project;

import java.awt.EventQueue;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField coursetotal;
	private JTextField studenttotal;
	private JTextField instotal;
	private JTextField coursesearch;
	private JTable coursetable;
	private JTable instable;
	private JTextField inssearch;
	private JTextField stusearch;
	private JTable stutable;
	private String value;
	private JTable resulttable;
	private JTextField resultsearch;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 488);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				std.st
			}
		});
		panel.setBounds(0, 0, 165, 449);
		panel.setBackground(new Color(62, 62, 62));
		panel.setForeground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(164, -30, 765, 490);
		contentPane.add(tabbedPane);
		
		
		JLabel dashboard = new JLabel("Dashboard");
		dashboard.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        tabbedPane.setSelectedIndex(0);
		    }
		});

		dashboard.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		dashboard.setForeground(new Color(255, 255, 255));
		dashboard.setBounds(64, 107, 91, 22);
		panel.add(dashboard);
		
		JLabel lblStudent = new JLabel("Student");
		lblStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		lblStudent.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblStudent.setForeground(new Color(255, 255, 255));
		lblStudent.setBounds(64, 191, 97, 22);
		panel.add(lblStudent);
		
		JLabel dashboard_1_1 = new JLabel("Instructor");
		dashboard_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		dashboard_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		dashboard_1_1.setForeground(new Color(255, 255, 255));
		dashboard_1_1.setBounds(64, 231, 97, 22);
		panel.add(dashboard_1_1);
		
		JLabel dashboard_1_1_2 = new JLabel("Courses");
		dashboard_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		dashboard_1_1_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		dashboard_1_1_2.setForeground(new Color(255, 255, 255));
		dashboard_1_1_2.setBounds(64, 150, 97, 22);
		panel.add(dashboard_1_1_2);
		
		JLabel lblCourseManagementSystem = new JLabel("CMS");
		lblCourseManagementSystem.setForeground(Color.WHITE);
		lblCourseManagementSystem.setFont(new Font("Yu Gothic UI", Font.BOLD, 21));
		lblCourseManagementSystem.setBounds(64, 26, 51, 22);
		panel.add(lblCourseManagementSystem);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/cms.png")));
		lblNewLabel.setBounds(30, 26, 24, 29);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/course.png")));
		lblNewLabel_5_1.setBounds(30, 150, 24, 22);
		panel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_3 = new JLabel("");
		lblNewLabel_5_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_3.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/teach.png")));
		lblNewLabel_5_3.setBounds(30, 231, 26, 22);
		panel.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("");
		lblNewLabel_5_1_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/d.png")));
		lblNewLabel_5_1_1.setBounds(30, 107, 24, 22);
		panel.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_1_2 = new JLabel("");
		lblNewLabel_5_1_2.setBounds(30, 150, 24, 22);
		panel.add(lblNewLabel_5_1_2);
		
		JLabel lblNewLabel_5_1_3 = new JLabel("");
		lblNewLabel_5_1_3.setBounds(30, 191, 24, 22);
		panel.add(lblNewLabel_5_1_3);
		
		JLabel lblNewLabel_5_2 = new JLabel("");
		lblNewLabel_5_2.setBounds(30, 191, 26, 22);
		panel.add(lblNewLabel_5_2);
		lblNewLabel_5_2.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/stu.png")));
		

		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 69, 112, 2);
		panel.add(separator);
		
		JLabel dashboard_1_1_1 = new JLabel("Log out");
		dashboard_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(panel_1,"Sure? You want to Log Out?", "Log Out",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION){
					Login l = new Login();
					l.setVisible(true);
					dispose();
		        }else if (result == JOptionPane.NO_OPTION){
		            
		        }
	      }
			
		});
		dashboard_1_1_1.setForeground(Color.WHITE);
		dashboard_1_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		dashboard_1_1_1.setBounds(64, 384, 73, 22);
		panel.add(dashboard_1_1_1);
		
		JLabel lblNewLabel_5_3_1 = new JLabel("");
		lblNewLabel_5_3_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/log.png")));
		lblNewLabel_5_3_1.setForeground(Color.WHITE);
		lblNewLabel_5_3_1.setBounds(30, 384, 26, 22);
		panel.add(lblNewLabel_5_3_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(81, 81, 81));
		separator_1.setBackground(new Color(63, 63, 63));
		separator_1.setBounds(23, 367, 112, 6);
		panel.add(separator_1);
		
		JLabel dashboard_1_1_3 = new JLabel("Result");
		dashboard_1_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		dashboard_1_1_3.setForeground(Color.WHITE);
		dashboard_1_1_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		dashboard_1_1_3.setBounds(64, 274, 97, 22);
		panel.add(dashboard_1_1_3);
		
		JLabel lblNewLabel_5_3_2 = new JLabel("");
		lblNewLabel_5_3_2.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/result.png")));
		lblNewLabel_5_3_2.setForeground(Color.WHITE);
		lblNewLabel_5_3_2.setBounds(30, 274, 26, 22);
		panel.add(lblNewLabel_5_3_2);
		
		
		JLabel lblNewLabel_1 = new JLabel("Dashboard");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setForeground(new Color(62, 62, 62));
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 19));
		lblNewLabel_1.setBounds(25, 31, 156, 31);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(245, 245, 245), 20, true));
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setForeground(new Color(62, 62, 62));
		panel_5.setBounds(25, 159, 174, 79);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		setCoursetotal(new JTextField());
		getCoursetotal().setEditable(false);
		getCoursetotal().setBorder(null);
		getCoursetotal().setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
		getCoursetotal().setBackground(new Color(245, 245, 245));
		getCoursetotal().setBounds(60, 11, 66, 36);
		panel_5.add(getCoursetotal());
		getCoursetotal().setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Total Courses");
		lblNewLabel_5.setBounds(60, 43, 100, 14);
		panel_5.add(lblNewLabel_5);
		lblNewLabel_5.setBackground(new Color(62, 62, 62));
		lblNewLabel_5.setForeground(new Color(62, 62, 62));
		lblNewLabel_5.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		
		JLabel lblNewLabel_5_1_3_1 = new JLabel("");
		lblNewLabel_5_1_3_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/cc.png")));
		lblNewLabel_5_1_3_1.setBounds(20, 21, 30, 31);
		panel_5.add(lblNewLabel_5_1_3_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(245, 245, 245));
		panel_7.setBounds(10, 11, 150, 57);
		panel_5.add(panel_7);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setForeground(new Color(62, 62, 62));
		panel_5_1.setBorder(new LineBorder(new Color(245, 245, 245), 20, true));
		panel_5_1.setBackground(Color.WHITE);
		panel_5_1.setBounds(220, 159, 179, 79);
		panel_1.add(panel_5_1);
		
		
		setStudenttotal(new JTextField());
		getStudenttotal().setEditable(false);
		getStudenttotal().setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
		getStudenttotal().setColumns(10);
		getStudenttotal().setBorder(null);
		getStudenttotal().setBackground(new Color(245, 245, 245));
		getStudenttotal().setBounds(60, 11, 66, 36);
		panel_5_1.add(getStudenttotal());
		
		JLabel lblNewLabel_5_4 = new JLabel("Total Students");
		lblNewLabel_5_4.setForeground(new Color(62, 62, 62));
		lblNewLabel_5_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		lblNewLabel_5_4.setBackground(new Color(62, 62, 62));
		lblNewLabel_5_4.setBounds(60, 43, 100, 14);
		panel_5_1.add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5_1_3_1_1 = new JLabel("");
		lblNewLabel_5_1_3_1_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/s.png")));
		lblNewLabel_5_1_3_1_1.setBounds(20, 21, 30, 31);
		panel_5_1.add(lblNewLabel_5_1_3_1_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(245, 245, 245));
		panel_8.setBounds(20, 11, 140, 57);
		panel_5_1.add(panel_8);
		
		JPanel panel_5_2 = new JPanel();
		panel_5_2.setLayout(null);
		panel_5_2.setForeground(new Color(62, 62, 62));
		panel_5_2.setBorder(new LineBorder(new Color(62, 62, 62), 19, true));
		panel_5_2.setBackground(new Color(255, 255, 255));
		panel_5_2.setBounds(419, 159, 174, 79);
		panel_1.add(panel_5_2);
		
		setInstotal(new JTextField());
		getInstotal().setEditable(false);
		getInstotal().setForeground(new Color(255, 255, 255));
		getInstotal().setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
		getInstotal().setColumns(10);
		getInstotal().setBorder(null);
		getInstotal().setBackground(new Color(62, 62, 62));
		getInstotal().setBounds(60, 11, 66, 36);
		panel_5_2.add(getInstotal());
		
		JLabel lblNewLabel_5_5 = new JLabel("Total Instructors");
		lblNewLabel_5_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_5.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		lblNewLabel_5_5.setBackground(new Color(62, 62, 62));
		lblNewLabel_5_5.setBounds(60, 43, 100, 14);
		panel_5_2.add(lblNewLabel_5_5);
		
		JLabel lblNewLabel_5_1_3_1_2 = new JLabel("");
		lblNewLabel_5_1_3_1_2.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/t.png")));
		lblNewLabel_5_1_3_1_2.setBounds(20, 21, 30, 31);
		panel_5_2.add(lblNewLabel_5_1_3_1_2);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(10, 11, 150, 57);
		panel_5_2.add(panel_9);
		panel_9.setBackground(new Color(62, 62, 62));
		
		JPanel panel_5_3 = new JPanel();
		panel_5_3.setLayout(null);
		panel_5_3.setForeground(new Color(62, 62, 62));
		panel_5_3.setBorder(new LineBorder(new Color(245, 245, 245), 20, true));
		panel_5_3.setBackground(Color.WHITE);
		panel_5_3.setBounds(25, 76, 568, 62);
		panel_1.add(panel_5_3);
		
		JLabel lblNewLabel_5_6 = new JLabel("Welcome to Dashboard!");
		lblNewLabel_5_6.setBounds(20, 11, 164, 26);
		panel_5_3.add(lblNewLabel_5_6);
		lblNewLabel_5_6.setForeground(new Color(62, 62, 62));
		lblNewLabel_5_6.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblNewLabel_5_6.setBackground(new Color(62, 62, 62));
		
		JLabel lblNewLabel_5_6_1 = new JLabel("Start your Journey with Course Management System.");
		lblNewLabel_5_6_1.setBounds(20, 31, 284, 14);
		panel_5_3.add(lblNewLabel_5_6_1);
		lblNewLabel_5_6_1.setForeground(new Color(62, 62, 62));
		lblNewLabel_5_6_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 10));
		lblNewLabel_5_6_1.setBackground(new Color(62, 62, 62));
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setBounds(10, 11, 548, 40);
		panel_5_3.add(panel_7_1);
		panel_7_1.setBackground(new Color(245, 245, 245));
		panel_7_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Courses");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
		lblNewLabel_2.setBounds(25, 28, 81, 25);
		panel_2.add(lblNewLabel_2);
		
		coursesearch = new JTextField();
		coursesearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DefaultTableModel model = (DefaultTableModel) getCoursetable().getModel();
				TableRowSorter<DefaultTableModel> model1 = new TableRowSorter<>(model);
				getCoursetable().setRowSorter(model1);
				model1.setRowFilter(RowFilter.regexFilter(coursesearch.getText()));
			}
		});
		coursesearch.setBorder(null);
		coursesearch.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		coursesearch.setBounds(532, 102, 134, 14);
		panel_2.add(coursesearch);
		coursesearch.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Search");
		lblNewLabel_6.setForeground(new Color(62, 62, 62));
		lblNewLabel_6.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblNewLabel_6.setBounds(489, 107, 42, 14);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/search.png")));
		lblNewLabel_7.setBounds(472, 104, 15, 20);
		panel_2.add(lblNewLabel_7);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(245, 245, 245), 28, true));
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBounds(25, 88, 367, 56);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Add Course");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddC ac = new AddC();
				ac.setAddc(ac);
				if(value.equals("Admin")) {
					ac.setVisible(true);
				}else {
					ac.setVisible(false);
					JOptionPane.showMessageDialog(null,"Access Denied","Denied",JOptionPane.ERROR_MESSAGE );
				}
				
			}
		});
		lblNewLabel_8.setBounds(32, 20, 89, 14);
		panel_6.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		
		JLabel lblNewLabel_8_1 = new JLabel("Edit Course");
		lblNewLabel_8_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditC ec = new EditC();
				ec.setEditc(ec);
				if(value.equals("Admin")) {
					ec.setVisible(true);
				}else {
					ec.setVisible(false);
					JOptionPane.showMessageDialog(null,"Access Denied","Denied",JOptionPane.ERROR_MESSAGE );
				}
				
			}
		});
		lblNewLabel_8_1.setBounds(142, 16, 81, 20);
		panel_6.add(lblNewLabel_8_1);
		lblNewLabel_8_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		
		JLabel lblNewLabel_8_2 = new JLabel("Delete Course");
		lblNewLabel_8_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DelC dc = new DelC();
				dc.Delc(dc);
				if(value.equals("Admin")) {
					dc.setVisible(true);
				}else {
					dc.setVisible(false);
					JOptionPane.showMessageDialog(null,"Access Denied","Denied",JOptionPane.ERROR_MESSAGE );
				}
			}
		});
		lblNewLabel_8_2.setBounds(253, 19, 89, 14);
		panel_6.add(lblNewLabel_8_2);
		lblNewLabel_8_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		
		JLabel lblNewLabel_9_1 = new JLabel("");
		lblNewLabel_9_1.setBounds(120, 16, 23, 20);
		panel_6.add(lblNewLabel_9_1);
		lblNewLabel_9_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/edi.png")));
		
		JLabel lblNewLabel_9_2 = new JLabel("");
		lblNewLabel_9_2.setBounds(233, 11, 18, 30);
		panel_6.add(lblNewLabel_9_2);
		lblNewLabel_9_2.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/del.png")));
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBounds(10, 20, 18, 14);
		panel_6.add(lblNewLabel_9);
		lblNewLabel_9.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/add.png")));
		
		JLabel lblNewLabel_1_1 = new JLabel("___________________");
		lblNewLabel_1_1.setBounds(532, 99, 147, 33);
		panel_2.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(255, 255, 255));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setFont(new Font("Yu Gothic UI", Font.PLAIN, 9));
		scrollPane.setBounds(25, 171, 654, 221);
		panel_2.add(scrollPane);
		
		setCoursetable(new JTable());
		getCoursetable().setGridColor(new Color(0, 0, 0));
		getCoursetable().setBackground(new Color(255, 255, 255));
		getCoursetable().setBorder(null);
		getCoursetable().setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		scrollPane.setViewportView(getCoursetable());
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Student");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
		lblNewLabel_3.setBounds(26, 28, 90, 25);
		panel_3.add(lblNewLabel_3);
		
		stusearch = new JTextField();
		stusearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DefaultTableModel model = (DefaultTableModel) getStutable().getModel();
				TableRowSorter<DefaultTableModel> model1 = new TableRowSorter<>(model);
				getStutable().setRowSorter(model1);
				model1.setRowFilter(RowFilter.regexFilter(stusearch.getText()));
			}
		});
		stusearch.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		stusearch.setColumns(10);
		stusearch.setBorder(null);
		stusearch.setBounds(533, 102, 134, 14);
		panel_3.add(stusearch);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Search");
		lblNewLabel_6_1_1.setForeground(new Color(62, 62, 62));
		lblNewLabel_6_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblNewLabel_6_1_1.setBounds(490, 107, 42, 14);
		panel_3.add(lblNewLabel_6_1_1);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("");
		lblNewLabel_7_1_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/search.png")));
		lblNewLabel_7_1_1.setBounds(473, 104, 15, 20);
		panel_3.add(lblNewLabel_7_1_1);
		
		JPanel panel_6_1_1 = new JPanel();
		panel_6_1_1.setLayout(null);
		panel_6_1_1.setBorder(new LineBorder(new Color(245, 245, 245), 28, true));
		panel_6_1_1.setBackground(Color.WHITE);
		panel_6_1_1.setBounds(26, 88, 367, 56);
		panel_3.add(panel_6_1_1);
		
		JLabel lblNewLabel_8_3_1 = new JLabel("Add Student");
		lblNewLabel_8_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Addstu adds = new Addstu();
				adds.setValue(adds);
				if(value.equals("Admin")) {
					adds.setVisible(true);
				}else {
					adds.setVisible(false);
					JOptionPane.showMessageDialog(null,"Access Denied","Denied",JOptionPane.ERROR_MESSAGE );
				}
			}
		});
		lblNewLabel_8_3_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_8_3_1.setBounds(32, 20, 89, 14);
		panel_6_1_1.add(lblNewLabel_8_3_1);
		
		JLabel lblNewLabel_8_1_1_1 = new JLabel("Edit Student");
		lblNewLabel_8_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Editstu edits = new Editstu();
				edits.setEdits(edits);
				if(value.equals("Admin")) {
					edits.setVisible(true);
				}else {
					edits.setVisible(false);
					JOptionPane.showMessageDialog(null,"Access Denied","Denied",JOptionPane.ERROR_MESSAGE );
				}
			}
		});
		lblNewLabel_8_1_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_8_1_1_1.setBounds(142, 17, 81, 20);
		panel_6_1_1.add(lblNewLabel_8_1_1_1);
		
		JLabel lblNewLabel_8_2_1_1 = new JLabel("Delete Student");
		lblNewLabel_8_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Delstu dels = new Delstu();
				dels.setDels(dels);
				if(value.equals("Admin")) {
					dels.setVisible(true);
				}else {
					dels.setVisible(false);
					JOptionPane.showMessageDialog(null,"Access Denied","Denied",JOptionPane.ERROR_MESSAGE );
				}
			}
		});
		lblNewLabel_8_2_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_8_2_1_1.setBounds(253, 19, 104, 14);
		panel_6_1_1.add(lblNewLabel_8_2_1_1);
		
		JLabel lblNewLabel_9_1_1_1 = new JLabel("");
		lblNewLabel_9_1_1_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/edi.png")));
		lblNewLabel_9_1_1_1.setBounds(120, 17, 23, 20);
		panel_6_1_1.add(lblNewLabel_9_1_1_1);
		
		JLabel lblNewLabel_9_2_1_1 = new JLabel("");
		lblNewLabel_9_2_1_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/del.png")));
		lblNewLabel_9_2_1_1.setBounds(233, 11, 18, 30);
		panel_6_1_1.add(lblNewLabel_9_2_1_1);
		
		JLabel lblNewLabel_9_3_1 = new JLabel("");
		lblNewLabel_9_3_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/add.png")));
		lblNewLabel_9_3_1.setBounds(10, 20, 18, 14);
		panel_6_1_1.add(lblNewLabel_9_3_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("___________________");
		lblNewLabel_1_1_1_1.setBounds(533, 99, 147, 33);
		panel_3.add(lblNewLabel_1_1_1_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(26, 171, 654, 210);
		panel_3.add(scrollPane_2);
		
		setStutable(new JTable());
		scrollPane_2.setViewportView(getStutable());
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Instructor");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
		lblNewLabel_4.setBounds(25, 27, 107, 25);
		panel_4.add(lblNewLabel_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 172, 702, 202);
		panel_4.add(scrollPane_1);
		
		setInstable(new JTable());
		scrollPane_1.setViewportView(getInstable());
		
		inssearch = new JTextField();
		inssearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DefaultTableModel modelins = (DefaultTableModel) getInstable().getModel();
				TableRowSorter<DefaultTableModel> model2 = new TableRowSorter<>(modelins);
				getInstable().setRowSorter(model2);
				model2.setRowFilter(RowFilter.regexFilter(inssearch.getText()));
			}
		});
		inssearch.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		inssearch.setColumns(10);
		inssearch.setBorder(null);
		inssearch.setBounds(580, 103, 134, 14);
		panel_4.add(inssearch);
		
		JLabel lblNewLabel_6_1 = new JLabel("Search");
		lblNewLabel_6_1.setForeground(new Color(62, 62, 62));
		lblNewLabel_6_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblNewLabel_6_1.setBounds(537, 108, 42, 14);
		panel_4.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("");
		lblNewLabel_7_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/search.png")));
		lblNewLabel_7_1.setBounds(520, 105, 15, 20);
		panel_4.add(lblNewLabel_7_1);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBorder(new LineBorder(new Color(245, 245, 245), 28, true));
		panel_6_1.setBackground(Color.WHITE);
		panel_6_1.setBounds(25, 88, 367, 56);
		panel_4.add(panel_6_1);
		
		JLabel lblNewLabel_8_3 = new JLabel("Add Instructor");
		lblNewLabel_8_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Addins ins = new Addins();
				ins.setAddins(ins);
				if(value.equals("Admin")) {
					ins.setVisible(true);
				}else {
					ins.setVisible(false);
					JOptionPane.showMessageDialog(null,"Access Denied","Denied",JOptionPane.ERROR_MESSAGE );
				}
			
			}
		});
		lblNewLabel_8_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_8_3.setBounds(32, 20, 89, 14);
		panel_6_1.add(lblNewLabel_8_3);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("Edit Instructor");
		lblNewLabel_8_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Editins edins = new Editins();
				edins.setEditins(edins);
				if(value.equals("Admin")) {
					edins.setVisible(true);
				}else {
					edins.setVisible(false);
					JOptionPane.showMessageDialog(null,"Access Denied","Denied",JOptionPane.ERROR_MESSAGE );
				}
			}
		});
		lblNewLabel_8_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_8_1_1.setBounds(142, 17, 81, 20);
		panel_6_1.add(lblNewLabel_8_1_1);
		
		JLabel lblNewLabel_8_2_1 = new JLabel("Delete Instructor");
		lblNewLabel_8_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Delins delins = new Delins();
				delins.setDelins(delins);
				if(value.equals("Admin")) {
					delins.setVisible(true);
				}else {
					delins.setVisible(false);
					JOptionPane.showMessageDialog(null,"Access Denied","Denied",JOptionPane.ERROR_MESSAGE );
				}
			}
		});
		lblNewLabel_8_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_8_2_1.setBounds(253, 19, 104, 14);
		panel_6_1.add(lblNewLabel_8_2_1);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("");
		lblNewLabel_9_1_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/edi.png")));
		lblNewLabel_9_1_1.setBounds(120, 17, 23, 20);
		panel_6_1.add(lblNewLabel_9_1_1);
		
		JLabel lblNewLabel_9_2_1 = new JLabel("");
		lblNewLabel_9_2_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/del.png")));
		lblNewLabel_9_2_1.setBounds(233, 11, 18, 30);
		panel_6_1.add(lblNewLabel_9_2_1);
		
		JLabel lblNewLabel_9_3 = new JLabel("");
		lblNewLabel_9_3.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/add.png")));
		lblNewLabel_9_3.setBounds(10, 20, 18, 14);
		panel_6_1.add(lblNewLabel_9_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("___________________");
		lblNewLabel_1_1_1.setBounds(580, 100, 147, 33);
		panel_4.add(lblNewLabel_1_1_1);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_10, null);
		panel_10.setLayout(null);
		
		JLabel lblNewLabel_4_1 = new JLabel("Result");
		lblNewLabel_4_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
		lblNewLabel_4_1.setBounds(25, 29, 108, 25);
		panel_10.add(lblNewLabel_4_1);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(25, 174, 709, 216);
		panel_10.add(scrollPane_3);
		
		setResulttable(new JTable());
		scrollPane_3.setViewportView(getResulttable());
		
		resultsearch = new JTextField();
		resultsearch.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		resultsearch.setColumns(10);
		resultsearch.setBorder(null);
		resultsearch.setBounds(535, 100, 120, 14);
		panel_10.add(resultsearch);
		
		JLabel lblNewLabel_6_1_2 = new JLabel("Search");
		lblNewLabel_6_1_2.setForeground(new Color(62, 62, 62));
		lblNewLabel_6_1_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblNewLabel_6_1_2.setBounds(492, 105, 42, 14);
		panel_10.add(lblNewLabel_6_1_2);
		
		JLabel lblNewLabel_7_1_2 = new JLabel("");
		lblNewLabel_7_1_2.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/search.png")));
		lblNewLabel_7_1_2.setBounds(475, 102, 15, 20);
		panel_10.add(lblNewLabel_7_1_2);
		
		JPanel panel_6_1_2 = new JPanel();
		panel_6_1_2.setLayout(null);
		panel_6_1_2.setBorder(new LineBorder(new Color(245, 245, 245), 28, true));
		panel_6_1_2.setBackground(Color.WHITE);
		panel_6_1_2.setBounds(25, 88, 326, 56);
		panel_10.add(panel_6_1_2);
		
		JLabel lblNewLabel_8_3_2 = new JLabel("Create Report\r\n");
		lblNewLabel_8_3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Report r = new Report();
				r.setReport(r);
				if(value.equals("Admin")) {
					r.setVisible(true);
				}else {
					r.setVisible(false);
					JOptionPane.showMessageDialog(null,"Access Denied","Denied",JOptionPane.ERROR_MESSAGE );
				}
				
			}
		});
		lblNewLabel_8_3_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_8_3_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNewLabel_8_3_2.setBounds(32, 20, 119, 14);
		panel_6_1_2.add(lblNewLabel_8_3_2);
		
		JLabel lblNewLabel_9_3_2 = new JLabel("");
		lblNewLabel_9_3_2.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/add.png")));
		lblNewLabel_9_3_2.setBounds(10, 20, 18, 14);
		panel_6_1_2.add(lblNewLabel_9_3_2);
		
		JLabel lblNewLabel_8_3_2_1 = new JLabel("Add Marks");
		lblNewLabel_8_3_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Marks m = new Marks();
				m.setMarks(m);
				if(value.equals("Instructor")) {
					m.setVisible(true);
				}else {
					m.setVisible(false);
					JOptionPane.showMessageDialog(null,"Access Denied","Denied",JOptionPane.ERROR_MESSAGE );
				}
			}
		});
		lblNewLabel_8_3_2_1.setForeground(new Color(0, 234, 58));
		lblNewLabel_8_3_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNewLabel_8_3_2_1.setBounds(158, 20, 89, 14);
		panel_6_1_2.add(lblNewLabel_8_3_2_1);
		
		JLabel lblNewLabel_9_3_2_1 = new JLabel("");
		lblNewLabel_9_3_2_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/add.png")));
		lblNewLabel_9_3_2_1.setBounds(136, 20, 18, 14);
		panel_6_1_2.add(lblNewLabel_9_3_2_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("___________________");
		lblNewLabel_1_1_1_2.setBounds(535, 97, 147, 33);
		panel_10.add(lblNewLabel_1_1_1_2);
		
		JButton go = new JButton("GO");
		go.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(value.equals("Student") &&!resultsearch.getText().equals("")) {
					try {
						String url = "jdbc:mysql://localhost:3306/coursemanagementsystem";
				        String username1 = "root";
				        String password1 = "";
				        Connection con = DriverManager.getConnection(url, username1, password1);
						Statement st = con.createStatement();
						String sql3 = "Select * from result where student_id = '"+resultsearch.getText()+"'";
						ResultSet rs5 = st.executeQuery(sql3);	
						ResultSetMetaData rsmd2 = (ResultSetMetaData) rs5.getMetaData();
						DefaultTableModel model2 = (DefaultTableModel) resulttable.getModel();	
						int cols2 = rsmd2.getColumnCount();
						String[] colName2 = new String[cols2];
						for(int i = 0; i<cols2; i++) {
							colName2[i]=rsmd2.getColumnName(i+1);
						}
						model2.setColumnIdentifiers(colName2);
						String rid, sid, courses, seme, md1, md2, md3, md4, mr1, mr2, mr3, mr4, re ;
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
								re = rs5.getString(13);
								String[] row1 = {rid, sid, courses, seme, md1, mr1, md2, mr2, md3, mr3, md4, mr4, re};
								model2.addRow(row1);
							}
						else {
							JOptionPane.showMessageDialog(null, "Result not Published");
						}
						con.close();
					}catch(Exception ea) {
			            System.out.println(ea);
			        }
				}
			}
		});
		go.setBorder(null);
		go.setForeground(new Color(255, 255, 255));
		go.setBackground(new Color(62, 62, 62));
		go.setFont(new Font("Yu Gothic UI", Font.BOLD, 10));
		go.setBounds(682, 97, 52, 23);
		panel_10.add(go);
	}

	public JTextField getStudenttotal() {
		return studenttotal;
	}

	public void setStudenttotal(JTextField studenttotal) {
		this.studenttotal = studenttotal;
	}

	public JTextField getInstotal() {
		return instotal;
	}

	public void setInstotal(JTextField instotal) {
		this.instotal = instotal;
	}

	public JTextField getCoursetotal() {
		return coursetotal;
	}

	public void setCoursetotal(JTextField coursetotal) {
		this.coursetotal = coursetotal;
	}

	public JTable getCoursetable() {
		return coursetable;
	}

	public void setCoursetable(JTable coursetable) {
		this.coursetable = coursetable;
	}

	public JTable getInstable() {
		return instable;
	}

	public void setInstable(JTable instable) {
		this.instable = instable;
	}

	public JTable getStutable() {
		return stutable;
	}

	public void setStutable(JTable stutable) {
		this.stutable = stutable;
	}
	public void setValue(String value) {
        this.value = value;
    }

	public JTable getResulttable() {
		return resulttable;
	}

	public void setResulttable(JTable resulttable) {
		this.resulttable = resulttable;
		resulttable.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
	}
	
}
