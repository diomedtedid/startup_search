<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Update Interest form</title>
    <%@include file="head.jsp" %>
    <c:set var="userId" value="${command.user.id}"/>
</head>
<body>
<div class="flex-container" align="center">

    <%@include file="header.jsp" %>
    <%@include file="navbar.jsp" %>

    <article class="article">
        <h3 align="center">Edit an interest</h3>
        <c:if test="${isOwner || isAdmin}">
        <div align="center">
            <form:form method="post" action="${pageContext.request.contextPath}/interest/${command.id}/update/">
                <form:input path="user.id" type="number" name="user.id" value="${command.user.id}" hidden="true"/>
                <table align="center">
                    <tr align="center">
                        <th>Name of the interest</th>
                        <td>
                            <form:input path="name" type="text" name="name" required="required" value="${command.name}" />
                        </td>
                    </tr>
                    <tr align="center">
                        <th>The announcement (brief description)</th>
                        <td>
                            <form:input path="description" type="text" name="description"  required="required" value="${command.description}" />
                        </td>
                    </tr>
                    <tr align="center">
                        <th>Budget</th>
                        <td>
                            <form:input path="budget" type="number" name="budget" min="1000" max="1000000000" step="100"
                                        value="${command.budget}" required="required"/>
                        </td>
                    </tr>
                    <tr align="center">
                        <th>Industry</th>
                        <td><form:select path="industry" name="industry">
                            <form:option value="">Industry</form:option>
                            <c:forEach items="${industries}" var="industry">
                                <form:option value="${industry}">${industry.label}</form:option>
                            </c:forEach>
                        </form:select></td>
                    </tr>
                    <tr align="center">
                        <th>Country</th>
                        <td><form:select path="country" name="country">
                            <form:option value="">Country</form:option>
                            <c:forEach items="${countries}" var="country">
                                <form:option value="${country}">${country.label}</form:option>
                            </c:forEach>
                        </form:select></td>
                    </tr>
                    <tr></tr>
                    <tr align="center">
                        <td>
                            <input type="submit" value="Save">
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
        </c:if>
    </article>
    <%@include file="footer.jsp" %>
</div>
</body>
</html>