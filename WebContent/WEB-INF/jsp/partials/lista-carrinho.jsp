<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${usuarioLogado.perfil.id != 1 }">
	<c:if test="${not empty carrinho }">
		<p>Meu carrinho</p>
		<table>
		<tr>
			<th>Nome</th>
			<th>Preço</th>
			<th>Opções</th>
		</tr>
		<c:forEach items="${carrinho.livros}" var="livroCarrinho">
			<tr>
				<td>${livroCarrinho.titulo }</td>
				<td>${livroCarrinho.preco }</td>
				<td><a href="remove-carrinho?id=${livroCarrinho.livro_id }">Remover do carrinho</a></td>
			</tr>
		</c:forEach>
		</table>
		<p>Subtotal: R$ ${carrinho.subTotal }</p>
	</c:if>
</c:if>
