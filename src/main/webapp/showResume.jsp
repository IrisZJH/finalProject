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
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>籍贯</td>
        <td>工作经验</td>
        <td>所学专业</td>
        <td>毕业学校</td>
        <td>学历</td>
        <td>电话</td>
        <td>Email</td>
        <td>详细经历</td>
        <td>面试职位</td>
    </tr>
    <c:if test="${not empty sessionScope.resumes}">
        <c:forEach items="${sessionScope.resumes}" var="resume">

            <tr>
                <td>${resume.name}</td>
                <td>${resume.sex}</td>
                <td>${resume.age}</td>
                <td>${resume.job}</td>
                <td>${resume.experience}</td>
                <td>${resume.specialty}</td>
                <td>${resume.school}</td>
                <td>${resume.studyeffort}</td>
                <td>${resume.tel}</td>
                <td>${resume.email}</td>
                <td>${resume.content}</td>
                <td>${resume.post.pname}</td>
                <td></td>
                <td><a href="/user/informinterview?rid=${resume.rid}">通知面试</a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
