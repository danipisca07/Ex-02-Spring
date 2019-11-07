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

		<h1  align="center">PURCHASE Page</h1>

		<table class="table">

			<tr>

				<td width="5%">

				</td>
				<td class="col">

					<div class="strict-container">
						<p><b>PURCHASE Input Form</b></p>

						<form:form action="addPurchase" method="post" modelAttribute="purchase">
							<table>
								<tr>
									<td>Purchase Number</td>
									<td>
										<form:input path="purchaseNumber" /> <br />
										<form:errors path="purchaseNumber" cssClass="error" />
									</td>
								</tr>
									<td colspan="2"><button type="submit">Submit</button></td>
								</tr>
							</table>
						</form:form>

					</div>

				</td>

				<td class="col">

					<p><b>Purchases List</b></p>

					<div class="container">

						<c:if test="${not empty purchasemsg}">
							<div class="alert alert-${css} alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<strong>${purchasemsg}</strong>
							</div>
						</c:if>

						<table class="table table-striped">
							<thead>
							<tr>
								<th>Purchase Number</th>
							</tr>
							</thead>

							<c:forEach var="purchse" items="${purchases}">
								<tr>
									<td>${purchse.name}</td>
									<td>
										<spring:url value="/purchses/${purchse.id}" var="useUrl" />
										<spring:url value="/purchses/${purchse.id}/delete" var="deleteUrl" />
										<spring:url value="/purchses/${purchse.id}/update" var="updateUrl" />

										<button class="btn btn-info" onclick="location.href='${useUrl}'">Query</button>
										<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
										<button class="btn btn-danger" onclick="this.disabled=true;location.href='${deleteUrl}'">Delete</button></td>
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