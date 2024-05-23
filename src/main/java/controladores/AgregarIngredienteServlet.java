package controladores;

import modelo.Categoria;
import modelo.Ingrediente;
import negocio.Calendario;
import negocio.CalendarioImpl;
import persistencia.IngredienteDao;
import persistencia.IngredienteDaoImpl;
import persistencia.CategoriaDao;
import persistencia.CategeoriaDaoImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/añadir")
public class AgregarIngredienteServlet extends HttpServlet {
    private Calendario calendario;

    @Override
    public void init() throws ServletException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("comidas");
        IngredienteDao ingredienteDao = new IngredienteDaoImpl(emf);
        CategoriaDao categoriaDao = new CategeoriaDaoImpl(emf);
        this.calendario = new CalendarioImpl(ingredienteDao, categoriaDao);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Categoria> categorias = calendario.getCategorias();
        if (categorias != null && !categorias.isEmpty()) {
            request.setAttribute("categorias", categorias);
        } else {
            request.setAttribute("categorias", null);
        }
        request.getRequestDispatcher("/añadirIngrediente.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String categoriaIdStr = request.getParameter("categoria");
        
        if (nombre == null || nombre.trim().isEmpty() || categoriaIdStr == null || categoriaIdStr.trim().isEmpty()) {
            request.setAttribute("error", "El nombre del ingrediente y la categoría son obligatorios.");
            doGet(request, response);
            return;
        }

        try {
            int categoriaId = Integer.parseInt(categoriaIdStr);
            Categoria categoria = calendario.getCategorias().stream()
                                             .filter(c -> c.getIdCategoria() == categoriaId)
                                             .findFirst()
                                             .orElse(null);

            if (categoria != null) {
                Ingrediente nuevoIngrediente = new Ingrediente();
                nuevoIngrediente.setNombre(nombre);
                nuevoIngrediente.setCategoria(categoria);

                calendario.addIngrediente(nuevoIngrediente);
                request.setAttribute("success", "Ingrediente añadido con éxito.");
            } else {
                request.setAttribute("error", "Categoría no encontrada.");
            }

            doGet(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "ID de categoría no válido.");
            doGet(request, response);
        }
    }
}
