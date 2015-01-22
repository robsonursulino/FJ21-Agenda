<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*,br.com.caelum.dao.*,br.com.caelum.modelo.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Contatos</title>
</head>
<body>
	<table border="1">
		<% ContatoDAO dao = new ContatoDAO(); %>
		<% List<Contato> contatos = dao.getLista(); %>
		<% SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy"); %>
		<tr>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Endereço</th>
			<th>Data de nascimento</th>									
		</tr>
		<% for (Contato contato : contatos) { %>
			<tr>
				<td><%= contato.getNome_contato() %> </td>
				<td><%= contato.getEmail() %> </td>
				<td><%= contato.getEndereco() %> </td>
				<td><%= fmt.format(contato.getData_nascimento().getTime()) %> </td>				
			</tr>
		<% } %>	
	</table>
</body>
</html>