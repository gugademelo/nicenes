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
<section class="container">
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
	<c:if test="${empty editar }">
		<form method="post" action="nova-categoria">
	</c:if>
	<c:if test="${not empty editar }">
		<form method="post" action="editar-categoria">
	</c:if>
	<table>
		<tr>
			<td>
		<label for="nome">Categoria</label>
			</td>
			<td>
		<input type="text" name="categoria" value="${editar.categoria} ">
			</td>
		</tr>
	</table>
		<c:if test="${not empty editar }">
			<input type="hidden" name="editar_id" value="${editar.categoria_id }">
		</c:if>
		
	<input type="submit" value="Cadastrar">
		
	</form>
		
	
</section>
</body>
</html>