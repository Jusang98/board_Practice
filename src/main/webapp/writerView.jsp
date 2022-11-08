<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>아이디</th>
        <th>이름</th>
    </tr>
        <tr align="center">
            <td>${user.id}</td>
            <td>${user.name}</td>
        </tr>
    <br><a href='<c:url value="/postindex.jsp"/>'>뒤로가기</a>
</table>
<%--<% session.removeAttribute("user"); %>--%>
</body>
</html>
