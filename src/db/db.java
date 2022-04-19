package db;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import reserve.reserve;
public class db {

	Connection con=null;
	
	
	public void connect()
	{
		
		try {
			 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_reservation","root", "Priya@149");
			System.out.println("success");
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public void register(String name,String phone)
	{
		try {
			PreparedStatement st = (PreparedStatement) con
                    .prepareStatement("insert into register values(?,?)");
			 st.setString(1, name);
             st.setString(2, phone);
             int rs1 = st.executeUpdate();
             System.out.println(rs1);
             con.close();  
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public int login(String name,String phone)
	{int flag=0;
		try {
			PreparedStatement st = (PreparedStatement) con
                    .prepareStatement("select name,phone from register where name=? and phone=? ");
			st.setString(1, name);
			st.setString(2,phone);
			ResultSet rs1 = st.executeQuery();
			  if (rs1.next()) {
                  
                flag=1;
                  
              } 
			  con.close();
			
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
		return flag;
	}
	
	
	public int logina(int id,String name,String phone)
	{int flag=0;
		try {
			PreparedStatement st = (PreparedStatement) con
                    .prepareStatement("select admin_id,name,phone from admin where admin_id=? and name=? and phone=? ");
			st.setInt(1, id);
			st.setString(2,name);
			st.setString(3,phone);
			ResultSet rs1 = st.executeQuery();
			  if (rs1.next()) {
                  
                flag=1;
                  
              } 
			  con.close();
			
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
		return flag;
	}
	
	public int table(String name,int num_guest,int in_table_number,int out_table_number,String date,String time,ArrayList<String> dishes)
	{int rs1=0;
	Object[] d=dishes.toArray();
		try {
			if(out_table_number==0)
			{PreparedStatement st = (PreparedStatement) con.prepareStatement("insert into tablebook(name,num_guest,in_table_number,date,time,dish_1,dish_2,dish_3,dish_4,dish_5) values(?,?,?,?,?,?,?,?,?,?)");
			 st.setString(1, name);
             st.setInt(2,num_guest );
             st.setInt(3,in_table_number);
             
             st.setString(4,date);
             st.setString(5,time);
             st.setString(6,(String) d[0]);
             st.setString(7,(String) d[1]);
             st.setString(8,(String) d[2]);
             st.setString(9,(String) d[3]);
             st.setString(10,(String) d[4]);
             rs1 = st.executeUpdate();
             System.out.println(rs1);
            
			}
			if(in_table_number==0)
			{PreparedStatement st = (PreparedStatement) con.prepareStatement("insert into tablebook(name,num_guest,out_table_number,date,time,dish_1,dish_2,dish_3,dish_4,dish_5) values(?,?,?,?,?,?,?,?,?,?)");
			 st.setString(1, name);
             st.setInt(2,num_guest);
             st.setInt(3,out_table_number);
             
             st.setString(4,date);
             st.setString(5,time);
             st.setString(6,(String) d[0]);
             st.setString(7,(String) d[1]);
             st.setString(8,(String) d[2]);
             st.setString(9,(String) d[3]);
             st.setString(10,(String) d[4]);
              rs1 = st.executeUpdate();
             System.out.println(rs1);
			}
			PreparedStatement st1 = (PreparedStatement) con.prepareStatement("update tablebook tb set cost_dish_1=(select price from dish where dish_name=?) where tb.name=?");
		
			  st1.setString(1,(String) d[0]);
			 
            st1.setString(2,(String) name);
            
        	PreparedStatement st2 = (PreparedStatement) con.prepareStatement("update tablebook tb set cost_dish_2=(select price from dish where dish_name=?) where tb.name=?");
    		
			  st2.setString(1,(String) d[1]);
			 
          st2.setString(2,(String) name);
      	PreparedStatement st3 = (PreparedStatement) con.prepareStatement("update tablebook tb set cost_dish_3=(select price from dish where dish_name=?) where tb.name=?");
		
		  st3.setString(1,(String) d[2]);
		 
      st3.setString(2,(String) name);
  	PreparedStatement st4 = (PreparedStatement) con.prepareStatement("update tablebook tb set cost_dish_4=(select price from dish where dish_name=?) where tb.name=?");
	
	  st4.setString(1,(String) d[3]);
	 
  st4.setString(2,(String) name);
	PreparedStatement st5 = (PreparedStatement) con.prepareStatement("update tablebook tb set cost_dish_5=(select price from dish where dish_name=?) where tb.name=?");
	
	  st5.setString(1,(String) d[4]);
	 
  st5.setString(2,(String) name);
			
			rs1 = st1.executeUpdate();
             System.out.println(rs1);
             rs1 = st2.executeUpdate();
             System.out.println(rs1);
             rs1 = st3.executeUpdate();
             System.out.println(rs1);
             rs1 = st4.executeUpdate();
             System.out.println(rs1);
             rs1 = st5.executeUpdate();
             System.out.println(rs1);
             
             
             PreparedStatement st6 = (PreparedStatement) con.prepareStatement("update tablebook tb set cost=(cost_dish_1+cost_dish_2+cost_dish_3+cost_dish_4+cost_dish_5) where tb.name=?");
         	
       	  
       	 
         st6.setString(1,(String) name);
         rs1 = st6.executeUpdate();
         System.out.println(rs1);
			
             
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return rs1;
	}
	
	public int table_pay(String name)
	{int c=0;
		try {
			PreparedStatement st = (PreparedStatement) con
	                .prepareStatement("select cost from tablebook where name=?");
			st.setString(1,(String) name);
			ResultSet rs1 = st.executeQuery();	
			while(rs1.next())
			{
				c=rs1.getInt("cost");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return c;
	}
	
	
	public void roombook(String name,String number,int no_of_guest,int no_of_adult,int no_of_child,String checkin,String checkintime,String checkout,String checkouttime,int no_of_room,String type_of_room,String address)
	{
		try {
			PreparedStatement st = (PreparedStatement) con.prepareStatement("insert into roombook(name,number,no_of_guest,no_of_adult,no_of_child,check_in_date,check_in_time,check_out_date,check_out_time,no_of_room,type_room,address) values(?,?,?,?,?,?,?,?,?,?,?,?)");
		st.setString(1, name);
		st.setString(2,number);
        st.setInt(3,no_of_guest);
        st.setInt(4, no_of_adult);
        st.setInt(5, no_of_child);
        st.setString(6,checkin);
        st.setString(7,checkintime);
        st.setString(8,checkout);
        st.setString(9,checkouttime);
        st.setInt(10, no_of_room);
        st.setString(11, type_of_room);
        st.setString(12,address);
       int rs1 = st.executeUpdate();
        System.out.println(rs1);
        PreparedStatement st6 = (PreparedStatement) con.prepareStatement("update roombook rb set cost=((select cost_of_room from type_of_room where type_of_room=?)*no_of_room),room_number=FLOOR(1+RAND()*500) where rb.name=?");
     	
     	  
      	 
        st6.setString(1,(String)type_of_room);
        st6.setString(2,(String)name);
        rs1 = st6.executeUpdate();
        System.out.println(rs1);
        
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public int[] room_pay(String name)
	{
			int[] a = new int[2];
		try {
			PreparedStatement st = (PreparedStatement) con
	                .prepareStatement("select cost,room_number from roombook where name=?");
			st.setString(1,(String) name);
			ResultSet rs1 = st.executeQuery();	
			while(rs1.next())
			{
				a[0]=rs1.getInt("cost");
				a[1]=rs1.getInt("room_number");
			}
			System.out.println(a[0]);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return a;
	}
	
	public void payment_online(String name,String mode,String ui,int amount)
	{
		try {
			PreparedStatement st = (PreparedStatement) con
	                .prepareStatement("insert into payment (name,payment_mode,upi_id,amount) values(?,?,?,?)");
			st.setString(1,(String) name);
			st.setString(2,(String) mode);
			st.setString(3,ui);
			st.setInt(4, amount);
			
			int rs1 = st.executeUpdate();
	        System.out.println(rs1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	
	public void payment_card(String name,String mode,String card_no,String valid_till,String cvv,int amount)
	{
		try {
			PreparedStatement st = (PreparedStatement) con
	                .prepareStatement("insert into payment (name,payment_mode,card_no,validate,cvv,amount) values(?,?,?,?,?,?)");
			st.setString(1,(String) name);
			st.setString(2,(String) mode);
			st.setString(3,card_no);
			st.setString(4, (String)valid_till);
			st.setString(5, (String)cvv);
			st.setInt(6, amount);
			
			int rs1 = st.executeUpdate();
	        System.out.println(rs1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
}
