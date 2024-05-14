package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UsuarioService;

public class SvUsuarioDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioService usuarioService = new UsuarioService();
       
    public SvUsuarioDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		long id = Long.parseLong(request.getParameter("idUserDelete"));
		
		usuarioService.deleteUserById(id);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
