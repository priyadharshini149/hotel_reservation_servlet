package table;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import db.db;
import reserve.reserve;
import login.login;
import payment.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.Date;
import java.awt.*;



public class table implements ActionListener,ItemListener,ListSelectionListener
{
	
	JFrame ft;
	JLabel heading,customer_name,select_ur_dish,no_of_guest,table_place,info,confirm,date,time,pli,plo;
	JPanel p2,food,head,in,out,table;
	JTextField cn,guest,ind,outd;
	JButton back,check;
	JToggleButton place;
	String s1[]= {"dosa","vada","chats","juice","ice cream","pongal","idly","puri","porata","chapati","meals","birayani"};
	JList<String> dish;
	String s2,s,tn,dis;
	JMenuBar mb;
	JMenu x;
	JMenuItem m1, m2, m3;
	public static int cost=0;
	JScrollPane sp;
	public  ArrayList<String>dishes=new ArrayList<String>();
	
	JButton submit;
	GridBagConstraints gb=new GridBagConstraints();
	JFormattedTextField dat,tim;
	
	public table()
	{
		 
		   
	        mb = new JMenuBar();
	        x = new JMenu("Contact us");
	        m1 = new JMenuItem("email");
	        m2 = new JMenuItem("whatsapp");
	        m3 = new JMenuItem("telegram");
	        x.add(m1);
	        x.add(m2);
	        x.add(m3);
	        mb.add(x);
		ft=new JFrame("table booking");
		Color customColor1=new Color(234, 237, 237);
		Color customColor2=new Color(46, 64, 83);
		Color customColor3=new Color(46, 64, 83 );
		
		
		 Format shortTime = DateFormat.getTimeInstance(DateFormat.SHORT);
		  tim = new JFormattedTextField(shortTime);
		   tim.setValue(new Date());
		   tim.setColumns(10);
		   tim.setBounds(100,100,100,30);    
			tim.setToolTipText("Enter time"); 
		    
		 
		
		   Format shortDate = DateFormat.getDateInstance(DateFormat.SHORT);
		  
		   dat= new JFormattedTextField(shortDate);
		   dat.setValue(new Date());
		   dat.setColumns(10);
		   dat.setBounds(100,100,100,30);    
			dat.setToolTipText("Enter date"); 
		   
		  
		
		heading=new JLabel("TABLE BOOKING");
		customer_name=new JLabel("customer name:");
		check=new JButton("check");
		sp=new JScrollPane();
		head=new JPanel();
		head.setBackground(customColor3);
		
		table=new JPanel();
	    ind=new JTextField(5);
	    ind.setBounds(100,100,100,30);    
		ind.setToolTipText("Enter indoor table number that you want"); 
	    in=new JPanel();
	    pli=new JLabel("indoor table number");
		in.add(pli);
		in.add(ind);
		
		
		
		out=new JPanel();
		outd=new JTextField(5);
		outd.setBounds(100,100,100,30);    
		outd.setToolTipText("Enter outdoor table number that you want"); 
		plo=new JLabel("outdoor table number");
		out.add(plo);
		out.add(outd);
		table.add(in);
		table.add(out);
		table.add(check);
		table.setVisible(false);
		
	

		ImagePanel img= new ImagePanel(new ImageIcon("C:\\Users\\Sathasivam\\eclipse-workspace\\hotel reservation\\src\\image\\home.jpg").getImage());
		Font font=new Font("Monospaced",Font.BOLD,55);
		Font fontl=new Font("Monospaced ",Font.BOLD,15);
		
		pli.setVerticalAlignment(JLabel.CENTER);
		pli.setHorizontalAlignment(JLabel.CENTER);
		pli.setFont(fontl);
		plo.setVerticalAlignment(JLabel.CENTER);
		plo.setHorizontalAlignment(JLabel.CENTER);
		plo.setFont(fontl);
		
		customer_name=new JLabel("customer name:");
		customer_name.setVerticalAlignment(JLabel.CENTER);
		customer_name.setHorizontalAlignment(JLabel.CENTER);
		customer_name.setFont(fontl);
		
		select_ur_dish=new JLabel("select your dish:");
		select_ur_dish.setVerticalAlignment(JLabel.CENTER);
		select_ur_dish.setHorizontalAlignment(JLabel.CENTER);
		select_ur_dish.setFont(fontl);
		
		no_of_guest=new JLabel("enter the no.of guests:");
		no_of_guest.setVerticalAlignment(JLabel.CENTER);
		no_of_guest.setHorizontalAlignment(JLabel.CENTER);
		no_of_guest.setFont(fontl);
		
		table_place=new JLabel(" in-door table/out-door table:");
		table_place.setVerticalAlignment(JLabel.CENTER);
		table_place.setHorizontalAlignment(JLabel.CENTER);
		table_place.setFont(fontl);
		
		
		date=new JLabel("date:");
		date.setVerticalAlignment(JLabel.CENTER);
		date.setHorizontalAlignment(JLabel.CENTER);
		date.setFont(fontl);
		
		time=new JLabel("time:");
		time.setVerticalAlignment(JLabel.CENTER);
		time.setHorizontalAlignment(JLabel.CENTER);
		time.setFont(fontl);
		
		
		
		confirm=new JLabel();
		
		
		cn=new JTextField(20);
		cn.setBounds(100,100,100,30);    
		cn.setToolTipText("Enter name");  
		cn.setFont(fontl);
		guest=new JTextField(20);
		guest.setFont(fontl);
		guest.setBounds(100,100,100,30);    
		guest.setToolTipText("Enter no of guest"); 
		
		dat.setFont(fontl);
		
		tim.setFont(fontl);
		place=new JToggleButton("in-door table/out-door table");
		place.setFont(fontl);
		place.addItemListener(this);
		dish=new JList(s1);
		
		dish.setPreferredSize(new Dimension(250,270));
		
		dish.addListSelectionListener( this);
		food=new JPanel();
		
		
		sp.setViewportView(dish);
		
		food.add(sp);
		
		
		dish.setFont(fontl);
		
		
		
		
		submit=new JButton("book");
	    submit.addActionListener(this);
	    back=new JButton("back");
		back.addActionListener(this);
		
		back.setBackground(customColor1);
		back.setForeground(customColor2);
		
		check.setBackground(customColor1);
		check.setForeground(customColor2);
		check.addActionListener(this);
		
		
		head.setLayout(new GridBagLayout());
		GridBagConstraints gb1=new GridBagConstraints();
		gb1.insets=new Insets(1,1,1,1);
		gb1.gridx=0;
		gb1.gridy=0;
		head.add(heading,gb1);
		mb.add(back);
		gb1.gridx=1;
		gb1.gridy=1;
		head.add(mb,gb1);
		
		
		heading.setForeground(customColor1);
		heading.setFont(font);
		
		
		p2=new JPanel();
		
		
		head.setBounds(0,0,750,105);
		
		p2.setBounds(30,140,650,550);
		p2.setLayout(new GridBagLayout());
		gb.insets=new Insets(10,10,10,10);
		
		gb.gridx=0;
		gb.gridy=0;
		p2.add(customer_name,gb);
		gb.gridx=1;
		gb.gridy=0;
		p2.add(cn,gb);
		gb.gridx=0;
		gb.gridy=1;
		p2.add(no_of_guest,gb);
		gb.gridx=1;
		gb.gridy=1;
		p2.add(guest,gb);
		gb.gridx=0;
		gb.gridy=2;
		p2.add(table_place,gb);
		gb.gridx=1;
		gb.gridy=2;
		p2.add(place,gb);
		gb.gridx=1;
		gb.gridy=3;
		p2.add(confirm,gb);
		gb.gridx=0;
		gb.gridy=4;
		p2.add(date,gb);
		
		
		gb.gridx=1;
		gb.gridy=4;
		p2.add(dat,gb);
		gb.gridx=0;
		gb.gridy=5;
		p2.add(time,gb);
		gb.gridx=1;
		gb.gridy=5;
		p2.add(tim,gb);
		gb.gridx=0;
		gb.gridy=6;
		p2.add(select_ur_dish,gb);
		gb.gridx=1;
		gb.gridy=6;
		p2.add(food,gb);
		gb.gridx=1;
		gb.gridy=7;
		p2.add(submit,gb);
		gb.gridx=0;
		gb.gridy=3;
		p2.add(table,gb);
		
		in.setVisible(false);
		out.setVisible(false);
		
		
		
		
		
		
		
		
		
		
		
		
		submit.setBackground(customColor2);
		submit.setForeground(Color.white);
	
		
		p2.setBorder(BorderFactory.createCompoundBorder(p2.getBorder(),BorderFactory.createLineBorder(Color.black)));
		
		
		ft.getContentPane().setBackground(customColor2);
		ft.add(p2);
		
		ft.add(head);
		
		ft.getContentPane().add(img);
		ft.setLayout(null);
		ft.setSize(750,750);
		ft.setVisible(true);
		ft.setDefaultCloseOperation(ft.HIDE_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==submit)
			{
			 db b=new db();
			 b.connect();
			int ta=b.table(cn.getText(), Integer.parseInt(guest.getText()), Integer.parseInt(ind.getText()),Integer.parseInt(outd.getText()), dat.getText(), tim.getText(), dishes);
			if(ta==1)
			{
				JOptionPane.showMessageDialog(ft,"table is available");
				payment p=new payment();
				cost=b.table_pay(cn.getText());
				p.amt.setText(Integer.toString(cost));
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(ft, "oops!!!,table is already booked or not available");
				
			}
			
			
			
			
				 
			}
		 if(e.getSource()==back)
		 {
			 reserve r=new reserve();
		 }
		 if(e.getSource()==check)
		 {
			  s=ind.getText();
			  s2=outd.getText();
			 if(place.isSelected())
			 { 
			 System.out.println(tn);
				 if(Integer.parseInt(s)<=50&&Integer.parseInt(s)>=1)
				{ 
					confirm.setText("table is available");
				}
				else
				{
					confirm.setText("table is not available");
				}
			 }
			 else {
				 
				 tn=s2;System.out.println(tn);
			if(Integer.parseInt(s2)<=20&&Integer.parseInt(s2)>=1)
			{
					confirm.setText("table is available");
			}
			else
			{
					confirm.setText("table is not available");
			}
			 }
				
		 }
			
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==place)
		{
			
			
			if(place.isSelected())
			{outd.setText("0");
				table.setVisible(true);
				in.setVisible(true);
				ind.setText("");
				confirm.setText("50 tables are available");
				pli.setText("indoor table number:");
				out.setVisible(false);
			 
			}
			else {out.setVisible(true);
			ind.setText("0");
				outd.setText("");
				confirm.setText("20 tables are available");
				plo.setText("outdoor table number:");
				
				in.setVisible(false);
			
			}
		}
		
		
		
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
     if(!e.getValueIsAdjusting()) {
    	 dishes.add(dish.getSelectedValue());
    	 for(String na:dishes)  
         {
        	 System.out.println(na+" ");
         }
		if(dishes.size()>5)
		{
			JOptionPane.showMessageDialog(ft, "only five are allowed to select");
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
	