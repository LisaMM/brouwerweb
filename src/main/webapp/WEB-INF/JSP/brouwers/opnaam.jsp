<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang='nl'>
	<head>
		<title>Brouwers op naam</title>
		<link rel='stylesheet'
			href='${pageContext.servletContext.contextPath}/styles/default.css'>
	</head>
	<body>
		<a href="<c:url value='/'/>">Menu</a>
		<h1>Brouwers op naam</h1>
		<c:url value="/brouwers" var="url"/>
		<form:form action="${url}" method="get" commandName="brouwersOpNaamForm">
			<form:label path="beginnaam">
				Begin van de naam: <form:errors path="beginnaam" cssClass="fout"/>
			</form:label>
			<form:input path="beginnaam" type="text" autofocus="autofocus"/>
			<input type="submit" value="Zoeken"/>
		</form:form>
		<c:if test="${not empty brouwers}">
			<ul>
				<c:forEach items="${brouwers}" var="brouwer">
					<li>${brouwer.naam}</li>
				</c:forEach>
			</ul>
		</c:if>
	</body>
</html>