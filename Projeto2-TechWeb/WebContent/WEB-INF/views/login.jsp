<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style type="text/css">  <%@include file="form_style.css" %> </style>
<head>
<link rel="stylesheet" type="text/css" href="bootstrap.css">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>


<div class="login-page">
  <div class="form">
    <form class="login-form" action="AutenticaUsuario">
    <h3>Login</h3>
      <input type="text" name="login" placeholder="username"/>
      <input type="password" name="senha" placeholder="password"/>
      <input id="botao" type="submit" value="Entrar">
    </form>
   <form class="login-form" action="Cadastro">
		<input id="botao" type="submit" value="Registrar">
	</form>
  </div>
</div>



</body>
</html>