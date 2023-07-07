package HomePage.user_service_request;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import Utilities.BankingMail;
import Utilities.DB_Connection;
import Utilities.PasswordGenerator;

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
import java.awt.event.ActionEvent;

public class PinChange extends JFrame {

	private JPanel contentPane;
	private JTextField card;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PinChange frame = new PinChange();
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
	public PinChange() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\password_reset_40px.png"));
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Pin Change");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 461, 588);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Pin Change Request");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 26));
		lblNewLabel.setBounds(95, 11, 242, 55);
		contentPane.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 64, 425, 14);
		contentPane.add(separator);

		JLabel lblNewLabel_1 = new JLabel("Customer Card No :");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 77, 136, 38);
		contentPane.add(lblNewLabel_1);

		card = new JTextField();
		card.setBounds(166, 81, 250, 29);
		contentPane.add(card);
		card.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 225, 425, 14);
		contentPane.add(separator_1);

		JRadioButton credit = new JRadioButton("Credit Card");
		credit.setBackground(new Color(255, 255, 255));
		credit.setFont(new Font("SansSerif", Font.PLAIN, 13));
		credit.setBounds(166, 124, 100, 29);
		contentPane.add(credit);

		JRadioButton debit = new JRadioButton("Debit Card");
		debit.setBackground(new Color(255, 255, 255));
		debit.setFont(new Font("SansSerif", Font.PLAIN, 13));
		debit.setBounds(268, 124, 89, 29);
		contentPane.add(debit);

		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(credit);
		bgroup.add(debit);

		JLabel lblNewLabel_2 = new JLabel("Card Type :");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(20, 126, 100, 29);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Name :");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(20, 293, 107, 29);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Card No :");
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(20, 333, 107, 29);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Expiry :");
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(20, 373, 107, 29);
		contentPane.add(lblNewLabel_5);

		JLabel name = new JLabel("");
		name.setForeground(new Color(255, 0, 0));
		name.setFont(new Font("SansSerif", Font.PLAIN, 13));
		name.setBounds(137, 293, 278, 29);
		contentPane.add(name);

		JLabel cardno = new JLabel("");
		cardno.setForeground(new Color(255, 0, 0));
		cardno.setFont(new Font("SansSerif", Font.PLAIN, 13));
		cardno.setBounds(138, 333, 278, 29);
		contentPane.add(cardno);

		JLabel expiry = new JLabel("");
		expiry.setForeground(new Color(255, 0, 0));
		expiry.setFont(new Font("SansSerif", Font.PLAIN, 13));
		expiry.setBounds(137, 373, 278, 29);
		contentPane.add(expiry);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 453, 425, 14);
		contentPane.add(separator_2);

		JLabel lblNewLabel_6 = new JLabel("Card Type :");
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(20, 413, 107, 29);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_8 = new JLabel("A/c No :");
		lblNewLabel_8.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(20, 253, 107, 29);
		contentPane.add(lblNewLabel_8);

		JLabel acNo = new JLabel("");
		acNo.setForeground(Color.RED);
		acNo.setFont(new Font("SansSerif", Font.PLAIN, 13));
		acNo.setBounds(137, 253, 278, 29);
		contentPane.add(acNo);

		JLabel cardType = new JLabel("");
		cardType.setForeground(Color.RED);
		cardType.setFont(new Font("SansSerif", Font.PLAIN, 13));
		cardType.setBounds(137, 413, 279, 29);
		contentPane.add(cardType);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cardNo = card.getText();

					// For Credit Card Section
					if (credit.isSelected()) {
						// creating connection
						Connection con = DB_Connection.getConnection();
						String sql = "SELECT * FROM credit_card where creditCardNo = ?";
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1, cardNo);
						ResultSet rs = pst.executeQuery();
						if (rs.next()) {
							int AccNumber = rs.getInt("accNo");
							String sql1 = "SELECT * FROM customer where AccNumber = ?";
							PreparedStatement pst1 = con.prepareStatement(sql1);
							pst1.setInt(1, AccNumber);
							ResultSet rs1 = pst1.executeQuery();
							if (rs1.next()) {
								acNo.setText(String.valueOf(AccNumber));
								name.setText(rs1.getString("AccName"));
								cardno.setText(rs.getString("creditCardNo"));
								expiry.setText(rs.getString("expiry"));
								cardType.setText("Credit Card");
							}
						} else {
							JOptionPane.showMessageDialog(contentPane, "No Result Found");
						}

						// For Debit Card Section
					} else if (debit.isSelected()) {
						// creating connection
						Connection con = DB_Connection.getConnection();
						String sql = "SELECT * FROM debitcard where CardNo = ?";
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1, cardNo);
						ResultSet rs = pst.executeQuery();
						if (rs.next()) {
							int AccNumber = rs.getInt("AccNumber");
							String sql1 = "SELECT * FROM customer where AccNumber = ?";
							PreparedStatement pst1 = con.prepareStatement(sql1);
							pst1.setInt(1, AccNumber);
							ResultSet rs1 = pst1.executeQuery();
							if (rs1.next()) {
								acNo.setText(String.valueOf(AccNumber));
								name.setText(rs1.getString("AccName"));
								cardno.setText(rs.getString("creditCardNo"));
								expiry.setText(rs.getString("expiry"));
								cardType.setText("Debit Card");
							}
						} else {
							JOptionPane.showMessageDialog(contentPane, "No Result Found");
						}

						// IF Nothing selected
					} else {
						JOptionPane.showMessageDialog(contentPane, "Please select card type");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton.setBackground(new Color(0, 153, 51));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(177, 178, 89, 29);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int accNo = Integer.parseInt(acNo.getText());
					String Name = name.getText();
					String cardNum = cardno.getText();
					String cardtype = cardType.getText();

					if (cardtype == "Credit Card") {
						// For Credit card
						try {
							Connection con = DB_Connection.getConnection();
							String sql = "select * from customer where AccNumber = ?";
							PreparedStatement pst = con.prepareStatement(sql);
							pst.setInt(1, accNo);
							ResultSet set = pst.executeQuery();
							if (set.next()) {
								String email = set.getString("emailID");
								int pin = Integer.parseInt(PasswordGenerator.generateRandom(3));

								String sql1 = "update credit_card set pin = ? where creditCardNo = ? and accNo = ?";
								PreparedStatement pst1 = con.prepareStatement(sql1);
								pst1.setInt(1, pin);
								pst1.setString(2, cardNum);
								pst1.setInt(3, accNo);
								int set1 = pst1.executeUpdate();
								if (set1 != 0) {
									JOptionPane.showMessageDialog(contentPane,
											"New Pin sent successfully to customer mail");
									BankingMail.PinChange(email, Name, cardtype, accNo, cardNum, pin);
									setVisible(false);

								} else {
									JOptionPane.showMessageDialog(contentPane, "Failed");
								}

							}

						} catch (NumberFormatException nfe) {
							JOptionPane.showMessageDialog(contentPane, "Please enter card no");
						} catch (Exception e2) {
							e2.printStackTrace();
						}

					} else if (cardtype == "Debit Card") {
						// For Debit Card
						try {
							Connection con = DB_Connection.getConnection();
							String sql = "select * from customer where AccNumber = ?";
							PreparedStatement pst = con.prepareStatement(sql);
							pst.setInt(1, accNo);
							ResultSet set = pst.executeQuery();
							if (set.next()) {
								String email = set.getString("emailID");
								int pin = Integer.parseInt(PasswordGenerator.generateRandom(3));

								String sql1 = "update debitcard set Pin = ? where CardNo = ? and AccNumber = ?";
								PreparedStatement pst1 = con.prepareStatement(sql1);
								pst1.setInt(1, pin);
								pst1.setString(2, cardNum);
								pst1.setInt(3, accNo);
								int set1 = pst1.executeUpdate();
								if (set1 != 0) {
									JOptionPane.showMessageDialog(contentPane,
											"New Pin sent successfully to customer mail");
									BankingMail.PinChange(email, Name, cardtype, accNo, cardNum, pin);
									setVisible(false);
								} else {
									JOptionPane.showMessageDialog(contentPane, "Failed");
								}

							}

						} catch (NumberFormatException nfe) {
							JOptionPane.showMessageDialog(contentPane, "Please enter card no");
						} catch (Exception e2) {
							e2.printStackTrace();
						}

					} else {
						JOptionPane.showMessageDialog(contentPane, "Something went wrong");
					}
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(contentPane, "Please enter card no");
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 102, 255));
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_1.setBounds(177, 495, 89, 29);
		contentPane.add(btnNewButton_1);

		JLabel label = new JLabel("New label");
		label.setBounds(20, 268, 74, -12);
		contentPane.add(label);

	}
}
