<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="nl">
<head>
<title>Brouwer toevoegen</title>
<link rel="stylesheet"
href="${pageContext.servletContext.contextPath}/styles/default.css">
</head>
<body>
<div><a href="<c:url value='/'/>">Menu</a></div>
<h1>Brouwer toevoegen</h1>
<c:url value="/brouwers" var="url"/>
<form:form action="${url}" method="post" commandName="brouwer" id="toevoegform">
<jsp:include page="brouwerformfields.jsp"/>
<input type="submit" value="Toevoegen" id="toevoegknop">
</form:form>
<script>
document.getElementById('toevoegform').onsubmit= function() {
document.getElementById('toevoegknop').disabled=true;
};
</script>
</body>
</html>