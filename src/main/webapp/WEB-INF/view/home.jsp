<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Title page</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css" />

</head>
<body>
	<div id="container">
		<div id="main">
			<div id="header">
			
				<div id="title">
					<h2>Система управления студентами и их успеваемостью</h2>
				</div>
				
				<div id="logout">
					<c:url var="logoutUrl" value="/logout" />
					<form class="form-inline" action="${logoutUrl}" method="post">
						<input type="submit" value="Logout" /> <input type="hidden"
							name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
				</div>
				
			</div>
			
			<div id="m1">
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/sistem/list.html">Студенты</a></li>
					<li><a
						href="${pageContext.request.contextPath}/disciplines/list.html">Дисциплины</a></li>
					<li><a href="${pageContext.request.contextPath}/termview">Семестры</a></li>
				</ul>
			</div>

		</div>
		<div id="footer"></div>
	</div>
</body>
</html>