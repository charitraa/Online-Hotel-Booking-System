package JDBC;


import Middleware.UserMiddleWare;

public class Contollers {
////	public boolean register(CorporateMiddleWare corporate) {
//		boolean result = new Jdbc().register(corporate);
//		return result;
//		
//	}
//	public boolean register1(NonCorporateMiddleWare Noncorporate) {
//		boolean result = new Jdbc().register1(Noncorporate);
//		return result;
//		
//	}
//	public boolean login( UserMiddleWare login) {
//		boolean result = new Jdbc().logins(login);
//		return result;
//		
//	}
//	public boolean book(BookingMiddleWare reserve) {
//		boolean result = new Jdbc().book(reserve);
//		return result;
//		
//	}
	
private UserMiddleWare user;
	
	public Contollers() {
		this.user=new UserMiddleWare();
	}
	
	public Contollers(UserMiddleWare user) {
		this.user=user;
	}
	public UserMiddleWare getUser() {
		return user;
	}
	public void setUser(UserMiddleWare user) {
		this.user = user;
	}
	
	public void login() {
		this.user = new Jdbc().login(this.user);
	}
	public void login1() {
		this.user = new Jdbc().login1(this.user);
	}
	
}
