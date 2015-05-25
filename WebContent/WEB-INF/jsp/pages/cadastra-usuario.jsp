<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Novo usuario</title>
<jsp:include page="/WEB-INF/jsp/partials/css_links.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/partials/header.jsp" />
<section class="container">
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
	<c:if test="${empty editar }">
		<form method="post" action="novo-usuario">
	</c:if>
	<c:if test="${not empty editar }">
		<form method="post" action="editar-usuario">
	</c:if>
		<label for="nome">Nome</label>
		<input type="text" name="nome" value="${editar.nome }">
		<label for="email">Email</label>
		<input type="text" name="email" value="${editar.email }">
		<label for="senha">Senha</label>
		<input type="password" name="senha" value="${editar.senha }">
		<c:if test="${usuarioLogado.perfil.id == 1 }">
			<label for="perfil">Perfil</label>
			<select name="perfil">
			<c:forEach items="${perfis}" var="perfil">
				<c:if test="${perfil.id == editar.perfil.id }">
    				<option value="${perfil.id }" selected="selected">${perfil.perfil }</option>
    			</c:if>
    			<c:if test="${perfil.id != editar.perfil.id }">
    				<option value="${perfil.id }">${perfil.perfil }</option>
    			</c:if>
			</c:forEach>
			</select>
		</c:if>
		<c:if test="${not empty editar }">
			<input type="hidden" name="editar_id" value="${editar.id }">
		</c:if>
		<input type="submit" value="Cadastrar">
	</form>
</section>
</body>
</html>