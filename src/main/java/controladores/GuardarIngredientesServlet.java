package controladores;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistencia.IngredienteDao;
import persistencia.IngredienteDaoImpl;

/* Este servlet maneja la solicitud POST enviada desde ingHidratos.jsp. Guarda los ingredientes seleccionados en la sesión del usuario, utilizando el día de la semana y el tipo de comida como claves.*/

@WebServlet("/guardarIngredientes")
public class GuardarIngredientesServlet extends HttpServlet {
    
	private IngredienteDao ingredienteDao; // Declaración del campo ingredienteDao
	
	@Override
    public void init() throws ServletException {
        super.init();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("comidas");
        ingredienteDao = new IngredienteDaoImpl(emf); // Inicialización de ingredienteDao
    }
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	
    	// Obtiene el dia de la semana y el tipo de comida del formulario
    	String dia = req.getParameter("dia");
        String comidaCena = req.getParameter("comidaCena");
        // Obtiene los ingredientes seleccionados a través de los parámetros de solicitud
        String[] ingredientesSeleccionados = req.getParameterValues("ingredientes");

        // Se crea una sesión (HttpSession) si aún no existe una. Luego se inicializa una lista llamada ingredientes
        HttpSession session = req.getSession();
        List<String> nombresIngredientes = new ArrayList<>();
 
        if (ingredientesSeleccionados != null) { // Si hay ingredientes seleccionados (es decir, si ingredientesSeleccionados no es nulo), se recorre el arreglo de ingredientes seleccionados y se añade cada uno a la lista ingredientes.
            for (String ingredienteId : ingredientesSeleccionados) {
            	String nombreIngrediente = ingredienteDao.getNombreIngPorId(ingredienteId);
                nombresIngredientes.add(nombreIngrediente);
            }
        }

        // Guardar los ingredientes seleccionados en la sesión
        session.setAttribute(dia + "-" + comidaCena, nombresIngredientes);

        // Redirigir de nuevo al calendario
        resp.sendRedirect(req.getContextPath() + "/calendario");
    }
}

