package com.test.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class autorDao implements autorLocal
{
    private String Driver="com.mysql.jdbc.Driver";
    private String db="jdbc:mysql://localhost/new_db";
    private String Table="author";
    private String User="root";
    private String Password="root";
    
    @Override
    public autor getAutorById(int id)
    {
       autor a=new autor();
       ResultSet rs=null;
       try
       {
    	   Class.forName(Driver).newInstance();
    	   Connection conn=DriverManager.getConnection(db,User,Password);
           String sql="Select id , nombre , apellido from " + Table + " where id = ?;";
           PreparedStatement statement = conn.prepareStatement(sql);
		   statement.setInt(1, id);
		   rs = statement.executeQuery();
		   while (rs.next())
		    {
				a.setId(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setApellido(rs.getString(3));
		    }
       }
       catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e)
       {
    	   e.printStackTrace();
       }
       return a;
    }
    
    @Override
    public List<autor> getAutors()
    {
    	List<autor> autors=new ArrayList<autor>();
    	ResultSet rs=null;
    	try 
		{
    		Class.forName(Driver).newInstance();
			Connection conn = DriverManager.getConnection(db, User, Password);   
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM " + Table+";";
			rs = stmt.executeQuery(sql);
			while (rs.next())
		    {
				autor a=new autor();
				a.setId(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setApellido(rs.getString(3));
				autors.add(a);
		    } 
		}
    	catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
  		  // TODO Auto-generated catch block
  		  e.printStackTrace();
  	   }
       return autors;
    }

	@Override
	public void addAutor(autor autor) 
	{
		// TODO Auto-generated method stub
		try 
		{
			Class.forName(Driver).newInstance();
			Connection conn = DriverManager.getConnection(db, User, Password);
			String sql = "INSERT INTO " + Table + " (id, nombre, apellido) VALUES (?, ?, ?)";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, autor.getId());
			statement.setString(2, autor.getNombre());
			statement.setString(3, autor.getApellido());
			 
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("A new user was inserted successfully!");
			}
		}
	    catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	   }
	}

	@Override
	public void updateAutor(autor autor)
	{
	   	try
	   	{
	   	   Class.forName(Driver).newInstance();
	   	   Connection conn=DriverManager.getConnection(db,User, Password);
	   	   String sql="UPDATE " + Table + " SET nombre=?, apellido=? WHERE id=?";
	   	   
	   	   PreparedStatement statement=conn.prepareStatement(sql);
	   	   statement.setInt(3, autor.getId());
	   	   statement.setString(1,autor.getNombre());
	   	   statement.setString(2, autor.getApellido());
	   	   
	   	   int rowUpdated=statement.executeUpdate();
	   	   if(rowUpdated>0)
	   	   {
	   		 System.out.println("A new user was updated successfully!");
	   	   }
	   	}
	   	catch(Exception e)
	   	{
	   		e.printStackTrace();
	   	}
	}
	
	@Override
	public void deleteAutor(autor autor)
	{
		try
	   	{
	   	   Class.forName(Driver).newInstance();
	   	   Connection conn=DriverManager.getConnection(db,User,Password);
	   	   String sql="DELETE FROM " + Table + " WHERE id=?;";
	   	   PreparedStatement statement=conn.prepareStatement(sql);
	   	   statement.setInt(1,autor.getId());
	   	   int rowDeleted=statement.executeUpdate();
	   	   if(rowDeleted>0)
	   	   {
	   		 System.out.println("A new user was deleted successfully!");
	   	   }
	   	}
	   	catch(Exception e)
	   	{
	   		e.printStackTrace();
	   	}
	}

}
