<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
		<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
		<link href="<c:url value="/resources/js/bootstrap.min.css" />" rel="stylesheet">
        <title>Welcome to the Knowledge Package</title>
    </head>
    <body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active">
						<a style="color: #0ab169" class="nav-link" href="${pageContext.request.contextPath}/kpacs"><b>Knowledge Package</b></a>
					</li>
					<li class="nav-item">
						<a style="color: #0ab169" class="nav-link" href="${pageContext.request.contextPath}/sets"><b>Knowledge Package Set</b></a>
					</li>
				</ul>
			</div>
		</nav>
    </body>
</html>
