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
    <script src="${pageContext.request.contextPath}/js/jquery.ui.core.js"></script>

    <script src="${pageContext.request.contextPath}/js/jquery.ui.widget.js"></script>

    <script src="${pageContext.request.contextPath}/js/jquery.ui.datepicker.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.ui.datepicker-zh-CN.js"></script>
    <script>
        $(function() {
            $("#datepicker").datepicker();
        });
        $(function() {
            $("#datepicker1").datepicker();
        });
    </script>
</head>
<body style="background-image:url(${request.pageContext.contextPath}/img/p2.jpg); background-size:100%,100%">

<form action="/train/addTrain" method="post">
    <table align="center" border="1">
        <tr>
            <td>培训名称</td>
            <td><input type="text" name="tname"></td>
        </tr>
        <tr>
            <td>培训起始时间</td>
            <td><input type="text" name="begintime" id="datepicker"></td>
        </tr>
        <tr>
            <td>培训结束时间</td>
            <td><input type="text" name="endtime" id="datepicker1"></td>
        </tr>
        <tr>
            <td>参加员工</td>
            <td>
                <c:forEach items="${sessionScope.employeeList}" var="employee">
                    <input type="checkbox" name="eid" value="${employee.eid}"/>${employee.ename}
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td>培训内容</td>
            <td><input type="text" name="content"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="添加"/>
                <a href="${pageContext.request.contextPath}/adminpage.jsp"><input type="button" value="返回"></a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
