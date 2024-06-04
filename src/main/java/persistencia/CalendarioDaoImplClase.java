package persistencia;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import modelo.Calendario;
import modelo.Usuario;

public class CalendarioDaoImplClase implements CalendarioDaoClase{

	 private EntityManagerFactory emf;

	    public CalendarioDaoImplClase(EntityManagerFactory emf) {
	        this.emf = emf;
	    }

		@Override
		public void save(Calendario calendario) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Calendario> findByUsuario(Usuario usuario) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Calendario> findByUsuarioAndDiaAndComidaCenaAndTipoNutriente(Usuario usuario, String dia,
				String comidaCena, String tipoNutriente) {
			// TODO Auto-generated method stub
			return null;
		}
	

}
