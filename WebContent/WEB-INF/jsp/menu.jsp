<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul>
	<c:if test = "${empty usuarioLogado }" >
		<li><a href="cadastra-usuario.html">Cadastre-se</a></li>
		<li><a href="login.html">Fa�a o login</a></li>
	</c:if>
	<c:if test = "${not empty usuarioLogado }" >
		<li><a href="logout">Logout</a></li>
		<p>Usuario logado: <b>${usuarioLogado.nome}</b></p>	
	</c:if>
</ul>