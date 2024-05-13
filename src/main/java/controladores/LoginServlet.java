package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.LoginService;
import services.LoginServiceImpl;

@WebServlet("/iniciar-sesion")
public class LoginServlet extends HttpServlet{
	 final static String USERNAME = "calendario";
	 final static String PASSWORD = "comidas";
	    
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        LoginService auth = new LoginServiceImpl(); // Es una implementacion de la clase LoginServlet
	        Optional<String> cookieOptional = auth.getUsername(req); 

	        if (cookieOptional.isPresent()) { // Si está presente la cookie damos el mensaje de bienvenida
	            resp.setContentType("text/html;charset=UTF-8");
	            try (PrintWriter out = resp.getWriter()) {
	            getServletContext().getRequestDispatcher("/login2.jsp").forward(req, resp);
	            }
	        } else { // Sino, cargamos el formulario de login.html
	            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
	        }
	    }
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {

            Cookie usernameCookie = new Cookie("username", username); 
            resp.addCookie(usernameCookie); 


            resp.sendRedirect(req.getContextPath() + "/login2.jsp"); // Es lo que me manda a la siguiente pagina
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no esta autorizado para ingresar a esta página!");
        }
	}
}
