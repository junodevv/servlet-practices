<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.bitacademy.guestbook.vo.GuestbookVo" %>
<%@ page import="com.bitacademy.guestbook.dao.GuestbookDao" %>
<%@ page import="java.util.List" %>
<%
	GuestbookDao dao = new GuestbookDao();
	List<GuestbookVo> list = dao.findAll();  
	int i = 0;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>

	<form action="add.jsp" method="post">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" value=" 확인 "></td>
		</tr>
	</table>
	</form>
	
	<br>
	<h3>방명록</h3>
<%
	for(GuestbookVo vo : list){
%>
	<br>
	<table width=510 border=1>
		<tr>
			<td>[<%=++i %>]</td>
			<td><%=vo.getName() %></td>
			<td><%=vo.getRegDate() %></td>
			<td><a href="deleteform.jsp?no=<%=vo.getNo() %>">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4><%=vo.getMessage() %></td>
		</tr>
	</table>
<%
	}
%>
	
</body>
</html>