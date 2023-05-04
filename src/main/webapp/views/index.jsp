<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>insurance form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
			<h3 class="mb-3">Report Application</h3>
	

		<form:form action="search" modelAttribute="request" method="POST">

			<table>

				<tr>
					<td>PlanName</td>
					<td><form:select path="Plan_Name">
							<form:option value="">-Select-</form:option>
							<form:options items="${plannames}" />
						</form:select></td>
					<td>Plan Status</td>
					<td><form:select path="Plan_Status">
							<form:option value="">-Select-</form:option>
							<form:options items="${planstatus}" />
						</form:select></td>

					<td>Gender:</td>
					<td><form:select path="gender">
							<form:option value="">-Select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="FeMale">FeMale</form:option>
						</form:select></td>
				</tr>

				<tr>
					<td>Start Date:</td>
					<td><form:input path="startDate" type="date" /></td>

				
					<td>End Date:</td>
					<td><form:input path="endDate" type="date" /></td>

				</tr>

				<tr>
				<td><a href="/" class="btn btn-secondary">Reset</a>
				
					<td><input type="submit" value="Search"
						class="btn btn-primary" /></td>
				</tr>
			</table>
		</form:form>

		<hr />
		<table border="1" class="table table-striped">
			<thead>
				<tr>
					<th>S.NO</th>
					<th>Customer Name</th>
					<th>Plan Name</th>
					<th>Plan Status</th>
					<th>Gender</th>
					<th>Plan Start Date</th>
					<th>Plan End Date</th>


				</tr>
			</thead>
			<tbody>
				<c:forEach items="${plans}" var="plan" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${plan.CITIZEN_NAME}</td>
						<td>${plan.GENDER}</td>
						<td>${plan.PLAN_NAME}</td>
						<td>${plan.PLAN_STATUS}</td>
						<td>${plan.PLAN_START_DATE}</td>
						<td>${plan.PLAN_END_DATE}</td>
					</tr>

				</c:forEach>
				<tr>
					<c:if test="${empty plans }">
						<td colspan="8" style="text-align: center">No results found</td>

					</c:if>
				</tr>



			</tbody>
		</table>

		<hr />
		Export:<a href="excel">EXCEL</a> <a href="key">PDF</a>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>



</body>
</html>