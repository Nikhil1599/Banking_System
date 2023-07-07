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

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class CheckBalance extends JFrame {

	private JPanel contentPane;
	private JTextField account;
	private JTextField cusID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBalance frame = new CheckBalance();
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
	public CheckBalance() {
		setTitle("Customer Balance");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\finance.png"));
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 880, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 864, 447);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 248, 220));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(21, 11, 285, 410);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHECK BALANCE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\euro_money_40px.png"));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 11, 265, 54);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("A/C No:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 98, 106, 32);
		panel_1.add(lblNewLabel_1);
		
		account = new JTextField();
		account.setBounds(20, 141, 230, 32);
		panel_1.add(account);
		account.setColumns(10);
		
		JLabel cust = new JLabel("Customer ID:");
		cust.setFont(new Font("Arial", Font.PLAIN, 15));
		cust.setBounds(10, 193, 106, 32);
		panel_1.add(cust);
		
		cusID = new JTextField();
		cusID.setBounds(20, 236, 230, 32);
		panel_1.add(cusID);
		cusID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Name: ");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(327, 90, 71, 37);
		panel.add(lblNewLabel_3);
		
		JLabel name = new JLabel("");
		name.setForeground(Color.RED);
		name.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		name.setBounds(408, 90, 275, 37);
		panel.add(name);
		
		JLabel lblNewLabel_5 = new JLabel("A/c No:");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(327, 147, 71, 37);
		panel.add(lblNewLabel_5);
		
		JLabel accNo = new JLabel("");
		accNo.setForeground(Color.RED);
		accNo.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		accNo.setBounds(408, 148, 275, 36);
		panel.add(accNo);
		
		JLabel lblNewLabel_7 = new JLabel("Branch:");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(326, 205, 72, 37);
		panel.add(lblNewLabel_7);
		
		JLabel branch = new JLabel("");
		branch.setForeground(Color.RED);
		branch.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		branch.setBounds(408, 205, 275, 37);
		panel.add(branch);
		
		JLabel lblNewLabel_9 = new JLabel("Balance:");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_9.setBounds(324, 267, 74, 37);
		panel.add(lblNewLabel_9);
		
		JLabel balance = new JLabel("");
		balance.setForeground(Color.RED);
		balance.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		balance.setBounds(408, 267, 285, 36);
		panel.add(balance);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int AccNo = Integer.parseInt(account.getText());
				int CusID = Integer.parseInt(cusID.getText());
				
				try {
					Connection con = DB_Connection.getConnection();
					String sql = "select * from customer where AccNumber = ? and cusID = ?";
					String sql1 = "select * from balance where AccNo = ?";
					PreparedStatement pst1 = con.prepareStatement(sql);
					PreparedStatement pst2 = con.prepareStatement(sql1);
					pst1.setInt(1,AccNo);
					pst1.setInt(2,CusID);
					pst2.setInt(1,AccNo);
					ResultSet set1 = pst1.executeQuery();
					ResultSet set2 = pst2.executeQuery();
					if(set1.next()) {
						if(set2.next()) {
							name.setText(set1.getString("AccName"));
							accNo.setText(set1.getString("AccNumber"));
							branch.setText(set1.getString("Branch"));
							balance.setText(String.valueOf(set2.getInt("balance")));
						}
					}else {
						JOptionPane.showMessageDialog(btnNewButton, "Please enter correct details");
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		btnNewButton.setBackground(new Color(51, 204, 102));
		btnNewButton.setBounds(87, 310, 89, 32);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Account Details");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\customer_48px.png"));
		lblNewLabel_2.setForeground(new Color(255, 153, 0));
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(316, 11, 262, 57);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText("");
				accNo.setText("");
				branch.setText("");
				balance.setText("");
			}
		});
		btnNewButton_1.setBackground(new Color(153, 153, 153));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		btnNewButton_1.setBounds(518, 341, 89, 30);
		panel.add(btnNewButton_1);
	}
}
