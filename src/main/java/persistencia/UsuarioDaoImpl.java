package persistencia;

import javax.persistence.EntityManagerFactory;



import modelo.Usuario;

public class UsuarioDaoImpl implements UsuarioDao{

	private EntityManagerFactory emf;
	public UsuarioDaoImpl(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public Usuario porUsername(String username) {
		
		return null;
	}

}
