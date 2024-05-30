<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Ingrediente" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calendario de Comidas</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            font-family: Arial, sans-serif;
            flex-direction: column;
            background-image: url('https://images.pexels.com/photos/7130557/pexels-photo-7130557.jpeg'), url('https://images.pexels.com/photos/2814828/pexels-photo-2814828.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');
            background-size: cover, cover;
            background-position: center, center;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            font-size: 40px;
        }
        table {
            width: 70%;
            border-collapse: collapse;
            background-color: rgba(255, 255, 255, 0.7);
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            border-radius: 15px;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        p {
            text-align: center;
            font-size: 20px;
            font-weight: bold;
        }
    </style>
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
                        <a href="<%= request.getContextPath() %>/nutrientes?tipo=Proteinas&dia=<%= dia %>&comidaCena=comida">Proteinas</a>
                        <a href="<%= request.getContextPath() %>/nutrientes?tipo=Vitaminas y minerales&dia=<%= dia %>&comidaCena=comida">Vegetales</a>
                        <a href="<%= request.getContextPath() %>/nutrientes?tipo=Grasas&dia=<%= dia %>&comidaCena=comida">Grasas</a>
                        <ul> <!-- Se accede a la sesión (session) para obtener las listas de ingredientes seleccionados para la comida y la cena de ese día (dia + "-comida" y dia + "-cena"). -->
                            <% List<String> ingredientesComida = (List<String>) session.getAttribute(dia + "-comida");
                            if (ingredientesComida != null) { // Si existen ingredientes seleccionados para la comida o la cena de ese día, se recorren las listas y se generan elementos de lista (<li>) para cada ingrediente.
                                for (String ingrediente : ingredientesComida) {
                                	%>
                                    <%= ingrediente %>
                            <% } } %>
                        </ul>
                    </td>
                    <td>
                        <a href="<%= request.getContextPath() %>/nutrientes?tipo=Hidratos de carbono&dia=<%= dia %>&comidaCena=cena">Hidratos</a>
                        <a href="<%= request.getContextPath() %>/nutrientes?tipo=Proteinas&dia=<%= dia %>&comidaCena=cena">Proteinas</a>
                        <a href="<%= request.getContextPath() %>/nutrientes?tipo=Vitaminas y minerales&dia=<%= dia %>&comidaCena=cena">Vegetales</a>
                        <a href="<%= request.getContextPath() %>/nutrientes?tipo=Grasas&dia=<%= dia %>&comidaCena=cena">Grasas</a>
                        <ul>
                            <% List<String> ingredientesCena = (List<String>) session.getAttribute(dia + "-cena");
                            if (ingredientesCena != null) {
                                for (String ingrediente : ingredientesCena) {
                                    %>
                                    <li><%= ingrediente %></li>
                            <% } } %>
                        </ul>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>
    <a href="<%= request.getContextPath() %>/inicio.jsp">Volver al inicio</a> <!-- Enlace para volver al inicio -->
</body>

</html>

