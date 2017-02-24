package com.test.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class clienteDao implements clienteLocal 
{
	private String Driver="com.mysql.jdbc.Driver";
    private String db="jdbc:mysql://localhost/new_db";
    private String Table="client";
    private String User="root";
    private String Password="root";
    
	@Override
	public cliente getClienteById(int id) 
	{
		// TODO Auto-generated method stub
		cliente cl=new cliente();
		try
		{
			Class.forName(Driver);
			Connection conn=DriverManager.getConnection(db,User,Password);
			String sql="select id, nombre from "+Table+" where id=?;";
			PreparedStatement stm=conn.prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet rs = null;
			rs = stm.executeQuery();
			while (rs.next())
		    {
				cl.setId(rs.getInt(1));
				cl.setNombre(rs.getString(2));
		    }
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return cl;
	}

	@Override
	public List<cliente> getClientes() 
	{
		// TODO Auto-generated method stub
		List<cliente> clientes=new ArrayList<cliente>();
		try 
		{
    		Class.forName(Driver).newInstance();
			Connection conn = DriverManager.getConnection(db, User, Password);   
			Statement stmt = conn.createStatement();
			String sql = "SELECT id, nombre FROM " + Table+";";
			ResultSet rs=null;
			rs = stmt.executeQuery(sql);
			while (rs.next())
		    {
				cliente c=new cliente();
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				clientes.add(c);
		    } 
		}
    	catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
  		  // TODO Auto-generated catch block
  		  e.printStackTrace();
  	   }
		return clientes;
	}

	@Override
	public void addCliente(cliente cl) 
	{
		// TODO Auto-generated method stub
		try
		{
			Class.forName(Driver).newInstance();
			Connection conn = DriverManager.getConnection(db, User, Password);
			String sql = "INSERT INTO " + Table + " (id, nombre) VALUES (?, ?);";
			PreparedStatement stm=conn.prepareStatement(sql);
			stm.setInt(1, cl.getId());
			stm.setString(2, cl.getNombre());
			int rowsInserted=stm.executeUpdate();
			if(rowsInserted>0)
			{
				System.out.print("A new client was inserted successfully!");
			}
		}
		catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void updateCliente(cliente cl) 
	{
		// TODO Auto-generated method stub
		try
		{
			Class.forName(Driver).newInstance();
			Connection conn = DriverManager.getConnection(db, User, Password); 
			String sql="UPDATE " + Table + " SET id=?, nombre=? WHERE id=?;";
			PreparedStatement stm=conn.prepareStatement(sql);
			int rowUpdated=stm.executeUpdate();
			if(rowUpdated>0)
			{
				System.out.println("A client has been updated successfully");
			}
		}
		catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCliente(cliente cl) 
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
				System.out.println("A client has been deleted sueccesfully");
			}
		}
		catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}

}
