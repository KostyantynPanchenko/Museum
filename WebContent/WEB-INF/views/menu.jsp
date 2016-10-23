<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/#" var="home" />
<spring:url value="/#museum" var="museum" />
<spring:url value="/tours" var="tours" />
<spring:url value="/#contacts" var="contacts" />
<spring:url value="/guides" var="guides" />
<spring:url value="/exhibits" var="exhibits" />

<!-- Navbar -->
<div class="w3-top">
	<ul class="w3-navbar w3-black w3-card-2 w3-left-align">
		<li><a href="${home}" class="w3-hover-none w3-hover-text-grey w3-padding-large">HOME</a></li>
		<li><a href="${museum}" class="w3-padding-large">MUSEUM</a></li>
		<li><a href="${tours}" class="w3-padding-large">TOURS</a></li>
		<li><a href="${contacts}" class=" w3-padding-large">CONTACTS</a></li>
		<li class="w3-dropdown-hover"><a href="javascript:void(0)"
			class="w3-hover-none w3-padding-large" title="More">MORE <i
				class="fa fa-caret-down"></i></a>
			<div class="w3-dropdown-content w3-white w3-card-4">
				<a href="${guides}">Our guides</a> <a href="${exhibits}">Exhibits</a>
			</div></li>
		<li class="w3-right"><a href="javascript:void(0)"
			class="w3-padding-large w3-hover-red"><i class="fa fa-search"></i></a></li>
	</ul>
</div>