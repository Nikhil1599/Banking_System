package Banking_Staff;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Banking_GUI.HomePage;
import Utilities.DB_Connection;
import beans.customer_bean;
import beans.query_bean;

public class CustomerDetails extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerDetails frame = new CustomerDetails();
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

	public ArrayList<customer_bean> customerList() {
		ArrayList<customer_bean> customerList = new ArrayList();
		try {
			int i = 0;
			Connection con = DB_Connection.getConnection();
			String sql = "SELECT * FROM customer";
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			customer_bean qbean;
			while (rs.next()) {
				qbean = new customer_bean(rs.getInt("cusID"), rs.getInt("AccNumber"), rs.getString("AccName"),
						rs.getString("AccType"), rs.getString("gender"), rs.getInt("Age"),
						rs.getString("MaritalStatus"), rs.getString("Occupation"), rs.getString("NomineeName"),
						rs.getString("NomineeRelation"), rs.getString("Branch"), rs.getString("DateOfBirth"),
						rs.getString("placeBirth"), rs.getString("Qualification"), rs.getString("aadharCard"),
						rs.getString("pancard"), rs.getString("emailID"), rs.getString("mobile"),
						rs.getString("alterMobile"), rs.getString("Room/Block"), rs.getString("Apartment/Area"),
						rs.getString("Landmark"), rs.getString("City"), rs.getInt("Pincode"), rs.getString("State"),
						rs.getString("Nationality"), rs.getString("DateOfJoining"));
				customerList.add(qbean);
				i++;
			}
			if (i == 0) {
				JOptionPane.showMessageDialog(contentPane, "No Record Found");
				setVisible(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return customerList;
	}

	public void showUser() {
		ArrayList<customer_bean> list = customerList();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[27];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getCusID();
			row[1] = list.get(i).getAccNumber();
			row[2] = list.get(i).getAccName();
			row[3] = list.get(i).getAccType();
			row[4] = list.get(i).getGender();
			row[5] = list.get(i).getAge();
			row[6] = list.get(i).getMaritalStatus();
			row[7] = list.get(i).getOccupation();
			row[8] = list.get(i).getNomineeName();
			row[9] = list.get(i).getNomineeRelation();
			row[10] = list.get(i).getBranch();
			row[11] = list.get(i).getDateOfBirth();
			row[12] = list.get(i).getPlaceOfBirth();
			row[13] = list.get(i).getQualification();
			row[14] = list.get(i).getAadharCard();
			row[15] = list.get(i).getPancard();
			row[16] = list.get(i).getEmailID();
			row[17] = list.get(i).getMobile();
			row[18] = list.get(i).getAltermobile();
			row[19] = list.get(i).getRoom();
			row[20] = list.get(i).getArea();
			row[21] = list.get(i).getLandmark();
			row[22] = list.get(i).getCity();
			row[23] = list.get(i).getPincode();
			row[24] = list.get(i).getState();
			row[25] = list.get(i).getNationality();
			row[26] = list.get(i).getDateOfJoining();
			model.addRow(row);
		}
	}

	public CustomerDetails() {
		setTitle("Customers List");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\customer_48px.png"));
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1098, 625);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Customers List");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		lblNewLabel.setBounds(23, 11, 239, 47);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 69, 1042, 499);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Customer ID", "Account No", "A/c Name", "A/c Type", "Gender", "Age", "Marital Status",
						"Occupation", "Nominee Name", "Nominee Relation", "Branch", "Date of Birth", "Place of Birth",
						"Qualification", "Aadhar Card", "Pan Card", "Email ID", "Mobile", "Alternate Mobile",
						"Room/Block", "Apartment/Area", "Landmark", "City", "Pin Code", "State", "Nationality",
						"Date of Joining" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false, false, false, false, false, false, false,
					false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setMinWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setMinWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setMinWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(5).setMinWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(140);
		table.getColumnModel().getColumn(6).setMinWidth(140);
		table.getColumnModel().getColumn(7).setPreferredWidth(155);
		table.getColumnModel().getColumn(7).setMinWidth(150);
		table.getColumnModel().getColumn(8).setPreferredWidth(200);
		table.getColumnModel().getColumn(8).setMinWidth(200);
		table.getColumnModel().getColumn(9).setPreferredWidth(130);
		table.getColumnModel().getColumn(9).setMinWidth(130);
		table.getColumnModel().getColumn(10).setPreferredWidth(130);
		table.getColumnModel().getColumn(10).setMinWidth(130);
		table.getColumnModel().getColumn(11).setPreferredWidth(120);
		table.getColumnModel().getColumn(11).setMinWidth(120);
		table.getColumnModel().getColumn(12).setPreferredWidth(130);
		table.getColumnModel().getColumn(12).setMinWidth(130);
		table.getColumnModel().getColumn(13).setPreferredWidth(150);
		table.getColumnModel().getColumn(13).setMinWidth(150);
		table.getColumnModel().getColumn(14).setPreferredWidth(160);
		table.getColumnModel().getColumn(14).setMinWidth(160);
		table.getColumnModel().getColumn(15).setPreferredWidth(120);
		table.getColumnModel().getColumn(15).setMinWidth(120);
		table.getColumnModel().getColumn(16).setPreferredWidth(250);
		table.getColumnModel().getColumn(16).setMinWidth(250);
		table.getColumnModel().getColumn(17).setPreferredWidth(130);
		table.getColumnModel().getColumn(17).setMinWidth(130);
		table.getColumnModel().getColumn(18).setPreferredWidth(130);
		table.getColumnModel().getColumn(18).setMinWidth(130);
		table.getColumnModel().getColumn(19).setPreferredWidth(200);
		table.getColumnModel().getColumn(19).setMinWidth(200);
		table.getColumnModel().getColumn(20).setPreferredWidth(200);
		table.getColumnModel().getColumn(20).setMinWidth(200);
		table.getColumnModel().getColumn(21).setPreferredWidth(200);
		table.getColumnModel().getColumn(21).setMinWidth(200);
		table.getColumnModel().getColumn(22).setPreferredWidth(150);
		table.getColumnModel().getColumn(22).setMinWidth(150);
		table.getColumnModel().getColumn(23).setPreferredWidth(120);
		table.getColumnModel().getColumn(23).setMinWidth(120);
		table.getColumnModel().getColumn(24).setPreferredWidth(190);
		table.getColumnModel().getColumn(24).setMinWidth(190);
		table.getColumnModel().getColumn(25).setPreferredWidth(100);
		table.getColumnModel().getColumn(25).setMinWidth(100);
		table.getColumnModel().getColumn(26).setPreferredWidth(130);
		table.getColumnModel().getColumn(26).setMinWidth(130);
		scrollPane.setViewportView(table);

		showUser();

	}
}
