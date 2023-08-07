package Middleware;

public class UserMiddleWare {
	public  String email;
	public  String password;
	public int uid;
	public UserMiddleWare() {
		
		this.email = "";
		this.password = "";
	}
	
	public UserMiddleWare(int uid,String email, String password) {
		this.uid=uid;
		this.email = email;
		this.password = password;
	}

	public  String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public  String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public  int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + password + ", uid=" + uid + "]";
	}
	
}