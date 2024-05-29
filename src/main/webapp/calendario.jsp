<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Ingrediente" %>
<%@ page import="com.fasterxml.jackson.core.type.TypeReference" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
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
                <%
                    for (String dia : dias) {
                %>
                    <tr>
                        <td><%= dia %></td>
                        <td>
                            <a href="<%= request.getContextPath() %>/nutrientes?tipo=Hidratos de carbono">Hidratos</a>
                            <a href="<%= request.getContextPath() %>/nutrientes?tipo=Proteinas">Proteinas</a>
                            <a href="<%= request.getContextPath() %>/nutrientes?tipo=Vitaminas y minerales">Vegetales</a>
                            <a href="<%= request.getContextPath() %>/nutrientes?tipo=Grasas">Grasas</a>
                        </td>
                        <td>
                            <a href="<%= request.getContextPath() %>/nutrientes?tipo=Hidratos de carbono">Hidratos</a>
                            <a href="<%= request.getContextPath() %>/nutrientes?tipo=Proteínas">Proteinas</a>
                            <a href="<%= request.getContextPath() %>/nutrientes?tipo=Vitaminas y minerales">Vegetales</a>
                            <a href="<%= request.getContextPath() %>/nutrientes?tipo=Grasas">Grasas</a>
                        </td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
       <%
    // Retrieve the "ingredientesLunes" cookie
    Cookie[] cookies = request.getCookies();
    String ingredientesJSON = null;
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("ingredientesLunes")) {
            ingredientesJSON = cookie.getValue();
            break;
        }
    }

    // If the cookie exists, parse the JSON string and use the ingredients
    if (ingredientesJSON != null) {
        List<String> selectedIngredientesLunes = new ObjectMapper().readValue(ingredientesJSON, new TypeReference<List<String>>() {});
        // Use selectedIngredientesLunes as needed
    }
%>

</body>
</html>

