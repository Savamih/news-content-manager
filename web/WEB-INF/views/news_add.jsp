<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addNews</title>
</head>
<body>
<h1>
    Add News
</h1>
<c:url var="postArticle" value="/news/add_update"></c:url>

<form:form action="${postArticle}" commandName="article">

    <table>
        <tr>
            <td>
                <form:hidden path="article_id" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="content">
                    <spring:message text="Content"/>
                </form:label>
            </td>
            <td>
                <form:input path="content" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="publication_date">
                    <spring:message text="Publication_date"/>
                </form:label>
            </td>
            <td>
                <form:input path="publication_date" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="category.name">
                    <spring:message text="Category"/>
                </form:label>
            </td>
            <td>
                <form:input path="category.name" />
            </td>
        </tr>
        <tr>
        <td colspan="2">
            <c:if test="${!empty article.content}">
                <input type="submit"
                       value="<spring:message text="Edit News"/>" />
            </c:if>
            <c:if test="${empty article.content}">
                <input type="submit"
                       value="<spring:message text="Add News"/>" />
            </c:if>
        </td>
    </tr>
    </table>
</form:form>
</body>
</html>
