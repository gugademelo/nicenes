<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${usuarioLogado.perfil.id != 1 }">
	<p>Lista de livros</p>
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Preço</th>
			<th>Opções</th>
		</tr>
		<c:forEach items="${livros}" var="livro">
			<tr>
				<td>${livro.titulo }</td>
				<td>${livro.preco }</td>
				<td>
					<a href="adiciona-carrinho?id=${livro.livro_id }">Adicionar ao carrinho</a> | 
					<a href="adiciona-lista-de-desejos?id=${livro.livro_id }">Adicionar a lista de desejos</a>
				</td>
			</tr>
		</c:forEach>
		</table>
</c:if>
