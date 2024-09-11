package fit.iuh.entities;

import java.time.LocalDate;
import java.util.Arrays;

public class Student {
	private String fname, lname, email, pnumber, address, city, pinCode, state, country, courseAppliesFor;
	
	private LocalDate dob;
	
	private boolean gender;
	
	private String[] hobbies;
	
	private String[][] qualification;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}


	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPnumber() {
		return pnumber;
	}

	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCourseAppliesFor() {
		return courseAppliesFor;
	}

	public void setCourseAppliesFor(String courseAppliesFor) {
		this.courseAppliesFor = courseAppliesFor;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public String[][] getQualification() {
		return qualification;
	}

	public void setQualification(String[][] qualification) {
		this.qualification = qualification;
	}

	public Student(String fname, String lname, LocalDate dob, String email, String pnumber, String address, String city,
			String pinCode, String state, String country, String courseAppliesFor, boolean gender, String[] hobbies,
			String[][] qualification) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.email = email;
		this.pnumber = pnumber;
		this.address = address;
		this.city = city;
		this.pinCode = pinCode;
		this.state = state;
		this.country = country;
		this.courseAppliesFor = courseAppliesFor;
		this.gender = gender;
		this.hobbies = hobbies;
		this.qualification = qualification;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [fname=" + fname + ", lname=" + lname + ", dob=" + dob + ", email=" + email + ", pnumber="
				+ pnumber + ", address=" + address + ", city=" + city + ", pinCode=" + pinCode + ", state=" + state
				+ ", country=" + country + ", courseAppliesFor=" + courseAppliesFor + ", gender=" + gender
				+ ", hobbies=" + Arrays.toString(hobbies) + ", qualification=" + Arrays.toString(qualification) + "]";
	}
	
	
}
