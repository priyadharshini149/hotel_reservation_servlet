package reserve;


import javax.swing.*;
import home.*;
import table.*;
import register.*;
import room.*;
import login.*;
import java.awt.event.*;
import java.awt.*;


public class reserve extends JFrame implements ActionListener 
{
	JFrame fr;
	JLabel reservation,confirmation,welcome;
	JPanel p1,button,head;
	JButton table,room,home;
	public reserve()
	{
		fr=new JFrame("reserve");
		
		
		Color customColor1=new Color(234, 237, 237);
		Color customColor2=new Color(46, 64, 83);
		Color customColor3=new Color(46, 64, 83);
		
		reservation=new JLabel("RESERVATION");
		Font font=new Font("Monospaced",Font.BOLD,55);
		Font fontl=new Font("Monospaced",Font.BOLD,17);
		Font font2=new Font("Monospaced",Font.BOLD,37);
		confirmation=new JLabel("select whether you need to book room or table");
		confirmation.setVerticalAlignment(JLabel.CENTER);
		confirmation.setHorizontalAlignment(JLabel.CENTER);
		confirmation.setFont(fontl);
		head=new JPanel();
		welcome=new JLabel("welcome "+login.name.getText());
		
		
		welcome.setVerticalAlignment(JLabel.CENTER);
		welcome.setHorizontalAlignment(JLabel.CENTER);
		welcome.setFont(font2);
		welcome.setForeground(customColor1);
		
		
		table=new JButton("Table");
		table.addActionListener(this);
		room=new JButton("Room");
		room.addActionListener(this);
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
		
		p1.setBounds(130,300,500,200);
		
		
		
		
		
		reservation.setForeground(customColor1);
		reservation.setFont(font);
		
		p1.setLayout(new GridLayout(2,1));
		button.add(table);
		button.add(room);
		
		table.setBackground(customColor2);
		table.setForeground(Color.white);
		room.setBackground(customColor2);
		room.setForeground(Color.white);
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
	if(e.getSource()==table)
	{
		int reply=JOptionPane.showConfirmDialog(fr,"whether want to book the table");
		if(reply==JOptionPane.YES_OPTION)
		{table t=new table();
		}
	}
		
		
		
	
	else if(e.getSource()==room)
	{
		int reply=JOptionPane.showConfirmDialog(fr,"whether want to book the room");
		if(reply==JOptionPane.YES_OPTION)
		{room r=new room();
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
		
		
		
	