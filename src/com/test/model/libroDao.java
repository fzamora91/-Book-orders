package com.test.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class libroDao implements libroLocal
{
	private String Driver="com.mysql.jdbc.Driver";
    private String db="jdbc:mysql://localhost/new_db";
    private String Table="book";
    private String User="root";
    private String Password="root";
    
	@Override
	public void addLibro(libro l) 
	{
		// TODO Auto-generated method stub
		try
		{
			Class.forName(Driver).newInstance();
			Connection conn = DriverManager.getConnection(db, User, Password);
			String sql = "INSERT INTO " + Table + " (id, titulo) VALUES (?, ?)";
			PreparedStatement stm=conn.prepareStatement(sql);
			int rowInserted=stm.executeUpdate();
			if(rowInserted>0)
			{
				System.out.println("A user book been deleted sueccesfully");
			}
		}
		catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}	
	}

	@Override
	public void updateLibro(libro l) 
	{
		// TODO Auto-generated method stub
		try
		{
			Class.forName(Driver).newInstance();
			Connection conn = DriverManager.getConnection(db, User, Password);
			String sql="UPDATE " + Table + " SET titulo=? WHERE id=?";
			PreparedStatement stm=conn.prepareStatement(sql);
			int rowUpdated=stm.executeUpdate();
			if(rowUpdated>0)
			{
				System.out.println("A book has been deleted sueccesfully");
			}
		}
		catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void deleteLibro(libro l) 
	{
		// TODO Auto-generated method stub
		try
		{
			Class.forName(Driver).newInstance();
			Connection conn = DriverManager.getConnection(db, User, Password);
			String sql="DELETE FROM " + Table + " WHERE id=?;";
			PreparedStatement stm=conn.prepareStatement(sql);
			int rowDeleted=stm.executeUpdate();
			if(rowDeleted>0)
			{
				System.out.println("A book has been deleted sueccesfully");
			}
		}
		catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<libro> getLibros() 
	{
		// TODO Auto-generated method stub
		List<libro> libros= new ArrayList<libro>();
		try
		{
			Class.forName(Driver).newInstance();
			Connection conn = DriverManager.getConnection(db, User, Password);
			Statement stmt = conn.createStatement();
			String sql = "SELECT id, titulo FROM " + Table+";";
			ResultSet rs=null;
			rs = stmt.executeQuery(sql);
			while (rs.next())
		    {
				libro l=new libro();
				l.setId(rs.getInt(1));
				l.setTitulo(rs.getString(2));
				libros.add(l);
		    } 
			
		}
		catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
		return libros;
	}

	@Override
	public libro getLibroById(int id) 
	{
		// TODO Auto-generated method stub
		libro lb=new libro();
		try
		{
			Class.forName(Driver).newInstance();
			Connection conn = DriverManager.getConnection(db, User, Password);
			String sql="select id, titulo from "+Table+" where id=?;";
			PreparedStatement stm=conn.prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet rs = null;
			rs = stm.executeQuery();
			while (rs.next())
		    {
				lb.setId(rs.getInt(1));
				lb.setTitulo((rs.getString(2)));
		    }
		}
		catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
		return lb;
	}

}
