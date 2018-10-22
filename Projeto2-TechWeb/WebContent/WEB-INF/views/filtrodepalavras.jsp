<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style type="text/css">  <%@include file="style.css" %> </style>
<link  href="http://fonts.googleapis.com/css?family=Reenie+Beanie:regular" rel="stylesheet"type="text/css">

<head>
<%@ page import="java.util.*,mvc.model.*,mvc.controller.*" %>

<%	DAO dao = new DAO();
	String palavra_filtrada = (String) session.getAttribute("palavra_filtrada");
	int id_usuario = (Integer) session.getAttribute("usuario");
	List<Notas> listaNotas = dao.getListaNotas(id_usuario);%>
</head>
<body>	
	<div class="flex-container">
		<% for (Notas nota : listaNotas) {
		if (nota.getConteudo().contains(palavra_filtrada)) { %>
		<div class="grid-item">
			<p id="texto_nota"><%=nota.getConteudo()%></p>
			<h6 id="data"> Criado em <%=dao.horarioCriacao(nota)%></h6>
  			<div class="button-flex">
  			<div>
			<form action = "RemoveNota" method = "post">
				<input type='hidden' name='id' value="<%= nota.getId()%>">
				<input type="hidden" name='pessoa_id' value=<%=id_usuario %>>
				<input id="apagar" class="button" type ="submit" value = "Apagar">
			</form></div>
			<div>
			<form action = "AtualizaNotas">
				<input type='hidden' name='id' value="<%= nota.getId()%>">
				<input type="hidden" name='pessoa_id' value=<%=id_usuario %>>
				<input id="editar" class="button" type = "submit" value = "Editar">
	</form></div>
	</div>
  	</div>
		<% }
			} %>
	</div>
	
	
<div class= "button-flex">
<div>
	<form action = "CriaNotas" method = "get">
		<input type = "hidden" value =<%= id_usuario %> name = "pessoa_id">
		<input id="home" class="button" type = "submit" value = "Crie uma nota">
	</form></div>
<div>
	<form action="AlteraCredenciais">		
		<input type="hidden" name='pessoa_id' value=<%=id_usuario %>>
		<input id="home" class="button" type ="submit" value="Alterar login e senha">
	</form></div>
<div>
	<form action="OrdenaNotas">
		<input type="hidden" name='pessoa_id' value=<%=id_usuario %>>
		<input id="home" class="button" type = "submit" value="Ordenar: Atualização">
	</form></div>
<div>
	<form action="ListaNotas">
		<input type="hidden" name='pessoa_id' value=<%=id_usuario %>>
		<input id="home" class="button" type = "submit" value="Ordenar: Criação">
	</form></div>
	</div>
	
</body>
</html>