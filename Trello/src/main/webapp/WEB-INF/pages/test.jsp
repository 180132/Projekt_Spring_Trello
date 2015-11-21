<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <title>AngelPrime to-do List</title>
		<!--
		<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
		-->
		<!-- 
		<link href="<c:url value="/style/lib/Bootstrap/bootstrap.min.css" />" rel="stylesheet">
		<link href="<c:url value= "/style/lib/jQuery/jquery.ui.min.css" />" rel="stylesheet">
		<link href="<c:url value= "/style/assets/todo.css" />" rel="stylesheet">
		-->  
 
        <link rel="stylesheet" type="text/css" href="/style/lib/Bootstrap/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="/style/lib/jQuery/jquery.ui.min.css" />
        <link rel="stylesheet" type="text/css" href="/style/assets/todo.css" />
      
	</head>
	
	<body class = "well">
		<div id = "container">
		
			<div id="header"> To Do List </div>
	
			<div class="task-list task-container" id="pending">
				<h3>Pending</h3>
				<!-- Sample task added manually to check look -->

			</div>

			
			<div class="task-list">
				<h3>Add a task</h3>
				<form id="todo-form">
					<input type="text" placeholder="Title" />
					<textarea placeholder="Descrtipion"></textarea>
					<input type="text" placeholder="Due Date (dd/mm/yyyy)" />
					<input type="button" class="btn btn-primary" value="Add Task"  onclick="todo.add();"/>
				</form>

				<input type="button" class="btn btn-primary" value="Clear Data" onclick="todo.clear();"/>

				<div id="delete-div">
					Drag Here to Delete
				</div>
			</div>
			
			<div style="clear:both;"></div>
			
			<!--
			<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
			-->
			<script type="text/javascript" src="<c:url value="/style/lib/jQuery/jquery.min.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/style/lib/Bootstrap/bootstrap.min.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/style/lib/jQuery/jquery.ui.min.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/style/assets/todo.js"/>"></script>
			<!--  
			<script type="text/javascript" src="lib/jQuery/jquery.min.js"></script>
			<script type="text/javascript" src="lib/Bootstrap/bootstrap.min.js"></script>
			<script type="text/javascript" src="lib/jQuery/jquery.ui.min.js"></script>
			<script type="text/javascript" src="assets/todo.js"></script>
			-->

			<script type="text/javascript">
				$( "#datepicker" ).datepicker();
				$( "#datepicker" ).datepicker("option", "dateFormat", "dd/mm/yy");

				$(".task-container").droppable();
				$(".todo-task").draggable({ revert: "valid", revertDuration:200 });
				todo.init();
			</script>
		</div>

	
	</body>

</html>