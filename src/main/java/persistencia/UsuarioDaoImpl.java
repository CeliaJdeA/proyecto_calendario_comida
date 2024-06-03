package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

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

	@Override
	public Usuario findByUsername(String username) {
		EntityManager em = emf.createEntityManager();
		try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.username = :username", Usuario.class)
                     .setParameter("username", username)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

}
