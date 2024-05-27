<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Ingrediente" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Ingredientes</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            font-family: Arial, sans-serif;
            flex-direction: column; /* Para que los elementos se apilen verticalmente */
            background-image: url('https://images.pexels.com/photos/7130557/pexels-photo-7130557.jpeg'), url('https://images.pexels.com/photos/2814828/pexels-photo-2814828.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'); /* Cambia 'ruta/a/imagen.jpg' por la ruta de tu imagen de fondo */
            background-size: cover, cover; /* Para que las imágenes de fondo cubran todo el cuerpo */
            background-position: center, center; /* Centra las imágenes de fondo */
        }
        h1 {
            text-align: center;
            margin-bottom: 20px; /* Espacio entre el encabezado y la tabla */
            font-size: 50px; /* Tamaño de letra más grande */
        }
        table {
            border-collapse: collapse; /* Para fusionar los bordes de la tabla */
            width: 50%; /* Ancho de la tabla */
            background-color: rgba(255, 255, 255, 0.7); /* Color blanco difuminado */
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2); /* Sombra suave */
            border-radius: 15px; /* Bordes redondeados */
            margin-bottom: 20px; /* Espacio entre la tabla y los botones */
        }
        th, td {
            border: 1px solid #000; /* Borde de la celda */
            padding: 8px; /* Espaciado interno de la celda */
            text-align: left; /* Alineación del texto a la izquierda */
        }
        th {
            background-color: #f2f2f2; /* Color de fondo del encabezado */
        }
        .botones {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-wrap: wrap; /* Envolver los botones si no hay suficiente espacio */
        }
        .boton {
            padding: 10px 20px;
            border: 2px solid #000; /* Color naranja */
            border-radius: 15px; /* Bordes redondeados */
            text-decoration: none;
            color: #000; /* Color del texto */
            font-weight: bold;
            transition: background-color 0.3s, border-color 0.3s, color 0.3s; /* Transición para el cambio de color */
            margin: 10px; /* Espacio entre los botones */
        }
        .boton:hover {
            background-color: #ffa366; /* Naranja más claro */
            border-color: #ffa366; /* Color del borde en hover */
            color: #fff; /* Color del texto en hover */
        }
    </style>
</head>
<body>
    <h1>Lista de Ingredientes</h1>
    <div class="botones">
        <a href="<%= request.getContextPath() %>/calendario" class="boton">Crear nuevo calendario</a>
        <a href="<%= request.getContextPath() %>/añadir" class="boton">Añadir Nuevo Ingrediente</a>
        <a href="<%= request.getContextPath() %>/eliminarIngrediente" class="boton">Eliminar ingrediente</a>
    </div>
    <table>
        <tr>
            <th>Ingrediente</th>
            <th>Categoría</th>
        </tr>
        <%
            List<Ingrediente> ingredientes = (List<Ingrediente>) request.getAttribute("ingredientes");
            for (Ingrediente ingrediente : ingredientes) {
        %>
            <tr>
                <td><%= ingrediente.getNombre() %></td>
                <td><%= ingrediente.getCategoria().getNombre() %></td>
            </tr>
        <%
            }
        %>
    </table>
    
</body>
</html>



