<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="u" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo autor</title>
<jsp:include page="/WEB-INF/jsp/partials/css_links.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/partials/header.jsp" />
<section class="container">
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
	<c:if test="${empty editar }">
		<form method="post" action="novo-autor">
	</c:if>
	<c:if test="${not empty editar }">
		<form method="post" action="editar-autor">
	</c:if>
		<table>
		<tr>
			<td>
		<label for="nome">Nome</label>
			</td>
			<td>
		<input type="text" name="nome" value="${editar.nome}">
			</td>
		</tr>
		<tr>
			<td>
		<label for="sobrenome">Sobrenome</label>
			</td>
			<td>		
		<input type="text" name="sobrenome" value="${editar.sobrenome}">
					</td>
		</tr>
		<tr>
			<td>
		<label for="´principal_livro">Principal livro</label>
			</td>
			<td>		
		<input type="text" name="principal_livro" value="${editar.principalLivro}">
					</td>
		</tr>
		<tr>
			<td>
		<label for="endereco">Endereço</label>
			</td>
			<td>		
		<input type="text" name="endereco" value="${editar.endereco}">
					</td>
		</tr>
		<tr>
			<td>
		<label for="telefone">Telefone</label>
			</td>
			<td>		
		<input type="text" name="telefone" value="${editar.telefone}">
					</td>
		</tr>
		<tr>
			<td>
		<label for="email">Email</label>
			</td>
			<td>		
		<input type="text" name="email" value="${editar.email}">
					</td>
		</tr>
		<tr>
			<td>
		<label for="rg">Rg</label>
			</td>
			<td>		
		<input type="text" name="rg" value="${editar.rg}">
					</td>
		</tr>
		<tr>
			<td>
		<label for="data_nascimento">Data de nascimento</label>
			</td>
			<td>		
		<u:formatDate var="dateFormat"  pattern="dd/MM/yyyy" value="${editar.dtNascimento}" />
		<input type="text" name="data_nascimento" value="${dateFormat}">
					</td>
		</tr>
		<tr>
			<td>
		<label for="obs">Observações</label>
			</td>
			<td>		
		<input type="text" name="obs" value="${editar.obs}">
					</td>
		</tr>
		<tr>
			<td>
		<label for="qtd_livros">Quantidade de livros</label>
			</td>
			<td>		
		<input type="text" name="qtd_livros" value="${editar.qtdLivros}">
					</td>
		</tr>
		</table>		
		
		<c:if test="${not empty editar }">
			<input type="hidden" name="editar_id" value="${editar.autor_Id}">
		</c:if>
		
	<input type="submit" value="Cadastrar">
	</form>
	
	
</section>
</body>
</html>