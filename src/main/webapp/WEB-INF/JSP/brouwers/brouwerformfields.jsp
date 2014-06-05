<%-- Je gebruikt deze include bij toevoegen én bij wijzingen brouwer --%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:label path="naam">Naam:
<form:errors path="naam" cssClass="fout"/></form:label>
<form:input path="naam" autofocus="autofocus" />
<form:label path="adres.straat">Straat:
<form:errors path="adres.straat" cssClass="fout"/></form:label>
<form:input path="adres.straat"/>
<form:label path="adres.huisNr">Huisnr.:
<form:errors path="adres.huisNr" cssClass="fout"/></form:label>
<form:input path="adres.huisNr"/>
<form:label path="adres.postcode">Postcode:
<form:errors path="adres.postcode" cssClass="fout" /></form:label>
<form:input path="adres.postcode" type="number"/>
<form:label path="adres.gemeente">Gemeente:
<form:errors path="adres.gemeente" cssClass="fout"/></form:label>
<form:input path="adres.gemeente"/>
<form:label path="omzet">Omzet:
<form:errors path="omzet" cssClass="fout"/></form:label>
<form:input path="omzet" type="number"/>