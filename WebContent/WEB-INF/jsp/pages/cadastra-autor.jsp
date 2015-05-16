<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo autor</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
	<form action="novo-autor" method="POST">
		<label for="nome">Nome</label>
		<input type="text" name="nome">
		<label for="sobrenome">Sobrenome</label>
		<input type="text" name="sobrenome">
		<label for="´principal_livro">Principal livro</label>
		<input type="text" name="principal_livro">
		<label for="endereco">Endereço</label>
		<input type="text" name="endereco">
		<label for="telefone">Telefone</label>
		<input type="text" name="telefone">
		<label for="email">Email</label>
		<input type="text" name="email">
		<label for="rg">Rg</label>
		<input type="text" name="rg">
		<label for="data_nascimento">Data de nascimento</label>
		<input type="text" name="data_nascimento">
		<label for="obs">Observações</label>
		<input type="text" name="obs">
		<label for="qtd_livros">Quantidade de livros</label>
		<input type="text" name="qtd_livros">
		<input type="submit" value="ok">
	</form>
</body>
</html>