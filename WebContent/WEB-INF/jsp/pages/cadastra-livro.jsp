<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
 
 <label for="categoria">Categoria</label>
 <select name="categoria" >
 <c:forEach var="categoria" items="${categorias}">
 		<option value="${categoria.categoria_id }">${categoria.categoria}</option> 
 </c:forEach>
 </select>
 
  <select name="editora" >
 <c:forEach var="editora" items="${editoras}">
 		<option value="asdasda">${editora.nome}</option> 
 </c:forEach>
 </select>


</body>
</html>