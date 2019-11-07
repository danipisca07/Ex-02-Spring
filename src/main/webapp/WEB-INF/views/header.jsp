<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>Spring MVC Form Handling Example</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/resources/core/images/delete.png" var="delete" />


<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/manageCustomers" var="managerCustomers" />
<spring:url value="/manageProducers" var="manageProducers" />
<spring:url value="/manageProducts" var="manageProducts" />
<spring:url value="/managePurchases" var="managePurchases" />
<spring:url value="/" var="editUsers" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<ul class="nav navbar-nav navbar-brand">
				<li class="navbar-brand"><a class="navbar-brand" href="${urlHome}">Spring MVC</a></li>
			</ul>
		</div>
	</div>

	<div class="container">

		<div class="navbar-right">
            <ul class="nav navbar-nav navbar-right">
				<li class="navbar-brand"><a href="${managerCustomers}">manageCustomers</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="navbar-brand"><a href="${manageProducers}">manageProducers</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="navbar-brand"><a href="${manageProducts}">manageProducts</a></li>
			</ul>
<%--			<ul class="nav navbar-nav navbar-right">--%>
<%--				<li class="active"><a href="${managePurchases}">managePurchases</a></li>--%>
<%--			</ul>--%>
			<ul class="nav navbar-nav navbar-right">
				<li class="navbar-brand"><a href="${editUsers}">editUsers</a></li>
			</ul>
		</div>

	</div>
	<br/>
	<br/>
</nav>

<hr>