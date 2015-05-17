<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${usuarioLogado.perfil.id != 1 }">
	<c:if test="${not empty carrinho }">
		<p>Meu carrinho</p>
		<table border="1">
		<tr>
			<th>Nome</th>
			<th>Opções</th>
		</tr>
		<c:forEach items="${carrinho.livros}" var="livroCarrinho">
			<tr>
				<td>${livroCarrinho.titulo }</td>
				<td><a href="remove-carrinho?id=${livroCarrinho.livro_id }">Remover do carrinho</a></td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
</c:if>
