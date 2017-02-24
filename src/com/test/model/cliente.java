package com.test.model;
import java.io.Serializable;

public class cliente implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	
	public cliente()
	{
		
	}
	
	public cliente(int id, String nombre)
	{
		super();
		this.id=id;
		this.nombre=nombre;
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
}
