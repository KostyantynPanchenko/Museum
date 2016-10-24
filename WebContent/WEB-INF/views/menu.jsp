<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/#" var="home" />
<spring:url value="/#museum" var="museum" />
<spring:url value="/tours" var="tours" />
<spring:url value="/#contacts" var="contacts" />
<spring:url value="/guides" var="guides" />
<spring:url value="/exhibits" var="exhibits" />
<spring:url value="/resources/images/GB.ico" var="GB" />
<spring:url value="/resources/images/UA.ico" var="UA" />
<spring:url value="?lang=en" var="en"/>
<spring:url value="?lang=uk" var="uk"/>	
	

<!-- Navbar -->
<div class="w3-top">
	<ul class="w3-navbar w3-black w3-card-2 w3-left-align">
		<li><a href="${home}" class="w3-hover-none w3-hover-text-grey w3-padding-large">
			<i class="fa fa-home w3-large"></i></a></li>
		<li><a href="${museum}" class="w3-padding-large">
			<spring:message code="menu.museum"/></a></li>		
		<li><a href="${contacts}" class="w3-padding-large">
			<spring:message code="menu.contacts"/></a></li>
		
		<li class="w3-dropdown-hover"><a href="javascript:void(0)"
			class="w3-hover-none w3-padding-large" title="More">
			<spring:message code="menu.more"/> 
			<i class="fa fa-caret-down"></i></a>
			<div class="w3-dropdown-content w3-white w3-card-4">
				<a href="${guides}"><spring:message code="menu.guides"/> </a> 
				<a href="${exhibits}"><spring:message code="menu.exhibits"/> </a>
				<a href="${tours}"><spring:message code="menu.tours"/> </a>
			</div></li>		
		
		<!--li class="w3-right w3-hover-none"><a href="" class="w3-padding-large w3-hover-none"><img src="${GB}" width="24px" /></a></li>
		<li class="w3-right w3-hover-none"><a href="" class="w3-padding-large w3-hover-none"><img src="${UA}" width="24px" /></a></li-->
		
						
		<li class="w3-right w3-hover-none"><a href="${uk}" class="w3-padding-large">
			<span class="w3-text-blue">U</span><span class="w3-text-yellow">K</span>
		</a></li>						
		<li class="w3-right w3-hover-none"><a href="${en}" class="w3-padding-large">
			<span class="w3-text-red">G</span><span class="w3-text-blue">B</span>
		</a></li>
	</ul>
</div>