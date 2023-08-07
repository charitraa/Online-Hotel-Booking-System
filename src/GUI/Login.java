package GUI;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.URI;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Middleware.*;
import JDBC.*;
public class Login extends JFrame implements ActionListener {

	JTextField txtUser;
	JPasswordField txtPass;
	JButton btnLogin, signup;
	JLabel log, user, pass,labelImge,or;
	JCheckBox show;
	
	public Login() {
		Cursor cus = new Cursor(Cursor.HAND_CURSOR);
		
		
		getContentPane().setBackground(Color.WHITE);
		setTitle("Login Page");
		setSize(400, 500);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon image = new ImageIcon("62fb3e321387b24cd8fd10a8_Hotel-logo.png");
		setIconImage(image.getImage());
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		
		ImageIcon img = new ImageIcon("loginIcon.png");
		labelImge = new JLabel();
		labelImge.setBounds(137,10,100,100);	
		labelImge.setIcon(img);
	
		log = new JLabel("Login");
		log.setBounds(147,90,100,80);
		log.setForeground(Color.BLACK);
		log.setFont(new Font("serif", Font.BOLD,30));
		
		user = new JLabel("Email");
		
		user.setBounds(90, 160, 100, 30);
		
		txtUser = new JTextField();
		txtUser.setToolTipText("Enter your Email");
		txtUser.setBounds(90, 190, 180, 30);

		
		pass = new JLabel("password");
		
		pass.setBounds(90,220,100,30);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(90, 255, 180, 30);
		txtPass.setToolTipText("Enter your password");

		
		show = new JCheckBox("Show Password");
		show.setBounds(150,285,120,30);
		show.addActionListener(ae -> {
			JCheckBox c = (JCheckBox) ae.getSource();
			txtPass.setEchoChar(c.isSelected() ? '\u0000' : (char) UIManager.get("PasswordField.echoChar"));
		});
		show.setBackground(Color.WHITE);
		show.setForeground(Color.BLACK);
		show.setFocusPainted(false);
		show.setBorderPainted(false);
		show.setOpaque(false);
		show.setCursor(cus);
		
		btnLogin=new JButton();
		btnLogin.addActionListener(this);
		btnLogin.setBackground(Color.decode("#6698FF"));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(90, 320, 180, 30);
		btnLogin.setText("Login");
		btnLogin.setCursor(cus);
		
		or = new JLabel("OR");
		or.setBounds(170,360,50,30);
		
		
		signup = new JButton("Continue with Facebook");
		signup.setBounds(100,390,170,30);
		signup.setFocusable(false);
		signup.setFont(new Font("serif", Font.BOLD,13));
		signup.setForeground(Color.BLACK);
		signup.setBackground(Color.WHITE);
		signup.setFocusPainted(false);
		signup.setBorderPainted(false);
		signup.setOpaque(false);
		signup.setCursor(cus);	
		signup.addActionListener(this);
		
		add(or);
		add(log);
		add(txtUser);
		add(txtPass);
		add(btnLogin);
		add(user);
		add(labelImge);
		add(pass);
		add(show);
		add(signup);
		setVisible(true);
		
		
	}

	public static void main(String[] args) {
		new Login(); //call constructor

	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnLogin) {
			
			UserMiddleWare user = new UserMiddleWare();
			Contollers control = new Contollers();
			user.setEmail(txtUser.getText());
			user.setPassword(txtPass.getText());
			control.setUser(user);
			control.login();
			control.login1();
			user = control.getUser();
			
			
			if(txtUser.getText().length()==0 && txtPass.getText().length()==0) {
				JOptionPane.showMessageDialog(null,"Pls enter your Email and Password");
			}
			else if(txtUser.getText().length()==0){
				JOptionPane.showMessageDialog(null,"Pls enter your Email");
			}
			else if (txtPass.getText().length()==0) {
				JOptionPane.showMessageDialog(null,"Pls enter your Password");
			}
			else if(user.getUid()>1) {
				test.userid = user.getUid();
				JOptionPane.showMessageDialog(this, "Welcome to hotel luton!");
				this.dispose();
				Booking book = new Booking();	
			}
			else if(user.getUid()==1) {
				
				JOptionPane.showMessageDialog(this, "Login Sucessfull");
				this.dispose();
				StaffDashboard staf = new StaffDashboard();
				
			}
			
			else {
				JOptionPane.showMessageDialog(this, "Error: user/password");
			}
			
		}
		
		
		if(e.getSource()==signup) {
			try {
				String url = "http://www.facebook.com";
				Desktop dt = Desktop.getDesktop();
				URI uri = new  URI(url);
				dt.browse(uri.resolve(uri));
		
			}
			catch(Exception ex) {
				System.out.println("you couldn't connect with facebook");
			}
		}
		
	}
	}
	

	