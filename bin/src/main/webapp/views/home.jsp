<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Student</title>
</head>
<body>

	<form method="POST" action="saveupdateStudent">
		<label>Id</label><input type="text" name="id" value="${student.id}" readonly></input><br>
		<label>Name</label><input type="text" name="name" value="${student.name}"  ></input><br>
		<label>Course</label><input type="text" value="${student.course}" name="course"></input><br>
		<label>Fees</label><input type="text" value="${student.fees}"  name="fees"></input><br>
		<input type="submit" value="Update">
	</form>
	
	${msg}
	
	<a href="/showStudents">Show Students</a>

</body>
</html>