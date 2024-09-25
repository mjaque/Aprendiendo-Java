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
	<!-- Creamos una url para llamar a una acción y la utilizamos inmediatamente -->
	<p><a href="<s:url action='accion1'/>">¡Hola Mundo!</a></p>
	
	<!-- Crea una variable de tipo url, con el parámetro indicado que se pasará por GET -->
	<s:url action="accion1" var="enlace1">
		<s:param name="nombreUsuario">Miguel Jaque</s:param>
	</s:url>

	<!-- Usamos la variable -->
	<p><a href="${enlace1}">Texto del enlace</a></p>
	
	<p>Creamos un formulario:</p>

	<!-- El tag se expande y crea una tabla, los inputs, los labels... -->
	<s:form action="accion1">
		<!-- El input toma el valor de nombreUsuario (si lo hay) llamando a su getter
		Y al enviarse el formulario, cambia el valor de nombreUsuario llamando a su setter -->
		<s:textfield name="nombreUsuario" label="Nombre" />
		<s:submit value="Enviar" />
	</s:form>
</body>
</html>