<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nicenes</title>
</head>
<body>
<a href="cadastra-usuario.html">Cadastre-se</a>
<a href="login.html">Faça o login</a>
<a href="logout">Logout</a>

${usuarioLogado.nome}
</body>
</html>