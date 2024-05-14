package persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import modelo.Ingrediente;

public class IngredienteDaoImpl implements IngredienteDao{

	private EntityManager em;
	private EntityManagerFactory emf;
	
	public IngredienteDaoImpl() {
		this.emf = EMF.getInstance();
	}
	
	@Override
	public List<Ingrediente> findAll() {
		em = emf.createEntityManager();
		String jpql = "select i from Ingrediente i";
		TypedQuery<Ingrediente> q = em.createQuery(jpql, Ingrediente.class);
		List<Ingrediente> resu = q.getResultList();
		em.close();
		return resu;
	}

}
