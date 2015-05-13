<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
	<form method="post" action="NovaEditora">
	
		<label for="nome">Nome</label>
		<input type="text" name="nome">
		<label for="endereco">Endereco</label>
		<input type="text" name="endereco">
		<label for="cidade">Cidade</label>
		<input type="text" name="cidade">
		<label for="uf">UF</label>
		<input type="text" name="uf">
		<label for="pais">Pais</label>
		<input type="text" name="pais">
		<label for="cep">Cep</label>
		<input type="text" name="cep">
		<label for="fone">Fone</label>
		<input type="text" name="fone">
		<label for="cnpj">Cnpj</label>
		<input type="text" name="cnpj">
		<label for="razao">Razao Social</label>
		<input type="text" name="razao">
		<label for="web">End. Web</label>
		<input type="text" name="web">
		
	<input type="submit" value="Cadastrar">
		
	</form>
	
</body>
</html>