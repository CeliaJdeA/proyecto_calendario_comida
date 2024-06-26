package controladores;

import modelo.Ingrediente;
import modelo.Usuario;
import negocio.Calendario;
import negocio.CalendarioImpl;
import persistencia.IngredienteDao;
import persistencia.IngredienteDaoImpl;
import persistencia.UsuarioDao;
import persistencia.UsuarioDaoImpl;
import persistencia.CategoriaDao;
import persistencia.CategeoriaDaoImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/calendario")
public class CalendarioServlet extends HttpServlet {
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
            // Obtener la lista de ingredientes desde la base de datos
            List<Ingrediente> ingredientes = calendario.getIngredientes();

            // Pasar la lista de ingredientes como un atributo en la solicitud
            request.setAttribute("ingredientes", ingredientes);

            // Reenviar la solicitud a la vista JSP
            request.getRequestDispatcher("/calendario.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Error al recuperar la lista de ingredientes", e);
        }
    }


}
