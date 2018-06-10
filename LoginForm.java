package dbconnection;
import java.awt.Image;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import com.sun.javafx.tk.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.imageio.ImageIO;
import java.io.File;

public class LoginForm extends DBConnection{
 
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.frame.setVisible(true);
                  
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginForm() {
		 getData();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Registar Fakulteta Elektrotehnike");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(200, 200, 594, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 try{ 
			    frame.setIconImage(ImageIO.read(new File("img/fet.png")));
			  } 
			  catch (IOException e){
			    e.printStackTrace();
			  }
		 
		JLabel lblUniverzitetUTuzli = new JLabel("UNIVERZITET U TUZLI");
		lblUniverzitetUTuzli.setForeground(new Color(128, 0, 0));
		lblUniverzitetUTuzli.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblUniverzitetUTuzli.setBounds(268, 45, 241, 43);
		frame.getContentPane().add(lblUniverzitetUTuzli);
		
		JLabel lblFa = new JLabel("FAKULTET ELEKTROTEHNIKE");
		lblFa.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFa.setBounds(247, 82, 272, 43);
		frame.getContentPane().add(lblFa);
		
		JLabel label = new JLabel("");
		Image untz_logo1= new ImageIcon (this.getClass().getResource("/untz_logo1.jpg")).getImage();
		label.setIcon(new ImageIcon(untz_logo1));
		label.setBounds(50, 28, 144, 129);
		frame.getContentPane().add(label);
		
	    JLabel label_1 = new JLabel("");
		Image shield= new ImageIcon (this.getClass().getResource("/shield.jpg")).getImage();
		label_1.setIcon(new ImageIcon(shield));
		label_1.setBounds(12, 196, 236, 280);
		frame.getContentPane().add(label_1);
		
		JLabel lblUnesiteSvojeKorisnike = new JLabel("Unesite svoje korisni\u010Dke podatke");
		lblUnesiteSvojeKorisnike.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnesiteSvojeKorisnike.setBounds(302, 215, 253, 35);
		frame.getContentPane().add(lblUnesiteSvojeKorisnike);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(302, 269, 69, 17);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(302, 287, 193, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblifra = new JLabel("\u0160ifra");
		lblifra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblifra.setBounds(302, 321, 56, 16);
		frame.getContentPane().add(lblifra);
		
		
		JButton btnPrijaviSe = new JButton("Prijavi se");
		btnPrijaviSe.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
//Fetching the username and password				 
				try{
					
					String username=textField.getText().trim();
					char[] password = passwordField.getPassword();
				    String sql="select username,password from person where username='"+username+"'and password='"+password+"'";
				    rs = st.executeQuery(sql);
				    int count =0;
				    
                   //count represents how many matches were found
				    
				    while (rs.next()) {
				    	System.out.println("Uso");
				    	count=count+1;
				    }
				  //One match found -> proceed to dashboard
				    if (count==1) 
				    	JOptionPane.showMessageDialog(null, "User found, Access Granted");
				 // User with given username and password doesn't exist
				    else  
				    JOptionPane.showMessageDialog(null, "User doesn't exist");
				    
				    System.out.println(username);
				    System.out.println(password);
				        System.out.print(count);
				        System.out.println(rs.next());
				   }
				catch (Exception ex) {}
			}
		});
		btnPrijaviSe.setBounds(302, 386, 97, 25);
		frame.getContentPane().add(btnPrijaviSe);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(302, 340, 193, 22);
		frame.getContentPane().add(passwordField);
	}
}
