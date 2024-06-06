<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="modelo.Ingrediente" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Proteínas</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estiloBase.css">
</head>
<body>
    <h2>Seleccionar Ingredientes - Proteínas</h2>
    <form action="<%= request.getContextPath() %>/guardarIngredientes" method="post">
    	<!-- Este campo oculto envía el día de la semana al servlet GuardarIngredientesServlet cuando se envía el formulario. El valor se obtiene del parámetro de consulta llamado "dia", que probablemente se establece en la vista calendario.jsp cuando el usuario hace clic en un día específico para agregar ingredientes. -->
        <input type="hidden" name="dia" value="<%= request.getParameter("dia") %>">
        <input type="hidden" name="comidaCena" value="<%= request.getParameter("comidaCena") %>">
        <ul> <!-- Itera sobre la lista de ingredientes (ingConNut) pasada desde el servlet ClasificaciónNutrientes. -->
            <% for (Ingrediente ingrediente : (List<Ingrediente>) request.getAttribute("ingConNut")) { %>
                <li>
                    <label> <!-- Cada ingrediente se representa como un checkbox en un formulario. El valor de cada checkbox es el ID del ingrediente. -->
                        <input type="checkbox" name="ingredientes" value="<%= ingrediente.getIdIngrediente() %>">
                        <%= ingrediente.getNombre() %>
                    </label>
                </li>
            <% } %>
        </ul> <!-- Cuando el usuario hace clic en "Guardar", el formulario envía los ingredientes seleccionados al servlet GuardarIngredientesServlet. -->
        <button type="submit">Guardar</button>
        <a href="<%= request.getContextPath() %>/calendario.jsp">Volver</a>
    </form>
</body>

</html>


