<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul>
	
	<li><a href="/nicenes">Início</a></li>
	<c:if test = "${empty usuarioLogado }" >
		<li><a href="novo-usuario">Cadastre-se</a></li>
		<li><a href="login">Faça o login</a></li>
	</c:if>
	<c:if test = "${not empty usuarioLogado }" >
		<c:if test = "${usuarioLogado.perfil.id == 1 }" >
			<li><a href="novo-usuario">Cadastre um novo usuario</a></li>
			<li><a href="lista-usuarios">Lista de usuarios</a>
			<li><a href="nova-editora">Cadastre uma nova editora</a></li>
			<li><a href="nova-categoria">Cadastre uma nova categoria</a></li>
			<li><a href="novo-livro">Cadastre um novo livro</a></li>
		</c:if>	
	</c:if>
</ul>
<c:if test = "${not empty usuarioLogado }" >
	<p>Usuario logado: <b>${usuarioLogado.nome} | </b><a href="logout">Logout</a></p>	
</c:if>