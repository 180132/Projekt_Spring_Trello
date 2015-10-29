<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Lists of ${tableName} board:
</br>
	<a href="/Trello/addList/${tableIndex}/nowa_lista"><button>Add</button></a>
</br>
	<c:forEach items="${requestScope.lists}" var="list" varStatus="loopCounter">
	
      	<tr>
      	<td><c:out value="${list.name}"/></td>
      	<a href="/Trello/deleteList/${tableIndex}/${loopCounter.index}"><button>Delete</button></a>
        </tr>
        </br>
	</c:forEach>
</body>
</html>