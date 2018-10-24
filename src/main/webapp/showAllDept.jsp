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
        <td>部门编号</td>
        <td>部门名称</td>
        <td>创建时间</td>
        <td colspan="3" align="center">操作</td>
    </tr>
    <c:if test="${not empty sessionScope.deptList}">
        <c:forEach items="${sessionScope.deptList}" var="dept">
            <tr>
                <td>${dept.did}</td>
                <td>${dept.dname}</td>
                <td><fmt:formatDate value='${dept.createtime}' pattern='yyyy-MM-dd'/></td>
                <td><a href="/dept/getDeptInfo?dname=${dept.dname}">查看职位</a></td>
                <td><a href="/dept/getDept?did=${dept.did}">修改</a></td>
                <td><a href="/dept/deleteDept?did=${dept.did}">删除</a></td>
            </tr>
        </c:forEach>
    </c:if>
    <tr>
        <td colspan="2" align="center">
            <a href="${request.pageContext.contextPath}/addDept.jsp"><input type="button" value="添加"/></a>
        </td>
        <td colspan="2" align="center">
            <a href="${request.pageContext.contextPath}/adminpage.jsp"><input type="button" value="返回"/></a>
        </td>

    </tr>
    <
    <table align="center" border="2">
        <tr>
            <td  align="center" style="color: red">
                ${deleteDept}
            </td>
        </tr>
    </table>

</table>
</body>
</html>
