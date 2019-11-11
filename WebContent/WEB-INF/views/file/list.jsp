<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
table {
	border-collapse: collapse;
	border: 1px solid #ccc;
	text-align: center;
}

td {
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	padding: 5px 10px;
}

th {
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	padding: 5px 10px;
}

td:hover {
	background: #ccf;
}

#title {
	background: #FF7F50;
}

tr:nth-child(2n) {
	background-color: ivory;
}

tr:nth-child(2n+1) {
	background-color: #FAEBD7;
}
</style>

</head>
<body>

	<h1>업로드 파일 목록</h1>
	<hr>

	<table border="1">
		<tr id="title">
			<th>파일 번호</th>
			<th>원본 이름</th>
			<th>저장된 이름</th>
		</tr>
		<c:forEach items="${list }" var="i">
			<tr>
				<td>${i.fileno }</td>
				<td><a href="/file/download?fileno=${i.fileno}">${i.originname }</a></td>
				<td>${i.storedname }</td>
			</tr>
		</c:forEach>
	</table>























	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>
