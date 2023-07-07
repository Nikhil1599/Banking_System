package beans;

public class chequeBean {
	int AcNo,chequeNo,leaf;
	String status,dateOfOrder;
	public chequeBean(int acNo, int chequeNo, int leaf, String status, String dateOfOrder) {
		super();
		AcNo = acNo;
		this.chequeNo = chequeNo;
		this.leaf = leaf;
		this.status = status;
		this.dateOfOrder = dateOfOrder;
	}
	public int getAcNo() {
		return AcNo;
	}
	public void setAcNo(int acNo) {
		AcNo = acNo;
	}
	public int getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}
	public int getLeaf() {
		return leaf;
	}
	public void setLeaf(int leaf) {
		this.leaf = leaf;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(String dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	
	
	
}
