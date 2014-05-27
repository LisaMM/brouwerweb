<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="nl">
	<head>
		<title><fmt:message key="menu" /></title>
		<link rel="stylesheet"
			href="${pageContext.servletContext.contextPath}/styles/default.css">
	</head>
	<body>
		<nav>
			<ul class="zonderbolletjes">
				<li><a href="<c:url value='/brouwers'/>">
					<fmt:message key="alleBrouwers" />
				</a></li>
				<li><a href="<c:url value='/brouwers/opnaam'/>">
					<fmt:message key="brouwersOpNaam" />
				</a></li>
				<li><a href="<c:url value='/brouwers/opalfabet'/>">
					<fmt:message key="brouwersOpAlfabet" />
				</a></li>
				<li><a href="<c:url value='/brouwers/toevoegen'/>">
					<fmt:message key="brouwerToevoegen" />
				</a></li>
			</ul>
		</nav>
		<h2>
			<fmt:message key="${groet}" />
		</h2>
	</body>
</html>