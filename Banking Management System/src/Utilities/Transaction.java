package Utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Transaction {

	public static void Deposit(int AccNo, int TransactionID, String email, String client, String method, int amount,
			String date, int bal) {

		String mode = "Credit";
		try {
			Connection con = DB_Connection.getConnection();
			String sql = "insert into transactions (AccNo,TransactionID,Amount,Mode,Method,client,dateOfTransaction) values "
					+ "(?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, AccNo);
			pst.setInt(2, TransactionID);
			pst.setInt(3, amount);
			pst.setString(4, mode);
			pst.setString(5, method);
			pst.setString(6, client);
			pst.setString(7, date);
			int set = pst.executeUpdate();
			if (set != 0) {
				BankingMail.transaction(email, AccNo, TransactionID, amount, mode, bal, method, client, date);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Withdrawal(int AccNo, int TransactionID, String email, String client, String method, int amount,
			String date, int bal) {

		String mode = "Debit";

		try {
			Connection con = DB_Connection.getConnection();
			String sql = "insert into transactions (AccNo,TransactionID,Amount,Mode,Method,client,dateOfTransaction) values "
					+ "(?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, AccNo);
			pst.setInt(2, TransactionID);
			pst.setInt(3, amount);
			pst.setString(4, mode);
			pst.setString(5, method);
			pst.setString(6,client);
			pst.setString(7, date);
			int set = pst.executeUpdate();
			if (set != 0) {
				BankingMail.transaction(email, AccNo, TransactionID, amount, mode, bal, method, client, date);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void fixedDeposit(int requestID,int AccNo, int TransactionID, String email, String client, String method,
			int amount, String dateOfInvest, String dateOfMaturity, String duration, int bal) {
		String mode = "Debit";
		try {
			Connection con = DB_Connection.getConnection();
			String sql = "insert into transactions (AccNo,TransactionID,Amount,Mode,Method,client,dateOfTransaction) values "
					+ "(?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, AccNo);
			pst.setInt(2, TransactionID);
			pst.setInt(3, amount);
			pst.setString(4, mode);
			pst.setString(5, method);
			pst.setString(6, client);
			pst.setString(7, dateOfInvest);
			int set = pst.executeUpdate();
			if(set != 0) {
				BankingMail.transaction(email, AccNo, TransactionID, amount, mode, bal, method, client, dateOfInvest);
				BankingMail.fixedDepo(email, requestID, AccNo, amount, duration, dateOfMaturity, dateOfInvest);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void creditBill(int AccNo, int TransactionID, String email, String client, String method, int amount,
			String date, int bal){
		String mode = "Debit";
		try {
			Connection con = DB_Connection.getConnection();
			String sql = "insert into transactions (AccNo,TransactionID,Amount,Mode,Method,client,dateOfTransaction) values "
					+ "(?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, AccNo);
			pst.setInt(2, TransactionID);
			pst.setInt(3, amount);
			pst.setString(4, mode);
			pst.setString(5, method);
			pst.setString(6, client);
			pst.setString(7, date);
			int set = pst.executeUpdate();
			if(set != 0) {
				BankingMail.transaction(email, AccNo, TransactionID, amount, mode, bal, method, client, date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
