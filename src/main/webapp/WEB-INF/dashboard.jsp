<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Dojo Overflow Dashboard</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	
</head>
<body>
	<div class="container-sm">
		<h1>Questions Dashboard</h1>
		<table>
			<thead>
				<tr>
					<th>Question</th>
					<th>Tags</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
				<c:when test="${ques == null}">
				<tr>
					<td>No Questions Yet. How about you ask one?</td>
				</tr>
				</c:when>
				<c:otherwise>
				<c:forEach items="${ques}" var="ques">
				<tr>
					<td><a href="/questions/${ques.id}">${ques.question}</a></td>
					<c:forEach items="${ques.tags}" var="tag">
					<td>${tag.subject}</td>
					</c:forEach>
				</tr>			
				</c:forEach>
				</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<div>
			<a href="questions/new" class="btn btn-warning">New Questions</a>
		</div>
	</div>
</body>
</html>