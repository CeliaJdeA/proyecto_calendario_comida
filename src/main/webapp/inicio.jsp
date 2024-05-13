<%@page contentType="UTF-8" import="java.util.Optional, jakarta.servlet.http.Cookie, jakarta.servlet.http.HttpServletRequest, java.util.Arrays"%>

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
                background-size: cover, cover; /* Para que las im�genes de fondo cubran todo el cuerpo */
                background-position: center, center; /* Centra las im�genes de fondo */
            }
            h3 {
                text-align: center;
                margin-bottom: 20px; /* Espacio entre el encabezado y los enlaces */
                font-size: 50px; /* Tama�o de letra m�s grande */
            }
            a {
                color: #000;
                font-weight: bold;
                text-decoration: none;
                transition: color 0.3s;
            }
            a:hover {
                color: #555;
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
            }
        </style>
    </head>
    <body>
    	<% Cookie[] cookies = request.getCookies() != null ? request.getCookies(): new Cookie[0];
				Optional<Cookie> cookieOptional = Arrays.stream(cookies)
				.filter(c-> "username".equals(c.getName())).findAny();%>
	
        <div class="second-background"></div>
        <h3>�Bienvenido <%= cookieOptional.isPresent() ? cookieOptional.get().getValue() : "" %>, vamos a ponernos la chaquetilla de chef!</h3>
        <%-- <p><a href="/comidas/calendario.jsp">Mi Calendario</a></p> --%>
        <p><a class="boton" href="comidas/index.html">Ir a Inicio</a></p>
        <%-- <p><a href='<%= req.getContextPath() %>/logout'>Cerrar sesi�n</a></p> --%>
    </body>
</html>


	<%-- 	<li><a href="/comidas/calendario">Mi Calendario</a></li>		
			<li><a href="/comidas/calendario">Crear nuevo calendario semanal</a></li>		--%>