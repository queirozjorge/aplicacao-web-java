<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/entrada?acao=Login" var="linkLogin"/>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<form action="${linkLogin}" method="post">
		<input type="text" name="login"> Login <br /> <br />
		<input type="password" name="senha"> Senha <br /> <br />
		<input type="submit">
	</form>

</body>
</html>