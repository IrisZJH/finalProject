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
<table align="center" border="2">
    <tr>
        <td>员工编号</td>
        <td>姓名</td>
        <td>部门</td>
        <td>职位</td>
        <td>员工基本工资</td>
        <td>员工绩效工资</td>
        <td>员工结算工资月份</td>
        <td >操作</td>
    </tr>
    <c:if test="${not empty sessionScope.employeeList}">
        <c:forEach items="${sessionScope.employeeList}" var="employeeList">
            <form action="/salary/addSalary" method="post">
                <tr>

                    <td><input type="text" value="${employeeList.eid}"  name="eid" readonly></td>
                    <td>${employeeList.ename}</td>
                    <td>${employeeList.dept.dname}</td>
                    <td>${employeeList.post.pname}</td>
                    <td><input type="text" name="basic"> </td>
                    <td><input type="text" name="bonus"> </td>
                    <td><input type="text" name="month" id="datepicker"> </td>
                    <td><input type="submit" name="submit" value="发放工资"> </td>
                </tr>
            </form>
        </c:forEach>
    </c:if>
</table>
<table align="center">
    <tr align="center">
        <td><a href="${pageContext.request.contextPath}/adminpage.jsp"><input type="button" value="返回"></a></td>
    </tr>
</table>
</body>
</html>
