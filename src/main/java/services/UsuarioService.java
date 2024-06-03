package services;

import java.util.Optional;

import modelo.Usuario;

public interface UsuarioService {

	Optional<Usuario> login (String username, String password);
}
