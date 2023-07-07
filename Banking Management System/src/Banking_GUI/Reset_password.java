package Banking_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import Utilities.DB_Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Reset_password extends JFrame {

	private JPanel contentPane;
	private JTextField stf_id;
	private JTextField username;
	private JTextField new_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reset_password frame = new Reset_password();
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
	public Reset_password() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\password_reset_40px.png"));
		setTitle("Reset Password");
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 529, 204);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 523, 175);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RESET PASSWORD");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 0, 153, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Staff ID:");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(32, 41, 68, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username: ");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(32, 82, 68, 30);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New Password: ");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(32, 123, 94, 30);
		panel.add(lblNewLabel_3);
		
		stf_id = new JTextField();
		stf_id.setBounds(149, 45, 153, 24);
		panel.add(stf_id);
		stf_id.setColumns(10);
		
		username = new JTextField();
		username.setBounds(149, 86, 153, 24);
		panel.add(username);
		username.setColumns(10);
		
		new_pass = new JTextField();
		new_pass.setBounds(149, 129, 153, 24);
		panel.add(new_pass);
		new_pass.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String staff_id = stf_id.getText();
				String user = username.getText();
				String pass = new_pass.getText();
			
				try {
					Connection con = DB_Connection.getConnection();
					String sql = "UPDATE bank_staff SET staff_password = '"+pass+"' WHERE staff_id = '"+staff_id+"' and staff_username = '"+user+"'";
					Statement smt = con.createStatement();
					int set = smt.executeUpdate(sql);
					if(set != 0) {
						JOptionPane.showMessageDialog(btnNewButton, "Password Reset Successfully");
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(btnNewButton, "Please enter correct details");
						stf_id.setText("");
						username.setText("");
						new_pass.setText("");
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(60, 179, 113));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnNewButton.setBounds(366, 59, 89, 30);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stf_id.setText("");
				username.setText("");
				new_pass.setText("");
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setBounds(366, 100, 89, 30);
		panel.add(btnNewButton_1);
	}
}
