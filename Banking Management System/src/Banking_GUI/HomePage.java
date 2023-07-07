package Banking_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import Banking_Staff.CustomerDetails;
import Banking_Staff.NewStaff;
import Banking_Staff.Query_Details;
import Banking_Staff.StaffQuery;
import Banking_Staff.UpdateStaff;
import HomePage.User_account.FD;
import HomePage.User_account.New_Account;
import HomePage.User_account.UpdateCustomer;
import HomePage.User_account.View_User;
import HomePage.user_service_request.CardPortal;
import HomePage.user_service_request.ChequeRequest;
import HomePage.user_service_request.ComplaintPortal;
import HomePage.user_service_request.PinChange;
import HomePage.user_service_transaction.AccStatement;
import HomePage.user_service_transaction.Loan_Portal;
import HomePage.user_service_transaction.PayBills;
import HomePage.user_service_transaction.Transaction_Portal;
import beans.staff_bean;

import javax.swing.JSeparator;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;
	//Main Frame
	static HomePage frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new HomePage();
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
	
	public HomePage() {
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\charity_50px.png"));
		setResizable(false);
		setType(Type.POPUP);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setTitle("WELCOME TO NSBC BANK PVT LTD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1286, 692);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		contentPane.setSize(screenSize.width, screenSize.height);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 1, 147, 663);
		panel.setBackground(new Color(0, 102, 204));
		contentPane.add(panel);
		panel.setLayout(null);
		
		//STAFF PORTAL HEADING 1 
		JLabel lblNewLabel_7 = new JLabel("STAFF");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblNewLabel_7.setBounds(0, 117, 147, 25);
		panel.add(lblNewLabel_7);
		
		//STAFF PORTAL HEADING 2
		JLabel lblNewLabel_8 = new JLabel("ACCOUNT");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(0, 137, 147, 25);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\administrator_male_40px.png"));
		lblNewLabel_9.setBounds(0, 56, 147, 62);
		panel.add(lblNewLabel_9);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(65, 105, 225));
		panel_7.setBounds(0, 202, 147, 62);
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("EDIT  ACCOUNT\r\n");
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new UpdateStaff().setVisible(true);
			}
		});
		lblNewLabel_10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_10.setBounds(0, 0, 147, 62);
		panel_7.add(lblNewLabel_10);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(65, 105, 225));
		panel_8.setBounds(0, 262, 147, 62);
		panel.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("ADD NEW STAFF");
		lblNewLabel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new NewStaff().setVisible(true);
			}
		});
		lblNewLabel_11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(0, 0, 147, 62);
		panel_8.add(lblNewLabel_11);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(65, 105, 225));
		panel_9.setBounds(0, 322, 147, 62);
		panel.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("QUERY LIST");
		lblNewLabel_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new Query_Details().setVisible(true);
			}
		});
		lblNewLabel_12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_12.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_12.setForeground(new Color(255, 255, 255));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(0, 0, 147, 62);
		panel_9.add(lblNewLabel_12);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(65, 105, 225));
		panel_10.setBounds(0, 382, 147, 62);
		panel.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblNewLabel_13 = new JLabel("STAFF COMPLAINT");
		lblNewLabel_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new StaffQuery().setVisible(true);
			}
		});
		lblNewLabel_13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_13.setForeground(new Color(255, 255, 255));
		lblNewLabel_13.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(0, 0, 147, 62);
		panel_10.add(lblNewLabel_13);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBackground(new Color(65, 105, 225));
		panel_22.setBounds(0, 443, 147, 62);
		panel.add(panel_22);
		panel_22.setLayout(null);
		
		JLabel lblNewLabel_42 = new JLabel("CUSTOMER LIST");
		lblNewLabel_42.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_42.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new CustomerDetails().setVisible(true);
			}
		});
		lblNewLabel_42.setForeground(Color.WHITE);
		lblNewLabel_42.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_42.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_42.setBounds(0, 0, 147, 62);
		panel_22.add(lblNewLabel_42);
		
		JLabel lblNewLabel_41 = new JLabel("CUSTOMER LIST");
		lblNewLabel_41.setBounds(0, 446, 147, 62);
		panel.add(lblNewLabel_41);
		lblNewLabel_41.setForeground(new Color(255, 255, 255));
		lblNewLabel_41.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_41.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new CompoundBorder());
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(147, 2, 1133, 662);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN PORTAL\r\n");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\verified_account_32px.png"));
		lblNewLabel_1.setBounds(21, 102, 199, 44);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_1.setBackground(new Color(255, 0, 0));
		
		JLabel lblNewLabel = new JLabel("NSBC BANK PVT LTD ");
		lblNewLabel.setBounds(313, 11, 461, 62);
		panel_2.add(lblNewLabel);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBackground(new Color(0, 0, 255));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\charity_50px.png"));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(843, 170, 257, 366);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBackground(new Color(255, 250, 205));
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ABOUT US");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\staff_48px.png"));
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel_2.setBounds(30, 11, 182, 34);
		panel_1.add(lblNewLabel_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 56, 258, 2);
		panel_1.add(separator_1);
		
		JLabel lblNewLabel_3 = new JLabel("NBSC BANK SOFTWARE SOLUTION");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 114, 237, 34);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("OWNED  BY: ");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 69, 104, 34);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("VERSION");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 159, 104, 34);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("V 1.01");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(10, 204, 237, 34);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_14 = new JLabel("SYSTEM TYPE:");
		lblNewLabel_14.setForeground(Color.RED);
		lblNewLabel_14.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_14.setBounds(10, 249, 123, 34);
		panel_1.add(lblNewLabel_14);
		
		JLabel lblNewLabel_40 = new JLabel("ADMIN");
		lblNewLabel_40.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_40.setBounds(10, 294, 237, 34);
		panel_1.add(lblNewLabel_40);
		
		
		staff_bean bn = new staff_bean();
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 84, 1099, 17);
		panel_2.add(separator);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(null, "USER ACCOUNT", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)));
		panel_11.setBackground(new Color(255, 255, 255));
		panel_11.setBounds(21, 157, 731, 143);
		panel_2.add(panel_11);
		panel_11.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new New_Account().setVisible(true);
			}
		});
		panel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.setBounds(20, 29, 134, 85);
		panel_11.add(panel_3);
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBackground(new Color(255, 165, 0));
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_16 = new JLabel("NEW ACCOUNT");
		lblNewLabel_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new New_Account().setVisible(true);
			}
		});
		lblNewLabel_16.setForeground(new Color(255, 255, 255));
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_16.setBounds(10, 55, 114, 19);
		panel_3.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new New_Account().setVisible(true);
			}
		});
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\add_user_group_woman_man_48px.png"));
		lblNewLabel_17.setBounds(10, 11, 114, 48);
		panel_3.add(lblNewLabel_17);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new View_User().setVisible(true);
			}
		});
		panel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.setBounds(188, 29, 134, 85);
		panel_11.add(panel_4);
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBackground(new Color(255, 165, 0));
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_18 = new JLabel("VIEW USER");
		lblNewLabel_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new View_User().setVisible(true);
			}
		});
		lblNewLabel_18.setForeground(new Color(255, 255, 255));
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_18.setBounds(10, 60, 114, 14);
		panel_4.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new View_User().setVisible(true);
			}
		});
		lblNewLabel_19.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\user_48px.png"));
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setBounds(10, 11, 114, 47);
		panel_4.add(lblNewLabel_19);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FD().setVisible(true);
			}
		});
		panel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_5.setBounds(519, 30, 134, 85);
		panel_11.add(panel_5);
		panel_5.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5.setBackground(new Color(255, 165, 0));
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_20 = new JLabel("FD/RD");
		lblNewLabel_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FD().setVisible(true);
			}
		});
		lblNewLabel_20.setForeground(new Color(255, 255, 255));
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_20.setBounds(10, 60, 114, 14);
		panel_5.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FD().setVisible(true);
			}
		});
		lblNewLabel_21.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\money_40px.png"));
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_21.setBounds(10, 11, 114, 44);
		panel_5.add(lblNewLabel_21);
		
		JPanel panel_20 = new JPanel();
		panel_20.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new UpdateCustomer().setVisible(true);
			}
		});
		panel_20.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_20.setBackground(new Color(255, 165, 0));
		panel_20.setBounds(355, 30, 134, 85);
		panel_11.add(panel_20);
		panel_20.setLayout(null);
		
		JLabel lblNewLabel_34 = new JLabel("");
		lblNewLabel_34.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new UpdateCustomer().setVisible(true);
			}
		});
		lblNewLabel_34.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_34.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\update_32px.png"));
		lblNewLabel_34.setBounds(10, 11, 114, 43);
		panel_20.add(lblNewLabel_34);
		
		JLabel lblNewLabel_35 = new JLabel("UPDATE USER");
		lblNewLabel_35.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new UpdateCustomer().setVisible(true);
			}
		});
		lblNewLabel_35.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_35.setForeground(new Color(255, 255, 255));
		lblNewLabel_35.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_35.setBounds(10, 54, 114, 20);
		panel_20.add(lblNewLabel_35);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "USER SERVICE TRANSACTION", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)));
		panel_12.setBackground(Color.WHITE);
		panel_12.setBounds(21, 311, 731, 143);
		panel_2.add(panel_12);
		panel_12.setLayout(null);
		
		JPanel panel_13 = new JPanel();
		panel_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Transaction_Portal().setVisible(true);
			}
		});
		panel_13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_13.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_13.setBackground(new Color(255, 165, 0));
		panel_13.setBounds(21, 30, 134, 85);
		panel_12.add(panel_13);
		panel_13.setLayout(null);
		
		JLabel lblNewLabel_24 = new JLabel("USER TRANSACTION");
		lblNewLabel_24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Transaction_Portal().setVisible(true);
			}
		});
		lblNewLabel_24.setForeground(Color.WHITE);
		lblNewLabel_24.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_24.setFont(new Font("SansSerif", Font.BOLD, 11));
		lblNewLabel_24.setBounds(10, 60, 114, 14);
		panel_13.add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("");
		lblNewLabel_25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Transaction_Portal().setVisible(true);
			}
		});
		lblNewLabel_25.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_25.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\transaction_40px.png"));
		lblNewLabel_25.setBounds(10, 11, 114, 51);
		panel_13.add(lblNewLabel_25);
		
		JPanel panel_14 = new JPanel();
		panel_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PayBills().setVisible(true);
			}
		});
		panel_14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_14.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_14.setBackground(new Color(255, 165, 0));
		panel_14.setBounds(190, 30, 134, 85);
		panel_12.add(panel_14);
		panel_14.setLayout(null);
		
		JLabel lblNewLabel_26 = new JLabel("PAY BILLS");
		lblNewLabel_26.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PayBills().setVisible(true);
			}
		});
		lblNewLabel_26.setForeground(Color.WHITE);
		lblNewLabel_26.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_26.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_26.setBounds(10, 60, 114, 14);
		panel_14.add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("");
		lblNewLabel_27.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PayBills().setVisible(true);
			}
		});
		lblNewLabel_27.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\receipt_64px.png"));
		lblNewLabel_27.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_27.setBounds(10, 11, 114, 48);
		panel_14.add(lblNewLabel_27);
		
		JPanel panel_15 = new JPanel();
		panel_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AccStatement().setVisible(true);
			}
		});
		panel_15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_15.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_15.setBackground(new Color(255, 165, 0));
		panel_15.setBounds(354, 30, 134, 85);
		panel_12.add(panel_15);
		panel_15.setLayout(null);
		
		JLabel lblNewLabel_32 = new JLabel("ACCOUNT STATEMENT");
		lblNewLabel_32.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AccStatement().setVisible(true);
			}
		});
		lblNewLabel_32.setForeground(Color.WHITE);
		lblNewLabel_32.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_32.setFont(new Font("SansSerif", Font.BOLD, 11));
		lblNewLabel_32.setBounds(0, 60, 134, 14);
		panel_15.add(lblNewLabel_32);
		
		JLabel lblNewLabel_33 = new JLabel("");
		lblNewLabel_33.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AccStatement().setVisible(true);
			}
		});
		lblNewLabel_33.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_33.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\transaction_list_48px.png"));
		lblNewLabel_33.setBounds(10, 11, 114, 44);
		panel_15.add(lblNewLabel_33);
		
		JPanel panel_16 = new JPanel();
		panel_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Loan_Portal().setVisible(true);
			}
		});
		panel_16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_16.setBackground(new Color(255, 165, 0));
		panel_16.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_16.setBounds(519, 30, 134, 85);
		panel_12.add(panel_16);
		panel_16.setLayout(null);
		
		JLabel lblNewLabel_38 = new JLabel("LOANS");
		lblNewLabel_38.setForeground(Color.WHITE);
		lblNewLabel_38.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_38.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_38.setBounds(10, 60, 114, 14);
		panel_16.add(lblNewLabel_38);
		
		JLabel lblNewLabel_39 = new JLabel("");
		lblNewLabel_39.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\euro_money_40px.png"));
		lblNewLabel_39.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_39.setBounds(10, 11, 114, 48);
		panel_16.add(lblNewLabel_39);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(255, 255, 255));
		panel_17.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "USER SERVICE REQUEST", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_17.setBounds(21, 465, 731, 143);
		panel_2.add(panel_17);
		panel_17.setLayout(null);
		
		JPanel panel_18 = new JPanel();
		panel_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ChequeRequest().setVisible(true);
			}
		});
		panel_18.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_18.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_18.setBackground(new Color(255, 165, 0));
		panel_18.setBounds(21, 28, 134, 85);
		panel_17.add(panel_18);
		panel_18.setLayout(null);
		
		JLabel lblNewLabel_28 = new JLabel("CHEQUE BOOK");
		lblNewLabel_28.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_28.setForeground(new Color(255, 255, 255));
		lblNewLabel_28.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_28.setBounds(10, 60, 114, 14);
		panel_18.add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("");
		lblNewLabel_29.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_29.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\paycheque_40px.png"));
		lblNewLabel_29.setBounds(10, 11, 114, 52);
		panel_18.add(lblNewLabel_29);
		
		JPanel panel_19 = new JPanel();
		panel_19.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_19.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_19.setBackground(new Color(255, 165, 0));
		panel_19.setBounds(190, 28, 134, 85);
		panel_17.add(panel_19);
		panel_19.setLayout(null);
		
		JLabel lblNewLabel_30 = new JLabel("CREDIT/DEBIT CARD");
		lblNewLabel_30.setForeground(Color.WHITE);
		lblNewLabel_30.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_30.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_30.setBounds(10, 60, 114, 14);
		panel_19.add(lblNewLabel_30);
		
		JLabel lblNewLabel_31 = new JLabel("");
		lblNewLabel_31.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new CardPortal().setVisible(true);
			}
		});
		lblNewLabel_31.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_31.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\debit_card_40px.png"));
		lblNewLabel_31.setBounds(10, 11, 114, 48);
		panel_19.add(lblNewLabel_31);
		
		JPanel panel_21 = new JPanel();
		panel_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PinChange().setVisible(true);
			}
		});
		panel_21.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_21.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_21.setBackground(new Color(255, 165, 0));
		panel_21.setBounds(519, 28, 134, 85);
		panel_17.add(panel_21);
		panel_21.setLayout(null);
		
		JLabel lblNewLabel_36 = new JLabel("PIN CHANGE");
		lblNewLabel_36.setForeground(Color.WHITE);
		lblNewLabel_36.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_36.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_36.setBounds(10, 60, 114, 14);
		panel_21.add(lblNewLabel_36);
		
		JLabel lblNewLabel_37 = new JLabel("");
		lblNewLabel_37.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\password_reset_40px.png"));
		lblNewLabel_37.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_37.setBounds(10, 11, 114, 51);
		panel_21.add(lblNewLabel_37);
		
		JPanel panel_6 = new JPanel();
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ComplaintPortal().setVisible(true);
			}
		});
		panel_6.setBounds(354, 30, 134, 85);
		panel_17.add(panel_6);
		panel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_6.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_6.setBackground(new Color(255, 165, 0));
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_22 = new JLabel("USER COMPLAINT");
		lblNewLabel_22.setForeground(Color.WHITE);
		lblNewLabel_22.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22.setBounds(10, 60, 114, 14);
		panel_6.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\customer_48px.png"));
		lblNewLabel_23.setBounds(10, 11, 114, 50);
		panel_6.add(lblNewLabel_23);
		
		JLabel lblNewLabel_15 = new JLabel("LOG OUT");
		lblNewLabel_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblNewLabel_15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_15.setForeground(new Color(255, 0, 0));
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_15.setFont(new Font("SansSerif", Font.BOLD, 11));
		lblNewLabel_15.setIcon(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Banking Management System\\src\\Images_icons\\exit_32px.png"));
		lblNewLabel_15.setBounds(928, 561, 90, 47);
		panel_2.add(lblNewLabel_15);
		
		
	}
}
