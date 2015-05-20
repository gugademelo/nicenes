<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagamento</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/partials/header.jsp" />
	<h2>Pagina de pagamento</h2>
	<jsp:include page="/WEB-INF/jsp/partials/lista-carrinho.jsp" />
	<h3>Opções de frete</h3>
	<form action="fechar-compra" method="post">
		<input type="hidden" name="totalCarrinho" value="${carrinho.subTotal }">
		<input type="radio" name="frete" value="sedex-0.2">
		<label for="sedex">Sedex (R$ ${carrinho.subTotal * 0.2 + carrinho.subTotal})</label>
		<input type="radio" name="frete" value="pac-0.1">
		<label for="sedex">PAC (R$ ${(carrinho.subTotal * 0.1) + carrinho.subTotal })</label>
		<input type="submit" value="Fechar compra">
	</form>
</body>
</html>