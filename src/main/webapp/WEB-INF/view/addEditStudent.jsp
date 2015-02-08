<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<?xml version="1.0" encoding="utf-8" ?>

<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Student</title>
<link href="<c:url value="/resources/css/studentlist.css" />" 
			rel="stylesheet" type="text/css" />
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

			<a href="${pageContext.request.contextPath}/index.html">На
				главную </a>&nbsp;&nbsp; <a
				href="${pageContext.request.contextPath}/sistem/list.html">Назад</a>
			<h4 align="center">${message}</h4>
			
			<div id="tbl">
				<center>
					<form:form method="POST" commandName="student"
						action="${pageContext.request.contextPath}/sistem/${addedit}.html">
						<table>
							<tbody>
								<tr>
									<td>Фамилия:</td>
									<td><form:input path="surname" /></td>
								</tr>
								<tr>
									<td>Имя:</td>
									<td><form:input path="name" /></td>
								</tr>
								<tr>
									<td>Группа:</td>
									<td><form:input path="group" /></td>
								</tr>
								<tr>
									<td>Дата:</td>
									<td><form:input path="dateIn" /></td>
								</tr>
								<tr>
									<td><input type="submit" value="Применить" /></td>
									<td></td>
								</tr>
							</tbody>
						</table>
						
					</form:form>
					<c:if test="${not empty errormessage}">
						<div class="error">
							<h3>${errormessage}</h3>
						</div>
					</c:if>
				</center>
				
			</div>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>