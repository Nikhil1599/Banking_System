package beans;

public class FixedDepo {
	private int RequestID, Amount;
	private String duration, maturity, dateOfInvest;
	public FixedDepo(int requestID, int amount, String duration, String maturity, String dateOfInvest) {
		super();
		RequestID = requestID;
		Amount = amount;
		this.duration = duration;
		this.maturity = maturity;
		this.dateOfInvest = dateOfInvest;
	}
	public int getRequestID() {
		return RequestID;
	}
	public void setRequestID(int requestID) {
		RequestID = requestID;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getMaturity() {
		return maturity;
	}
	public void setMaturity(String maturity) {
		this.maturity = maturity;
	}
	public String getDateOfInvest() {
		return dateOfInvest;
	}
	public void setDateOfInvest(String dateOfInvest) {
		this.dateOfInvest = dateOfInvest;
	}
	
	
}
