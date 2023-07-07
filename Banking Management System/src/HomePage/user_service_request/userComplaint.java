package HomePage.user_service_request;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import Utilities.BankingMail;
import Utilities.DB_Connection;
import Utilities.PasswordGenerator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class userComplaint extends JFrame {

	private JPanel contentPane;
	private JTextField AccNumber;
	private JTextField subject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userComplaint frame = new userComplaint();
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
	public userComplaint() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\complaint_48px.png"));
		setTitle("Customer Complaint");
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 486, 616);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Customer Care Service");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\complaint_48px.png"));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(30, 11, 390, 47);
		contentPane.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 69, 445, 18);
		contentPane.add(separator);

		JLabel lblNewLabel_1 = new JLabel("Customer A/c No :");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(30, 82, 130, 34);
		contentPane.add(lblNewLabel_1);

		AccNumber = new JTextField();
		AccNumber.setBounds(59, 114, 261, 27);
		contentPane.add(AccNumber);
		AccNumber.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 156, 445, 10);
		contentPane.add(separator_1);

		JLabel lblNewLabel_2 = new JLabel("Name :");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(30, 177, 97, 27);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("A/c No :");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(30, 215, 97, 27);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Subject :");
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(30, 253, 97, 34);
		contentPane.add(lblNewLabel_4);

		subject = new JTextField();
		subject.setBounds(40, 284, 380, 34);
		contentPane.add(subject);
		subject.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Complaint :");
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(30, 329, 101, 34);
		contentPane.add(lblNewLabel_5);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 356, 380, 111);
		contentPane.add(scrollPane);

		JTextArea complaint = new JTextArea();
		scrollPane.setViewportView(complaint);
		complaint.setLineWrap(true);
		complaint.setWrapStyleWord(true);
		complaint.setFont(new Font("SansSerif", Font.PLAIN, 12));

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 497, 445, 10);
		contentPane.add(separator_2);

		JLabel name = new JLabel("");
		name.setForeground(new Color(255, 0, 0));
		name.setFont(new Font("SansSerif", Font.PLAIN, 14));
		name.setBounds(137, 176, 261, 27);
		contentPane.add(name);

		JLabel acNo = new JLabel("");
		acNo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		acNo.setForeground(new Color(255, 0, 0));
		acNo.setBounds(137, 214, 267, 27);
		contentPane.add(acNo);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int AccNum = Integer.parseInt(AccNumber.getText());
					Connection con = DB_Connection.getConnection();
					String sql = "select * from customer where AccNumber = ?";
					PreparedStatement st = con.prepareStatement(sql);
					st.setInt(1, AccNum);
					ResultSet set = st.executeQuery();
					if (set.next()) {
						name.setText(set.getString("AccName"));
						acNo.setText(String.valueOf(set.getInt("AccNumber")));
					} else {
						JOptionPane.showMessageDialog(contentPane, "No Result Found");
					}

				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(contentPane, "Please enter A/c no");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBackground(new Color(0, 204, 102));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton.setBounds(330, 114, 89, 27);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// setting variables
					String Name = name.getText();
					int acNumber = Integer.parseInt(acNo.getText());
					int ComplaintID = Integer.parseInt(PasswordGenerator.generateRandom(7));
					String sub = subject.getText();
					String comp = complaint.getText();
					Date date = new Date();
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					String dateOfjoin = df.format(date);

					Connection con = DB_Connection.getConnection();
					String sql = "select * from customer where AccNumber = ?";
					PreparedStatement st = con.prepareStatement(sql);
					st.setInt(1, acNumber);
					ResultSet set = st.executeQuery();
					if (set.next()) {
						String email = set.getString("emailID");
						String sql1 = "insert into usercomplaint (ComplaintID,AcNumber,AcName,Subject,Complaint,dateOfComplaint)"
								+ " values (?,?,?,?,?,?)";
						PreparedStatement pst = con.prepareStatement(sql1);
						pst.setInt(1, ComplaintID);
						pst.setInt(2, acNumber);
						pst.setString(3, Name);
						pst.setString(4, sub);
						pst.setString(5, comp);
						pst.setString(6, dateOfjoin);
						int set1 = pst.executeUpdate();
						if (set1 != 0) {
							JOptionPane.showMessageDialog(contentPane, "Complaint registered successfully");
							BankingMail.userComplaint(email, ComplaintID, acNumber, Name);
							setVisible(false);
						} else {
							JOptionPane.showMessageDialog(contentPane, "Something went wrong");
						}

					}

				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(contentPane, "Please enter A/c no");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_1.setBounds(184, 518, 89, 27);
		contentPane.add(btnNewButton_1);

	}
}
