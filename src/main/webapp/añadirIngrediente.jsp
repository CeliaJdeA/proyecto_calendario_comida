<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Agregar Ingrediente</title>
</head>
<body>
<h1>Agregar Ingrediente</h1>

<form action="añadir" method="post">
    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" required>

    <label for="categoriaId">Categoría:</label>
    <select id="categoriaId" name="categoriaId" required>
        </select>

    <input type="submit" value="Agregar">
</form>

</body>
</html>
