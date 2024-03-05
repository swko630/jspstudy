<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>   
    
<%
 request.setCharacterEncoding("utf-8");

String creater = request.getParameter("creater");
String title = request.getParameter("title");
String contents = request.getParameter("contents");



String uploadPath = application.getRealPath("upload");

String uploadName = LocalDate.now() + "-" + creater + "-" + title + ".txt";
File uploadDir = new File(uploadPath);
if(!uploadDir.exists()){
  uploadDir.mkdirs();
  %>
<script>
alert("<%=uploadName%> + 파일이 생성되었습니다.")</script>
<%
 
}


session.setAttribute("uploadName", uploadName);

File uploadFile = new File(uploadDir, uploadName);

BufferedWriter writer = new BufferedWriter(new FileWriter(uploadFile));

writer.write(contents + "\n");
writer.flush();
writer.close();



%>

</body>
</html>