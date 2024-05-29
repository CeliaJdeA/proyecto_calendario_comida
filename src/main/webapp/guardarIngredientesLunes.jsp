<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">  <title>Insert title here</title>
</head>
<body>
<%
    // Retrieve selected ingredients from the request
    List<String> selectedIngredientesLunes = new ArrayList<>();
    if (request.getParameterValues("ingredientesLunes") != null) {
        for (String ingredienteNombre : request.getParameterValues("ingredientesLunes")) {
            selectedIngredientesLunes.add(ingredienteNombre);
        }
    }

    // Convert selected ingredients to a JSON string
    ObjectMapper mapper = new ObjectMapper(); // Create ObjectMapper instance
    String ingredientesJSON = new ObjectMapper().writeValueAsString(selectedIngredientesLunes);

    try {
        // Escape quotes in the JSON string (optional)
        ingredientesJSON = ingredientesJSON.replace("\"", "\\\"");  // Replace " with \"

        // Create and set cookie attributes
        Cookie ingredienteLunesCookie = new Cookie("ingredientesLunes", ingredientesJSON);
        ingredienteLunesCookie.setMaxAge(60 * 60 * 24 * 7); // 1 week
        ingredienteLunesCookie.setPath("/"); // Accessible from all paths

        // Add cookie to the response
        response.addCookie(ingredienteLunesCookie);

        // Redirect to calendario.jsp
        response.sendRedirect("calendario.jsp");
    } catch (IllegalArgumentException e) {
        // Handle the exception (e.g., log the error)
        System.err.println("Error setting cookie: " + e.getMessage());
    }
%>
</body>
</html>
