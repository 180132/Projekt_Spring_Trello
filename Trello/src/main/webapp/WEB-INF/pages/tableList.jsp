<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body style = "background-color: #3385FF">
		<header style = "background-color: #1A1AFF;
						color: white;
						text-algin: center;
						width: 100%;
						height: 50px;
						border-radius: 10px;">
			<center>Trello</center>
		</header>
		
			<a href="/Trello/addTable/Board name">
				<div style = "width: 200px;
						height: 25px;
						background-color: #FF1A1A;
						border-radius: 10px;">

						<center>ADD Board</center>
				</div>
			</a>
			<aside style="float:right; width:35%;">
			<h3>Historia</h3>
				<c:forEach items="${requestScope.history}" var="event" varStatus="loopCounter">
					<c:out value="${event}"/><br/>
				</c:forEach>
			</aside>
			<section>
				<c:forEach items="${requestScope.tables}" var="table" varStatus="loopCounter">
					<div style = "width: 210px;
								height: 110px;
								float: left;">
						
						<a href="/Trello/tablePage/${loopCounter.index}/${table.name}">					
							<div style = "width: 200px;
									height: 100px;
									background-color: red;">								
	
								<c:out value="${table.name}"/>
	
								<a href="/Trello/deleteTable/${loopCounter.index}"><button>Delete</button></a>
								
							</div>
						</a>
					</div>
				</c:forEach>
			</section>
	</body>
</html>