package Banking_Staff;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Banking_GUI.HomePage;
import Utilities.DB_Connection;
import beans.query_bean;
import beans.staff_bean;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Query_Details extends JFrame {

	private JPanel contentPane;
	private JTextField s_cID;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query_Details frame = new Query_Details();
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
	
	public ArrayList<query_bean> querylist(){
		ArrayList<query_bean> querylist = new ArrayList();
		try {
			int i = 0;
			Connection con = DB_Connection.getConnection();
			String query1 = "SELECT * FROM staffquery ";
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(query1);
			query_bean qbean;
			while(rs.next()) {
				qbean = new query_bean(rs.getInt("sr no"),rs.getInt("complaintID"),rs.getInt("StaffID"),rs.getString("StaffEmail"),
						rs.getString("StaffName"),rs.getString("StaffSubject"),rs.getString("StaffComplaint"),rs.getString("ComplaintStatus"),rs.getString("dateOfReg"));
				querylist.add(qbean);
				i++;
			}
			if (i == 0) {
				JOptionPane.showMessageDialog(contentPane, "No Record Found");
				setVisible(false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return querylist;
		
	}
	
	public void showUser() {
		ArrayList<query_bean> list = querylist();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[9];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getSr_no();
			row[1] = list.get(i).getComplaintID();
			row[2] = list.get(i).getStaffID();
			row[3] = list.get(i).getStaffEmail();
			row[4] = list.get(i).getStaffName();
			row[5] = list.get(i).getStaffSubject();
			row[6] = list.get(i).getStaffComplaint();
			row[7] = list.get(i).getStaffStatus();
			row[8] = list.get(i).getDateOfReg();
			
			model.addRow(row);

		}
	}
	
	public Query_Details() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\complaint_48px.png"));
		setAlwaysOnTop(true);
		setTitle("Complaint List");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1237, 621);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1221, 581);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Complaint Details", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 11, 337, 559);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Query Management");
		lblNewLabel.setForeground(new Color(0, 102, 255));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\customer_48px.png"));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 26, 301, 50);
		panel_1.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 79, 290, 10);
		panel_1.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Complaint ID:");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 90, 87, 26);
		panel_1.add(lblNewLabel_1);
		
		s_cID = new JTextField();
		s_cID.setBounds(32, 127, 171, 31);
		panel_1.add(s_cID);
		s_cID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Staff ID :");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 198, 67, 26);
		panel_1.add(lblNewLabel_3);
		
		JLabel stfID = new JLabel("");
		stfID.setForeground(new Color(255, 0, 0));
		stfID.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		stfID.setBounds(87, 198, 120, 26);
		panel_1.add(stfID);
		
		JLabel lblNewLabel_5 = new JLabel("Name :");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(10, 235, 67, 26);
		panel_1.add(lblNewLabel_5);
		
		JLabel name = new JLabel("");
		name.setForeground(new Color(255, 0, 0));
		name.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		name.setBounds(68, 235, 217, 26);
		panel_1.add(name);
		
		JLabel lblNewLabel_2 = new JLabel("Subject :");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 310, 67, 26);
		panel_1.add(lblNewLabel_2);
		
		JLabel subject = new JLabel("");
		subject.setForeground(new Color(255, 0, 0));
		subject.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		subject.setBounds(20, 336, 291, 26);
		panel_1.add(subject);
		
		JLabel lblNewLabel_6 = new JLabel("Complaint :");
		lblNewLabel_6.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(10, 373, 87, 26);
		panel_1.add(lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 403, 289, 96);
		panel_1.add(scrollPane);
		
		JTextArea complaint = new JTextArea();
		scrollPane.setViewportView(complaint);
		complaint.setEditable(false);
		complaint.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		complaint.setLineWrap(true);
		
		JLabel lblNewLabel_8 = new JLabel("Status :");
		lblNewLabel_8.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(10, 272, 60, 26);
		panel_1.add(lblNewLabel_8);
		
		JComboBox status = new JComboBox();
		status.setModel(new DefaultComboBoxModel(new String[] {"", "Active", "Complete"}));
		status.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		status.setBounds(78, 272, 106, 26);
		panel_1.add(status);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s_cID.setText("");
				stfID.setText("");
				name.setText("");
				status.setSelectedIndex(0);
				subject.setText("");
				complaint.setText("");
			}
		});
		btnNewButton_1.setBackground(new Color(102, 102, 102));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_1.setBounds(167, 510, 89, 30);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String StaffID = s_cID.getText();
				int stfid = Integer.parseInt(StaffID);
				String sts = status.getSelectedItem().toString();
				try {
					Connection con = DB_Connection.getConnection();
					String sql1 = "UPDATE staffquery SET ComplaintStatus = ? WHERE complaintID = ?";
					PreparedStatement pst = con.prepareStatement(sql1);
					pst.setString(1,sts);
					pst.setInt(2,stfid);
					int set = pst.executeUpdate();
					if (set != 0) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						showUser();
						JOptionPane.showMessageDialog(btnNewButton_1, "Staff query updated successfully",
								"Update Successfully", JOptionPane.INFORMATION_MESSAGE);
						
						s_cID.setText("");
						stfID.setText("");
						name.setText("");
						status.setSelectedIndex(0);
						subject.setText("");
						complaint.setText("");
					}
				}catch(Exception e2) {
					
				}
				
			}
		});
		btnNewButton_2.setBackground(new Color(102, 204, 102));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_2.setBounds(68, 510, 89, 30);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_7 = new JLabel("Complaint List");
		lblNewLabel_7.setForeground(new Color(0, 102, 255));
		lblNewLabel_7.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(357, 11, 189, 51);
		panel.add(lblNewLabel_7);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(357, 73, 832, 497);
		panel.add(scrollPane_1);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Sr no", "Complaint ID", "Staff ID", "Name", "Email ID", "Subject", "Complaint", "Status", "Date of Complaint"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setMinWidth(75);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(75);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setMinWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setMinWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		table.getColumnModel().getColumn(5).setMinWidth(200);
		table.getColumnModel().getColumn(6).setPreferredWidth(250);
		table.getColumnModel().getColumn(6).setMinWidth(250);
		table.getColumnModel().getColumn(7).setMinWidth(75);
		table.getColumnModel().getColumn(8).setPreferredWidth(125);
		table.getColumnModel().getColumn(8).setMinWidth(125);
		table.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		
		JButton btnNewButton_3 = new JButton("Refresh");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				showUser();
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(0, 204, 204));
		btnNewButton_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnNewButton_3.setBounds(1098, 26, 89, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cID = Integer.parseInt(s_cID.getText());
				
				try {
					Connection con = DB_Connection.getConnection();
					String sql = "SELECT * FROM staffquery WHERE complaintID = ?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setInt(1,cID);
					ResultSet set = pst.executeQuery();
					if(set.next()) {
						stfID.setText(String.valueOf(set.getInt("StaffID")));
						name.setText(set.getString("StaffName"));
						status.setSelectedItem(set.getString("complaintStatus"));
						subject.setText(set.getString("StaffSubject"));
						complaint.setText(set.getString("StaffComplaint"));
					}else {
						JOptionPane.showMessageDialog(btnNewButton, "Please enter valid complaint number");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 102, 255));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton.setBounds(212, 127, 87, 31);
		panel_1.add(btnNewButton);
		
		showUser();
	}
}
