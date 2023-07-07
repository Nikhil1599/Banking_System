package beans;

public class cusQuery_bean {
	
	int complaintId,AcNumber;
	String name,status,subject,complaint,dateofjoin;
	
	public cusQuery_bean(int complaintId, int acNumber, String name, String status, String subject, String complaint,
			String dateofjoin) {
		super();
		this.complaintId = complaintId;
		AcNumber = acNumber;
		this.name = name;
		this.status = status;
		this.subject = subject;
		this.complaint = complaint;
		this.dateofjoin = dateofjoin;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public int getAcNumber() {
		return AcNumber;
	}

	public void setAcNumber(int acNumber) {
		AcNumber = acNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public String getDateofjoin() {
		return dateofjoin;
	}

	public void setDateofjoin(String dateofjoin) {
		this.dateofjoin = dateofjoin;
	}
	
	
	
}
