<%--
  Created by IntelliJ IDEA.
  User: 18221
  Date: 2018/10/18
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>

</head>
<%--<body class="ContentBody">--%>
<body style="background-image:url(${request.pageContext.contextPath}/img/p2.jpg); background-size:100%,100%">

<form action="/employee/addEmployee" method="post">
    <table class="list" align="center">
        <tr>
            <td>部门</td>
            <td>
                <input value="${sessionScope.dept.dname}" name="dname" readonly>
            </td>
        </tr>
        <tr>
            <td>职位</td>
            <td>
                <input value="${sessionScope.post.pname}"  readonly>
            </td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" value="${sessionScope.resume.name}" name="ename" readonly> </td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="text" value="${sessionScope.resume.sex}" name="sex" readonly></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" value="${sessionScope.resume.age}" name="age" readonly></td>
        </tr>
        <tr>
        <tr>
            <td>籍贯</td>
            <td><input type="text" value="${sessionScope.resume.job}" readonly></td>
        </tr>
        <td>学历</td>
        <td><input  value="${sessionScope.resume.studyeffort}" readonly ></td>
        </tr>
        <tr>
            <td>专业</td>
            <td><input type="text" value="${sessionScope.resume.specialty}" readonly></td>
        </tr>
        <tr>
            <td>工作经验</td>
            <td><input type="text" value="${sessionScope.resume.experience}" readonly></td>
        </tr>
        <tr>
            <td>手机号码</td>
            <td><input type="text" value="${sessionScope.resume.tel}" name="tel"readonly></td>
        </tr>

        <tr>
            <td>邮箱</td>
            <td><input type="text" value="${sessionScope.resume.email}" name="email" readonly></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="录用">
                <a href="/recruit/showJoinInterview"><input type="button" value="返回"></a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
