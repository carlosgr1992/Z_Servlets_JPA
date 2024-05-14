package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Usuario;
import service.UsuarioService;

@WebServlet("/SvUsuarios")
public class SvUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsuarioService service = new UsuarioService();

	private static final Logger log = Logger.getLogger("Servlet log: ");

	public SvUsuarios() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Creamos la sesión del usuario en cuestión
		HttpSession sesion = request.getSession();
		
		// Declaramos una lista nueva y le damos los valores de la base de datos.
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios = service.findAll();
		
		// Creamos un atributo llamado "listaUsuarios" al que le pasamos la lista de usuarios para mandarlos al JSP
		sesion.setAttribute("listaUsuarios", listaUsuarios);
		
		// Cambiamos la pantalla para ir a mostrarUsuarios.jsp
		response.sendRedirect("mostrarUsuarios.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

		HttpSession session = request.getSession(true);

		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = emf.createEntityManager();

		String dni = request.getParameter("dniUser");
		String nombre = request.getParameter("nameUser");
		String apellidos = request.getParameter("surNameUser");
		String telefono = request.getParameter("telUser");

		Usuario usu = new Usuario(dni,nombre,apellidos,telefono);

		service.crearUsuario(usu);

		// Nos movemos a la pantalla de index.jsp
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

}
