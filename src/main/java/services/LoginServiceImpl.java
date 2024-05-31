package services;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginServiceImpl implements LoginService {

	@Override
	public Optional<String> getUsername(HttpServletRequest request) {
//		Creamos una sesion. Se hace de forma automatica por cada cliente o navegador web y accedemos mediante el objeto 'request'.		
		HttpSession sesion = request.getSession();
//		Obtenemos un valor o un objeto que ya esté guardado utilizamos el método .getAttribute y el nombre con el cual se guardó
		String username = (String) sesion.getAttribute("username"); // Devuelve tippo Objecto y por eso hacemos cast a un String
		if (username != null) { // Si el username existe devolvemos un Optional del username, sino devolvemos un Optional vacío
			return Optional.of(username); // '.of': Convertir un objeto a un Optional de algun tipo (String)
		}
		return Optional.empty();
	}

}
