<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8"/>
	<title>Con Struts2</title>
<head>
<body>
	<h1>Struts2 - UsarTags</h1>
	<p><a href="<s:url action='accion1'/>">¡Hola Mundo!</a></p>
	
	<s:url action="accion1" var="enlace1">
		<s:param name="nombreUsuario">Miguel Jaque</s:param>
	</s:url>

	<p><a href="${enlace1}">Hello Bruce Phillips</a></p>
	
	<p>Creamos un formulario:</p>

	<s:form action="accion1">
		<s:textfield name="nombreUsuario" label="Nombre:" />
		<s:submit value="Enviar" />
	</s:form>
</body>
</html>