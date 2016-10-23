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
		
		<div class="mySlides w3-display-container w3-center">
			<img src="${coverPhoto}" style="width: 100%">			
		</div>
		
		<!-- The Museum Section -->
		<div class="w3-container w3-content w3-center w3-padding-64"
			style="max-width: 800px" id="band">
			<h2 class="w3-wide">THE MUSEUM</h2>
			<p class="w3-opacity">
				<i>We love programming</i>
			</p>
			<p class="w3-justify">OUR EXHIBITS</p>
			<div class="w3-row w3-padding-32">
				<div class="w3-half">
					<p>Kostyantyn Panchenko</p>
					<img src="${avatar}"
						class="w3-round w3-margin-bottom" alt="Kostyantyn Panchenko"
						style="width: 60%">
				</div>
				<div class="w3-half">
					<p>Yuri Puschalo</p>
					<img src="${avatar}"
						class="w3-round w3-margin-bottom" alt="Yuri Puschalo"
						style="width: 60%">
				</div>
			</div>
		</div>
	</div>
		
	<!-- Footer -->
	<footer
		class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge">		
	</footer>

</body>
</html>

