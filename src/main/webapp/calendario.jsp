<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Ingrediente"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calendario de Comidas</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Calendario de Comidas</h2>
    <table>
        <thead>
            <tr>
                <th>Día</th>
                <th>Comida</th>
                <th>Cena</th>
            </tr>
        </thead>
        <tbody>
            <%
                String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
                Object ingredientesObj = request.getAttribute("ingredientes");
                if (ingredientesObj instanceof List<?>) {
                    List<Ingrediente> ingredientes = (List<Ingrediente>) ingredientesObj;
                    for (String dia : dias) {
            %>
            <tr>
                <td><%= dia %></td>
                <td>
                    <select name="comida_<%= dia.toLowerCase() %>">
                        <% for (Ingrediente ing : ingredientes) { %>
                            <option value="<%= ing.getIdIngrediente() %>"><%= ing.getNombre() %></option>
                        <% } %>
                    </select>
                </td>
                <td>
                    <select name="cena_<%= dia.toLowerCase() %>">
                        <% for (Ingrediente ing : ingredientes) { %>
                            <option value="<%= ing.getIdIngrediente() %>"><%= ing.getNombre() %></option>
                        <% } %>
                    </select>
                </td>
            </tr>
            <% 
                    }
                } else {
                    out.println("Error: La lista de ingredientes no está disponible.");
                }
            %>
        </tbody>
    </table>
</body>
</html>
