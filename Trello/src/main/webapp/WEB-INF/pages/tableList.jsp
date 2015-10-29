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
Boards:
</br>
	<a href="/Trello/addTable/Board name">
		<button>Add board</button>
	</a>
</br>
	<c:forEach items="${requestScope.tables}" var="table" varStatus="loopCounter">
      	<tr>
      	<td><c:out value="${table.name}"/></td>
        </tr>
      	<a href="/Trello/tablePage/${loopCounter.index}/${table.name}"><button>Go to</button></a>
      	<a href="/Trello/deleteTable/${loopCounter.index}"><button>Delete</button></a>
        </br>
	</c:forEach>

</body>
</html>