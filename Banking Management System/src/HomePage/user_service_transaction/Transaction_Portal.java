package HomePage.user_service_transaction;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import HomePage.User_account.View_User;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Transaction_Portal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transaction_Portal frame = new Transaction_Portal();
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
	public Transaction_Portal() {
		setResizable(false);
		setTitle("Customer Transaction");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\money_40px.png"));
		setAlwaysOnTop(true);
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 895, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 879, 457);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NSBC BANK PVT LTD");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\charity_50px.png"));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 859, 56);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 128)));
		panel_1.setBackground(new Color(250, 235, 215));
		panel_1.setBounds(49, 158, 772, 216);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Deposit_T().setVisible(true);
			}
		});
		
		panel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBackground(new Color(255, 215, 0));
		panel_2.setBounds(47, 48, 163, 113);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("DEPOSIT");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Deposit_T().setVisible(true);
			}
		});
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 74, 143, 28);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Deposit_T().setVisible(true);
			}
		});
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\transaction_40px.png"));
		lblNewLabel_5.setBounds(10, 11, 143, 62);
		panel_2.add(lblNewLabel_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Withdraw_T().setVisible(true);
			}
		});
		panel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBackground(new Color(255, 215, 0));
		panel_3.setBounds(300, 48, 163, 113);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("WITHDRAW");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Withdraw_T().setVisible(true);
			}
		});
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 76, 143, 26);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Withdraw_T().setVisible(true);
			}
		});
		lblNewLabel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\debit_card_40px.png"));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(10, 11, 143, 64);
		panel_3.add(lblNewLabel_6);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new CheckBalance().setVisible(true);
			}
		});
		panel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBackground(new Color(255, 215, 0));
		panel_4.setBounds(552, 48, 163, 113);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("CHECK BALANCE");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new CheckBalance().setVisible(true);
			}
		});
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 76, 143, 26);
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new CheckBalance().setVisible(true);
			}
		});
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\receipt_64px.png"));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(10, 11, 143, 66);
		panel_4.add(lblNewLabel_7);
		
		JLabel lblNewLabel_1 = new JLabel("MONETARY SERVICE");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\money_40px.png"));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(53, 100, 232, 47);
		panel.add(lblNewLabel_1);
	}
}
