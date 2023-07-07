package Utilities;

import java.util.Random;

public class PasswordGenerator {
	public static String generateRandomPassword(int len) {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi"
          +"jklmnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i <= len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
	public static String generateRandom(int len) {
		String chars = "0123456789";
				Random rnd = new Random();
				StringBuilder sb = new StringBuilder(len);
				for (int i = 0; i <= len; i++)
					sb.append(chars.charAt(rnd.nextInt(chars.length())));
				return sb.toString();
	}
	
	public static String generateComplaintID(int len) {
		String chars = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i <= len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
	
	public static String generateAccNo(int len) {
		String chars = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i <= len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
}
