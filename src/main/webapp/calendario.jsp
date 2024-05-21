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
    <%
        Object error = request.getAttribute("error");
        if (error != null) {
            out.println("<p style='color: red;'>" + error + "</p>");
        } else {
            List<Ingrediente> ingredientes = (List<Ingrediente>) request.getAttribute("ingredientes");
            if (ingredientes != null && !ingredientes.isEmpty()) {
                out.println("<p>Ingredientes disponibles:</p>");
    %>
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
            %>
        </tbody>
    </table>
    <%
            } else {
                out.println("<p>No hay ingredientes disponibles.</p>");
            }
        }
    %>
</body>
</html>


