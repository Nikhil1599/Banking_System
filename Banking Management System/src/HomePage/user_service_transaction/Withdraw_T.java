package HomePage.user_service_transaction;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import Utilities.DB_Connection;
import Utilities.PasswordGenerator;
import Utilities.Transaction;

import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Withdraw_T extends JFrame {

	private JPanel contentPane;
	private JTextField account;
	private JTextField cusId;
	private JTextField amount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw_T frame = new Withdraw_T();
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
	public Withdraw_T() {
		setTitle("Withdraw Money");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\debit_card_40px.png"));
		setResizable(false);
		setAlwaysOnTop(true);
		setBounds(100, 100, 908, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 892, 466);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(255, 235, 205));
		panel_1.setBounds(21, 22, 291, 408);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("WITHDRAW MONEY");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\debit_card_40px.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 22, 240, 42);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Customer A/C No:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 94, 145, 27);
		panel_1.add(lblNewLabel_1);

		account = new JTextField();
		account.setBounds(34, 128, 208, 30);
		panel_1.add(account);
		account.setColumns(10);

		cusId = new JTextField();
		cusId.setBounds(34, 207, 208, 30);
		panel_1.add(cusId);
		cusId.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Customer ID:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 169, 145, 27);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Amount:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 248, 145, 27);
		panel_1.add(lblNewLabel_3);

		amount = new JTextField();
		amount.setBounds(34, 286, 208, 30);
		panel_1.add(amount);
		amount.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 69, 271, 14);
		panel_1.add(separator);

		JTextArea statement = new JTextArea();
		statement.setEditable(false);
		statement.setFont(new Font("Monospaced", Font.PLAIN, 14));
		statement.setLineWrap(true);
		statement.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		statement.setBounds(540, 11, 333, 425);
		panel.add(statement);

		JButton btnNewButton_3 = new JButton("Withdraw");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int cusID = Integer.parseInt(cusId.getText());
				int AccNo = Integer.parseInt(account.getText());
				int Amount = Integer.parseInt(amount.getText());

				// setting transaction time and date
				Date date = new Date();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd:HH:mm");
				String dateOfTransaction = df.format(date);

				try {
					Connection con = DB_Connection.getConnection();
					String sql = "select * from customer where cusID = ? and AccNumber = ?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setInt(1, cusID);
					pst.setInt(2, AccNo);
					ResultSet set = pst.executeQuery();
					if (set.next()) {
						String name = set.getString("AccName");
						String branch = set.getString("Branch");
						String email = set.getString("emailID");
						String sql2 = "SELECT balance from balance where AccNo = ?";
						PreparedStatement pst1 = con.prepareStatement(sql2);
						pst1.setInt(1, AccNo);
						ResultSet rset = pst1.executeQuery();
						if (rset.next()) {
							int money = rset.getInt("balance");
							if (money > Amount) {
								int balance = money - Amount;
								String sql3 = "update balance set balance = ? where AccNo = ?";
								PreparedStatement pst2 = con.prepareStatement(sql3);
								pst2.setInt(1, balance);
								pst2.setInt(2, AccNo);
								int set2 = pst2.executeUpdate();
								if (set2 != 0) {
									JOptionPane.showMessageDialog(btnNewButton_3, "Amount withdrawal successfully");
									PreparedStatement pst3 = con.prepareStatement(sql2);
									pst3.setInt(1, AccNo);
									ResultSet rset1 = pst1.executeQuery();
									if (rset1.next()) {
										int bal = rset1.getInt("balance");
										int transaction = Integer.parseInt(PasswordGenerator.generateRandom(7));
										String client = "Bank Withdrawal";
										String method = "Cash";
										statement.setText("\n\t        NBSC Bank\n"
												+ " ***************************************\n Name: " + name
												+ "\n Ac No: " + AccNo + "   Branch: " + branch + "\n Cust ID: " + cusID
												+ "   Date: " + dateOfTransaction + ""
												+ "\n ***************************************\n Amount: " + Amount
												+ "   By: " + method + " \n Transaction ID: " + transaction + " \n Time: "
												+ dateOfTransaction + "\n\n Amount Successfully"
												+ " Debited from Account\n ***************************************\n\t        Thank you");

										// Resetting input field
										account.setText("");
										cusId.setText("");
										amount.setText("");
										Transaction.Withdrawal(AccNo, transaction, email, client, method, Amount, dateOfTransaction, bal);
									}
								}

							} else {
								JOptionPane.showMessageDialog(btnNewButton_3, "Insufficient Balance");
							}
						}

					} else {
						JOptionPane.showMessageDialog(btnNewButton_3, "Please enter correct details");
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		btnNewButton_3.setBackground(new Color(255, 204, 0));
		btnNewButton_3.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_3.setBounds(34, 350, 89, 30);
		panel_1.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Reset");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				account.setText("");
				cusId.setText("");
				amount.setText("");
			}
		});
		btnNewButton_4.setBackground(new Color(255, 204, 0));
		btnNewButton_4.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_4.setBounds(153, 350, 89, 30);
		panel_1.add(btnNewButton_4);

		JButton btnNewButton = new JButton("Statement");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					statement.print();
					statement.setText("");
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(51, 204, 51));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton.setBounds(425, 51, 105, 33);
		panel.add(btnNewButton);
	}
}
