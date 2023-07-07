package Utilities;

import java.util.Properties;

import javax.mail.*;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class BankingMail {
	// Sender's email ID needs to be mentioned
	final static String username = "banknbsc@gmail.com";// change accordingly
	final static String password = "nbsc1234";// change accordingly

	// Get the Session object
	public static void newAccount(String recipient, String staff_username, int staff_id, String staff_pass) {
		// Recipient's email ID needs to be mentioned.
		String to = recipient;// change accordingly
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("Welcome to NBSC Bank");

			// Now set the actual message
			message.setText("Welcome to NBSC Family, your staff welcome kit is given below \n\nStaff ID: " + staff_id
					+ "" + "\nUsername: " + staff_username + "\nPassword: " + staff_pass
					+ "\n\n****Please dont share your credentials" + " with anyone.****");

			// Send message
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void StaffQuery(String recipient, int complaintID, int StaffID, String name) {
		// Recipient's email ID needs to be mentioned.
		String to = recipient;// change accordingly
		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("Your Complaint ID is " + complaintID + " from\nNBSC Bank(Staff ID: " + StaffID + ")");

			// Now set the actual message
			message.setText("" + name + " your complaint has successfully registered\nPlease refer you complaint id "
					+ complaintID + "" + " to track your complaint status.");

			// Send message
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void NewCustomer(String recipient, int cusID, String name, int accNumber, String accType,
			String branch) {
		// Recipient's email ID needs to be mentioned.
		String to = recipient;// change accordingly
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("Welcome to NBSC Bank, " + name + " your " + accType + " has activated Successfully");

			// Now set the actual message
			message.setText("Your " + accType + " account details is given below:\n\n-----------------------------\n"
					+ "Customer ID: " + cusID + "\nAccount no: " + accNumber + "\nAccount Name: " + name + ""
					+ "\nAccount Type: " + accType + "\nBranch: " + branch + "\n\n* Note: please don't share your "
					+ "account details or password and otp with other's *");

			// Send message
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void debitcard(String recipient, int AccNumber, int cusID, String name, String validity, String card,
			int cvv, int pin) {
		// Recipient's email ID needs to be mentioned.
		String to = recipient;// change accordingly
		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("" + name + " your Debit Card for account number " + AccNumber
					+ " has been activated (Customer ID : " + cusID + ")");

			// Now set the actual message
			message.setText(
					"We glad to inform you that your Debit Card is ready to use, your card details is given below\n\n"
							+ "------------------------\nName : " + name + "\nCard no : " + card + "\nValidity : "
							+ validity + "\n" + "CVV : " + cvv + "\nPin : " + pin
							+ "\n\n * Note : Please dont share this details with anyone *");

			// Send message
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void creditcard(String recipient, int AccNumber, String name, String validity, String card, int cvv,
			int limit, int pin) {
		// Recipient's email ID needs to be mentioned.
		String to = recipient;// change accordingly
		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("" + name + " your Credit Card for account number " + AccNumber
					+ " has been activated (Credit Card No : " + card + " )");

			// Now set the actual message
			message.setText(
					"We glad to inform you that your Credit Card is ready to use, your card details is given below\n\n"
							+ "------------------------\nName : " + name + "\nCard no : " + card + "\nValidity : "
							+ validity + "\n" + "CVV : " + cvv + "\nPin : " + pin + "\nLimit : " + limit
							+ "\n\n * Note : Please dont share this details with anyone *");

			// Send message
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void chequeBook(String recipient, int cheque, int AccNo) {
		// Recipient's email ID needs to be mentioned.
		String to = recipient;// change accordingly
		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("Welcome to NBSC Bank | Dear Customer your Cheque Book request for Account no : " + AccNo
					+ " has approved");

			// Now set the actual message
			message.setText("Dear Customer your Cheque Book request has been approved. Your Cheque Book no : " + cheque
					+ " "
					+ "will be dispatch and delivered to your registered address within a 7 working days\n\nThank You ");

			// Send message
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void transaction(String recipient, int AccNo, int TransacID, int Amount, String mode, int balance,
			String Method, String client, String dateOfT) {
		// Recipient's email ID needs to be mentioned.
		String to = recipient;// change accordingly
		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			if (mode == "Credit") {
				message.setSubject("Transaction Sucess Alert | Rs." + Amount + " Credited to A/c " + AccNo + "");
				message.setText("Thank you for choosing NBSC Bank. Rs." + Amount + " Credited to A/c " + AccNo + " by "
						+ Method + " through " + client + "." + " Total Bal:Rs." + balance + " (" + dateOfT
						+ ") - NBSC Bank ");
			} else if (mode == "Debit") {
				message.setSubject("Transaction Sucess Alert | Rs." + Amount + " Debited from A/c " + AccNo + "");
				message.setText("Thank you for choosing NBSC Bank. Rs." + Amount + " Debited from A/c " + AccNo + " by "
						+ Method + " through " + client + "." + " Total Bal:Rs." + balance + " (" + dateOfT
						+ ") - NBSC Bank ");
			}
			// Now set the actual message

			// Send message
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void fixedDepo(String recipient, int RequestID, int AccNo, int amount, String duration,
			String validity, String dateOfInvest) {
		// Recipient's email ID needs to be mentioned.
		String to = recipient;// change accordingly
		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("Dear Customer | Your Fixed Deposit Amount of Rs." + amount + " issued successfully");

			// Now set the actual message
			message.setText("Dear Customer your Fixed Deposit request has been approved. Your Investment Request ID : "
					+ RequestID + "\nA/c No : " + AccNo + "\nRequest ID : " + RequestID + "\nAmount : " + amount
					+ "\nTerm : " + duration + "\n" + "Date of Maturity : " + validity + " " + "\n\nThank You ");

			// Send message
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void creditCardBill(String recipient, String card, int transaction, int accNo, int amount,
			String method, String dateofpay, int newBal) {
		// Recipient's email ID needs to be mentioned.
		String to = recipient;// change accordingly
		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("Dear Credit Card Customer | Your Credit Card bill paid successfully (Card no :" + " "
					+ card + ")");

			// Now set the actual message
			message.setText("Thank you for choosing NBSC Bank Credit card. Your credit card bill paid successfully by "
					+ method + " on " + dateofpay + ".\n" + "Bill Amount : " + amount + "\nTransaction ID : "
					+ transaction + "\nAvailable Balance : " + newBal + "\n\nThank You ");

			// Send message
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void Loan(String recipient, int policy, int account, int loanAmount, int payable, String interest,
			String tenure, String dateOfJoin, String name, String loanFor) {
		// Recipient's email ID needs to be mentioned.
		String to = recipient;// change accordingly
		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject(" " + name + " your " + loanFor + " has Approved (Policy no : " + policy + ")");

			// Now set the actual message
			message.setText(
					"Dear Customer, Your loan has been approved successfully. your loan application details given below.\n"
							+ "A/c No : " + account + "\nPolicy No : " + policy + "\nLoan Amount : " + loanAmount
							+ "\nInterest : " + interest + "\nTotal Payable : " + payable + "\n" + "Tenure : " + tenure
							+ "\nDate of Registration : " + dateOfJoin + "\n\nThank You");

			// Send message
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void PinChange(String recipient, String name, String cardType, int accNo, String cardNo, int pin) {
		// Recipient's email ID needs to be mentioned.
		String to = recipient;// change accordingly
		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject(
					"Dear, " + name + " your " + cardType + " pin changed successfully (Card no : " + cardNo + ")");

			// Now set the actual message
			message.setText("Dear Customer, Your " + cardType
					+ " pin change request has successfully completed, your new pin is " + pin + "."
					+ " Please don't share your pin with anyone.\n\nThank You ");

			// Send message
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void userComplaint(String recipient, int complaintID, int accNumber, String name) {
		// Recipient's email ID needs to be mentioned.
		String to = recipient;// change accordingly
		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("Dear, Customer your complaint has been registered successfully (Complaint id : "
					+ complaintID + ")");

			// Now set the actual message
			message.setText("Dear " + name + " your complaint for A/c No " + accNumber
					+ " has been registered to bank. please refer your complaint id " + complaintID + ""
					+ " to track your complaint status.\n\nThank You ");

			// Send message
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}