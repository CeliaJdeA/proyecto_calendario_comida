package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;



import modelo.Usuario;

public class UsuarioDaoImpl implements UsuarioDao{

	private EntityManagerFactory emf;
	public UsuarioDaoImpl(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public void save(Usuario u) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		em.close();
	}

}
