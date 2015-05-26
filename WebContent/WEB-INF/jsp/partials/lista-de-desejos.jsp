<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${usuarioLogado.perfil.id != 1 }">
	<c:if test="${not empty listaDeDesejos }">
		<p>Minha lista de desejos</p>
		<table>
		<tr>
			<th>Nome</th>
			<th>Preço</th>
			<th>Autor</th>
			<th>Categoria</th>
			<th>Opções</th>
		</tr>
		<c:forEach items="${listaDeDesejos}" var="livroListaDeDesejos">
			<tr>
				<td>${livroListaDeDesejos.titulo }</td>
				<td>${livroListaDeDesejos.preco }</td>
				<td><a href="google?autor=${livroListaDeDesejos.autor.autor_Id }">${livroListaDeDesejos.autor.nome }</a></td>
				<td><a href="google?categoria=${livroListaDeDesejos.categoria.categoria_id }">${livroListaDeDesejos.categoria.categoria }</a></td>
				<td>
					<a href="remove-lista-de-desejos?id=${livroListaDeDesejos.livro_id }">Remover lista de desejos</a>
				</td>
			</tr>
		</c:forEach>
		</table>
		</c:if>
</c:if>
