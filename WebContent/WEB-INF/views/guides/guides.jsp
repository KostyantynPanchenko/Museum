<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/guides/position" var="position" />
<spring:url value="/guides/available" var="available" />
<spring:url value="/guides/statistics" var="statistics" />

<html>
	<jsp:include page="../head.jsp"></jsp:include>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>	

	<!-- Page content -->		
	<div class="w3-container w3-content w3-center w3-padding-64 w3-card-8" style="max-width: 800px; margin-top: 100px; margin-bottom: 100px" >
		<h2 class="w3-wide"><spring:message code="menu.guides" /></h2>
		<c:if test="${not empty guides}">
			<table class="w3-table w3-striped w3-border w3-bordered w3-hoverable">
				<thead>
				<tr class="w3-light-grey"><th>Name</th><th>Position</th></tr>
				</thead>
				<c:forEach items="${guides}" var="current">
					<tr>
						<td>${current.firstName} ${current.lastName}</td>
						<td>${current.position.toString()}</td>							
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<br/><br/>
		<div class="w3-container w3-content w3-center w3-padding-32" style="max-width: 280px">
			<p><a href="${position}" class="w3-btn-block w3-black">Find guides by position</a></p>
			<p><a href="${available}" class="w3-btn-block w3-black">Find available guides</a></p>
			<p><a href="${statistics}" class="w3-btn-block w3-black">Statistics per guide</a></p>
		</div>				
	</div>	
		
	<!-- Footer -->
	<footer
		class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge">		
	</footer>

</body>
</html>

