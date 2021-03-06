<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Startup info page</title>
    <%@include file="head.jsp" %>
    <c:set var="userId" value="${project.user.id}"/>
</head>

<body>
<div class="flex-container">
    <%--<c:set var="isOwner" value="${project.user.id == user_id}"/>--%>

    <%@include file="header.jsp" %>
    <%@include file="navbar.jsp" %>

    <aside>
    </aside>
    <%--<nav class="nav">--%>
        <%--<ul>--%>
            <%--<c:if test="${isOwner || isAdmin}">--%>
                    <%--<li><a href="${pageContext.request.contextPath}/startup/create">Add project</a></li>--%>
                    <%--<br>--%>
                    <%--<li><a href="${pageContext.request.contextPath}/interest/create">Add interest</a></li>--%>
                    <%--<br>--%>
                    <%--<li><a href="${pageContext.request.contextPath}/user/personalAccount/${project.user.id}/edit">Edit--%>
                        <%--profile</a></li>--%>
                    <%--<br>--%>
                    <%--<li><a href="${pageContext.request.contextPath}/logout">Logout</a><br></li>--%>
                    <%--<br>--%>
                    <%--<li><a href="${pageContext.request.contextPath}/user/personalAccount/${project.user.id}/delete">Delete--%>
                        <%--profile</a></li>--%>
                    <%--<br>--%>
                <%--</c:if>--%>
            <%--<c:if test="${!(isOwner || isAdmin)}">--%>
                <%--<li><a href="${pageContext.request.contextPath}/main">Home</a></li>--%>
                <%--<br>--%>
                <%--<li><a href="${pageContext.request.contextPath}/logout">Logout</a><br></li>--%>
                <%--<br>--%>
            <%--</c:if>--%>
        <%--</ul>--%>
    <%--</nav>--%>

    <article class="article">
        <%@include file="full-project-info.jsp" %>
    </article>

    <%@include file="footer.jsp" %>
</div>
</body>
</html>