package Banking_Staff;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.text.DateFormat;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

import Banking_GUI.HomePage;
import Utilities.BankingMail;
import Utilities.DB_Connection;
import Utilities.PasswordGenerator;
import beans.staff_bean;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class NewStaff extends JFrame {

	private JPanel contentPane;
	private JTextField t_fname;
	private JTextField t_mname;
	private JTextField t_lname;
	private JTextField b_branch;
	private JTextField b_state;
	private JTextField p_pincode;
	private JTextField p_pancard;
	private JTextField adhar_1;
	private JTextField adhar_2;
	private JTextField adhar_3;
	private JTextField m_mobile;
	private JTextField e_email;
	private JTextField u_username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewStaff frame = new NewStaff();
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
	public NewStaff() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\add_user_group_woman_man_48px.png"));
		setTitle("Staff Management");
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 982, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 0, 966, 565);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 205));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(24, 11, 445, 543);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("FORM NO 2E");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 24, 425, 29);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Employement Registration Form");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 51, 425, 29);
		panel_1.add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 91, 425, 1);
		panel_1.add(separator);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Personal Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_3.setBackground(new Color(255, 250, 205));
		panel_3.setBounds(10, 103, 425, 175);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Name :");
		lblNewLabel_2.setBounds(10, 22, 62, 34);
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 13));

		t_fname = new JTextField();
		t_fname.setBounds(82, 27, 104, 26);
		panel_3.add(t_fname);
		t_fname.setColumns(10);

		t_mname = new JTextField();
		t_mname.setBounds(196, 27, 104, 26);
		panel_3.add(t_mname);
		t_mname.setColumns(10);

		t_lname = new JTextField();
		t_lname.setBounds(310, 27, 104, 26);
		panel_3.add(t_lname);
		t_lname.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Gender :");
		lblNewLabel_3.setBounds(10, 81, 79, 34);
		panel_3.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 13));

		JRadioButton r_1 = new JRadioButton("Male");
		r_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		r_1.setBackground(new Color(255, 250, 205));
		r_1.setBounds(82, 87, 79, 23);
		panel_3.add(r_1);

		JRadioButton r_2 = new JRadioButton("Female");
		r_2.setBackground(new Color(255, 250, 205));
		r_2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		r_2.setBounds(163, 87, 79, 23);
		panel_3.add(r_2);

		JRadioButton r_3 = new JRadioButton("Ohter");
		r_3.setBackground(new Color(255, 250, 205));
		r_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
		r_3.setBounds(254, 87, 68, 23);
		panel_3.add(r_3);
		ButtonGroup group = new ButtonGroup();

		group.add(r_1);
		group.add(r_2);
		group.add(r_3);

		JLabel lblNewLabel_4 = new JLabel("Date of Birth :");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 126, 94, 34);
		panel_3.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("First Name");
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(82, 55, 104, 14);
		panel_3.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Middle Name");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6.setBounds(196, 55, 104, 14);
		panel_3.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Last Name");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_7.setForeground(new Color(255, 0, 0));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(310, 55, 104, 14);
		panel_3.add(lblNewLabel_7);

		JDateChooser d_dob = new JDateChooser();
		d_dob.setBounds(98, 130, 144, 26);
		panel_3.add(d_dob);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Work Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_4.setBackground(new Color(255, 250, 205));
		panel_4.setBounds(10, 289, 425, 243);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("Department :");
		lblNewLabel_8.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(10, 25, 84, 30);
		panel_4.add(lblNewLabel_8);

		JComboBox d_dept = new JComboBox();
		d_dept.setModel(new DefaultComboBoxModel(new String[] { "", "Admin", "Staff", "Customer care" }));
		d_dept.setFont(new Font("Arial", Font.PLAIN, 12));
		d_dept.setBounds(104, 29, 164, 25);
		panel_4.add(d_dept);

		JLabel lblNewLabel_9 = new JLabel("Designation :");
		lblNewLabel_9.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(10, 66, 84, 30);
		panel_4.add(lblNewLabel_9);

		JComboBox d_desig = new JComboBox();
		d_desig.setModel(new DefaultComboBoxModel(new String[] {"", "Assistant", "Management", "Tech Support", "Accountant", "CRM", "Desk Support"}));
		d_desig.setFont(new Font("Arial", Font.PLAIN, 12));
		String dept = d_dept.getSelectedItem().toString();
		d_desig.setBounds(104, 70, 164, 25);
		panel_4.add(d_desig);

		JLabel lblNewLabel_10 = new JLabel("Branch :");
		lblNewLabel_10.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_10.setBounds(10, 107, 84, 30);
		panel_4.add(lblNewLabel_10);

		b_branch = new JTextField();
		b_branch.setBounds(104, 112, 164, 25);
		panel_4.add(b_branch);
		b_branch.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("State :");
		lblNewLabel_11.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_11.setBounds(10, 148, 84, 30);
		panel_4.add(lblNewLabel_11);

		b_state = new JTextField();
		b_state.setBounds(104, 152, 164, 25);
		panel_4.add(b_state);
		b_state.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Pin Code :");
		lblNewLabel_12.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_12.setBounds(10, 189, 84, 30);
		panel_4.add(lblNewLabel_12);

		p_pincode = new JTextField();
		p_pincode.setBounds(104, 193, 164, 25);
		panel_4.add(p_pincode);
		p_pincode.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 205));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(494, 11, 445, 543);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 250, 205));
		panel_5.setBorder(
				new TitledBorder(null, "Other Details", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_5.setBounds(10, 11, 425, 164);
		panel_2.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_13 = new JLabel("Qualification: ");
		lblNewLabel_13.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_13.setBounds(10, 24, 96, 33);
		panel_5.add(lblNewLabel_13);

		JComboBox c_qualification = new JComboBox();
		c_qualification.setFont(new Font("Arial", Font.PLAIN, 13));
		c_qualification.setModel(
				new DefaultComboBoxModel(new String[] {"", "High School", "Diploma", "Graduation", "Post Graduation"}));
		c_qualification.setBounds(116, 28, 155, 27);
		panel_5.add(c_qualification);

		JLabel lblNewLabel_14 = new JLabel("Pan Card :");
		lblNewLabel_14.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_14.setBounds(10, 68, 96, 33);
		panel_5.add(lblNewLabel_14);

		p_pancard = new JTextField();
		p_pancard.setBounds(116, 72, 155, 26);
		panel_5.add(p_pancard);
		p_pancard.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("Aadhar Card :");
		lblNewLabel_15.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_15.setBounds(10, 112, 96, 33);
		panel_5.add(lblNewLabel_15);

		adhar_1 = new JTextField();
		adhar_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (adhar_1.getText().length() >= 4) {
					adhar_1.setText(adhar_1.getText().substring(0, 3));
				}
			}
		});
		adhar_1.setBounds(115, 116, 86, 26);
		panel_5.add(adhar_1);
		adhar_1.setColumns(4);

		adhar_2 = new JTextField();
		adhar_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (adhar_2.getText().length() >= 4) {
					adhar_2.setText(adhar_2.getText().substring(0, 3));
				}
			}
		});
		adhar_2.setBounds(211, 116, 86, 26);
		panel_5.add(adhar_2);
		adhar_2.setColumns(4);

		adhar_3 = new JTextField();
		adhar_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (adhar_3.getText().length() >= 4) {
					adhar_3.setText(adhar_3.getText().substring(0, 3));
				}
			}
		});
		adhar_3.setBounds(308, 116, 86, 26);
		panel_5.add(adhar_3);
		adhar_3.setColumns(4);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Contact Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_6.setBackground(new Color(255, 250, 205));
		panel_6.setBounds(10, 184, 425, 172);
		panel_2.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_16 = new JLabel("Mobile :");
		lblNewLabel_16.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_16.setBounds(10, 25, 100, 29);
		panel_6.add(lblNewLabel_16);

		m_mobile = new JTextField();
		m_mobile.setBounds(120, 25, 153, 25);
		panel_6.add(m_mobile);
		m_mobile.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("Email ID :");
		lblNewLabel_17.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_17.setBounds(10, 65, 100, 29);
		panel_6.add(lblNewLabel_17);

		e_email = new JTextField();
		e_email.setBounds(120, 69, 153, 25);
		panel_6.add(e_email);
		e_email.setColumns(10);

		JLabel lblNewLabel_18 = new JLabel("Username :");
		lblNewLabel_18.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_18.setBounds(10, 111, 100, 29);
		panel_6.add(lblNewLabel_18);

		u_username = new JTextField();
		u_username.setBounds(118, 114, 155, 25);
		panel_6.add(u_username);
		u_username.setColumns(10);

		JCheckBox c_tac = new JCheckBox("I Accept all term's and condition's");
		c_tac.setBackground(new Color(250, 250, 210));
		c_tac.setFont(new Font("SansSerif", Font.PLAIN, 11));
		c_tac.setHorizontalAlignment(SwingConstants.CENTER);
		c_tac.setBounds(10, 374, 425, 33);
		panel_2.add(c_tac);

		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fullname = t_fname.getText() + " " + t_mname.getText() + " " + t_lname.getText();
				String gender = null;
				if (r_1.isSelected()) {
					gender = r_1.getText().toString();
				}
				if (r_2.isSelected()) {
					gender = r_2.getText();
				}
				if (r_3.isSelected()) {
					gender = r_3.getText();
				}
				String dateOfBirth = null;
				try {
					Date date = d_dob.getDate();
					dateOfBirth = DateFormat.getDateInstance().format(date);
				} catch (Exception exp) {
					JOptionPane.showMessageDialog(btnNewButton, "Please Select Date of Birth");
				}
				String depart = d_dept.getSelectedItem().toString();
				String design = d_desig.getSelectedItem().toString();
				String branch = b_branch.getText();
				String state = b_state.getText();
				String pincode = p_pincode.getText();
				String qualification = c_qualification.getSelectedItem().toString();
				String pancard = p_pancard.getText();
				String aadhar = adhar_1.getText() + " " + adhar_2.getText() + " " + adhar_3.getText();
				String mobile = m_mobile.getText();
				String email = e_email.getText();
				String username = u_username.getText();
				String password = PasswordGenerator.generateRandomPassword(5);
				Date dt = new Date();
				String dateOfJoining = DateFormat.getDateInstance().format(dt);
				if (c_tac.isSelected()) {
					try {
						Connection con = DB_Connection.getConnection();
						String sql = "INSERT INTO bank_staff (staff_name, staff_gender, staff_date_of_birth, staff_department,"
								+ "staff_designation,staff_branch,staff_state,staff_zipcode,staff_mobile,staff_qualification,"
								+ "staff_email,staff_pan_card,staff_aadhar_card,staff_username,staff_password,staff_date_of_joining) "
								+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement smt = con.prepareStatement(sql);
						smt.setString(1, fullname);
						smt.setString(2, gender);
						smt.setString(3, dateOfBirth);
						smt.setString(4, depart);
						smt.setString(5, design);
						smt.setString(6, branch);
						smt.setString(7, state);
						smt.setString(8, pincode);
						smt.setString(9, mobile);
						smt.setString(10, qualification);
						smt.setString(11, email);
						smt.setString(12, pancard);
						smt.setString(13, aadhar);
						smt.setString(14, username);
						smt.setString(15, password);
						smt.setString(16, dateOfJoining);

						int result = smt.executeUpdate();
						if (result > 0) {
								JOptionPane.showMessageDialog(btnNewButton, "Successfully Registered",
										"Employee Registration", JOptionPane.INFORMATION_MESSAGE);
								String sql1 = "select staff_id from bank_staff where staff_username = ? and staff_pan_card = ?";
								PreparedStatement smt1 = con.prepareStatement(sql1);
								smt1.setString(1, username);
								smt1.setString(2, pancard);
								ResultSet set = smt1.executeQuery();
								while (set.next()) {
									int staffId = set.getInt("staff_id");
									BankingMail.newAccount(email, username, staffId, password);
									setVisible(false);
								}
						} else {
							JOptionPane.showMessageDialog(btnNewButton, "Failed", "Employee Registration",
									JOptionPane.ERROR_MESSAGE);
						}
						con.close();
					}  catch (SQLIntegrityConstraintViolationException sqlIV) {
						JOptionPane.showMessageDialog(btnNewButton, "Please enter all details correctly", "Registration Failed", JOptionPane.ERROR_MESSAGE);
					}catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(btnNewButton, "Please allow term's and condition");
				}

			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(51, 204, 102));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(107, 431, 89, 28);
		panel_2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.setBackground(new Color(153, 153, 153));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t_fname.setText("");
				t_mname.setText("");
				t_lname.setText("");
				b_branch.setText("");
				b_state.setText("");
				p_pincode.setText("");
				p_pancard.setText("");
				adhar_1.setText("");
				adhar_2.setText("");
				adhar_3.setText("");
				m_mobile.setText("");
				e_email.setText("");
				u_username.setText("");
				d_dept.setSelectedIndex(0);
				d_desig.setSelectedIndex(0);
				c_qualification.setSelectedIndex(0);
			}
		});
		btnNewButton_1.setBounds(248, 431, 89, 28);
		panel_2.add(btnNewButton_1);
	}
}
