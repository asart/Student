<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<?xml version="1.0" encoding="utf-8" ?>

<%@ page language="java" contentType="text/html; charset=utf-8"pageEncoding="utf-8"%>

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
					главную</a>&nbsp;&nbsp;<a
					href="${pageContext.request.contextPath}/sistem/list.html">Назад</a>
			</div>

			<div id="tbl">
				<form:form method="get" name="myform">
					<table border="1">
						<caption>Отображена успеваемость для следующего студента</caption>
						<thead>
							<tr>
								<th width="10%">Фамилия</th>
								<th width="10%">Имя</th>
								<th width="10%">Группа</th>
								<th width="10%">Дата поступления</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${student.surname}</td>
								<td>${student.name}</td>
								<td>${student.group}</td>
								<td>${student.dateIn}</td>
							</tr>

						</tbody>
					</table>
				</form:form>
				
				<br></br>
				
				<h3>Средний балл студента ${average}</h3>
				
				<br></br>
				
				<form:form method="get">
					<tr>
						<td><select name="idterm">
								<c:forEach var="term" items="${term}">
									<option value="${term.id}">${term.termName}</option>
								</c:forEach>
						</select></td>
						<td><input type="submit" value="Применить" /></td>
					</tr>
				</form:form>

				<br></br>
				<form:form method="get" name="myform2">
					<table border="1">
						<caption>Список дисциплин</caption>
						<thead>
							<tr>
								<th width="50%">Наименование дисциплины</th>
								<th width="10%">Оценка</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${disciplines}" var="discipline">
								<tr>
									<td>${discipline.subject}</td>
									<c:forEach items="${result}" var="result">
										<c:if test="${discipline.id == result.discipline.id}">
											<td>${result.mark}</td>
										</c:if>
									</c:forEach>
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