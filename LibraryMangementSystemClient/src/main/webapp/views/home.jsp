<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Searched Products</title>
<style type="text/css">
.header {
	display: flex;
	margin: 15px;
	justify-content: space-between;
}

table tr {
	margin: 20px;
	padding: 20px;
}

.items-btn, .user-details {
	display: flex;
	justify-content: space-evenly;
}

* {
	margin: 0px;
	padding: 0px;
}

.details {
	margin-left: 10px;
}

.form {
	margin-left: 20px;
}

select {
	margin: 50px
}

.form-input {
	margin: 50px;
}

table, tr, td, th {
	border: 1px solid #000000;
	border-collapse: collapse;
	text-align: center;
}

.container {
	width: 100% !important;
	padding: 0;
}
.actionButton{
display: inline;
}
</style>
</head>
<body>

	<div class="header">
		<div></div>
		<form class="user-details" action="/">
			<p class="fs-5 fw-bold" style="margin-right: 10px; margin-top: 5px;">Welcome
				${username}</p>
			<button class="btn btn-outline-primary mx-3 px-3" type="submit">Logout</button>
		</form>
	</div>
	<div class="header">
		<div></div>
		<h4 class="fs-2">Book Listing</h4>
		<form action="showBooks" method="post">

			<button class="btn btn-primary" type="submit">Add a Book</button>
		</form>
	</div>
	<div class="container-fluid ">

		<table class="table table-hover mt-3">
			<tr>
				<th>Book Code</th>
				<th>Book Name</th>
				<th>Author</th>
				<th>Date Added</th>
				<th>Actions</th>
			</tr>

			<c:forEach var="book" items="${books}">
				<tr>
					<td>${book.bookId}</td>
					<td>${book.bookName}</td>
					<td>${book.author.authorName}</td>
					<td>${book.bookAddedDate}</td>
					<td>
					<form action="editBook" class="actionButton">
						<button type="submit" name='edit' value='${book.bookId}' class="btn btn-outline-secondary mx-3" >Edit</button>
						</form>
						<form action="deleteBook" class="actionButton">
						<button type="submit" name='delete' value='${book.bookId}' class="btn btn-outline-danger mx-3" >Delete</button>
						</form>
					</td>
				</tr>

			</c:forEach>

		</table>
	</div>

</body>
</html>