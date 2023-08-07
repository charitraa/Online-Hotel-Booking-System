

package GUI;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class HomePage extends JFrame implements ActionListener{
		JButton buttonSign,buttonRegister;//Declaration
		JLabel labelHotel ,labelSlogan,labelImage, slogan;
	public HomePage() {
		Cursor cus = new Cursor(Cursor.HAND_CURSOR);
		//Set the title of frame
		setTitle("Home Page");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set Size of Frame
		setSize(1600,1200);
		//set Layout 
		setLayout(null);
		setResizable(false);
		//Add image to the frame
		ImageIcon img = new ImageIcon("singapore_night_city_hotel_59558_1600x1200.jpg");
		labelImage = new JLabel();
		labelImage.setIcon(img);
		labelImage.setBounds(0,0,1600,1200);
		ImageIcon image = new ImageIcon("62fb3e321387b24cd8fd10a8_Hotel-logo.png");
		setIconImage(image.getImage());
		labelHotel = new JLabel("HOTEL LUTON");
		labelHotel.setBounds(100, 20, 300, 50);
		labelHotel.setFont(new Font("College", Font.BOLD,30));
		labelHotel.setForeground(Color.WHITE);
		
		buttonSign = new JButton("Sign in");
		buttonSign.setBounds(1200, 10, 100, 30);
		buttonSign.addActionListener(this);
		buttonSign.setFocusable(false);
		buttonSign.setFont(new Font("Comic Sans", Font.BOLD,18));
		buttonSign.setForeground(Color.WHITE);
		buttonSign.setBackground(Color.WHITE);
		buttonSign.setFocusPainted(false);
		buttonSign.setBorderPainted(false);
		buttonSign.setOpaque(false);
		buttonSign.setCursor(cus);
		
		buttonRegister = new JButton("Register");
		buttonRegister.setBounds(1300, 10, 130, 30);
		buttonRegister.addActionListener(this);
		buttonRegister.setFocusable(false);
		buttonRegister.setFont(new Font("Comic Sans", Font.BOLD,18));
		buttonRegister.setForeground(Color.WHITE);
		buttonRegister.setBackground(new Color(0,0,0,0));
		buttonRegister.setFocusPainted(false);
		buttonRegister.setBorderPainted(false);
		buttonRegister.setOpaque(false);
		buttonRegister.setCursor(cus);
		
		
		labelSlogan = new JLabel("<html> <p>Stay once, <br>carry memories forever.</p> </html>");
		labelSlogan.setBounds(100,300,300,200);
		labelSlogan.setFont(new Font("Comic Sans", Font.BOLD,30));
		labelSlogan.setForeground(Color.WHITE);
		
		slogan = new JLabel("<html> <p>See life from a <br> different perspective.</p> </html>");
		slogan.setBounds(1200,280,300,200);
		slogan.setFont(new Font("Comic Sans", Font.BOLD,30));
		slogan.setForeground(Color.WHITE);
		
		add(slogan);
		add(labelSlogan);
		add(buttonSign);
		add(buttonRegister);
		add(labelHotel);
		add(labelImage);
		
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buttonSign) {
			Login page = new Login();
			
		
		}
		if(e.getSource()==buttonRegister) {
			Noncorporate reg = new Noncorporate();
		}
		
	}
	
	public static void main(String[]args) {
		new HomePage();
		}

}
