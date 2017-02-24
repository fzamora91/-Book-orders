import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClienteAdd
 */
@WebServlet("/ClienteAdd")
public class ClienteAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteAdd() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	if(request.getParameter("nombre")==null)
    	{
    		request.setAttribute("titulo", "Agregar Cliente");
        	request.getRequestDispatcher("/cliente/formCliente.jsp").forward(request, response);		
    	}
    	else
    	{
    		com.test.model.cliente cl=new com.test.model.cliente();
    		cl.setId(Integer.parseInt(request.getParameter("id"))); 
    		cl.setNombre(request.getParameter("nombre")); 
    		new com.test.model.clienteDao().addCliente(cl);
    		request.getRequestDispatcher("/ClienteDefault").forward(request, response);
    	}
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
