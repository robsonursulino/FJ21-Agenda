<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tagutil" %>

<!DOCTYPE html>
<html>
<head>
	<link href="css/jquery-ui.css" rel="stylesheet">
	
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui.js"></script>	
	
	<meta charset="ISO-8859-1">
	
	<title>Adicionando Contato</title>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>

	<h1>Adiciona Contato</h1>
	<hr>
	<form action="adicionaContato" method="post">
		Nome: <input type="text" name="nome_contato"><br>
		E-mail: <input type="text" name="email"><br>
		Endereço: <input type="text" name="endereco"><br>
		Data de nascimento: <tagutil:campoData id="data_nascimento"></tagutil:campoData>

		<input type="submit" value="Gravar">
	</form>
	
	<c:import url="rodape.jsp"></c:import>
</body>
</html>