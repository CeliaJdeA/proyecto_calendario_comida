package services;

import java.util.Arrays;
import java.util.Optional;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class LoginServiceImpl implements LoginService {

	@Override
	public Optional<String> getUsername(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies() != null ? request.getCookies(): new Cookie[0];
        return Arrays.stream(cookies) // Obtenemos un arreglo con las cookies y la iteramos
                .filter(c-> "username".equals(c.getName())) // Filtramos por la cookie que contenga el nombre 'username'. 
                .map(Cookie::getValue) // Si la encuentra lo convertimos al tipo String invocando el método .getValue para obtener el valor de la cookie
                .findAny(); // Obtenemos la cookie
	}

}
