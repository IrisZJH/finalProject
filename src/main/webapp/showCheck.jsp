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
        <td>上班时间</td>
        <td>下班时间</td>
        <td>是否迟到</td>
        <td>是否早退</td>
    </tr>
    <c:if test="${not empty sessionScope.checkon2}">
        <tr>
            <td><fmt:formatDate value='${sessionScope.checkon2.starttime}' pattern='yyyy-MM-dd'/></td>
            <td><fmt:formatDate value='${sessionScope.checkon2.endtime}' pattern='yyyy-MM-dd'/></td>
            <td>${sessionScope.checkon2.gowork_state}</td>
            <td>${sessionScope.checkon2.upwork_state}</td>
            <td><a href="${pageContext.request.contextPath}/employeepage.jsp">返回</a></td>
        </tr>
    </c:if>


    <tr>
        ${success}
        ${defeated}

    </tr>
</table>

</body>
</html>