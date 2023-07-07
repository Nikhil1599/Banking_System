package HomePage.user_service_request;

import Utilities.BankingMail;
import Utilities.DB_Connection;
import Utilities.PasswordGenerator;
import beans.chequeBean;
import beans.cusQuery_bean;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class ChequeRequest extends JFrame {

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
					ChequeRequest frame = new ChequeRequest();
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

	public ArrayList<chequeBean> chequeList() {
		ArrayList<chequeBean> chequeList = new ArrayList();
		try {
			int i = 0;
			Connection con = DB_Connection.getConnection();
			String query1 = "SELECT * FROM chequebook";
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(query1);
			chequeBean qbean;
			while (rs.next()) {
				qbean = new chequeBean(rs.getInt("AccNo"), rs.getInt("ChequeNo"), rs.getInt("chqLeaf"),
							rs.getString("chequeStatus"), rs.getString("dateOfJoining"));
				chequeList.add(qbean);
				i++;
			}
			if (i == 0) {
				JOptionPane.showMessageDialog(null, "No Record Found");
				setVisible(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return chequeList;
	}
	
	public void showUser() {
		ArrayList<chequeBean> list = chequeList();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[5];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getAcNo();
			row[1] = list.get(i).getChequeNo();
			row[2] = list.get(i).getStatus();
			row[3] = list.get(i).getLeaf();
			row[4] = list.get(i).getDateOfOrder();
			
			model.addRow(row);

		}
	}

	public ChequeRequest() {
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\paycheque_40px.png"));
		setTitle("Cheque Book");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1223, 621);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Cheque Request", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 333, 557);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Request Cheque Leaf");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\paycheque_40px.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 26, 271, 45);
		panel.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 67, 313, 7);
		panel.add(separator);

		JLabel lblNewLabel_1 = new JLabel("Customer A/c No :");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 76, 123, 29);
		panel.add(lblNewLabel_1);

		AccNo = new JTextField();
		AccNo.setBounds(10, 101, 214, 29);
		panel.add(AccNo);
		AccNo.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 146, 313, 2);
		panel.add(separator_1);

		JLabel lblNewLabel_2 = new JLabel("A/c No :");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 159, 83, 29);
		panel.add(lblNewLabel_2);

		JLabel acNo = new JLabel("");
		acNo.setForeground(new Color(255, 0, 0));
		acNo.setFont(new Font("SansSerif", Font.PLAIN, 13));
		acNo.setBounds(103, 158, 220, 29);
		panel.add(acNo);

		JLabel lblNewLabel_4 = new JLabel("Name :");
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 199, 83, 29);
		panel.add(lblNewLabel_4);

		JLabel name = new JLabel("");
		name.setForeground(new Color(255, 0, 0));
		name.setFont(new Font("SansSerif", Font.PLAIN, 13));
		name.setBounds(103, 199, 220, 29);
		panel.add(name);

		JLabel lblNewLabel_3 = new JLabel("A/c Type :");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 239, 83, 29);
		panel.add(lblNewLabel_3);

		JLabel accType = new JLabel("");
		accType.setForeground(new Color(255, 0, 0));
		accType.setFont(new Font("SansSerif", Font.PLAIN, 13));
		accType.setBounds(103, 239, 220, 29);
		panel.add(accType);

		JLabel lblNewLabel_5 = new JLabel("Branch :");
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 279, 83, 29);
		panel.add(lblNewLabel_5);

		JLabel branch = new JLabel("");
		branch.setForeground(new Color(255, 0, 0));
		branch.setFont(new Font("SansSerif", Font.PLAIN, 13));
		branch.setBounds(103, 279, 220, 29);
		panel.add(branch);

		JLabel lblNewLabel_6 = new JLabel("No. of Leaf :");
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 319, 83, 29);
		panel.add(lblNewLabel_6);

		JComboBox leaf = new JComboBox();
		leaf.setFont(new Font("SansSerif", Font.PLAIN, 13));
		leaf.setModel(new DefaultComboBoxModel(new String[] { "", "35", "75" }));
		leaf.setBounds(103, 318, 203, 29);
		panel.add(leaf);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 370, 313, 7);
		panel.add(separator_2);

		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Reseting label
				AccNo.setText("");
				acNo.setText("");
				name.setText("");
				accType.setText("");
				branch.setText("");
				leaf.setSelectedIndex(0);
			}
		});
		btnNewButton_2.setBackground(new Color(153, 153, 153));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton_2.setBounds(169, 431, 89, 29);
		panel.add(btnNewButton_2);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int accNo = Integer.parseInt(AccNo.getText());

					Connection con = DB_Connection.getConnection();
					String sql = "SELECT * FROM customer where AccNumber = ?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setInt(1, accNo);
					ResultSet set = pst.executeQuery();
					if (set.next()) {
						acNo.setText(String.valueOf(set.getInt("AccNumber")));
						name.setText(set.getString("AccName"));
						accType.setText(set.getString("AccType"));
						branch.setText(set.getString("Branch"));
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
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton.setBounds(234, 100, 89, 29);
		panel.add(btnNewButton);

		JLabel lblNewLabel_7 = new JLabel("Data Table");
		lblNewLabel_7.setForeground(new Color(0, 51, 255));
		lblNewLabel_7.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(353, 11, 349, 56);
		contentPane.add(lblNewLabel_7);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(353, 78, 842, 484);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Customer A/c No", "Cheque No", "Status", "Cheque Leaf", "Order Date" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setMinWidth(120);
		table.getColumnModel().getColumn(1).setMinWidth(120);
		table.getColumnModel().getColumn(2).setMinWidth(120);
		table.getColumnModel().getColumn(3).setMinWidth(120);
		table.getColumnModel().getColumn(4).setMinWidth(120);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Order");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int AccNumber = Integer.parseInt(acNo.getText());
					int chequeNo = Integer.parseInt(PasswordGenerator.generateRandom(7));
					Date date = new Date();
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					String dateOfjoin = df.format(date);
					int chequeLeaf = Integer.parseInt((String) leaf.getSelectedItem());

					if (leaf.getSelectedIndex() != 0) {

						Connection con = DB_Connection.getConnection();
						String sql = "select * from customer where AccNumber = ?";
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setInt(1, AccNumber);
						ResultSet st = pst.executeQuery();
						if (st.next()) {
							String email = st.getString("emailID");

							String sql1 = "insert into chequebook (AccNo,ChequeNo,chqLeaf,dateOfjoining) values (?,?,?,?)";
							PreparedStatement pst1 = con.prepareStatement(sql1);
							pst1.setInt(1, AccNumber);
							pst1.setInt(2, chequeNo);
							pst1.setInt(3, chequeLeaf);
							pst1.setString(4, dateOfjoin);
							int set = pst1.executeUpdate();
							if (set != 0) {
								JOptionPane.showMessageDialog(contentPane, "Order Confirmed");
								DefaultTableModel model = (DefaultTableModel) table.getModel();
								model.setRowCount(0);
								showUser();
								BankingMail.chequeBook(email, chequeNo, AccNumber);

								// Reseting label
								AccNo.setText("");
								acNo.setText("");
								name.setText("");
								accType.setText("");
								branch.setText("");
								leaf.setSelectedIndex(0);

							} else {
								JOptionPane.showMessageDialog(contentPane, "Something went wrong");
							}
						}
					} else {
						JOptionPane.showMessageDialog(contentPane, "Please select No. of Leaf");
					}

				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(contentPane, "Please enter A/c No and No. of Leaf");
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton_1.setBounds(57, 431, 89, 29);
		panel.add(btnNewButton_1);
		
		showUser();

	}
}
