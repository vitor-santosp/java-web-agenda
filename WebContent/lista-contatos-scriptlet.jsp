<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, br.com.caelum.jdbc.dao.*, br.com.caelum.jdbc.modelo.*, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts List</title>
</head>
	<body>
		<table>
			<%
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			
			for (Contato contato : contatos) {
			%>
				<tr>
					<th>Nome</th>
					<th>Email</th>
					<th>Endereço</th>
					<th>Data Nascimento</th>
				</tr>
				<tr>
					<td><%=contato.getNome() %></td>
					<td><%=contato.getEmail() %></td>
					<td><%=contato.getEndereco() %></td>
					<% SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy"); %>
					<% String dataFormatada = sf.format(contato.getDatanascimento().getTime()); %>
					<td><%= dataFormatada  %></td>
				</tr>
			<%
			}
			%>
		</table>
	</body>
</html>