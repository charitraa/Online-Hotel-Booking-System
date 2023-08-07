package GUI;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewCheckIn extends JFrame{
DefaultTableModel model;
JTable datas;
	public ViewCheckIn() {
		setTitle("Veiw Check In");
		ImageIcon image = new ImageIcon("62fb3e321387b24cd8fd10a8_Hotel-logo.png");
		setIconImage(image.getImage());

		setSize(1200,600);
		setResizable(false);
		String column[]= {"BookingID","Name","Country","Phone number","gender","check in date","check out date" ,"No of guest","Room No","Room type","Booking status"};
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		datas = new JTable(model);
		datas.setFont(new Font("times new roman", Font.PLAIN, 14));

		datas.setCellSelectionEnabled(true);
		datas.setSelectionBackground(Color.white);
		datas.setSelectionForeground(Color.black);
		datas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		datas.setFillsViewportHeight(true);
		String sql = "SELECT booking.Booking_Id, CONCAT(non_corporate.First_Name,\" \",non_corporate.Middle_Name,\" \",non_corporate.Last_Name)AS Name,non_corporate.Country,non_corporate.Phone_Number,"
				+ "non_corporate.Sex,booking.Check_in_date,booking.check_out_date,booking.No_of_Guest,booking.Room_Type,room.Room_No,booking.Booking_Status\r\n"
				+ "FROM non_corporate\r\n"
				+ "JOIN booking\r\n"
				+ "ON non_corporate.UserId =booking.User_Id\r\n"
				+"JOIN room\r\n"
				+ "ON booking.Booking_Id = room.Booking_Id\r\n"
				+ "WHERE booking.Booking_Status = ?";
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_luton", "root","");

			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1,"active");
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				String id = rs.getString("Booking_Id");
				String name = rs.getString("Name");
				String country = rs.getString("Country");
				String phone = rs.getString("Phone_Number");
				String gender = rs.getString("sex");
				
				String checkindate = rs.getString("Check_in_date");
				String checkoutdate = rs.getString("check_out_date");
				String type = rs.getString("Room_Type");
				String Noofguest = rs.getString("No_of_guest");
				String roomno = rs.getString("Room_No");
				String BookingStatus = rs.getString("Booking_Status");
				model.addRow(new Object [] {id,name,country,phone,gender,checkindate,checkoutdate,Noofguest,roomno,type, BookingStatus});
				}
			rs.close();
			pstat.close();
			conn.close();
		}
		catch(Exception ex) {
			System.out.println("Error "+ ex.getMessage());
		}
		JScrollPane sp =  new JScrollPane(datas);
		sp.setBounds(0,0,0,0);
		
		add(sp);
		setVisible(true);
		setLocationRelativeTo(null);
		setLayout(null);
	}
	public static void main(String[]args) {
		new ViewCheckIn();
	}
}
