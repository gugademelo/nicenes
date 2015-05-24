<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${usuarioLogado.perfil.id != 1 }">
	<p>Minha lista de desejos</p>
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Preço</th>
			<th>Opções</th>
		</tr>
		<c:forEach items="${listaDeDesejos}" var="livroListaDeDesejos">
			<tr>
				<td>${livroListaDeDesejos.titulo }</td>
				<td>${livroListaDeDesejos.preco }</td>
				<td>
					<a href="adiciona-carrinho?id=${livroListaDeDesejos.livro_id }">Adicionar ao carrinho</a> | 
					<a href="adiciona-lista-de-desejos?id=${livroListaDeDesejos.livro_id }">Remover da lista de desejos</a>
				</td>
			</tr>
		</c:forEach>
		</table>
</c:if>
