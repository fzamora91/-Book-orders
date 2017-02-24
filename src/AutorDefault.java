import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AutorServlet
 */
@WebServlet("/AutorDefault")
public class AutorDefault extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AutorDefault() {
        super();
        // TODO Auto-generated constructor stub
    }
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	//request.setAttribute("autorList", new com.test.model.autorDao().getAutorById());
    	request.setAttribute("autorList", new com.test.model.autorDao().getAutors());
    	request.getRequestDispatcher("/autor/listarAutor.jsp").forward(request, response);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
