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
- 보관소에 저장된 값을 제거한다.
</pre>

<%
pageContext.setAttribute("name","홍길동");
request.setAttribute("name","임꺽정");
session.setAttribute("name","유관순");
application.setAttribute("name","김구");

%>

<c:set scope="request" var="name1" value="홍길동"/>
pageScope : ${pageScope.name}<br>
requestScope : ${requestScope.name}<br>
sessionScope : ${sessionScope.name}<br>
applicationScope : ${applicationScope.name}<br>
--------page보관소에 있는거 지우기--------<br>
<c:remove var="name" scope="page"/>
pageScope : ${pageScope.name}<br>
requestScope : ${requestScope.name}<br>
sessionScope : ${sessionScope.name}<br>
applicationScope : ${applicationScope.name}<br>

--------request보관소에 있는거 지우기--------<br>
<c:remove var="name" scope="request"/>
pageScope : ${pageScope.name}<br>
requestScope : ${requestScope.name}<br>
sessionScope : ${sessionScope.name}<br>
applicationScope : ${applicationScope.name}<br>

--------session보관소에 있는거 지우기--------<br>
<c:remove var="name" scope="session"/>
pageScope : ${pageScope.name}<br>
requestScope : ${requestScope.name}<br>
sessionScope : ${sessionScope.name}<br>
applicationScope : ${applicationScope.name}<br>

--------application보관소에 있는거 지우기--------<br>
<c:remove var="name" scope="application"/>
pageScope : ${pageScope.name}<br>
requestScope : ${requestScope.name}<br>
sessionScope : ${sessionScope.name}<br>
applicationScope : ${applicationScope.name}<br>

</body>
</html>












