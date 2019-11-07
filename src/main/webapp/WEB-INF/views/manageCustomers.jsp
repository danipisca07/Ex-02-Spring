<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>

<html>

<jsp:include page="header.jsp" />

<%--		<head>--%>
<%--		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">--%>
<%--		<title>Spring5 MVC Hibernate Demo</title>--%>
<%--		<style type="text/css">--%>
<%--			.error {--%>
<%--				color: red;--%>
<%--			}--%>
<%--			table {--%>
<%--				width: 50%;--%>
<%--				border-collapse: collapse;--%>
<%--				border-spacing: 0px;--%>
<%--			}--%>
<%--			table td {--%>
<%--				border: 1px solid #565454;--%>
<%--				padding: 20px;--%>
<%--			}--%>
<%--		</style>--%>
<%--	</head>--%>
	<body>

		<h1  align="center">CUSTOMER Page</h1>

		<table class="table">

			<tr>

				<td width="5%">

				</td>
				<td class="col">

					<div class="strict-container">
						<p><b>CUSTOMER input Form</b></p>

						<form:form action="addCustomer" method="post" modelAttribute="customer">
							<table class="table">
								<tr>
									<td class="col">Name</td>
									<td class="col">
										<form:input path="name" /> <br />
										<form:errors path="name" cssClass="error" />
									</td>
								</tr>
								<tr>
									<td colspan="2" align="center"><button type="submit">Submit</button></td>
								</tr>
							</table>
						</form:form>

					</div>

				</td>

				<td class="col">

					<p><b>Customer List</b></p>

					<div class="container">

						<c:if test="${not empty customermsg}">
							<div class="alert alert-${css} alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<strong>${customermsg}</strong>
							</div>
						</c:if>

						<table class="table table-striped">
							<thead>
							<tr>
								<th>Name</th>
							</tr>
							</thead>

							<c:forEach var="customer" items="${customers}">
								<tr>
									<td>${customer.name}</td>
									<td>
										<spring:url value="/customers/${customer.id}" var="customerUrl" />
										<spring:url value="/customers/${customer.id}/delete" var="customerDeleteUrl" />
										<spring:url value="/customers/${customer.id}/update" var="customerUpdateUrl" />

										<button class="btn btn-info" onclick="location.href='${customerUrl}'">Query</button>
										<button class="btn btn-primary" onclick="location.href='${customerUpdateUrl}'">Update</button>
										<button class="btn btn-danger" onclick="this.disabled=true;location.href='${customerDeleteUrl}'">Delete</button></td>
								</tr>
							</c:forEach>
						</table>

					</div>

				</td>

			</tr>

		</table>

		<jsp:include page="footer.jsp" />

	</body>
</html>