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
	
							
		<c:forEach var="venda" items="${vendas}">
		<table border="0" class="pontilhado">
			<tr>
				<th>Pedido nº:&nbsp;${venda.id_venda}<br/>
					<c:if test = "${usuarioLogado.perfil.id == 1 }" >
						Usuário: ${venda.usuario.nome}
					</c:if>
				
				</th>
				<th valign="bottom" colspan="2">Frete:&nbsp;${venda.frete}</th>
				<th valign="bottom" align="right">Val.&nbsp;Frete:&nbsp;${venda.valor_frete}</th>
			</tr>
			
			<tr>
					<td align="right">&nbsp;</td>
					<td align="left"><b>Livro</b></td>	
					<td Colspan="2" align="right"><b>Preço</b></td>	

			</tr>
			
			<c:forEach var="item" items="${itensvenda}">
				<c:if test="${item.venda.id_venda == venda.id_venda}">	
					<tr>
						<td align="right">&nbsp;</td>
						<td align="left">${item.livro.titulo}</td>
						<td Colspan="2" align="right">${item.livro.preco}</td>
					</tr>
				</c:if>
			</c:forEach>
			
			<tr>
						
					<td Colspan="3" align="right"><b>Total<br/>Total C/ Frete</b></td>	
					<td align="right">_ _ _ _ _ _ _ _ &nbsp;&nbsp;&nbsp;&nbsp;
					<b>${venda.valor_total}<br/> ${venda.valor_frete+venda.valor_total}</b></td>

			</tr>
			
			
		</table><br/>	
		</c:forEach>
	


</body>
</html>