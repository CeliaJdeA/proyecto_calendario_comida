package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calendario")
public class CalendarioServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = resp.getWriter()) {
			 out.println("<!DOCTYPE html>");
	         out.println("<html>");
	         out.println("    <head>");
	         out.println("        <meta charset=\"UTF-8\">");
	         out.println("        <title>Listado de Productos</title>");
	         out.println("    </head>");
	         out.println("    <body>");
		}
	}
}
