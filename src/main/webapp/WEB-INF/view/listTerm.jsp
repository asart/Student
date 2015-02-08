<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<?xml version="1.0" encoding="utf-8" ?>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value="/resources/css/studentlist.css" />"
		rel="stylesheet" type="text/css" />
<title>List of teams</title>
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
			
			<div id="">
				<a href="${pageContext.request.contextPath}/index.html">На
					главную</a>
			</div>
			
			<div id="btn">
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<button class="btn">Создать семестр</button>
					<button class="btn">Модифицировать семестр</button>
					<button class="btn">Удалить семестр</button>
				</sec:authorize>
			</div>
			
			<div id="tbl">
				<form:form method="get">
					<input type="submit" value="Применить" />
					<tr>
						<td>Семестры:</td>
						<td><select name="id">
								<c:forEach items="${term}" var="terms">
									<option value="${terms.id}">${terms.termName}</option>
								</c:forEach>
						</select></td>
					</tr>
				</form:form>

				<form:form method="get" name="myform2">
					<table border="1">
						<caption>Список дисциплин</caption>
						<thead>
							<tr>
								<th width="50%">Наименование дисциплины</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${disciplines}" var="discipline">
								<tr>
									<td>${discipline.subject}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form:form>
			</div>

		</div>

	</div>
	<div id="footer"></div>
</body>
</html>