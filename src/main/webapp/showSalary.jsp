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
        <td>姓名</td>
        <td>基本工资</td>
        <td>绩效</td>
        <td>奖惩总计</td>
        <td>社保</td>
        <td>总工资</td>
        <td>发放时间</td>
    </tr>
    <c:if test="${not empty sessionScope.salary2}">
        <tr>
            <td>${sessionScope.salary2.employee.ename}</td>
            <td>${sessionScope.salary2.basic}</td>
            <td>${sessionScope.salary2.bonus}</td>
            <td>${sessionScope.salary2.punish}</td>
            <td>${sessionScope.salary2.social}</td>
            <td>${sessionScope.salary2.totalSal}</td>
            <td>${sessionScope.salary2.accountTime}</td>
        </tr>
    </c:if>
</table>
<table align="center">
    <tr align="center">
        <td><a href="${pageContext.request.contextPath}/addSalary.jsp">返回</a></td>
    </tr>
</table>
<table align="center">
    <tr align="center">
        <td>${account}</td>
        <td>${resal}</td>
        <td>${sal}</td>
    </tr>
</table>

</body>
</html>
