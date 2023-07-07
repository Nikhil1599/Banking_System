package HomePage.User_account;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Utilities.DB_Connection;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class UpdateCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField acNo;
	private JTextField cusID;
	private JTextField name;
	private JTextField branch;
	private JTextField nominee;
	private JTextField email;
	private JTextField mobile;
	private JTextField amobile;
	private JTextField room;
	private JTextField apartment;
	private JTextField landmark;
	private JTextField pincode;
	private JTextField city;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCustomer frame = new UpdateCustomer();
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
	public UpdateCustomer() {
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("UPDATE CUSTOMER");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\search_client_30px.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 611, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 605, 683);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "SEARCH ACCOUNT", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 3, 574, 67);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("A/c No :");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 21, 51, 30);
		panel_1.add(lblNewLabel);

		acNo = new JTextField();
		acNo.setBounds(71, 22, 134, 26);
		panel_1.add(acNo);
		acNo.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Customer No:");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(228, 21, 85, 30);
		panel_1.add(lblNewLabel_1);

		cusID = new JTextField();
		cusID.setBounds(323, 22, 120, 26);
		panel_1.add(cusID);
		cusID.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "UPDATE DETAILS", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(255, 0, 0)));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 70, 574, 602);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Name :");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 23, 58, 28);
		panel_2.add(lblNewLabel_2);

		name = new JTextField();
		name.setBounds(78, 24, 238, 25);
		panel_2.add(name);
		name.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Branch :");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(315, 506, 58, 28);
		panel_2.add(lblNewLabel_3);

		branch = new JTextField();
		branch.setBounds(382, 507, 125, 25);
		panel_2.add(branch);
		branch.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Gender :");
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 70, 58, 28);
		panel_2.add(lblNewLabel_4);

		JComboBox gender = new JComboBox();
		gender.setFont(new Font("Arial", Font.PLAIN, 13));
		gender.setModel(new DefaultComboBoxModel(new String[] { "", "Male", "Female", "Other" }));
		gender.setBounds(78, 70, 121, 26);
		panel_2.add(gender);

		JLabel lblNewLabel_5 = new JLabel("Marital Status  :");
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(231, 70, 99, 28);
		panel_2.add(lblNewLabel_5);

		JComboBox mStatus = new JComboBox();
		mStatus.setModel(new DefaultComboBoxModel(new String[] { "", "Single", "Married", "Divorced" }));
		mStatus.setFont(new Font("Arial", Font.PLAIN, 13));
		mStatus.setBounds(340, 70, 128, 26);
		panel_2.add(mStatus);

		JLabel lblNewLabel_6 = new JLabel("Occupation :");
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(10, 119, 74, 28);
		panel_2.add(lblNewLabel_6);

		JComboBox occupation = new JComboBox();
		occupation.setModel(new DefaultComboBoxModel(
				new String[] { "", "Bussiness", "Defence", "Service", "Government", "Self Employeed", "Student" }));
		occupation.setFont(new Font("Arial", Font.PLAIN, 13));
		occupation.setBounds(94, 119, 128, 26);
		panel_2.add(occupation);

		JLabel lblNewLabel_7 = new JLabel("Qualification :");
		lblNewLabel_7.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(258, 118, 86, 28);
		panel_2.add(lblNewLabel_7);

		JComboBox qualification = new JComboBox();
		qualification.setModel(new DefaultComboBoxModel(
				new String[] { "", "HIGH SCHOOL", "DIPLOMA", "GRADUATION", "POST GRADUATION" }));
		qualification.setFont(new Font("Arial", Font.PLAIN, 12));
		qualification.setBounds(354, 119, 128, 26);
		panel_2.add(qualification);

		JLabel lblNewLabel_8 = new JLabel("Nominee Name :");
		lblNewLabel_8.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(10, 172, 99, 28);
		panel_2.add(lblNewLabel_8);

		nominee = new JTextField();
		nominee.setBounds(119, 173, 211, 25);
		panel_2.add(nominee);
		nominee.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Relation :");
		lblNewLabel_9.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(354, 174, 58, 28);
		panel_2.add(lblNewLabel_9);

		JComboBox relation = new JComboBox();
		relation.setModel(new DefaultComboBoxModel(
				new String[] { "", "Father", "Mother", "Brother", "Sister", "Wife", "Husband", "Other" }));
		relation.setFont(new Font("Arial", Font.PLAIN, 13));
		relation.setBounds(422, 172, 99, 26);
		panel_2.add(relation);

		JLabel lblNewLabel_10 = new JLabel("Email :");
		lblNewLabel_10.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_10.setBounds(10, 222, 50, 28);
		panel_2.add(lblNewLabel_10);

		email = new JTextField();
		email.setBounds(78, 223, 184, 24);
		panel_2.add(email);
		email.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Nationality :");
		lblNewLabel_11.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_11.setBounds(298, 222, 74, 28);
		panel_2.add(lblNewLabel_11);

		JComboBox nationality = new JComboBox();
		nationality.setFont(new Font("Arial", Font.PLAIN, 13));
		nationality.setModel(new DefaultComboBoxModel(new String[] { "", "INDIAN", "NRI" }));
		nationality.setBounds(382, 222, 114, 26);
		panel_2.add(nationality);

		JLabel lblNewLabel_12 = new JLabel("Mobile :");
		lblNewLabel_12.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_12.setBounds(10, 269, 58, 28);
		panel_2.add(lblNewLabel_12);

		mobile = new JTextField();
		mobile.setBounds(78, 270, 157, 25);
		panel_2.add(mobile);
		mobile.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("Alternate Mobile :");
		lblNewLabel_13.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_13.setBounds(258, 268, 114, 28);
		panel_2.add(lblNewLabel_13);

		amobile = new JTextField();
		amobile.setBounds(382, 270, 146, 25);
		panel_2.add(amobile);
		amobile.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("Room/Block :");
		lblNewLabel_14.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_14.setBounds(10, 322, 99, 28);
		panel_2.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("Apartment/Area :");
		lblNewLabel_15.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_15.setBounds(10, 371, 106, 28);
		panel_2.add(lblNewLabel_15);

		room = new JTextField();
		room.setBounds(119, 323, 388, 25);
		panel_2.add(room);
		room.setColumns(10);

		apartment = new JTextField();
		apartment.setBounds(119, 372, 388, 25);
		panel_2.add(apartment);
		apartment.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("Landmark :");
		lblNewLabel_16.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_16.setBounds(10, 417, 99, 28);
		panel_2.add(lblNewLabel_16);

		landmark = new JTextField();
		landmark.setBounds(119, 418, 388, 25);
		panel_2.add(landmark);
		landmark.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("Pincode :");
		lblNewLabel_17.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_17.setBounds(10, 462, 74, 25);
		panel_2.add(lblNewLabel_17);

		pincode = new JTextField();
		pincode.setBounds(119, 461, 116, 24);
		panel_2.add(pincode);
		pincode.setColumns(10);

		JLabel lblNewLabel_18 = new JLabel("City :");
		lblNewLabel_18.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_18.setBounds(279, 460, 37, 28);
		panel_2.add(lblNewLabel_18);

		city = new JTextField();
		city.setBounds(329, 461, 178, 24);
		panel_2.add(city);
		city.setColumns(10);

		JLabel lblNewLabel_19 = new JLabel("State :");
		lblNewLabel_19.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_19.setBounds(10, 506, 74, 28);
		panel_2.add(lblNewLabel_19);

		JComboBox state = new JComboBox();
		state.setModel(new DefaultComboBoxModel(new String[] { "", "Andhra Pradesh", "Arunachal Pradesh", "Assam",
				"Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand", "Karnataka",
				"Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha",
				"Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand",
				"West Bengal", "Andaman and Nicobar Island", "Chandigarh", "Dadra and Nagar Haveli", "Daman and Diu",
				"Delhi", "Ladakh", "Lakshadweep", "Jammu and Kashmir", "Puducherry" }));
		state.setFont(new Font("Arial", Font.PLAIN, 13));
		state.setBounds(119, 508, 186, 26);
		panel_2.add(state);

		JLabel lblNewLabel_20 = new JLabel("A/c No :");
		lblNewLabel_20.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_20.setBounds(338, 22, 50, 28);
		panel_2.add(lblNewLabel_20);

		JLabel accountNo = new JLabel("");
		accountNo.setForeground(new Color(255, 0, 0));
		accountNo.setFont(new Font("Arial", Font.PLAIN, 13));
		accountNo.setBounds(398, 23, 109, 28);
		panel_2.add(accountNo);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int AcNo = Integer.parseInt(acNo.getText());
					int cusid = Integer.parseInt(cusID.getText());
					Connection con = DB_Connection.getConnection();
					String sql = "select * from customer where AccNumber = ? and cusID = ?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setInt(1, AcNo);
					pst.setInt(2, cusid);
					ResultSet set = pst.executeQuery();
					if (set.next()) {
						name.setText(set.getString("AccName"));
						accountNo.setText(String.valueOf(set.getInt("AccNumber")));
						gender.setSelectedItem(set.getString("Gender"));
						mStatus.setSelectedItem(set.getString("MaritalStatus"));
						occupation.setSelectedItem(set.getString("Occupation"));
						qualification.setSelectedItem(set.getString("Qualification"));
						nominee.setText(set.getString("NomineeName"));
						relation.setSelectedItem(set.getString("NomineeRelation"));
						email.setText(set.getString("emailID"));
						nationality.setSelectedItem(set.getString("Nationality"));
						mobile.setText(set.getString("mobile"));
						amobile.setText(set.getString("alterMobile"));
						room.setText(set.getString("Room/Block"));
						apartment.setText(set.getString("Apartment/Area"));
						landmark.setText(set.getString("Landmark"));
						city.setText(set.getString("City"));
						pincode.setText(String.valueOf(set.getInt("Pincode")));
						state.setSelectedItem(set.getString("State"));
						branch.setText(set.getString("Branch"));

						con.close();

					} else {
						JOptionPane.showMessageDialog(panel_2, "Please enter correct details");
					}
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(panel_2, "Please enter A/c No and Customer ID");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 153, 204));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(469, 22, 89, 26);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (accountNo.getText() == "") {
					JOptionPane.showMessageDialog(panel_2, "Please enter A/c No and Customer ID");
				} else {
					try {
						Connection con = DB_Connection.getConnection();
						String sql = "update customer set AccName = ?, Gender = ?, MaritalStatus = ?, Occupation = ?,"
								+ "Qualification = ?, NomineeName = ?, NomineeRelation = ?, emailID = ?, Nationality = ?,"
								+ "mobile = ?, alterMobile = ?, `Room/Block` = ?, `Apartment/Area` = ?, Landmark = ?, city = ?,"
								+ "pincode = ?, State = ?, Branch = ? WHERE AccNumber = ?;";
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1,name.getText());
						pst.setString(2,String.valueOf(gender.getSelectedItem()));
						pst.setString(3,String.valueOf(mStatus.getSelectedItem()));
						pst.setString(4,String.valueOf(occupation.getSelectedItem()));
						pst.setString(5,String.valueOf(qualification.getSelectedItem()));
						pst.setString(6,nominee.getText());
						pst.setString(7,String.valueOf(relation.getSelectedItem()));
						pst.setString(8,email.getText());
						pst.setString(9,String.valueOf(nationality.getSelectedItem()));
						pst.setString(10,mobile.getText());
						pst.setString(11,amobile.getText());
						pst.setString(12,room.getText());
						pst.setString(13,apartment.getText());
						pst.setString(14,landmark.getText());
						pst.setString(15,city.getText());
						pst.setInt(16,Integer.parseInt(pincode.getText()));
						pst.setString(17,String.valueOf(state.getSelectedItem()));
						pst.setString(18,branch.getText());
						pst.setInt(19,Integer.parseInt(accountNo.getText()));
						int result = JOptionPane.showConfirmDialog(panel_2, "Are you Sure? you want to update the details", "Account Updation", 
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(result == 0) {
							int set = pst.executeUpdate();
							if(set != 0) {
								JOptionPane.showMessageDialog(panel_2, "Details updated successfully");
								setVisible(false);
							}
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}

			}
		});
		btnNewButton_1.setBackground(new Color(51, 204, 51));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton_1.setBounds(241, 555, 89, 28);
		panel_2.add(btnNewButton_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 544, 527, 8);
		panel_2.add(separator);

	}
}
