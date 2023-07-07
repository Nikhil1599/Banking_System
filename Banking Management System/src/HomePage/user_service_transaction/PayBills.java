package HomePage.user_service_transaction;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import Utilities.BankingMail;
import Utilities.DB_Connection;
import Utilities.PasswordGenerator;
import Utilities.Transaction;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class PayBills extends JFrame {

	private JPanel contentPane;
	private JTextField ccNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayBills frame = new PayBills();
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
	public PayBills() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\debit_card_40px.png"));
		setTitle("Credit Card Bills");
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 509, 666);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 493, 626);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Credit Card Bill Payment");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 296, 46);
		panel.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 68, 473, 12);
		panel.add(separator);

		JLabel lblNewLabel_1 = new JLabel("Credit Card No :");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 86, 115, 29);
		panel.add(lblNewLabel_1);

		ccNo = new JTextField();
		ccNo.setBounds(39, 115, 267, 29);
		panel.add(ccNo);
		ccNo.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 157, 473, 12);
		panel.add(separator_1);

		JLabel lblNewLabel_2 = new JLabel("Name :");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(29, 172, 58, 29);
		panel.add(lblNewLabel_2);

		JLabel name = new JLabel("");
		name.setForeground(Color.RED);
		name.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		name.setBounds(157, 170, 267, 35);
		panel.add(name);

		JLabel lblNewLabel_4 = new JLabel("A/c No :");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(29, 223, 77, 29);
		panel.add(lblNewLabel_4);

		JLabel accNo = new JLabel("");
		accNo.setForeground(Color.RED);
		accNo.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		accNo.setBounds(157, 221, 267, 35);
		panel.add(accNo);

		JLabel lblNewLabel_6 = new JLabel("Expiry :");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(29, 278, 58, 29);
		panel.add(lblNewLabel_6);

		JLabel expiry = new JLabel("");
		expiry.setForeground(Color.RED);
		expiry.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		expiry.setBounds(157, 276, 267, 35);
		panel.add(expiry);

		JLabel lblNewLabel_8 = new JLabel("Balance :");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(25, 332, 77, 29);
		panel.add(lblNewLabel_8);

		JLabel bal = new JLabel("");
		bal.setForeground(Color.RED);
		bal.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		bal.setBounds(157, 330, 267, 35);
		panel.add(bal);

		JLabel lblNewLabel_10 = new JLabel("Amount to paid :");
		lblNewLabel_10.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(25, 384, 105, 29);
		panel.add(lblNewLabel_10);

		JLabel amount = new JLabel("");
		amount.setForeground(Color.RED);
		amount.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		amount.setBounds(157, 382, 267, 35);
		panel.add(amount);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 428, 473, 12);
		panel.add(separator_2);

		JRadioButton cash = new JRadioButton("Cash");
		cash.setBackground(Color.WHITE);
		cash.setFont(new Font("Arial", Font.PLAIN, 13));
		cash.setBounds(157, 496, 67, 23);
		panel.add(cash);

		JRadioButton account = new JRadioButton("Account ");
		account.setBackground(Color.WHITE);
		account.setFont(new Font("Arial", Font.PLAIN, 13));
		account.setBounds(226, 496, 82, 23);
		panel.add(account);

		ButtonGroup group = new ButtonGroup();
		group.add(cash);
		group.add(account);

		JLabel lblNewLabel_5 = new JLabel("Credit Card no :");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(20, 441, 115, 29);
		panel.add(lblNewLabel_5);

		JLabel ccardN = new JLabel("");
		ccardN.setForeground(new Color(255, 0, 0));
		ccardN.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		ccardN.setBounds(157, 441, 240, 29);
		panel.add(ccardN);

		JLabel lblNewLabel_3 = new JLabel("Payment Method :");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(20, 492, 125, 29);
		panel.add(lblNewLabel_3);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String cardNo = ccNo.getText();
					Connection con = DB_Connection.getConnection();
					String sql = "select * from credit_card where creditCardNo = ?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, cardNo);
					ResultSet set = pst.executeQuery();
					if (set.next()) {

						String card = set.getString("creditCardNo");
						int acc = set.getInt("accNo");
						int balance = set.getInt("balance");
						int limit = set.getInt("limit");
						String expiry1 = set.getString("expiry");
						int Amount = limit - balance;
						String sql1 = "select * from customer where AccNumber = ?";
						PreparedStatement pst1 = con.prepareStatement(sql1);
						pst1.setInt(1, acc);
						ResultSet set1 = pst1.executeQuery();
						if (set1.next()) {
							// setting details to JText
							name.setText(set1.getString("AccName"));
							accNo.setText(String.valueOf(acc));
							expiry.setText(expiry1);
							bal.setText(String.valueOf(balance));
							amount.setText(String.valueOf(Amount));
							ccardN.setText(cardNo);
						}

					} else {
						JOptionPane.showMessageDialog(panel, "Please enter correct details");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 153, 51));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton.setBounds(329, 115, 89, 29);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Pay Now");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cash.isSelected()) {
					try {
						// setting variables
						int accNumber = Integer.parseInt(accNo.getText());
						String expiry1 = expiry.getText();
						int balance = Integer.parseInt(bal.getText());
						int amt = Integer.parseInt(amount.getText());
						String cCard = ccardN.getText();
						int TransactionID = Integer.parseInt(PasswordGenerator.generateRandom(7));
						String method = "Cash";
						Date date1 = new Date();
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd:HH:mm");
						String dateOfpay = df.format(date1);
						// database connectivity
						Connection con = DB_Connection.getConnection();
						String sql = "insert into creditcardbill (Card_No,TransactionID,AccNo,paidAmount,paymentMethod,paidDate) "
								+ "values (?,?,?,?,?,?)";
						String sql2 = "select * from customer where AccNumber = ?";
						PreparedStatement pst = con.prepareStatement(sql);
						PreparedStatement pst1 = con.prepareStatement(sql2);
						pst1.setInt(1, accNumber);
						pst.setInt(1, Integer.parseInt(cCard));
						pst.setInt(2, TransactionID);
						pst.setInt(3, accNumber);
						pst.setInt(4, amt);
						pst.setString(5, method);
						pst.setString(6, dateOfpay);

						int set = pst.executeUpdate();
						ResultSet set1 = pst1.executeQuery();
						if (set != 0 && set1.next()) {
							int newBal = balance + amt;
							String email = set1.getString("emailID");
							String sql1 = "update credit_card set balance = ? where creditCardNo = ?";
							PreparedStatement pst2 = con.prepareStatement(sql1);
							pst2.setInt(1, newBal);
							pst2.setString(2, cCard);
							int set2 = pst2.executeUpdate();
							if (set2 != 0) {
								JOptionPane.showMessageDialog(panel, "Bill Paid successfully");
								BankingMail.creditCardBill(email, cCard, TransactionID, accNumber, amt, method,
										dateOfpay, newBal);
								setVisible(false);
							}
						}

					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(panel, "Please enter credit card no");
					} catch (Exception e2) {
						e2.printStackTrace();
					}

				} else if (account.isSelected()) {

					try {
						// setting variables
						int accNumber = Integer.parseInt(accNo.getText());
						String expiry1 = expiry.getText();
						int balance = Integer.parseInt(bal.getText());
						int amt = Integer.parseInt(amount.getText());
						String cCard = ccardN.getText();
						int TransactionID = Integer.parseInt(PasswordGenerator.generateRandom(7));
						String method = "A/c Balance";
						String client = "Credit card due";
						Date date1 = new Date();
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd:HH:mm");
						String dateOfpay = df.format(date1);
						// database connectivity
						Connection con = DB_Connection.getConnection();

						String sql2 = "select * from customer where AccNumber = ?";
						String sql4 = "select * from balance where AccNo = ?";

						PreparedStatement pst1 = con.prepareStatement(sql2);
						PreparedStatement pst3 = con.prepareStatement(sql4);
						pst3.setInt(1, accNumber);
						pst1.setInt(1, accNumber);
						ResultSet set1 = pst1.executeQuery();
						ResultSet set3 = pst3.executeQuery();
						if (set1.next() && set3.next()) {
							String email = set1.getString("emailID");
							int AccBalance = set3.getInt("balance");
							int newBal = balance + amt;
							int newAccBal = 0;

							if (AccBalance > amt) {
								newAccBal = AccBalance - amt;
								String sql = "insert into creditcardbill (Card_No,TransactionID,AccNo,paidAmount,paymentMethod,paidDate) "
										+ "values (?,?,?,?,?,?)";

								String sql1 = "update credit_card set balance = ? where creditCardNo = ?";
								String sql5 = "update balance set balance = ? where AccNo = ?";
								PreparedStatement pst4 = con.prepareStatement(sql5);
								PreparedStatement pst2 = con.prepareStatement(sql1);
								PreparedStatement pst = con.prepareStatement(sql);
								pst.setInt(1, Integer.parseInt(cCard));
								pst.setInt(2, TransactionID);
								pst.setInt(3, accNumber);
								pst.setInt(4, amt);
								pst.setString(5, method);
								pst.setString(6, dateOfpay);
								pst4.setInt(1, newAccBal);
								pst4.setInt(2, accNumber);
								pst2.setInt(1, newBal);
								pst2.setString(2, cCard);
								int set4 = pst4.executeUpdate();
								int set2 = pst2.executeUpdate();
								int set = pst.executeUpdate();
								if (set2 != 0 && set4 != 0 && set != 0) {
									JOptionPane.showMessageDialog(panel, "Bill Paid successfully");
									Transaction.creditBill(accNumber, TransactionID, email, client, method, amt,
											dateOfpay, newAccBal);
									BankingMail.creditCardBill(email, cCard, TransactionID, accNumber, amt, method,
											dateOfpay, newBal);
									setVisible(false);
								}
							} else {
								JOptionPane.showMessageDialog(panel, "Insufficent Balance");

							}

						}
					} catch (NumberFormatException nfe) {
						nfe.printStackTrace();
						//JOptionPane.showMessageDialog(panel, "Please enter credit card no");
					} catch (Exception e2) {
						e2.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(panel, "Please select payment method");
				}
			}
		});
		btnNewButton_1.setBackground(new Color(51, 102, 255));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_1.setBounds(197, 556, 89, 29);
		panel.add(btnNewButton_1);

	}
}
