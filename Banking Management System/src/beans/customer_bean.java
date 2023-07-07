package beans;

public class customer_bean {
	private int cusID, AccNumber, Age, pincode;
	private String AccName,placeOfBirth, AccType, Gender, MaritalStatus, Occupation, NomineeName, NomineeRelation, Branch,
			dateOfBirth, Qualification, aadharCard, pancard, emailID, mobile, altermobile, Room, Area, Landmark, City,
			State, Nationality, DateOfJoining;

	public customer_bean(int cusID, int accNumber, String accName, String accType, String gender, int age,
			String maritalStatus, String occupation, String nomineeName, String nomineeRelation, String branch,
			String dateOfBirth,String placeOfBirth, String qualification, String aadharCard, String pancard, String emailID, String mobile,
			String altermobile, String room, String area, String landmark, String city, int pincode, String state,
			String nationality, String dateOfJoining) {
		super();
		this.cusID = cusID;
		this.AccNumber = accNumber;
		this.Age = age;
		this.pincode = pincode;
		this.AccName = accName;
		this.AccType = accType;
		this.Gender = gender;
		this.MaritalStatus = maritalStatus;
		this.Occupation = occupation;
		this.NomineeName = nomineeName;
		this.NomineeRelation = nomineeRelation;
		this.Branch = branch;
		this.dateOfBirth = dateOfBirth;
		this.Qualification = qualification;
		this.aadharCard = aadharCard;
		this.pancard = pancard;
		this.emailID = emailID;
		this.mobile = mobile;
		this.altermobile = altermobile;
		this.Room = room;
		this.Area = area;
		this.Landmark = landmark;
		this.placeOfBirth = placeOfBirth;
		this.City = city;
		this.State = state;
		this.Nationality = nationality;
		this.DateOfJoining = dateOfJoining;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public int getCusID() {
		return cusID;
	}

	public void setCusID(int cusID) {
		this.cusID = cusID;
	}

	public int getAccNumber() {
		return AccNumber;
	}

	public void setAccNumber(int accNumber) {
		AccNumber = accNumber;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getAccName() {
		return AccName;
	}

	public void setAccName(String accName) {
		AccName = accName;
	}

	public String getAccType() {
		return AccType;
	}

	public void setAccType(String accType) {
		AccType = accType;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getMaritalStatus() {
		return MaritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		MaritalStatus = maritalStatus;
	}

	public String getOccupation() {
		return Occupation;
	}

	public void setOccupation(String occupation) {
		Occupation = occupation;
	}

	public String getNomineeName() {
		return NomineeName;
	}

	public void setNomineeName(String nomineeName) {
		NomineeName = nomineeName;
	}

	public String getNomineeRelation() {
		return NomineeRelation;
	}

	public void setNomineeRelation(String nomineeRelation) {
		NomineeRelation = nomineeRelation;
	}

	public String getBranch() {
		return Branch;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getQualification() {
		return Qualification;
	}

	public void setQualification(String qualification) {
		Qualification = qualification;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAltermobile() {
		return altermobile;
	}

	public void setAltermobile(String altermobile) {
		this.altermobile = altermobile;
	}

	public String getRoom() {
		return Room;
	}

	public void setRoom(String room) {
		Room = room;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public String getLandmark() {
		return Landmark;
	}

	public void setLandmark(String landmark) {
		Landmark = landmark;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	public String getDateOfJoining() {
		return DateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		DateOfJoining = dateOfJoining;
	}

	@Override
	public String toString() {
		return "customer_bean [cusID=" + cusID + ", AccNumber=" + AccNumber + ", Age=" + Age + ", pincode=" + pincode
				+ ", AccName=" + AccName + ", placeOfBirth=" + placeOfBirth + ", AccType=" + AccType + ", Gender="
				+ Gender + ", MaritalStatus=" + MaritalStatus + ", Occupation=" + Occupation + ", NomineeName="
				+ NomineeName + ", NomineeRelation=" + NomineeRelation + ", Branch=" + Branch + ", dateOfBirth="
				+ dateOfBirth + ", Qualification=" + Qualification + ", aadharCard=" + aadharCard + ", pancard="
				+ pancard + ", emailID=" + emailID + ", mobile=" + mobile + ", altermobile=" + altermobile + ", Room="
				+ Room + ", Area=" + Area + ", Landmark=" + Landmark + ", City=" + City + ", State=" + State
				+ ", Nationality=" + Nationality + ", DateOfJoining=" + DateOfJoining + "]";
	}
	
}
