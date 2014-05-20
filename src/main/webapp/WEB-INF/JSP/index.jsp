<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
	<head>
		<title>Menu</title>
		<link rel='stylesheet'
			href='${pageContext.servletContext.contextPath}/styles/default.css'>
	</head>
	<body>
		<nav>
			<ul class='zonderbolletjes'>
				<li><a href="<c:url value='/brouwers'/>">Brouwers</a></li>
				<li><a href="<c:url value='/brouwers/opnaam'/>">
					Brouwers op naam</a></li>
				<li><a href="<c:url value='/brouwers/toevoegen'/>">
					Brouwer toevoegen</a></li>
				<li><a href="<c:url value='/brouwers/opalfabet'/>">
					Brouwers op alfabet</a></li>
			</ul>
		</nav>
	</body>
</html>