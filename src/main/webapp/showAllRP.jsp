<%--
  Created by IntelliJ IDEA.
  User: 18221
  Date: 2018/10/18
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>

</head>
<%--<body class="ContentBody">--%>
<body style="background-image:url(${request.pageContext.contextPath}/img/p2.jpg); background-size:100%,100%">

<table align="center" border="2">
    <tr>
        <td>奖惩人员</td>
        <td>奖惩金额</td>
        <td>奖惩缘由</td>
        <td>奖惩时间</td>
        <td colspan="2" align="center">操作</td>
    </tr>
    <c:if test="${not empty sessionScope.rwandphList}">
        <c:forEach items="${sessionScope.rwandphList}" var="rwandphList">
            <tr>
                <td>${rwandphList.employee.ename}</td>
                <td>${rwandphList.money}</td>
                <td>${rwandphList.cause}</td>
                <td><fmt:formatDate value='${rwandphList.rptime}' pattern='yyyy-MM-dd'/></td>
                <td><a href="/rewardAndPunish/getRwandph?rpid=${rwandphList.rpid}">修改</a></td>
                <td><a href="/rewardAndPunish/deleteRwandph?rpid=${rwandphList.rpid}">删除</a></td>
            </tr>
        </c:forEach>
    </c:if>
    <tr>
        <td colspan="7" align="center">
            <a href="${pageContext.request.contextPath}/adminpage.jsp"><input type="button" value="返回"/></a>
        </td>
    </tr>
</table>
</body>
</html>
