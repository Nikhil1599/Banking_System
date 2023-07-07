package HomePage.user_service_transaction;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Utilities.DB_Connection;
import beans.transaction_bean;

import javax.swing.JScrollPane;

public class AccStatement extends JFrame {

	private JPanel contentPane;
	private JTextField account;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccStatement frame = new AccStatement();
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
		PreparedStatement st;
		try {
			int i = 0;
			Connection con = DB_Connection.getConnection();
			if (account == 0) {
				String sql = "SELECT * FROM transactions";
				st = con.prepareStatement(sql);
			} else {
				String sql = "SELECT * FROM transactions where AccNo = ?";
				st = con.prepareStatement(sql);
				st.setInt(1, account);
			}
			ResultSet set = st.executeQuery();
			transaction_bean tbean;
				while (set.next()) {
					tbean = new transaction_bean(set.getInt("AccNo"), set.getInt("TransactionID"), set.getInt("Amount"),
							set.getString("Status"), set.getString("Mode"), set.getString("Method"),
							set.getString("dateOfTransaction"), set.getString("client"));
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
		Object[] row = new Object[8];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getAccNo();
			row[1] = list.get(i).getTransactionID();
			row[2] = list.get(i).getStatus();
			row[3] = list.get(i).getAmount();
			row[4] = list.get(i).getMode();
			row[5] = list.get(i).getMethod();
			row[6] = list.get(i).getClient();
			row[7] = list.get(i).getDateOfTransaction();
			model.addRow(row);
		}
	}

	public AccStatement() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\receipt_64px.png"));
		setResizable(false);
		setTitle("TRANSACTION STATEMENT");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1134, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1118, 605);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("A/c No :");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 65, 28);
		panel.add(lblNewLabel);

		account = new JTextField();
		account.setBounds(86, 11, 206, 27);
		panel.add(account);
		account.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Transaction Statement", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 50, 1098, 544);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 27, 1078, 506);
		panel_1.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Account No", "Transaction ID", "Status", "Amount", "Mode", "Method", "Client", "Date of Transaction"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(0).setMinWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setMinWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setMinWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setMinWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setMinWidth(120);
		table.getColumnModel().getColumn(6).setPreferredWidth(130);
		table.getColumnModel().getColumn(6).setMinWidth(130);
		table.getColumnModel().getColumn(7).setPreferredWidth(130);
		table.getColumnModel().getColumn(7).setMinWidth(130);
		table.setFont(new Font("SanSerif", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int acc = Integer.parseInt(account.getText());
					
					//clearing table and fetching new data from database
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					showUser(acc);
					
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(table, "Please enter A/c No");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(51, 102, 255));
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		btnNewButton.setBounds(302, 11, 89, 26);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.setBackground(new Color(0, 204, 102));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {
		try {
			table.print();
		} catch (PrinterException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
});btnNewButton_1.setBounds(1008,13,89,28);panel.add(btnNewButton_1);
JButton Clear = new JButton("Clear");
Clear.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		//clearing table and fetching new data from database
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		showUser(0);
	}
});
Clear.setForeground(new Color(255, 255, 255));
Clear.setBackground(new Color(153, 153, 153));
Clear.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
Clear.setBounds(911, 13, 89, 28);
panel.add(Clear);

showUser(0);}}
