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

@WebServlet("/eliminarIngrediente")
public class EliminarIngredienteServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Ingrediente> ingredientes = calendario.getIngredientes();
        if (ingredientes != null && !ingredientes.isEmpty()) {
            request.setAttribute("ingredientes", ingredientes);
        } else {
            request.setAttribute("ingredientes", null);
        }
        request.getRequestDispatcher("/eliminarIngrediente.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] ingredientesAEliminarIds = request.getParameterValues("ingredientesAEliminar");
        if (ingredientesAEliminarIds != null) {
            for (String id : ingredientesAEliminarIds) {
                int idIngrediente = Integer.parseInt(id);
                calendario.removeIngrediente(idIngrediente);
            }
            request.setAttribute("success", "Ingredientes eliminados con éxito.");
        } else {
            request.setAttribute("error", "No se seleccionaron ingredientes para eliminar.");
        }
        doGet(request, response);
    }
}
