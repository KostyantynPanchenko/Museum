<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/resources/css/w3.css" var="w3css" />
<spring:url value="/resources/images/cover.jpg" var="coverPhoto" />
<spring:url value="/resources/images/avatar.png" var="avatar" />

<html>
<title>zMuseum</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<link rel="stylesheet" href="${w3css}">

<body>

	<!-- Navbar -->
	<div class="w3-top">
		<ul class="w3-navbar w3-black w3-card-2 w3-left-align">			
			<li><a href="#"
				class="w3-hover-none w3-hover-text-grey w3-padding-large">HOME</a></li>
			<li><a href="#museum" class="w3-padding-large">MUSEUM</a></li>
			<li><a href="#tour"	class="w3-padding-large">TOURS</a></li>
			<li><a href="#contact" class=" w3-padding-large">CONTACTS</a></li>
			<li class="w3-dropdown-hover">
				<a href="javascript:void(0)" class="w3-hover-none w3-padding-large"
				title="More">MORE <i class="fa fa-caret-down"></i></a>
				<div class="w3-dropdown-content w3-white w3-card-4">
					<a href="#">Our guides</a> <a href="#">Exhibits</a>
				</div></li>
			<li class="w3-right"><a href="javascript:void(0)"
				class="w3-padding-large w3-hover-red"><i class="fa fa-search"></i></a></li>
		</ul>
	</div>

	<!-- Page content -->
	<div class="w3-content" style="max-width: 2000px; margin-top: 46px">

		<!-- Automatic Slideshow Images -->
		<div class="mySlides w3-display-container w3-center">
			<img src="${coverPhoto}" style="width: 100%">			
		</div>
		
		<!-- The Band Section -->
		<div class="w3-container w3-content w3-center w3-padding-64"
			style="max-width: 800px" id="band">
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

		<!-- The Tour Section -->
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

		<!-- The Contact Section -->
		<div class="w3-container w3-content w3-padding-64"
			style="max-width: 800px" id="contact">
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
	<!-- script src="https://maps.googleapis.com/maps/api/js"></script-->
	<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC1reMf-jjgha7NXk5QaWzl2wxGkhyLfug&callback=initMap" type="text/javascript"></script>
	
	<script>
		var myCenter = new google.maps.LatLng(49.832751, 23.997182);		

		function initialize() {
			var mapProp = {
				center : myCenter,
				zoom : 14,
				scrollwheel : false,
				draggable : false,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			};

			var map = new google.maps.Map(document.getElementById("googleMap"),
					mapProp);

			var marker = new google.maps.Marker({
				position : myCenter,
			});

			marker.setMap(map);
		}

		google.maps.event.addDomListener(window, 'load', initialize);
	</script>

	<!-- Footer -->
	<footer
		class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge">		
	</footer>

</body>
</html>

