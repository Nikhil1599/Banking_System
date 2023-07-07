package beans;

public class staff_bean {
	private int id, zipcode;
	private String mobile,aadhar;
	private String name, gender, dateOfbith, department, designation, branch, state, qualification, email, pancard, username,
			password, dateOfjoining;
	public staff_bean(int id, String name, String gender, String dateOfbith, String department, String designation,
			String branch, String state,int zipcode, String mobile, String qualification, String email, String pancard,String aadhar, String username,
			String password, String dateOfjoining) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dateOfbith = dateOfbith;
		this.department = department;
		this.designation = designation;
		this.branch = branch;
		this.state = state;
		this.zipcode = zipcode;
		this.mobile = mobile;
		this.qualification = qualification;
		this.email = email;
		this.pancard = pancard;
		this.aadhar = aadhar;
		this.username = username;
		this.password = password;
		this.dateOfjoining = dateOfjoining;
	}
	public staff_bean() {
		super();
		
	}
	
	
	
	public staff_bean(int id, String name, String designation, String branch) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.branch = branch;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfbith() {
		return dateOfbith;
	}
	public void setDateOfbith(String dateOfbith) {
		this.dateOfbith = dateOfbith;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDateOfjoining() {
		return dateOfjoining;
	}
	public void setDateOfjoining(String dateOfjoining) {
		this.dateOfjoining = dateOfjoining;
	}
	@Override
	public String toString() {
		return "staff_bean [id=" + id + ", zipcode=" + zipcode + ", mobile=" + mobile + ", aadhar=" + aadhar + ", name="
				+ name + ", gender=" + gender + ", dateOfbith=" + dateOfbith + ", department=" + department
				+ ", designation=" + designation + ", branch=" + branch + ", state=" + state + ", qualification="
				+ qualification + ", email=" + email + ", pancard=" + pancard + ", username=" + username + ", password="
				+ password + ", dateOfjoining=" + dateOfjoining + "]";
	}
	
}
