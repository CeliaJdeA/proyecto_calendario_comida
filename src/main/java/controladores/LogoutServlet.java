package controladores;

import java.io.IOException;
import java.util.Optional;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.LoginService;
import services.LoginServiceImpl;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	LoginService auth = new LoginServiceImpl();
        Optional<String> username = auth.getUsername(req);
        if (username.isPresent()) { // Si está presente borramos la sesión
            HttpSession session = req.getSession();
            session.invalidate(); // Invalida la sesion completa
        }
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}
