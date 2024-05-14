package persistencia;

import java.util.List;

import modelo.Usuario;
import repository.UsuarioRepository;

public class ControladorPersistencia {

	
	 UsuarioRepository usuJpa = new UsuarioRepository(); 
	
	 public void crearUsuario(Usuario usu) {
		 
		 usuJpa.createUsuario(usu);
		 
	 }
	 
	 public List<Usuario> traerUsuarios(){
		 
		 return usuJpa.findAll();
		 
	 }
	
}
