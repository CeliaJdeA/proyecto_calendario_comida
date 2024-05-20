package controladores;

import negocio.Calendario;
import negocio.CalendarioImpl;
import modelo.Ingrediente;
import persistencia.IngredienteDao;
import persistencia.IngredienteDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/calendario")
public class CalendarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private Calendario calendario;

    @Override
    public void init() throws ServletException {
        super.init();
        IngredienteDao ingredienteDao = new IngredienteDaoImpl(null);
        calendario = new CalendarioImpl(ingredienteDao);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ingrediente> ingredientes = calendario.getIngredientes();
        request.setAttribute("ingredientes", ingredientes);
        request.getRequestDispatcher("/calendario.jsp").forward(request, response);
    }
}

