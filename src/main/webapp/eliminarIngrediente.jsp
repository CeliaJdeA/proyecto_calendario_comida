<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Ingrediente" %>
<!DOCTYPE html>
<html>
<head>
    <title>Seleccionar Ingredientes a Eliminar</title>
</head>
<body>
    <h1>Seleccionar Ingredientes a Eliminar</h1>

    <%
        String error = (String) request.getAttribute("error");
        String success = (String) request.getAttribute("success");
        if (error != null) {
    %>
        <p style="color: red;"><%= error %></p>
    <%
        }
        if (success != null) {
    %>
        <p style="color: green;"><%= success %></p>
    <%
        }
    %>

    <form action="<%= request.getContextPath() %>/eliminarIngrediente" method="post">
        <table>
            <tr>
                <th>Seleccionar</th>
                <th>Ingrediente</th>
                <th>Categoría</th>
            </tr>
            <%
                List<Ingrediente> ingredientes = (List<Ingrediente>) request.getAttribute("ingredientes");
                if (ingredientes != null && !ingredientes.isEmpty()) {
                    for (Ingrediente ingrediente : ingredientes) {
            %>
                        <tr>
                            <td><input type="checkbox" name="ingredientesAEliminar" value="<%= ingrediente.getIdIngrediente() %>"></td>
                            <td><%= ingrediente.getNombre() %></td>
                            <td><%= ingrediente.getCategoria().getNombre() %></td>
                        </tr>
            <%
                    }
                } else {
            %>
                    <tr>
                        <td colspan="3">No hay ingredientes disponibles para eliminar.</td>
                    </tr>
            <%
                }
            %>
        </table>
        <input type="submit" value="Eliminar Ingredientes Seleccionados">
    </form>

    <form action="<%= request.getContextPath() %>/lista" method="get" style="display: inline;">
        <button type="submit">Volver a la Lista de Ingredientes</button>
    </form>
</body>
</html>

