package login;

import javax.swing.*;
import javax.swing.border.Border;

import admin_page.admin_page;
import db.db;

import java.util.Random;
import java.awt.event.*;
import java.awt.*;
import reserve.*;
import register.register;


public class login extends JFrame implements ActionListener{
	JFrame fl;
	 JTabbedPane tp; 
	Random randotp=new Random();
	JPanel main,log,head1,bt,ad;
	JLabel head,cn,phone,pass,heading,info,namead,numberad,idd;
	public static JTextField name,namea,id;
	JTextField number,numbera;
	JPasswordField password;
	JButton submit,send,submita;
	int otp;
	public static String custnam;
	public login()
	{
		fl=new JFrame("login");
		 tp=new JTabbedPane();  
		   
		main=new JPanel();
		ad=new JPanel();
		log=new JPanel();
		bt=new JPanel();
		
		head=new JLabel("LOGIN");
		heading=new JLabel(" PRP RESTAURANT");
		info=new JLabel("Enter the neccessary details");
		head1=new JPanel();
		
		Color customColor1=new Color(234, 237, 237);
		Color customColor2=new Color(46, 64, 83);
		Color customColor3=new Color(46, 64, 83 );
		Font font=new Font("Monospaced",Font.BOLD,55);
		head.setFont(font);
		head.setForeground(customColor1);
		heading.setFont(font);
		heading.setForeground(customColor1);
	
		Font fontl=new Font("Monospaced ",Font.BOLD,15);
		
		head.setVerticalAlignment(JLabel.CENTER);
		head.setHorizontalAlignment(JLabel.CENTER);
		heading.setVerticalAlignment(JLabel.CENTER);
		heading.setHorizontalAlignment(JLabel.CENTER);
		
		cn=new JLabel("CUSTOMER NAME:");
		cn.setVerticalAlignment(JLabel.CENTER);
		cn.setHorizontalAlignment(JLabel.CENTER);
		cn.setFont(fontl);
		
		phone=new JLabel("PHONE:");
		phone.setVerticalAlignment(JLabel.CENTER);
		phone.setHorizontalAlignment(JLabel.CENTER);
		phone.setFont(fontl);
		
		namead=new JLabel("ADMIN NAME:");
		namead.setVerticalAlignment(JLabel.CENTER);
		namead.setHorizontalAlignment(JLabel.CENTER);
		namead.setFont(fontl);
		
		idd=new JLabel("ADMIN ID:");
		idd.setVerticalAlignment(JLabel.CENTER);
		idd.setHorizontalAlignment(JLabel.CENTER);
		idd.setFont(fontl);
		
		numberad=new JLabel("PHONE:");
		numberad.setVerticalAlignment(JLabel.CENTER);
		numberad.setHorizontalAlignment(JLabel.CENTER);
		numberad.setFont(fontl);
		
		pass=new JLabel("OTP:");
		pass.setVerticalAlignment(JLabel.CENTER);
		pass.setHorizontalAlignment(JLabel.CENTER);
		pass.setFont(fontl);
		
		
		head1.setBackground(customColor3);
		head1.setBounds(0,0,750,150);
		head1.setLayout(new GridBagLayout());
		GridBagConstraints gb1=new GridBagConstraints();
		gb1.insets=new Insets(1,1,1,1);
		gb1.gridx=0;
		gb1.gridy=0;
		head1.add(heading,gb1);
		gb1.gridx=0;
		gb1.gridy=1;
		head1.add(head,gb1);
		
		
		name=new JTextField(20);
		name.setFont(fontl);
		number=new JTextField(20);
		number.setFont(fontl);
		namea=new JTextField(20);
		namea.setFont(fontl);
		numbera=new JTextField(20);
		numbera.setFont(fontl);
		id=new JTextField(20);
		id.setFont(fontl);
		password=new JPasswordField(20);
		password.setFont(fontl);
		submit=new JButton("submit");
		submita=new JButton("submit");
		submit.setBackground(customColor2);
		submit.setForeground(customColor1);
		submit.addActionListener(this);
		submita.setBackground(customColor2);
		submita.setForeground(customColor1);
		submita.addActionListener(this);
		send=new JButton("send otp");
		send.setBackground(customColor2);
		send.setForeground(customColor1);
		send.addActionListener(this);
		
		bt.add(send);
		bt.add(submit);
		//main.setBackground(Color.red);
		//log.setBackground(Color.blue);
		//sub.setBackground(Color.yellow);
         tp.setBounds(130,300,520,300);
		
		
		
		
		//log.setBackground(Color.blue);
		
	   
		
		log.setLayout(new GridBagLayout());
		GridBagConstraints gbc2 = new GridBagConstraints(); 
		gbc2.insets=new  Insets(20,20,20,20);
		gbc2.gridx=0;
		gbc2.gridy=0;
		log.add(cn,gbc2);
		gbc2.gridx=1;
		gbc2.gridy=0;
		log.add(name,gbc2);
		gbc2.gridx=0;
		gbc2.gridy=1;
		log.add(phone,gbc2);
		gbc2.gridx=1;
		gbc2.gridy=1;
		log.add(number,gbc2);
		gbc2.gridx=0;
		gbc2.gridy=2;
		log.add(pass,gbc2);
		gbc2.gridx=1;
		gbc2.gridy=2;
		log.add(password,gbc2);
		
		gbc2.gridx=1;
		gbc2.gridy=3;
		log.add(bt,gbc2);
		
		
		ad.setBorder(BorderFactory.createCompoundBorder(ad.getBorder(),BorderFactory.createLineBorder(Color.black)));
		
		

		ad.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints(); 
		gbc.insets=new  Insets(20,20,20,20);
		
		gbc.gridx=0;
		gbc.gridy=1;
		ad.add(namead,gbc);
		gbc.gridx=1;
		gbc.gridy=1;
		ad.add(namea,gbc);
		gbc.gridx=0;
		gbc.gridy=2;
		ad.add(numberad,gbc);
		gbc.gridx=1;
		gbc.gridy=2;
		ad.add(numbera,gbc);
		gbc.gridx=0;
		gbc.gridy=0;
		ad.add(idd,gbc);
		gbc.gridx=1;
		gbc.gridy=0;
		ad.add(id,gbc);
		gbc.gridx=1;
		gbc.gridy=3;
		ad.add(submita,gbc);
		
		
		log.setBorder(BorderFactory.createCompoundBorder(log.getBorder(),BorderFactory.createLineBorder(Color.black)));
		ImagePanel img= new ImagePanel(new ImageIcon("C:\\Users\\Sathasivam\\eclipse-workspace\\hotel reservation\\src\\image\\home.jpg").getImage());
		tp.add("admin",ad);
		tp.add("customer",log);
		
		fl.getContentPane().setBackground(customColor2);
		fl.add(tp);
		
		
		fl.add(head1);
		fl.getContentPane().add(img);
		fl.setLayout(null);
		fl.setSize(750,770);
		fl.setVisible(true);
		fl.setDefaultCloseOperation(fl.HIDE_ON_CLOSE);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==send)
		{
					
					otp=1000+randotp.nextInt(1000);
					JOptionPane.showMessageDialog(fl, "your one time password is "+otp);
			
		}
		
		
		
		if(e.getSource()==submit)
		{String s;int flag;
		s=password.getText();
		db b=new db();
		b.connect();
		flag=b.login(name.getText(),number.getText());
		if(Integer.parseInt(s)==otp & flag==1)
		{
		JOptionPane.showMessageDialog(fl,"successfully,logged in");
		reserve r=new reserve();
		}
		else
		{
			JOptionPane.showMessageDialog(fl,"incorrect password or user name");
		}
		}
		
		
		if(e.getSource()==submita)
		{String s;int flag;
		s=password.getText();
		db b=new db();
		b.connect();
		flag=b.logina(Integer.parseInt(id.getText()),namea.getText(),numbera.getText());
		if( flag==1)
		{
		JOptionPane.showMessageDialog(fl,"successfully,logged in");
		admin_page a=new admin_page();
		}
		else
		{
			JOptionPane.showMessageDialog(fl,"incorrect password or user name");
		}
		}
		
		
		
	}
}


class ImagePanel extends JPanel {

	  private Image img;

	  

	  public ImagePanel(Image img) {
	    this.img = img;
	  
	    setSize(750,750);
	    setLayout(null);
	  }

	  public void paintComponent(Graphics g) {
		  g.drawImage(img, 0,0,null); 
	  }

	}