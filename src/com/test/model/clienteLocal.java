package com.test.model;
import java.util.List;
import javax.ejb.Local;

@Local
public interface clienteLocal 
{
    public void addCliente(cliente cl);
    public void updateCliente(cliente cl);
    public void deleteCliente(cliente cl);
    public cliente getClienteById(int id);
    public List<cliente> getClientes();
}
