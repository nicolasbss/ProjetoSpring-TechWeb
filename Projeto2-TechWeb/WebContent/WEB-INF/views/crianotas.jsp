<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style type="text/css">  <%@include file="form_style.css" %> </style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
<% int id_usuario = (Integer) session.getAttribute("pessoa_id");%>
<div class="login-page">
  <div class="form">
  <h3>Criar Nota</h3>
    <form class="login-form" action="CriaNotas" method="post">
    Selecione o tipo da sua nota: <select name='tipo'><option value='texto'> Texto </option></select><br><br>
      <input type="text" name="conteudo" placeholder="conteudo"/>
      <input type = "hidden" value =<%=id_usuario %> name = "pessoa_id">
      <input id="botao" type="submit" value="Criar">
    </form>
  </div>
</div>
</body>
</html>