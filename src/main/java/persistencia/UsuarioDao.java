package persistencia;

import modelo.Usuario;

public interface UsuarioDao {

	public void save(Usuario u);
	public Usuario findByUsername(String username);
}
