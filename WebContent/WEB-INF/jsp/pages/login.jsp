<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/jsp/partials/css_links.jsp" />

</head>
<body>
	<jsp:include page="/WEB-INF/jsp/partials/header.jsp" />
<section class="container">
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
	<form action="login" method="post">
		<label for="email">Email</label>
		<input type="text" name="email">
		<label for="senha">Senha</label>
		<input type="password" name="senha">
		<input type="submit" value="Ok">
	</form>

</section>
</body>
</html>