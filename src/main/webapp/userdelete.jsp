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
    <form method="post" action="/user/delete.do">
        <c:forEach var="users" items="${userlist}" varStatus="i">
            <tr align="center">
                <td>${i.count}</td>
                <td>${users.id}</td>
            </tr>
        </c:forEach>
        삭제 할 아이디  <input type="text" name="id"><br />
        <input type="submit" value="유저삭제">
    </form>

    <br><a href='/index.html'>뒤로가기</a>
</table>
</body>
</html>
