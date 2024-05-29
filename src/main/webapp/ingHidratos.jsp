<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="modelo.Ingrediente" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Seleccionar Ingredientes para Lunes (Hidratos)</title>
</head>
<body>
    <h1>Seleccionar Ingredientes para Lunes (Hidratos)</h1>

    <%
        // Retrieve ingredients from the request attribute
        List<Ingrediente> ingredientes = (List<Ingrediente>) request.getAttribute("ingConNut");

        // Initialize an empty list to store selected ingredients
        List<String> selectedIngredientesLunes = new ArrayList<>();

        // Check if the request contains selected ingredients for Monday (from the form submission)
        if (request.getParameterValues("ingredientesLunes") != null) {
            for (String ingredienteId : request.getParameterValues("ingredientesLunes")) {
                // Find the corresponding ingredient object based on ID
                Ingrediente ingrediente = ingredientes.stream()
                        .filter(i -> i.getIdIngrediente() == Integer.parseInt(ingredienteId))
                        .findFirst()
                        .orElse(null);

                if (ingrediente != null) {
                    selectedIngredientesLunes.add(ingrediente.getNombre());
                }
            }
        }
    %>

    <form action="guardarIngredientesLunes.jsp" method="post">
        <ul>
            <% for (Ingrediente ingrediente : ingredientes) { %>
                <li>
                    <label>
                        <input type="checkbox" name="ingredientesLunes" value="<%= ingrediente.getIdIngrediente() %>"
                               <%= selectedIngredientesLunes.contains(ingrediente.getNombre()) ? "checked" : "" %>>
                        <%= ingrediente.getNombre() %>
                    </label>
                </li>
            <% } %>
        </ul>
        <button type="submit">Guardar</button>
    </form>

</body>
</html>




