<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Project form</title>
    <%@include file="head.jsp" %>
    <c:set var="userId" value="${user_id}"/>
</head>
<body>

<div class="flex-container" align="center">

    <%@include file="header.jsp" %>
    <%@include file="navbar.jsp" %>

    <article class="article">
        <h3 align="center">Adding a project</h3>
        <div align="center">
            <form method="post" action="${pageContext.request.contextPath}/startup/create/" >
                <input type="text" name="user.id" value="${user_id}" hidden>
                <table align="center">
                    <tr align="center">
                        <th>Name of the project</th>
                        <td>
                            <input autofocus type="text" name="name" placeholder="your name- companies, enterprise or brands name" required>
                        </td>
                    </tr>
                    <tr align="center">
                        <th>The announcement (brief description)</th>
                        <td>
                            <input type="text" name="description" placeholder="" required>
                        </td>
                    </tr>
                    <tr align="center">
                        <th>Funds</th>
                        <td>
                            <input type="number" name="funds" min="1000" max="1000000000" step="100" placeholder="necessary investments" required>
                        </td>
                    </tr>
                    <tr align="center">
                        <th>Industry</th>
                        <td><select name="industry">
                                <option value="">Industry</option>
                                <c:forEach items="${industries}" var="industry">
                                    <option value="${industry}">${industry.label}</option>
                                </c:forEach>
                        </select></td>
                    </tr>
                    <tr align="center">
                        <th>Country</th>
                        <td><select name="address.country">
                            <option value="">Country</option>
                            <c:forEach items="${countries}" var="country">
                                <option value="${country}">${country.label}</option>
                            </c:forEach>
                        </select></td>
                    </tr>
                    <tr align="center">
                        <th>City</th>
                        <td>
                            <input type="text" name="address.city" placeholder="city">
                        </td>
                    </tr>
                    <tr></tr>
                    <tr align="center">
                        <td>
                            <input type="submit" value="Save">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </article>
    <%@include file="footer.jsp" %>
</div>
</body>
</html>