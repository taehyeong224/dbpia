<%--
  Created by IntelliJ IDEA.
  User: kth
  Date: 2015. 11. 21.
  Time: 오후 4:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
검색어를 입력하세요
<form action="getJson" name="google">
검색어 : <input type="text" name="search">
<input type="submit">
</form>
<c:forEach var="m" items="${dbpia}">
  ${m}<br/><br/>
</c:forEach>
</body>
</html>
