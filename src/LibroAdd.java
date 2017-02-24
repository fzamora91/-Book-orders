import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LibroAdd
 */
@WebServlet("/LibroAdd")
public class LibroAdd extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibroAdd() 
    {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
    	if(request.getParameter("titulo")==null)
    	{
    		request.setAttribute("titulo", "Agregar Libro");
        	request.getRequestDispatcher("/libro/formLibro.jsp").forward(request, response);	
    	}
    	else
    	{
    		com.test.model.libro lb=new com.test.model.libro();
    		lb.setId(Integer.parseInt(request.getParameter("id"))); 
    		lb.setTitulo(request.getParameter("titulo")); 
    		new com.test.model.libroDao().addLibro(lb);;
    		request.getRequestDispatcher("/LibroDefault").forward(request, response);	
    	}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
