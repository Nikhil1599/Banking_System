package HomePage.user_service_transaction;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import Banking_GUI.HomePage;
import Utilities.DB_Connection;
import beans.Loan;
import beans.query_bean;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LaonDetails extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaonDetails frame = new LaonDetails();
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

	public ArrayList<Loan> loanList(String val) {
		ArrayList<Loan> loanList = new ArrayList();
			if(val != "All") {
			try {
				int i = 0;
				Connection con = DB_Connection.getConnection();
				String sql = "SELECT * from loanapplication where loanFor = ?";
				PreparedStatement st =  con.prepareStatement(sql);
				st.setString(1,val);
				ResultSet rs = st.executeQuery();
				Loan lbean;
				while (rs.next()) {
					lbean = new Loan(rs.getInt("AccNo"), rs.getInt("PolicyNo"), rs.getInt("loanAmount"),
							rs.getInt("payableAmount"), rs.getString("interest"), rs.getString("loanFor"),
							rs.getString("tenure"), rs.getString("dateOfJoin"));
					loanList.add(lbean);
					i++;
				}
				if (i == 0) {
					JOptionPane.showMessageDialog(contentPane, "No Record Found");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			try {
				int i = 0;
				Connection con = DB_Connection.getConnection();
				String sql = "SELECT * from loanapplication";
				Statement st = (Statement) con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				Loan lbean;
				while (rs.next()) {
					lbean = new Loan(rs.getInt("AccNo"), rs.getInt("PolicyNo"), rs.getInt("loanAmount"),
							rs.getInt("payableAmount"), rs.getString("interest"), rs.getString("loanFor"),
							rs.getString("tenure"), rs.getString("dateOfJoin"));
					loanList.add(lbean);
					i++;
				}
				if (i == 0) {
					JOptionPane.showMessageDialog(contentPane, "No Record Found");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return loanList;
	}

	public void showUser(String val) {
		ArrayList<Loan> list = loanList(val);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[8];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getAccNo();
			row[1] = list.get(i).getPolicyNo();
			row[2] = list.get(i).getLoanAmount();
			row[3] = list.get(i).getInterest();
			row[4] = list.get(i).getLoanFor();
			row[5] = list.get(i).getTenure();
			row[6] = list.get(i).getTotalAmount();
			row[7] = list.get(i).getDateOfJoin();

			model.addRow(row);
		}
	}

	public LaonDetails() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\finance.png"));
		setTitle("Customer Loan Data");
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1144, 618);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Loan Data");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 22, 172, 37);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 77, 1086, 484);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "A/c No", "Policy No", "Laon Amount",
				"Interest", "Loan Type", "Tenure", "Total Amount", "Issue Date" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setMinWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setMinWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setMinWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(120);
		table.getColumnModel().getColumn(6).setMinWidth(120);
		table.getColumnModel().getColumn(7).setPreferredWidth(120);
		table.getColumnModel().getColumn(7).setMinWidth(120);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("Select Loan Type :");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(669, 30, 125, 26);
		contentPane.add(lblNewLabel_1);

		JComboBox loanType = new JComboBox();
		loanType.setModel(new DefaultComboBoxModel(
				new String[] { "All", "Personal", "Home Loan", "Education Loan", "Car Loan" }));
		loanType.setFont(new Font("SansSerif", Font.PLAIN, 13));
		loanType.setBounds(804, 27, 178, 28);
		contentPane.add(loanType);
		
		showUser("All");
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				showUser(String.valueOf(loanType.getSelectedItem()));	
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 204, 51));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton.setBounds(998, 28, 89, 28);
		contentPane.add(btnNewButton);
	}
}
