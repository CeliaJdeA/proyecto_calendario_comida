<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Ingrediente" %>
<html>
<head>
    <title>Calendario de Comidas</title>
    <style>
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid black; padding: 10px; text-align: center; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h2>Calendario de Comidas</h2>

    <%
        List<modelo.Ingrediente> ingredientes = (List<modelo.Ingrediente>) request.getAttribute("ingredientes");
        if (ingredientes != null && !ingredientes.isEmpty()) {
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
                                <%
                                    for (modelo.Ingrediente ing : ingredientes) {
                                %>
                                    <option value="<%= ing.getIdIngrediente() %>"><%= ing.getNombre() %></option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                        <td>
                            <select name="cena_<%= dia.toLowerCase() %>">
                                <%
                                    for (modelo.Ingrediente ing : ingredientes) {
                                %>
                                    <option value="<%= ing.getIdIngrediente() %>"><%= ing.getNombre() %></option>
                                <%
                                    }
                                %>
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
    %>
        <p>No hay ingredientes disponibles.</p>
    <%
        }
    %>
</body>
</html>
