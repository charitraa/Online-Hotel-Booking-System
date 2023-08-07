package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import GUI.Booking;
import GUI.Login;
import GUI.test;
import Middleware.BookingMiddleWare;
import Middleware.CorporateMiddleWare;
import Middleware.UserMiddleWare;
import Middleware.NonCorporateMiddleWare;

public class Jdbc {
	public UserMiddleWare login(UserMiddleWare user) {
		//quries 
		String sql = "SELECT * FROM user WHERE email = ? AND password =?";
		try {
			//connect to java
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_luton", "root","");
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getEmail());
			pstat.setString(2, user.getPassword());
			//run sql statement
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				user.setUid(rs.getInt("uid"));
			
			}
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return user;
	}
public UserMiddleWare login1(UserMiddleWare user) {
		
		String sql = "SELECT * FROM staff WHERE Email = ? AND Password =?";
		try {
			//connect
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_luton", "root","");
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getEmail());
			pstat.setString(2, user.getPassword());
			//run sql statement
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				user.setUid(rs.getInt("Staff_Id"));
			
			}
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return user;
}
		public boolean register(CorporateMiddleWare corporate) {

			boolean result=false;
			String sql1 = "SELECT uid FROM user ";
			String sql = "INSERT INTO `corporate`( `Company_Name`, `Established_Date`, `Country`, `Address`, `Phone_Number`, `Credit_Card_No`, `Cvc`, `UserId`) VALUES (?,?,?,?,?,?,?,?)";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");//load database driver
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_luton", "root", "");
				PreparedStatement select = conn.prepareStatement(sql1);
				ResultSet rs = select.executeQuery();
				PreparedStatement pstat=conn.prepareStatement(sql);
				while(rs.next()) {
					int id = rs.getInt("uid");
					pstat.setInt(8, id);
				}

				pstat.setString(1, corporate.getName());
				pstat.setString(2, corporate.getDate());
				pstat.setString(3, corporate.getCountry());
				pstat.setString(4, corporate.getAddress());
				pstat.setString(5, corporate.getPhonenumber());
				pstat.setString(6, corporate.getCreditCard());
				pstat.setString(7, corporate.getCvc());
				
				//to save 
				pstat.executeUpdate(); 
				pstat.close();
				conn.close();
				result=true;
			}
			catch(Exception ex) {
				System.out.println("Error : "+ex.getMessage());
			}
			return result;
		}
		
		public boolean register1(NonCorporateMiddleWare Noncorporate) {

			boolean result=false;
			String sql1 = "SELECT uid FROM user";
			String sql = "INSERT INTO `non_corporate`(`First_Name`, `Middle_Name`, `Last_Name`, `Date_of_Birth`, `Country`, `Address`, `Phone_Number`, `Sex`,`UserId`) VALUES (?,?,?,?,?,?,?,?,?)";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");//load database driver
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_luton", "root", "");
				PreparedStatement select = conn.prepareStatement(sql1);
				ResultSet rs = select.executeQuery();
				PreparedStatement pstat=conn.prepareStatement(sql);
				while(rs.next()) {
					int id = rs.getInt("uid");
					pstat.setInt(9, id);
				}
				
				pstat.setString(1, Noncorporate.getFirstName());
				pstat.setString(2, Noncorporate.getMiddleName());
				pstat.setString(3, Noncorporate.getLastName());
				pstat.setString(4, Noncorporate.getDob());
				pstat.setString(5, Noncorporate.getCountry());
				pstat.setString(6, Noncorporate.getAddress());
				pstat.setString(7, Noncorporate.getNumber());
				pstat.setString(8, Noncorporate.getSex());
				//to save 
				pstat.executeUpdate(); 
				pstat.close();
				conn.close();
				result=true;
			}
			catch(Exception ex) {
				System.out.println("Error : "+ex.getMessage());
			}
			return result;
		}
		
		public boolean logins(UserMiddleWare login ) {

			boolean result=false;
			String sql = "INSERT INTO `user`(`uid`, `email`, `password`) VALUES (?,?,?)";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");//load database driver
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_luton", "root", "");
				PreparedStatement pstat=conn.prepareStatement(sql);
				pstat.setInt(1, login.getUid());
				pstat.setString(2, login.getEmail());
				pstat.setString(3, login.getPassword());
				
				//to save 
				pstat.executeUpdate(); 
				pstat.close();
				conn.close();
				result=true;
			}
			catch(Exception ex) {
				System.out.println("Error : "+ex.getMessage());
			}
			return result;
		}
		
		
		public boolean book(BookingMiddleWare reserve) {
			boolean result=false;

			String sql = "INSERT INTO booking ( `Check_in_date`, `check_out_date`, `Booking_Status`, `No_of_Guest`,`Room_Type`,`User_Id`) VALUES(?,?,?,?,?,?)";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_luton", "root", "");
				PreparedStatement pstat=conn.prepareStatement(sql);

				
				pstat.setString(1, reserve.getCheckInDate());
				pstat.setString(2, reserve.getCheckOutdate());
				pstat.setString(3, reserve.getBookingStatus());
				pstat.setString(4, reserve.getNumberOfGuest());
				pstat.setString(5, reserve.getType());
				pstat.setInt(6, test.userid);
				pstat.executeUpdate(); 
				pstat.close();
				conn.close();
				result=true;
			}
			catch(Exception ex) {
				System.out.println("Error : "+ex.getMessage());
			}
			return result;
		}



}