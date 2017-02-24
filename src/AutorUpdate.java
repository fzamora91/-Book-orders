

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AutorUpdate
 */
@WebServlet("/AutorUpdate")
public class AutorUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutorUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	if(request.getParameter("nombre")==null)
    	{
    		int id=Integer.parseInt(request.getParameter("id"));
    		com.test.model.autor a=new com.test.model.autorDao().getAutorById(id);
    		/*a.setId(a.getId());
    		a.setNombre(a.getNombre());
    		a.setApellido(a.getApellido());*/
    		request.setAttribute("autor",a);	
    		request.setAttribute("titulo", "Actulizar usuario");
    		request.getRequestDispatcher("/autor/formAutor.jsp").forward(request, response);	
    	}
    	else
    	{
    		com.test.model.autor a=new com.test.model.autor();
    		a.setId(Integer.parseInt(request.getParameter("id"))); 
    		a.setNombre(request.getParameter("nombre")); 
    		a.setApellido(request.getParameter("apellido"));
    		new com.test.model.autorDao().updateAutor(a);
    		request.getRequestDispatcher("/AutorDefault").forward(request, response);
    	}
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
