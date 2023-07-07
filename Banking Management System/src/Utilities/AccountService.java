package Utilities;

import java.sql.*;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class AccountService {

	public static void DebitCard(int AccNumber, int cusID, String Name, String Date, String email, int cvv, int pin) {
		String cardNo = PasswordGenerator.generateRandom(7);

		SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.YEAR, 3); // Adding 3 years
		String validity = sdf.format(c.getTime());

		try {
			Connection con = DB_Connection.getConnection();
			String sql = "insert into debitcard values (?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, cusID);
			pst.setInt(2, AccNumber);
			pst.setString(3, Name);
			pst.setString(4, cardNo);
			pst.setString(5, validity);
			pst.setInt(6, cvv);
			pst.setInt(7, pin);
			pst.setString(8, Date);
			int set = pst.executeUpdate();

			if (set > 0) {
				BankingMail.debitcard(email, AccNumber, cusID, Name, validity, cardNo, cvv, pin);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void CreditCard(int AccNo, String Date, String email, int cvv, int pin, String name) {
		String cardNo = PasswordGenerator.generateRandom(7);

		SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.YEAR, 3); // Adding 3 years
		String validity = sdf.format(c.getTime());

		int limit = 25000;
		try {
			Connection con = DB_Connection.getConnection();
			String sql = "insert into credit_card (accNo,creditCardNo,expiry,cvv ,pin ,dateOfJoining) values (?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, AccNo);
			pst.setString(2, cardNo);
			pst.setString(3, validity);
			pst.setInt(4, cvv);
			pst.setInt(5, pin);
			pst.setString(6, Date);
			int set = pst.executeUpdate();

			if (set > 0) {
				BankingMail.creditcard(email, AccNo, name, validity, cardNo, cvv, limit, pin);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void CreditCard(int AccNo, String Date, String email, int cvv, int pin, String name, int limit) {
		String cardNo = PasswordGenerator.generateRandom(7);

		SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.YEAR, 3); // Adding 3 years
		String validity = sdf.format(c.getTime());
		int balance = limit;
		try {
			Connection con = DB_Connection.getConnection();
			String sql = "insert into credit_card (accNo,creditCardNo,`balance`,`limit`,expiry,cvv ,pin ,dateOfJoining) values (?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, AccNo);
			pst.setString(2, cardNo);
			pst.setInt(3, balance);
			pst.setInt(4, limit);
			pst.setString(5, validity);
			pst.setInt(6, cvv);
			pst.setInt(7, pin);
			pst.setString(8, Date);
			int set = pst.executeUpdate();

			if (set > 0) {
				BankingMail.creditcard(email, AccNo, name, validity, cardNo, cvv, limit, pin);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void cheque(int AccNo, String email, int cheque, String dateOfJoining) {

		try {
			Connection con = DB_Connection.getConnection();
			String sql = "insert into chequebook (AccNo,ChequeNo,dateOfJoining) values (?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, AccNo);
			pst.setInt(2, cheque);
			pst.setString(3, dateOfJoining);
			int set = pst.executeUpdate();

			if (set > 0) {
				BankingMail.chequeBook(email, cheque, AccNo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
