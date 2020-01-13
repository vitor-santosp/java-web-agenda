<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"	%>
<%@taglib tagdir="/WEB-INF/tags" prefix="cale" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>add contacts</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui.js"></script>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<h1>Adiciona Contatos</h1>
	<hr/>
	<form action="adicionaContato">
		Nome: <input type="text" name="nome" /> <br/>
		E-mail: <input type="text" name="email" /> <br/>
		Endereço: <input type="text" name="endereco" /> <br/>
		Data Nascimento: <cale:campoData id="dataNascimento" /><br/>
		<input type="submit" value="Gravar" />
	</form>
	<c:import url="rodape.jsp" />
</body>
</html>