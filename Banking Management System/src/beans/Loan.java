package beans;

public class Loan {
	int AccNo,PolicyNo,LoanAmount, totalAmount;
	String interest,loanFor,tenure,dateOfJoin;
	
	public Loan(int accNo, int policyNo, int loanAmount, int totalAmount, String interest, String loanFor,
			String tenure, String dateOfJoin) {
		super();
		AccNo = accNo;
		PolicyNo = policyNo;
		LoanAmount = loanAmount;
		this.totalAmount = totalAmount;
		this.interest = interest;
		this.loanFor = loanFor;
		this.tenure = tenure;
		this.dateOfJoin = dateOfJoin;
	}

	public int getAccNo() {
		return AccNo;
	}

	public void setAccNo(int accNo) {
		AccNo = accNo;
	}

	public int getPolicyNo() {
		return PolicyNo;
	}

	public void setPolicyNo(int policyNo) {
		PolicyNo = policyNo;
	}

	public int getLoanAmount() {
		return LoanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		LoanAmount = loanAmount;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getLoanFor() {
		return loanFor;
	}

	public void setLoanFor(String loanFor) {
		this.loanFor = loanFor;
	}

	public String getTenure() {
		return tenure;
	}

	public void setTenure(String tenure) {
		this.tenure = tenure;
	}

	public String getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	
	
	
}
