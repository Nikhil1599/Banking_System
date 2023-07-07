package beans;

public class debitBean {
	int CusID,AccNumber;
	String AccName,CardNo,Validity,cvv,DateOfJoining;
	public debitBean(int cusID, int accNumber, String accName, String cardNo, String validity, String cvv,
			String dateOfJoining) {
		super();
		CusID = cusID;
		AccNumber = accNumber;
		AccName = accName;
		CardNo = cardNo;
		Validity = validity;
		this.cvv = cvv;
		DateOfJoining = dateOfJoining;
	}
	public int getCusID() {
		return CusID;
	}
	public void setCusID(int cusID) {
		CusID = cusID;
	}
	public int getAccNumber() {
		return AccNumber;
	}
	public void setAccNumber(int accNumber) {
		AccNumber = accNumber;
	}
	public String getAccName() {
		return AccName;
	}
	public void setAccName(String accName) {
		AccName = accName;
	}
	public String getCardNo() {
		return CardNo;
	}
	public void setCardNo(String cardNo) {
		CardNo = cardNo;
	}
	public String getValidity() {
		return Validity;
	}
	public void setValidity(String validity) {
		Validity = validity;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getDateOfJoining() {
		return DateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		DateOfJoining = dateOfJoining;
	}
	
	
	
}
