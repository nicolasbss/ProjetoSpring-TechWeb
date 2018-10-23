<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style type="text/css">  <%@include file="style.css" %> </style>
<link href="https://fonts.googleapis.com/css?family=Chakra+Petch|Charmonman|Mali|Niramit|Oswald|Roboto" rel="stylesheet">

<head>
<%@ page import="java.util.*,mvc.model.*,mvc.controller.*, com.google.cloud.translate.*, com.google.cloud.translate.Translate.TranslateOption, com.google.auth.oauth2.GoogleCredentials, com.google.common.collect.Lists,java.io.FileInputStream" %>

<%
	DAO dao = new DAO();
	Translate translate = TranslateOptions.getDefaultInstance().getService();
	
	int id_usuario = (Integer) session.getAttribute("usuario");
	List<Notas> listaNotas = dao.getListaNotas(id_usuario); %>
</head>
<body>
<div class= "button-flex">
<div class="form">
	<form class="login-form" action = "FiltraNotas">
		<input type = "text" name="palavra_filtrada">
		<input type = "hidden" value =<%= id_usuario %> name = "pessoa_id">
		<input id="home" class="button" type = "submit" value="Filtrar notas">
	</form></div></div>
	
<div class="flex-container">
<% for (Notas nota : listaNotas) { 
	
	String conteudo_traduzido = nota.getConteudo();

	Translation translation = translate.translate(
	    	conteudo_traduzido,
	    	TranslateOption.sourceLanguage("br"),
	    	TranslateOption.targetLanguage("en"));


%>
  <div class="grid-item">
  	<p id="texto_nota" style="font-family:<%=nota.getFont() %>, serif;"><%=translation.getTranslatedText()%></p>
  	<h6 id="data"> Criado em <%=dao.horarioCriacao(nota)%></h6>
  	<div class="button-flex">
  	<div>
	<form action = "RemoveNota" method = "post">
		<input type='hidden' name='id' value="<%= nota.getId()%>">
		<input type="hidden" name='pessoa_id' value=<%=id_usuario %>>
		<input id="apagar" class="button" type ="submit" value = "Apagar">
	</form></div>
	<div>
	<form action = "AtualizaNotas" method = "get">
		<input type='hidden' name='id' value="<%= nota.getId()%>">
		<input type="hidden" name='pessoa_id' value=<%=id_usuario %>>
		<input id="editar" class="button" type = "submit" value = "Editar">
	</form></div>
	</div>
  </div>
<% } %>
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
	<form action="login">
		<input id="home" class="button" type = "submit" value="Logout">
	</form></div>
	</div>

</body>
</html>