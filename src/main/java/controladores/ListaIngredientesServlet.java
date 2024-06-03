package controladores;

import java.io.IOException;


import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Ingrediente;
import negocio.Calendario;
import negocio.CalendarioImpl;
import persistencia.CategeoriaDaoImpl;
import persistencia.CategoriaDao;
import persistencia.IngredienteDao;
import persistencia.IngredienteDaoImpl;
import persistencia.UsuarioDao;
import persistencia.UsuarioDaoImpl;

@WebServlet("/lista")
public class ListaIngredientesServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private Calendario calendario;
	
	@Override
	public void init() throws ServletException {
		super.init();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("comidas");
		IngredienteDao ingredienteDao = new IngredienteDaoImpl(emf);
        CategoriaDao categoriaDao = new CategeoriaDaoImpl(emf);
        UsuarioDao usuarioDao = new UsuarioDaoImpl(emf);
		this.calendario = new CalendarioImpl(ingredienteDao, categoriaDao, usuarioDao);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Ingrediente> ingredientes = calendario.ordenarIngPorCat();
			request.setAttribute("ingredientes", ingredientes);
			request.getRequestDispatcher("/listaIngredientes.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException("Error al recuperar la lista de ingredientes", e);
		}
	}
}
