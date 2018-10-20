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
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>电话</td>
        <td>Email</td>
        <td>所属部门</td>
        <td>所属职位</td>
        <td colspan="2">操作</td>
    </tr>
    <c:if test="${not empty sessionScope.employeeList}">
        <c:forEach items="${sessionScope.employeeList}" var="employee">
            <tr>
                <td>${employee.ename}</td>
                <td>${employee.sex}</td>
                <td>${employee.age}</td>
                <td>${employee.tel}</td>
                <td>${employee.email}</td>
                <td>${employee.dept.dname}</td>
                <td>${employee.post.pname}</td>
                <td><a href="/employee/updateEmployee?eid=${employee.eid}">人员调动</a></td>
                <td><a href="deleteEmployee.action?eid=${employee.eid}">开除员工</a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<table align="center">
    <tr align="center">
        <td><a href="${pageContext.request.contextPath}/adminpage.jsp"><input type="button" value="返回"></a></td>
    </tr>
    <tr>
        <td>${updatS}</td>
    </tr>
</table>

</body>
</html>
