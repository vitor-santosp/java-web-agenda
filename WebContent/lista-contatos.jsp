<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listing test</title>
</head>
	<body>
		<c:import url="cabecalho.jsp"/>	
		<table border="1">
			<c:forEach var="contato" items="${contatos}" varStatus="num">
				<tr>
					<th>Nome</th>
					<th>Email</th>
					<th>Endereco</th>
					<th>Data Nascimento</th>
				</tr>
				<tr bgcolor="#${num.count % 2 == 0 ? 'aaee88' : 'C71585'} ">
					<td>${contato.nome}</td>
					<td>
						<c:choose>
							<c:when test="${not empty contato.email}">
								<a href="mailto:${contato.email}">${contato.email}</a>
							</c:when>
							<c:otherwise>E-mail não informado</c:otherwise>
						</c:choose>
					</td>
					<td>${contato.endereco}</td>
					<td><fmt:formatDate value="${contato.datanascimento.time}"
					pattern="dd/MM/yyyy"/></td>
					<td><a href="mvc?logic=RemoveContatoLogic&id=${contato.id}">Remover</a></td>
				</tr>
			</c:forEach>
		</table>
		<c:import url="rodape.jsp"></c:import>	
	</body>
</html>