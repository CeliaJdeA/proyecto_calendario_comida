package persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import modelo.Ingrediente;

public class IngredienteDaoImpl implements IngredienteDao {

    private EntityManagerFactory emf;

    public IngredienteDaoImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Ingrediente> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            String jpql = "select i from Ingrediente i";
            TypedQuery<Ingrediente> q = em.createQuery(jpql, Ingrediente.class);
            List<Ingrediente> resultado = q.getResultList();
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
	public void save(Ingrediente i) {
		// TODO Auto-generated method stub
		
	}

	
}
