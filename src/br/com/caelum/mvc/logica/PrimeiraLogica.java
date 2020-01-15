package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica {

	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("Running logic...");
		System.out.println("Returning JSP page name...");
		return "primeira-logica.jsp";
	}

}
