<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="u" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo autor</title>
</head>
<body>
	
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
	<c:if test="${empty editar }">
		<form method="post" action="novo-autor">
	</c:if>
	<c:if test="${not empty editar }">
		<form method="post" action="editar-autor">
	</c:if>
	
		<label for="nome">Nome</label>
		<input type="text" name="nome" value="${editar.nome}">
		<label for="sobrenome">Sobrenome</label>
		<input type="text" name="sobrenome" value="${editar.sobrenome}">
		<label for="´principal_livro">Principal livro</label>
		<input type="text" name="principal_livro" value="${editar.principalLivro}">
		<label for="endereco">Endereço</label>
		<input type="text" name="endereco" value="${editar.endereco}">
		<label for="telefone">Telefone</label>
		<input type="text" name="telefone" value="${editar.telefone}">
		<label for="email">Email</label>
		<input type="text" name="email" value="${editar.email}">
		<label for="rg">Rg</label>
		<input type="text" name="rg" value="${editar.rg}">
		<label for="data_nascimento">Data de nascimento</label>
		<u:formatDate var="dateFormat"  pattern="dd/MM/yyyy" value="${editar.dtNascimento}" />
		<input type="text" name="data_nascimento" value="${dateFormat}">
		<label for="obs">Observações</label>
		<input type="text" name="obs" value="${editar.obs}">
		<label for="qtd_livros">Quantidade de livros</label>
		<input type="text" name="qtd_livros" value="${editar.qtdLivros}">
		
		<c:if test="${not empty editar }">
			<input type="hidden" name="editar_id" value="${editar.autor_Id}">
		</c:if>
		
	<input type="submit" value="Cadastrar">
	</form>
	
	
</body>
</html>