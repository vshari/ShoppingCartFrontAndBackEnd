<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Category Page</title>

</head>

<body>

	<h2>
		<center>Manage Category</center>
	</h2>

	<hr>
	<!-- march 10th /manage_category_create -->
	<form action="manage_category_create" method="post">

		<input type="text" name="id"> 
		<input type="text" name="name">
		<input type="text" name="description"> 
		<input type="submit" value="Create">

	</form>

	<!--${categoryList}  -->

	<table border="2">

		<thead>

			<tr>

				<td>Id</td>

				<td>Name</td>

				<td>Description</td>

				<td>Action</td>

			</tr>

		</thead>

		<c:forEach var="category" items="${categoryList}">

			<tr>

				<td>${category.id}</td>

				<td>${category.name}</td>

				<td>${category.description}</td>

				<td><a href="manage_category_edit"> Edit</a> | <a
					href="manage_category_delete/01"> Delete</a></td>

			</tr>

		</c:forEach>

	</table>

	<br>

	<br>

</body>

</html>