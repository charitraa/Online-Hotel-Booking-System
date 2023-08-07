package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Booking extends JFrame implements ActionListener {
	
	//Deceleration
	JLabel book,singleimage , doubleimage, twinimage, lsingle,ldouble,ltwin,fsingle,fdueo,ftwin;
	JButton view , logout, sinbook, dueobbok,twinbook;
	JPanel single , dueo, twin ;
	
	//creating methods
	public Booking() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("Booking Page");
		ImageIcon image = new ImageIcon("62fb3e321387b24cd8fd10a8_Hotel-logo.png");
		setIconImage(image.getImage());
		
		//SetJframe
		setSize(1000,800);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		Cursor cus = new Cursor(Cursor.HAND_CURSOR);
		
		
		
		
	
		book = new JLabel("Room Type");
		book.setFont(new Font("serif",Font.BOLD,40));
		book.setForeground(Color.WHITE);
		book.setBounds(420,30,200,50);
		
		single = new JPanel();
		single.setBackground(Color.WHITE);
		single.setBounds( 40,95,900,200);
		
		add(single);
		
		
		dueo = new JPanel();
		dueo.setBackground(Color.WHITE);
		dueo.setBounds( 40,320,900,200);
		dueo.setLayout(null);
		add(dueo);
		
		twin = new JPanel();
		twin.setBackground(Color.WHITE);
		twin.setBounds( 40,545,900,200);
		twin.setLayout(null);
		
		view = new JButton("My Booking");
		view.setBackground( Color.white);
		view.setBounds(40,50,100,30);
		view.setFocusable(false);
		view.addActionListener(this);
//		view.setOpaque(false);
		view.setCursor(cus);
		
		logout = new JButton("Logout");
		logout.setBackground( Color.white);
		logout.setBounds(840,50,100,30);
		logout.addActionListener(this);
		logout.setFocusable(false);
		logout.setCursor(cus); 
		
		singleimage = new JLabel();
		singleimage.setBounds(10,0,300,200);
		ImageIcon img = new ImageIcon("images (1).jpeg");
		singleimage.setIcon(img);
		single.setLayout(null);
		single.add(singleimage);
		
		lsingle = new JLabel("Single Bed");
		lsingle.setBounds(400,10,150,50);
		lsingle.setFont(new Font("serif",Font.BOLD,30));
		single.add(lsingle);
		
		fsingle = new JLabel("<html> <p> ONE BED <br> ONE LED TV AND FREE WIFI <br> ATTACHED TOILET BATHROOM WITH HOT WATER <br> Price:2000 </p> </html>");
		fsingle.setBounds(400,10,250,200);
		single.add(fsingle);
		
		doubleimage = new JLabel();
		doubleimage.setBounds(10,0,300,200);
		ImageIcon imgs = new ImageIcon("Untitled design (2).png");
		doubleimage.setIcon(imgs);
		dueo.setLayout(null);
		dueo.add(doubleimage);
		ldouble = new JLabel("Double Bed");
		ldouble.setBounds(400,10,200,50);
		ldouble.setFont(new Font("serif",Font.BOLD,30));
		dueo.add(ldouble);
		fdueo = new JLabel("<html> <p> ONE QUEEN SIZE BED <br> ONE LED TV AND FREE WIFI <br> ATTACHED TOILET BATHROOM WITH JACUZZI <br> Price:4000  </p> </html>");
		fdueo.setBounds(400,10,250,200);
		dueo.add(fdueo);
		
		
		twinimage = new JLabel();
		twinimage.setBounds(10,0,300,200);
		ImageIcon imgss = new ImageIcon("Untitled design (3).png");
		twinimage.setIcon(imgss);
		twin.setLayout(null);
		twin.add(twinimage);
		ltwin = new JLabel("Twin Bed");
		ltwin.setBounds(400,10,150,50);
		ltwin.setFont(new Font("serif",Font.BOLD,30));
		twin.add(ltwin);
		ftwin = new JLabel("<html> <p> TWO QUEEN SIZE BED <br> SOFA BALCONY VIEW <bc>ONE LED TV AND FREE WIFI <br> ATTACHED TOILET BATHROOM WITH JACUZZI AND A BATH TUB <br> Price:8000  </p> </html>");
		ftwin.setBounds(400,10,250,200);
		twin.add(ftwin);
		
		sinbook = new JButton("Book Now");
		sinbook.setBounds(700,60,150,50);
		
		sinbook.setFocusable(false);
		sinbook.setBackground( Color.decode("#5ADEFE"));
		sinbook.addActionListener(this);
		sinbook.setCursor(cus);
		single.add(sinbook);
		
		dueobbok = new JButton("Book Now");
		dueobbok.setBounds(700,60,150,50);
		dueobbok.setBackground( Color.decode("#5ADEFE"));
		dueobbok.addActionListener(this);
		dueobbok.setFocusable(false);
		dueobbok.setCursor(cus);
		dueo.add(dueobbok);
		
		twinbook = new JButton("Book Now");
		twinbook.setBounds(700,60,150,50);
		twinbook.addActionListener(this);
		twinbook.setBackground( Color.decode("#5ADEFE"));
		twinbook.setFocusable(false);
		twinbook.setCursor(cus);
		twin.add(twinbook);
		
		
		add(twin);
		add(book);
		add(view);
		add(logout);
		
		setVisible(true);
	}
	//main methods
	public static void main(String[] args) {
		new Booking();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==logout) {
			this.dispose();
			HomePage home = new HomePage();
			Login log = new Login();
			
		}
		if(e.getSource()==sinbook) {
			Single sin = new Single();
		}
		
		if(e.getSource()==dueobbok) {
			Dueo doub = new Dueo();
		}
		
		if(e.getSource()==twinbook) {
			Twin  twin= new Twin();
		}
		
		if(e.getSource()==view) {
			this.dispose();
			MyBooking vewin = new MyBooking();
		}
	}

}
