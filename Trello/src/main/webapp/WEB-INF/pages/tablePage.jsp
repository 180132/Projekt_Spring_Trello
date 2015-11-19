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
	<header style = "background-color: blue;
						color: white;
						text-algin: center;
						width: 100%;
						height: 50px;
						border-radius: 10px;">
		<center>Trello</center>
	</header>
Lists of "${tableName}" board:
</br>
	<a href="/Trello/addList/${tableIndex}/${tableName}/List name">
		<div style = "width: 200px;
					height: 25px;
					background-color: red;
					border-radius: 10px;">
						
			<center>ADD List</center>
						
		</div>
	</a>
</br>
	<aside style="float:right; width:35%;">
	<h3>Historia</h3>
		<c:forEach items="${requestScope.history}" var="event" varStatus="loopCounter">
			<c:out value="${event}"/><br/>
		</c:forEach>
	</aside>
	<c:forEach items="${requestScope.lists}" var="list" varStatus="loopCounter">
		<div style = "width: 210px;
					height: 110px;
					float: left;">
							
	      	<tr>
	      	<td><c:out value="${list.name}"/></td>
	        </tr>
	      	<a href="/Trello/deleteList/${tableIndex}/${tableName}/${loopCounter.index}"><button>Delete</button></a>
	        </br>
        </div>
	</c:forEach>
</body>
</html>