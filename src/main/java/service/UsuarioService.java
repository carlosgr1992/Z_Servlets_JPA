package service;

import java.util.List;

import modelo.Usuario;
import persistencia.ControladorPersistencia;
import repository.UsuarioRepository;

public class UsuarioService {
	// Creamos un objeto repository
	private UsuarioRepository usuarioRepo = new UsuarioRepository();
	
	
	
	public void crearUsuario(Usuario usu) {
		
		usuarioRepo.createUsuario(usu);
		
	}
	
	public List<Usuario> findAll(){
		
		return usuarioRepo.findAll();
	}
	
	public void deleteUserById(long id) {
		
		usuarioRepo.deleteUsuarioById(id);
		
	}
	
	public void updateUser(Usuario usuario) {
		
		usuarioRepo.updateUsuario(usuario);
	}
	
	public void updateUserById(long id, Usuario usu) {
		
		usuarioRepo.updateUsuarioById(id, usu);
		
	}
	
}
