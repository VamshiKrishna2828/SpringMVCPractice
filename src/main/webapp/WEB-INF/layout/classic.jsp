<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js">
	</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
	<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
	<tilesx:useAttribute name="current"/>
	
	
	<div class="container">

		<!-- Static navbar -->
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href='<spring:url value="hello.htm"></spring:url>'>MyJBA</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<security:authorize access="! isAuthenticated()">
							<li class="${current == login ? "active" : ""}"><a href='<spring:url value="/login.htm"></spring:url>'>Login</a></li>
						</security:authorize>
						<li class="${current == hello ? "active" : ""}"><a href='<spring:url value="hello.htm"></spring:url>'>Home</a></li>
						<security:authorize access="hasRole('ROLE_ADMIN')">
						<li class="${current == users ? "active" : ""}"><a href='<spring:url value="/users.htm"></spring:url>'>Users</a></li>
						</security:authorize>
						<li class="${current == register ? "active" : ""}"><a href='<spring:url value="/register.htm"></spring:url>'>Register</a></li>
						<security:authorize access="isAuthenticated()">
							<li><a href='<spring:url value="/logout"></spring:url>'>Logout</a></li>
						</security:authorize>
						<li><a href="#">Contact</a></li>
						 <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="#">Action</a></li>
                  <li><a href="#">Another action</a></li>
                  <li><a href="#">Something else here</a></li>
                  <li role="separator" class="divider"></li>
                  <li class="dropdown-header">Nav header</li>
                  <li><a href="#">Separated link</a></li>
                  <li><a href="#">One more separated link</a></li>
                </ul>
              </li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</nav>
		<tiles:insertAttribute name="body"></tiles:insertAttribute>

	</div>
</body>

<br>
<br>
<center>
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
</center>

</html>