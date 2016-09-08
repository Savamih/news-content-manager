<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>News</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h3>News</h3>
<c:if test="${!empty listArticles}">
    <table class="tg">
        <tr>
            <th width="80">Article ID</th>
            <th width="120">Content</th>
            <th width="120">Article Date</th>
            <th width="120">Article Category</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listArticles}" var="article">
            <tr>
                <td>${article.article_id}</td>
                <td>${article.content}</td>
                <td>${article.publication_date}</td>
                <td>${article.category.name}</td>
                <td><a href="<c:url value='/news/update/${article.article_id}' />" >Edit</a></td>
                <td><a href="<c:url value='/news/remove/${article.article_id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<a href="<c:url value='/news/add' />">Add News</a>
</body>
</html>
