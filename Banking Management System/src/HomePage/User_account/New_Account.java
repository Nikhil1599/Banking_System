package HomePage.User_account;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import java.awt.ComponentOrientation;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.JCheckBox;
import com.toedter.calendar.JDateChooser;

import Utilities.AccountService;
import Utilities.BankingMail;
import Utilities.DB_Connection;
import Utilities.PasswordGenerator;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class New_Account extends JFrame {

	private JPanel contentPane;
	static New_Account frame;
	private JTextField f_name;
	private JTextField m_name;
	private JTextField s_name;
	private JTextField t_age;
	private JTextField adhar_1;
	private JTextField adhar_2;
	private JTextField adhar_3;
	private JTextField t_pancard;
	private JTextField t_email;
	private JTextField t_mobile;
	private JTextField nom_first;
	private JTextField nom_middle;
	private JTextField nom_last;
	private JTextField t_branch;
	private JTextField t_block;
	private JTextField t_apartment;
	private JTextField t_landmark;
	private JTextField t_city;
	private JTextField t_pincode;
	private JTextField t_pob;
	private JTextField t_alterM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new New_Account();
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
	public New_Account() {

		setType(Type.POPUP);
		setAlwaysOnTop(true);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setTitle("FORM NO. 1A");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 635, 692);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(new Color(255, 248, 220));
		panel_2.setBounds(10, 11, 615, 661);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("FORM NO 1(A)");
		lblNewLabel.setBounds(10, 0, 595, 46);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 27));
		panel_2.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("APPLICATION FOR ACCOUNT OPENING -Page 1(a)");
		lblNewLabel_1.setBounds(10, 42, 595, 26);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		panel_2.add(lblNewLabel_1);

		JPanel panel_4 = new JPanel();
		panel_4.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		panel_4.setBorder(new TitledBorder(null, "USER DETAILS", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(255, 0, 0)));
		panel_4.setBackground(new Color(255, 248, 220));
		panel_4.setBounds(10, 68, 595, 409);
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("NAME : ");
		lblNewLabel_3.setBounds(10, 27, 116, 26);
		panel_4.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));

		f_name = new JTextField();
		f_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		f_name.setBounds(136, 27, 135, 24);
		panel_4.add(f_name);
		f_name.setColumns(10);

		m_name = new JTextField();
		m_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		m_name.setBounds(281, 27, 135, 24);
		panel_4.add(m_name);
		m_name.setColumns(10);

		s_name = new JTextField();
		s_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		s_name.setBounds(426, 27, 135, 24);
		panel_4.add(s_name);
		s_name.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("ACCOUNT TYPE :");
		lblNewLabel_4.setBounds(10, 83, 116, 26);
		panel_4.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));

		JRadioButton r_saving = new JRadioButton("SAVING");
		r_saving.setBounds(139, 83, 109, 23);
		panel_4.add(r_saving);
		r_saving.setBackground(new Color(255, 248, 220));
		r_saving.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JRadioButton r_current = new JRadioButton("CURRENT");
		r_current.setBounds(264, 83, 109, 23);
		panel_4.add(r_current);
		r_current.setBackground(new Color(255, 248, 220));
		r_current.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JRadioButton r_loan = new JRadioButton("LOAN\r\n");
		r_loan.setBounds(409, 83, 109, 23);
		panel_4.add(r_loan);
		r_loan.setBackground(new Color(255, 248, 220));
		r_loan.setFont(new Font("Tahoma", Font.PLAIN, 13));

		ButtonGroup group = new ButtonGroup();
		group.add(r_loan);
		group.add(r_saving);
		group.add(r_current);

		JLabel lblNewLabel_5 = new JLabel("GENDER: ");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 121, 116, 26);
		panel_4.add(lblNewLabel_5);

		JComboBox c_gender = new JComboBox();
		c_gender.setModel(new DefaultComboBoxModel(new String[] {"", "Male", "Female", "Other"}));
		c_gender.setFont(new Font("Calibri", Font.PLAIN, 13));
		c_gender.setBounds(136, 121, 135, 22);
		panel_4.add(c_gender);

		JLabel lblNewLabel_6 = new JLabel("AGE :");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(324, 121, 92, 26);
		panel_4.add(lblNewLabel_6);

		t_age = new JTextField();
		t_age.setFont(new Font("Tahoma", Font.PLAIN, 14));
		t_age.setBounds(426, 120, 135, 24);
		panel_4.add(t_age);
		t_age.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("MARITAL STATUS : ");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(10, 158, 116, 26);
		panel_4.add(lblNewLabel_7);

		JComboBox c_m_status = new JComboBox();
		c_m_status.setFont(new Font("Calibri", Font.PLAIN, 13));
		c_m_status.setModel(new DefaultComboBoxModel(new String[] {"", "Single", "Married", "Divorced"}));
		c_m_status.setBounds(136, 159, 135, 22);
		panel_4.add(c_m_status);

		JLabel lblNewLabel_8 = new JLabel("OCCUPATION :");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(324, 158, 92, 26);
		panel_4.add(lblNewLabel_8);

		JComboBox c_occupation = new JComboBox();
		c_occupation.setFont(new Font("Calibri", Font.PLAIN, 13));
		c_occupation.setModel(
				new DefaultComboBoxModel(new String[] {"", "Bussiness", "Defence", "Service", "Government", "Self Employeed", "Student"}));
		c_occupation.setBounds(426, 159, 135, 22);
		panel_4.add(c_occupation);

		JLabel lblNewLabel_11 = new JLabel("FIRST NAME");
		lblNewLabel_11.setForeground(new Color(255, 0, 0));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(136, 50, 135, 20);
		panel_4.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("MIDDLE NAME");
		lblNewLabel_12.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_12.setForeground(new Color(255, 0, 0));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(281, 50, 135, 20);
		panel_4.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("LAST NAME");
		lblNewLabel_13.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_13.setForeground(new Color(255, 0, 0));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(426, 50, 135, 20);
		panel_4.add(lblNewLabel_13);

		JLabel lblNewLabel_16 = new JLabel("NOMINEE : ");
		lblNewLabel_16.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_16.setBounds(10, 195, 116, 26);
		panel_4.add(lblNewLabel_16);

		nom_first = new JTextField();
		nom_first.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nom_first.setBounds(136, 195, 135, 24);
		panel_4.add(nom_first);
		nom_first.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("FIRST NAME\r\n");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setForeground(Color.RED);
		lblNewLabel_17.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_17.setBounds(136, 221, 135, 20);
		panel_4.add(lblNewLabel_17);

		nom_middle = new JTextField();
		nom_middle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nom_middle.setBounds(281, 195, 135, 24);
		panel_4.add(nom_middle);
		nom_middle.setColumns(10);

		nom_last = new JTextField();
		nom_last.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nom_last.setBounds(426, 195, 135, 24);
		panel_4.add(nom_last);
		nom_last.setColumns(10);

		JLabel lblNewLabel_18 = new JLabel("MIDDLE NAME");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setForeground(Color.RED);
		lblNewLabel_18.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_18.setBounds(281, 221, 135, 20);
		panel_4.add(lblNewLabel_18);

		JLabel lblNewLabel_19 = new JLabel("LAST NAME");
		lblNewLabel_19.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setForeground(Color.RED);
		lblNewLabel_19.setBounds(426, 221, 129, 20);
		panel_4.add(lblNewLabel_19);

		JLabel lblNewLabel_20 = new JLabel("RELATION :");
		lblNewLabel_20.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_20.setBounds(10, 255, 116, 26);
		panel_4.add(lblNewLabel_20);

		JComboBox c_relation = new JComboBox();
		c_relation.setFont(new Font("Calibri", Font.PLAIN, 13));
		c_relation.setModel(new DefaultComboBoxModel(new String[] {"", "Mother", "Father", "Brother", "Sister", "Husband", "Wife", "Other"}));
		c_relation.setBounds(136, 260, 135, 22);
		panel_4.add(c_relation);

		JLabel lblNewLabel_21 = new JLabel("BRANCH :");
		lblNewLabel_21.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_21.setBounds(310, 255, 92, 26);
		panel_4.add(lblNewLabel_21);

		t_branch = new JTextField();
		t_branch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		t_branch.setBounds(426, 256, 135, 24);
		panel_4.add(t_branch);
		t_branch.setColumns(10);

		JLabel lblNewLabel_29 = new JLabel("DATE OF BIRTH :\r\n");
		lblNewLabel_29.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_29.setBounds(10, 292, 116, 26);
		panel_4.add(lblNewLabel_29);

		JDateChooser d_dob = new JDateChooser();
		d_dob.setBounds(136, 294, 135, 24);
		panel_4.add(d_dob);

		JLabel lblNewLabel_30 = new JLabel("PLACE OF BIRTH :");
		lblNewLabel_30.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_30.setBounds(310, 292, 106, 26);
		panel_4.add(lblNewLabel_30);

		t_pob = new JTextField();
		t_pob.setBounds(426, 293, 135, 24);
		panel_4.add(t_pob);
		t_pob.setColumns(10);

		JLabel lblNewLabel_31 = new JLabel("QUALIFICATION :");
		lblNewLabel_31.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_31.setBounds(10, 329, 116, 26);
		panel_4.add(lblNewLabel_31);

		JCheckBox c_hs = new JCheckBox("HIGH SCHOOL");
		c_hs.setBackground(new Color(255, 248, 220));
		c_hs.setFont(new Font("Arial", Font.PLAIN, 11));
		c_hs.setBounds(136, 332, 97, 24);
		panel_4.add(c_hs);

		JCheckBox c_diploma = new JCheckBox("DIPLOMA");
		c_diploma.setFont(new Font("Arial", Font.PLAIN, 11));
		c_diploma.setBackground(new Color(255, 248, 220));
		c_diploma.setBounds(235, 331, 83, 24);
		panel_4.add(c_diploma);

		JCheckBox c_graduation = new JCheckBox("GRADUATION");
		c_graduation.setFont(new Font("Arial", Font.PLAIN, 11));
		c_graduation.setBackground(new Color(255, 248, 220));
		c_graduation.setBounds(320, 330, 106, 24);
		panel_4.add(c_graduation);

		JCheckBox c_pg = new JCheckBox("POST GRADUATION");
		c_pg.setFont(new Font("Arial", Font.PLAIN, 11));
		c_pg.setBackground(new Color(255, 248, 220));
		c_pg.setBounds(426, 330, 129, 24);
		panel_4.add(c_pg);

		ButtonGroup group1 = new ButtonGroup();
		group1.add(c_hs);
		group1.add(c_diploma);
		group1.add(c_graduation);
		group1.add(c_pg);

		JLabel lblNewLabel_32 = new JLabel("SERVICE :");
		lblNewLabel_32.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_32.setBounds(10, 366, 116, 26);
		panel_4.add(lblNewLabel_32);

		JCheckBox c_db = new JCheckBox("DEBIT CARD");
		c_db.setFont(new Font("Arial", Font.PLAIN, 11));
		c_db.setBackground(new Color(255, 248, 220));
		c_db.setBounds(136, 368, 97, 24);
		panel_4.add(c_db);

		JCheckBox c_cc = new JCheckBox("CREDIT CARD");
		c_cc.setFont(new Font("Arial", Font.PLAIN, 11));
		c_cc.setBackground(new Color(255, 248, 220));
		c_cc.setBounds(235, 368, 97, 24);
		panel_4.add(c_cc);

		JCheckBox c_chq = new JCheckBox("CHEQUE");
		c_chq.setFont(new Font("Arial", Font.PLAIN, 11));
		c_chq.setBackground(new Color(255, 248, 220));
		c_chq.setBounds(334, 368, 97, 24);
		panel_4.add(c_chq);

		JCheckBox c_nn = new JCheckBox("NOT NOW");
		c_nn.setFont(new Font("Arial", Font.PLAIN, 11));
		c_nn.setBackground(new Color(255, 248, 220));
		c_nn.setBounds(433, 368, 97, 24);
		panel_4.add(c_nn);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"CONTACT DETAILS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_5.setBackground(new Color(255, 248, 220));
		panel_5.setBounds(10, 477, 595, 173);
		panel_2.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_9 = new JLabel("AADHAAR CARD :");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(10, 22, 114, 28);
		panel_5.add(lblNewLabel_9);

		adhar_1 = new JTextField();
		adhar_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (adhar_1.getText().length() >= 4) {
					adhar_1.setText(adhar_1.getText().substring(0, 3));
				}
			}
		});
		adhar_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		adhar_1.setBounds(134, 23, 91, 25);
		panel_5.add(adhar_1);
		adhar_1.setColumns(4);

		adhar_2 = new JTextField();
		adhar_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (adhar_2.getText().length() >= 4) {
					adhar_2.setText(adhar_2.getText().substring(0, 3));
				}
			}
		});
		adhar_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		adhar_2.setBounds(235, 23, 91, 25);
		panel_5.add(adhar_2);
		adhar_2.setColumns(4);

		adhar_3 = new JTextField();
		adhar_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (adhar_3.getText().length() >= 4) {
					adhar_3.setText(adhar_3.getText().substring(0, 3));
				}
			}
		});
		adhar_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		adhar_3.setBounds(336, 23, 91, 25);
		panel_5.add(adhar_3);
		adhar_3.setColumns(4);

		JLabel lblNewLabel_10 = new JLabel("PAN CARD :");
		lblNewLabel_10.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(10, 61, 114, 28);
		panel_5.add(lblNewLabel_10);

		t_pancard = new JTextField();
		t_pancard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		t_pancard.setBounds(134, 61, 192, 25);
		panel_5.add(t_pancard);
		t_pancard.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("EMAIL ID :");
		lblNewLabel_14.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(10, 100, 114, 28);
		panel_5.add(lblNewLabel_14);

		t_email = new JTextField();
		t_email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		t_email.setBounds(134, 100, 251, 25);
		panel_5.add(t_email);
		t_email.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("MOBILE: ");
		lblNewLabel_15.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_15.setBounds(10, 139, 114, 28);
		panel_5.add(lblNewLabel_15);

		t_mobile = new JTextField();
		t_mobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		t_mobile.setBounds(134, 136, 140, 25);
		panel_5.add(t_mobile);
		t_mobile.setColumns(10);

		JLabel lblNewLabel_33 = new JLabel("ALTERNATE NO :");
		lblNewLabel_33.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_33.setBounds(294, 136, 114, 28);
		panel_5.add(lblNewLabel_33);

		t_alterM = new JTextField();
		t_alterM.setBounds(418, 138, 140, 25);
		panel_5.add(t_alterM);
		t_alterM.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(632, 0, 642, 692);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(new Color(255, 248, 220));
		panel_3.setBounds(10, 11, 615, 661);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("APPLICATION FOR ACCOUNT OPENING -Page 1(b)");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 11, 612, 22);
		panel_3.add(lblNewLabel_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 44, 595, 2);
		panel_3.add(separator);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"CUSTOMER ADDRESS ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_6.setBackground(new Color(255, 248, 220));
		panel_6.setBounds(10, 57, 595, 251);
		panel_3.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_22 = new JLabel("ROOM NO/BLOCK NO :");
		lblNewLabel_22.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_22.setBounds(10, 20, 142, 26);
		panel_6.add(lblNewLabel_22);

		t_block = new JTextField();
		t_block.setFont(new Font("Tahoma", Font.PLAIN, 14));
		t_block.setBounds(182, 22, 392, 24);
		panel_6.add(t_block);
		t_block.setColumns(10);

		JLabel lblNewLabel_23 = new JLabel("APARTMENT/AREA :");
		lblNewLabel_23.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_23.setBounds(10, 57, 142, 26);
		panel_6.add(lblNewLabel_23);

		t_apartment = new JTextField();
		t_apartment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		t_apartment.setBounds(182, 57, 392, 24);
		panel_6.add(t_apartment);
		t_apartment.setColumns(10);

		JLabel lblNewLabel_24 = new JLabel("LANDMARK :");
		lblNewLabel_24.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_24.setBounds(10, 94, 153, 26);
		panel_6.add(lblNewLabel_24);

		t_landmark = new JTextField();
		t_landmark.setFont(new Font("Tahoma", Font.PLAIN, 14));
		t_landmark.setBounds(182, 92, 392, 24);
		panel_6.add(t_landmark);
		t_landmark.setColumns(10);

		JLabel lblNewLabel_25 = new JLabel("CITY :");
		lblNewLabel_25.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_25.setBounds(10, 131, 70, 26);
		panel_6.add(lblNewLabel_25);

		t_city = new JTextField();
		t_city.setFont(new Font("Tahoma", Font.PLAIN, 14));
		t_city.setBounds(182, 132, 142, 24);
		panel_6.add(t_city);
		t_city.setColumns(10);

		JLabel lblNewLabel_26 = new JLabel("PIN CODE :");
		lblNewLabel_26.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_26.setBounds(352, 131, 70, 26);
		panel_6.add(lblNewLabel_26);

		t_pincode = new JTextField();
		t_pincode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		t_pincode.setBounds(432, 132, 142, 24);
		panel_6.add(t_pincode);
		t_pincode.setColumns(10);

		JLabel lblNewLabel_27 = new JLabel("STATE/UT :");
		lblNewLabel_27.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_27.setBounds(10, 168, 142, 26);
		panel_6.add(lblNewLabel_27);

		JComboBox c_state = new JComboBox();
		c_state.setFont(new Font("Calibri", Font.PLAIN, 13));
		c_state.setModel(new DefaultComboBoxModel(new String[] { "", "Andhra Pradesh", "Arunachal Pradesh", "Assam",
				"Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand", "Karnataka",
				"Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha",
				"Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand",
				"West Bengal", "Andaman and Nicobar Island", "Chandigarh", "Dadra and Nagar Haveli", "Daman and Diu",
				"Delhi", "Ladakh", "Lakshadweep", "Jammu and Kashmir", "Puducherry" }));
		c_state.setSelectedIndex(0);
		c_state.setBounds(182, 170, 213, 24);
		panel_6.add(c_state);

		JLabel lblNewLabel_28 = new JLabel("NATIONALITY :");
		lblNewLabel_28.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_28.setBounds(10, 205, 142, 26);
		panel_6.add(lblNewLabel_28);

		JCheckBox c_indian = new JCheckBox("INDIAN");
		c_indian.setBackground(new Color(255, 248, 220));
		c_indian.setFont(new Font("Arial", Font.PLAIN, 11));
		c_indian.setBounds(182, 207, 97, 24);
		panel_6.add(c_indian);

		JCheckBox c_nri = new JCheckBox("NRI");
		c_nri.setFont(new Font("Arial", Font.PLAIN, 11));
		c_nri.setBackground(new Color(255, 248, 220));
		c_nri.setBounds(298, 207, 97, 24);
		panel_6.add(c_nri);

		ButtonGroup gp = new ButtonGroup();
		gp.add(c_indian);
		gp.add(c_nri);

		JCheckBox tac = new JCheckBox("ACCEPT ALL TERM'S AND CONDITION'S");
		tac.setBackground(new Color(255, 248, 220));
		tac.setHorizontalAlignment(SwingConstants.CENTER);
		tac.setFont(new Font("Arial", Font.PLAIN, 11));
		tac.setBounds(120, 506, 373, 23);
		panel_3.add(tac);

		JFileChooser fileDialog = new JFileChooser();

		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					// taking input from user
					int accNumber = Integer.parseInt(PasswordGenerator.generateAccNo(7));
					String name = f_name.getText() + " " + m_name.getText() + " " + s_name.getText();
					String accType = null;
					if (r_saving.isSelected()) {
						accType = r_saving.getText();
					} else if (r_current.isSelected()) {
						accType = r_current.getText();
					} else if (r_loan.isSelected()) {
						accType = r_loan.getText();
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Please select account type");
					}
					String gender = c_gender.getSelectedItem().toString();
					int age = Integer.parseInt(t_age.getText());
					String mStatus = c_m_status.getSelectedItem().toString();
					String occ = c_occupation.getSelectedItem().toString();
					String nominee_name = nom_first.getText() + " " + nom_middle.getText() + " " + nom_last.getText();
					String relation = c_relation.getSelectedItem().toString();
					String branch = t_branch.getText();
					
					String dateOfBirth = null;
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					try {
						Date date = d_dob.getDate();
						dateOfBirth = df.format(date);
					} catch (Exception exp) {
						JOptionPane.showMessageDialog(btnNewButton, "Please Select Date of Birth");
					}

					String pBirth = t_pob.getText();
					String qualification = null;

					if (c_hs.isSelected()) {
						qualification = c_hs.getText();
					} else if (c_diploma.isSelected()) {
						qualification = c_diploma.getText();
					} else if (c_graduation.isSelected()) {
						qualification = c_graduation.getText();
					} else if (c_pg.isSelected()) {
						qualification = c_pg.getText();
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Please select your qualification");
					}

					String aadhar = adhar_1.getText() + " " + adhar_2.getText() + " " + adhar_3.getText();
					
					String pancard = t_pancard.getText();
					String email = t_email.getText();
					String mobile = t_mobile.getText();
					String alternate = t_alterM.getText();
					String room = t_block.getText();
					String apartment = t_apartment.getText();
					String landmark = t_landmark.getText();
					String city = t_city.getText();
					int pincode = Integer.parseInt(t_pincode.getText());
					String state = c_state.getSelectedItem().toString();
					String nationality = null;
					if (c_nri.isSelected()) {
						nationality = c_nri.getText();
					}
					if (c_indian.isSelected()) {
						nationality = c_indian.getText();
					}
					Date date1 = new Date();
					String dateOfJoining = df.format(date1);
					// end of taking input

					// Database Connection
					Connection con = DB_Connection.getConnection();
					String sql = "INSERT INTO customer (`AccNumber`,`AccName`,`AccType`,`Gender`,`Age`,`MaritalStatus`,`Occupation`,`NomineeName`,`NomineeRelation`,"
							+ "`Branch`,`DateOfBirth`,`placeBirth`,`Qualification`,`aadharCard`,`pancard`,`emailID`,`mobile`,`alterMobile`,`Room/Block`,`Apartment/Area`,`Landmark`,`City`,"
							+ "`Pincode`,`State`,`Nationality`,`DateOfJoining`) VALUES"
							+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setInt(1, accNumber);
					pst.setString(2, name);
					pst.setString(3, accType);
					pst.setString(4, gender);
					pst.setInt(5, age);
					pst.setString(6, mStatus);
					pst.setString(7, occ);
					pst.setString(8, nominee_name);
					pst.setString(9, relation);
					pst.setString(10, branch);
					pst.setString(11, dateOfBirth);
					pst.setString(12, pBirth);
					pst.setString(13, qualification);
					pst.setString(14, aadhar);
					pst.setString(15, pancard);
					pst.setString(16, email);
					pst.setString(17, mobile);
					pst.setString(18, alternate);
					pst.setString(19, room);
					pst.setString(20, apartment);
					pst.setString(21, landmark);
					pst.setString(22, city);
					pst.setInt(23, pincode);
					pst.setString(24, state);
					pst.setString(25, nationality);
					pst.setString(26, dateOfJoining);

					if (tac.isSelected()) {
						
						int result = pst.executeUpdate();
						if (result > 0) {
							JOptionPane.showMessageDialog(btnNewButton, "New account registration has completed",
									"Successfully Registered", JOptionPane.INFORMATION_MESSAGE);
							
							
							String sql2 = "insert into balance (AccNo) values (?)";
							String sql1 = "select cusID from customer where AccNumber = ?";
							PreparedStatement smt1 = con.prepareStatement(sql1);
							PreparedStatement smt2 = con.prepareStatement(sql2);
							smt2.setInt(1,accNumber);
							smt1.setInt(1,accNumber);
							int set1 = smt2.executeUpdate();
							ResultSet set = smt1.executeQuery();
							
							if(set.next()) {
								int csID = set.getInt("cusID");
								BankingMail.NewCustomer(email, csID, name, accNumber, accType, branch);
								if(c_db.isSelected()) {
									int cvv = Integer.parseInt(PasswordGenerator.generateRandom(2));
									int pin = Integer.parseInt(PasswordGenerator.generateRandom(3));
									AccountService.DebitCard(accNumber, csID, name, dateOfJoining, email,cvv,pin);
								}
								if(c_cc.isSelected()) {
									
									int cvv = Integer.parseInt(PasswordGenerator.generateRandom(2));
									int pin = Integer.parseInt(PasswordGenerator.generateRandom(3));
									AccountService.CreditCard(accNumber,dateOfJoining,email,cvv,pin,name);
								}
								if(c_chq.isSelected()) {
									int cheque = Integer.parseInt(PasswordGenerator.generateRandom(5));
									AccountService.cheque(accNumber,email, cheque, dateOfJoining);
								}
							}
							
							//Exitting from page
							setVisible(false);
							
						}else {
							JOptionPane.showMessageDialog(btnNewButton, "Failed", "Employee Registration",
									JOptionPane.ERROR_MESSAGE);
						}
						
					}else {
						JOptionPane.showMessageDialog(btnNewButton, "Please accept term's and condition's");
					}

				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(btnNewButton, "Please complete all details");
				} catch (Exception eq) {
					eq.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(244, 164, 96));
		btnNewButton.setBounds(178, 551, 114, 36);
		panel_3.add(btnNewButton);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 248, 220));
		panel_7.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"OTHER DETAILS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_7.setBounds(10, 319, 595, 169);
		panel_3.add(panel_7);
		panel_7.setLayout(null);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Are you a Tax's payer of India");
		chckbxNewCheckBox_1.setBackground(new Color(255, 248, 220));
		chckbxNewCheckBox_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		chckbxNewCheckBox_1.setBounds(23, 29, 450, 28);
		panel_7.add(chckbxNewCheckBox_1);

		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Are you belong's to Divyang Quota?");
		chckbxNewCheckBox_2.setBackground(new Color(255, 248, 220));
		chckbxNewCheckBox_2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		chckbxNewCheckBox_2.setBounds(23, 72, 450, 28);
		panel_7.add(chckbxNewCheckBox_2);

		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Are you a Senior Citizen");
		chckbxNewCheckBox_3.setBackground(new Color(255, 248, 220));
		chckbxNewCheckBox_3.setFont(new Font("SansSerif", Font.PLAIN, 13));
		chckbxNewCheckBox_3.setBounds(24, 112, 449, 28);
		panel_7.add(chckbxNewCheckBox_3);

		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f_name.setText("");
				m_name.setText("");
				s_name.setText("");
				group.clearSelection();
				c_gender.setSelectedIndex(0);
				c_m_status.setSelectedIndex(0);
				t_age.setText("");
				nom_first.setText("");
				nom_middle.setText("");
				nom_last.setText("");
				c_relation.setSelectedIndex(0);
				t_branch.setText("");
				d_dob.setCalendar(null);
				t_pob.setText("");
				adhar_1.setText("");
				adhar_2.setText("");
				adhar_3.setText("");
				t_pancard.setText("");
				t_email.setText("");
				t_mobile.setText("");
				t_alterM.setText("");
				t_apartment.setText("");
				t_block.setText("");
				t_city.setText("");
				t_landmark.setText("");
				t_pincode.setText("");
				c_state.setSelectedIndex(0);
				gp.clearSelection();
				
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton_1.setBounds(314, 551, 114, 36);
		panel_3.add(btnNewButton_1);
	}
}
