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
<form action="/employee/update" method="post">
    <table class="list" align="center">
        <tr>
            <td>员工编号</td>
            <td><input type="text" value="${sessionScope.employee.eid}" name="eid" readonly> </td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" value="${sessionScope.employee.ename}" name="ename" > </td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="text" value="${sessionScope.employee.sex}" name="sex" ></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" value="${sessionScope.employee.age}" name="age" ></td>
        </tr>
        <tr>

        <tr>
            <td>手机号码</td>
            <td><input type="text" value="${sessionScope.employee.tel}" name="tel"></td>
        </tr>

        <tr>
            <td>邮箱</td>
            <td><input type="text" value="${sessionScope.employee.email}" name="email"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="修改">
                <a href="/employee/updateEmpInfo"><input type="button" value="返回"></a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
