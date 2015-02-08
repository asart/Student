<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<?xml version="1.0" encoding="utf-8" ?>

<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value="/resources/css/studentlist.css" />"
	rel="stylesheet" type="text/css" />
<script>
	function goToEdit() {
		var valuee = "";
		for (var i = 0; i < document.myform.iddiscipline.length; i++) {
			if (document.myform.iddiscipline[i].checked) {
				valuee = encodeURIComponent(document.myform.iddiscipline[i].value);
			}
			location.href = '${pageContext.request.contextPath}/disciplines/edit/'
					+ valuee + '.html';
		}
	}

	function goToDelete() {
		var valuee = "";
		for (var i = 0; i < document.myform.iddiscipline.length; i++) {
			if (document.myform.iddiscipline[i].checked) {
				valuee = encodeURIComponent(document.myform.iddiscipline[i].value);
			}
			location.href = '${pageContext.request.contextPath}/disciplines/delete/'
					+ valuee + '.html';
		}
	}
</script>
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
					<a href="${pageContext.request.contextPath}/disciplines/add.html"><button
							class="btn">Создать дисциплину</button></a>
					<button class="btn" onclick="goToEdit();">Модифицировать
						выбранную дисциплину</button>
					<button class="btn" onclick="goToDelete();">Удалить
						выбранную дисциплину</button>
				</sec:authorize>
			</div>
			
			<div id="tbl">
				<form:form method="get" name="myform">
					<table border="1">
						<caption>Список дисциплин</caption>
						<thead>
							<tr>
								<sec:authorize access="hasRole('ROLE_ADMIN')">
									<th width="2%"></th>
								</sec:authorize>
								<th width="50%">Наименование дисциплины</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${disciplines}" var="discipline">
								<tr>
									<sec:authorize access="hasRole('ROLE_ADMIN')">
										<td><input type="checkbox" id="iddiscipline"
											value="${discipline.id}" /></td>
									</sec:authorize>
									<td>${discipline.subject}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form:form>
			</div>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>