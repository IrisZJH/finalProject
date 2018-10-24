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
        <td>员工</td>
        <td>基本工资</td>
        <td>绩效工资</td>
        <td>奖惩工资</td>
        <td>社保</td>
        <td>总工资</td>
        <td>结算时间</td>
    </tr>
    <c:if test="${not empty sessionScope.salaryList}">
        <c:forEach items="${sessionScope.salaryList}" var="salary">
            <tr>
                <td>${salary.employee.eid}</td>
                <td>${salary.basic}</td>
                <td>${salary.bonus}</td>
                <td>${salary.punish}</td>
                <td>${salary.social}</td>
                <td>${salary.totalSal}</td>
                <td><fmt:formatDate value='${salary.accountTime}' pattern='yyyy-MM-dd'/></td>
            </tr>
        </c:forEach>
    </c:if>
    <tr>
        <td colspan="7" align="center">
            <a href="${pageContext.request.contextPath}/adminpage.jsp"><input type="button" value="返回"/></a>
        </td>
        <td>${Dss}</td>
    </tr>
</table>

</body>
</html>
