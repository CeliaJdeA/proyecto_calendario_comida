package controladores;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Optional;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.LoginService;
import services.LoginServiceImpl;

@WebServlet("/iniciar-sesion")
public class LoginServlet extends HttpServlet{
	 final static String USERNAME = "celia";
	 final static String PASSWORD = "comidas";
	    
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        LoginService auth = new LoginServiceImpl(); // Es una implementacion de la clase LoginServlet
	        Optional<String> usernameOptional = auth.getUsername(req);

	        if (usernameOptional.isPresent()) { // Si está presente la sesion damos el mensaje de bienvenida
	            resp.setContentType("text/html;charset=UTF-8");
	            try (PrintWriter out = resp.getWriter()) {
	            getServletContext().getRequestDispatcher("/inicio.jsp").forward(req, resp);
	            }
	        } else { // Sino, cargamos el formulario de login.html
	            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
	        	
	        }	
	    }
	 
/* 	 Si la autenticación es exitosa, se establece una cookie y se redirige al usuario a la página de inicio. 
	 Si la autenticación falla, se envía un mensaje de error al cliente. */	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        
        
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {

           HttpSession sesion = req.getSession();
           sesion.setAttribute("username", username);

            resp.sendRedirect(req.getContextPath() + "/inicio.jsp"); 
        } else {
        	// Credenciales incorrectas, enviar mensajes de error
            if (!USERNAME.equals(username)) {
                req.setAttribute("usernameError", "Usuario incorrecto");
            }
            if (!PASSWORD.equals(password)) {
                req.setAttribute("passwordError", "Contraseña incorrecta");
            }
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }    
	}
}