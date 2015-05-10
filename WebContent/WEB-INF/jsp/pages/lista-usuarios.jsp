<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Lita de usu�rios</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
	<h1>Lista de usu�rios</h1>
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Perfil</th>
			<th>Op��es</th>
		</tr>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>${usuario.nome }</td>
				<td>${usuario.email }</td>
				<td>${usuario.perfil }</td>
				<td><a href="excluir-usuario?id=${usuario.id }">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>