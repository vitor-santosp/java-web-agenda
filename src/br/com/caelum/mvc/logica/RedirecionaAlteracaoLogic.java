package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.modelo.Contato;

public class RedirecionaAlteracaoLogic implements Logica {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(null == request.getAttribute("contato"))
			return "adiciona-contato-form.jsp";
		Contato contato = (Contato) request.getAttribute("contato");
		String nome = (String) request.getAttribute("nome");
		request.setAttribute("contatoAlterado", contato);
		return "altera-contato.jsp";
	}

}
