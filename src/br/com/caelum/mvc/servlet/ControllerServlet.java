package br.com.caelum.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = -830961110831284182L;

	protected void service (HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		String param = request.getParameter("logic");
		String className = "br.com.caelum.mvc.logica." + param;
		
		try {
			Class<?> classe = Class.forName(className);
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(request, response);
			request.getRequestDispatcher(pagina).forward(request, response);
		} catch (Exception e) {
			throw new ServletException("The business logic launched one exception",e);
		}
	}
}
