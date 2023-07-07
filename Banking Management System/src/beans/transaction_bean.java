package beans;

public class transaction_bean {

	private int AccNo, TransactionID, Amount;
	private String Status, Mode, Method, DateOfTransaction,client;
	public transaction_bean(int accNo, int transactionID, int amount, String status, String mode, String method,
			String dateOfTransaction,String client) {
		super();
		this.AccNo = accNo;
		this.TransactionID = transactionID;
		this.Amount = amount;
		this.Status = status;
		this.Mode = mode;
		this.Method = method;
		this.DateOfTransaction = dateOfTransaction;
		this.client = client;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public int getAccNo() {
		return AccNo;
	}
	public void setAccNo(int accNo) {
		AccNo = accNo;
	}
	public int getTransactionID() {
		return TransactionID;
	}
	public void setTransactionID(int transactionID) {
		TransactionID = transactionID;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getMode() {
		return Mode;
	}
	public void setMode(String mode) {
		Mode = mode;
	}
	public String getMethod() {
		return Method;
	}
	public void setMethod(String method) {
		Method = method;
	}
	public String getDateOfTransaction() {
		return DateOfTransaction;
	}
	public void setDateOfTransaction(String dateOfTransaction) {
		DateOfTransaction = dateOfTransaction;
	}

	
	
}
