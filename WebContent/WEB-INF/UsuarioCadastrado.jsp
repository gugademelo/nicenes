<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  
<jsp:useBean id="usuario" type="model.Usuario" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${usuario.nome}, seu usuário com o email ${usuario.email} foi cadastrado com sucesso.</h1>
	<a href="login.html">Faça o login</a>
</body>
</html>