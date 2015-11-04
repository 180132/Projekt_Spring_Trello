
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="." modelAttribute="account">
		<h1>Rejestracja nowego uzytkownika</h1>
		<div>Nazwa uzytkownika: <form: input path="username" /></div>
		<div>Haslo: <form: password path="password" /></div>
		<div>Potwierdz haslo: <form: password path="confirmPassword" /></div>
		<div>Adres e-mail: <form: input path="email" /></div>
		<div>Imie: <form: input path="name" /></div>
		<div>Nazwisko: <form: input path="surename" /></div>
		<div><form: checkbox id="marketingOk" path="marketingOk" />Pierdoly</div>
		<div><form: checkbox id="acceptTerms" path="acceptTerms" />Zgadzam sie ze jestem debilem</div>
		<div><input type="submit" value="Zarejestruj" /></div>
		
	</form:form>

</body>
</html>