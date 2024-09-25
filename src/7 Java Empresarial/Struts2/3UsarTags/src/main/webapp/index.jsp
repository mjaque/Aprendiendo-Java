<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8"/>
	<title>Struts2 - Usar Tags</title>
<head>
<body>
	<h1>Struts2 - Usar Tags</h1>
	<p><a href="<s:url action='accion1'/>">¡Hola Mundo!</a></p>
	
	<!-- Crea una variable de tipo url, con el parámetro indicado que se pasará por GET -->
	<s:url action="accion1" var="enlace1">
		<s:param name="nombreUsuario">Miguel Jaque</s:param>
	</s:url>

	<!-- Usamos la variable -->
	<p><a href="${enlace1}">Texto del enlace</a></p>
	
	<p>Creamos un formulario:</p>

	<s:form action="accion1">
		<s:textfield name="nombreUsuario" label="Nombre" />
		<s:submit value="Enviar" />
	</s:form>
</body>
</html>