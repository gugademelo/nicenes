<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="/WEB-INF/jsp/partials/header.jsp" />
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
	<c:if test="${empty editar }">
		<form method="post" action="nova-editora">
	</c:if>
	<c:if test="${not empty editar }">
		<form method="post" action="editar-editora">
	</c:if>


	
		<label for="nome">Nome</label>
		<input type="text" name="nome" value="${editar.nome}">
		<label for="endereco">Endereco</label>
		<input type="text" name="endereco" value="${editar.endereco}">
		<label for="cidade">Cidade</label>
		<input type="text" name="cidade" value="${editar.cidade}">
		<label for="uf">UF</label>
		<input type="text" name="uf" value="${editar.uf}">
		<label for="pais">Pais</label>
		<input type="text" name="pais" value="${editar.pais}">
		<label for="cep">Cep</label>
		<input type="text" name="cep" value="${editar.cep}">
		<label for="fone">Fone</label>
		<input type="text" name="fone" value="${editar.fone}">
		<label for="cnpj">Cnpj</label>
		<input type="text" name="cnpj" value="${editar.cnpj}">
		<label for="razao">Razao Social</label>
		<input type="text" name="razao" value="${editar.razaoSocial}">
		<label for="web">End. Web</label>
		<input type="text" name="web" value="${editar.web}">
		<c:if test="${not empty editar }">
			<input type="hidden" name="editar_id" value="${editar.id }">
		</c:if>
		
	<input type="submit" value="Cadastrar">
		
	</form>
	
</body>
</html>