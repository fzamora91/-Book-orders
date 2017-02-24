package com.test.model;
import java.io.Serializable;

public class autor implements Serializable
{
	private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private String apellido;
    
    public autor()
    {
    }
    
    public autor(int id, String nombre, String apellido)
    {
    	super();
    	this.id=id;
    	this.nombre=nombre;
    	this.apellido=apellido;
    }
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
