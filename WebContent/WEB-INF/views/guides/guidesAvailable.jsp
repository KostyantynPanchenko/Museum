<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/resources/images/cover.jpg" var="coverPhoto" />
<spring:url value="/resources/images/avatar.png" var="avatar" />

<html>
	<jsp:include page="../head.jsp"></jsp:include>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>	

	<!-- Page content -->
	<div class="w3-content" style="max-width: 2000px; margin-top: 46px">		
		<div class="w3-container w3-content w3-center w3-padding-64"
			style="max-width: 800px" >
			<h2 class="w3-wide">Find available guides by specified time:</h2>
			<spring:url value="/guides/available" var="availableGuides"></spring:url>
			<form method="POST" action="${availableGuides}">
				<input type="datetime-local" name="start" />
				<input type="submit" />
			</form>
		</div>
	</div>		
		
	<!-- Footer -->
	<footer
		class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge">		
	</footer>

</body>
</html>

