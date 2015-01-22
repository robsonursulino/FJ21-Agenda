<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tagutil" %>

<!DOCTYPE html>
<html>
<head>
	<link href="css/jquery-ui.css" rel="stylesheet">
	
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui.js"></script>	

	<meta charset="ISO-8859-1">
	<title>Contato</title>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>

	<h1>Dados do contato</h1>
	<hr>
	<form action="mvc" method="post">
		Nome: <input type="text" name="nome_contato" value="${contato.nome_contato}"><br>
		E-mail: <input type="text" name="email" value="${contato.email}"><br>
		Endereço: <input type="text" name="endereco" value="${contato.endereco}"><br>
		
		<fmt:formatDate value="${contato.data_nascimento.time}" pattern="dd/MM/yyyy" var="nascimento"/>
		
		Data de nascimento: <tagutil:campoData id="data_nascimento" value="${nascimento}"></tagutil:campoData>

		<input type="hidden" name="logica" value="EditaContatoLogica">
		<input type="hidden" name="cod_contato" value="${contato.cod_contato}">
		<input type="submit" value="Gravar">
	</form>
	
	<c:import url="rodape.jsp"></c:import>
</body>
</html>