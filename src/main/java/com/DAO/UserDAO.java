package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.User.UserDetails;

public class UserDAO {
	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addUser(UserDetails us)
	{
		boolean f=false;
		try {
			
			String sql="insert into user(name,email,password) values(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, us.getFirstname());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPassword());
			int i=ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}

					
		} catch (Exception e) {
		}
		return f;
	}
	
	public UserDetails loginUser(UserDetails us)
	{
		UserDetails user=null;
		try
		{
			String sql2="select * from user where email=? and password=?";
			PreparedStatement ps1=conn.prepareStatement(sql2);
			
			ps1.setString(1, us.getEmail());
			ps1.setString(2, us.getPassword());
			
			ResultSet rs=ps1.executeQuery();
			if(rs.next())
			{
				user=new UserDetails();
				user.setId(rs.getInt("id"));

				user.setFirstname(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));

			}
			
			
		}
		catch(Exception er)
		{
			er.printStackTrace();
		}
 		return user;
	}
	
	
	}


