<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Inicio</title>
	<link type="text/css" href="<c:url value='/resources/css/style.css'/>" rel="stylesheet"/>
</head>
<body>
	<section>
		<form action="login" method="post">
			<div>
				<div>Nombre:</div>
				<div><input type="text" id="nombre" name="nombre" /></div>
			</div>
			<div>
				<div>Contraseña:</div>
				<div><input type="password" id="password" name="password" /></div>
			</div>
			<div>
				<input type="submit" value="Login" id="btnLogin" name="btnLogin"/>
			</div>
		</form>
	</section>
</body>
<script type="text/javascript" src="<c:url value='/js/jquery-1.11.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/scripts.js'/>"></script>
</html>