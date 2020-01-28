package br.com.caelum.mvc.logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.exception.DAOException;
import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AlteraContatoLogic implements Logica {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Contato contato = new Contato();
		ContatoDao dao = new ContatoDao();
		
		contato.setNome(request.getParameter("nome"));
		contato.setEmail(request.getParameter("email"));
		contato.setEndereco(request.getParameter("endereco"));
		Date dataAlterada =  new SimpleDateFormat("dd/MM/yyy").parse(request.getParameter("dataNascimento"));
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(dataAlterada);
		contato.setDatanascimento(dataNascimento);
		try {
			dao.alteraContato(contato);
		} catch (Exception e) {
			throw new DAOException();
		}
		System.out.println("Changed contact");
		return "contato-alterado.jsp";
	}

}
