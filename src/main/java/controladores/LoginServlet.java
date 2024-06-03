package controladores;

import java.io.IOException;


import java.io.PrintWriter;

import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;
import negocio.Calendario;
import services.LoginService;
import services.LoginServiceImpl;
import negocio.CalendarioImpl;
import persistencia.CategeoriaDaoImpl;
import persistencia.CategoriaDao;
import persistencia.IngredienteDao;
import persistencia.IngredienteDaoImpl;
import persistencia.UsuarioDao;
import persistencia.UsuarioDaoImpl;

@WebServlet("/iniciar-sesion")
public class LoginServlet extends HttpServlet{
	private Calendario calendario;

    @Override
    public void init() throws ServletException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("comidas");
        IngredienteDao ingredienteDao = new IngredienteDaoImpl(emf);
        CategoriaDao categoriaDao = new CategeoriaDaoImpl(emf);
        UsuarioDao usuarioDao = new UsuarioDaoImpl(emf);
        this.calendario = new CalendarioImpl(ingredienteDao, categoriaDao, usuarioDao);
    }
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession sesion = req.getSession(false);
	        if (sesion != null && sesion.getAttribute("username") != null) {
	            getServletContext().getRequestDispatcher("/inicio.jsp").forward(req, resp);
	        } else {
	            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
	        }	
	    }
	 
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String username = req.getParameter("username");
	        String password = req.getParameter("password");
//			Busca el usuario en la BBDD
	        Usuario usuario = calendario.getUsuarioByUsername(username); 
//			Si el usuario no es null y la password coincide, se crea una sesión y se redirige al usuario a inicio.jsp.
	        if (usuario != null && usuario.getPassword().equals(password)) {
	            HttpSession sesion = req.getSession();
	            sesion.setAttribute("username", username);
	            resp.sendRedirect(req.getContextPath() + "/inicio.jsp");
	        } else {
	            if (usuario == null) {
	                req.setAttribute("usernameError", "Usuario incorrecto");
	            } else {
	                req.setAttribute("passwordError", "Contraseña incorrecta");
	            }
	            req.getRequestDispatcher("/login.jsp").forward(req, resp);
	        }
	    }
}