<%@ page import="java.util.List" %>
<%@ page import="com.nhnacademy.domain.Post" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Post> postlist = (List) request.getAttribute("postlist"); %>
<script>
    function submit2(frm){
        frm.action='/delete.do'
        frm.submit();
        return true;
    }
    function submit3(frm){
        frm.action='Content.do'
        frm.submit;
        return true;
    }
</script>
<html>
<head>
    <title>게시물 목록 조회</title>
</head>
<body>
<table border="1">
    <tr>
        <th>작성순서</th>
        <th>제목</th>
        <th>작성자</th>
        <th>내용</th>
        <th>작성시간</th>
        <th>조회수</th>
    </tr>
    <form method="post" action="<c:url value="/post/writerView.do"/>">
    <c:forEach var="post" items="${postlist}" varStatus="i">
        <tr align="center">
            <td>${i.count}</td>
            <td>${post.title}</td>
            <td>${post.id}</td>
            <td>${post.content}</td>
            <td>${post.writerTime}</td>
            <td>${post.viewCount}</td>
            <td><input type="button" onclick="location.href='postmodify.jsp'" value="수정"></td>
            <td><button type="submit" onclick='return submit2(this.form);'name="id"
                        value="${post.id}">삭제</button></td>
        </tr>
    </c:forEach>
    조회 할 아이디 <input type="text" name="id"><br />
    <input type="submit" value="사용자조회">
    <br><a href='<c:url value="/postindex.jsp"/>'>뒤로가기</a>
        </form>
</table>
</body>
</html>
<%--    <% for(int i =0;i<postlist.size();i++){ %>--%>
<%--    <tr>--%>
<%--        <td><%=postlist.get(i).getTitle()%> </td>--%>
<%--        <td><a href="/post/view?postwriter=<%=postlist.get(i).getWriterId()%>"><%=postlist.get(i).getWriterId()%></a></td>--%>
<%--        <td><%=postlist.get(i).getWriterTime()%></td>--%>
<%--        <td><%=postlist.get(i).getViewCount()%></td>--%>
<%--    </tr>--%>
<%--    <% } %>--%>