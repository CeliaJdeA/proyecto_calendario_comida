package services;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginServiceImpl implements LoginService {

	@Override
	public Optional<String> getUsername(HttpServletRequest request) {
		HttpSession sesion = request.getSession();
		String username = (String) sesion.getAttribute("username");
		if (username != null) {
			return Optional.of(username);
		}
		return Optional.empty();
	}

}
