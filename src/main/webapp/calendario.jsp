<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Map.Entry" %>
<%@ page import="modelo.Ingrediente" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calendario de Comidas</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/calendario.css">
</head>
<body>
    <h2>Calendario de Comidas</h2>
    <%
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
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
        <!-- Se utiliza un bucle for para iterar sobre la lista de días de la semana (dias), que probablemente contiene los nombres de los días como elementos. -->
            <% for (String dia : dias) { %>
                <tr>
                    <td><%= dia %></td> <!-- Primera columna: lunes, martes... -->
                    <td> <!-- Segunda columna: Cada enlace apunta al servlet ClasificaciónNutrientes con parámetros de consulta que especifican el tipo de nutriente (tipo), el día de la semana (dia), y si es para comida o cena (comidaCena). -->
                        <a href="<%= request.getContextPath() %>/nutrientes?tipo=Hidratos de carbono&dia=<%= dia %>&comidaCena=comida">Hidratos</a>
                        <a href="<%= request.getContextPath() %>/nutrientes?tipo=Proteínas&dia=<%= dia %>&comidaCena=comida">Proteínas</a>
                        <a href="<%= request.getContextPath() %>/nutrientes?tipo=Vitaminas y minerales&dia=<%= dia %>&comidaCena=comida">Vegetales</a>
                        <a href="<%= request.getContextPath() %>/nutrientes?tipo=Grasas&dia=<%= dia %>&comidaCena=comida">Grasas</a>
                        <ul> 
<!-- 						Esta línea obtiene un atributo de la sesión HTTP. El atributo buscado es una combinación del día (dia) y la cadena "-comida". 
							Este atributo es un mapa (Map<String, List<String>>) donde:
							- La clave es un String que representa el tipo de nutriente (por ejemplo, "Hidratos", "Proteinas", etc.).
							- El valor es una lista de nombres de ingredientes (List<String>) correspondientes a ese tipo de nutriente.. -->
                            <% Map<String, List<String>> ingredientesPorTipoComida = (Map<String, List<String>>) session.getAttribute(dia + "-comida");
/*							Se verifica si ingredientesPorTipoComida no es nulo. Esto significa que hay ingredientes seleccionados para la 
							comida de ese día y se puede proceder a procesarlos.*/                            
                            if (ingredientesPorTipoComida != null) { 
/*								Se itera sobre cada entrada del mapa ingredientesPorTipoComida. Cada entrada (entry) es un par clave-valor:
								- entry.getKey() obtiene la clave (el tipo de nutriente).
								- entry.getValue() obtiene la lista de ingredientes asociados con ese tipo de nutriente.*/                            										 
                            	for (Map.Entry<String, List<String>> entry : ingredientesPorTipoComida.entrySet()) { 
/*									Se itera sobre cada ingrediente en la lista de ingredientes (entry.getValue()) para el tipo de nutriente específico.*/                            		
                            		for (String ingrediente : entry.getValue()) {
                            %>
                                    <%= ingrediente %> <!-- Cada ingrediente se imprime en la página -->
                            <% } } }%>
                        </ul>
                    </td>
                    <td>
                        <a href="<%= request.getContextPath() %>/nutrientes?tipo=Hidratos de carbono&dia=<%= dia %>&comidaCena=cena">Hidratos</a>
                        <a href="<%= request.getContextPath() %>/nutrientes?tipo=Proteínas&dia=<%= dia %>&comidaCena=cena">Proteinas</a>
                        <a href="<%= request.getContextPath() %>/nutrientes?tipo=Vitaminas y minerales&dia=<%= dia %>&comidaCena=cena">Vegetales</a>
                        <a href="<%= request.getContextPath() %>/nutrientes?tipo=Grasas&dia=<%= dia %>&comidaCena=cena">Grasas</a>
                        <ul>
                            <% Map<String, List<String>> ingredientesPorTipoCena = (Map<String, List<String>>) session.getAttribute(dia + "-cena");
                            if (ingredientesPorTipoCena != null) {
                                for (Map.Entry<String, List<String>> entry : ingredientesPorTipoCena.entrySet()) {
                                    for (String ingrediente : entry.getValue()) {
                                    %>
                                    <%= ingrediente %>
                            <% } } }%>
                        </ul>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>
    <a href="<%= request.getContextPath() %>/inicio.jsp">Volver al inicio</a> <!-- Enlace para volver al inicio -->
</body>

</html>

