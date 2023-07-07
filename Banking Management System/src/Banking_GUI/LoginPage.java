package Banking_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Utilities.DB_Connection;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField t_username;
	private JPasswordField t_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\administrator_male_40px.png"));
		setResizable(false);
		//Set window title
		setTitle("NSBC BANK STAFF LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//window dimension
		setBounds(100, 100, 774, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//panel 1
		JPanel panel = new JPanel();
		panel.setBackground(new Color(65, 105, 225));
		panel.setBounds(0, 0, 176, 393);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel Title_1 = new JLabel("Bank Admin");
		Title_1.setHorizontalAlignment(SwingConstants.CENTER);
		Title_1.setForeground(Color.WHITE);
		Title_1.setFont(new Font("Calibri", Font.BOLD, 27));
		Title_1.setBounds(10, 69, 156, 42);
		panel.add(Title_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(0, 155, 176, 56);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel Title_Section1 = new JLabel("Login");
		Title_Section1.setBounds(32, 11, 97, 45);
		panel_2.add(Title_Section1);
		Title_Section1.setInheritsPopupMenu(false);
		Title_Section1.setIconTextGap(1);
		Title_Section1.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\key_30px.png"));
		Title_Section1.setHorizontalAlignment(SwingConstants.LEFT);
		Title_Section1.setFont(new Font("Calibri", Font.PLAIN, 21));
		Title_Section1.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_3 = new JLabel("V 1.012");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(38, 325, 94, 42);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(175, 0, 583, 393);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel Bank_title = new JLabel("NBSC BANK PVT LTD");
		Bank_title.setHorizontalAlignment(SwingConstants.CENTER);
		Bank_title.setForeground(Color.BLUE);
		Bank_title.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\charity_50px.png"));
		Bank_title.setFont(new Font("SansSerif", Font.BOLD, 26));
		Bank_title.setBounds(10, 25, 563, 45);
		panel_1.add(Bank_title);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\user_30px.png"));
		lblNewLabel.setBounds(83, 124, 36, 45);
		panel_1.add(lblNewLabel);
		
		t_username = new JTextField();
		t_username.setFont(new Font("Arial", Font.PLAIN, 13));
		t_username.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "USERNAME", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 51)));
		t_username.setBounds(133, 124, 260, 45);
		panel_1.add(t_username);
		t_username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\lock_48px.png"));
		lblNewLabel_1.setBounds(73, 194, 46, 55);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = t_username.getText();
				String password = t_password.getText();
				try {
					Connection con = DB_Connection.getConnection();
					String query = "select * from bank_staff where staff_username = ? and staff_password = ?";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, username);
		            pst.setString(2, password);
					ResultSet set = pst.executeQuery();
					if(set.next()) {
						HomePage hp = new HomePage();
						setVisible(false);
						hp.setVisible(true);					
					}else {
						JOptionPane.showMessageDialog(btnNewButton, "Username and Password is incorrect", "Invalid Details", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Consolas", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 102, 204));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\enter_26px.png"));
		btnNewButton.setBounds(135, 274, 254, 39);
		panel_1.add(btnNewButton);
		
		t_password = new JPasswordField();
		t_password.setFont(new Font("Arial", Font.PLAIN, 13));
		t_password.setBorder(new TitledBorder(null, "PASSWORD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 51)));
		t_password.setBounds(133, 204, 260, 45);
		panel_1.add(t_password);
		
		JLabel lblNewLabel_2 = new JLabel("Forget Password");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Reset_password().setVisible(true);
			}
		});
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\forget.png"));
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(214, 345, 131, 25);
		panel_1.add(lblNewLabel_2);
	}
}
