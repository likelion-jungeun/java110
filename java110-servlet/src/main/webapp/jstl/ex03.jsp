<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<h1>JSTL - c:set</h1>
<pre>
- 보관소에 값을 저장한다.
  &lt;c:set
    var="변수명"
    scope="page(기본임)|request|session|application"
    value="보관소에 저장할 값"/>
  &lt;c:out value="출력될 값">기본값&lt;c:out>
</pre>
<c:set scope="request" var="name1" value="홍길동"/>
requestScope : ${requestScope.name1}<br>
pageScope : ${pageScope.name1}<br>
-------------------------<br>
<c:set var="name2" value="임꺽정"/>
requestScope : ${requestScope.name2}<br>
pageScope : ${pageScope.name2}<br>
-------------------------<br>
<c:set var="name3">유관순</c:set>
requestScope : ${requestScope.name3}<br>
pageScope : ${pageScope.name3}<br>

<h2>객체의 프로퍼티 값 설정하기</h2>
<jsp:useBean id="m1" class="bitcamp.java110.Member"/>
<jsp:setProperty name="m1" property="no" value="100"/>
<c:set target="${pageScope.m1}" property="email" value="hong@test.com"/>

${pageScope.m1.no}<br>
${pageScope.m1.email}<br>
</body>
</html>
