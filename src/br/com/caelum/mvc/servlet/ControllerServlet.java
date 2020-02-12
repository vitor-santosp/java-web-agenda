package br.com.caelum.mvc.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.mvc.logica.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = -830961110831284182L;

	protected void service (HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		String param = request.getParameter("logic");
		String className = "br.com.caelum.mvc.logica." + param;
		if("RedirecionaAlteracaoLogic".equals(param) && null != request.getParameter("idcontato")) {
			Contato contato = new Contato();
			contato.setNome(request.getParameter("nome"));
			contato.setEmail(request.getParameter("email"));
			contato.setEndereco(request.getParameter("endereco"));
			contato.setId(Long.valueOf((request.getParameter("idcontato"))));
			try {
				String stringDate=request.getParameter("nascimento");
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date date = formatter.parse(stringDate);
				Calendar calender = Calendar.getInstance();
				calender.setTime(date);
				contato.setDatanascimento(calender);
				request.setAttribute("contatoAlteracao", contato);
			} catch (ParseException e) {
				System.out.println("erro ao formatar data");
				e.printStackTrace();
			}
		
		}
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
