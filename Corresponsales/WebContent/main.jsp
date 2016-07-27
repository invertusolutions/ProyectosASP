<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:f="http://java.sun.com/jsf/core"      
      xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin - Corresponsales</title>
<link rel="stylesheet"	href="resources/css/jquery-ui.css">
<link rel="stylesheet"	href="resources/css/theme.css">
<script src="resources/js/jquery-1.12.4.js"></script>
<script src="resources/js/jquery-ui.js"></script>
<script src="resources/js/utils.js"></script>

<script>
	$(function() {
		$("#tabs")
				.tabs(
						{
							beforeLoad : function(event, ui) {
								ui.jqXHR
										.fail(function() {
											ui.panel
													.html("No fue posible cargar la información ");
										});
							}
						});
	});
</script>
</head>
<body>
	<div id="header">
		<table cellpadding="20" width="100%">
			<tr>
				<td width="340px"><img src="img/logoASP.png"></td>
				<td><img src="img/loading.gif" id="image" style="display:none;"></td>
				<td><h1>&nbsp;<br>Catálogo de Corresponsales</h1></td>
			</tr>
			
		</table>
		<h2>Usuario: <%=session.getAttribute("username") %> | <a href="logout.jsf">Cerrar sesión</a></h2>	
	</div>
	<div id="tabs">
		<ul>
			<li><a href="#tabs-1">Inicio</a></li>
			<li><a href="resources/bolson.jsf">Ampliación de Bolsón</a></li>
			<li><a href="resources/bloqueos.jsf">Bloqueo</a></li>
			<li><a href="resources/desbloqueos.jsf">Desbloqueo</a></li>
			<li><a href="resources/reportes.jsf">Reportes</a></li>
		</ul>
		<div id="tabs-1">
			<iframe src="resources/ini.jsf" width="100%" frameborder="0" height="360px"></iframe>
		</div>
	</div>


</body>
</html>