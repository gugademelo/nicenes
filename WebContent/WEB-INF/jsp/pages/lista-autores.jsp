<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="u" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/jsp/partials/css_links.jsp" />
</head>
<body>

	<jsp:include page="/WEB-INF/jsp/partials/header.jsp" />
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
	<h1>Lista de Autores</h1>
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Sobrenome</th>
			<th>Principal Livro</th>
			<th>Endereco</th>
			<th>Telefone</th>
			<th>Email</th>
			<th>Rg</th>
			<th>Data de Nascimento</th>
			<th>Observações</th>
			<th>Qtd. Livros</th>
			<th>Opções</th>
		</tr>
		
					
		<c:forEach var="autor" items="${autores}">
			<tr>
				<td>${autor.nome}</td>
				<td>${autor.sobrenome}</td>
				<td>${autor.principalLivro}</td>
				<td>${autor.endereco}</td>
				<td>${autor.telefone}</td>
				<td>${autor.email}</td>
				<td>${autor.rg}</td>
				<td><u:formatDate pattern="dd/MM/yyyy" value="${autor.dtNascimento}"/></td>
				<td>${autor.obs}</td>
				<td>${autor.qtdLivros }</td>
				<td><a href="excluir-autor?id=${autor.autor_Id }">Excluir</a> | <a href="editar-autor?id=${autor.autor_Id}">Editar</a></td>
			</tr>
		</c:forEach>
	</table>




		
		
</body>
</html>