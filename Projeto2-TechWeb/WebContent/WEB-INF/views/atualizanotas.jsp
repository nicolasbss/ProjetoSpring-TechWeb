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
	<%@ page import="java.util.*,mvc.model.*,mvc.controller.*" %>
	
    
    <div class="login-page">
  <div class="form">
    <form class="login-form" action="AtualizaNotas" method="POST">
    <% DAO dao = new DAO();
    int id = (Integer) session.getAttribute("idNota");
    int pessoa_id = (Integer) session.getAttribute("pessoa_id");
    String text = dao.getNota(id);%>
    <h3>Atualizar Nota</h3>
    Tipo: <select name='tipo'><option value='texto'>Texto </option></select><br><br>
      <input type="text" name="conteudo" value='<%=text%>'/>
      <input type ="hidden" name = "id" value= <%=id %>>
      <input type ="hidden" name = "pessoa_id" value=<%=pessoa_id %>>
      <input id="botao" type="submit" value="Atualizar">
    </form>
  </div>
</div>
</body>
</html>