package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.User.Post;
import com.User.UserDetails;

public class postDAO {
	
	private Connection conn;

	public postDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addNotes(String ti,String co,int ui)
	{
		boolean f=false;
		try
		{
			String sd="insert into post(title,content,uid)values(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sd);
			ps.setString(1,ti);
			ps.setString(2,co);
			ps.setInt(3,ui);
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				f=true;
			}

			
		}
		catch(Exception ert)
		{
			ert.printStackTrace();
		}
		
		return f;
	}
	
	
	public List<Post> getData(int id)
	{
		
		List<Post> list=new ArrayList<Post>();
		Post po=null;
		
		try {
			
			String gn="select * from post where uid=? order by id DESC";
			PreparedStatement ps=conn.prepareStatement(gn);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{		po=new Post();

				po.setId(rs.getInt(1));
				po.setTitle(rs.getString(2));
				po.setContent(rs.getString(3));
				po.setPdate(rs.getTimestamp(4));
				
				list.add(po);
			}
			
			
		} catch (Exception e) {
		}
		
		return list;
	}
	
	public Post getDataById(int noteId)
	{
		Post p=null;
		
		try {
			String pd="select * from post where id=?";
			PreparedStatement ps=conn.prepareStatement(pd);
			ps.setInt(1,noteId);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{	
				p=new Post();

				p.setId(rs.getInt(1));
				p.setTitle(rs.getString(2));
				p.setContent(rs.getString(3));
				
			}
			
			
			
		}
		catch (Exception e) {
		}
		
		
		return p;
	}
	
	public boolean updatePost(int nid,String ti,String con)
	{
		boolean f=false;
		
		try {
			
			String sql="update post set title=?,content=?where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, ti);
			ps.setString(2, con);
			ps.setInt(3, nid);
			int i=ps.executeUpdate();
			
			if(i==1)
			{
				f=true;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
		
	}
	
	
	public boolean delPost(int nid)
	{
		boolean f=false;
		
		try {
			
			String sql="delete from post where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, nid);
		
			int i=ps.executeUpdate();
			
			if(i==1)
			{
				f=true;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
		
	}

}
