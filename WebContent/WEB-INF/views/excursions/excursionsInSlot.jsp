<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/tours/all" var="all" />
<spring:url value="/tours/timeslot" var="slot" />
<spring:url value="/tours" var="tours" />

<html>
	<jsp:include page="../head.jsp"></jsp:include>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>	

	<!-- Page content -->		
	<div class="w3-container w3-content w3-center w3-padding-64 w3-card-8" style="max-width: 800px; margin-top: 100px; margin-bottom: 100px" >
		<h2 class="w3-wide">Find available tours:</h2>
		<div class="w3-container w3-content w3-center" style="max-width:260px">			
			<form method="POST" action="${slot}">
				<p>From: <input type="datetime-local" name="start" class="w3-input w3-border" /></p>
				<p>To: <input type="datetime-local" name="end" class="w3-input w3-border" /></p>
				<p><input type="submit" class="w3-btn-block w3-blue"/></p>
			</form>
		</div>			
		<div>
			<h3 class="w3-wide"><spring:message code="menu.tours" /></h3>
			<div class="w3-container w3-content w3-center" style="max-width: 200px">
				<p><a href="${tours}" class="w3-btn-block w3-black">Available tours</a></p>
				<p><a href="${all}" class="w3-btn-block w3-black">Weekly schedule</a></p>
			</div>			
		</div>
	</div>
		
	<!-- Footer -->
	<footer
		class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge">		
	</footer>

</body>
</html>

