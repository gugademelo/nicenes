<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/partials/header.jsp" />
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
	<form action="login" method="post">
		<label for="email">Email</label>
		<input type="text" name="email">
		<label for="senha">Senha</label>
		<input type="password" name="senha">
		<input type="submit" value="Ok">
	</form>

</body>
</html>