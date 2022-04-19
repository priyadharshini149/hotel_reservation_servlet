package admin_page;


import javax.swing.*;
import home.*;

import verification_page_table.verification_page_table;
import verification_room_details.verification_room_details;
import register.*;

import login.*;
import java.awt.event.*;
import java.awt.*;


public class admin_page extends JFrame implements ActionListener 
{
	JFrame fr;
	JLabel reservation,confirmation,welcome;
	JPanel p1,button,head;
	JButton table_details,room_details,home;
	public admin_page()
	{
		fr=new JFrame("admin_page");
		
		
		Color customColor1=new Color(234, 237, 237);
		Color customColor2=new Color(46, 64, 83);
		Color customColor3=new Color(46, 64, 83);
		
		reservation=new JLabel("RESERVATION");
		Font font=new Font("Monospaced",Font.BOLD,55);
		Font fontl=new Font("Monospaced",Font.BOLD,17);
		Font font2=new Font("Monospaced",Font.BOLD,37);
		confirmation=new JLabel("select whether you need to view  of  room details or table details");
		confirmation.setVerticalAlignment(JLabel.CENTER);
		confirmation.setHorizontalAlignment(JLabel.CENTER);
		confirmation.setFont(fontl);
		head=new JPanel();
		welcome=new JLabel("welcome "+login.namea.getText());
		
		
		welcome.setVerticalAlignment(JLabel.CENTER);
		welcome.setHorizontalAlignment(JLabel.CENTER);
		welcome.setFont(font2);
		welcome.setForeground(customColor1);
		
		
		table_details=new JButton("Table");
		table_details.addActionListener(this);
		room_details=new JButton("Room");
		room_details.addActionListener(this);
		home=new JButton("home");
		home.addActionListener(this);
		
		p1=new JPanel();
		button=new JPanel();
		
		
		head.setBackground(customColor3);
		head.setBounds(0,0,750,110);
		welcome.setBounds(120,100,500,200);
		head.setLayout(new GridBagLayout());
		GridBagConstraints gb1=new GridBagConstraints();
		gb1.insets=new Insets(1,1,1,1);
		gb1.gridx=0;
		gb1.gridy=0;
		head.add(reservation,gb1);
		gb1.gridx=1;
		gb1.gridy=1;
		head.add(home,gb1);
		
		p1.setBounds(10,300,700,200);
		
		
		
		
		
		reservation.setForeground(customColor1);
		reservation.setFont(font);
		
		p1.setLayout(new GridLayout(2,1));
		button.add(table_details);
		button.add(room_details);
		
		table_details.setBackground(customColor2);
		table_details.setForeground(Color.white);
		room_details.setBackground(customColor2);
		room_details.setForeground(Color.white);
		home.setBackground(customColor1);
		home.setForeground(customColor2);
		
		p1.setBorder(BorderFactory.createCompoundBorder(p1.getBorder(),BorderFactory.createLineBorder(Color.black)));
		ImagePanel img= new ImagePanel(new ImageIcon("C:\\Users\\Sathasivam\\eclipse-workspace\\hotel reservation\\src\\image\\home.jpg").getImage());
		p1.add(confirmation);
		p1.add(button);
		
		fr.add(p1);
		fr.add(head);
		fr.add(welcome);
		fr.add(img);
		fr.getContentPane().setBackground(customColor2);
		fr.setLayout(null);
		fr.setSize(750,750);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(fr.HIDE_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==table_details)
	{
		int reply=JOptionPane.showConfirmDialog(fr,"whether want to view details of table booked");
		if(reply==JOptionPane.YES_OPTION)
		{verification_page_table t=new verification_page_table();
		}
	}
		
		
		
	
	else if(e.getSource()==room_details)
	{
		int reply=JOptionPane.showConfirmDialog(fr,"whether want to view details of room booked");
		if(reply==JOptionPane.YES_OPTION)
		{verification_room_details r=new verification_room_details();
		}
	}
	else if(e.getSource()==home)
	{
		home h=new home();
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
		
		
		
	