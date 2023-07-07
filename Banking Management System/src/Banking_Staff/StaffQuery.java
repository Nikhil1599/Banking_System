package Banking_Staff;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import Utilities.BankingMail;
import Utilities.DB_Connection;
import Utilities.PasswordGenerator;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class StaffQuery extends JFrame {

	private JPanel contentPane;
	private JTextField stf_id;
	private JTextField subject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffQuery frame = new StaffQuery();
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
	public StaffQuery() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\complaint_48px.png"));
		setTitle("Staff Query Portal");
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 769, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 753, 644);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("STAFF COMPLAINT");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\customer_48px.png"));
		lblNewLabel.setForeground(new Color(0, 102, 255));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 34));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 733, 65);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Staff ID:");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel_1.setBounds(186, 87, 84, 32);
		panel.add(lblNewLabel_1);

		stf_id = new JTextField();
		stf_id.setFont(new Font("SansSerif", Font.PLAIN, 14));
		stf_id.setBounds(280, 89, 182, 32);
		panel.add(stf_id);
		stf_id.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"STAFF DETAILS", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
		panel_1.setBounds(128, 141, 492, 147);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Name :");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_2.setBounds(20, 62, 55, 28);
		panel_1.add(lblNewLabel_2);

		JLabel st_name = new JLabel("");
		st_name.setForeground(Color.RED);
		st_name.setFont(new Font("SansSerif", Font.PLAIN, 15));
		st_name.setBounds(133, 62, 223, 27);
		panel_1.add(st_name);

		JLabel lblNewLabel_4 = new JLabel("Email ID:");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_4.setBounds(20, 100, 66, 28);
		panel_1.add(lblNewLabel_4);

		JLabel st_email = new JLabel("");
		st_email.setForeground(Color.RED);
		st_email.setFont(new Font("SansSerif", Font.PLAIN, 15));
		st_email.setBounds(133, 100, 277, 28);
		panel_1.add(st_email);

		JLabel lblNewLabel_3 = new JLabel("Staff ID: ");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_3.setBounds(20, 23, 66, 28);
		panel_1.add(lblNewLabel_3);

		JLabel st_id = new JLabel("");
		st_id.setForeground(Color.RED);
		st_id.setFont(new Font("SansSerif", Font.PLAIN, 15));
		st_id.setBounds(133, 23, 132, 28);
		panel_1.add(st_id);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				try {
					
					int StaffID = Integer.parseInt(stf_id.getText());
					Connection con = DB_Connection.getConnection();
					String sql = "SELECT staff_id, staff_name, staff_email from Bank_Staff WHERE staff_id = ? ";
					PreparedStatement st = con.prepareStatement(sql);
					st.setInt(1, StaffID);
					ResultSet set = st.executeQuery();
					if (set.next()) {
						int sId = set.getInt(1);
						st_id.setText(String.valueOf(sId));
						st_name.setText(set.getString(2));
						st_email.setText(set.getString(3));
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Staff not found, please enter correct staff id",
								"Failed to load", JOptionPane.OK_OPTION);
					}
				}catch(NumberFormatException efx) {
					JOptionPane.showMessageDialog(btnNewButton, "Please enter staff id");
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 153, 204));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(472, 90, 89, 32);
		panel.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"REGISTER COMPLAINT", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(71, 299, 605, 235);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("SUBJECT: ");
		lblNewLabel_5.setForeground(new Color(0, 102, 255));
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(20, 32, 92, 31);
		panel_2.add(lblNewLabel_5);

		subject = new JTextField();
		subject.setFont(new Font("SansSerif", Font.PLAIN, 13));
		subject.setBounds(133, 33, 369, 30);
		panel_2.add(subject);
		subject.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("COMPLAINT:");
		lblNewLabel_6.setForeground(new Color(0, 102, 255));
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(20, 84, 92, 31);
		panel_2.add(lblNewLabel_6);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(133, 86, 369, 126);
		panel_2.add(scrollPane);

		JTextArea complaint = new JTextArea();
		complaint.setFont(new Font("SansSerif", Font.PLAIN, 13));
		scrollPane.setViewportView(complaint);
		complaint.setLineWrap(true);

		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String compID = PasswordGenerator.generateComplaintID(5);
					int cID = Integer.parseInt(compID);
					int std_id = Integer.parseInt(st_id.getText());
					String name = st_name.getText();
					String email = st_email.getText();
					String sub = subject.getText();
					String comp = complaint.getText();
					String status = "Active";
					Date dt = new Date();
					String dateOfReg = DateFormat.getDateInstance().format(dt);
					Connection con = DB_Connection.getConnection();
					String sql = "INSERT INTO staffquery (complaintID,StaffID,StaffName,StaffEmail,StaffSubject,StaffComplaint,ComplaintStatus,dateOfReg)"
							+ "values (?,?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setInt(1, cID);
					pst.setInt(2,std_id);
					pst.setString(3, name);
					pst.setString(4, email);
					pst.setString(5, sub);
					pst.setString(6, comp);
					pst.setString(7, status);
					pst.setString(8, dateOfReg);
					int set = set = pst.executeUpdate();
					
					if (set > 0) {
						JOptionPane.showMessageDialog(btnNewButton_1, "Complaint registered successfully");
						BankingMail.StaffQuery(email, cID, std_id, name);
						
						//resetting details
						stf_id.setText("");
						st_id.setText("");
						st_email.setText("");
						st_name.setText("");
						subject.setText("");
						complaint.setText("");
						
						
					} else {
						JOptionPane.showMessageDialog(btnNewButton_1, "Complaint registration failed");
					}

				} catch (NumberFormatException nfs) {
					JOptionPane.showMessageDialog(btnNewButton_1, "Please enter staff id first");
				} catch (SQLException sqle) {
					JOptionPane.showMessageDialog(null, "Please enter details properly");
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 204, 102));
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_1.setBounds(246, 557, 107, 32);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//resetting details
				stf_id.setText("");
				st_id.setText("");
				st_email.setText("");
				st_name.setText("");
				subject.setText("");
				complaint.setText("");
				
			}
		});
		btnNewButton_2.setBackground(new Color(128, 128, 128));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_2.setBounds(386, 557, 107, 32);
		panel.add(btnNewButton_2);

	}
}
