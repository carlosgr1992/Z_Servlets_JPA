package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;
import repository.UsuarioRepository;

public class SvUsuariosUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioRepository usuarioRepo = new UsuarioRepository();
	
    public SvUsuariosUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		long id = Long.parseLong(request.getParameter("idUserUpdate"));
		String dniNuevo = request.getParameter("dniUserUpdate");
		String nameNuevo = request.getParameter("nameUserUpdate");
		String surNameNuevo = request.getParameter("surNameUserUpdate");
		String telNuevo = request.getParameter("telUserUpdate");
		
		Usuario usuarioModificar = usuarioRepo.findUsuario(id);
		
		if(usuarioModificar != null) {
			usuarioModificar.setDni(dniNuevo);
			usuarioModificar.setName(nameNuevo);
			usuarioModificar.setSurName(surNameNuevo);
			usuarioModificar.setTel(telNuevo);
			
			usuarioRepo.updateUsuario(usuarioModificar);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else System.out.println("NO EXISTE EL ID"); request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

}
