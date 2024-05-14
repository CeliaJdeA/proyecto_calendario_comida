package controladores;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Ingrediente;
import services.IngredienteService;
import services.IngredienteServiceImpl;

@WebServlet("/calendario")
public class CalendarioServlet extends HttpServlet{
	
	/*se crea una instancia de la interfaz IngredienteService y se inicializa con una implementación concreta IngredienteServiceImpl(). Esto significa que el servlet tendrá acceso a los métodos definidos en IngredienteService a través de esta instancia, como por ejemplo, listar().
	 * */
	private IngredienteService ingredienteService = new IngredienteServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// se llama al método listar() del servicio de ingredientes para obtener una lista de ingredientes. Esta lista se utiliza más adelante en el servlet.
				List<Ingrediente> ingredientes = ingredienteService.listar();
		        //  Se establece un atributo de solicitud llamado "ingredientes" y se le asigna el valor de la lista de ingredientes que se obtuvo del servicio.
				req.setAttribute("ingredientes", ingredientes);
				// Esta línea envía la solicitud y la respuesta al servlet o JSP especificado en la URL de destino ("/calendario.jsp" en este caso). Este método de reenvío de solicitud (forward()) le permite al servlet o JSP destino tener acceso a los atributos de solicitud establecidos en el servlet actual. Esto significa que la lista de ingredientes que se estableció como un atributo de solicitud estará disponible en el JSP calendario.jsp.
		        getServletContext().getRequestDispatcher("/calendario.jsp").forward(req, resp);
	}
}	
