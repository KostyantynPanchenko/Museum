<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/exhibits/byMaterial" var="byMaterial" />

<html>
	<jsp:include page="../head.jsp"></jsp:include>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>	

	<!-- Page content -->
	<div class="w3-content" style="max-width: 2000px; margin-top: 46px">		
		<div class="w3-container w3-content w3-center w3-padding-64"
			style="max-width: 800px" >
			<h2 class="w3-wide">Exhibits by material ${material}</h2>			
			
			<c:choose>
				<c:when test="${not empty exhibits}">
				<table class="w3-table w3-striped w3-border w3-bordered w3-hoverable">
					<thead>
					<tr class="w3-light-grey"><th>Author</th><th>Name</th><th>Technique</th><th>Hall</th></tr>
					</thead>
					<c:forEach items="${exhibits}" var="current">
						<tr>
							<td>${current.author.name}</td>
							<td>${current.name}</td>
							<td>${current.technique.description}</td>
							<td>${current.hall}</td>
						</tr>
					</c:forEach>
				</table>
				</c:when>
				<c:otherwise>
					<h2 class="w3-wide">not found!</h2>
					<p>Try another one material:</p>
					
					<form method="post" action="${byMaterial}">
					<p><input type="text" value="" name="material" class="w3-input w3-border" /></p>
					<p><input type="submit" class="w3-btn w3-round w3-teal"/></p>
			</form>	
				</c:otherwise>	
			</c:choose>
					
		</div>
	</div>
		
	<!-- Footer -->
	<footer
		class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge">		
	</footer>

</body>
</html>

