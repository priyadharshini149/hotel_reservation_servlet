package payment;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionListener;



import db.*;
import login.*;
import table.*;

import java.awt.event.*;
import java.awt.*;


public class payment extends JFrame implements ActionListener,ItemListener
{
    JFrame fp;
	JPanel main,log,h,card,online_pay,pay;
	JTextField card_no_c,validate_till_c;
	JLabel payment,id,head,heading,card_no,validate_till,cvv;
public static  JLabel amt;
	 JLabel amount;
	JPasswordField i,cvv_c;
	JComboBox paym;
	String s1[]= {"select in mode","gpay","credit card","depit card","paytm"};
	String name="",ui="",cv="";
	JButton submit;
	public payment()
	{
		fp=new JFrame("login");
		
		main=new JPanel();
		card=new JPanel();
		log=new JPanel();
		online_pay=new JPanel();
		pay=new JPanel();
		paym=new JComboBox(s1);
		paym.addItemListener(this);
		paym.setSize(20, 50);
		
		h=new JPanel();
		
		
		head=new JLabel("PAYMENT");
		heading=new JLabel("PRP HOTEL");
		
		
		h.setBounds(500,0,500,200);
		
		Color customColor1=new Color(234, 237, 237);
		Color customColor2=new Color(46, 64, 83);
		
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
		
		h.setBackground(customColor2);
		h.setBounds(0,0,750,150);
		h.setLayout(new GridBagLayout());
		GridBagConstraints gb1=new GridBagConstraints();
		gb1.insets=new Insets(1,1,1,1);
		gb1.gridx=0;
		gb1.gridy=0;
		h.add(heading,gb1);
		gb1.gridx=0;
		gb1.gridy=1;
		h.add(head,gb1);
		
		payment=new JLabel("select the payment type:");
		payment.setVerticalAlignment(JLabel.CENTER);
		payment.setHorizontalAlignment(JLabel.CENTER);
		payment.setFont(fontl);
		
		id=new JLabel("enter the upi id:");
		id.setVerticalAlignment(JLabel.CENTER);
		id.setHorizontalAlignment(JLabel.CENTER);
		id.setFont(fontl);
		
		card_no=new JLabel("enter card number:");
		card_no.setVerticalAlignment(JLabel.CENTER);
		card_no.setHorizontalAlignment(JLabel.CENTER);
		card_no.setFont(fontl);
		
		
		validate_till=new JLabel("valid till:");
		validate_till.setVerticalAlignment(JLabel.CENTER);
		validate_till.setHorizontalAlignment(JLabel.CENTER);
		validate_till.setFont(fontl);
		
		cvv=new JLabel("enter cvv:");
		cvv.setVerticalAlignment(JLabel.CENTER);
		cvv.setHorizontalAlignment(JLabel.CENTER);
		cvv.setFont(fontl);
		
		amt=new JLabel("amount");
		amt.setFont(fontl);
		amount=new JLabel("amount:");
		amount.setVerticalAlignment(JLabel.CENTER);
		amount.setHorizontalAlignment(JLabel.CENTER);
		amount.setFont(fontl);
		
		
		name+=login.name.getText();
		
		
		i=new JPasswordField(10);
		i.setFont(fontl);
		ui+=i.getPassword();
		
		online_pay.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints(); 
		gbc.insets=new  Insets(10,10,10,10);
		gbc.gridx=0;
		gbc.gridy=0;
		online_pay.add(id,gbc);
		gbc.gridx=1;
		gbc.gridy=0;
		online_pay.add(i,gbc);
		online_pay.setVisible(false);
		pay.add(online_pay);
		
		card_no_c=new JTextField(10);
		card_no_c.setFont(fontl);
		
		
		validate_till_c=new JTextField(10);
		validate_till_c.setFont(fontl);
		
		cvv_c=new JPasswordField(10);
		cvv_c.setFont(fontl);
		cv+=cvv_c.getPassword();
		card.setLayout(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints(); 
		gbc1.insets=new  Insets(10,10,10,10);
		gbc1.gridx=0;
		gbc1.gridy=0;
		card.add(card_no,gbc1);
		gbc1.gridx=1;
		gbc1.gridy=0;
		card.add(card_no_c,gbc1);
		gbc1.gridx=0;
		gbc1.gridy=1;
		card.add(validate_till,gbc1);
		gbc1.gridx=1;
		gbc1.gridy=1;
		card.add(validate_till_c,gbc1);
		gbc1.gridx=0;
		gbc1.gridy=2;
		card.add(cvv,gbc1);
		gbc1.gridx=1;
		gbc1.gridy=2;
		card.add(cvv_c,gbc1);
		card.setVisible(false);
		pay.add(card);
		pay.setSize(500,500);
		submit=new JButton("submit");
		submit.addActionListener(this);
		submit.setBackground(customColor2);
		submit.setForeground(customColor1);
		
		
		
		//main.setBackground(Color.red);
		//log.setBackground(Color.blue);
		//sub.setBackground(Color.yellow);
         log.setBounds(80,300,600,300);
		
		
		
		
		//log.setBackground(Color.blue);
		
	   
		
		log.setLayout(new GridBagLayout());
		GridBagConstraints gbc2 = new GridBagConstraints(); 
		gbc2.insets=new  Insets(10,10,10,10);
		gbc2.gridx=0;
		gbc2.gridy=0;
		log.add(payment,gbc2);
		gbc2.gridx=1;
		gbc2.gridy=0;
		log.add(paym,gbc2);
		gbc2.gridx=0;
		gbc2.gridy=1;
		gbc2.gridwidth = 2;
		log.add(pay,gbc2);
		
		gbc2.gridx=0;
		gbc2.gridy=2;
		log.add(amount,gbc2);
		gbc2.gridx=1;
		gbc2.gridy=2;
		log.add(amt,gbc2);
		gbc2.gridx=1;
		gbc2.gridy=3;
		log.add(submit,gbc2);
		
		
		log.setBorder(BorderFactory.createCompoundBorder(log.getBorder(),BorderFactory.createLineBorder(Color.black)));
		ImagePanel img= new ImagePanel(new ImageIcon("C:\\Users\\Sathasivam\\eclipse-workspace\\hotel reservation\\src\\image\\home.jpg").getImage());
	
		
		
		
		fp.getContentPane().setBackground(customColor2);
		fp.add(log);
		
		fp.add(h);
		
		fp.getContentPane().add(img);
		fp.setLayout(null);
		fp.setSize(750,800);
		fp.setVisible(true);
		fp.setDefaultCloseOperation(fp.HIDE_ON_CLOSE);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==submit)
		{
			
			if((paym.getSelectedItem()=="gpay") ||(paym.getSelectedItem()=="paytm") )
			{db b=new db();
			b.connect();
				
				b.payment_online(name,(String)paym.getSelectedItem(),ui,Integer.parseInt(amt.getText()));
			
			}
			else if((paym.getSelectedItem()=="credit card") ||(paym.getSelectedItem()=="debit card"))
			{db b=new db();
			b.connect();
			
				b.payment_card(name,(String)paym.getSelectedItem(),card_no_c.getText(),validate_till_c.getText(),cv,Integer.parseInt(amt.getText()));
				
			}
		
			JOptionPane.showMessageDialog(fp, "successfully booked");
		}
		
		
		 
	}
	@SuppressWarnings("deprecation")
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if((e.getItem()=="gpay") ||(e.getItem()=="paytm") )
		{
			online_pay.setVisible(true);
			card.setVisible(false);
			
			
		
		}
		else if ((paym.getSelectedItem()=="credit card") ||(paym.getSelectedItem()=="debit card"))
		{online_pay.setVisible(false);
			card.setVisible(true);
			
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