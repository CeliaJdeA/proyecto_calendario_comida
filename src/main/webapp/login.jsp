
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Iniciar sesión</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            font-family: Arial, sans-serif;
            flex-direction: column; /* Para que los elementos se apilen verticalmente */
            background-image: url('https://images.pexels.com/photos/7130557/pexels-photo-7130557.jpeg'); /* Cambia 'ruta/a/imagen.jpg' por la ruta de tu imagen de fondo */
            background-size: cover; /* Para que la imagen de fondo cubra todo el cuerpo */
            background-position: center; /* Centra la imagen de fondo */
        }
        h1 {
            text-align: center;
            margin-bottom: 20px; /* Espacio entre el encabezado y el formulario */
            font-size: 25px; /* Tamaño de letra más pequeño */
            color: white;
        }
        form {
            background-color: rgba(255, 255, 255, 0.8); /* Fondo del formulario semi-transparente */
            padding: 20px;
            border-radius: 15px;
        }
        label {
            font-weight: bold;
        }
        input[type="text"],
        input[type="password"],
        input[type="submit"] {
            width: calc(100% - 20px); /* Ajuste del ancho para compensar el padding */
            padding: 10px;
            margin-top: 10px;
            margin-bottom: 10px;
            border: 2px solid #000;
            border-radius: 5px;
            box-sizing: border-box; /* Para incluir el padding en el cálculo del ancho */
        }
        input[type="submit"] {
            cursor: pointer;
            background-color: #ffcab7; /* Color naranja */
            font-weight: bold;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #ffa366; /* Cambio de color al pasar el mouse */
        }
        .login-text {
            color: rgba(255, 255, 255, 0.8); /* Color semi-transparente para el texto */
        }
    </style>
</head>
<body>
    <h1 class="login-text">Iniciar sesión</h1>
    <form action="/comidas/iniciar-sesion" method="post">
        <div>
            <label for="username">Usuario</label>
            <div>
                <input type="text" name="username" id="username">
            </div>
            <%-- Aquí se mostrará el mensaje de error del nombre de usuario --%>
            <%-- Para evitar que aparezcan null, puedes realizar una verificación en tu JSP antes de mostrar los mensajes de error --%>
            <% String usernameError = (String) request.getAttribute("usernameError");
       			if (usernameError != null) { %>
           		<span style="color: red;"><%= usernameError %></span><br>
    		<% } %>
        </div>
        <div>
            <label for="password">Contraseña</label>
            <div>
                <input type="password" name="password" id="password">
            </div>
           <%--  Aquí se mostrará el mensaje de error de la contraseña--%>
           <% String passwordError = (String) request.getAttribute("passwordError");
       			if (passwordError != null) { %>
           		<span style="color: red;"><%= passwordError %></span><br>
   		   <% } %>
        </div>
        <div>
            <input type="submit" value="Entrar">
        </div>
    </form>
</body>
</html>

