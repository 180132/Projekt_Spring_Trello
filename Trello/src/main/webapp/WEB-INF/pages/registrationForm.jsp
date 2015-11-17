<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message var="msgAllFieldsRequired" code="newUserRegistration.message.allFieldsRequired" />
<spring:message var="pageTitle" code="newUserRegistration.pageTitle" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style = "background-color: #3385FF">
	<center><div style = "background-color: blue;
						color: white;
						text-algin: center;
						width: 600px;
						height: 100%;
						border-radius: 10px;">
		<form:form action="." modelAttribute="account">
			<h1>Rejestracja nowego uzytkownika</h1>
			<div style = "width: 300px;">
				<div><spring:message code="newUserRegistration.label.username" /><form:input path="username" /></div>
				<div><spring:message code="newUserRegistration.label.password" /><form:password path="password" /></div>
				<div><spring:message code="newUserRegistration.label.confirmPassword" /><form:password path="confirmPassword" /></div>
				<div><spring:message code="newUserRegistration.label.email" /><form:input path="email" /></div>
				<div><spring:message code="newUserRegistration.label.firstName" /><form:input path="firstName" /></div>
				<div><spring:message code="newUserRegistration.label.lastName" /><form:input path="lastName" /></div>
			
				<div><form:checkbox id="marketingOk" path="marketingOk" />Wysylaj mi informacje o produkcie</div>
				<div><form:checkbox id="acceptTerms" path="acceptTerms" />Zgadzam sie z warunkami korzystania z serwisu</div>
				<div><input type="submit" value="Zarejestruj" /></div>
			</div>
			
		</form:form>
		</br>
	</div></center>

</body>
</html>