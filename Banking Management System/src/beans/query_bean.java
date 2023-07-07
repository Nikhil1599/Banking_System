package beans;

public class query_bean {
	int sr_no, complaintID, StaffID;
	String StaffEmail, StaffName, StaffSubject, StaffComplaint, StaffStatus, dateOfReg;
	
	public query_bean(int sr_no, int complaintID, int staffID, String staffEmail, String staffName, String staffSubject,
			String staffComplaint, String staffStatus, String dateOfReg) {
		super();
		this.sr_no = sr_no;
		this.complaintID = complaintID;
		this.StaffID = staffID;
		this.StaffEmail = staffEmail;
		this.StaffName = staffName;
		this.StaffSubject = staffSubject;
		this.StaffComplaint = staffComplaint;
		this.StaffStatus = staffStatus;
		this.dateOfReg = dateOfReg;
	}

	public int getSr_no() {
		return sr_no;
	}

	public void setSr_no(int sr_no) {
		this.sr_no = sr_no;
	}

	public int getComplaintID() {
		return complaintID;
	}

	public void setComplaintID(int complaintID) {
		this.complaintID = complaintID;
	}

	public int getStaffID() {
		return StaffID;
	}

	public void setStaffID(int staffID) {
		StaffID = staffID;
	}

	public String getStaffEmail() {
		return StaffEmail;
	}

	public void setStaffEmail(String staffEmail) {
		StaffEmail = staffEmail;
	}

	public String getStaffName() {
		return StaffName;
	}

	public void setStaffName(String staffName) {
		StaffName = staffName;
	}

	public String getStaffSubject() {
		return StaffSubject;
	}

	public void setStaffSubject(String staffSubject) {
		StaffSubject = staffSubject;
	}

	public String getStaffComplaint() {
		return StaffComplaint;
	}

	public void setStaffComplaint(String staffComplaint) {
		StaffComplaint = staffComplaint;
	}

	public String getStaffStatus() {
		return StaffStatus;
	}

	public void setStaffStatus(String staffStatus) {
		StaffStatus = staffStatus;
	}

	public String getDateOfReg() {
		return dateOfReg;
	}

	public void setDateOfReg(String dateOfReg) {
		this.dateOfReg = dateOfReg;
	}
	
}
