<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>DBPIA 와 GOOGLE API를 활용한 RESTfull 제공 사이트</title>
</head>
<body>
DBPIA 와 GOOGLE API를 활용한 RESTfull 제공 사이트입니다.<br/>
<c:set var="user" value="${SPRING_SECURITY_CONTEXT.authentication.principal}"/>


<sec:authorize access="isAnonymous()">
<a href="/user/signin">로그인</a>
<a href="/user/signup">회원가입</a>
</sec:authorize>
<br/><br/>
<sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
    안녕하세요 ${user.name}님  <br/>
    <br/>
    <br/>

    <c:url var="logoutUrl" value="/j_spring_security_logout"/>
    <input type="button" value="total" onclick="location.href='/total/'"/><br/>
    <form action="${logoutUrl}" method="post">
        <input type="submit" value="로그 아웃" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <br/><br/>
</sec:authorize>
</body>
</html>
