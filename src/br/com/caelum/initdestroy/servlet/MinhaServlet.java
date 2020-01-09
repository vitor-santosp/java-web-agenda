package br.com.caelum.initdestroy.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/minhaServlet")
public class MinhaServlet extends HttpServlet {

	private static final long serialVersionUID = -1533935501885644148L;

	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		log("Iiciando a servlet");
	}
	
	public void destroy() {
		super.destroy();
		log("Destruindo a sevlet");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		this.destroy();
	}
}
