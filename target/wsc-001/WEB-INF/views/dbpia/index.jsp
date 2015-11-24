<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title></title>
</head>
<body>
<br/>
검색어를 입력하세요
<form action="getDbpia" name="dbpia">
  검색어 : <input type="text" name="search">
  <input type="submit">
</form>
<c:forEach var="m" items="${dbpia}">
${m}<br/><br/>
</c:forEach>

<%--getCtype = ${ctpype}<br/>--%>
<%--getTitle = ${getTitle}<br/>--%>
<%--getName = ${getName}<br/>--%>
<%--getPublicationUrl = ${getPublicationUrl}<br/>--%>
<%--getPublicationName = ${getPublicationName}<br/>--%>
<%--getAuthors : ${getAuthors}<br/>--%>
<%--getFreeYn : ${getFreeYn}<br/>--%>
<%--getIssue : ${getIssue}<br/>--%>
<%--getLinkApi : ${getLinkApi}<br/>--%>
<%--getLinkUrl : ${getLinkUrl}<br/>--%>
<%--getPages : ${getPages}<br/>--%>
<%--getPreview : ${getPreview}<br/>--%>
<%--getPreviewYn : ${getPreviewYn}<br/>--%>
<%--getPublication : ${getPublication}<br/>--%>
<%--getPublisher : ${getPublisher}<br/>--%>
<%--getTitle : ${getTitle}<br/>--%>



</body>
</html>
