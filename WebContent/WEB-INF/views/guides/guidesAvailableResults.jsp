<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/guides/position" var="position" />
<spring:url value="/guides/available" var="available" />

<html>
	<jsp:include page="../head.jsp"></jsp:include>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>	

	<!-- Page content -->
	<div class="w3-content" style="max-width: 2000px; margin-top: 46px">		
		<div class="w3-container w3-content w3-center w3-padding-64" style="max-width: 800px" >
			<h3 class="w3-wide">Guides available</h3>
			<div class="w3-container w3-content w3-center">
			<h3 class="w3-wide">from ${start}</h3>
			<h3 class="w3-wide">to ${end}</h3>
			</div>		
			
			<c:choose>
				<c:when test="${not empty guides}">
				<table class="w3-table w3-striped w3-border w3-bordered w3-hoverable">
					<thead>
					<tr class="w3-light-grey"><th>Guide</th><th>Position</th></tr>
					</thead>
					<c:forEach items="${guides}" var="current">
						<tr>
							<td>${current.firstName} ${current.lastName}</td>
							<td>${current.position.toString()}</td>
						</tr>
					</c:forEach>
				</table>
				</c:when>
				<c:otherwise>
					<h2 class="w3-wide">not found!</h2>
					<p>Try one more time</p>
				</c:otherwise>	
			</c:choose>
			<div class="w3-container w3-content w3-center w3-row" style="max-width: 260px">
			<p><a href="${position}" class="w3-btn-block w3-black">Find guides by position</a></p>
			<p><a href="${available}" class="w3-btn-block w3-black">Find available guides</a></p>
		</div>
		</div>
	</div>
	<br />
		
	<!-- Footer -->
	<footer
		class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge">		
	</footer>

</body>
</html>

