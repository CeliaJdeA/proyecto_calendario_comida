package controladores;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

/* Este servlet maneja la solicitud POST enviada desde ingHidratos.jsp. Guarda los ingredientes seleccionados en la sesión del usuario, 
 * utilizando el día de la semana y el tipo de comida como claves.*/

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
        
    	
// 		Obtiene el dia de la semana y el tipo de comida del formulario
    	String dia = req.getParameter("dia");
        String comidaCena = req.getParameter("comidaCena");
        String tipo = req.getParameter("tipo"); // Añadido para obtener el tipo de ingrediente (Hidratos, Vegetales, etc.)

 // 	Obtiene los ingredientes seleccionados a través de los parámetros de solicitud
        String[] ingredientesSeleccionados = req.getParameterValues("ingredientes");

// 		Se crea una sesión (HttpSession) si aún no existe una.
/* 		'ingredientesPorTipo' intenta obtener el atributo de la sesión que corresponde a la combinación del día y el tipo de comida 
        (por ejemplo, "Lunes-comida"). Este atributo debe ser un 'Map<String, List<String>>', donde la clave (String) es el tipo de ingrediente 
        (por ejemplo, "Hidratos") y el valor es una lista (List<String>)de nombres de ingredientes.*/
        HttpSession session = req.getSession();
        Map<String, List<String>> ingredientesPorTipo = (Map<String, List<String>>) session.getAttribute(dia + "-" + comidaCena);

// 		Si el ingredientesPorTipo es nulo (es decir, no existe aún en la sesión), se inicializa como un nuevo HashMap.
        if (ingredientesPorTipo == null) {
            ingredientesPorTipo = new HashMap<>();
        }
        
// 		Se obtiene la lista de nombres de ingredientes para el tipo específico (por ejemplo, "Hidratos"). Si esta lista no existe, 
// 		se inicializa como una nueva ArrayList.
        List<String> nombresIngredientes = ingredientesPorTipo.get(tipo);
        if (nombresIngredientes == null) {
            nombresIngredientes = new ArrayList<>();
        }
        
// 		Si hay ingredientes seleccionados (es decir, si ingredientesSeleccionados no es nulo), se recorre el arreglo de ingredientes 
//      seleccionados y se añade cada uno a la lista ingredientes.
        if (ingredientesSeleccionados != null) { 
            for (String ingredienteId : ingredientesSeleccionados) {
            	String nombreIngrediente = ingredienteDao.getNombreIngPorId(ingredienteId);
                nombresIngredientes.add(nombreIngrediente);
            }
        }
//		Se actualiza el Map con la lista de nombres de ingredientes para el tipo específico. 
//      Luego, se guarda este Map actualizado en la sesión con la clave dia + "-" + comidaCena.
        ingredientesPorTipo.put(tipo, nombresIngredientes);
        session.setAttribute(dia + "-" + comidaCena, ingredientesPorTipo);

        // Redirigir de nuevo al calendario
        resp.sendRedirect(req.getContextPath() + "/calendario");
    }
}

