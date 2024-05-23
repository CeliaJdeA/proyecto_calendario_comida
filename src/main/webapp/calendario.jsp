<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Ingrediente" %>
<html>
<head>
    <title>Calendario de Comidas</title>
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
        h2 {
            text-align: center;
            margin-bottom: 20px; /* Espacio entre el encabezado y la tabla */
            font-size: 40px; /* Tamaño de letra más grande */
        }
        table {
            width: 70%; /* Ancho de la tabla */
            border-collapse: collapse;
            background-color: rgba(255, 255, 255, 0.7); /* Color blanco difuminado */
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2); /* Sombra suave */
            border-radius: 15px; /* Bordes redondeados */
            margin-bottom: 20px; /* Espacio entre la tabla y el mensaje de no hay ingredientes */
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2; /* Color de fondo del encabezado */
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
        List<modelo.Ingrediente> ingredientes = (List<modelo.Ingrediente>) request.getAttribute("ingredientes");
        if (ingredientes != null && !ingredientes.isEmpty()) {
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
                    String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
                    for (String dia : dias) {
                %>
                    <tr>
                        <td><%= dia %></td>
                        <td>
                            <select name="comida_<%= dia.toLowerCase() %>">
                                <%
                                    for (modelo.Ingrediente ing : ingredientes) {
                                %>
                                    <option value="<%= ing.getIdIngrediente() %>"><%= ing.getNombre() %></option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                        <td>
                            <select name="cena_<%= dia.toLowerCase() %>">
                                <%
                                    for (modelo.Ingrediente ing : ingredientes) {
                                %>
                                    <option value="<%= ing.getIdIngrediente() %>"><%= ing.getNombre() %></option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    <%
        } else {
    %>
        <p>No hay ingredientes disponibles.</p>
    <%
        }
    %>
</body>
</html>

