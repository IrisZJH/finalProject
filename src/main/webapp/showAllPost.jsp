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
        <td>职位编号</td>
        <td>职位名称</td>
        <td>部门名称</td>
        <td colspan="2" align="center">操作</td>
    </tr>
    <c:if test="${not empty sessionScope.postList}">
        <c:forEach items="${sessionScope.postList}" var="post">
            <tr>
                <td>${post.pid}</td>
                <td>${post.pname}</td>
                <td>${post.dept.dname}</td>
                <td><a href="/post/getPost?pid=${post.pid}">修改</a></td>
                <td><a href="/post/deletePost?pid=${post.pid}">删除</a></td>
            </tr>
        </c:forEach>
    </c:if>
    <tr>
        <td  align="center">
            <a href="${request.pageContext.contextPath}/addPost.jsp"><input type="button" value="添加"/></a>
        </td>
        <td  align="center">
            <a href="${request.pageContext.contextPath}/adminpage.jsp"><input type="button" value="返回"/></a>
        </td>
    </tr>
    <table align="center" border="2">
        <tr>
            <td  align="center">
                ${DPF}
            </td>
        </tr>
    </table>
</table>
</body>
</html>
