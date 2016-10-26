<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/guides/available" var="availableGuides"></spring:url>

<html>
	<jsp:include page="../head.jsp"></jsp:include>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>	

	<!-- Page content -->		
	<div class="w3-container w3-content w3-center w3-padding-64 w3-card-8" style="max-width: 800px; margin-top: 100px" >
		<h2 class="w3-wide">Find available guides:</h2>
		<div class="w3-container w3-content w3-center" style="max-width:260px">			
		<form method="POST" action="${availableGuides}">
			<p>From: <input type="datetime-local" name="start" class="w3-input w3-border" /></p>
			<p>To: <input type="datetime-local" name="end" class="w3-input w3-border" /></p>
			<p><input type="submit" class="w3-btn-block w3-blue"/></p>
		</form>
		</div>
	</div>	
		
	<!-- Footer -->
	<footer
		class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge">		
	</footer>

</body>
</html>

