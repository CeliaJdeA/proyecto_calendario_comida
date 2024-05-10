<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calendario comida</title>
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
                <td><!-- Aquí podrías poner los datos de la comida --></td>
                <% } %>
            </tr>
            <tr>
                <td>Cena</td>
                <% for (int i = 0; i < diasSemana.length; i++) { %>
                <td><!-- Aquí podrías poner los datos de la cena --></td>
                <% } %>
            </tr>
        </tbody>
    </table>
    </form>
</body>
</html>