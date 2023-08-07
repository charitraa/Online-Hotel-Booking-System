package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.print.attribute.HashPrintJobAttributeSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.toedter.calendar.JDateChooser;

import Middleware.UserMiddleWare;


public class MyBooking extends JFrame implements ActionListener {
	
	JButton edit , cancel, back;
	JTable datas ;
	DefaultTableModel model;
	JLabel noOfGuest,checkIndate,checkOutDate,roomType,prize;
	
	JComboBox type ,No;
	JTextField prise,id;
	JDateChooser in ,out ;
	public MyBooking() {
		Cursor cus = new Cursor(Cursor.HAND_CURSOR);
		
		setTitle("Veiw My booking");
		getContentPane().setBackground(Color.decode("#686A6C"));
		ImageIcon image = new ImageIcon("62fb3e321387b24cd8fd10a8_Hotel-logo.png");
		setIconImage(image.getImage());
		setSize(800,600);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		
		checkIndate = new JLabel("Check in date:");
		checkIndate.setForeground(Color.WHITE);
		checkIndate.setBounds(80,50,100,50);
		add(checkIndate);
		
		in = new JDateChooser();
		in.setBounds(170,60,150,30);
		add(in);
		
		
		
		checkOutDate = new JLabel("Check out date:");
		checkOutDate.setForeground(Color.WHITE);
		checkOutDate.setBounds(455,60,100,30);
		add(checkOutDate);	
		
		out = new JDateChooser();
		out.setBounds(560,60,150,30);
		add(out);
		
		
		roomType = new JLabel("Room Type:");
		roomType.setForeground(Color.WHITE);
		roomType.setBounds(80,120,100,50);
		add(roomType);	
		
		String typ[] = {"Single","Double","Twin"}; 
		type = new JComboBox(typ);
		type.setBounds(170,130,120,30);
		type.addActionListener(this);
		add(type);
		
	
		
		
		noOfGuest = new JLabel("No of guest:");
		noOfGuest.setForeground(Color.WHITE);
		noOfGuest.setBounds(320,120,100,50);
		add(noOfGuest);	
		
		String types[] = {"1","2","3","4","5"}; 
		No = new JComboBox(types);
		No.setBounds(400,130,100,30);
		add(No);
		
		prize = new JLabel("Price:");
		prize.setForeground(Color.WHITE);
		prize.setBounds(520,130,100,30);
		add(prize);	
		
		prise = new JTextField();
		prise.setBounds(570,130,100,30);
		prise.setEnabled(false);
		add(prise);
		
		id = new JTextField();
		id.setBounds(50,50,100,50);
		id.setVisible(false);
		add(id);
		
		back = new JButton("Back");
		back.setCursor(cus);
		back.setBounds(560,210,150,30);
		back.setFocusable(false);
		back.addActionListener(this);
		add(back);
		
		String column[]= {"Booking_Id","Check_in_date","check_out_date","Room_type","No_of_guest","Booking_Status","Room_No"};
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		datas = new JTable(model);
		datas.addMouseListener( new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
			int index = datas.getSelectedRow();
			id.setText(model.getValueAt(index,0).toString());
			((JTextField)in.getDateEditor().getUiComponent()).setText(model.getValueAt(index,1).toString());
			((JTextField)out.getDateEditor().getUiComponent()).setText(model.getValueAt(index,2).toString());
			type.setSelectedItem(model.getValueAt(index,3).toString());
			No.setSelectedItem(model.getValueAt(index,4).toString());
			
			
		
			}});
//		datas.setBounds(80,300,100,100);
		JScrollPane sp =  new JScrollPane(datas);
		sp.setBounds(80,280,635,250);
		add(sp);
		
		edit = new JButton("Update");
		edit.setBounds(80,210,150,30);
		edit.setFocusable(false);
		edit.setCursor(cus);
		edit.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() ==edit) {
					int bookid = Integer.parseInt(id.getText())  ;
					String checkindate = ((JTextField)in.getDateEditor().getUiComponent()).getText();

					String checkoutdate = ((JTextField)out.getDateEditor().getUiComponent()).getText();
					String ty = (String) type.getSelectedItem();
					String no = No.getSelectedItem().toString();
				
					int row = datas.getSelectedRow();
					if(row==-1) {
						JOptionPane.showMessageDialog(null, "please selected the row first");
					}
					model.setValueAt(checkindate,row,1);
					model.setValueAt(checkoutdate,row,2);
					model.setValueAt(ty,row,3);
					model.setValueAt(no,row,4);
					
					
					
					String sql = "UPDATE booking SET Check_in_date=?,`check_out_date`=?, `No_of_Guest`=?, `Room_Type`=? WHERE Booking_Id= ?";

					try {

					Class.forName("com.mysql.cj.jdbc.Driver");//load database driver

					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_luton", "root", "");

					PreparedStatement pstat=conn.prepareStatement(sql);

					pstat.setString(1, checkindate);

					pstat.setString(2, checkoutdate);

					pstat.setString(3, no);

					pstat.setString(4, ty);

					pstat.setInt(5, bookid);

					

					pstat.executeUpdate(); 

					pstat.close();

					conn.close();
					JOptionPane.showMessageDialog(null, "update table");
					

					}

					catch(Exception ex) {

					System.out.println("Error : "+ex.getMessage());
					JOptionPane.showMessageDialog(null, "No update table");
					

					}
				}
				
				
						
					
				}	
				
			
			});
		add(edit);
		
		
		cancel = new JButton("Cancel");
		cancel.setCursor(cus);
		cancel.setBounds(320,210,150,30);
		cancel.setFocusable(false);
		cancel.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(datas.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Please select a row" , "Error", JOptionPane.ERROR_MESSAGE);
				}
				int select = JOptionPane.showConfirmDialog(null, "Do you Want to delete this row", "Confirm", JOptionPane.YES_NO_OPTION);
				
				if(select  == JOptionPane.YES_OPTION) {
					model.removeRow(datas.getSelectedRow());
					String sql = "Delete FROM booking WHERE Booking_Id=?";
					int bookid = Integer.parseInt(id.getText())  ;
					try {

					Class.forName("com.mysql.cj.jdbc.Driver");//load database driver

					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_luton", "root", "");

					PreparedStatement pstat=conn.prepareStatement(sql);

					

					pstat.setInt(1, bookid);

					

					pstat.executeUpdate(); 

					pstat.close();

					conn.close();
					JOptionPane.showMessageDialog(null, "your booking has been cancel");
					

					}

					catch(Exception ex) {

					System.out.println("Error : "+ex.getMessage());

					}
				}
				datas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
					
				}
				
			
		
		}
		);
		add(cancel);
		
		

		String sql = "SELECT booking.Booking_Id,booking.Check_in_date, booking.check_out_date,booking.No_of_Guest,booking.Booking_Status,booking.Room_Type\r\n"
				+ "FROM user\r\n"
				+ "JOIN booking\r\n"
				+ "ON booking.User_Id = user.uid\r\n"
				+ "WHERE booking.User_Id = ? ";
		try {
//			UserMiddleWare user = new UserMiddleWare();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_luton", "root","");
			//PreparedStatement select = conn.prepareStatement(sql1);
			PreparedStatement pstat = conn.prepareStatement(sql);

			pstat.setInt(1,test.userid);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				String id = rs.getString("Booking_Id");
				String checkindate = rs.getString("Check_in_date");
				String checkoutdate = rs.getString("check_out_date");
				String type = rs.getString("Room_type");
				String Noofguest = rs.getString("No_of_guest");
				String BookingStatus = rs.getString("Booking_Status");
				model.addRow(new Object [] {id,checkindate,checkoutdate,type,Noofguest, BookingStatus});

				}
			rs.close();
			pstat.close();
			conn.close();
		}
		catch(Exception ex) {
			System.out.println("Error "+ ex.getMessage());
		}
		
		setVisible(true);
		validate();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyBooking();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comboBox = (String) type.getSelectedItem();
		if (comboBox.equals("Double")) {
			prise.setText("4000");
			}
			if (comboBox.equals("Single")) {
				prise.setText("2000");
			}
			if (comboBox.equals("Twin")) {
				prise.setText("6000");
			}
		// TODO Auto-generated method stub
		if(e.getSource()==back) {
			this.dispose();
			Booking book = new Booking();
			
		}
		
	
			
			
		}
		
		
		
	}




