<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="u" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/jsp/partials/css_links.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/partials/header.jsp" />
<section class="container">
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />


	<h1>Lista de Compras</h1>
	<table border="1">
							
		<c:forEach var="venda" items="${vendas}">
			<tr>
				<td>Número:&nbsp;${venda.id_venda}</td>
				<td>Frete:&nbsp;${venda.frete}</td>
				<td>Val.&nbsp;Frete:&nbsp;${venda.valor_frete}</td>
				<td>Val.&nbsp;Total:&nbsp;${venda.valor_frete+venda.valor_total}</td>
			</tr>
			
			<c:forEach var="item" items="${itensvenda}">
				<c:if test="${item.venda.id_venda == venda.id_venda}">	
					<tr>
						<td>&nbsp;</td>	
						<td>&nbsp;</td>	
						<td>${item.livro.titulo}</td>
						<td>${item.livro.preco}</td>
					</tr>
				</c:if>
			</c:forEach>
			
		</c:forEach>
	</table>


</body>
</html>