<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nova editora</title>
<jsp:include page="/WEB-INF/jsp/partials/css_links.jsp" />
</head>
<body>

	<jsp:include page="/WEB-INF/jsp/partials/header.jsp" />
<section class="container">
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
	<c:if test="${empty editar }">
		<form method="post" action="nova-editora">
	</c:if>
	<c:if test="${not empty editar }">
		<form method="post" action="editar-editora">
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
		<label for="endereco">Endereco</label>
			</td>
			<td>		
		<input type="text" name="endereco" value="${editar.endereco}">
			</td>
		</tr>
		<tr>
			<td>		
		<label for="cidade">Cidade</label>
			</td>
			<td>		
		<input type="text" name="cidade" value="${editar.cidade}">
			</td>
		</tr>
		<tr>
			<td>

		<label for="uf">UF</label>
			</td>
			<td>		
		<input type="text" name="uf" value="${editar.uf}">
			</td>
		</tr>
		<tr>
			<td>

		<label for="pais">Pais</label>
			</td>
			<td>		
		<input type="text" name="pais" value="${editar.pais}">
			</td>
		</tr>
		<tr>
			<td>		
		<label for="cep">Cep</label>
			</td>
			<td>		
		<input type="text" name="cep" value="${editar.cep}">
			</td>
		</tr>
		<tr>
			<td>		
		<label for="fone">Fone</label>
			</td>
			<td>		
		<input type="text" name="fone" value="${editar.fone}">
			</td>
		</tr>
		<tr>
			<td>		
		<label for="cnpj">Cnpj</label>
			</td>
			<td>		
		<input type="text" name="cnpj" value="${editar.cnpj}">
			</td>
		</tr>
		<tr>
			<td>		
		<label for="razao">Razao Social</label>
			</td>
			<td>		
		<input type="text" name="razao" value="${editar.razaoSocial}">
			</td>
		</tr>
		<tr>
			<td>		
		<label for="web">End. Web</label>
			</td>
			<td>		
		<input type="text" name="web" value="${editar.web}">
			</td>
		</tr>
		</table>		
		<c:if test="${not empty editar }">
			<input type="hidden" name="editar_id" value="${editar.id }">
		</c:if>
		
	<input type="submit" value="Cadastrar">
		
	</form>
	
</section>
</body>
</html>