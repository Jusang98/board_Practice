<%--
  Created by IntelliJ IDEA.
  User: rlatk
  Date: 2022-10-30
  Time: 오후 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>index</title>
</head>
<body>
<form method="post" action="/user/login.do">
    아이디<input type="text" name="id"><br/>
    비밀번호 <input type="text" name="pwd"><br/>
    <input type="submit" value="Login">
</form>
</body>
</html>
