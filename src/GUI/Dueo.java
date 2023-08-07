package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import JDBC.Jdbc;
import Middleware.BookingMiddleWare;


public class Dueo extends JFrame implements ActionListener {
	
	
	JLabel booking, roomtype, checkin, checkout, room, number,prize;
	JDateChooser  checkindate , checkoutdate;
	JButton book , back;
	JTextField type,prise;
	JComboBox num,rooms;
	public Dueo() {
		getContentPane().setBackground(Color.decode("#93917C"));
		Cursor cus = new Cursor(Cursor.HAND_CURSOR);
		setTitle("Double booking page");
		setSize(500,500);
		setLayout(null);
		setUndecorated(true);
		booking = new JLabel("Booking Page");
		booking.setBounds(180,40,150,50);
		booking.setFont( new Font("serif",Font.BOLD,25));
		add(booking);
		
		roomtype = new JLabel("Room Type:");
		roomtype.setBounds(80,120,100,30);
		add(roomtype);
		
		checkin = new JLabel("Check In Date:");
		checkin.setBounds(80,170,100,30);
		add(checkin);
		
		checkout = new JLabel("Check Out Date:");
		checkout.setBounds(80,220,150,30);
		add(checkout);
	
		type = new JTextField("Double");
		type.setBounds(160,120,100,30);
		type.setEnabled(false);
		add(type);
		
		checkindate = new JDateChooser();
		checkindate.setBounds(170,170,150,30);
		add(checkindate);
		
		
		checkoutdate = new JDateChooser();
		checkoutdate.setBounds(180,220,150,30);
		add(checkoutdate);
		
		

		
		
		book = new JButton("Book");
		book.setCursor(cus);
		book.setBackground(Color.WHITE);
		book.setBounds(80,390,150,30);
		book.addActionListener(this);
		add(book);
		
		back = new JButton("Back");
		back.setCursor(cus);
		back.setBackground(Color.WHITE);
		back.setBounds(260,390,150,30);
		back.addActionListener(this);
		add(back);
		
		number = new JLabel("Number of Guest:");
		number.setBounds(80,270,150,30);
		add(number);
		
		String typ[] = {"1","2","3","4","5"}; 
		num = new JComboBox(typ);
		num.setBounds(190,270,120,30);
		add(num);
		
		prize = new JLabel("Prize:");
		prize.setBounds(80,320,150,30);
		add(prize);
		
		prise = new JTextField(" 4000");
		prise.setEnabled(false);
		prise.setBounds(130,320,100,30);
		add(prise);
		
		setVisible(true);
		setLocationRelativeTo(null);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==book) {
			
			int id = 0;
			String number = num.getSelectedItem().toString();
			String checkin = ((JTextField)checkindate.getDateEditor().getUiComponent()).getText();
			String checkout =((JTextField)checkoutdate.getDateEditor().getUiComponent()).getText();
			String bookingstatus = "pending";
			String RoomType = type.getText();
			
			BookingMiddleWare booking = new BookingMiddleWare(id, number,checkin,checkout,bookingstatus, RoomType);
			boolean result = new Jdbc().book(booking);	
			if (result ==true) {

			JOptionPane.showMessageDialog(null, "Booking sucessfull");
			this.dispose();
			} else {

			JOptionPane.showMessageDialog(null, "Failed to Book");

			}
			
			}
		if(e.getSource()==back) {
			this.dispose();
		}
		
	}
	public static void main(String[]args) {
		new Dueo();
	}

}