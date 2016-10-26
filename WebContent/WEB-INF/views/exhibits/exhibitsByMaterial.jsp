<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/exhibits/material" var="byMaterial" />

<html>
	<jsp:include page="../head.jsp"></jsp:include>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>	

	<!-- Page content -->
	<div class="w3-content" style="max-width: 2000px; margin-top: 46px">		
		<div class="w3-container w3-content w3-center w3-padding-64"
			style="max-width: 800px" >
			<h2 class="w3-wide">Enter material:</h2>
			<div class="w3-container w3-content w3-center" style="max-width: 120px">
			<form method="post" action="${byMaterial}">
				<c:forEach items="${materials}" var="current">
				<p><input	class="w3-check w3-left" 
							type="checkbox" 
							name="chosenMaterials" 
							value="${current.description}">
				<label class="w3-validate">${current.description}</label>		
				</c:forEach>
				<p><input type="submit" class="w3-btn w3-blue"/></p>
			</form>			
			</div>
		</div>
	</div>
		
	<!-- Footer -->
	<footer
		class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge">		
	</footer>

</body>
</html>

