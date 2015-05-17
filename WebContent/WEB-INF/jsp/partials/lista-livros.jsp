<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${usuarioLogado.perfil.id != 1 }">
	<p>Lista de livros</p>
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Opções</th>
		</tr>
		<c:forEach items="${livros}" var="livro">
			<tr>
				<td>${livro.titulo }</td>
				<td><a href="adiciona-carrinho?id=${livro.titulo }">Adicionar ao carrinho</a></td>
			</tr>
		</c:forEach>
</c:if>
