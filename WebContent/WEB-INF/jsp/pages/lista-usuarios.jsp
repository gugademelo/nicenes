<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Lita de usuários</title>
<jsp:include page="/WEB-INF/jsp/partials/css_links.jsp" />

</head>
<body>
	<jsp:include page="/WEB-INF/jsp/partials/header.jsp" />
<section class="container">
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
	<h1>Lista de usuários</h1>
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Perfil</th>
			<th>Opções</th>
		</tr>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>${usuario.nome }</td>
				<td>${usuario.email }</td>
				<td>${usuario.perfil.perfil }</td>
				<td><a href="excluir-usuario?id=${usuario.id }">Excluir</a> | <a href="editar-usuario?id=${usuario.id }">Editar</a></td>
			</tr>
		</c:forEach>
	</table>
</section>
</body>
</html>