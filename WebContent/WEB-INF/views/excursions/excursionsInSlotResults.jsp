<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/tours" var="tours" />
<spring:url value="/tours/all" var="all" />
<spring:url value="/tours/timeslot" var="slot" />
<spring:url value="/tours/from" var="from" />

<html>
	<jsp:include page="../head.jsp"></jsp:include>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>	

	<!-- Page content -->		
	<div class="w3-container w3-content w3-center w3-padding-64 w3-card-8" style="max-width: 800px; margin-top: 100px; margin-bottom: 100px" >
		<h2 class="w3-wide">Tours in given time slot:</h2>
		<c:choose>
			<c:when test="${not empty excursions}">
			<table class="w3-table w3-striped w3-border w3-bordered w3-hoverable">
				<thead>
				<tr class="w3-light-grey"><th>Name</th><th>Start</th><th>Duration</th><th>Guide</th></tr>
				</thead>
				<jsp:useBean id="myFormatter" class="com.softserve.museum.utils.LocalDateTimeCustomFormatter" scope="page"></jsp:useBean>
				<c:forEach items="${excursions}" var="current">
					<tr>
						<td>${current.details.name}</td>
						<td>${myFormatter.format(current.start)}</td>
						<td>${current.details.duration}</td>
						<td>${current.guide.firstName} ${current.guide.lastName}</td>
					</tr>
				</c:forEach>
			</table>
			</c:when>
			<c:otherwise>
				<h2 class="w3-wide">not found!</h2>				
			</c:otherwise>	
		</c:choose>
			
		<div class="w3-container w3-content w3-center" style="max-width: 200px">
			<h3 class="w3-wide"><spring:message code="menu.tours" /></h3>
			<p><a href="${tours}" class="w3-btn-block w3-black">Available tours</a></p>
			<p><a href="${all}" class="w3-btn-block w3-black">Weekly schedule</a></p>
		</div>
	</div>
		
	<!-- Footer -->
	<footer
		class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge">		
	</footer>

</body>
</html>

