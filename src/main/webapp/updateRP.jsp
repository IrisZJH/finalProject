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
    <script src="${pageContext.request.contextPath}/js/jquery.ui.core.js"></script>

    <script src="${pageContext.request.contextPath}/js/jquery.ui.widget.js"></script>

    <script src="${pageContext.request.contextPath}/js/jquery.ui.datepicker.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.ui.datepicker-zh-CN.js"></script>
    <script>
        $(function() {
            $("#datepicker").datepicker();
        });
    </script>

</head>
<body style="background-image:url(${request.pageContext.contextPath}/img/p2.jpg); background-size:100%,100%">
<form action="/rewardAndPunish/updateRwandph?eid=${sessionScope.rwandph.employee.eid}" method="post">
    <table align="center">
        <tr>
            <td>奖惩编号</td>
            <td><input type="text" value="${sessionScope.rwandph.rpid}" name="rpid" READONLY> </td>
        </tr>
        <tr>
            <td>奖惩人员</td>
            <td><input type="text" value="${sessionScope.rwandph.employee.ename}" name="ename" readonly></td>
        </tr>
        <tr>
            <td>奖惩金额</td>
            <td><input type="text" value="${sessionScope.rwandph.money}" name="money"></td>
        </tr>
        <tr>
            <td>奖惩缘由</td>
            <td><input type="text" value="${sessionScope.rwandph.cause}" name="cause"></td>
        </tr>
        <tr>
            <td>奖惩时间</td>
            <td><input type="text" value="<fmt:formatDate value='${sessionScope.rwandph.rptime}' pattern='yyyy-MM-dd'/>" name="rptime" id="datepicker"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="修改"/></td>
        </tr>
    </table>
</form>
</body>
</html>
