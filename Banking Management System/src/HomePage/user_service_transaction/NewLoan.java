package HomePage.user_service_transaction;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import Utilities.BankingMail;
import Utilities.DB_Connection;
import Utilities.PasswordGenerator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class NewLoan extends JFrame {

	private JPanel contentPane;
	private JTextField accNo;
	private JTextField LoanA;
	private JTextField tenure;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewLoan frame = new NewLoan();
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
	public NewLoan() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\deposit_80px.png"));
		setTitle("New Loan Application");
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1089, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "New Application", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 411, 585);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer A/c No :");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 24, 141, 23);
		panel.add(lblNewLabel);
		
		accNo = new JTextField();
		accNo.setBounds(20, 46, 248, 28);
		panel.add(accNo);
		accNo.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 85, 391, 11);
		panel.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 105, 72, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("A/c Type :");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(20, 183, 72, 28);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Loan Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 222, 391, 138);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Loan Amount :");
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 25, 97, 26);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Loan for :");
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 62, 97, 26);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tenure :");
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 99, 97, 28);
		panel_1.add(lblNewLabel_6);
		
		LoanA = new JTextField();
		LoanA.setBounds(117, 24, 226, 26);
		panel_1.add(LoanA);
		LoanA.setColumns(10);
		
		JComboBox loanF = new JComboBox();
		loanF.setFont(new Font("SansSerif", Font.PLAIN, 13));
		loanF.setModel(new DefaultComboBoxModel(new String[] {"", "Personal", "Home Loan", "Car Loan", "Education Loan"}));
		loanF.setBounds(117, 61, 226, 26);
		panel_1.add(loanF);
		
		JLabel lblNewLabel_7 = new JLabel("Years");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(224, 101, 75, 26);
		panel_1.add(lblNewLabel_7);
		
		tenure = new JTextField();
		tenure.setBounds(117, 100, 97, 25);
		panel_1.add(tenure);
		tenure.setColumns(10);
		
		JTextArea dashboard = new JTextArea();
		dashboard.setFont(new Font("Consolas", Font.PLAIN, 15));
		dashboard.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		dashboard.setLineWrap(true);
		dashboard.setEditable(false);
		dashboard.setWrapStyleWord(true);
		dashboard.setBounds(650, 11, 402, 580);
		contentPane.add(dashboard);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "EMI Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 405, 391, 129);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Interest :");
		lblNewLabel_8.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(10, 21, 82, 26);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Total Payable :");
		lblNewLabel_9.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(10, 94, 97, 26);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Laon Amount :");
		lblNewLabel_10.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(10, 58, 97, 25);
		panel_2.add(lblNewLabel_10);
		
		JLabel interestL = new JLabel("");
		interestL.setForeground(new Color(255, 0, 0));
		interestL.setFont(new Font("SansSerif", Font.PLAIN, 14));
		interestL.setBounds(117, 21, 151, 26);
		panel_2.add(interestL);
		
		JLabel totalPay = new JLabel("");
		totalPay.setForeground(new Color(255, 0, 0));
		totalPay.setFont(new Font("SansSerif", Font.PLAIN, 14));
		totalPay.setBounds(118, 94, 171, 24);
		panel_2.add(totalPay);
		
		JLabel lblNewLabel_11 = new JLabel("A/c No :");
		lblNewLabel_11.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(20, 144, 72, 28);
		panel.add(lblNewLabel_11);
		
		JLabel accType = new JLabel("");
		accType.setForeground(new Color(255, 0, 0));
		accType.setFont(new Font("SansSerif", Font.PLAIN, 14));
		accType.setBounds(102, 183, 224, 26);
		panel.add(accType);
		
		JLabel LoanAmount = new JLabel("");
		LoanAmount.setForeground(new Color(255, 0, 0));
		LoanAmount.setFont(new Font("SansSerif", Font.PLAIN, 14));
		LoanAmount.setBounds(117, 56, 151, 26);
		panel_2.add(LoanAmount);
		
		JLabel name = new JLabel("");
		name.setForeground(new Color(255, 0, 0));
		name.setFont(new Font("SansSerif", Font.PLAIN, 14));
		name.setBounds(102, 105, 224, 26);
		panel.add(name);
		
		JLabel acNo = new JLabel("");
		acNo.setForeground(new Color(255, 0, 0));
		acNo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		acNo.setBounds(102, 146, 224, 26);
		panel.add(acNo);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int AccNo = Integer.parseInt(accNo.getText());
					Connection con = DB_Connection.getConnection();
					String sql = "select * from customer where AccNumber = ?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setInt(1,AccNo);
					ResultSet set = pst.executeQuery();
					
					if(set.next()) {
						//Setting Account details						
						name.setText(set.getString("AccName"));
						acNo.setText(String.valueOf(set.getInt("AccNumber")));
						accType.setText(set.getString("AccType"));
						
					}else {
						JOptionPane.showMessageDialog(panel, "Please enter correct details");
					}
					
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(panel, "Please enter A/c No");
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 204, 102));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton.setBounds(279, 46, 89, 28);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Calculate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int loanAmount = Integer.parseInt(LoanA.getText());
					float loanInterest = 0;
					boolean flag = false;
					
					if(loanF.getSelectedItem() == "Personal") {
						loanInterest =(float) 8.5;
						flag = true;
					}else if(loanF.getSelectedItem() == "Home Loan") {
						loanInterest = (float) 6.5;
						flag = true;
					}else if(loanF.getSelectedItem() == "Car Loan") {
						loanInterest = (float) 9.5;
						flag = true;
					}else if(loanF.getSelectedItem() == "Education Loan") {
						loanInterest = (float) 8.5;
						flag = true;
					}
					
					if(flag == true) {
						int loanTenure = Integer.parseInt(tenure.getText());
						int loanIntRate = (int) (loanAmount * loanInterest * loanTenure / 100);
						int total = (int) (loanAmount + loanIntRate);
						interestL.setText(String.valueOf(loanIntRate));
						LoanAmount.setText(String.valueOf(loanAmount));
						totalPay.setText(String.valueOf(total));
					}else {
						JOptionPane.showMessageDialog(panel, "Please select loan option");	
					}
					
					
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(panel, "Please enter loan details");
				} catch (Exception e2) {
					e2.printStackTrace();
				}				
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton_1.setBounds(154, 371, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Approve");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float loanInterest = 0;
				//Setting loan details from caculate button
				try {
					int loanAmount = Integer.parseInt(LoanA.getText());
					boolean flag = false;
					
					if(loanF.getSelectedItem() == "Personal") {
						loanInterest =(float) 8.5;
						flag = true;
					}else if(loanF.getSelectedItem() == "Home Loan") {
						loanInterest = (float) 6.5;
						flag = true;
					}else if(loanF.getSelectedItem() == "Car Loan") {
						loanInterest = (float) 9.5;
						flag = true;
					}else if(loanF.getSelectedItem() == "Education Loan") {
						loanInterest = (float) 8.5;
						flag = true;
					}
					
					if(flag == true) {
						int loanTenure = Integer.parseInt(tenure.getText());
						int loanIntRate = (int) (loanAmount * loanInterest * loanTenure / 100);
						int total = (int) (loanAmount + loanIntRate);
						interestL.setText(String.valueOf(loanIntRate));
						LoanAmount.setText(String.valueOf(loanAmount));
						totalPay.setText(String.valueOf(total));
					}else {
						JOptionPane.showMessageDialog(panel, "Please select loan option");	
					}
					
					
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(panel, "Please enter loan details");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				//setting data into database and mail
				try {
					int account = Integer.parseInt(accNo.getText());
					
					Connection con = DB_Connection.getConnection();
					String sql = "select * from customer where AccNumber = ?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setInt(1,account);
					ResultSet set = pst.executeQuery();
					if(set.next()) {
						int AccNumber = set.getInt("AccNumber");
						String branch = set.getString("Branch");
						String email = set.getString("emailID");
						String name = set.getString("AccName");
						int policy = Integer.parseInt(PasswordGenerator.generateRandom(7));
						int loanAmount = Integer.parseInt(LoanAmount.getText());
						String interest = interestL.getText();
						String loanfor = String.valueOf(loanF.getSelectedItem());
						String Tenure = String.valueOf(tenure.getText()) + " Years";
						int payble = Integer.parseInt(totalPay.getText());
						Date date1 = new Date();
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						String dateOfJoining = sdf.format(date1);
						
						String sql1 = "insert into loanapplication (AccNo,PolicyNo,loanAmount,interest,loanFor,tenure,payableAmount,dateOfJoin)"
								+ " values (?,?,?,?,?,?,?,?)";
						PreparedStatement pst1 = con.prepareStatement(sql1);
						pst1.setInt(1,AccNumber);
						pst1.setInt(2,policy);
						pst1.setInt(3,loanAmount);
						pst1.setString(4,String.valueOf(loanInterest));
						pst1.setString(5,loanfor);
						pst1.setString(6,Tenure);
						pst1.setInt(7,payble);
						pst1.setString(8,dateOfJoining);
						int set1 = pst1.executeUpdate();
						if(set1 != 0) {
							JOptionPane.showMessageDialog(panel, "Loan Application Submitted");
							BankingMail.Loan(email, policy, account, loanAmount, payble, String.valueOf(loanInterest), Tenure, dateOfJoining, name, loanfor);
							dashboard.setText("\n\t         NBSC Bank Pvt Ltd\n ************************************************\n Name : "+name+"      Date : "+dateOfJoining+"  \n A/c No : "+AccNumber+"      Branch : "+branch+"  \n"
									+ " ************************************************\n\t         --Loan Details-- \n\n Policy No : "+policy+"\n"
									+ " Loan Amount : "+loanAmount+"\n Loan Type : "+loanfor+" \n Interest Rate : "+loanInterest+"\n Tenure : "+Tenure+"  \n Interest to pay : "+interest+"\n Total Amount : "+payble+" \n\n "
									+ "************************************************\n\t            Thank you ");
						}
						else
						{
							JOptionPane.showMessageDialog(panel, "Loan Application Failed");
						}
					}
					
				}catch(NumberFormatException nfe1) {
					JOptionPane.showMessageDialog(panel, "PLease enter A/c no");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_2.setBackground(new Color(0, 153, 255));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton_2.setBounds(154, 545, 89, 28);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Print");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dashboard.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(51, 153, 255));
		btnNewButton_3.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_3.setBounds(551, 69, 89, 29);
		contentPane.add(btnNewButton_3);
		
		
	}
}
