package com.test.model;
import java.util.List;
import javax.ejb.Local;

@Local
public interface autorLocal 
{
	public autor getAutorById(int id);
	public List<autor> getAutors();
	public void addAutor(autor autor);	
	public void updateAutor(autor autor);
	public void deleteAutor(autor autor);
}
