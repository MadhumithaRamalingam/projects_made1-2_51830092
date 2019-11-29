<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Details Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

	welcome ${user.name }
	<br />
	<a href="logout">logout</a>
	<br />
	<br />
	<br />
	
	<div class="container">
		<div class="row">
			<div class="col-sm-6">

				<table class="table table-striped">

					<thead>
						<tr>
							<th>cust_id</th>
							<th>name</th>
							<th>DOB</th>
							<th>address</th>
							<th>email</th>
							<th>phone_no</th>
							<th>salary</th>
							<th>delete</th>
							<th>update</th>
						</tr>
					</thead>


					<tbody>
						<c:forEach items="${customers}" var="customer">
							<tr>
								<td>${customer.cust_id}</td>
								<td>${customer.name}</td>
								<td><fmt:formatDate value="${customer.DOB}"
										pattern="dd/MM/yyyy" /></td>
								<td>${customer.address}</td>
								<td>${customer.email}</td>
								<td>${customer.phone_no}</td>
								<td>${customer.salary}</td>
								<c:if test="${user.profile == 'admin'}">
									<td><a href="delete?id=${customer.cust_id}">delete</a></td>
									<td><a href="update?id=${customer.cust_id}">update</a></td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<c:if test="${user.profile == 'admin' || user.profile == 'mgr'}">
		<a href="addcustomer">addcustomer</a>
	</c:if>


</body>
</html>