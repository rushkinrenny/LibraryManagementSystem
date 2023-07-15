<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<style type="text/css">
.header {
	display: flex;
	margin: 15px;
	justify-content: space-between;
}

.user-details {
	display: flex;
	justify-content: space-evenly;
}

.actionButton {
	display: inline;
}
</style>
<title>Edit Book Details</title>
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
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-12  col-md-6">
				<form class="form" action="updateBook" method="post">
					<div class="form-group">
						<div class="row">
							<div class="col-6">
								<label class="fs-4" for="bookCode">Book Code</label>
							</div>
							<div class="col-6">
								${book.bookId}
								<input type='hidden' name='bookCode' value='${book.bookId}'/>
							</div>
						</div>
					</div>

					<div class="form-group mt-3">
						<div class="row">
							<div class="col-6">
								<label class="fs-4" for="bookName">Book Name</label>
							</div>
							<div class="col-6">
								<input type="text" id="bookName" name="bookName" value="${book.bookName}"
									class="form-control" required />
							</div>
						</div>
					</div>

					<div class="form-group mt-3">
						<div class="row">
							<div class="col-6">
								<label class="fs-4" for="author">Author</label>
							</div>
							<div class="col-6">
								<select name="author" id="author"
									class="form-control form-select" required>
									<option value="">None</option>
									<c:forEach var="author" items="${authors}">
										<option value="${author.authorId}">${author.authorName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>

					<div class="form-group mt-3">
						<div class="row">
							<div class="col-6">
								<label class="fs-4" for="bookAddedDate">Added On</label>
							</div>
							<div class="col-6" id="bookAddedDate">
								<%
								DateFormat Date = DateFormat.getDateInstance();
								Calendar cals = Calendar.getInstance();
								String currentDate = Date.format(cals.getTime());

								out.println(currentDate);
								%>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-6"></div>
						<div class="col-6 mt-3">
							<button id="submit" class="btn btn-primary btn-md" type="submit">
								Submit</button>
							<button class="btn btn-danger btn-md" type="reset" id="reset">
								Clear</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>