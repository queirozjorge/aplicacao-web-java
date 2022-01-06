<%@page import="br.com.alura.gerenciador.modelo.Empresa"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de empresas</title>
</head>
<body>

	<c:import url="logout-parcial.jsp" /> <br />
	
	<c:if test="${not empty empresa}">
	
		Empresa ${ empresa } cadastrada com sucesso!
		
	</c:if> <br /> <br />

	Lista de empresas:
	<br />

	<ul>
		<c:forEach items="${ listaEmpresas }" var="empresa">
			<li>${ empresa.nome } - CNPJ: ${ empresa.cnpj } - <fmt:formatDate value="${empresa.data}" pattern="dd/MM/yyyy" />
				<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}"> editar</a>
				<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}"> remover</a>
			</li>
		</c:forEach>

	</ul>
<br />
<a href="/gerenciador/entrada?acao=NovaEmpresaForm"> Nova Empresa</a>

</body>
</html>