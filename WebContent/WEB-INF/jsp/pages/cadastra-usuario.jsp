<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
	<form method="post" action="novo-usuario">
		<label for="nome">Nome</label>
		<input type="text" name="nome" value="${editar.nome }">
		<label for="email">Email</label>
		<input type="text" name="email">
		<label for="senha">Senha</label>
		<input type="password" name="senha">
		<c:if test="${usuarioLogado.perfil.id == 1 }">
			<label for="perfil">Perfil</label>
			<select name="perfil">
			<c:forEach items="${perfis}" var="perfil">
    			<option value="${perfil.id }">${perfil.perfil }</option>
			</c:forEach>
			</select>
		</c:if>
		<input type="submit" value="Cadastrar">
	</form>
</body>
</html>