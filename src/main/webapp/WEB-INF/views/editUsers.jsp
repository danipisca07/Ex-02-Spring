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

		<h1>USER Section</h1>

		<table class="table">

			<tr>

				<td width="5%">

				</td>
				<td class="col">

					<div class="strict-container">
						<p><b>USER Input Form</b></p>
						<form:form action="addUser" method="post" modelAttribute="user">
							<table class="table">
								<tr>
									<td class="col">Name</td>
									<td class="col">
										<form:input path="name" /> <br />
										<form:errors path="name" cssClass="error" />
									</td>
								</tr>
								<tr>
									<td>Email</td>
									<td>
										<form:input path="email" /> <br />
										<form:errors path="email" cssClass="error" />
									</td>
								</tr>
								<tr>
									<td colspan="2"><button type="submit" style="align-items: center">Submit</button></td>
								</tr>
							</table>
						</form:form>
					</div>


				</td>


				<td class="col">

					<div class="container">

						<c:if test="${not empty usermsg}">
							<div class="alert alert-${css} alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<strong>${usermsg}</strong>
							</div>
						</c:if>

						<p><b>All Users</b></p>

						<%--			<button class="btn btn-info" onclick="location.href='refreshUsers'">Refresh List</button>--%>

						<table class="table table-striped">
							<thead>
							<tr>
								<th>Name</th>
								<th>Email</th>
							</tr>
							</thead>

							<c:forEach var="user" items="${users}">
								<tr>
									<td>${user.name}</td>
									<td>${user.email}</td>
									<td>
										<spring:url value="/users/${user.id}" var="userUrl" />
										<spring:url value="/users/${user.id}/delete" var="deleteUrl" />
										<spring:url value="/users/${user.id}/update" var="updateUrl" />

										<button class="btn btn-info" onclick="location.href='${userUrl}'">Query</button>
										<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
										<button class="btn btn-danger" onclick="this.disabled=true;location.href='${deleteUrl}'">Delete</button></td>
								</tr>
							</c:forEach>
						</table>

					</div>

				</td>

			</tr>

		</table>

		<hr> <!-- ------------------------------------------------------------------------------------------------ -->
		<hr> <!-- ------------------------------------------------------------------------------------------------ -->

		<h1>CUSTOMER Section</h1>

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
									<td colspan="2"><button type="submit">Submit</button></td>
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

		<hr> <!-- ------------------------------------------------------------------------------------------------ -->
		<hr> <!-- ------------------------------------------------------------------------------------------------ -->

		<h1>PRODUCER Section</h1>

		<table class="table">

			<tr>

				<td width="5%">

				</td>
				<td class="col">

					<div class="strict-container">
						<p><b>PRODUCER Input Form</b></p>

						<form:form action="addProducer" method="post" modelAttribute="producer">
							<table class="table">
								<tr>
									<td class="col">Name</td>
									<td class="col">
										<form:input path="name" /> <br />
										<form:errors path="name" cssClass="error" />
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

					<p><b>Producers List</b></p>

					<div class="container">

						<c:if test="${not empty producermsg}">
							<div class="alert alert-${css} alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<strong>${producermsg}</strong>
							</div>
						</c:if>

						<table class="table table-striped">
							<thead>
							<tr>
								<th>Name</th>
							</tr>
							</thead>

							<c:forEach var="producer" items="${producers}">
								<tr>
									<td>${producer.name}</td>
									<td>
										<spring:url value="/producers/${producer.id}" var="useUrl" />
										<spring:url value="/producers/${producer.id}/delete" var="deleteUrl" />
										<spring:url value="/producers/${producer.id}/update" var="updateUrl" />

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

		<hr> <!-- ------------------------------------------------------------------------------------------------ -->
		<hr> <!-- ------------------------------------------------------------------------------------------------ -->

		<h1>PRODUCTS Section</h1>

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

<%--		<hr> <!-- ------------------------------------------------------------------------------------------------ -->--%>
<%--		<hr> <!-- ------------------------------------------------------------------------------------------------ -->--%>

<%--		<h1>PURCHASE Section</h1>--%>

<%--		<table class="table">--%>

<%--			<tr>--%>

<%--				<td width="5%">--%>

<%--				</td>--%>
<%--				<td class="col">--%>

<%--					<div class="strict-container">--%>
<%--						<p><b>PURCHASE Input Form</b></p>--%>

<%--						<form:form action="addPurchase" method="post" modelAttribute="purchase">--%>
<%--							<table>--%>
<%--								<tr>--%>
<%--									<td>Purchase Number</td>--%>
<%--									<td>--%>
<%--										<form:input path="purchaseNumber" /> <br />--%>
<%--										<form:errors path="purchaseNumber" cssClass="error" />--%>
<%--									</td>--%>
<%--								</tr>--%>
<%--									<td colspan="2"><button type="submit">Submit</button></td>--%>
<%--								</tr>--%>
<%--							</table>--%>
<%--						</form:form>--%>

<%--					</div>--%>

<%--				</td>--%>

<%--				<td class="col">--%>

<%--					<p><b>Purchases List</b></p>--%>

<%--					<div class="container">--%>

<%--						<c:if test="${not empty purchasemsg}">--%>
<%--							<div class="alert alert-${css} alert-dismissible" role="alert">--%>
<%--								<button type="button" class="close" data-dismiss="alert" aria-label="Close">--%>
<%--									<span aria-hidden="true">&times;</span>--%>
<%--								</button>--%>
<%--								<strong>${purchasemsg}</strong>--%>
<%--							</div>--%>
<%--						</c:if>--%>

<%--						<table class="table table-striped">--%>
<%--							<thead>--%>
<%--							<tr>--%>
<%--								<th>Purchase Number</th>--%>
<%--							</tr>--%>
<%--							</thead>--%>

<%--							<c:forEach var="purchse" items="${purchases}">--%>
<%--								<tr>--%>
<%--									<td>${purchse.name}</td>--%>
<%--									<td>--%>
<%--										<spring:url value="/purchses/${purchse.id}" var="useUrl" />--%>
<%--										<spring:url value="/purchses/${purchse.id}/delete" var="deleteUrl" />--%>
<%--										<spring:url value="/purchses/${purchse.id}/update" var="updateUrl" />--%>

<%--										<button class="btn btn-info" onclick="location.href='${useUrl}'">Query</button>--%>
<%--										<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>--%>
<%--										<button class="btn btn-danger" onclick="this.disabled=true;location.href='${deleteUrl}'">Delete</button></td>--%>
<%--								</tr>--%>
<%--							</c:forEach>--%>
<%--						</table>--%>

<%--					</div>--%>

<%--				</td>--%>

<%--			</tr>--%>

<%--		</table>--%>

		<jsp:include page="footer.jsp" />

	</body>
</html>