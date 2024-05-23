<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.Optional, javax.servlet.http.Cookie, javax.servlet.http.HttpServletRequest, java.util.Arrays"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bienvenido</title>
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
        h3 {
            text-align: center;
            margin-bottom: 20px; /* Espacio entre el encabezado y los enlaces */
            font-size: 50px; /* Tamaño de letra más grande */
        }
        a {
            display: inline-block;
            padding: 10px 20px;
            border: 2px solid #000; /* Color naranja */
            border-radius: 15px; /* Bordes un poco menos redondeados */
            text-decoration: none;
            color: #000; /* Color del texto */
            font-weight: bold;
            transition: background-color 0.3s, border-color 0.3s, color 0.3s; /* Transición para el cambio de color */
            margin: 10px 0; /* Añadido un margen entre los botones */
        }

        a:hover {
            background-color: #ffa366; /* Naranja más claro */
            border-color: #ffa366; /* Color del borde en hover */
            color: #fff; /* Color del texto en hover */
        }

        .second-background {
            background-image: url('https://images.pexels.com/photos/2814828/pexels-photo-2814828.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');
            opacity: 0.2; /* Ajusta la opacidad de la segunda imagen */
            background-size: cover;
            background-position: center;
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            z-index: -1; /* Coloca la capa detrás de otros elementos */
        }
    </style>
</head>
<body>
<%
// Obtener el valor de la cookie "username"
Cookie[] cookies = request.getCookies();
String username = null;
if (cookies != null) {
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("username")) {
            username = cookie.getValue();
            break;
        }
    }
}
%>
<div class="second-background"></div>
<h3>¡Bienvenido <%= (username != null) ? username : "Usuario desconocido" %>, vamos a ponernos la chaquetilla de chef!</h3>

<a class="boton" href="<%= request.getContextPath() %>/calendario">Crear nuevo calendario</a>

<!-- Movido el botón "Lista de ingredientes" hacia abajo -->
<a class="boton" href="<%= request.getContextPath() %>/lista">Lista de ingredientes</a>
</body>
</html>
