package controladores;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;
import negocio.Calendario;
import negocio.CalendarioImpl;
import persistencia.CategeoriaDaoImpl;
import persistencia.CategoriaDao;
import persistencia.IngredienteDao;
import persistencia.IngredienteDaoImpl;
import persistencia.UsuarioDao;
import persistencia.UsuarioDaoImpl;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet{
	
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Usuario nuevoUsuario = new Usuario();
		nuevoUsuario.setNombre(nombre);
		nuevoUsuario.setApellido(apellido);
		nuevoUsuario.setUsername(username);
		nuevoUsuario.setPassword(password);
			
		calendario.addUsuario(nuevoUsuario);
		resp.sendRedirect(req.getContextPath() + "/inicio.jsp");
		
	}
}
