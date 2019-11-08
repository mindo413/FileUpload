<%@page import="dto.UploadFile"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<UploadFile> uList = (List) request.getAttribute("list");
%>
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
	<h1>파일 리스트</h1>
	<hr>

	<a href="/commons/fileupload"><button>파일 업로드</button></a>
	<hr>

	<table border="1">
		<tr id="title">
			<td>fileno</td>
			<td>originname</td>
			<td>storedname</td>
		</tr>

		<%
			for (int i = 0; i < uList.size(); i++) {
		%>

		<tr>
			<td><%=uList.get(i).getFileno()%></td>
			<td><a href="/upload/<%=uList.get(i).getStoredname()%>"><%=uList.get(i).getOriginname()%>></a></td>
			<td><%=uList.get(i).getStoredname()%></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>