package home;




import javax.swing.*;
import register.*;
import login.*;
import java.awt.event.*;
import java.awt.*;


public class home extends JFrame implements ActionListener 
{
	JFrame fh;
	JLabel heading,log;
	JPanel p1,button,head;
	JButton login,regi;
	JTabbedPane tb;
	public home()
	{
		fh=new JFrame("PRP RESTAURANT");
		tb=new JTabbedPane();
		heading=new JLabel(" PRP RESTAURANT");
		Color customColor1=new Color(234, 237, 237);
		Color customColor2=new Color(215, 189, 226);
		Color customColor3=new Color(46, 64, 83 );
		Font font=new Font("Monospaced",Font.BOLD,48);
		Font fontl=new Font("Monospaced",Font.BOLD,35);
		heading.setForeground(customColor1);
		heading.setFont(font);
		head=new JPanel();
		head.setBackground(customColor3);
		head.add(heading);
		ImagePanel img= new ImagePanel(new ImageIcon("C:\\Users\\Sathasivam\\eclipse-workspace\\hotel reservation\\src\\image\\home.jpg").getImage());
		
		

		log=new JLabel("REGISTER/LOGIN");
		log.setVerticalAlignment(JLabel.CENTER);
		log.setHorizontalAlignment(JLabel.CENTER);
		log.setFont(fontl);
		log.setForeground(customColor1);
		
		
		
		login=new JButton("login");
		login.addActionListener(this);
		login.setBackground(customColor3);
		login.setToolTipText("login");
		
		regi=new JButton("register");
		regi.addActionListener(this);
		regi.setForeground(customColor1);
		regi.setBackground(customColor3);
		regi.setToolTipText("register");
		
		p1=new JPanel();
		button=new JPanel();
		
		head.setBounds(0,0,750,100);
		p1.setBounds(100,300,500,200);
		p1.setBackground(customColor3);
		
		
		
		
		p1.setLayout(new GridLayout(2,1));
		button.setLayout(new GridBagLayout());
		
		GridBagConstraints gb=new GridBagConstraints();
		gb.insets=new Insets(10,10,10,10);
		gb.gridx=0;
		gb.gridy=0;
		button.add(regi,gb);
		gb.gridx=0;
		gb.gridy=1;
		button.add(login,gb);
		
		
		
		
		login.setForeground(Color.white);
	
		
		p1.setBorder(BorderFactory.createCompoundBorder(p1.getBorder(),BorderFactory.createLineBorder(Color.black)));
		
		button.setBorder(BorderFactory.createCompoundBorder(p1.getBorder(),BorderFactory.createEmptyBorder(10,10,0,0)));
		p1.add(log);
		p1.add(button);
		
		fh.add(p1);
		fh.add(head);
		
		fh.getContentPane().add(img);
		
		fh.setLayout(null);
		
		fh.setSize(750,750);
		fh.setVisible(true);
		fh.setDefaultCloseOperation(fh.EXIT_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
	 if(e.getSource()==regi)
		{
			register r=new register();
		}
	 if(e.getSource()==login)
		{
			login l=new login();
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
	
		
		
		
	