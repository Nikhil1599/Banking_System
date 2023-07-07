package HomePage.user_service_transaction;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import Utilities.DB_Connection;
import Utilities.PasswordGenerator;
import Utilities.Transaction;

import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Deposit_T extends JFrame {

	private JPanel contentPane;
	private JTextField acNo;
	private JTextField cusID;
	private JTextField amount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit_T frame = new Deposit_T();
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
	 
	public Deposit_T() {
		setTitle("Deposit Money");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\money_40px.png"));
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 894, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(
				new BevelBorder(BevelBorder.LOWERED, null, new Color(128, 128, 128), null, new Color(255, 255, 255)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 879, 457);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(24, 21, 300, 413);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(255, 248, 220));
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("DEPOSIT MONEY");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\transaction_40px.png"));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 255, 50);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Customer A/C No:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 82, 134, 25);
		panel_1.add(lblNewLabel_1);

		acNo = new JTextField();
		acNo.setFont(new Font("SansSerif", Font.PLAIN, 13));
		acNo.setBounds(30, 118, 216, 33);
		panel_1.add(acNo);
		acNo.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Amount:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 242, 134, 25);
		panel_1.add(lblNewLabel_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 66, 280, 9);
		panel_1.add(separator);

		JLabel lblNewLabel_3 = new JLabel("Customer ID :\r\n");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 162, 134, 25);
		panel_1.add(lblNewLabel_3);

		cusID = new JTextField();
		cusID.setFont(new Font("SansSerif", Font.PLAIN, 13));
		cusID.setBounds(30, 198, 216, 33);
		panel_1.add(cusID);
		cusID.setColumns(10);

		amount = new JTextField();
		amount.setFont(new Font("SansSerif", Font.PLAIN, 13));
		amount.setBounds(30, 278, 216, 33);
		panel_1.add(amount);
		amount.setColumns(10);

		JTextArea statement = new JTextArea();
		statement.setFont(new Font("Monospaced", Font.PLAIN, 14));
		statement.setEditable(false);
		statement.setLineWrap(true);
		statement.setBounds(522, 11, 333, 425);
		statement.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128),
				new Color(128, 128, 128), new Color(128, 128, 128)));
		panel.add(statement);

		JButton btnNewButton = new JButton("Transfer\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int AccNo = Integer.parseInt(acNo.getText());
				int cusId = Integer.parseInt(cusID.getText());
				int amountT = Integer.parseInt(amount.getText());

				// setting transaction time and date
				Date date = new Date();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd:HH:mm");
				String dateOfTransaction = df.format(date);

				try {

					Connection con = DB_Connection.getConnection();
					String sql = "select * from customer where AccNumber = ? and cusID = ?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setInt(1, AccNo);
					pst.setInt(2, cusId);
					ResultSet set = pst.executeQuery();
					if (set.next()) {
						String cusName = set.getString("AccName");
						String email = set.getString("emailID");
						String branch = set.getString("Branch");
						String sql2 = "SELECT balance from balance where AccNo = ?";
						PreparedStatement pst1 = con.prepareStatement(sql2);
						pst1.setInt(1, AccNo);
						ResultSet rset = pst1.executeQuery();
						if (rset.next()) {
							int money = rset.getInt("balance");
							int balance = money + amountT;
							String sql3 = "update balance set balance = ? where AccNo = ?";
							PreparedStatement pst2 = con.prepareStatement(sql3);
							pst2.setInt(1, balance);
							pst2.setInt(2, AccNo);
							int set2 = pst2.executeUpdate();
							if (set2 != 0) {
								JOptionPane.showMessageDialog(btnNewButton, "Amount deposit successfully");
								PreparedStatement pst3 = con.prepareStatement(sql2);
								pst3.setInt(1, AccNo);
								ResultSet rset1 = pst1.executeQuery();
								if (rset1.next()) {
									int bal = rset1.getInt("balance");
									int transaction = Integer.parseInt(PasswordGenerator.generateRandom(7));
									String client = "Bank Deposit";
									String method = "Cash";
									statement.setText("\n\t        NBSC Bank\n"
											+ " ***************************************\n Name: " + cusName
											+ "\n Ac No: " + AccNo + "   Branch: " + branch + "\n Cust ID: " + cusId
											+ "   Date: " + dateOfTransaction + ""
											+ "\n ***************************************\n Amount: " + amountT
											+ "   By: " + method + " \n Transaction ID: " + transaction + " \n Time: "
											+ dateOfTransaction + "\n\n Amount Successfully"
											+ " Credited to Account\n ***************************************\n\t        Thank you");

									// Resetting input field
									acNo.setText("");
									cusID.setText("");
									amount.setText("");

									Transaction.Deposit(AccNo, transaction, email, client, method, amountT,
											dateOfTransaction, bal);
								}
							}
						}
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Please enter correct details");
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton.setBounds(30, 346, 89, 33);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Reset\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acNo.setText("");
				cusID.setText("");
				amount.setText("");
			}
		});
		btnNewButton_1.setBackground(new Color(255, 215, 0));
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_1.setBounds(156, 346, 89, 33);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Print");
		btnNewButton_2.addActionListener(new ActionListener() {
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
		btnNewButton_2.setBackground(new Color(244, 164, 96));
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_2.setBounds(416, 40, 96, 31);
		panel.add(btnNewButton_2);
	}
}
