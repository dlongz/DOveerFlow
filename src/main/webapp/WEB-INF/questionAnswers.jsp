<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Question Profile</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	
</head>
<body>
	<div class="container-sm">
		<nav>
			<a href="/questions" class="btn btn-primary mb-3">Home</a>
		</nav>
		<h1>${ques.question}</h1>
		<h2>Tags: <c:forEach items="${ques.tags}" var="tag"><span>${tag.subject} </span></c:forEach></h2>
		<div class="answer_table">
			<table>
				<thead>				
					<tr>
						<th>Answers</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ques.answers}" var="ans">
						<tr>
							<td>${ans.answerText}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="answerForm">
			<h2>Add your answer:</h2>
			<form:form action="/questions/${ques.id}" method="post" modelAttribute="answerForm">
				<div>
					<form:label path="answerText" >Answer:</form:label>
					<form:textarea path="answerText" />
				</div>
<%-- 				<form:hidden path="question" value="${ques.id}"/> --%>
				<input type="submit" value="Answer It!" class="btn btn-success"/>
			</form:form>
		</div>
	</div>
</body>
</html>