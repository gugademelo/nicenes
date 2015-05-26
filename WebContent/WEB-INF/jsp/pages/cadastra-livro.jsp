<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Novo livro</title>
<jsp:include page="/WEB-INF/jsp/partials/css_links.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/partials/header.jsp" />
<section class="container">
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
	
	<c:if test="${not empty visualizar }">
		<form method="post" action="">
	</c:if>
	
	<c:if test="${empty editar }">
		<form method="post" action="novo-livro">
	</c:if>
	<c:if test="${not empty editar }">
		<form method="post" action="editar-livro">
	</c:if>
	<table>
		<tr>
			<td>
	<label for="titulo">Titulo</label>
			</td>
			<td>
	<input type="text" name="titulo" value="${editar.titulo}">
			</td>
		</tr>
		<tr>
			<td>
	<label for="isbn">ISBN</label>
			</td>
			<td>	
	<input type="text" name="isbn" value="${editar.isbn}">
			</td>
		</tr>
		<tr>
			<td>	
	<label for="colecao">Coleção</label>
			</td>
			<td>	
	<input type="text" name="colecao" value="${editar.colecao}">
			</td>
		</tr>
		<tr>
			<td>	
	<label for="edicao">Edição</label>
			</td>
			<td>	
	<input type="text" name="edicao" value="${editar.edicao}">
			</td>
		</tr>
		<tr>
			<td>	
	<label for="idioma">Idioma</label>
			</td>
			<td>	
	<input type="text" name="idioma" value="${editar.idioma}">
			</td>
		</tr>
		<tr>
			<td>	
	<label for="ano">Ano</label>
			</td>
			<td>	
	<input type="text" name="ano" value="${editar.ano}">
			</td>
		</tr>
		<tr>
			<td>	
	<label for="categoria">Categoria</label>
			</td>
			<td>	
	<select name="categoria">
		<c:forEach var="categoria" items="${categorias}">
		
			<c:if test="${editar.categoria.categoria_id == categoria.categoria_id}">
				<option value="${categoria.categoria_id }" selected>${categoria.categoria}</option>
			</c:if>
			<c:if test="${editar.categoria.categoria_id != categoria.categoria_id}">
				<option value="${categoria.categoria_id }">${categoria.categoria}</option>
			</c:if>
			
		</c:forEach>
	</select>
			</td>
		</tr>
		<tr>
			<td>	
	<label for="editora">Editora</label>
			</td>
			<td>	
	<select name="editora">
		<c:forEach var="editora" items="${editoras}">
		
			<c:if test="${editar.editora.id == editora.id}">
				<option value="${editora.id }" selected>${editora.nome}</option>
			</c:if>
			<c:if test="${editar.editora.id != editora.id}">
				<option value="${editora.id }">${editora.nome}</option>
			</c:if>
		
		</c:forEach>
	</select>
			</td>
		</tr>
		<tr>
			<td>
	<label for="autor">Autor</label>
			</td>
			<td>	
	<select name="autor">
		<c:forEach var="autor" items="${autores}">
		
			<c:if test="${editar.autor.autor_Id == autor.autor_Id}">
				<option value="${autor.autor_Id }" selected>${autor.nome}&nbsp;${autor.sobrenome}</option>
			</c:if>
			<c:if test="${editar.autor.autor_Id != autor.autor_Id}">
				<option value="${autor.autor_Id }" >${autor.nome}&nbsp;${autor.sobrenome}</option>
			</c:if>
			
		</c:forEach>
	</select>
				</td>
		</tr>
		<tr>
			<td>
	<label for="assunto">Preço</label>
			</td>
			<td>	
	<input type="text" name="preco" value="${editar.preco}">
				</td>
		</tr>
	</table>
	
		<c:if test="${not empty editar }">
			<input type="hidden" name="editar_id" value="${editar.livro_id }">
		</c:if>
	
	<c:if test="${empty visualizar }">
		<input type="submit" value="Cadastrar">
	</c:if>	

	
	</form>

</section>
</body>
</html>