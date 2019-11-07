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

		<h1  align="center">PRODUCTS Page</h1>

		<table class="table">

			<tr>

				<td width="5%">

				</td>
				<td class="col">

					<div class="strict-container">
						<p><b>PRODUCTS Input Form</b></p>

						<form:form action="addProduct" method="post" modelAttribute="product">
							<table class="table">
								<tr>
									<td class="col">Name</td>
									<td class="col">
										<form:input path="name" /> <br />
										<form:errors path="name" cssClass="error" />
									</td>
								</tr>
								<tr>
									<td>Product Number</td>
									<td>
										<form:input path="productNumber" /> <br />
										<form:errors path="productNumber" cssClass="error" />
									</td>
								</tr>
								<tr>
									<td>Price</td>
									<td>
										<form:input path="price" /> <br />
										<form:errors path="price" cssClass="error" />
									</td>
								</tr>
								<tr>
									<td colspan="2"><button type="submit">Submit</button></td>
								</tr>
							</table>
						</form:form>

					</div>

				</td>

				<td class="col">

					<p><b>Product List</b></p>

					<div class="container">

						<c:if test="${not empty productmsg}">
							<div class="alert alert-${css} alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<strong>${productmsg}</strong>
							</div>
						</c:if>

						<table class="table table-striped">
							<thead>
							<tr>
								<th>Name</th>
								<th>Product Number</th>
								<th>Price</th>
							</tr>
							</thead>

							<c:forEach var="product" items="${products}">
								<tr>
									<td>${product.name}</td>
									<td>${product.productNumber}</td>
									<td>${product.price}</td>
									<td>
										<spring:url value="/products/${product.id}" var="useUrl" />
										<spring:url value="/products/${product.id}/delete" var="deleteUrl" />
										<spring:url value="/products/${product.id}/update" var="updateUrl" />

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