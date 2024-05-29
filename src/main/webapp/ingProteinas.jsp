<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Ingrediente" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Proteínas</title>
</head>
<body>
    <h1>Ingredientes con Proteínas</h1>
    <ul>
        <% List<Ingrediente> ingredientes = (List<Ingrediente>) request.getAttribute("ingConNut");
           if (ingredientes != null) {
               for (Ingrediente ingrediente : ingredientes) {
                   out.println("<li>" + ingrediente.getNombre() + "</li>");
               }
           } else {
               out.println("<li>No se encontraron ingredientes</li>");
           }
        %>
    </ul>
    <button onclick="window.close()">Cerrar</button>
</body>
</html>
