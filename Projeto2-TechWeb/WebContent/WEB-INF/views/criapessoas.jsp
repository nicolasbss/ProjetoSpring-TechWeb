<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<style type="text/css">  <%@include file="form_style.css" %> </style>
<head>
<meta charset="ISO-8859-1">
<title>Registrar</title>
</head>
<body>
<div class="login-page">
  <div class="form">
	<form class="login-form" action = "Cadastro" method='post'>
	<h3>Registrar</h3>
		<input type='text' name='login' placeholder="username">
		<input type="password" name="senha" placeholder="password"/>
		<input id="botao" type="submit" value="Registrar">
	</form>
	  </div>
</div>
</body>
</html>