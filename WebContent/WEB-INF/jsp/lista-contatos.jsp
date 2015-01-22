<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="css/estilo_tabela.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lista de contatos</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>

	<a href="mvc?logica=MostraContatoLogica&id=0">Criar novo</a>

	<!-- Lista os contatos -->
	
	<display:table name="contatos" uid="contato">
		<display:column property="nome_contato" title="Nome"/>
		<c:choose>
			<c:when test="${not empty contato.email}">
				<display:column property="email" title="E-mail" autolink="true"/>
			</c:when>
			<c:otherwise>
				<display:column value="E-mail não cadastrado" title="E-mail"/>
			</c:otherwise>
		</c:choose>
		<display:column property="endereco" title="Endereço"/>
		<display:column property="data_nascimento.time" title="Data de nascimento" format="{0,date,dd/MM/yyyy}"/>
		<display:column title="" value="Editar" href="mvc?logica=MostraContatoLogica" paramId="id" paramProperty="cod_contato"/>
		<display:column title="" value="Remover" href="mvc?logica=RemoveContatoLogica" paramId="id" paramProperty="cod_contato"/>
	</display:table>
	
	<!--  
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Endereço</th>
			<th>Nascimento</th>			 
		</tr>
		<c:forEach var="contato" items="${contatos}" varStatus="id">
			<tr bgcolor="${id.count % 2 ==0 ? 'aaee88' : 'ffffff' }">
				<td>${contato.nome_contato}</td>
				<td>
					<c:if test="${not empty contato.email}">
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:if>
					<c:if test="${empty contato.email}">
						E-mail não cadastrado
					</c:if>
				</td>	
				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.data_nascimento.time}" pattern="dd/MM/yyyy"/></td>
				<td><a href="mvc?logica=MostraContatoLogica&id=${contato.cod_contato}">Editar</a></td>				
				<td><a href="mvc?logica=RemoveContatoLogica&id=${contato.cod_contato}">Remover</a></td>
			</tr>
		</c:forEach>
	</table> -->
	<c:import url="rodape.jsp"/>
</body>
</html>