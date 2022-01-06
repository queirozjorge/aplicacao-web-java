<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/entrada?acao=AlteraEmpresa" var="linkEntradaAlteraEmpresa" />

<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar dados de empresa</title>
</head>
<body>

<c:import url="logout-parcial.jsp" /> <br /> <br />

	<form action="${linkEntradaAlteraEmpresa}" method="post">
		<input type="text" name="nome" value="${empresa.nome}"> Nome <br /> <br /> 
		<input type="text" name="cnpj" value="${empresa.cnpj}"> CNPJ <br /> <br /> 
		<input type="text" name="data" value="<fmt:formatDate value="${empresa.data}" pattern="dd/MM/yyyy" />"> Data <br /> <br /> 
		<input type="hidden" name="id" value="${empresa.id}"> <br /> <br /> 
		<input type="submit">
	</form>

</body>
</html>