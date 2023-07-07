package Utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import beans.customer_bean;

public class Testing {

	public static void main(String[] args) {
		Date date1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dateOfJoining = sdf.format(date1);
		System.out.println(dateOfJoining);

	}
}