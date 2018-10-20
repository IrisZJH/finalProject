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
<body style="background-image:url(${request.pageContext.contextPath}/img/p2.jpg); background-size:100%,100%">
<form action="/dept/updateDept">
    <table align="center" border="2">
        <tr>
            <td>部门编号</td>
            <td><input type="text" value="${sessionScope.dept.did}"name="did" READONLY> </td>
        </tr>
        <tr>
            <td>部门名称</td>
            <td><input type="text" value="${sessionScope.dept.dname}" name="dname"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="修改"/></td>
        </tr>
    </table>
</form>
</body>
</html>
