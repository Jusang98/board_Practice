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
        <th>비번</th>
        <th>이름</th>
    </tr>
    <form method="post" action="/user/modify.do">
        <c:forEach var="users" items="${userlist}" varStatus="i">
            <tr align="center">
                <td>${i.count}</td>
                <td>${users.id}</td>
                <td>${users.pwd}</td>
                <td>${users.name}</td>
            </tr>
        </c:forEach>
        수정 할 아이디  <input type="text" name="id"><br />
        아디 수정<input type="text" name="newid"><br />
        비번 수정 <input type="text" name="newpwd"><br/>
        이름 수정 <input type="text" name="newname"><br/>
        <input type="submit" value="수정하기">
    </form>

    <br><a href='/index.html'>뒤로가기</a>
</table>
</body>
</html>
