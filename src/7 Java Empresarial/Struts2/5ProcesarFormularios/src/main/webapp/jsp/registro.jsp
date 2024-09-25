<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf8"/>
	<title>Struts2 - Registro</title>
	<!-- Añade css y javascript (por defecto) -->
	<s:head />
</head>
<body>
	<h1>Registro de Persona</h1>
	<s:form action="registrar">
		
		<s:textfield name="personaBean.nombre" label="Nombre" />
		<!-- para AccionRegistrar, se llama a getPersonaBean().setNombre()-->
		
		<!-- Si usamos su resource bundle. La key debe coincidir con un campo del Bean y con la key del bundle para encontrar la etiqueta -->
		<s:textfield key="personaBean.apellidos" />
		
		<!-- Podemos utilizar los input de HTML5-->
		<s:textfield type="email" key="personaBean.email" />  
		<s:textfield type="number" key="personaBean.edad" />
		<s:submit value="Registrar"/>
	</s:form>	
	<p><s:text name="copyright"/></p>
</body>
</html>