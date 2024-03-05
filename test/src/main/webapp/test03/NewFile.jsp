<%@page import="java.sql.Date"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
<% LocalDate currentDay = LocalDate.now();%>
<select id=time-unit>
<option value="<%=currentDay%>">현재날짜</option>
<option value="<%=currentDay%>">현재시간</option>
</select>
<button type="button" onclick="click()">요청하기</button>

<script>
function click(){
	alert(<%=currentDay%>);
}
</script>

</div>
</body>
</html>