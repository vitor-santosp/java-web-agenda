package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

	private static final long serialVersionUID = -7161718484315386878L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Contato contato = new Contato();
		ContatoDao dao = new ContatoDao();
		
		contato.setNome(request.getParameter("nome"));
		contato.setEmail(request.getParameter("email"));
		contato.setEndereco(request.getParameter("endereco"));
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyy").parse(request.getParameter("dataNascimento"));
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
			contato.setDatanascimento(dataNascimento);
		} catch (Exception e) {
			out.println("Erro de conversão de data");
		}
		
		dao.adiciona(contato);
		out.println("<html>");
		out.println("<body>");
		out.println("Contato " + contato.getNome() + " adicionado com sucesso");
		out.println("</body>");
		out.println("</html>");
		
	}
	
}
