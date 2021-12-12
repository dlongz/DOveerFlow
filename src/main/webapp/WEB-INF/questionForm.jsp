<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Question</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
	<div class="container-sm">
		<h1>What's Your Question</h1>
		<form:form actions="/questions/new" method="post" modelAttribute="questionForm">
			<div>
				<form:label path="question">Question:</form:label>
				<form:errors path="question"/>
				<form:textarea path="question"/>
			</div>
			<div>
				<form:label path="frontEndTags">Tags:</form:label>
				<form:errors path="frontEndTags"/>
				<form:input path="frontEndTags"/>
			</div>
			<input type="submit" value="Submit" class="btn btn-success"/>
		</form:form>
	</div>
</body>
</html>