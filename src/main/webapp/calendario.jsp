<%@page contentType="UTF-8" import="java.util.List, modelo.Ingrediente "  %>
<%
List<Ingrediente> ingredientes = (List<Ingrediente>) request.getAttribute("ingredientes");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calendario comida</title>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }
    th, td {
        border: 1px solid black;
        padding: 8px;
        text-align: left;
    }
</style>

</head>
<body>
	
	<h3>Calendario semanal</h3>
    <form action="/comidas/calendario" method="get">
        <table>
            <thead>
                <tr>
                    <th></th> <!-- Espacio en la esquina superior izquierda -->
                    <% 
                    String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
                    for (String dia : diasSemana) {
                    %>
                    <th><%= dia %></th>
                    <% } %>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Comida</td>
                    <% for (int i = 0; i < diasSemana.length; i++) { %>
                    <td>
                        <select name="comida<%= i %>">
                            <% if (ingredientes != null && !ingredientes.isEmpty()) {
        							for (Ingrediente ingrediente : ingredientes) { %>
            						<option value="<%= ingrediente.getIdIngrediente() %>"><%= ingrediente.getNombre() %></option>
    						<%  }
    							} else { %>
        							<option value="">No hay ingredientes disponibles</option>
   							 <% } %>
                        </select>
                    </td>
                    <% } %>
                </tr>
                
                <!-- Espacio entre las filas -->
                <tr style="height: 10px;"></tr>
                
                <tr>
                    <td>Cena</td>
                    <% for (int i = 0; i < diasSemana.length; i++) { %>
                    <td>
                        <select name="cena<%= i %>">
                    		<% if (ingredientes != null && !ingredientes.isEmpty()) {
        							for (Ingrediente ingrediente : ingredientes) { %>
            						<option value="<%= ingrediente.getIdIngrediente() %>"><%= ingrediente.getNombre() %></option>
    						<%  }
    							} else { %>
        							<option value="">No hay ingredientes disponibles</option>
   							 <% } %>
                        </select>
                    </td>
                    <% } %>
                </tr>
            </tbody>
        </table>
        <%-- <input type="submit" value="Guardar"> --%>
    </form>
</body>
</html>