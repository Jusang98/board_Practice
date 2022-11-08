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
  <c:forEach var="user" items="${userlist}" varStatus="i">
    <tr align="center">
      <td>${i.count}</td>
      <td>${user.id}</td>
      <td>${user.pwd}</td>
      <td>${user.name}</td>
    </tr>
  </c:forEach>
  <br><a href='<c:url value="/index.html"/>'>뒤로가기</a>
</table>
<%--<% session.removeAttribute("user"); %>--%>
</body>
</html>
