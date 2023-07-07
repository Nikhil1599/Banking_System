package Banking_Staff;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Banking_GUI.HomePage;
import Utilities.DB_Connection;
import beans.staff_bean;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPasswordField;

public class UpdateStaff extends JFrame {

	private JPanel contentPane;
	private JTextField stf_id;
	private JTextField stf_username;
	private JTextField staff_name;
	private JTextField staff_branch;
	private JTextField staff_state;
	private JTextField staff_pincode;
	private JTextField staff_mobile;
	private JTextField staff_email;
	private JTextField staff_username;
	private JTextField staff_pass;
	private JTable table;
	private JPasswordField stf_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStaff frame = new UpdateStaff();
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

	// creating staff list for table
	public ArrayList<staff_bean> userList() {
		ArrayList<staff_bean> userList = new ArrayList();
		try {

			int i = 0;
			Connection con = DB_Connection.getConnection();
			String query1 = "SELECT * FROM Bank_Staff ";
			Statement st = (Statement) con.createStatement();
			
			ResultSet rs = st.executeQuery(query1);
			staff_bean stf_bean;
			while (rs.next()) {
				stf_bean = new staff_bean(rs.getInt("staff_id"), rs.getString("staff_name"),
						rs.getString("staff_gender"), rs.getString("staff_date_of_birth"),
						rs.getString("staff_department"), rs.getString("staff_designation"),
						rs.getString("staff_branch"), rs.getString("staff_state"), rs.getInt("staff_zipcode"),
						rs.getString("staff_mobile"), rs.getString("staff_qualification"), rs.getString("staff_email"),
						rs.getString("staff_pan_card"), rs.getString("staff_aadhar_card"),
						rs.getString("staff_username"), rs.getString("staff_password"),
						rs.getString("staff_date_of_joining"));
				userList.add(stf_bean);
				i++;
			}
			if (i == 0) {
				JOptionPane.showMessageDialog(null, "No Record Found");
				setVisible(false);
				new HomePage().setVisible(true);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return userList;
	}

	public void showuser() {
		ArrayList<staff_bean> list = userList();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[16];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getId();
			row[1] = list.get(i).getName();
			row[2] = list.get(i).getGender();
			row[3] = list.get(i).getDateOfbith();
			row[4] = list.get(i).getDepartment();
			row[5] = list.get(i).getDesignation();
			row[6] = list.get(i).getBranch();
			row[7] = list.get(i).getState();
			row[8] = list.get(i).getZipcode();
			row[9] = list.get(i).getMobile();
			row[10] = list.get(i).getQualification();
			row[11] = list.get(i).getEmail();
			row[12] = list.get(i).getPancard();
			row[13] = list.get(i).getAadhar();
			row[14] = list.get(i).getUsername();
			row[15] = list.get(i).getDateOfjoining();
			
			model.addRow(row);

		}
	}

	public UpdateStaff() {
		// displaying staff
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\search_client_30px.png"));
		setTitle("Staff Management Portal");
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1124, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1108, 563);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(255, 250, 205));
		panel_1.setBounds(10, 60, 251, 412);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("SEARCH STAFF");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\search_client_30px.png"));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 231, 34);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Staff ID:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 64, 113, 26);
		panel_1.add(lblNewLabel_1);

		stf_id = new JTextField();
		stf_id.setBounds(20, 101, 198, 26);
		panel_1.add(stf_id);
		stf_id.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 224, 88, 26);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Username:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 144, 88, 26);
		panel_1.add(lblNewLabel_3);

		stf_username = new JTextField();
		stf_username.setBounds(20, 181, 198, 26);
		panel_1.add(stf_username);
		stf_username.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 56, 231, 2);
		panel_1.add(separator);

		JLabel staff_id = new JLabel("");
		staff_id.setForeground(Color.RED);
		staff_id.setFont(new Font("Arial", Font.PLAIN, 13));
		staff_id.setBounds(102, 23, 121, 25);

		JLabel lblNewLabel_4 = new JLabel("STAFF MANAGEMENT");
		lblNewLabel_4.setIcon(new ImageIcon(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\staff_48px.png"));
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 11, 239, 48);
		panel.add(lblNewLabel_4);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"UPDATE DETAILS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(273, 11, 825, 191);
		panel.add(panel_2);
		panel_2.setLayout(null);
		panel_2.add(staff_id);

		JLabel lblNewLabel_5 = new JLabel("Name :");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(233, 21, 57, 26);
		panel_2.add(lblNewLabel_5);

		staff_name = new JTextField();
		staff_name.setBounds(300, 22, 183, 26);
		panel_2.add(staff_name);
		staff_name.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Staff ID :");
		lblNewLabel_9.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(10, 22, 82, 26);
		panel_2.add(lblNewLabel_9);

		JLabel lblNewLabel_7 = new JLabel("Department :");
		lblNewLabel_7.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(271, 59, 82, 26);
		panel_2.add(lblNewLabel_7);

		JComboBox staff_dept = new JComboBox();
		staff_dept.setModel(new DefaultComboBoxModel(new String[] { "", "Admin", "Staff" }));
		staff_dept.setFont(new Font("SansSerif", Font.PLAIN, 13));
		staff_dept.setBounds(363, 59, 121, 26);
		panel_2.add(staff_dept);

		JLabel lblNewLabel_8 = new JLabel("Designation :");
		lblNewLabel_8.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(499, 59, 92, 26);
		panel_2.add(lblNewLabel_8);

		JComboBox staff_design = new JComboBox();
		staff_design.setFont(new Font("SansSerif", Font.PLAIN, 13));
		staff_design.setModel(new DefaultComboBoxModel(
				new String[] { "", "Assistant", "Management", "Tech Support", "Accountant", "CRM", "Desk Support" }));
		staff_design.setBounds(591, 60, 143, 26);
		panel_2.add(staff_design);

		JLabel lblNewLabel_11 = new JLabel("Branch :");
		lblNewLabel_11.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_11.setBounds(10, 96, 71, 26);
		panel_2.add(lblNewLabel_11);

		staff_branch = new JTextField();
		staff_branch.setBounds(91, 96, 121, 26);
		panel_2.add(staff_branch);
		staff_branch.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("State :");
		lblNewLabel_12.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_12.setBounds(266, 96, 57, 26);
		panel_2.add(lblNewLabel_12);

		staff_state = new JTextField();
		staff_state.setBounds(333, 97, 143, 26);
		panel_2.add(staff_state);
		staff_state.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("Qualification :");
		lblNewLabel_13.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_13.setBounds(10, 59, 82, 26);
		panel_2.add(lblNewLabel_13);

		JComboBox staff_qualification = new JComboBox();
		staff_qualification.setFont(new Font("SansSerif", Font.PLAIN, 13));
		staff_qualification.setModel(new DefaultComboBoxModel(
				new String[] { "", "High School", "Diploma", "Graduation", "Post Graduation" }));
		staff_qualification.setBounds(102, 59, 144, 26);
		panel_2.add(staff_qualification);

		JLabel lblNewLabel_14 = new JLabel("Pin Code :");
		lblNewLabel_14.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_14.setBounds(509, 96, 71, 26);
		panel_2.add(lblNewLabel_14);

		staff_pincode = new JTextField();
		staff_pincode.setBounds(591, 97, 121, 25);
		panel_2.add(staff_pincode);
		staff_pincode.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("Mobile :");
		lblNewLabel_15.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_15.setBounds(10, 153, 71, 26);
		panel_2.add(lblNewLabel_15);

		staff_mobile = new JTextField();
		staff_mobile.setBounds(91, 154, 121, 26);
		panel_2.add(staff_mobile);
		staff_mobile.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("Email :");
		lblNewLabel_16.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_16.setBounds(233, 153, 71, 26);
		panel_2.add(lblNewLabel_16);

		staff_email = new JTextField();
		staff_email.setBounds(314, 153, 162, 26);
		panel_2.add(staff_email);
		staff_email.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("Username :");
		lblNewLabel_17.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_17.setBounds(509, 21, 82, 26);
		panel_2.add(lblNewLabel_17);

		staff_username = new JTextField();
		staff_username.setBounds(601, 21, 143, 26);
		panel_2.add(staff_username);
		staff_username.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Password :");
		lblNewLabel_6.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(499, 153, 71, 26);
		panel_2.add(lblNewLabel_6);

		staff_pass = new JTextField();
		staff_pass.setBounds(591, 154, 121, 26);
		panel_2.add(staff_pass);
		staff_pass.setColumns(10);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// initializing values
					String staffId = stf_id.getText();
					int staff = Integer.parseInt(staffId);
					String staffEm = stf_username.getText();
					String staffUs = stf_pass.getText();

					// database connectivity
					Connection con = DB_Connection.getConnection();
					String sql = "select * from bank_staff where staff_id = ? and staff_username = ? and staff_password = ?";
					PreparedStatement pst = con.prepareStatement(sql);
					// setting sql parameters
					pst.setInt(1, staff);
					pst.setString(2, staffEm);
					pst.setString(3, staffUs);
					ResultSet set = pst.executeQuery();
					if (set.next()) {
						// fetching details from database
						int stfID = set.getInt("staff_id");
						staff_id.setText(String.valueOf(stfID));
						staff_name.setText(set.getString("staff_name"));
						staff_username.setText(set.getString("staff_username"));
						String qual = set.getString("staff_qualification").toString();
						staff_qualification.setSelectedItem(qual);
						staff_dept.setSelectedItem(set.getString("staff_department"));
						staff_design.setSelectedItem(set.getString("staff_designation"));
						staff_branch.setText(set.getString("staff_branch"));
						staff_state.setText(set.getString("staff_state"));
						staff_pincode.setText(set.getString("staff_zipcode"));
						staff_mobile.setText(set.getString("staff_mobile"));
						staff_email.setText(set.getString("staff_email"));
						staff_pass.setText(set.getString("staff_password"));
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Staff not found");
					}
				} catch (NumberFormatException NEx) {
					JOptionPane.showMessageDialog(btnNewButton, "Please enter details first");
				} catch (SQLException sqlEx) {
					JOptionPane.showMessageDialog(btnNewButton, "Please enter details first");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 204, 102));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton.setBounds(73, 353, 89, 34);
		panel_1.add(btnNewButton);
		
		stf_pass = new JPasswordField();
		stf_pass.setBounds(20, 261, 198, 26);
		panel_1.add(stf_pass);

		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = staff_name.getText();
				String user = staff_username.getText();
				String qual = staff_qualification.getSelectedItem().toString();
				String depart = staff_dept.getSelectedItem().toString();
				String design = staff_design.getSelectedItem().toString();
				String branch = staff_branch.getText();
				String state = staff_state.getText();
				String pincode = staff_pincode.getText();
				String mobile = staff_mobile.getText();
				String email = staff_email.getText();
				String pass = staff_pass.getText();

				String staffId = stf_id.getText();
				int staff = Integer.parseInt(staffId);
				String staffEm = stf_username.getText();
				String staffUs = stf_pass.getText();

				try {
					Connection con = DB_Connection.getConnection();
					String sql = "UPDATE Bank_Staff SET staff_name = ?,staff_username = ?,staff_qualification = ?, staff_department = ?,"
							+ "staff_designation = ?, staff_branch = ?, staff_state = ?, staff_zipcode = ?, staff_mobile = ?,"
							+ "staff_email = ?, staff_password = ? WHERE staff_id = ? and staff_username = ? and staff_password = ?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, name);
					pst.setString(2, user);
					pst.setString(3, qual);
					pst.setString(4, depart);
					pst.setString(5, design);
					pst.setString(6, branch);
					pst.setString(7, state);
					pst.setString(8, pincode);
					pst.setString(9, mobile);
					pst.setString(10, email);
					pst.setString(11, pass);

					pst.setInt(12, staff);
					pst.setString(13, staffEm);
					pst.setString(14, staffUs);
					int set = pst.executeUpdate();
					if (set != 0) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						showuser();
						JOptionPane.showMessageDialog(btnNewButton_1, "Staff details updated successfully",
								"Update Successfully", JOptionPane.INFORMATION_MESSAGE);

						// details get cleared after updating details
						stf_id.setText("");
						stf_pass.setText("");
						stf_username.setText("");

						// update page reset
						staff_id.setText("");
						staff_name.setText("");
						staff_username.setText("");
						staff_qualification.setSelectedIndex(0);
						staff_dept.setSelectedIndex(0);
						staff_design.setSelectedIndex(0);
						staff_branch.setText("");
						staff_state.setText("");
						staff_pincode.setText("");
						staff_mobile.setText("");
						staff_email.setText("");
						staff_pass.setText("");

					} else {
						JOptionPane.showMessageDialog(btnNewButton_1, "Staff details updated failed", "Update Failed",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnNewButton_1, "Database Failed");
				}
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(51, 204, 153));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_1.setBounds(463, 213, 89, 30);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Resetting the textbox to ""
				stf_id.setText("");
				stf_pass.setText("");
				stf_username.setText("");

				// update page reset
				staff_id.setText("");
				staff_name.setText("");
				staff_username.setText("");
				staff_qualification.setSelectedIndex(0);
				staff_dept.setSelectedIndex(0);
				staff_design.setSelectedIndex(0);
				staff_branch.setText("");
				staff_state.setText("");
				staff_pincode.setText("");
				staff_mobile.setText("");
				staff_email.setText("");
				staff_pass.setText("");
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(SystemColor.controlShadow);
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_2.setBounds(711, 213, 89, 30);
		panel.add(btnNewButton_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(274, 256, 824, 284);
		panel.add(scrollPane);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Staff ID", "Name", "Gender", "Date of Birth", "Department", "Designation", "Branch", "State",
				"zipcode", "Mobile", "Qualification", "Email", "Pan Card", "Aadhar Card", "Username",
				"Date of Joining" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(49);
		table.getColumnModel().getColumn(0).setMinWidth(49);
		table.getColumnModel().getColumn(1).setPreferredWidth(138);
		table.getColumnModel().getColumn(1).setMinWidth(138);
		table.getColumnModel().getColumn(2).setMinWidth(75);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setMinWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setMinWidth(80);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(5).setMinWidth(80);
		table.getColumnModel().getColumn(6).setMinWidth(75);
		table.getColumnModel().getColumn(7).setPreferredWidth(84);
		table.getColumnModel().getColumn(7).setMinWidth(84);
		table.getColumnModel().getColumn(8).setMinWidth(75);
		table.getColumnModel().getColumn(9).setPreferredWidth(80);
		table.getColumnModel().getColumn(9).setMinWidth(80);
		table.getColumnModel().getColumn(10).setPreferredWidth(90);
		table.getColumnModel().getColumn(10).setMinWidth(90);
		table.getColumnModel().getColumn(11).setPreferredWidth(95);
		table.getColumnModel().getColumn(11).setMinWidth(95);
		table.getColumnModel().getColumn(12).setPreferredWidth(83);
		table.getColumnModel().getColumn(12).setMinWidth(83);
		table.getColumnModel().getColumn(13).setPreferredWidth(100);
		table.getColumnModel().getColumn(13).setMinWidth(100);
		table.getColumnModel().getColumn(14).setPreferredWidth(85);
		table.getColumnModel().getColumn(14).setMinWidth(85);
		table.getColumnModel().getColumn(15).setPreferredWidth(90);
		table.getColumnModel().getColumn(15).setMinWidth(90);
		table.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(255, 153, 51));
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String staffId = staff_id.getText();
				int staff = Integer.parseInt(staffId);
				String staffEm = stf_username.getText();
				String staffUs = stf_pass.getText();
				
				try {
					Connection con = DB_Connection.getConnection();
					String sql = "DELETE FROM Bank_Staff where staff_id = ? and staff_username = ? and staff_password = ?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setInt(1,staff);
					pst.setString(2,staffEm);
					pst.setString(3,staffUs);
					int set = pst.executeUpdate();
					if(set != 0 ) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						showuser();
						JOptionPane.showMessageDialog(btnNewButton_3, "Staff Deleted Successfully");
						// Resetting the textbox to ""
						stf_id.setText("");
						stf_pass.setText("");
						stf_username.setText("");

						// update page reset
						staff_id.setText("");
						staff_name.setText("");
						staff_username.setText("");
						staff_qualification.setSelectedIndex(0);
						staff_dept.setSelectedIndex(0);
						staff_design.setSelectedIndex(0);
						staff_branch.setText("");
						staff_state.setText("");
						staff_pincode.setText("");
						staff_mobile.setText("");
						staff_email.setText("");
						staff_pass.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton_3, "Delete Staff failed");
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			
				
			}
		});
		btnNewButton_3.setBounds(587, 213, 89, 30);
		panel.add(btnNewButton_3);
		showuser();

	}
}
