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
        <td>员工编号</td>
        <td>员工姓名</td>
    </tr>
    <c:if test="${not empty sessionScope.empList}">
        <c:forEach items="${sessionScope.empList}" var="employee">
            <tr>
                <td>${employee.eid}</td>
                <td>${employee.ename}</td>
            </tr>
        </c:forEach>
    </c:if>

    <tr>
        <td colspan="2" align="center"><a href="${pageContext.request.contextPath}/showDeptPost.jsp">返回</a></td>
    </tr>
</table>
</body>
</html>
