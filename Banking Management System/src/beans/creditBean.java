package beans;

public class creditBean {
	String cardNo,expiry,dateOfJoin;
	int accNo,balance,limit,cvv;
	
	public creditBean(String cardNo, String expiry, String dateOfJoin, int accNo, int balance, int limit, int cvv) {
		super();
		this.cardNo = cardNo;
		this.expiry = expiry;
		this.dateOfJoin = dateOfJoin;
		this.accNo = accNo;
		this.balance = balance;
		this.limit = limit;
		this.cvv = cvv;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public String getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	
}
