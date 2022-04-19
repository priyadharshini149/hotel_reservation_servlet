package verification_room_details;




import javax.swing.*;
import javax.swing.border.Border;





import java.util.ArrayList;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;



public class verification_room_details extends JFrame {
	JFrame fr;
	Connection con=null;
	
	JPanel main,log,head1,bt;
	JLabel head,heading;
	JLabel customer_name,no_of_guest,table_number,date,time,dish;
	JLabel cn,nog,tn,d,t,dis;
	   
String column[]={"name","number","no.of guest","no.of adult","no.of child","checkin date","checkin time",
		"checkout date","checkout time","no.of room","type of room","address","room no."};         


	
	public verification_room_details()
	{
		fr=new JFrame("verify");
		
		main=new JPanel();
		
		
		
		
		head=new JLabel("Room booked details");
		heading=new JLabel(" PRP RESTAURANT");
		
		head1=new JPanel();
		
		main.setBounds(20,200,930,500);
		
		
		Color customColor1=new Color(234, 237, 237);
		Color customColor2=new Color(46, 64, 83);
		Color customColor3=new Color(0f,0f,.12f,.6f );
		Font font=new Font("Monospaced",Font.BOLD,55);
		Font fontl=new Font("Monospaced ",Font.BOLD,15);
		
		head.setFont(font);
		head.setForeground(customColor1);
		heading.setFont(font);
		heading.setForeground(customColor1);
		main.setBackground(customColor3);
	
		
		
		head.setVerticalAlignment(JLabel.CENTER);
		head.setHorizontalAlignment(JLabel.CENTER);
		heading.setVerticalAlignment(JLabel.CENTER);
		heading.setHorizontalAlignment(JLabel.CENTER);
		
		
		
		
		
		
		
		head1.setBackground(customColor3);
		head1.setBounds(0,0,1000,150);
		head1.setLayout(new GridBagLayout());
		GridBagConstraints gb1=new GridBagConstraints();
		gb1.insets=new Insets(1,1,1,1);
		gb1.gridx=0;
		gb1.gridy=0;
		head1.add(heading,gb1);
		gb1.gridx=0;
		gb1.gridy=1;
		head1.add(head,gb1);
		
		
		
	
		//main.setBackground(Color.red);
		//log.setBackground(Color.blue);
		//sub.setBackground(Color.yellow);
        
		
		
		
		
		//log.setBackground(Color.blue);
		
	   
		  Object[][] data =tabledetail();
		JTable jt=new JTable(data,column); 
         jt.setForeground(customColor1);
         jt.setBackground(customColor3);
         jt.setFont(fontl);
		main.setLayout(new BorderLayout());    
         JScrollPane sp=new JScrollPane(jt);    
     	main.add(jt.getTableHeader(), BorderLayout.NORTH);
    	jt.getTableHeader().setFont(fontl);
    	jt.getTableHeader().setPreferredSize(new Dimension(100,80));
    	
    	jt.setRowHeight( 40);
    	
		main.add(jt, BorderLayout.CENTER);
         main.add(jt);
       
         

		
       
		
		main.setBorder(BorderFactory.createCompoundBorder(main.getBorder(),BorderFactory.createLineBorder(Color.black)));
		ImagePanel img= new ImagePanel(new ImageIcon("C:\\Users\\Sathasivam\\eclipse-workspace\\hotel reservation\\src\\image\\home.jpg").getImage());
		
		
		
		fr.getContentPane().setBackground(customColor2);
	
		fr.add(main);
		fr.add(head1);
		fr.getContentPane().add(img);
		fr.setLayout(null);
		fr.setSize(980,790);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(fr.HIDE_ON_CLOSE);
		
		
	}
	private Object[][] tabledetail(){
		Object[][] data =null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_reservation","root", "Priya@149");
			
			PreparedStatement st = (PreparedStatement) con
                 .prepareStatement("select name,number,no_of_guest,no_of_adult,no_of_child,check_out_date,check_in_date,check_in_time,check_out_time,no_of_room,type_room,address,room_number from roombook  ",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery();
			int rowCount = getRowCount(rs); 
			int columnCount = getColumnCount(rs); 

			data = new Object[rowCount][columnCount];
		
			rs.beforeFirst();

			int i = 0;
			
			while (rs.next()) {

				int j = 0;
                
                
				data[i][j++] = rs.getString("name");
				data[i][j++] = rs.getString("number");
				data[i][j++] = rs.getInt("no_of_guest");
				data[i][j++] = rs.getInt("no_of_adult");
				data[i][j++] = rs.getString("no_of_child");
				data[i][j++] = rs.getString("check_in_date");
				data[i][j++] = rs.getString("check_in_time");
				data[i][j++] = rs.getString("check_out_date");
				data[i][j++] = rs.getString("check_out_time");
				data[i][j++] = rs.getString("no_of_room");
				data[i][j++] = rs.getString("type_room");
				data[i][j++] = rs.getString("address");
				data[i][j++] = rs.getString("room_number");
				i++;
			}

			
			
			
			con.close();
			
		} catch (Exception e) {

			System.out.println(e);
		}
		return data;
	}
	private int getRowCount(ResultSet rs) {

		try {
			
			if(rs != null) {
				
				rs.last();
				
				return rs.getRow(); 
			}
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return 0;
	}


	private int getColumnCount(ResultSet rs) {

		try {

			if(rs != null)
				return rs.getMetaData().getColumnCount();

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return 0;
	}	
	}



class ImagePanel extends JPanel {

	  private Image img;

	  

	  public ImagePanel(Image img) {
	    this.img = img;
	  
	    setSize(1000,790);
	    setLayout(null);
	  }

	  public void paintComponent(Graphics g) {
		  g.drawImage(img, 0,0,null); 
	  }

	}