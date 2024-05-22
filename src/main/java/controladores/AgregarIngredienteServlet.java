package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Categoria;
import modelo.Ingrediente;
import negocio.Calendario;
import negocio.CalendarioImpl;
import persistencia.IngredienteDao;
import persistencia.IngredienteDaoImpl;

@WebServlet("/añadir")
public class AgregarIngredienteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
    private Calendario calendario;
    
	@Override
    public void init() throws ServletException {
        super.init();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("comidas");
        IngredienteDao ingredienteDao = new IngredienteDaoImpl(emf);
        calendario = new CalendarioImpl(ingredienteDao);
    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
/*		String nombre = req.getParameter("nombre");
//		int idCategoria = Integer.parseInt(req.getParameter("idCategoria"));
		
		Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre(nombre);

//     Categoria categoria = 
        
		Map<String, String> errores = new HashMap<>();
		if (nombre == null || nombre.isBlank()) {
			errores.put("nombre", "El nombre es requerido");
		}
		if (categorias == null || categorias.length == 0) {
			errores.put("categorias", "La categoria es requerida es requerido");
		}*/
		
	}
}
