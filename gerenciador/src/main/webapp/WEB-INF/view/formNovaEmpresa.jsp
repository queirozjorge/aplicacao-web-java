<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/entrada?acao=NovaEmpresa" var="linkEntradaNovaEmpresa"/>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar nova empresa</title>
</head>
<body>

<c:import url="logout-parcial.jsp" /> <br /> <br />

	<form action="${linkEntradaNovaEmpresa}" method="post">
		<input type="text" name="nome"> Nome <br /> <br />
		<input type="text" name="cnpj"> CNPJ<br /> <br />
		<input type="text" name="data"> Data <br /> <br />
		<input type="submit">
	</form>

</body>
</html>