<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<div class="container">--%>
	<hr>
<%--	<footer class="footer">--%>
		<nav class="navbar-inverse">
			<div class="container">
				<br/>
					<p align="center" style="color: #9d9d9d;size: 40px"> <b> &copy; Sistemi Distribuiti M 2019-2020 </b></p>
				<br/>
			</div>
		</nav>
<%--	</footer>--%>
<%--</div>--%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<spring:url value="/resources/core/js/hello.js" var="coreJs" />
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>


