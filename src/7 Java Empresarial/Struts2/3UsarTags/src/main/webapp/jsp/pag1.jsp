<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf8"/>
	<title>Struts2 - UsarTags</title>
</head>
<body>
	<h1>Struts2 - UsarTags</h1>
	<p>El mensaje es: <s:property value="mensaje"/></p>
	<p>Se ha ejecutado <s:property value="contador" /> veces.</p>
</body>
</html>