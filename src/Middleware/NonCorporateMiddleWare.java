package Middleware;

public class NonCorporateMiddleWare {
	
	private String firstName, middleName,lastName,dob,country,address,number,sex;
	public NonCorporateMiddleWare() {
	
		this.firstName = "";
		this.middleName = "";
		this.lastName = "";
		this.dob = "";
		this.country = "";
		this.address = "";
		this.number = "";
		this.sex = "";
	}
	public NonCorporateMiddleWare(String firstName, String middleName, String lastName, String dob,
			String country, String address, String number, String sex) {
		
		
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.country = country;
		this.address = address;
		this.number = number;
		this.sex = sex;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "NonCorporateMiddleWare [" + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", dob=" + dob + ", country=" + country + ", address="
				+ address + ", number=" + number + ", sex=" + sex + "]";
	}
		
}
