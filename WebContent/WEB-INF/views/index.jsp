<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/resources/images/cover.jpg" var="coverPhoto" />
<spring:url value="/resources/images/avatar.png" var="avatar" />

<html>
	<jsp:include page="head.jsp"></jsp:include>
<body>
	<jsp:include page="menu.jsp"></jsp:include>	

	<!-- Page content -->
	<div class="w3-content" style="max-width: 2000px; margin-top: 46px">
		
		<div class="mySlides w3-display-container w3-center">
			<img src="${coverPhoto}" style="width: 100%">			
		</div>
		
		<!-- The Museum Section -->
		<div class="w3-container w3-content w3-center w3-padding-64" style="max-width: 800px" id="museum">
			<h2 class="w3-wide">THE MUSEUM</h2>
			<p class="w3-opacity">
				<i>We love programming</i>
			</p>
			<p class="w3-justify">We have created a fictional museum website.
				Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
				eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim
				ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
				aliquip ex ea commodo consequat. Duis aute irure dolor in
				reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
				pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
				culpa qui officia deserunt mollit anim id est laborum consectetur
				adipiscing elit, sed do eiusmod tempor incididunt ut labore et
				dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
				exercitation ullamco laboris nisi ut aliquip ex ea commodo
				consequat.</p>
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

		<!-- The Tours Section -->
		<div class="w3-black" id="tour">
			<div class="w3-container w3-content w3-padding-64"
				style="max-width: 800px">
				<h2 class="w3-wide w3-center">MUSEUM OPERATION DATES</h2>
				<p class="w3-opacity w3-center">
					<i>Remember to book your tickets!</i>
				</p>
				<br>

				<ul class="w3-ul w3-border w3-white w3-text-grey">
					<li class="w3-padding">October <span
						class="w3-tag w3-red w3-margin-left">Sold out</span></li>
					<li class="w3-padding">November <span
						class="w3-tag w3-red w3-margin-left">Sold out</span></li>
					<li class="w3-padding">December <span
						class="w3-badge w3-right w3-margin-right">3</span></li>
				</ul>
				
			</div>
		</div>

		<!-- The Contacts Section -->
		<div class="w3-container w3-content w3-padding-64"
			style="max-width: 800px" id="contacts">
			<h2 class="w3-wide w3-center">CONTACTS</h2>
			<p class="w3-opacity w3-center">
				<i>Interested? Drop a note!</i>
			</p>
			<div class="w3-row w3-padding-32">
				<div class="w3-col m6 w3-large w3-margin-bottom">
					<i class="fa fa-map-marker" style="width: 30px"></i> Lviv, UA<br>
					<i class="fa fa-phone" style="width: 30px"></i> Phone: 0 800 60 3000<br>
					<i class="fa fa-envelope" style="width: 30px"> </i> Email:
					info@softserveinc.com<br>
				</div>
				<div class="w3-col m6">
					<div class="w3-row-padding" style="margin: 0 -16px 8px -16px">
						<div class="w3-half">
							<input class="w3-input w3-border" type="text" placeholder="Name">
						</div>
						<div class="w3-half">
							<input class="w3-input w3-border" type="text" placeholder="Email">
						</div>
					</div>
					<input class="w3-input w3-border" type="text" placeholder="Comment">
					<button class="w3-btn w3-section w3-right">SEND</button>
				</div>
			</div>
		</div>

		<!-- End Page Content -->
	</div>

	<!-- Add Google Maps -->
	<div id="googleMap"
		style="height: 400px; filter: grayscale(50%); -webkit-filter: grayscale(50%);"></div>
	
	<script>
      function initMap() {
        var uluru = {lat: 49.832751, lng: 23.997182};
        var map = new google.maps.Map(document.getElementById('googleMap'), {
          zoom: 14,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
          map: map
        });
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC1reMf-jjgha7NXk5QaWzl2wxGkhyLfug&callback=initMap">
    </script>
    
	<!-- Footer -->
	<footer
		class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge">		
	</footer>

</body>
</html>

