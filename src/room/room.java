package room;

import javax.swing.*;

import db.db;
import login.login;
import payment.*;
import reserve.reserve;
import table.table;

import java.awt.event.*;
import java.sql.Time;
import java.text.DateFormat;
import java.text.Format;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.*;


public class room implements ActionListener,ItemListener
{
	JFrame froom;
	JLabel preferance,no_of_room,heading,customer_name,phone_number,check_in_time,check_out_time,add,check_in_date,check_out_date,no_of_guest,no_of_child,no_of_adult,ci,co;
	JPanel p2,head,checkinp,checkoutp;
	JTextField room,cn,pno,guest,child,adult;
	
	JComboBox cb;
	JTextArea address;
	JButton submit,back;
	String p[]= {"standard","deluxe","suite"};
	int amt=0;
	
	JFormattedTextField checkin,checkout,checkindate,checkoutdate;
	public room()
	{
		
		
		froom=new JFrame("room booking");
		heading=new JLabel("ROOM BOOKING");
		
	
		 Format shortTime = DateFormat.getTimeInstance(DateFormat.SHORT);
		
		   checkin = new JFormattedTextField(shortTime);
		   checkin.setValue(new Date());
		   checkin.setColumns(10);
		    
		 
		   
		   checkout = new JFormattedTextField(shortTime);
		   checkout.setValue(new Date());
		   checkout.setColumns(10);
		
		   Format shortDate = DateFormat.getDateInstance(DateFormat.SHORT);
		  
		   checkindate = new JFormattedTextField(shortDate);
		   checkindate.setValue(new Date());
		   checkindate.setColumns(10);
		   
		   checkoutdate = new JFormattedTextField(shortDate);
		   checkoutdate.setValue(new Date());
		   checkoutdate.setColumns(10);
		
		Color customColor1=new Color(234, 237, 237);
		Color customColor2=new Color(46, 64, 83);
		Color customColor3=new Color(46, 64, 83 );
		Font font=new Font("Monospaced",Font.BOLD,55);
		Font fontl=new Font("Monospaced ",Font.BOLD,15);
		
		cb=new JComboBox(p);
		cb.addItemListener(this);
		customer_name=new JLabel("customer name:");
		customer_name.setVerticalAlignment(JLabel.CENTER);
		customer_name.setHorizontalAlignment(JLabel.CENTER);
		customer_name.setFont(fontl);
		
		phone_number=new JLabel("phone number:");
		phone_number.setVerticalAlignment(JLabel.CENTER);
		phone_number.setHorizontalAlignment(JLabel.CENTER);
		phone_number.setFont(fontl);
		
		check_in_time=new JLabel("check in time:");
		check_in_time.setVerticalAlignment(JLabel.CENTER);
		check_in_time.setHorizontalAlignment(JLabel.CENTER);
		check_in_time.setFont(fontl);
		
		check_out_time=new JLabel("check out time:");
		check_out_time.setVerticalAlignment(JLabel.CENTER);
		check_out_time.setHorizontalAlignment(JLabel.CENTER);
		check_out_time.setFont(fontl);
		
		check_in_date=new JLabel("check in date:");
		check_in_date.setVerticalAlignment(JLabel.CENTER);
		check_in_date.setHorizontalAlignment(JLabel.CENTER);
		check_in_date.setFont(fontl);
		
		check_out_date=new JLabel("check out date:");
		check_out_date.setVerticalAlignment(JLabel.CENTER);
		check_out_date.setHorizontalAlignment(JLabel.CENTER);
		check_out_date.setFont(fontl);
		
		no_of_guest=new JLabel("no.of guest:");
		no_of_guest.setVerticalAlignment(JLabel.CENTER);
		no_of_guest.setHorizontalAlignment(JLabel.CENTER);
		no_of_guest.setFont(fontl);
		
		no_of_adult=new JLabel("no.of adult:");
		no_of_adult.setVerticalAlignment(JLabel.CENTER);
		no_of_adult.setHorizontalAlignment(JLabel.CENTER);
		no_of_adult.setFont(fontl);
		
		no_of_child=new JLabel("no.of child:");
		no_of_child.setVerticalAlignment(JLabel.CENTER);
		no_of_child.setHorizontalAlignment(JLabel.CENTER);
		no_of_child.setFont(fontl);
		
		ci=new JLabel("check in details");
		ci.setVerticalAlignment(JLabel.CENTER);
		ci.setHorizontalAlignment(JLabel.CENTER);
		ci.setFont(fontl);
		
		co=new JLabel("check out details");
		co.setVerticalAlignment(JLabel.CENTER);
		co.setHorizontalAlignment(JLabel.CENTER);
		co.setFont(fontl);
		
		preferance=new JLabel("select type of room:");
		preferance.setVerticalAlignment(JLabel.CENTER);
		preferance.setHorizontalAlignment(JLabel.CENTER);
		preferance.setFont(fontl);
		
		no_of_room=new JLabel("no. of rooms:");
		no_of_room.setVerticalAlignment(JLabel.CENTER);
		no_of_room.setHorizontalAlignment(JLabel.CENTER);
		no_of_room.setFont(fontl);
		
		add=new JLabel("address:");
		add.setVerticalAlignment(JLabel.CENTER);
		add.setHorizontalAlignment(JLabel.CENTER);
		add.setFont(fontl);
		
		cn=new JTextField(15);
		cn.setFont(fontl);
		pno=new JTextField(15);
		pno.setFont(fontl);
		
		address=new JTextArea(5,15);
		address.setFont(fontl);
		
		checkindate.setFont(fontl);
		
		checkoutdate.setFont(fontl);
checkin.setFont(fontl);
		
		checkout.setFont(fontl);
		guest=new JTextField(10);
		guest.setFont(fontl);
		child=new JTextField(10);
		child.setFont(fontl);
		adult=new JTextField(10);
		adult.setFont(fontl);
		room=new JTextField(10);
		room.setFont(fontl);
		
		
		
		submit=new JButton("book");
	    submit.addActionListener(this);
		
		
		
	    heading.setForeground(customColor1);
	    heading.setBackground(customColor2);
		heading.setFont(font);
		
		
		
		  back=new JButton("back");
			back.addActionListener(this);
			
			back.setBackground(customColor1);
			back.setForeground(customColor2);
		p2=new JPanel();
		head=new JPanel();
		
		checkinp=new JPanel();
		checkinp.setLayout(new GridBagLayout());
		GridBagConstraints gb2=new GridBagConstraints();
		gb2.insets=new Insets(1,1,1,1);
		gb2.gridx=0;
		gb2.gridy=1;
		checkinp.add(check_in_date,gb2);
		gb2.gridx=1;
		gb2.gridy=1;
		checkinp.add(checkindate,gb2);
		gb2.gridx=0;
		gb2.gridy=2;
		checkinp.add(check_in_time,gb2);
		gb2.gridx=1;
		gb2.gridy=2;
		checkinp.add(checkin,gb2);
		gb2.gridwidth=2;
		gb2.gridx=0;
		gb2.gridy=0;
		checkinp.add(ci,gb2);
		checkinp.setBorder(BorderFactory.createCompoundBorder(checkinp.getBorder(),BorderFactory.createLineBorder(Color.black)));
		
		checkoutp=new JPanel();
		checkoutp.setLayout(new GridBagLayout());
		GridBagConstraints gb3=new GridBagConstraints();
		gb3.insets=new Insets(1,1,1,1);
		gb3.gridx=0;
		gb3.gridy=1;
		checkoutp.add(check_out_date,gb3);
		gb3.gridx=1;
		gb3.gridy=1;
		checkoutp.add(checkoutdate,gb3);
		gb3.gridx=0;
		gb3.gridy=2;
		checkoutp.add(check_out_time,gb3);
		gb3.gridx=1;
		gb3.gridy=2;
		checkoutp.add(checkout,gb3);
		gb3.gridwidth=2;
		gb3.gridx=0;
		gb3.gridy=0;
		checkoutp.add(co,gb3);
		checkoutp.setBorder(BorderFactory.createCompoundBorder(checkoutp.getBorder(),BorderFactory.createLineBorder(Color.black)));
		
		head.setLayout(new GridBagLayout());
		GridBagConstraints gb1=new GridBagConstraints();
		gb1.insets=new Insets(1,1,1,1);
		gb1.gridx=0;
		gb1.gridy=0;
		head.add(heading,gb1);
		gb1.gridx=1;
		gb1.gridy=1;
		head.add(back,gb1);
		head.setBackground(customColor3);
		head.setBounds(0,0,750,110);
		p2.setBounds(30,140,650,600);
		p2.setLayout(new GridBagLayout());
		
		GridBagConstraints gb=new GridBagConstraints();
		gb.insets=new Insets(10,10,10,10);
		gb.gridx=0;
		gb.gridy=0;
		p2.add(customer_name,gb);
		gb.gridx=1;
		gb.gridy=0;
		p2.add(cn,gb);
		gb.gridx=0;
		gb.gridy=1;
		p2.add(phone_number,gb);
		gb.gridx=1;
		gb.gridy=1;
		p2.add(pno,gb);
		gb.gridx=0;
		gb.gridy=2;
		p2.add(no_of_guest,gb);
		gb.gridx=1;
		gb.gridy=2;
		p2.add(guest,gb);
		gb.gridx=0;
		gb.gridy=3;
		p2.add(no_of_adult,gb);
		gb.gridx=1;
		gb.gridy=3;
		p2.add(adult,gb);
		gb.gridx=0;
		gb.gridy=4;
		p2.add(no_of_child,gb);
		gb.gridx=1;
		gb.gridy=4;
		p2.add(child,gb);
		gb.gridx=0;
		gb.gridy=5;
		p2.add(checkinp,gb);
		gb.gridx=1;
		gb.gridy=5;
		p2.add(checkoutp,gb);
		gb.gridx=0;
		gb.gridy=8;
		p2.add(add,gb);
		gb.gridx=1;
		gb.gridy=8;
		p2.add(address,gb);
		gb.gridx=0;
		gb.gridy=6;
		p2.add(no_of_room,gb);
		gb.gridx=1;
		gb.gridy=6;
		p2.add(room,gb);
		gb.gridx=0;
		gb.gridy=7;
		p2.add(preferance,gb);
		gb.gridx=1;
		gb.gridy=7;
		p2.add(cb,gb);
		gb.gridx=1;
		gb.gridy=9;
		p2.add(submit,gb);
		
		
		submit.setBackground(customColor2);
		submit.setForeground(customColor1);
	
		
		p2.setBorder(BorderFactory.createCompoundBorder(p2.getBorder(),BorderFactory.createLineBorder(Color.black)));
		ImagePanel img= new ImagePanel(new ImageIcon("C:\\Users\\Sathasivam\\eclipse-workspace\\hotel reservation\\src\\image\\home.jpg").getImage());
		
	
		
		froom.getContentPane().setBackground(customColor2);
		froom.add(p2);
		froom.add(head);
		froom.getContentPane().add(img);
		
		froom.setLayout(null);
		froom.setSize(750,780);
		froom.setVisible(true);
		froom.setDefaultCloseOperation(froom.HIDE_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	 if(e.getSource()==submit)
	{
	String r="";	
	db b=new db();
b.connect();
	b.roombook(cn.getText(),pno.getText(),Integer.parseInt(guest.getText()),Integer.parseInt(adult.getText()),
			Integer.parseInt(child.getText()),checkindate.getText(),checkin.getText(),checkoutdate.getText(),checkout.getText(),Integer.parseInt(room.getText())
			,(String)cb.getSelectedItem(),address.getText());
	int a[]=b.room_pay(cn.getText());
	
	for(int i=1;i<=Integer.parseInt(room.getText());i++)
	{
		r+=a[1]+i;
		r+=" ";
		
	}
	
	JOptionPane.showMessageDialog(froom, "your room numbers are "+r);
	
	
	payment p=new payment();
	p.amt.setText(Integer.toString(a[0]));
	 
	}
	 if(e.getSource()==back)
	 {
		 reserve r=new reserve();
	 }
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED)
		{
			
			
			System.out.println(cb.getSelectedItem());
			
			
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