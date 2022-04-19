package register;
import db.*;
import javax.swing.*;
import javax.swing.border.Border;

import login.login;



import java.awt.event.*;
import java.awt.*;
import reserve.*;


public class register extends JFrame implements ActionListener{
	JFrame fr;
	
	JPanel main,log,head1,bt;
	JLabel head,cn,phone,heading;
	JTextField number;
	
	JButton submit,back,reset;
	public static JTextField name;
	
	public register()
	{
		fr=new JFrame("register");
		
		main=new JPanel();
		
		log=new JPanel();
		bt=new JPanel();
		
		head=new JLabel("REGISTER");
		heading=new JLabel(" PRP RESTAURANT");
		
		head1=new JPanel();
		back=new JButton("login");
		reset=new JButton("reset");
		
		
		
		Color customColor1=new Color(234, 237, 237);
		Color customColor2=new Color(46, 64, 83);
		Color customColor3=new Color(46, 64, 83 );
		Font font=new Font("Monospaced",Font.BOLD,55);
		Font fontl=new Font("Monospaced ",Font.BOLD,15);
		
		head.setFont(font);
		head.setForeground(customColor1);
		heading.setFont(font);
		heading.setForeground(customColor1);
		
		back.setBackground(customColor1);
		back.setForeground(customColor2);
		back.addActionListener(this);
			
		reset.setBackground(customColor2);
		reset.setForeground(customColor1);
		reset.addActionListener(this);
		
		
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
		gb1.gridx=1;
		gb1.gridy=1;
		head1.add(back,gb1);
		
		
		name=new JTextField(20);
		name.setFont(fontl);
		number=new JTextField(20);
		number.setFont(fontl);
		
		submit=new JButton("submit");
		
		submit.setBackground(customColor2);
		submit.setForeground(customColor1);
		submit.addActionListener(this);
	
		bt.add(reset);
		bt.add(submit);
		//main.setBackground(Color.red);
		//log.setBackground(Color.blue);
		//sub.setBackground(Color.yellow);
         log.setBounds(130,300,520,300);
		
		
		
		
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
		
		
		gbc2.gridx=1;
		gbc2.gridy=3;
		log.add(bt,gbc2);
		
		
		log.setBorder(BorderFactory.createCompoundBorder(log.getBorder(),BorderFactory.createLineBorder(Color.black)));
		ImagePanel img= new ImagePanel(new ImageIcon("C:\\Users\\Sathasivam\\eclipse-workspace\\hotel reservation\\src\\image\\home.jpg").getImage());
		
		
		
		fr.getContentPane().setBackground(customColor2);
		fr.add(log);
		
		
		fr.add(head1);
		fr.getContentPane().add(img);
		fr.setLayout(null);
		fr.setSize(750,770);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(fr.HIDE_ON_CLOSE);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		
		
		if(e.getSource()==submit)
		{
		
		db b=new db();
		b.connect();
		b.register(name.getText(), number.getText());
		login l=new login();
		  JOptionPane.showMessageDialog(fr, "successfully registered");
		  
		}
		if(e.getSource()==back)
		{
			login l=new login();
		}
		
		if(e.getSource()==reset)
		{
			name.setText("");
			number.setText("");
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