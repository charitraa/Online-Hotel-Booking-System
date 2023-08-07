package Middleware;

public class CorporateMiddleWare {
	public String name,date,country,address,phonenumber,creditCard,cvc,email,password,femail;
	
	public CorporateMiddleWare() {
		
		this.name = "";
		this.date = "";
		this.country = "";
		this.address = "";
		this.phonenumber = "";
		this.creditCard = "";
		this.cvc = "";
	}
	public CorporateMiddleWare(String name, String date, String country, String address, String phonenumber, String creditCard,
			String cvc) {
		
		
		this.name = name;
		this.date = date;
		this.country = country;
		this.address = address;
		this.phonenumber = phonenumber;
		this.creditCard = creditCard;
		this.cvc = cvc;

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public String getCvc() {
		return cvc;
	}
	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFemail() {
		return femail;
	}
	public void setFemail(String femail) {
		this.femail = femail;
	}
	
	
	@Override
	public String toString() {
		return "CorporateMiddleWare [name=" + name + ", date=" + date + ", country=" + country + ", address=" + address
				+ ", phonenumber=" + phonenumber + ", creditCard=" + creditCard + ", cvc=" + cvc + ", email=" + email
				+ ", password=" + password + ", femail=" + femail + "]";
	}
	
}