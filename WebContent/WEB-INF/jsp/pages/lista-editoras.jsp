<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/jsp/partials/css_links.jsp" />

</head>
<body>
	<jsp:include page="/WEB-INF/jsp/partials/header.jsp" />
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
	<h1>Lista de Editoras</h1>
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Endereco</th>
			<th>Cidade</th>
			<th>UF</th>
			<th>Pais</th>
			<th>Cep</th>
			<th>Fone</th>
			<th>Cnpj</th>
			<th>Razao Social</th>
			<th>Web</th>
			<th>Opções</th>
		</tr>
		
					
		<c:forEach var="editora" items="${editoras}">
			<tr>
				<td>${editora.nome}</td>
				<td>${editora.endereco}</td>
				<td>${editora.cidade}</td>
				<td>${editora.uf}</td>
				<td>${editora.pais}</td>
				<td>${editora.cep}</td>
				<td>${editora.fone}</td>
				<td>${editora.cnpj}</td>
				<td>${editora.razaoSocial}</td>
				<td>${editora.web }</td>
				<td><a href="excluir-editora?id=${editora.id }">Excluir</a> | <a href="editar-editora?id=${editora.id }">Editar</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>