<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title><%= "title" %>></title>
</head>
<body>
<c:set var="email" value="dongmyo@nhndooray.com" scope="request" />
<c:out value="Hello, Servlet" /><br />
<c:out value="${email}" /><br />

<fmt:setLocale value="ko" />
<fmt:setBundle basename="message" var="message" />
<%--<%--%>
<%--  for (int i = 2; i <= 9; i++){--%>
<%--%>--%>
<%--<!-- <%= i%>단 시작 -->--%>
<%--<%--%>
<%--    for(int j = 1; j < 10; j++){--%>
<%--%>--%>

<%--<%= i %> * <%= j %> = <%= i*j%><br />--%>
<%--<%--%>
<%--    }--%>
<%--  }--%>
<%--%>--%>

</body>
</html>
