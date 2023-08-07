package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;


public class StaffDashboard extends JFrame implements ActionListener{

JButton viewCheckin;

JButton viewCheckout;

JButton managecheckoutView;

JButton managecheckout;

JTextField roomType ,id;

JComboBox roomNumber;
JMenuBar menubar  ;
DefaultTableModel buub,buub22,bob,bobi;
JMenu corporate , nonCorporate;
JTable lol ,lol22,vivik,lie;
JComboBox roomNumber2;
JButton five;
JButton six;
JTextField roomType2;
JButton two;
JButton three;
	StaffDashboard(){
		Cursor cus = new Cursor(Cursor.HAND_CURSOR);
		ImageIcon image = new ImageIcon("62fb3e321387b24cd8fd10a8_Hotel-logo.png");
		setIconImage(image.getImage());
		//tabbed pane mathi ko corporate non corporate
JTabbedPane mainPane= new JTabbedPane();
mainPane.setBounds(0,0,1600,1200);

setTitle("Manager Dashboard");
// first panel for non corporate stored inside mainPane JTabbed pane
JPanel custTabPane= new JPanel();
custTabPane.setBackground(Color.gray);
JLabel manpanlabel= new JLabel("MANAGER DASHBOARD");
custTabPane.setBackground(Color.black);
manpanlabel.setBounds(240,40,1600,70);

manpanlabel.setForeground(Color.white);

manpanlabel.setFont(new Font("times new roman",Font.BOLD,80));

//
JTabbedPane tab= new JTabbedPane();


///CHECK IN PANEL INSIDE TAB PANE
JPanel checkInPanel= new JPanel();

JLabel custty= new JLabel("Room Type :");

custty.setFont(new Font("times new roman",Font.BOLD,18));

custty.setForeground(Color.white);

custty.setBounds(80,30,150,40);

checkInPanel.add(custty);

roomType= new JTextField();

roomType.setBounds(205,30,180,40);

roomType.setFont(new Font("times new roman",Font.BOLD,18));


JLabel hh= new JLabel("Room Number :");

hh.setFont(new Font("times new roman",Font.BOLD,18));

hh.setForeground(Color.white);

hh.setBounds(410,30,150,40);

checkInPanel.add(hh);
//booking id
id =new JTextField();
id.setBounds(10,10,10,10);
id.setVisible(false);
add(id);


roomNumber= new JComboBox();

roomNumber.setBounds(570,30,180,40);

roomNumber.setFont(new Font("times new roman",Font.BOLD,18));


viewCheckin= new JButton("VIEW-IN-GUEST");
viewCheckin.setCursor(cus);

viewCheckin.setBounds(820,30,220,40);
viewCheckin.addActionListener( new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new ViewCheckIn();
		
	}
});

viewCheckin.setFocusPainted(false);

viewCheckin.setForeground(Color.white);

viewCheckin.setBackground(Color.black);
viewCheckin.addActionListener(this);

viewCheckout= new JButton("CHECK-IN-GUEST");
viewCheckout.setCursor(cus);

viewCheckout.setBounds(1100,30,220,40);

viewCheckout.setForeground(Color.white);

viewCheckout.setBackground(Color.black);

viewCheckout.setFocusPainted(false);
viewCheckout.addActionListener( new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==viewCheckout) {
			int boid=Integer.parseInt(id.getText());

			String roomid=roomNumber.getSelectedItem().toString();
			
			String sqkl = "update room set Room_Status =? , Booking_Id = ? where Room_No = ?";
			String upl = "update booking set Booking_Status=? where Booking_Id=?";

			try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_luton", "root",

			"");

			PreparedStatement pstat = conn.prepareStatement(sqkl);

			PreparedStatement pstat2 = conn.prepareStatement(upl);

			

			pstat.setString(1,"booked");

			pstat.setString(3,roomid);
			
			pstat.setInt(2, boid
					);
			
			pstat2.setString(1,"active");

			pstat2.setInt(2, boid);

			pstat2.executeUpdate();

			pstat.executeUpdate();

			pstat2.close();

			pstat.close();

			conn.close();

			
			buub.removeRow(lol.getSelectedRow());
			JOptionPane.showMessageDialog(null,"Sucessfully checked in","room",JOptionPane.PLAIN_MESSAGE);
			roomNumber.setToolTipText("");
			roomType.setText("");
			} catch (Exception ex) {

			System.out.println("Error " + ex.getMessage());

			}
		
	}
}});
String[] bubly = { "BookingID","Name","Country","Phone number","gender","check in date","check out date" ,"No of guest","Room type","Booking status"};

 buub = new DefaultTableModel();

buub.setColumnIdentifiers(bubly);
 lol = new JTable(buub); 
 buub.fireTableDataChanged();
JScrollPane vob = new JScrollPane(lol);
lol.addMouseListener( new MouseAdapter() {
public void mouseClicked(MouseEvent arg0) {
	int index = lol.getSelectedRow();	
	roomType.setText(buub.getValueAt(index,8).toString());
	id.setText(buub.getValueAt(index,0).toString());
	String sql1 = "SELECT * FROM room WHERE Room_Type = ? AND Room_Status = ?";

try {
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_luton", "root", "");
		PreparedStatement pstat = conn.prepareStatement(sql1);
		pstat.setString(1, roomType.getText());
		pstat.setString(2, "Not Book");
		ResultSet rs = pstat.executeQuery();
		
		while(rs.next()) {
			String rom = rs.getString("Room_No");
			roomNumber.addItem(rom);
		}
		rs.close();
		pstat.close();
		conn.close();
	}
	catch(Exception ex) {
		System.out.println("Error "+ ex.getMessage());
	}
}
});
String sql = "SELECT booking.Booking_Id, CONCAT(non_corporate.First_Name,\" \",non_corporate.Middle_Name,\" \",non_corporate.Last_Name)AS Name,non_corporate.Country,non_corporate.Phone_Number,"
		+ "non_corporate.Sex,booking.Check_in_date,booking.check_out_date,booking.No_of_Guest,booking.Room_Type,booking.Booking_Status\r\n"
		+ "FROM non_corporate\r\n"
		+ "JOIN booking\r\n"
		+ "ON non_corporate.UserId =booking.User_Id\r\n"
		+ "WHERE booking.Booking_Status = ?";
try {
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_luton", "root","");

	PreparedStatement pstat = conn.prepareStatement(sql);
	pstat.setString(1,"pending");
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
		String BookingStatus = rs.getString("Booking_Status");
		buub.addRow(new Object [] {id,name,country,phone,gender,checkindate,checkoutdate,Noofguest,type, BookingStatus});
		}
	rs.close();
	pstat.close();
	conn.close();
}
catch(Exception ex) {
	System.out.println("Error "+ ex.getMessage());
}

lol.setFont(new Font("times new roman", Font.PLAIN, 14));

lol.setCellSelectionEnabled(true);

lol.setSelectionBackground(Color.white);

lol.setSelectionForeground(Color.black);

// -----------------------------------------------------------------------------------------------------------
lol.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
lol.setFillsViewportHeight(true);
vob.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
vob.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
vob.setBounds(30, 100, 1445, 450);
checkInPanel.add(vob);

checkInPanel.add(roomNumber);

checkInPanel.add(roomType);

checkInPanel.add(viewCheckin);

checkInPanel.add(viewCheckout);

checkInPanel.setLayout(null);

checkInPanel.setBackground(Color.gray);



JPanel checkOutPanel= new JPanel();

managecheckout= new JButton("CHECK-OUT-GUEST");
managecheckout.setCursor(cus);

managecheckout.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource()==managecheckout) {
			int bid=Integer.parseInt(id.getText());

			String upl = "update booking set Booking_Status= ? where Booking_Id= ?";


			try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_luton", "root",

			"");
			PreparedStatement pstat2 = conn.prepareStatement(upl);
			pstat2.setString(1,"check out");
			pstat2.setInt(2, bid);
			pstat2.executeUpdate();
			
			buub22.removeRow(lol22.getSelectedRow());
			JOptionPane.showMessageDialog(null,"Sucessfully checked out ");
			
			
			} catch (Exception ex) {
				
				JOptionPane.showMessageDialog(null,"unsucessfull check out ");
			System.out.println("Error " + ex.getMessage());

			}
	}
	}
	}

);
managecheckout.setBounds(300,30,220,40);

managecheckout.setFocusPainted(false);

managecheckout.setForeground(Color.black);

managecheckout.setBackground(Color.lightGray);


managecheckoutView= new JButton("VIEW-CHECK-OUT");
managecheckoutView.setCursor(cus);

managecheckoutView.setBounds(600,30,220,40);

managecheckoutView.setFocusPainted(false);
managecheckoutView.addActionListener( new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new VeiwCheckout();
		
	}
});

managecheckoutView.setForeground(Color.black);

managecheckoutView.setBackground(Color.lightGray);


String[] bible44= {"BookingID","Name","Country","Phone number","gender","check in date","check out date" ,"No of guest","Room No","Room type","Booking status" };

 buub22 = new DefaultTableModel();

buub22.setColumnIdentifiers(bible44);
buub22.fireTableDataChanged();

lol22 = new JTable(buub22);

JScrollPane vob2 = new JScrollPane(lol22);

lol22.addMouseListener( new MouseAdapter() {
public void mouseClicked(MouseEvent arg0) {
	int index = lol22.getSelectedRow();	
	
	id.setText(buub22.getValueAt(index,0).toString());
	
}});




lol22.setFont(new Font("times new roman", Font.PLAIN, 14));

lol22.setCellSelectionEnabled(true);

lol22.setSelectionBackground(Color.white);

lol22.setSelectionForeground(Color.black);

// -----------------------------------------------------------------------------------------------------------

lol22.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

lol22.setFillsViewportHeight(true);

vob2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

vob2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

vob2.setBounds(30, 100, 1445, 450);

String sql1 = "SELECT booking.Booking_Id, CONCAT(non_corporate.First_Name,\" \",non_corporate.Middle_Name,\" \",non_corporate.Last_Name)AS Name,non_corporate.Country,non_corporate.Phone_Number,"
		+ "non_corporate.Sex,booking.Check_in_date,booking.check_out_date,booking.No_of_Guest,booking.Room_Type,room.Room_No,booking.Booking_Status\r\n"
		+ "FROM non_corporate\r\n"
		+ "JOIN booking\r\n"
		+ "ON non_corporate.UserId =booking.User_Id\r\n"
		+"JOIN room\r\n"
		+ "ON booking.Booking_Id = room.Booking_Id\r\n"
		+ "WHERE booking.Booking_Status = ?";
try {
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_luton", "root","");

	PreparedStatement pstat = conn.prepareStatement(sql1);
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
		buub22.addRow(new Object [] {id,name,country,phone,gender,checkindate,checkoutdate,Noofguest,roomno,type, BookingStatus});
		}
	rs.close();
	pstat.close();
	conn.close();
}
catch(Exception ex) {
	System.out.println("Error "+ ex.getMessage());
}


checkOutPanel.add(vob2);

checkOutPanel.add(managecheckoutView);

checkOutPanel.add(managecheckout);

checkOutPanel.setLayout(null);

checkOutPanel.setBackground(Color.darkGray);

tab.setBounds(10,160,1510,620);

tab.add(checkInPanel,"checkin");

tab.add(checkOutPanel,"checkout");
custTabPane.add(tab);


custTabPane.add(manpanlabel);

custTabPane.setLayout(null);


JPanel corpoTabPane= new JPanel();
corpoTabPane.setBackground(Color.LIGHT_GRAY);
JLabel man= new JLabel("MANAGER DASHBOARD");
man.setBounds(350,50,1600,60);
man.setFont(new Font("times new roman",Font.BOLD,80));
corpoTabPane.add(man);

JTabbedPane corptab2= new JTabbedPane();
corptab2.setBounds(10,140,1510,640);
JPanel panelOne= new JPanel();
panelOne.setBackground(Color.gray);

String[] prop = {"BookingID","Name","Country","Phone number","Credit card","check in date","check out date" ,"No of guest","Room type","Booking status" };

 bob = new DefaultTableModel();
bob.fireTableDataChanged();
bob.setColumnIdentifiers(prop);
 vivik = new JTable(bob);
 vivik.addMouseListener( new MouseAdapter() {
	 public void mouseClicked(MouseEvent arg0) {
	 	int index = vivik.getSelectedRow();	
	 	roomType2.setText(bob.getValueAt(index,8).toString());
	 	id.setText(bob.getValueAt(index,0).toString());
	 	String sql1 = "SELECT * FROM room WHERE Room_Type = ? AND Room_Status = ?";

	 try {
	 		
	 		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_luton", "root", "");
	 		PreparedStatement pstat = conn.prepareStatement(sql1);
	 		pstat.setString(1, roomType2.getText());
	 		pstat.setString(2, "Not Book");
	 		ResultSet rs = pstat.executeQuery();
	 		
	 		while(rs.next()) {
	 			String rom = rs.getString("Room_No");
	 			roomNumber2.addItem(rom);
	 		}
	 		rs.close();
	 		pstat.close();
	 		conn.close();
	 	}
	 	catch(Exception ex) {
	 		System.out.println("Error "+ ex.getMessage());
	 	}
	 }
	 });
 
 String sql12 = "SELECT booking.Booking_Id,corporate.Company_Name,corporate.Country,corporate.Phone_Number,corporate.Credit_Card_No,booking.Check_in_date,booking.check_out_date,booking.No_of_Guest,booking.Room_Type,booking.Booking_Status\r\n"
 		+ "FROM corporate\r\n"
 		+ "JOIN booking\r\n"
 		+ "ON corporate.UserId=booking.User_Id\r\n"
 		+ "WHERE booking.Booking_Status = ? ";
 try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_luton", "root","");

		PreparedStatement pstat = conn.prepareStatement(sql12);
		pstat.setString(1,"pending");
		ResultSet rs = pstat.executeQuery();
		while (rs.next()) {
			String id = rs.getString("Booking_Id");
			String name = rs.getString("Company_Name");
			String country = rs.getString("Country");
			String phone = rs.getString("Phone_Number");
			String gender = rs.getString("Credit_Card_No");
			
			String checkindate = rs.getString("Check_in_date");
			String checkoutdate = rs.getString("check_out_date");
			String type = rs.getString("Room_Type");
			String Noofguest = rs.getString("No_of_guest");
		
			String BookingStatus = rs.getString("Booking_Status");
			bob.addRow(new Object [] {id,name,country,phone,gender,checkindate,checkoutdate,Noofguest,type, BookingStatus});
			}
		rs.close();
		pstat.close();
		conn.close();
	}
	catch(Exception ex) {
		System.out.println("Error "+ ex.getMessage());
	}

JScrollPane vobb3 = new JScrollPane(vivik);

vivik.setFont(new Font("times new roman", Font.PLAIN, 14));

vivik.setCellSelectionEnabled(true);

vivik.setSelectionBackground(Color.white);

vivik.setSelectionForeground(Color.black);

// -----------------------------------------------------------------------------------------------------------

vivik.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

vivik.setFillsViewportHeight(true);

vobb3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

vobb3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

vobb3.setBounds(30, 100, 1445, 450);
panelOne.add(vobb3);

JLabel roomkoNumber=  new JLabel("Room Number :");

roomkoNumber.setFont(new Font("times new roman", Font.BOLD, 20));
roomkoNumber.setForeground(Color.black);
roomkoNumber.setBounds(120,20,180,40);



roomNumber2= new JComboBox();
roomNumber2.setBounds(300,20,180,40);
panelOne.add(roomNumber2);
panelOne.add(roomkoNumber);
panelOne.setLayout(null);

JLabel ty=  new JLabel("Room Type :");

ty.setFont(new Font("times new roman", Font.BOLD, 20));
ty.setForeground(Color.black);
ty.setBounds(510,20,180,40);
panelOne.add(ty);

roomType2= new JTextField();
roomType2.setBounds(650,20,180,40);
panelOne.add(roomType2);

two= new JButton("Check In");
two.addActionListener( new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==two) {
			int boid=Integer.parseInt(id.getText());

			String roomid=roomNumber2.getSelectedItem().toString();
			
			String sqkl = "update room set Room_Status =? , Booking_Id = ? where Room_No = ?";
			String upl = "update booking set Booking_Status=? where Booking_Id=?";

			try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_luton", "root",

			"");

			PreparedStatement pstat = conn.prepareStatement(sqkl);

			PreparedStatement pstat2 = conn.prepareStatement(upl);

			

			pstat.setString(1,"booked");

			pstat.setString(3,roomid);
			
			pstat.setInt(2, boid
					);
			
			pstat2.setString(1,"active");

			pstat2.setInt(2, boid);

			pstat2.executeUpdate();

			pstat.executeUpdate();

			pstat2.close();

			pstat.close();

			conn.close();

			
			bob.removeRow(vivik.getSelectedRow());
			JOptionPane.showMessageDialog(null,"Sucessfully checked in","room",JOptionPane.PLAIN_MESSAGE);
			roomNumber.setToolTipText("");
			roomType.setText("");
			} catch (Exception ex) {

			System.out.println("Error " + ex.getMessage());

			}
		
	}
}});
two.setCursor(cus);
two.setBounds(850,20,150,40);
two.setBackground(Color.black);
two.setForeground(Color.white);
two.setFont(new Font("times new roman", Font.BOLD, 20));
panelOne.add(two);

three= new JButton("Veiw Check In");
three.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CorporateVeiwCheckIn check = new CorporateVeiwCheckIn();
		
	}
});
three.setCursor(cus);
three.setBounds(1020,20,250,40);
three.setBackground(Color.black);
three.setForeground(Color.white);
three.setFont(new Font("times new roman", Font.BOLD, 20));
panelOne.add(three);




JPanel panelTwo= new JPanel();
panelTwo.setBackground(Color.gray);

String[] propper = {"BookingID","Name","Country","Phone number","gender","check in date","check out date" ,"No of guest","Room No","Room type","Booking status" };

bobi = new DefaultTableModel();

bobi.setColumnIdentifiers(propper);
bobi.fireTableDataChanged();
 lie = new JTable(bobi);
 lie.addMouseListener( new MouseAdapter() {
	 public void mouseClicked(MouseEvent arg0) {
	 	int index = lie.getSelectedRow();	
	 	
	 	id.setText(bobi.getValueAt(index,0).toString());
	 	
	 }});

 
 String sql0 =  "SELECT booking.Booking_Id,corporate.Company_Name,corporate.Country,corporate.Phone_Number,corporate.Credit_Card_No,booking.Check_in_date,booking.check_out_date,booking.No_of_Guest,booking.Room_Type,booking.Booking_Status,room.Room_No\r\n"
	 		+ "FROM corporate\r\n"
	 		+ "JOIN booking\r\n"
	 		+ "ON corporate.UserId=booking.User_Id\r\n"
	 		+"JOIN room\r\n"
			+ "ON booking.Booking_Id = room.Booking_Id\r\n"
	 		
	 		+ "WHERE booking.Booking_Status = ? ";
	try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_luton", "root","");

		PreparedStatement pstat = conn.prepareStatement(sql0);
		pstat.setString(1,"active");
		ResultSet rs = pstat.executeQuery();
		while (rs.next()) {
			String id = rs.getString("Booking_Id");
			String name = rs.getString("Company_Name");
			String country = rs.getString("Country");
			String phone = rs.getString("Phone_Number");
			String gender = rs.getString("Credit_Card_No");
			
			String checkindate = rs.getString("Check_in_date");
			String checkoutdate = rs.getString("check_out_date");
			String type = rs.getString("Room_Type");
			String roomno = rs.getString("Room_No");
			String Noofguest = rs.getString("No_of_guest");
			String BookingStatus = rs.getString("Booking_Status");
			bobi.addRow(new Object [] {id,name,country,phone,gender,checkindate,checkoutdate,Noofguest,type,roomno, BookingStatus});
			}
		rs.close();
		pstat.close();
		conn.close();
	}
	catch(Exception ex) {
		System.out.println("Error "+ ex.getMessage());
	}

JScrollPane nnnn = new JScrollPane(lie);

lie.setFont(new Font("times new roman", Font.PLAIN, 14));

lie.setCellSelectionEnabled(true);

lie.setSelectionBackground(Color.white);

lie.setSelectionForeground(Color.black);

// -----------------------------------------------------------------------------------------------------------

lie.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
lie.setFillsViewportHeight(true);

nnnn.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

nnnn.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

nnnn.setBounds(30, 100, 1445, 450);
panelTwo.add(nnnn);
 
five= new JButton(" check out");
five.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource()==five) {
			int bid=Integer.parseInt(id.getText());

			String upl = "update booking set Booking_Status= ? where Booking_Id= ?";


			try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_luton", "root",

			"");
			PreparedStatement pstat2 = conn.prepareStatement(upl);
			pstat2.setString(1,"check out");
			pstat2.setInt(2, bid);
			pstat2.executeUpdate();
			
			bobi.removeRow(lie.getSelectedRow());
			JOptionPane.showMessageDialog(null,"Sucessfully checked out ");
			
			
			} catch (Exception ex) {
				
				JOptionPane.showMessageDialog(null,"unsucessfull check out ");
			System.out.println("Error " + ex.getMessage());

			}
	}
	}
	}

);
five.setCursor(cus);
five.setBounds(240,40,180,40);
five.setBackground(Color.black);
five.setForeground(Color.white);
five.setFont(new Font("times new roman", Font.BOLD, 20));
panelTwo.add(five);

six= new JButton(" Veiw check out");

six.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CorporateVeiwCheckOut veiw = new CorporateVeiwCheckOut();
	}
});
six.setCursor(cus);
six.setBounds(430,40,180,40);
six.setBackground(Color.black);
six.setForeground(Color.white);
six.setFocusable(false);
six.setFont(new Font("times new roman", Font.BOLD, 20));
panelTwo.add(six);
panelTwo.setLayout(null);
corptab2.add(panelOne,"check In");
corptab2.add(panelTwo,"check out");





corpoTabPane.add(corptab2);
corpoTabPane.setLayout(null);
	
	
	 
		
	
		
	mainPane.add(custTabPane,"Non-Corporate");
	mainPane.add(corpoTabPane,"Corporate");
add(mainPane);		
		
setSize(1600,1200);

setLayout(null);

setVisible(true);
	}

	
	public static void main(String []args) {
		new StaffDashboard();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
