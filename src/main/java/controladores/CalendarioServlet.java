package controladores;



import modelo.Categoria;

import modelo.Ingrediente;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.List;

@WebServlet("/calendario")
public class CalendarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            // Crear una categoría de ejemplo
            Categoria categoria1 = new Categoria("Lácteos");

            // Prepara datos de prueba simulados
            List<Ingrediente> ingredientes = new ArrayList<>();
            ingredientes.add(new Ingrediente("Huevos", categoria1));
            ingredientes.add(new Ingrediente("Leche", categoria1));
            ingredientes.add(new Ingrediente("Queso", categoria1));

            // Generar el HTML directamente en el servlet
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calendario de Comidas</title>");
            out.println("<style>");
            out.println("table { width: 100%; border-collapse: collapse; }");
            out.println("th, td { border: 1px solid black; padding: 10px; text-align: center; }");
            out.println("th { background-color: #f2f2f2; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Calendario de Comidas</h2>");
            
            if (ingredientes != null && !ingredientes.isEmpty()) {
                out.println("<table>");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th>Día</th>");
                out.println("<th>Comida</th>");
                out.println("<th>Cena</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                
                String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
                for (String dia : dias) {
                    out.println("<tr>");
                    out.println("<td>" + dia + "</td>");
                    out.println("<td>");
                    out.println("<select name=\"comida_" + dia.toLowerCase() + "\">");
                    for (Ingrediente ing : ingredientes) {
                        out.println("<option value=\"" + ing.getIdIngrediente() + "\">" + ing.getNombre() + "</option>");
                    }
                    out.println("</select>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<select name=\"cena_" + dia.toLowerCase() + "\">");
                    for (Ingrediente ing : ingredientes) {
                        out.println("<option value=\"" + ing.getIdIngrediente() + "\">" + ing.getNombre() + "</option>");
                    }
                    out.println("</select>");
                    out.println("</td>");
                    out.println("</tr>");
                }
                
                out.println("</tbody>");
                out.println("</table>");
            } else {
                out.println("<p>No hay ingredientes disponibles.</p>");
            }
            
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir
            e.printStackTrace(out);
            out.println("<p style='color: red;'>Error al recuperar la lista de ingredientes.</p>");
        } finally {
            out.close();
        }
    }}


