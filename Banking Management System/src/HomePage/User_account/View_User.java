package HomePage.User_account;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Banking_GUI.HomePage;
import Utilities.DB_Connection;
import beans.customer_bean;
import beans.query_bean;
import beans.transaction_bean;

import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;

public class View_User extends JFrame {

	private JPanel contentPane;
	private JTextField AcNo;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_User frame = new View_User();
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

	public ArrayList<transaction_bean> transactionList(int account) {
		ArrayList<transaction_bean> transactionList = new ArrayList();
		try {
			int i = 0;
			Connection con = DB_Connection.getConnection();
			String sql = "SELECT * FROM transactions where AccNo = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,account);
			ResultSet set = st.executeQuery();
			transaction_bean tbean;
			while (set.next()) {
				tbean = new transaction_bean(set.getInt("AccNo"), set.getInt("TransactionID"), set.getInt("Amount"),
						set.getString("Status"), set.getString("Mode"), set.getString("Method"), set.getString("dateOfTransaction"),set.getString("client"));
				transactionList.add(tbean);
				i++;
			}
			if (i == 0) {
				JOptionPane.showMessageDialog(table, "No Transaction Record Found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactionList;
	}

	public void showUser(int acc) {
			ArrayList<transaction_bean> list = transactionList(acc);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Object[] row = new Object[7];
			for (int i = 0; i < list.size(); i++) {
				row[0] = list.get(i).getAccNo();
				row[1] = list.get(i).getTransactionID();
				row[2] = list.get(i).getStatus();
				row[3] = list.get(i).getAmount();
				row[4] = list.get(i).getMode();
				row[5] = list.get(i).getMethod();
				row[6] = list.get(i).getDateOfTransaction();
				model.addRow(row);
			}
	}

	public View_User() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\add_user_group_woman_man_48px.png"));
		setType(Type.POPUP);
		setTitle("CUSTOMER DETAILS");
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1346, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(255, 248, 220));
		panel.setBounds(0, 0, 289, 693);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ACCOUNT DETAILS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\customer_50px.png"));
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 11, 269, 62);
		panel.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"BASIC ACCOUNT INFO", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_2.setBackground(new Color(255, 248, 220));
		panel_2.setBounds(10, 201, 269, 324);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("ACCOUNT NO:");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 32, 135, 28);
		panel_2.add(lblNewLabel_1);

		JLabel accNo = new JLabel("");
		accNo.setFont(new Font("Arial", Font.PLAIN, 15));
		accNo.setBounds(20, 59, 202, 28);
		panel_2.add(accNo);

		JLabel lblNewLabel_3 = new JLabel("ACCOUNT NAME:");
		lblNewLabel_3.setForeground(new Color(0, 0, 255));
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(10, 98, 135, 28);
		panel_2.add(lblNewLabel_3);

		JLabel accName = new JLabel("");
		accName.setFont(new Font("Arial", Font.PLAIN, 15));
		accName.setBounds(20, 126, 239, 28);
		panel_2.add(accName);

		JLabel lblNewLabel_5 = new JLabel("ACCOUNT TYPE:");
		lblNewLabel_5.setForeground(new Color(0, 0, 255));
		lblNewLabel_5.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(10, 165, 135, 28);
		panel_2.add(lblNewLabel_5);

		JLabel accType = new JLabel("");
		accType.setFont(new Font("Arial", Font.PLAIN, 15));
		accType.setBounds(20, 192, 202, 28);
		panel_2.add(accType);

		JLabel lblNewLabel_7 = new JLabel("BRANCH: ");
		lblNewLabel_7.setForeground(new Color(0, 0, 255));
		lblNewLabel_7.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_7.setBounds(10, 231, 135, 28);
		panel_2.add(lblNewLabel_7);

		JLabel branch = new JLabel("");
		branch.setFont(new Font("Arial", Font.PLAIN, 15));
		branch.setBounds(20, 256, 202, 28);
		panel_2.add(branch);

		AcNo = new JTextField();
		AcNo.setFont(new Font("Arial", Font.PLAIN, 13));
		AcNo.setBounds(10, 97, 177, 29);
		panel.add(AcNo);
		AcNo.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 71, 269, 15);
		panel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 536, 269, 8);
		panel.add(separator_1);

		JButton btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new UpdateCustomer().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_2.setBackground(new Color(233, 150, 122));
		btnNewButton_2.setBounds(156, 555, 85, 29);
		panel.add(btnNewButton_2);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 595, 269, 8);
		panel.add(separator_2);

		JButton btnNewButton_4 = new JButton("ACCOUNT STATEMENT");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(255, 0, 0));
		btnNewButton_4.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton_4.setBounds(61, 616, 158, 29);
		panel.add(btnNewButton_4);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(288, 0, 1052, 693);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 11, 1015, 305);
		panel_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"ACCOUNT DETAILS", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_9 = new JLabel("GENDER:");
		lblNewLabel_9.setForeground(new Color(0, 0, 255));
		lblNewLabel_9.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_9.setBounds(10, 23, 71, 26);
		panel_3.add(lblNewLabel_9);

		JLabel gender = new JLabel("");
		gender.setFont(new Font("Arial", Font.PLAIN, 14));
		gender.setBounds(91, 22, 87, 26);
		panel_3.add(gender);

		JLabel lblNewLabel_11 = new JLabel("AGE:");
		lblNewLabel_11.setForeground(new Color(0, 0, 255));
		lblNewLabel_11.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_11.setBounds(801, 60, 44, 26);
		panel_3.add(lblNewLabel_11);

		JLabel age = new JLabel("");
		age.setFont(new Font("Arial", Font.PLAIN, 14));
		age.setBounds(866, 60, 50, 26);
		panel_3.add(age);

		JLabel lblNewLabel_13 = new JLabel("DATE OF BIRTH:");
		lblNewLabel_13.setForeground(new Color(0, 0, 255));
		lblNewLabel_13.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_13.setBounds(208, 23, 109, 26);
		panel_3.add(lblNewLabel_13);

		JLabel dateOfBirth = new JLabel("");
		dateOfBirth.setFont(new Font("Arial", Font.PLAIN, 14));
		dateOfBirth.setBounds(345, 23, 97, 26);
		panel_3.add(dateOfBirth);

		JLabel lblNewLabel_15 = new JLabel("MARITAL STATUS:");
		lblNewLabel_15.setForeground(new Color(0, 0, 255));
		lblNewLabel_15.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_15.setBounds(472, 23, 125, 26);
		panel_3.add(lblNewLabel_15);

		JLabel mStatus = new JLabel("");
		mStatus.setFont(new Font("Arial", Font.PLAIN, 14));
		mStatus.setBounds(633, 22, 87, 26);
		panel_3.add(mStatus);

		JLabel lblNewLabel_17 = new JLabel("NATIONALITY:");
		lblNewLabel_17.setForeground(new Color(0, 0, 255));
		lblNewLabel_17.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_17.setBounds(749, 23, 97, 26);
		panel_3.add(lblNewLabel_17);

		JLabel nationality = new JLabel("");
		nationality.setFont(new Font("Arial", Font.PLAIN, 14));
		nationality.setBounds(856, 23, 97, 26);
		panel_3.add(nationality);

		JLabel lblNewLabel_19 = new JLabel("PLACE OF BIRTH: ");
		lblNewLabel_19.setForeground(new Color(0, 0, 255));
		lblNewLabel_19.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_19.setBounds(10, 60, 125, 26);
		panel_3.add(lblNewLabel_19);

		JLabel pBirth = new JLabel("");
		pBirth.setFont(new Font("Arial", Font.PLAIN, 14));
		pBirth.setBounds(145, 59, 81, 27);
		panel_3.add(pBirth);

		JLabel lblNewLabel_21 = new JLabel("OCCUPATION:");
		lblNewLabel_21.setForeground(new Color(0, 0, 255));
		lblNewLabel_21.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_21.setBounds(260, 59, 109, 27);
		panel_3.add(lblNewLabel_21);

		JLabel occupation = new JLabel("");
		occupation.setFont(new Font("Arial", Font.PLAIN, 14));
		occupation.setBounds(391, 60, 125, 26);
		panel_3.add(occupation);

		JLabel lblNewLabel_23 = new JLabel("QUALIFICATION:");
		lblNewLabel_23.setForeground(new Color(0, 0, 255));
		lblNewLabel_23.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_23.setBounds(523, 60, 125, 27);
		panel_3.add(lblNewLabel_23);

		JLabel qualification = new JLabel("");
		qualification.setFont(new Font("Arial", Font.PLAIN, 14));
		qualification.setBounds(658, 59, 133, 26);
		panel_3.add(qualification);

		JLabel lblNewLabel_27 = new JLabel("ROOM /BLOCK NO:");
		lblNewLabel_27.setForeground(new Color(0, 0, 255));
		lblNewLabel_27.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_27.setBounds(10, 171, 152, 26);
		panel_3.add(lblNewLabel_27);

		JLabel room = new JLabel("");
		room.setFont(new Font("Arial", Font.PLAIN, 14));
		room.setBounds(158, 171, 108, 26);
		panel_3.add(room);

		JLabel lblNewLabel_29 = new JLabel("APARTMENT /AREA:");
		lblNewLabel_29.setForeground(new Color(0, 0, 255));
		lblNewLabel_29.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_29.setBounds(290, 170, 152, 28);
		panel_3.add(lblNewLabel_29);

		JLabel lblNewLabel_30 = new JLabel("EMAIL:");
		lblNewLabel_30.setForeground(new Color(0, 0, 255));
		lblNewLabel_30.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_30.setBounds(10, 97, 81, 26);
		panel_3.add(lblNewLabel_30);

		JLabel email = new JLabel("");
		email.setFont(new Font("Arial", Font.PLAIN, 14));
		email.setBounds(91, 95, 244, 26);
		panel_3.add(email);

		JLabel lblNewLabel_32 = new JLabel("MOBILE NO: ");
		lblNewLabel_32.setForeground(new Color(0, 0, 255));
		lblNewLabel_32.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_32.setBounds(365, 95, 97, 27);
		panel_3.add(lblNewLabel_32);

		JLabel mobile = new JLabel("");
		mobile.setFont(new Font("Arial", Font.PLAIN, 14));
		mobile.setBounds(462, 93, 117, 26);
		panel_3.add(mobile);

		JLabel lblNewLabel_34 = new JLabel("ALTERNATE CONTACT:");
		lblNewLabel_34.setForeground(new Color(0, 0, 255));
		lblNewLabel_34.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_34.setBounds(587, 96, 167, 28);
		panel_3.add(lblNewLabel_34);

		JLabel altermobile = new JLabel("");
		altermobile.setFont(new Font("Arial", Font.PLAIN, 14));
		altermobile.setBounds(764, 93, 152, 27);
		panel_3.add(altermobile);

		JLabel lblNewLabel_36 = new JLabel("AADHAR CARD:");
		lblNewLabel_36.setForeground(new Color(0, 0, 255));
		lblNewLabel_36.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_36.setBounds(10, 134, 117, 26);
		panel_3.add(lblNewLabel_36);

		JLabel aadhar = new JLabel("");
		aadhar.setFont(new Font("Arial", Font.PLAIN, 14));
		aadhar.setBounds(132, 131, 109, 28);
		panel_3.add(aadhar);

		JLabel lblNewLabel_38 = new JLabel("PAN CARD:");
		lblNewLabel_38.setForeground(new Color(0, 0, 255));
		lblNewLabel_38.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_38.setBounds(251, 132, 87, 28);
		panel_3.add(lblNewLabel_38);

		JLabel pancard = new JLabel("");
		pancard.setFont(new Font("Arial", Font.PLAIN, 14));
		pancard.setBounds(345, 131, 97, 27);
		panel_3.add(pancard);

		JLabel area = new JLabel("");
		area.setFont(new Font("Arial", Font.PLAIN, 14));
		area.setBounds(452, 169, 196, 27);
		panel_3.add(area);

		JLabel lblNewLabel_41 = new JLabel("LANDMARK:");
		lblNewLabel_41.setForeground(new Color(0, 0, 255));
		lblNewLabel_41.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_41.setBounds(657, 171, 97, 26);
		panel_3.add(lblNewLabel_41);

		JLabel landmark = new JLabel("");
		landmark.setFont(new Font("Arial", Font.PLAIN, 14));
		landmark.setBounds(764, 169, 204, 26);
		panel_3.add(landmark);

		JLabel lblNewLabel_43 = new JLabel("CITY:");
		lblNewLabel_43.setForeground(new Color(0, 0, 255));
		lblNewLabel_43.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_43.setBounds(10, 208, 49, 26);
		panel_3.add(lblNewLabel_43);

		JLabel city = new JLabel("");
		city.setFont(new Font("Arial", Font.PLAIN, 14));
		city.setBounds(57, 208, 109, 26);
		panel_3.add(city);

		JLabel lblNewLabel_45 = new JLabel("STATE:");
		lblNewLabel_45.setForeground(new Color(0, 0, 255));
		lblNewLabel_45.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_45.setBounds(182, 206, 59, 28);
		panel_3.add(lblNewLabel_45);

		JLabel state = new JLabel("");
		state.setFont(new Font("Arial", Font.PLAIN, 14));
		state.setBounds(236, 205, 152, 28);
		panel_3.add(state);

		JLabel lblNewLabel_47 = new JLabel("PIN CODE:");
		lblNewLabel_47.setForeground(new Color(0, 0, 255));
		lblNewLabel_47.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_47.setBounds(435, 209, 81, 25);
		panel_3.add(lblNewLabel_47);

		JLabel pincode = new JLabel("");
		pincode.setFont(new Font("Arial", Font.PLAIN, 14));
		pincode.setBounds(516, 207, 81, 27);
		panel_3.add(pincode);

		JLabel lblNewLabel_49 = new JLabel("NOMINEE:");
		lblNewLabel_49.setForeground(Color.BLUE);
		lblNewLabel_49.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_49.setBounds(10, 245, 87, 28);
		panel_3.add(lblNewLabel_49);

		JLabel nominee = new JLabel("");
		nominee.setFont(new Font("Arial", Font.PLAIN, 14));
		nominee.setBounds(107, 244, 228, 26);
		panel_3.add(nominee);

		JLabel lblNewLabel_51 = new JLabel("RELATION:");
		lblNewLabel_51.setForeground(new Color(0, 0, 255));
		lblNewLabel_51.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_51.setBounds(375, 245, 87, 29);
		panel_3.add(lblNewLabel_51);

		JLabel relation = new JLabel("");
		relation.setFont(new Font("Arial", Font.PLAIN, 14));
		relation.setBounds(472, 243, 125, 28);
		panel_3.add(relation);
		
		JLabel lblNewLabel_2 = new JLabel("DATE OF JOINING:");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBackground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(617, 246, 137, 26);
		panel_3.add(lblNewLabel_2);
		
		JLabel dJoining = new JLabel("");
		dJoining.setFont(new Font("Arial", Font.PLAIN, 14));
		dJoining.setBounds(764, 245, 133, 26);
		panel_3.add(dJoining);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new TitledBorder(null, "ACCOUNT TRANSACTIONS", TitledBorder.LEADING, TitledBorder.TOP, null,
				Color.RED));
		panel_4.setBounds(10, 321, 1015, 347);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		scrollPane.setBounds(10, 26, 995, 310);
		panel_4.add(scrollPane);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Account no", "Transaction ID", "Status", "Amount", "Mode", "Method", "Date of Transaction"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setMinWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setMinWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setMinWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(130);
		table.getColumnModel().getColumn(6).setMinWidth(130);
		table.setFont(new Font("SanSerif", Font.PLAIN, 14));
		
		
		//Seach button validation
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int acno = Integer.parseInt(AcNo.getText());
				
				try {
					Connection con = DB_Connection.getConnection();
					String sql = "select * from customer where AccNumber = ?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setInt(1,acno);
					ResultSet set = pst.executeQuery();
					if(set.next()) {
						//fetching data to text label
						accNo.setText(String.valueOf(set.getInt("AccNumber")));
						accName.setText(set.getString("AccName"));
						accType.setText(set.getString("AccType"));
						branch.setText(set.getString("Branch"));
						gender.setText(set.getString("Gender"));
						dateOfBirth.setText(set.getString("DateOfBirth"));
						mStatus.setText(set.getString("MaritalStatus"));
						nationality.setText(set.getString("Nationality"));
						pBirth.setText(set.getString("placeBirth"));
						occupation.setText(set.getString("Occupation"));
						qualification.setText(set.getString("Qualification"));
						age.setText(String.valueOf(set.getInt("Age")));
						email.setText(set.getString("emailID"));
						mobile.setText(set.getString("mobile"));
						altermobile.setText(set.getString("alterMobile"));
						aadhar.setText(set.getString("aadharCard"));
						pancard.setText(set.getString("pancard"));
						room.setText(set.getString("Room/Block"));
						area.setText(set.getString("Apartment/Area"));
						landmark.setText(set.getString("Landmark"));
						city.setText(set.getString("City"));
						state.setText(set.getString("State"));
						pincode.setText(String.valueOf(set.getString("Pincode")));
						nominee.setText(set.getString("NomineeName"));
						relation.setText(set.getString("NomineeRelation"));
						dJoining.setText(set.getString("DateOfJoining"));
						
						//clearing table and fetching new data from database
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						showUser(acno);
					}else {
						JOptionPane.showMessageDialog(btnNewButton, "Please enter correct details");
						AcNo.setText("");
					}
					
					
				}catch(Exception e1) {
					
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 222, 173));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.setBounds(197, 97, 82, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(accNo.getText() == "") {
					JOptionPane.showMessageDialog(btnNewButton_1,"Please enter account number");
				}else {
					int result = JOptionPane.showConfirmDialog(area, "Are you Sure? you want to close this account?", "Account Closure", 
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(result == 0) {
						try {
							int AcNo = Integer.parseInt(accNo.getText());
							Connection con = DB_Connection.getConnection();
							String sql = "DELETE FROM customer where AccNumber = ?";
							PreparedStatement pst = con.prepareStatement(sql);
							pst.setInt(1,AcNo);
							int set = pst.executeUpdate();
							if(set != 0) {
								JOptionPane.showMessageDialog(area, "Account Closed Successfully");
								setVisible(false);
							}
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
					
				}
			}
		});
		btnNewButton_1.setBackground(new Color(233, 150, 122));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_1.setBounds(48, 555, 82, 29);
		panel.add(btnNewButton_1);
		
	}
}
