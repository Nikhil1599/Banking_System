package HomePage.User_account;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import Utilities.DB_Connection;
import Utilities.PasswordGenerator;
import Utilities.Transaction;
import beans.FixedDepo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FD extends JFrame {

	private JPanel contentPane;
	private JTextField acNo;
	private JTextField amount;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FD frame = new FD();
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

	public ArrayList<FixedDepo> fixedDepo(int account) {
		ArrayList<FixedDepo> fixedDepot = new ArrayList();
		try {
			int i = 0;
			Connection con = DB_Connection.getConnection();
			String sql = "select * from fixed_deposit where AccNo = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, account);
			ResultSet set = st.executeQuery();
			FixedDepo fbean;
			while (set.next()) {
				fbean = new FixedDepo(set.getInt("Request_ID"), set.getInt("Amount"), set.getString("duration"),
						set.getString("maturity"), set.getString("dateOfInvest"));
				fixedDepot.add(fbean);
				i++;
			}
			if (i == 0) {
				JOptionPane.showMessageDialog(table, "No Investment Record Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fixedDepot;

	}

	public void showUser(int acc) {
		ArrayList<FixedDepo> list = fixedDepo(acc);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[5];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getRequestID();
			row[1] = list.get(i).getAmount();
			row[2] = list.get(i).getDuration();
			row[3] = list.get(i).getMaturity();
			row[4] = list.get(i).getDateOfInvest();
			model.addRow(row);
		}
	}

	public FD() {
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\deposit_80px.png"));
		setTitle("FIXED DEPOSIT");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1204, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 102, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1188, 605);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Customer Fixed Deposit", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBounds(10, 11, 297, 583);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Customer A/c No");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 29, 148, 21);
		panel_1.add(lblNewLabel);

		acNo = new JTextField();
		acNo.setBounds(10, 61, 181, 28);
		panel_1.add(acNo);
		acNo.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 114, 52, 28);
		panel_1.add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 100, 277, 8);
		panel_1.add(separator);

		JLabel name = new JLabel("");
		name.setForeground(new Color(255, 0, 0));
		name.setFont(new Font("Arial", Font.PLAIN, 13));
		name.setBounds(72, 114, 215, 28);
		panel_1.add(name);

		JLabel lblNewLabel_2 = new JLabel("A/c No :");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 164, 62, 28);
		panel_1.add(lblNewLabel_2);

		JLabel accountN = new JLabel("");
		accountN.setForeground(new Color(255, 0, 0));
		accountN.setFont(new Font("Arial", Font.PLAIN, 13));
		accountN.setBounds(82, 164, 205, 28);
		panel_1.add(accountN);

		JLabel lblNewLabel_4 = new JLabel("A/c Type :");
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 214, 74, 28);
		panel_1.add(lblNewLabel_4);

		JLabel AcType = new JLabel("");
		AcType.setForeground(new Color(255, 0, 0));
		AcType.setFont(new Font("Arial", Font.PLAIN, 13));
		AcType.setBounds(94, 213, 193, 28);
		panel_1.add(AcType);

		JLabel lblNewLabel_6 = new JLabel("Balance :");
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 263, 74, 28);
		panel_1.add(lblNewLabel_6);

		JLabel bal = new JLabel("");
		bal.setForeground(new Color(255, 0, 0));
		bal.setFont(new Font("Arial", Font.PLAIN, 13));
		bal.setBounds(94, 263, 193, 28);
		panel_1.add(bal);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(null, "Transaction Details", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 320, 277, 252);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("Amount :");
		lblNewLabel_8.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(10, 31, 66, 27);
		panel_2.add(lblNewLabel_8);

		amount = new JTextField();
		amount.setBounds(86, 31, 169, 25);
		panel_2.add(amount);
		amount.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Term :");
		lblNewLabel_9.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(10, 82, 66, 27);
		panel_2.add(lblNewLabel_9);

		JComboBox duration = new JComboBox();
		duration.setModel(
				new DefaultComboBoxModel(new String[] { "", "3 Month", "6 Month", "1 Year", "3 Years", "5 Years" }));
		duration.setFont(new Font("Arial", Font.PLAIN, 13));
		duration.setBounds(86, 81, 169, 26);
		panel_2.add(duration);

		JButton btnNewButton_1 = new JButton("Transfer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int accNo = Integer.parseInt(accountN.getText());
					int Amount = Integer.parseInt(amount.getText());
					String term = String.valueOf(duration.getSelectedItem());

					Connection con = DB_Connection.getConnection();
					String sql = "select * from balance where AccNo = ?";
					String sql2 = "select * from customer where AccNumber = ?";
					PreparedStatement pst = con.prepareStatement(sql);
					PreparedStatement pst2 = con.prepareStatement(sql2);
					pst.setInt(1, accNo);
					pst2.setInt(1, accNo);
					ResultSet set = pst.executeQuery();
					ResultSet set2 = pst2.executeQuery();
					while (set.next() && set2.next()) {
						int balance = set.getInt("balance");
						String email = set2.getString("emailID");
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						Date date1 = new Date();
						String dateOfJoining = sdf.format(date1);

						Calendar c = Calendar.getInstance();
						c.setTime(new Date()); // Using today's date
						if (term == "3 Month") {
							c.add(Calendar.MONTH, 3);
						} else if (term == "6 Month") {
							c.add(Calendar.MONTH, 6);
						} else if (term == "1 Year") {
							c.add(Calendar.YEAR, 1);
						} else if (term == "3 Years") {
							c.add(Calendar.YEAR, 3);
						} else if (term == "5 Years") {
							c.add(Calendar.YEAR, 5);
						}

						String validity = sdf.format(c.getTime());

						if (balance > Amount) {
							int RequestID = Integer.parseInt(PasswordGenerator.generateRandom(7));
							int TransactionID = Integer.parseInt(PasswordGenerator.generateRandom(7));
							int restBalance = balance - Amount;
							String sql1 = "insert into fixed_deposit (Request_Id,AccNo,Amount,duration,maturity,dateOfInvest) values "
									+ "(?,?,?,?,?,?)";
							PreparedStatement pst1 = con.prepareStatement(sql1);
							pst1.setInt(1, RequestID);
							pst1.setInt(2, accNo);
							pst1.setInt(3, Amount);
							pst1.setString(4, term);
							pst1.setString(5, validity);
							pst1.setString(6, dateOfJoining);
							int set1 = pst1.executeUpdate();
							if (set1 != 0) {
								String client = "Fixed Deposit";
								String method = "A/c balance";

								String sql4 = "update balance set balance = ? where AccNo = ?";
								PreparedStatement pst4 = con.prepareStatement(sql4);
								pst4.setInt(1, restBalance);
								pst4.setInt(2, accNo);
								int set4 = pst4.executeUpdate();
								if (set4 > 0) {
									JOptionPane.showMessageDialog(btnNewButton_1, "Transaction completed successfully");
									Transaction.fixedDeposit(RequestID, accNo, TransactionID, email, client, method,
											Amount, dateOfJoining, validity, term, restBalance);
									setVisible(false);
								}

							}
						} else {
							JOptionPane.showMessageDialog(panel_1, "Insufficent Balance");
						}
					}

				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(panel_1, "Please enter A/c no");
				}  catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(51, 153, 255));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton_1.setBounds(92, 158, 89, 33);
		panel_2.add(btnNewButton_1);

		

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 302, 277, 8);
		panel_1.add(separator_1);

		JLabel lblNewLabel_10 = new JLabel("CURRENT INVESTMENT");
		lblNewLabel_10.setForeground(new Color(0, 102, 255));
		lblNewLabel_10.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		lblNewLabel_10.setBounds(317, 11, 279, 42);
		panel.add(lblNewLabel_10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(317, 64, 861, 530);
		panel.add(scrollPane);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.setFont(new Font("Arial", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Request ID", "Amount", "Duration", "Maturity Date", "Date of Investment" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(0).setMinWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setMinWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setMinWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int account = Integer.parseInt(acNo.getText());
					Connection con = DB_Connection.getConnection();
					String sql = "select * from customer where AccNumber = ?";
					String sql2 = "select * from balance where AccNo = ?";
					PreparedStatement pst = con.prepareStatement(sql);
					PreparedStatement pst1 = con.prepareStatement(sql2);
					pst1.setInt(1, account);
					pst.setInt(1, account);
					ResultSet set = pst.executeQuery();
					ResultSet set2 = pst1.executeQuery();
					if (set.next() && set2.next()) {
						name.setText(set.getString("AccName"));
						accountN.setText(String.valueOf(set.getInt("AccNumber")));
						AcType.setText(set.getString("AccType"));
						bal.setText(String.valueOf(set2.getInt("balance")));
						//clearing table and fetching new data from database
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						showUser(account);

					} else {
						JOptionPane.showMessageDialog(panel_1, "Please enter correct details");
					}
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(panel_1, "Please enter A/c no");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBackground(new Color(51, 204, 102));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(201, 61, 86, 28);
		panel_1.add(btnNewButton);
		
	}
}
