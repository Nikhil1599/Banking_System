package HomePage.user_service_request;

import Utilities.AccountService;
import Utilities.DB_Connection;
import Utilities.PasswordGenerator;
import beans.creditBean;
import beans.debitBean;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class CreditCard extends JFrame {

	private JPanel contentPane;
	private JTextField AccNo;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreditCard frame = new CreditCard();
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

	public ArrayList<creditBean> creditList() {
		ArrayList<creditBean> creditlist = new ArrayList();

		try {
			int i = 0;
			Connection con = DB_Connection.getConnection();
			String query1 = "SELECT * FROM credit_card";
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(query1);
			creditBean qbean;
			while (rs.next()) {
				qbean = new creditBean(rs.getString("creditCardNo"), rs.getString("expiry"),
						rs.getString("dateOfJoining"), rs.getInt("accNo"), rs.getInt("balance"), rs.getInt("limit"),
						rs.getInt("cvv"));
				creditlist.add(qbean);
				i++;
			}
			if (i == 0) {
				JOptionPane.showMessageDialog(null, "No Record Found");
				setVisible(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return creditlist;
	}

	public void showUser() {
		ArrayList<creditBean> list = creditList();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[7];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getCardNo();
			row[1] = list.get(i).getAccNo();
			row[2] = list.get(i).getBalance();
			row[3] = list.get(i).getLimit();
			row[4] = list.get(i).getExpiry();
			row[5] = list.get(i).getCvv();
			row[6] = list.get(i).getDateOfJoin();

			model.addRow(row);

		}
	}

	public CreditCard() {
		setTitle("Credit Card Portal");
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1231, 591);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"New Application", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 22, 340, 506);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Issue Credit Card");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 27, 320, 45);
		panel.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 70, 320, 12);
		panel.add(separator);

		JLabel lblNewLabel_1 = new JLabel("Customer A/c No :");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 83, 127, 25);
		panel.add(lblNewLabel_1);

		AccNo = new JTextField();
		AccNo.setBounds(10, 104, 221, 31);
		panel.add(AccNo);
		AccNo.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 146, 320, 12);
		panel.add(separator_1);

		JLabel lblNewLabel_2 = new JLabel("Name :");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 169, 71, 31);
		panel.add(lblNewLabel_2);

		JLabel name = new JLabel("");
		name.setForeground(new Color(255, 0, 0));
		name.setFont(new Font("SansSerif", Font.PLAIN, 13));
		name.setBounds(91, 168, 221, 31);
		panel.add(name);

		JLabel lblNewLabel_3 = new JLabel("A/c No :");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(12, 212, 71, 28);
		panel.add(lblNewLabel_3);

		JLabel acNo = new JLabel("");
		acNo.setForeground(new Color(255, 0, 0));
		acNo.setFont(new Font("SansSerif", Font.PLAIN, 13));
		acNo.setBounds(91, 210, 226, 31);
		panel.add(acNo);

		JLabel lblNewLabel_4 = new JLabel("Customer ID :");
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 251, 89, 25);
		panel.add(lblNewLabel_4);

		JLabel cusID = new JLabel("");
		cusID.setForeground(new Color(255, 0, 0));
		cusID.setFont(new Font("SansSerif", Font.PLAIN, 13));
		cusID.setBounds(91, 245, 214, 31);
		panel.add(cusID);

		JLabel lblNewLabel_5 = new JLabel("Limit :");
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 337, 82, 31);
		panel.add(lblNewLabel_5);

		JComboBox limit = new JComboBox();
		limit.setFont(new Font("SansSerif", Font.PLAIN, 13));
		limit.setModel(
				new DefaultComboBoxModel(new String[] { "", "25000", "50000", "75000", "100000", "150000", "200000" }));
		limit.setBounds(108, 336, 193, 31);
		panel.add(limit);

		JLabel lblNewLabel_6 = new JLabel("Email Id :");
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 287, 82, 31);
		panel.add(lblNewLabel_6);

		JLabel email = new JLabel("");
		email.setFont(new Font("SansSerif", Font.PLAIN, 13));
		email.setForeground(new Color(255, 0, 0));
		email.setBounds(91, 287, 193, 31);
		panel.add(email);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 395, 320, 12);
		panel.add(separator_2);

		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Resetting
				acNo.setText("");
				name.setText("");
				email.setText("");
				cusID.setText("");
				AccNo.setText("");
			}
		});
		btnNewButton_2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(153, 153, 153));
		btnNewButton_2.setBounds(175, 418, 89, 31);
		panel.add(btnNewButton_2);

		JLabel lblNewLabel_7 = new JLabel("Customer Details");
		lblNewLabel_7.setForeground(new Color(0, 51, 255));
		lblNewLabel_7.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(360, 22, 238, 50);
		contentPane.add(lblNewLabel_7);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(360, 65, 839, 466);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Card No", "Customer A/c No", "Balance", "Limit", "Expiry", "Cvv", "Order Date" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(0).setMinWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setMinWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setMinWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setMinWidth(130);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(140);
		table.getColumnModel().getColumn(6).setMinWidth(140);
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int AccNumber = Integer.parseInt(AccNo.getText());

					Connection con = DB_Connection.getConnection();
					String sql = "select * from customer where AccNumber = ?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setInt(1, AccNumber);
					ResultSet set = pst.executeQuery();

					if (set.next()) {
						acNo.setText(String.valueOf(set.getInt("AccNumber")));
						name.setText(set.getString("AccName"));
						cusID.setText(String.valueOf(set.getInt("cusID")));
						email.setText(set.getString("emailID"));

					} else {
						JOptionPane.showMessageDialog(contentPane, "No Result Found");
					}

				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(contentPane, "Please enter A/c no");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 204, 102));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton.setBounds(241, 103, 89, 31);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Order\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					int AccNumber = Integer.parseInt(acNo.getText());
					String Name = name.getText();
					String Email = email.getText();
					int cvv = Integer.parseInt(PasswordGenerator.generateRandom(2));
					int pin = Integer.parseInt(PasswordGenerator.generateRandom(3));
					Date date = new Date();
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					String dateOfjoin = df.format(date);
					
					if (limit.getSelectedIndex() != 0) {
						int Limit = Integer.parseInt((String) limit.getSelectedItem());
						AccountService.CreditCard(AccNumber, dateOfjoin, Email, cvv, pin, Name, Limit);
						JOptionPane.showMessageDialog(contentPane, "Order Confirmed");
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						showUser();

						// Resetting
						acNo.setText("");
						name.setText("");
						email.setText("");
						cusID.setText("");
						AccNo.setText("");
						limit.setSelectedIndex(0);
					} else {
						JOptionPane.showMessageDialog(contentPane, "Please select limit");
					}

				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(contentPane, "Please enter A/c no");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_1.setBounds(64, 418, 89, 31);
		panel.add(btnNewButton_1);

		showUser();

	}
}
