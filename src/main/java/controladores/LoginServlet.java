package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/iniciar-sesion")
public class LoginServlet extends HttpServlet{
	 final static String USERNAME = "calendario";
	 final static String PASSWORD = "comidas";
	    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies() != null ? req.getCookies(): new Cookie[0];
		Optional<Cookie> cookieOptional = Arrays.stream(cookies)
				.filter(c-> "username".equals(c.getName())).findAny();
		
		 if (cookieOptional.isPresent()) {
			 resp.setContentType("text/html;charset=UTF-8");
	            try (PrintWriter out = resp.getWriter()) {

	                out.println("<!DOCTYPE html>");
	                out.println("<html>");
	                out.println("    <head>");
	                out.println("        <meta charset=\"UTF-8\">");
	                out.println("        <title>Hola " + cookieOptional.get().getValue() + "</title>");
	                out.println("    </head>");
	                out.println("    <body>"); 
	                out.println("        <h3>Hola " + cookieOptional.get().getValue() + " has iniciado sesión con éxito!</h3>");
	                out.println("<p><a href='" + req.getContextPath() + "/index.html'>volver</a></p>");
	                out.println("<p><a href='" + req.getContextPath() + "/inicio.jsp'>Inicio</a)</p>");
//	                out.println("<p><a href='" + req.getContextPath() + "/logout'>cerrar sesión</a></p>");
	                out.println("    </body>");
	                out.println("</html>");
	            } 
		 } else {
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


            resp.sendRedirect(req.getContextPath() + "/iniciar-sesion");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no esta autorizado para ingresar a esta página!");
        }
	}
}
