package persistencia;

import modelo.Usuario;

public interface UsuarioDao {

	public Usuario porUsername(String username);
}
