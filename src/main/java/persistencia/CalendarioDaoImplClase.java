package persistencia;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import modelo.CalendarioClase;
import modelo.Ingrediente;
import modelo.Usuario;

public class CalendarioDaoImplClase implements CalendarioDaoClase{

	 private EntityManagerFactory emf;

	    public CalendarioDaoImplClase(EntityManagerFactory emf) {
	        this.emf = emf;
	    }

		@Override
		public void save(CalendarioClase calendario) {
			EntityManager em = emf.createEntityManager();
			em = emf.createEntityManager();
			em.merge(calendario);
			em.getTransaction().commit();
			em.close();	
		}

		@Override
		public List<CalendarioClase> findByUsuario(Usuario usuario) {
			EntityManager em = emf.createEntityManager();
			try {
				String jpql = "SELECT c FROM Calendario c WHERE c.usuario = :usuario";
				TypedQuery<CalendarioClase> q = em.createQuery(jpql, CalendarioClase.class);
				q.setParameter("usuario", usuario);
				return q.getResultList();
			} finally {
				em.close();
			}
		}

		@Override
		public List<CalendarioClase> findByUsuarioAndDiaAndComidaCenaAndTipoNutriente(Usuario usuario, String dia,
				String comidaCena, String tipoNutriente) {
			EntityManager em = emf.createEntityManager();
			try {
				String jpql = "SELECT c FROM Calendario c WHERE c.usuario = :usuario AND c.dia = :dia AND c.comidaCena = :comidaCena AND c.tipoNutriente = :tipoNutriente";
				TypedQuery<CalendarioClase> q = em.createQuery(jpql, CalendarioClase.class);
				q.setParameter("usuario", usuario);
				q.setParameter("dia", dia);
				q.setParameter("comidaCena", comidaCena);
				q.setParameter("tipoNutriente", tipoNutriente);
				return q.getResultList();
			} finally {
				em.close();
			}
		}

		@Override
		public CalendarioClase remove(int idCalendario) {
			 EntityManager em = emf.createEntityManager();
		        try {
		            em.getTransaction().begin();
		            CalendarioClase cal = em.find(CalendarioClase.class, idCalendario);
		            if (cal != null) {
		                em.remove(cal);
		                em.getTransaction().commit();
		            } else {
		                em.getTransaction().rollback();
		            }
		            return cal;
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
	

}
