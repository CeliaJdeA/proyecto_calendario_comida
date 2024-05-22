package persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import modelo.Categoria;
import modelo.Ingrediente;


public class CategeoriaDaoImpl implements CategoriaDao{

	private EntityManagerFactory emf;

	public CategeoriaDaoImpl(EntityManagerFactory emf) {
		this.emf = emf;
	}
	

	@Override
	public List<Categoria> findAll() {
		EntityManager em = emf.createEntityManager();
		try {
            em.getTransaction().begin();
            String jpql = "select c from Categoria c";
            TypedQuery<Categoria> q = em.createQuery(jpql, Categoria.class);
            List<Categoria> resultado = q.getResultList();
            em.getTransaction().commit();
            return resultado;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            // Manejar o registrar la excepción adecuadamente
            e.printStackTrace();
            return null; // O lanzar una excepción personalizada
        } finally {
            em.close();
        }
	}

	@Override
	public void save (Categoria c) {
		EntityManager em = emf.createEntityManager();
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		em.close();
		
	}


	@Override
	public Categoria findByNombre(String nombre) {
		EntityManager em = emf.createEntityManager();
		Categoria resu = em.find(Categoria.class, nombre);
		em.close();
		return resu;
	}

}
