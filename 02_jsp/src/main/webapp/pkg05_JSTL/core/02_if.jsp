<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
  <c:if>
  1. else 개념이 없는 if 문 태그이다.
  2. 형식 
     <c:if test="조건식">
       실행문
       </c:if>
 --%>
 
 <c:set var="age" value="<%=(int)(Math.random()*100+1) %>" scope="page"/>
 <c:if test="${age >= 20}">
 <div>${age}살은 성인입니다.</div>
 </c:if>
 <c:if test="${age < 20}">
 <div>${age}살은 미성년자입니다.</div>
 </c:if>

<hr>

<c:set var="score" value="<%=(int)(Math.random()*100+1)%>"/>
<c:if test="${score >= 90}">
<c:set var="grade" value="A"></c:set>
</c:if>
<c:if test="${score >= 80 and score < 90}">
<c:set var="grade" value="B"></c:set>
</c:if>
<c:if test="${score >= 70 and score < 80}">
<c:set var="grade" value="C"></c:set>
</c:if>
<c:if test="${score >= 60 and score < 70}">
<c:set var="grade" value="D"></c:set>
</c:if>
<c:if test="${score < 60}">
<c:set var="grade" value="E"></c:set>
</c:if>
<div>점수는 ${score}이고, 성적은 ${grade}입니다.</div>


</body>
</html>