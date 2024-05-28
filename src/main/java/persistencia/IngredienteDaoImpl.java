package persistencia;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import modelo.Categoria;
import modelo.Ingrediente;
import modelo.Nutriente;

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
	public void save (Ingrediente i) {
		EntityManager em = emf.createEntityManager();
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(i);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Ingrediente findByNombre (String nombre) {
		EntityManager em = emf.createEntityManager();
		Ingrediente resu = em.find(Ingrediente.class, nombre);
		em.close();
		return resu;
	}
	

	 @Override
	    public Ingrediente remove(int idIngrediente) {
	        EntityManager em = emf.createEntityManager();
	        try {
	            em.getTransaction().begin();
	            Ingrediente ingrediente = em.find(Ingrediente.class, idIngrediente);
	            if (ingrediente != null) {
	                em.remove(ingrediente);
	                em.getTransaction().commit();
	            } else {
	                em.getTransaction().rollback();
	            }
	            return ingrediente;
	        } catch (Exception e) {
	            if (em.getTransaction().isActive()) {
	                em.getTransaction().rollback();
	            }
	            e.printStackTrace();
	            return null;
	        } finally {
	            em.close();
	        }
	    }

	@Override
	public List<Ingrediente> getIngConNutrientes(String nombreNutriente) {
		EntityManager em = emf.createEntityManager();
		try {
			String jpql = "SELECT i FROM Ingrediente i WHERE i.categoria.nutriente.nombre = :nombreNutriente";
			TypedQuery<Ingrediente> q = em.createQuery(jpql, Ingrediente.class);
			q.setParameter("nombreNutriente",nombreNutriente);
			return q.getResultList();
		} finally {
			em.close();
		}
	}
}
