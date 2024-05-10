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
		            out.println("        <title>Bienvenido " + cookieOptional.get().getValue() + "</title>");
		            out.println("        <style>");
		            out.println("            body {");
		            out.println("                display: flex;");
		            out.println("                justify-content: center;");
		            out.println("                align-items: center;");
		            out.println("                height: 100vh;");
		            out.println("                font-family: Arial, sans-serif;");
		            out.println("                flex-direction: column; /* Para que los elementos se apilen verticalmente */");
		            out.println("                background-image: url('https://images.pexels.com/photos/7130557/pexels-photo-7130557.jpeg'), url('https://images.pexels.com/photos/2814828/pexels-photo-2814828.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'); /* Cambia 'ruta/a/imagen.jpg' por la ruta de tu imagen de fondo */");
		            out.println("                background-size: cover, cover; /* Para que las imágenes de fondo cubran todo el cuerpo */");
		            out.println("                background-position: center, center; /* Centra las imágenes de fondo */");
		            out.println("            }");
		            out.println("            h3 {");
		            out.println("                text-align: center;");
		            out.println("                margin-bottom: 20px; /* Espacio entre el encabezado y los enlaces */");
		            out.println("                font-size: 50px; /* Tamaño de letra más grande */");
		            out.println("            }");
		            out.println("            a {");
		            out.println("                color: #000;");
		            out.println("                font-weight: bold;");
		            out.println("                text-decoration: none;");
		            out.println("                transition: color 0.3s;");
		            out.println("            }");
		            out.println("            a:hover {");
		            out.println("                color: #555;");
		            out.println("            }");
		            out.println("            .second-background {");
		            out.println("                background-image: url('https://images.pexels.com/photos/2814828/pexels-photo-2814828.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');");
		            out.println("                opacity: 0.2; /* Ajusta la opacidad de la segunda imagen */");
		            out.println("                background-size: cover;");
		            out.println("                background-position: center;");
		            out.println("                position: absolute;");
		            out.println("                top: 0;");
		            out.println("                left: 0;");
		            out.println("                width: 100%;");
		            out.println("                height: 100%;");
		            out.println("            }");
		            out.println("        </style>");
		            out.println("    </head>");
		            out.println("    <body>");
		            out.println("        <div class=\"second-background\"></div>");
		            out.println("        <h3>¡Bienvenido " + cookieOptional.get().getValue() + ", vamos a ponernos la chaquetilla de chef!</h3>");
		            out.println("        <p><a href='" + req.getContextPath() + "/index.html'>Volver</a></p>");
		            out.println("        <p><a href='" + req.getContextPath() + "/inicio.jsp'>Inicio</a></p>");
//		            out.println("        <p><a href='" + req.getContextPath() + "/logout'>Cerrar sesión</a></p>");
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
