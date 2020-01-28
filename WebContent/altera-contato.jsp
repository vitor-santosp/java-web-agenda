<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib tagdir="/WEB-INF/tags" prefix="cale" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Change Contact</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui.js"></script>
	 <script>
  $( function() {
	  $("#dataNascimento").datepicker({dateFormat: 'dd/mm/yy'});
  } );
  </script>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<h1>Change Contact ${contatoAlteracao.nome}</h1>
	
	<hr/>
	<form action="mvc?logic=AlteraContatoLogic">
		Nome: <input type="text" name="nome" value="${contatoAlteracao.nome}" /> <br/>
		E-mail: <input type="text" name="email" value="${contatoAlteracao.email}" /> <br/>
		Endereço: <input type="text" name="endereco" value="${contatoAlteracao.endereco}" /> <br/>
		Data Nascimento: <input type="text" id="dataNascimento" name="dataNascimento" value="<fmt:formatDate value="${contatoAlteracao.datanascimento.time}"
		pattern="dd/MM/yyyy"/>"/>
		<input type="submit" value="Gravar" />
	</form>
	<c:import url="rodape.jsp" />
</body>
</html>