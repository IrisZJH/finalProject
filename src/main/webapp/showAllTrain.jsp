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
        <td>培训名称</td>
        <td>开始时间</td>
        <td>结束时间</td>
        <td>参与人员</td>
        <td>内容</td>
    </tr>
    <c:if test="${not empty sessionScope.trainList}">
        <c:forEach items="${sessionScope.trainList}" var="trainList">

            <tr>
                <td>${trainList.tname}</td>
                <td><fmt:formatDate value='${trainList.begintime}' pattern='yyyy-MM-dd'/></td>
                <td><fmt:formatDate value='${trainList.endtime}' pattern='yyyy-MM-dd'/></td>
                <td>
                    <c:forEach items="${trainList.employeeSet}" var="emp">
                        ${emp.ename}
                    </c:forEach>
                </td>
                <td>${trainList.content}</td>
                <td><a href="${pageContext.request.contextPath}/adminpage.jsp"><input type="button" value="返回"></a></td>
            </tr>
        </c:forEach>
    </c:if>
</table></body>
</html>
