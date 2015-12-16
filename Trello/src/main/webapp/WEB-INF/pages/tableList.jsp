<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style/assets/tableList.css" />
		<link rel="stylesheet" type="text/css" href="style/lib/Bootstrap/bootstrap.min.css" />
		<title>Insert title here</title>
	</head>
	<body class = "body_table">
		<header class = "header_table">
			<center>
				<h3>Trello</h3>
			</center>
		</header>
		
			<h5><a href="/Trello/addTable/Board name" style="color: white">
				<div class = "add_button">

						<center>ADD Board</center>
				</div>
			</a></h5>
			<aside class = "history_panel">
				<h3>Historia</h3>
					<c:forEach items="${requestScope.history}" var="event" varStatus="loopCounter">
						<c:out value="${event}"/><br/>
					</c:forEach>
			</aside>
			<section class = "main_panel">
				<c:forEach items="${requestScope.tables}" var="table" varStatus="loopCounter">
					<div class = "list_button_shadow">
						
						<center><a href="/Trello/tablePage/${loopCounter.index}/${table.name}" style="color: white">
							<div class = "list_button">								
	
								<h4><c:out value="${table.name}"/></h4>
								<center><a href="/Trello/deleteTable/${loopCounter.index}"><button type="button" class="btn btn-primary">Delete</button></a></center>
								
							</div>
						</a></center>
					</div>
				</c:forEach>
			</section>
	</body>
</html>