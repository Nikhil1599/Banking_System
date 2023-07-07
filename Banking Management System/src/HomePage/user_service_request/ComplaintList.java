package HomePage.user_service_request;

import Utilities.DB_Connection;
import beans.cusQuery_bean;
import beans.query_bean;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ComplaintList extends JFrame {

	private JPanel contentPane;
	private JTextField compid;
	private JTable table;
	int complaintID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComplaintList frame = new ComplaintList();
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
	
	public ArrayList<cusQuery_bean> querylist(){
		ArrayList<cusQuery_bean> querylist = new ArrayList();
		try {
			int i = 0;
			Connection con = DB_Connection.getConnection();
			String query1 = "SELECT * FROM usercomplaint";
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(query1);
			cusQuery_bean qbean;
			while(rs.next()) {
				qbean = new cusQuery_bean(rs.getInt("ComplaintID"),rs.getInt("AcNumber"),rs.getString("AcName"),rs.getString("Status"),
						rs.getString("Subject"),rs.getString("Complaint"),rs.getString("dateOfComplaint"));
				querylist.add(qbean);
				i++;
			}
			if (i == 0) {
				JOptionPane.showMessageDialog(null, "No Record Found");
				setVisible(false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return querylist;
	}
	
	public void showUser() {
		ArrayList<cusQuery_bean> list = querylist();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[7];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getComplaintId();
			row[1] = list.get(i).getAcNumber();
			row[2] = list.get(i).getName();
			row[3] = list.get(i).getStatus();
			row[4] = list.get(i).getSubject();
			row[5] = list.get(i).getComplaint();
			row[6] = list.get(i).getDateofjoin();
			
			model.addRow(row);

		}
	}
	
	public ComplaintList() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\bulleted_list_48px.png"));
		setTitle("Complaint Data");
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1269, 670);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Complaint Details", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(20, 24, 334, 590);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Query");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\technical_support_40px.png"));
		lblNewLabel.setForeground(new Color(0, 51, 255));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 22, 295, 43);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 73, 314, 14);
		panel.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Complaint ID :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(13, 85, 117, 26);
		panel.add(lblNewLabel_1);
		
		compid = new JTextField();
		compid.setBounds(23, 110, 196, 31);
		panel.add(compid);
		compid.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 155, 314, 14);
		panel.add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("A/c No :");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(20, 180, 71, 31);
		panel.add(lblNewLabel_2);
		
		JLabel acNo = new JLabel("");
		acNo.setForeground(new Color(255, 0, 0));
		acNo.setFont(new Font("SansSerif", Font.PLAIN, 13));
		acNo.setBounds(101, 179, 223, 31);
		panel.add(acNo);
		
		JLabel name1 = new JLabel("Name :");
		name1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		name1.setBounds(20, 222, 71, 26);
		panel.add(name1);
		
		JLabel name = new JLabel("");
		name.setForeground(new Color(255, 0, 0));
		name.setFont(new Font("SansSerif", Font.PLAIN, 13));
		name.setBounds(101, 219, 223, 31);
		panel.add(name);
		
		JLabel lblNewLabel_3 = new JLabel("Status :");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(20, 262, 71, 26);
		panel.add(lblNewLabel_3);
		
		JComboBox status = new JComboBox();
		status.setFont(new Font("SansSerif", Font.PLAIN, 12));
		status.setModel(new DefaultComboBoxModel(new String[] {"", "Active", "Completed"}));
		status.setBounds(101, 261, 175, 27);
		panel.add(status);
		
		JLabel lblNewLabel_4 = new JLabel("Subject :");
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(20, 299, 71, 26);
		panel.add(lblNewLabel_4);
		
		JLabel subject = new JLabel("");
		subject.setForeground(new Color(255, 0, 0));
		subject.setFont(new Font("SansSerif", Font.PLAIN, 13));
		subject.setBounds(23, 325, 294, 26);
		panel.add(subject);
		
		JLabel lblNewLabel_5 = new JLabel("Complaint :");
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(20, 372, 89, 31);
		panel.add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 396, 295, 104);
		panel.add(scrollPane);
		
		JTextArea complaint = new JTextArea();
		complaint.setEditable(false);
		complaint.setWrapStyleWord(true);
		complaint.setLineWrap(true);
		complaint.setFont(new Font("SansSerif", Font.PLAIN, 13));
		scrollPane.setViewportView(complaint);
		
		
		
		JLabel lblNewLabel_6 = new JLabel("Complaint List");
		lblNewLabel_6.setForeground(new Color(0, 51, 255));
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(364, 31, 268, 40);
		contentPane.add(lblNewLabel_6);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(364, 70, 862, 544);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Complaint ID", "Customer A/c No", "Name", "Status", "Subject", "Complaint", "Complaint Date"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setMinWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setMinWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setMinWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setMinWidth(200);
		table.getColumnModel().getColumn(5).setPreferredWidth(300);
		table.getColumnModel().getColumn(5).setMinWidth(300);
		table.getColumnModel().getColumn(6).setPreferredWidth(120);
		table.getColumnModel().getColumn(6).setMinWidth(120);
		scrollPane_1.setViewportView(table);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int compId = Integer.parseInt(compid.getText());
					Connection con = DB_Connection.getConnection();
					String sql = "select * from usercomplaint where ComplaintID = ?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setInt(1,compId);
					ResultSet set = pst.executeQuery();
					if(set.next()) {
						complaintID = set.getInt("ComplaintID");
						acNo.setText(String.valueOf(set.getInt("AcNumber")));
						name.setText(set.getString("AcName"));
						subject.setText(set.getString("Subject"));
						complaint.setText(set.getString("Complaint"));
						status.setSelectedItem(set.getString("Status"));
						
					}else {
						JOptionPane.showMessageDialog(contentPane,"No Result Found");
					}
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(contentPane,"Please enter Complaint ID");
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 204, 102));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton.setBounds(229, 109, 89, 30);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sts = String.valueOf(status.getSelectedItem());
					Connection con = DB_Connection.getConnection();
					String sql = "update usercomplaint set Status = ? where ComplaintID = ?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,sts);
					pst.setInt(2,complaintID);
					int set = pst.executeUpdate();
					if(set != 0) {
						JOptionPane.showMessageDialog(contentPane,"Complaint Updated");
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						showUser();
					}else{
						JOptionPane.showMessageDialog(contentPane,"Something went wrong");
					}
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(contentPane,"Please enter Complaint ID");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_1.setBounds(67, 527, 89, 31);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compid.setText("");
				acNo.setText("");
				name.setText("");
				status.setSelectedIndex(0);
				subject.setText("");
				complaint.setText("");
			}
		});
		btnNewButton_2.setBackground(new Color(169, 169, 169));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_2.setBounds(173, 527, 89, 31);
		panel.add(btnNewButton_2);
		
		showUser();
		
	}
}
