<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Ingrediente" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Ingredientes</title>
</head>
<body>
    <h1>Lista de Ingredientes</h1>
    <table border="1">
        <tr>
            <th>Ingrediente</th>
            <th>Categoría</th>
        </tr>
        <%
            List<Ingrediente> ingredientes = (List<Ingrediente>) request.getAttribute("ingredientes");
            for (Ingrediente ingrediente : ingredientes) {
        %>
            <tr>
                <td><%= ingrediente.getNombre() %></td>
                <td><%= ingrediente.getCategoria().getNombre() %></td>
            </tr>
        <%
            }
        %>
    </table>
    <a class="boton" href="<%= request.getContextPath() %>/añadirIngrediente.jsp">Añadir nuevo ingrediente</a>
</body>
</html>
