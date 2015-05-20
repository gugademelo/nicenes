<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/partials/header.jsp" />
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
	<h1>Lista de Livros</h1>
	<table border="1">
		<tr>
			<th>Titulo</th>
			<th>Isbn</th>
			<th>Colecao</th>
			<th>Edicao</th>
			<th>Idioma</th>
			<th>Ano</th>
			<th>Autor</th>
			<th>Editora</th>
			<th>Categoria</th>
			<th>Preco</th>
			<th>Opções</th>
		</tr>
					
		<c:forEach var="livro" items="${livros}">
			<tr>
				<td>${livro.titulo}</td>
				<td>${livro.isbn}</td>
				<td>${livro.colecao}</td>
				<td>${livro.edicao}</td>
				<td>${livro.idioma}</td>
				<td>${livro.ano}</td>
				<td>${livro.autor.nome}&nbsp;${livro.autor.sobrenome}</td>
				<td>${livro.editora.nome}</td>
				<td>${livro.categoria.categoria}</td>
				<td>${livro.preco}</td>
				<td><a href="excluir-livro?id=${livro.livro_id }">Excluir</a> | <a href="editar-livro?id=${livro.livro_id}">Editar</a></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>