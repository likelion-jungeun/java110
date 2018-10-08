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
<h2>JSTL - c:redirect</h2>
<pre>
- redirect 응답하기.
</pre>

<c:if test="${param.search == 'naver'}">
    <c:redirect url="http://naver.com"/>
</c:if>

<c:if test="${param.search == 'daum'}">
    <c:redirect url="http://daum.net"/>
</c:if>

<p>search라는 이름으로 검색 엔진을 지정하세요!<br>
    유효한 엔진은 'naver'와 'daum'입니다.</p>

</body>
</html>
