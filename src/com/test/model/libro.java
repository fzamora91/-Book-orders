package com.test.model;
import java.io.Serializable;

public class libro implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int id;
	private String titulo;
	
	public libro()
	{
		
	}
	
	public libro(int id, String titulo)
	{
		super();
		this.id=id;
		this.titulo=titulo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
