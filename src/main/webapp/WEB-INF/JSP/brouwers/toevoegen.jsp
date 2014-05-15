<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
	<head>
		<title>Brouwer toevoegen</title>
		<link rel='stylesheet'
			href='${pageContext.servletContext.contextPath}/styles/default.css'>
	</head>
	<body>
		<a href="<c:url value='/'/>">Menu</a>
		<h1>Brouwer toevoegen</h1>
		<form method='post' action='<c:url value="/brouwers/toevoegen"/>'>
			Hier komen later de invoervelden van de brouwer ...
			<div>
				<input type='submit' value='Toevoegen'>
			</div>
		</form>
	</body>
</html>