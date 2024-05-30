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

@WebServlet("/nutrientes")
public class ClasificaciónNutrientes extends HttpServlet{

	private Calendario calendario;
	
	@Override
	public void init() throws ServletException {
		 super.init();
	     EntityManagerFactory emf = Persistence.createEntityManagerFactory("comidas");
	     IngredienteDao ingredienteDao = new IngredienteDaoImpl(emf);
	     CategoriaDao categoriaDao = new CategeoriaDaoImpl(emf);
	     calendario = new CalendarioImpl(ingredienteDao, categoriaDao);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tipoNutriente = req.getParameter("tipo");
        String jspPage = "No hay ingredientes guardados en la BBDD"; // Valor por defecto

        if (tipoNutriente != null) {
            List<Ingrediente> ingredientes = null;
            if (tipoNutriente.equalsIgnoreCase("Hidratos de carbono")) {
                ingredientes = calendario.getIngConHidratos();
                jspPage = "/ingHidratos.jsp";
            } else if (tipoNutriente.equalsIgnoreCase("Proteínas")) {
                ingredientes = calendario.getIngConProteinas();
                jspPage = "/ingProteinas.jsp";
            } else if (tipoNutriente.equalsIgnoreCase("Vitaminas y minerales")) {
                ingredientes = calendario.getIngConVegetales();
                jspPage = "/ingVegetales.jsp";
            } else if (tipoNutriente.equalsIgnoreCase("Grasas")) {
                ingredientes = calendario.getIngConGrasas();
                jspPage = "/ingGrasas.jsp";
            }

            req.setAttribute("ingConNut", ingredientes);
            req.getRequestDispatcher(jspPage).forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Tipo de nutriente no especificado");
        }
    }
}
