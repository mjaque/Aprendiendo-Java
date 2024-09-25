<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf8"/>
	<title>Struts2 - Registro</title>
</head>
<body>
	<h1>Registro de Persona</h1>
	<s:form action="registrar">
		<s:textfield name="personaBean.nombre" label="Nombre" />
		<!-- para AccionRegistrar, se llama a getPersonaBean().setNombre()-->
		<s:textfield name="personaBean.apellidos" label="Apellidos" />
		<!-- Podemos utilizar los input de HTML5-->
		<s:textfield type="email" name="personaBean.email"  label ="Email"/>  
		<s:textfield type="number" name="personaBean.edad"  label="Edad"  />
		<s:submit value="Registrar"/>
	</s:form>	
</body>
</html>