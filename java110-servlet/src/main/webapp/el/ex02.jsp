<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
<h1>EL - 보관소에서 값 꺼내기</h1>
<%
pageContext.setAttribute("name","홍길동");
request.setAttribute("name","임꺽정");
session.setAttribute("name","유관순");
application.setAttribute("name","안중근");
%>

PageContext 보관소 : ${pageScope.name}<br>
ServletRequest 보관소 : ${requestScope.name}<br>
HttpSession 보관소 : ${sessionScope.name}<br>
ServletContext 보관소 : ${applicationScope.name}<br>
</body>
</html>












