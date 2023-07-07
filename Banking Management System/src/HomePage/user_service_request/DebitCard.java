package HomePage.user_service_request;

import Utilities.AccountService;
import Utilities.DB_Connection;
import Utilities.PasswordGenerator;
import beans.chequeBean;
import beans.debitBean;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
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

public class DebitCard extends JFrame {

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
					DebitCard frame = new DebitCard();
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

	public ArrayList<debitBean> debitList() {
		ArrayList<debitBean> debitlist = new ArrayList();
		try {
			int i = 0;
			Connection con = DB_Connection.getConnection();
			String query1 = "SELECT * FROM debitcard";
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(query1);
			debitBean qbean;
			while (rs.next()) {
				qbean = new debitBean(rs.getInt("CusID"), rs.getInt("AccNumber"), rs.getString("AccName"),
						rs.getString("CardNo"), rs.getString("Validity"), rs.getString("CVV"),
						rs.getString("DateOfJoining"));
				debitlist.add(qbean);
				i++;
			}
			if (i == 0) {
				JOptionPane.showMessageDialog(null, "No Record Found");
				setVisible(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return debitlist;
	}

	public void showUser() {
		ArrayList<debitBean> list = debitList();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[7];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getCusID();
			row[1] = list.get(i).getAccNumber();
			row[2] = list.get(i).getAccName();
			row[3] = list.get(i).getCardNo();
			row[4] = list.get(i).getValidity();
			row[5] = list.get(i).getCvv();
			row[6] = list.get(i).getDateOfJoining();
			
			model.addRow(row);

		}
	}
	
	public DebitCard() {
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\money_40px.png"));
		setTitle("Debit Card Portal");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1238, 642);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"New Application", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(10, 23, 356, 553);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Issue Debit Card");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 23, 336, 46);
		panel.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 67, 336, 8);
		panel.add(separator);

		JLabel lblNewLabel_1 = new JLabel("Customer A/c No :");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 80, 131, 24);
		panel.add(lblNewLabel_1);

		AccNo = new JTextField();
		AccNo.setBounds(10, 101, 231, 30);
		panel.add(AccNo);
		AccNo.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 142, 336, 8);
		panel.add(separator_1);

		JLabel lblNewLabel_2 = new JLabel("A/c No :");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 161, 80, 30);
		panel.add(lblNewLabel_2);

		JLabel acNo = new JLabel("");
		acNo.setForeground(new Color(255, 0, 0));
		acNo.setFont(new Font("SansSerif", Font.PLAIN, 13));
		acNo.setBounds(100, 160, 231, 30);
		panel.add(acNo);

		JLabel lblNewLabel_4 = new JLabel("Name :");
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 202, 80, 30);
		panel.add(lblNewLabel_4);

		JLabel name = new JLabel("");
		name.setForeground(new Color(255, 0, 0));
		name.setFont(new Font("SansSerif", Font.PLAIN, 13));
		name.setBounds(100, 201, 231, 30);
		panel.add(name);

		JLabel lblNewLabel_3 = new JLabel("Customer ID :");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 243, 80, 30);
		panel.add(lblNewLabel_3);

		JLabel cusID = new JLabel("");
		cusID.setForeground(new Color(255, 0, 0));
		cusID.setFont(new Font("SansSerif", Font.PLAIN, 13));
		cusID.setBounds(100, 242, 231, 30);
		panel.add(cusID);

		JLabel lblNewLabel_5 = new JLabel("Email Id :");
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 284, 80, 30);
		panel.add(lblNewLabel_5);

		JLabel email = new JLabel("");
		email.setForeground(new Color(255, 0, 0));
		email.setFont(new Font("SansSerif", Font.PLAIN, 13));
		email.setBounds(100, 283, 231, 30);
		panel.add(email);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 338, 336, 8);
		panel.add(separator_2);

		JButton btnNewButton_1 = new JButton("Order");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int AccNumber = Integer.parseInt(acNo.getText());
					int CusID = Integer.parseInt(cusID.getText());
					String Name = name.getText();
					String Email = email.getText();
					int cvv = Integer.parseInt(PasswordGenerator.generateRandom(2));
					int pin = Integer.parseInt(PasswordGenerator.generateRandom(3));
					Date date = new Date();
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					String dateOfjoin = df.format(date);

					AccountService.DebitCard(AccNumber, CusID, Name, dateOfjoin, Email, cvv, pin);
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

				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(contentPane, "Please enter A/c No");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_1.setBounds(73, 400, 89, 30);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acNo.setText("");
				name.setText("");
				email.setText("");
				cusID.setText("");
				AccNo.setText("");
			}
		});
		btnNewButton_2.setBackground(new Color(169, 169, 169));
		btnNewButton_2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(190, 400, 89, 30);
		panel.add(btnNewButton_2);

		JLabel lblNewLabel_6 = new JLabel("Customer Details");
		lblNewLabel_6.setForeground(new Color(0, 0, 255));
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		lblNewLabel_6.setBounds(376, 11, 282, 56);
		contentPane.add(lblNewLabel_6);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(376, 67, 825, 509);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Customer ID", "A/c No", "Name", "Card No", "Validity", "CVV", "Date of Joining" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, true, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(0).setMinWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setMinWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setMinWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setMinWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(120);
		table.getColumnModel().getColumn(6).setMinWidth(120);
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int AccNumber = Integer.parseInt(AccNo.getText());

					Connection con = DB_Connection.getConnection();
					String sql = "SELECT * FROM customer where AccNumber = ?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setInt(1, AccNumber);
					ResultSet set = pst.executeQuery();
					if (set.next()) {
						cusID.setText(String.valueOf(set.getInt("cusID")));
						acNo.setText(String.valueOf(set.getInt("AccNumber")));
						name.setText(set.getString("AccName"));
						email.setText(set.getString("emailID"));
					} else {
						JOptionPane.showMessageDialog(contentPane, "No Result Found");
					}

				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(contentPane, "Please enter A/c No");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 204, 102));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton.setBounds(251, 101, 89, 30);
		panel.add(btnNewButton);
		
	    showUser();
		
	}
}
