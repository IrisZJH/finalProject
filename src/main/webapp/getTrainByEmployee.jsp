<%--
  Created by IntelliJ IDEA.
  User: 18221
  Date: 2018/10/18
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>

</head>
<%--<body class="ContentBody">--%>
<body style="background-image:url(${request.pageContext.contextPath}/img/p2.jpg); background-size:100%,100%">

<table align="center" border="2">
    <tr>
        <td>培训名称</td>
        <td>开始时间</td>
        <td>结束时间</td>
        <td>参加状态</td>
        <td>内容</td>
        <td colspan="2" align="center">操作</td>
    </tr>
    <c:if test="${not empty sessionScope.train }">
        <tr>
            <td>${sessionScope.train.tname}</td>
            <td>${sessionScope.train.begintime}</td>
            <td>${sessionScope.train.endtime}</td>
            <td>
                <c:if test="${sessionScope.train.state==1}">
                    已参加
                </c:if>
                <c:if test="${sessionScope.train.state==0}">
                    没参加
                </c:if>
            </td>
            <td>${sessionScope.train.content}</td>
            <td>${trainList.content}</td>
            <td><a href="/train/updateT?tid=${sessionScope.train.tid}">参加</a></td>
            <td><a href="${pageContext.request.contextPath}/employeepage.jsp">返回</a></td>
        </tr>
    </c:if>

</table>
</body>
</html>
