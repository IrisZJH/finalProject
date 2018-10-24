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
    </script>

</head>
<%--<body class="ContentBody">--%>
<body style="background-image:url(${request.pageContext.contextPath}/img/p2.jpg); background-size:100%,100%">
<form action="/rewardAndPunish/addRwandph" method="post">
    <table align="center" border="1">
        <tr>
            <td>奖惩员工</td>
            <td>
                <select name="eid" id="ename">
                    <c:if test="${not empty sessionScope.employeeList}">
                        <c:forEach items="${sessionScope.employeeList}" var="employee">
                            <option value="${employee.eid}">${employee.ename}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </td>
        </tr>
        <tr>
            <td>奖金金额</td>
            <td><input type="text" name="money"></td>
        </tr>
        <tr>
            <td>奖惩时间</td>
            <td><input name="rptime" id="datepicker" required/></td>
        </tr>
        <tr>
            <td>奖惩缘由</td>
            <td><input type="text" name="cause"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="添加"></td>
            <td><a href="${pageContext.request.contextPath}/adminpage.jsp" ><input type="button" value="返回"></a></td>
        </tr>
    </table>
</form>
</body>
</html>
