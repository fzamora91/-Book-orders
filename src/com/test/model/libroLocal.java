package com.test.model;
import java.util.List;
import javax.ejb.Local;

@Local
public interface libroLocal 
{
    public void addLibro(libro l);
    public void updateLibro(libro l);
    public void deleteLibro(libro l);
    public List<libro>getLibros();
    public libro getLibroById(int id);
}