package services;

import java.util.Optional;


import javax.servlet.http.HttpServletRequest;

public interface LoginService {

	Optional<String> getUsername(HttpServletRequest request);
}
