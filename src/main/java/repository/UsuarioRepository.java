package repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.mysql.cj.log.Log;

import modelo.Usuario;
import util.JPAUtil;

public class UsuarioRepository {

    private EntityManager em;

    public UsuarioRepository(EntityManager em) {
        this.em = JPAUtil.getEntityManager();
    }
    
    public UsuarioRepository() {
        this.em = JPAUtil.getEntityManager();
    }
    
    public Usuario findUsuario(long id) {
        return em.find(Usuario.class, id);
    }
    
    public List<Usuario> findAll(){
    	TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u",Usuario.class);
    	return query.getResultList();
    	
    }

    public void createUsuario(Usuario usuario) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(usuario);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    public void updateUsuario(Usuario usuario) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(usuario);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }
    
    public void updateUsuarioById(long id, Usuario usuarioNuevo) {
    
    	Usuario usuarioAntiguo = findUsuario(id);
    	
    	if(usuarioAntiguo != null) {
    	EntityTransaction tx = em.getTransaction();
    	try {
    	usuarioAntiguo.setDni(usuarioNuevo.getDni());
    	usuarioAntiguo.setName(usuarioNuevo.getName());
    	usuarioAntiguo.setSurName(usuarioNuevo.getSurName());
    	usuarioAntiguo.setTel(usuarioNuevo.getTel());
    	
    	em.merge(usuarioAntiguo);
    	tx.commit();
    	}catch(RuntimeException ex) {
    		if(tx.isActive()) {
    			tx.rollback();
    		}
    	}
    	}else System.out.println("El id de usuario " + id + " no existe");
    	
    }

    
    
    public void deleteUsuarioById(long id) {
        Usuario usuario = findUsuario(id);
        if (usuario != null) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                em.remove(usuario);
                tx.commit();
            } catch (RuntimeException e) {
                if (tx.isActive()) {
                    tx.rollback();
                }
                throw e;
            }
        }else System.out.println("El usuario no existe");	// AQUI REDIRIGIR A UNA VENTANA EMERGENTE QUE DE ERROR? O EN QUE PUNTO VALIDAR ESO?
    }
}



