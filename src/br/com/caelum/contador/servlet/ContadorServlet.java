package br.com.caelum.contador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contador")
public class ContadorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 8413601801677327447L;
	
	private int contador = 0;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contador++;
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Contador agora é: " + contador);
		out.println("</html>");
		out.println("</body>");
	}
}
