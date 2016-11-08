<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/resources/css/w3.css" var="css" />
<spring:url value="/resources/css/custom.css" var="customCss" />

<head>
	<title>zMuseum</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css"-->
	<link rel="stylesheet" href="${css}">
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/css?family=Lato">
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
	<style>
		.padding-lang {
			padding: 16px 4px 16px 4 px;			
		}
	</style>
</head>