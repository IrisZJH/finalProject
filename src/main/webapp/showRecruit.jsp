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
        <td>公司名称</td>
        <td>申请部门</td>
        <td>申请岗位</td>
        <td>工作地点</td>
        <td>描述</td>
        <td>发布时间</td>
    </tr>
    <c:if test="${not empty sessionScope.recruitList}">
        <c:forEach items="${sessionScope.recruitList}" var="recruit">
            <tr>
                <td>${recruit.name}</td>
                <td>${recruit.dept.dname}</td>
                <td>${recruit.post.pname}</td>
                <td>${recruit.address}</td>
                <td>${recruit.description}</td>
                <td><fmt:formatDate value='${recruit.grantTime}' pattern='yyyy-MM-dd'/></td>
                <td><a href="/resume/seedResume?reid=${recruit.reid}">投递简历</a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>

</body>
</html>
