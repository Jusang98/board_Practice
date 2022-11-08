<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>생성순서</th>
        <th>아이디</th>
    </tr>
        <c:forEach var="user" items="${userlist}" varStatus="i">
            <tr align="center">
                <td>${i.count}</td>
                <td>${user.id}</td>
            </tr>
        </c:forEach>
    <br><a href='<c:url value="/index.html"/>'>뒤로가기</a>
</table>
</body>
</html>
