<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${usuarioLogado.perfil.id != 1 }">
	<p>Lista de livros aleatorios</p>
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Pre�o</th>
			<th>Op��es</th>
		</tr>
		<c:forEach items="${livrosAleatorios}" var="livroAleatorio">
			<tr>
				<td>${livroAleatorio.titulo }</td>
				<td>${livroAleatorio.preco }</td>
				<td>
					<a href="adiciona-carrinho?id=${livroAleatorio.livro_id }">Adicionar ao carrinho</a> | 
					<a href="adiciona-lista-de-desejos?id=${livroAleatorio.livro_id }">Adicionar a lista de desejos</a>
				</td>
			</tr>
		</c:forEach>
		</table>
</c:if>
