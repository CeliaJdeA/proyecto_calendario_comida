package persistencia;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CalendarioDaoImpl implements CalendarioDao{

	 private EntityManagerFactory emf;

	    public CalendarioDaoImpl(EntityManagerFactory emf) {
	        this.emf = emf;
	    }
	@Override
	public void guardarIngredientes(int usuarioId, String dia, String comidaCena, String tipo, List<Integer> ingredienteIds) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
		
	}

	@Override
	public Map<String, Map<String, List<String>>> obtenerIngredientesSeleccionados(int usuarioId) {
		// TODO Auto-generated method stub
		return null;
	}

}
