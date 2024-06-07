<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Categoria" %>
<!DOCTYPE html>
<html>
<head>
    <title>Añadir Nuevo Ingrediente</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/formAñadir.css">
</head>
<body>
    <h1>Añadir Nuevo Ingrediente</h1>

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

    <form action="<%= request.getContextPath() %>/añadir" method="post">
        <label for="nombre">Nombre del Ingrediente:</label>
        <input type="text" id="nombre" name="nombre" required><br>
        
        <label for="categoria">Categoría:</label>
        <select id="categoria" name="categoria" required>
            <%
                List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
                if (categorias != null && !categorias.isEmpty()) {
                    for (Categoria categoria : categorias) {
            %>
                        <option value="<%= categoria.getIdCategoria() %>"><%= categoria.getNombre() %></option>
            <%
                    }
                } else {
            %>
                    <option value="">No hay categorías disponibles</option>
            <%
                }
            %>
        </select><br>
        
        <button type="submit">Añadir ingrediente</button>
    </form>

    <a href="<%= request.getContextPath() %>/lista" class="boton">Volver a la lista de Ingredientes</a>
</body>
</html>
