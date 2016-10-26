<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/tours/all" var="all" />
<spring:url value="/tours/timeslot" var="slot" />
<spring:url value="/tours/from" var="from" />

<html>
	<jsp:include page="../head.jsp"></jsp:include>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>	

	<!-- Page content -->		
	<div class="w3-container w3-content w3-center w3-padding-64 w3-card-8" style="max-width: 800px; margin-top: 100px; margin-bottom: 100px" >
		<h2 class="w3-wide"><spring:message code="menu.tours" /></h2>
		<c:if test="${not empty excursions}">
			<table class="w3-table w3-striped w3-border w3-bordered w3-hoverable">
				<thead>
				<tr class="w3-light-grey"><th>Name</th><th>Duration</th></tr>
				</thead>					
				<c:forEach items="${excursions}" var="current">
					<tr>
						<td>${current.name}</td>
						<td>${current.duration}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<br/>
		<div class="w3-container w3-content w3-center w3-padding-32" style="max-width: 200px">
			<p><a href="${all}" class="w3-btn-block w3-black">Weekly schedule</a></p>
			<p><a href="${slot}" class="w3-btn-block w3-black">From .. to ..</a></p>
		</div>
	</div>
		
	<!-- Footer -->
	<footer
		class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge">		
	</footer>

</body>
</html>

